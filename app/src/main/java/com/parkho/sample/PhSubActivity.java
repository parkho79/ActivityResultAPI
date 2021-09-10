package com.parkho.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.parkho.sample.PhMainActivity.Constant;

public class PhSubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        final String strSendText = getIntent().getStringExtra(Constant.SEND_TEXT);

        OnClickListener clickListener = new OnClickListener() {
            @Override
            public void onClick(View view) {
                final String strInput =  ((EditText) findViewById(R.id.et_input)).getText().toString();
                final String strResult = strSendText + strInput;

                Intent intent = new Intent();
                intent.putExtra(Constant.RESULT_INPUT, strResult);
                setResult(RESULT_OK, intent);
                finish();
            }
        };
        findViewById(R.id.btn_send).setOnClickListener(clickListener);
    }
}