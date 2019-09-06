package com.logic.uasg

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.logic.uasg.model.User
import com.logic.uasg.util.DatabaseUtils
import com.logic.uasg.util.DatabaseUtils.Companion.INPUT_COLUMN_Email
import com.logic.uasg.util.DatabaseUtils.Companion.INPUT_COLUMN_ID
import com.logic.uasg.util.DatabaseUtils.Companion.INPUT_COLUMN_Name
import kotlinx.android.synthetic.main.activity_list.*
import java.util.ArrayList

class StudentListActivity : AppCompatActivity() {


    private var databaseUtils: DatabaseUtils? = null
    private val dataList = ArrayList<User>()

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        databaseUtils = DatabaseUtils(getBaseContext())

        val cursor = databaseUtils!!.getAllUser
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                val listDetails = User(
                    cursor.getInt(cursor.getColumnIndex(INPUT_COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(INPUT_COLUMN_Name)),
                    cursor.getString(cursor.getColumnIndex(INPUT_COLUMN_Email))
                )
                dataList.add(listDetails)
                cursor.moveToNext()
            }
        }

        for (i in 0 until dataList.size) {
            txt_list!!.append(dataList[i].email + "\n\n")
            Log.e("user email", "" + dataList[i].email)
        }
    }
}