package com.parkho.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class PhMainActivity extends AppCompatActivity {

    public interface Constant {
        String SEND_TEXT = "send_text";
        String RESULT_INPUT = "result_input";
    }

    // Pre contract
    private ActivityResultLauncher<Intent> mPreContractStartActivityResult =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult a_result) {
                            if (a_result.getResultCode() == Activity.RESULT_OK) {
                                final String strInput = a_result.getData().getStringExtra(Constant.RESULT_INPUT);
                                ((TextView) findViewById(R.id.tv_input)).setText(strInput);
                            }

                        }
                    });

    // Custom contract
    private ActivityResultLauncher<String> mCustomContractStartActivityResult =
            registerForActivityResult(
                    new PhMainContract(),
                    new ActivityResultCallback<String>() {
                        @Override
                        public void onActivityResult(String a_strResult) {
                            ((TextView) findViewById(R.id.tv_input)).setText(a_strResult);
                        }
                    }
            );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sub activity 실행
        OnClickListener explicitClickListener = new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), PhSubActivity.class);
                mPreContractStartActivityResult.launch(intent);

                // mCustomContractStartActivityResult.launch("parkho");
            }
        };
        findViewById(R.id.btn_start).setOnClickListener(explicitClickListener);
    }
}