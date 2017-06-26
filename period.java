package com.example.admin.iwantyoubaby;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class period extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.period);

        final ImageButton cmd = (ImageButton) findViewById(R.id.calculator);
        final EditText cycle = (EditText) findViewById(R.id.editText);
        final DatePicker date = (DatePicker) findViewById(R.id.datePicker);

                cmd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            Intent it = new Intent(getApplicationContext(), result.class);
                            String c = cycle.getText().toString();
                            int cy = Integer.parseInt(c); //รัย cycle
                            //คำนวณวัน
                            int ovday = cy/2;
                            int ffday = cy-18;
                            int lfday = cy-11;
                            //รับค่าวันที่จาก datepicker
                            int day = date.getDayOfMonth();
                            int month = date.getMonth();
                            int year = date.getYear()-1900;
                            //แปลงเป็นวันที่
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
                            String dmy = sdf.format(new Date(year,month,day));
                            DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
                            Date d = dateFormat.parse(dmy); //แปลง string เป็น date
                            //set date
                            Calendar ca = Calendar.getInstance();
                            ca.setTime(d);
                            ca.add(ca.DATE,ovday);
                            Calendar ca1 = Calendar.getInstance();
                            ca1.setTime(d);
                            ca1.add(ca.DATE,ffday);
                            Calendar ca2 = Calendar.getInstance();
                            ca2.setTime(d);
                            ca2.add(ca.DATE,lfday);
                            //แปลง date เป็น string
                            String ov = dateFormat.format(ca.getTime());
                            String ff = dateFormat.format(ca1.getTime());
                            String lf = dateFormat.format(ca2.getTime());
                            //ส่งค่าไป activity ถัดไป
                            it.putExtra("d", dmy);
                            it.putExtra("c", c);
                            it.putExtra("o", ov);
                            it.putExtra("f", ff);
                            it.putExtra("l", lf);
                            startActivity(it);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
            }
    }
