package com.example.admin.iwantyoubaby;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton cal = (ImageButton) findViewById(R.id.cal);
        ImageButton his = (ImageButton) findViewById(R.id.his);
        ImageButton info = (ImageButton) findViewById(R.id.info);
        //period calculator
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent it = new Intent(getApplicationContext(), period.class);
                startActivity(it);
                    }
                });
        //history
        his.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                Intent it = new Intent(getApplicationContext(), history.class);
                startActivity(it);
            }
        });
        //information
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), info.class);
                startActivity(it);
            }
        });
    }
}
