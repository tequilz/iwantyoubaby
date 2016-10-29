package com.example.admin.datepickertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cmd = (Button) findViewById(R.id.button2);
        final EditText cycle = (EditText) findViewById(R.id.editText3);
        final CalendarView d = (CalendarView) findViewById(R.id.calendarView);

        cmd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cy = Integer.parseInt(cycle.getText().toString());
                int ovday = cy/2;
                int ffday = cy-18;
                int lfday = cy-11;
                String date = "---";
                Toast t = Toast.makeText(getApplicationContext(),date,Toast.LENGTH_SHORT);
                t.show();
            }
        });
    }
}
