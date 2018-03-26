package com.example.coderlt.googletraining.sample.activity;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.coderlt.googletraining.R;
import com.example.coderlt.googletraining.sample.util.ToastUtil;

import java.awt.font.TextAttribute;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executor;

import static java.util.Calendar.FRIDAY;
import static java.util.Calendar.MONDAY;
import static java.util.Calendar.SATURDAY;
import static java.util.Calendar.SUNDAY;
import static java.util.Calendar.THURSDAY;
import static java.util.Calendar.TUESDAY;
import static java.util.Calendar.WEDNESDAY;

public class CalendarTestActivity extends AppCompatActivity {
    private static final String TAG = "CalendarTestActivity";
    private Calendar calendar = Calendar.getInstance();
    private Calendar calendarTomorrow;
    private TextView calendarTv ;
    private int year,month,dayOfWeek,dayOfMonth,dayOfYear,hour,min,sec;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
    private String sdfTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_test);

        getTime();
        initViews();
        calendarTv.setText("分别获取年月日： "+year+"-"+month+"-"+dayOfMonth+
                    "\n今天是今年的第"+dayOfYear+"天"+
                    "\n今天是星期"+dayOfWeek+
                    "\nSimpleDataFormat:"+sdfTime+
                    "\n明天："+sdf.format(calendarTomorrow.getTime()));

        DatePickerDialog dp = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                ToastUtil.showToast("Date selected");
            }
        },2018,3,1);
        dp.show();
    }

    private void initViews(){
        calendarTv = findViewById(R.id.calendar_tv);
    }

    private void getTime(){
        year = calendar.get(Calendar.YEAR);
        month  = calendar.get(Calendar.MONTH)+1;
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        //获得今天是周几，这里不能直接将返回值当做周几，而应该与Calendar用于表示周几的常量搭配使用
        // 返回值为3不代表今天是周三
        dayOfWeek = realDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK));

        //Calendar虽然不提供显示规范格式时间的方法，但是可以用SimpleDateFormat来输出规范的字符串
        sdfTime = sdf.format(calendar.getTime());

        // 额，我这里好像没什么屌用，calendarTomorrow的改变也会引起calendar的改变
        calendarTomorrow = calendar;
        calendarTomorrow.add(Calendar.DAY_OF_MONTH,2);

        //除了可以方便地显示日期以外，还可以将格式一致的字符串解析为Date类，
        // 然后使用Calendar类的方法将Date类转换为Calendar类
        try{
            Date date = sdf.parse("2018年3月6日");
            calendar.setTime(date);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private int realDayOfWeek(int dayOfWeek){
        switch (dayOfWeek){
            case MONDAY:
                return 1;
            case TUESDAY:
                return 2;
            case WEDNESDAY:
                return 3;
            case THURSDAY:
                return 4;
            case FRIDAY:
                return 5;
            case SATURDAY:
                return 6;
            case SUNDAY:
                return 7;
            default:
                return -1;
        }
    }
}
