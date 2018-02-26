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
                    chapterFourBtn;
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
                Intent intent = new Intent(this,GTIntentActivity.class);
                startActivity(intent);
                break;
            case R.id.chapter_two_btn:
                Intent intent1 = new Intent(this,LifeCycleActivity.class);
                startActivity(intent1);
                break;
            case R.id.chapter_three_btn:
                Intent intent2 = new Intent(this,FragmentUIActivity.class);
                startActivity(intent2);
                break;
            case R.id.chapter_four_btn:
                Intent intent3 = new Intent(this,GT4DataPersistenceActivity.class);
                startActivity(intent3);
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
        // set on listener
        chapterOneBtn.setOnClickListener(this);
        chapterTwoBtn.setOnClickListener(this);
        chapterThreeBtn.setOnClickListener(this);
        chapterFourBtn.setOnClickListener(this);
    }
}
