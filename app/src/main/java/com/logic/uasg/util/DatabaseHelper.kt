package com.logic.uasg.util

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseUtils(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {


    val getAllUser: Cursor
        get() {
            val db = this.readableDatabase
            return db.rawQuery("SELECT * FROM $INPUT_TABLE_NAME", null)
        }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE " + INPUT_TABLE_NAME + "(" +
                    INPUT_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    INPUT_COLUMN_Name + " TEXT, " +
                    INPUT_COLUMN_Email + " TEXT )"
        )
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $INPUT_TABLE_NAME")
        onCreate(db)
    }


    fun insertUser(title: String, text: String) {
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(INPUT_COLUMN_Name, title)
        contentValues.put(INPUT_COLUMN_Email, text)
        db.insert(INPUT_TABLE_NAME, null, contentValues)
    }

    companion object {

        private val DATABASE_NAME = "Users.db"
        private val DATABASE_VERSION = 1
        private val INPUT_TABLE_NAME = "user"
        val INPUT_COLUMN_ID = "_id"
        val INPUT_COLUMN_Name = "name"
        val INPUT_COLUMN_Email = "email"
    }

}