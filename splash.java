package com.example.admin.iwantyoubaby;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class splash extends Activity {
    private static final int SPLASH_TIME = 2 * 1000;// 3 seconds delay

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        ImageView iv= (ImageView) findViewById(R.id.imageView2);
        iv.setBackgroundResource(R.drawable.splash);
        try {
            new Handler().postDelayed(new Runnable() {

                public void run() {

                    Intent intent = new Intent(splash.this,
                            MainActivity.class);
                    startActivity(intent);

                    splash.this.finish();
                }
            }, SPLASH_TIME);

    } catch(Exception e){}
}
    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }
}