package com.example.coderlt.googletraining.sample.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.coderlt.googletraining.R;
import com.example.coderlt.googletraining.sample.fragment.GT3FragmentOne;
import com.example.coderlt.googletraining.sample.fragment.GT3FragmentTwo;
import com.example.coderlt.googletraining.sample.util.ToastUtil;

public class FragmentUIActivity extends AppCompatActivity implements GT3FragmentOne.OnImageSelectedListener{
    private static final String TAG = "FragmentUIActivity";
    private FrameLayout contentFrame;
    private FragmentManager fm;
    private Fragment fragmentOne,fragmentTwo;
    private Button transitionBtn;
    private boolean isFragmentOne = true;

    @Override
    public void onImageSelect(){
        ToastUtil.showToast("Image Selected");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_ui);

        fm = getSupportFragmentManager();
        fragmentOne = new GT3FragmentOne();
        fragmentTwo = new GT3FragmentTwo();

        //((GT3FragmentOne)fragmentOne).setOnImageSelectedListener(this);
        // 添加一个 fragment
        fm.beginTransaction().add(R.id.content_frame,fragmentOne)
                .commit();

        transitionBtn = findViewById(R.id.transition_btn);
        transitionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFragmentOne){
                    // replace 用一个 fragment 替换另一个 fragment
                    fm.beginTransaction().replace(R.id.content_frame,fragmentTwo)
                        .commit();
                    isFragmentOne = false;
                }else{
                    fm.beginTransaction().replace(R.id.content_frame,fragmentOne)
                        .commit();
                    isFragmentOne = true;
                }
            }
        });
    }
}

/**
 * 通常， Fragment 之间可能存在交互，比如基于用户事件的内容变更，
 * 所有 fragment之间的交互应通过与之关联的 Activity 进行
 * 两个 fragment 之间不应该直接交互
 */