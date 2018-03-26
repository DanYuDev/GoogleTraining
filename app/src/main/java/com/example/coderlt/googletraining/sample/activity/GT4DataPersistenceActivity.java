package com.example.coderlt.googletraining.sample.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.coderlt.googletraining.R;
import com.example.coderlt.googletraining.sample.util.ToastUtil;

import java.io.File;
import java.io.IOException;

public class GT4DataPersistenceActivity extends AppCompatActivity
        implements View.OnClickListener{
    private static final String TAG = "GT4DataPersistence";
    private static boolean isChecked = false;
    private SharedPreferences preferences;
    private CheckBox checkBox;
    private EditText accountEt,passwordEt;
    private Button loginBtn;
    private String accountStr,passwordStr;

    private EditText internalEt,
                     internalCacheEt,
                     externalEt;
    private Button fileBuildBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gt4_data_persistence);

        initViews();
        login();
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            //登陆验证，密码保存在 actvity 的生命周期方法内
            case R.id.login_btn:
                setString();
                if("15068159967".equals(accountStr) && "wangzuxian".equals(passwordStr)){
                    startActivity(new Intent(this,GT4HomeActivity.class));
                }else{
                    ToastUtil.showToast("用户名或密码错误");
                }
                break;
            // 执行一系列的创建文件的工作
            // internal File 在手机端是看不到的，隐藏了起来
            case R.id.file_build_btn:
                File internalFile =
                        new File(this.getFilesDir(),internalEt.getText().toString());
                try{
                    if(!internalFile.exists())
                        internalFile.createNewFile();
                    else{
                        Log.d(TAG,"internalFile path "+internalFile.getAbsolutePath());
                        ToastUtil.showToast("internalFile exist.");
                    }
                }catch (IOException ex){
                    ex.printStackTrace();
                }
                File internalCacheFile =
                        new File(getCacheDir(),internalCacheEt.getText().toString());
                try{
                    if(!internalCacheFile.exists())
                        internalCacheFile.createNewFile();
                    else
                        ToastUtil.showToast("internalCacheFile exist.");
                }catch (IOException ex){
                    ex.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

    private void initViews(){
        accountEt = findViewById(R.id.account_et);
        passwordEt = findViewById(R.id.password_et);
        checkBox = findViewById(R.id.remember_check_box);
        loginBtn = findViewById(R.id.login_btn);
        internalEt = findViewById(R.id.internal_file_et);
        internalCacheEt = findViewById(R.id.internal_cache_file_et);
        fileBuildBtn = findViewById(R.id.file_build_btn);

        loginBtn.setOnClickListener(this);
        fileBuildBtn.setOnClickListener(this);
        preferences = getPreferences(MODE_PRIVATE);
    }

    private void login(){
        if(isChecked){
            checkBox.setChecked(true);
            accountEt.setText(preferences.getString("account",""));
            passwordEt.setText(preferences.getString("password",""));
        }
    }

    private void writePreference(){
        preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("account",accountStr);
        editor.putString("password",passwordStr);
        editor.commit();
    }

    private void setString(){
        accountStr = accountEt.getText().toString().trim();
        passwordStr = passwordEt.getText().toString().trim();
    }

    /**
     * 写入preference的时机有两个，其实只有一个，其实只要下面这个就行
     * 不信你可以log一下，点击登陆，还是要执行下面这一步
     * 这充分体现了 Activity 生命周期的重要性
     */
    @Override
    protected void onPause(){
        super.onPause();
        if(checkBox.isChecked()){
            setString();
            writePreference();
            isChecked = true;
        } else{
            isChecked = false;
        }
    }
}
