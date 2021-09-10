package com.parkho.sample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sub.*

import com.parkho.sample.PhMainActivityForKotlin.Constant

class PhSubActivityForKotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val strSendText = intent.getStringExtra(Constant.SEND_TEXT)

        val clickListener = View.OnClickListener {
            val intent = Intent().apply {
                val strInput = et_input.text.toString()
                val strResult = strSendText + strInput
                putExtra(Constant.RESULT_INPUT, strResult)
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        btn_send.setOnClickListener(clickListener)
    }
}