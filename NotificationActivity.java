package com.example.admin.iwantyoubaby;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

public class NotificationActivity extends Activity {

    static final int NOTIFY_ID = 0;
    NotificationCompat.Builder mNotifyBuilder;
    NotificationManager mNotifyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notif);

        Intent intent = new Intent(NotificationActivity.this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(NotificationActivity.this, 0,
                intent, 0);

        mNotifyBuilder = new NotificationCompat.Builder(NotificationActivity.this)
                .setContentTitle("I want you Baby")
                .setContentText("ถึงช่วงเวลาดีๆของคุณแล้ว!")
                .setSmallIcon(R.drawable.iwantyoubaby)
                .setContentIntent(pIntent)
                .setAutoCancel(true);

        Notification notification = mNotifyBuilder.build();

        mNotifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyManager.notify(NOTIFY_ID, notification);
    }

}