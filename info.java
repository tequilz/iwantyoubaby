package com.example.admin.iwantyoubaby;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class info extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
    }
    //เปลี่ยนไปหน้า info
    public void next(View view){
        setContentView(R.layout.info);
    }
    //เปลี่ยนไปหน้า info2
    public void next2(View view){
        setContentView(R.layout.info2);
    }
    //เปลี่ยนไปหน้า info3
    public void next3(View view){
        setContentView(R.layout.info3);
    }
    //เปลี่ยนไปหน้า info5
    public void next5(View view){
        setContentView(R.layout.info5);
    }
    //กลับหน้า home
    public void home(View view){
        ImageButton home = (ImageButton) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent it = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it);
            }
        });
    }
}
