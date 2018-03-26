package com.example.coderlt.googletraining.sample.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.coderlt.googletraining.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button  chapterOneBtn,
                    chapterTwoBtn,
                    chapterThreeBtn,
                    chapterFourBtn,
                    calenderTestBtn,
                    courseLinkBtn,
                    implicitIntentBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.chapter_one_btn:
                /**
                 * Intent可以携带称作 extras 的键-值对数据类型。
                 * putExtra()方法把键名作为第一个参数，把值作为第二个参数。
                 */
                Intent intent1 = new Intent(this,GTIntentActivity.class);
                startActivity(intent1);
                break;
            case R.id.chapter_two_btn:
                Intent intent2 = new Intent(this,LifeCycleActivity.class);
                startActivity(intent2);
                break;
            case R.id.chapter_three_btn:
                Intent intent3 = new Intent(this,FragmentUIActivity.class);
                startActivity(intent3);
                break;
            case R.id.chapter_four_btn:
                Intent intent4 = new Intent(this,GT4DataPersistenceActivity.class);
                startActivity(intent4);
                break;
            case R.id.calender_test_btn:
                Intent calendarIntent = new Intent(this,CalendarTestActivity.class);
                startActivity(calendarIntent);
                break;
            case R.id.course_link_btn:
                Intent courseIntent = new Intent(this,CourseActivity.class);
                startActivity(courseIntent);
                break;
            case R.id.implicit_intent_btn:
                Intent implicitItent = new Intent(this,ImplicitIntentActivity.class);
                startActivity(implicitItent);
                break;
            default:
                break;
        }
    }

    private void initViews(){
        chapterOneBtn = findViewById(R.id.chapter_one_btn);
        chapterTwoBtn = findViewById(R.id.chapter_two_btn);
        chapterThreeBtn = findViewById(R.id.chapter_three_btn);
        chapterFourBtn = findViewById(R.id.chapter_four_btn);
        calenderTestBtn = findViewById(R.id.calender_test_btn);
        courseLinkBtn = findViewById(R.id.course_link_btn);
        implicitIntentBtn = findViewById(R.id.implicit_intent_btn);

        // set on listener
        chapterOneBtn.setOnClickListener(this);
        chapterTwoBtn.setOnClickListener(this);
        chapterThreeBtn.setOnClickListener(this);
        chapterFourBtn.setOnClickListener(this);
        calenderTestBtn.setOnClickListener(this);
        courseLinkBtn.setOnClickListener(this);
        implicitIntentBtn.setOnClickListener(this);
    }
}
