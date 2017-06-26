package com.example.admin.iwantyoubaby;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import static com.example.admin.iwantyoubaby.Constants.CONTENT;
import static com.example.admin.iwantyoubaby.Constants.TABLE_NAME;
import static com.example.admin.iwantyoubaby.Constants.TIME;

public class NotesHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "simple_note.db";
    private static final int DATABASE_VERSION = 1;

    // คอนสตรัคเตอร์
    public NotesHelper(Context context) {
        // เรียกคอนสตรัคเตอร์ของคลาส SQLiteOpenHelper
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // สร้างเทเบิล notes ที่ประกอบด้วยคอลัมน์ _id, time และ content
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + BaseColumns._ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TIME
                + " INTEGER, " + CONTENT + " TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // โค้ดที่ใช้อัพเกรดฐานข้อมูล
    }
}

