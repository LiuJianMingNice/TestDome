package com.example.developandart.chapter_3.customview;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Build;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import androidx.annotation.RequiresApi;

public  class  DateTimePicker implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

    private static Context context;
    private static DatePickerDialog datePickerDialog;
    private static TimePickerDialog pickerDialog;
    private static Calendar calendar;
    private static TextView editText;  // 绑定控件
    private String dt = "";
    Integer themeId = 2;   // 主题ID
    @SuppressLint("ResourceType")
//    @RequiresApi(api = Build.VERSION_CODES.N)
    public void init(Context context1, TextView editText1)
    {
        calendar=Calendar.getInstance();
        editText=editText1;
        context=context1;
        datePickerDialog=new DatePickerDialog(context,themeId,this, calendar.get(Calendar.YEAR), calendar
                .get(Calendar.MONTH), calendar
                .get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        dt = String.valueOf(new StringBuilder()
                .append(year)
                .append("-")
                .append((month + 1) < 10 ? "0"
                        + (month + 1) : (month + 1))
                .append("-")
                .append((day < 10) ? "0" + day : day));
//        editText.setText( );
        initTimePicker(context);
    }

    public void initTimePicker(Context context1){
        context=context1;
        pickerDialog=new TimePickerDialog(context,themeId,this,8,00,true);
        pickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String s=(hourOfDay<10?"0"+hourOfDay:hourOfDay)+":"+(minute<10?"0"+minute:minute)+ ":"+ "00";
        dt = dt +" "+s;
        editText.setText(dt);
    }
}
