package com.parkho.sample

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

import com.parkho.sample.PhMainActivityForKotlin.Constant

class PhMainContractForKotlin : ActivityResultContract<String, String>() {

    override fun createIntent(a_context: Context, a_strSendText: String): Intent {
        return Intent(a_context, PhSubActivityForKotlin::class.java).apply {
            putExtra(Constant.SEND_TEXT, a_strSendText)
        }
    }

    override fun parseResult(a_resultCode: Int, a_intent: Intent?): String? =
            if (a_resultCode == Activity.RESULT_OK) a_intent?.getStringExtra(PhMainActivity.Constant.RESULT_INPUT)
            else ""

}