package com.example.admin.iwantyoubaby;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class result extends AppCompatActivity {

    static final int NOTIFY_ID = 0;
    NotificationCompat.Builder mNotifyBuilder;
    NotificationManager mNotifyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        TextView ovd = (TextView) findViewById(R.id.textView3);
        TextView fep = (TextView) findViewById(R.id.textView5);
        //รับค่าจาก period
        Intent it = getIntent();
        final String dmy = it.getStringExtra("d");
        final String cy = it.getStringExtra("c");
        final String ov = it.getStringExtra("o");
        final String ff = it.getStringExtra("f");
        final String lf = it.getStringExtra("l");
        final String fe = ff + " - " + lf;
        //set ค่าให้ text
        ovd.setText(ov);
        fep.setText(fe);

        ImageButton cmd = (ImageButton) findViewById(R.id.save);
        ImageButton cmd1 = (ImageButton) findViewById(R.id.recal);
        //บันทึก
        cmd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupAlarm(); //แจ้งเตือน
                Intent it = new Intent(getApplicationContext(), history.class);
                Toast t = Toast.makeText(getApplicationContext(), "บันทึกแล้ว", Toast.LENGTH_SHORT);
                t.show();
                it.putExtra("d", dmy); //Date
                it.putExtra("c", cy); //cycle
                it.putExtra("o", ov); //ovulation
                it.putExtra("f", fe); //fertile
                startActivity(it);
            }
        });
        //ไปหน้าคำนวณใหม่
        cmd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent it = new Intent(getApplicationContext(), period.class);
                startActivity(it);
            }
        });}
    //แจ้งเตือน
    private void setupAlarm(){
        //รับค่ามาแจ้งเตือน
        Intent it = getIntent();
        final String ff = it.getStringExtra("f");

        //set แจ้งเตือน
        try {
            DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
            Date d = dateFormat.parse(ff); //แปลง string เป็น date
            //set date
            Calendar alarm = Calendar.getInstance();
            alarm.setTime(d);
            // alarm at 9 AM
            alarm.set(Calendar.HOUR_OF_DAY, 9);
            alarm.set(Calendar.MINUTE, 0);
            alarm.set(Calendar.SECOND, 0);
            alarm.set(Calendar.MILLISECOND, 0);

            //set notification
            Intent intent = new Intent(result.this, NotificationActivity.class);
            PendingIntent pIntent = PendingIntent.getActivity(result.this, 0,
                    intent, 0);

            AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, alarm.getTimeInMillis(), pIntent);

        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
}