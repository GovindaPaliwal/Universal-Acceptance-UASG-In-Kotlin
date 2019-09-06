package com.logic.uasg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.logic.uasg.util.DatabaseUtils
import com.logic.uasg.util.Validator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var helper = DatabaseUtils(applicationContext)


        btn_submit.setOnClickListener {
            if (TextUtils.isEmpty(et_email.text)) {
                et_email.error = "enter email address";
            } else if (TextUtils.isEmpty(et_name.text)) {
                et_name.error = "enter student name";
            } else if (!Validator.isEmailValid(et_email.text.toString())) {
                et_email.error = "enter valid email address";
            } else {

                helper.insertUser(et_name.text.toString(), et_email.text.toString())
                Toast.makeText(
                    applicationContext,
                    "Student Information Store Successfully",
                    Toast.LENGTH_LONG
                ).show()
                et_name.setText("");
                et_email.setText("");
            }
        }

        btn_list.setOnClickListener {
            val intent = Intent(this, StudentListActivity::class.java)
            startActivity(intent)
        }
    }
}
