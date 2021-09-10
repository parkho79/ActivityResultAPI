package com.parkho.sample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class PhMainActivityForKotlin : AppCompatActivity() {

    interface Constant {
        companion object {
            const val SEND_TEXT = "send_text"
            const val RESULT_INPUT = "result_input"
        }
    }

    // Pre contract
    private val preContractStartActivityResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { a_result ->
                if (a_result.resultCode == Activity.RESULT_OK) {
                    a_result.data?.let {
                        tv_input.text = it.getStringExtra(Constant.RESULT_INPUT)
                    }
                }
            }

    // Custom contract
    private val customContractStartActivityResult =
            registerForActivityResult(PhMainContractForKotlin()) { a_result ->
                a_result?.let {
                    tv_input.text = it
                }
            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Sub activity 실행
        val clickListener = View.OnClickListener {
            val intent = Intent(application, PhSubActivityForKotlin::class.java)
            preContractStartActivityResult.launch(intent)

            // customContractStartActivityResult.launch("parkho")
        }
        btn_start.setOnClickListener(clickListener)
    }
}