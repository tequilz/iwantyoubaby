package com.example.admin.iwantyoubaby;

import android.content.Intent;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import static com.example.admin.iwantyoubaby.Constants.CONTENT;
import static com.example.admin.iwantyoubaby.Constants.TABLE_NAME;
import static com.example.admin.iwantyoubaby.Constants.TIME;
import static com.example.admin.iwantyoubaby.Constants._ID;

public class history extends ListActivity {

    private NotesHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        ImageButton clear = (ImageButton) findViewById(R.id.calculator);
        //ลบข้อมูล
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helper.getWritableDatabase().delete(TABLE_NAME,null,null);
                helper.close();
                Cursor cursor = getAllNotes();
                showNotes(cursor);
                Toast.makeText(getApplicationContext(),"ล้างประวัติแล้ว",Toast.LENGTH_SHORT).show();
            }
        });

        Intent it = getIntent();
        final String dmy = it.getStringExtra("d");
        final String cy = it.getStringExtra("c");
        final String ov = it.getStringExtra("o");
        final String fe = it.getStringExtra("f");

        helper = new NotesHelper(this);  // สร้าง Helper object

            // อ่านข้อมูลทั้งหมดจากฐานข้อมูลมาแสดงผล
            try {
                Cursor cursor = getAllNotes();
                showNotes(cursor);
            } finally {
                // ปิดการเชื่อมต่อกับฐานข้อมูล ไม่ว่าโค้ดในส่วนของ try จะเกิดข้อผิดพลาดหรือไม่ก็ตาม
                helper.close();
            }

            final String txtNewText = "ประจำเดือนวันแรก : "+dmy+"\n"+"รอบเดือน : "+cy+" วัน \nวันไข่ตก : "+ov+"\n"+"ระยะเวลาที่เหมาะสม : "+fe;

            // นำข้อความจาก EditText เพิ่มลงฐานข้อมูล แล้วอ่านข้อมูลทั้งหมดมาแสดง
            try {
                if(ov != null && fe !=null) {
                    addNote(txtNewText);
                    Cursor cursor = getAllNotes();
                    showNotes(cursor);
                }
            } finally {
                helper.close();
            }
    }
    //เพิ่มข้อมูล
    private void addNote(String str) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TIME, System.currentTimeMillis());
        values.put(CONTENT, str);
        db.insertOrThrow(TABLE_NAME, null, values);
    }

    private static String[] COLUMNS = {_ID, TIME, CONTENT};
    private static String ORDER_BY = TIME + " DESC";

    private Cursor getAllNotes() {
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql = "SELECT _id, datetime(time/1000, 'unixepoch', 'localtime') as time, content " +
                "FROM " + TABLE_NAME + " ORDER BY " + ORDER_BY;
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }

    private static int[] VIEWS = {R.id.rowid, R.id.time, R.id.content};

    private void showNotes(Cursor cursor) {
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.item, cursor, COLUMNS, VIEWS, 0);
        setListAdapter(adapter);
    }
}
