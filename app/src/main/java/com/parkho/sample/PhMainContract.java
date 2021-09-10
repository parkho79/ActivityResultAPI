package com.parkho.sample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.activity.result.contract.ActivityResultContract;

import com.parkho.sample.PhMainActivity.Constant;

public class PhMainContract extends ActivityResultContract<String, String> {

    @Override
    public Intent createIntent(Context a_context, String a_strSendText) {
        Intent intent = new Intent(a_context, PhSubActivity.class);
        intent.putExtra(Constant.SEND_TEXT, a_strSendText);
        return intent;
    }

    @Override
    public String parseResult(int a_resultCode, Intent a_intent) {
        if (a_resultCode == Activity.RESULT_OK) {
            if (a_intent != null) {
                return a_intent.getStringExtra(Constant.RESULT_INPUT);
            }
        }

        return "";
    }
}