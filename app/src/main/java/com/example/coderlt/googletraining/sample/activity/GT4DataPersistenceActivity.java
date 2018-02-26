package com.example.coderlt.googletraining.sample.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.coderlt.googletraining.R;
import com.example.coderlt.googletraining.sample.util.ToastUtil;

public class GT4DataPersistenceActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "GT4DataPersistenceActivity";
    private static boolean isChecked = false;
    private SharedPreferences preferences;
    private CheckBox checkBox;
    private EditText accountEt,passwordEt;
    private Button loginBtn;
    private String accountStr,passwordStr;
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
            case R.id.login_btn:
                setString();
                if("15068159967".equals(accountStr) && "wangzuxian".equals(passwordStr)){
                    startActivity(new Intent(this,GT4HomeActivity.class));
                }else{
                    ToastUtil.showToast("用户名或密码错误");
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

        loginBtn.setOnClickListener(this);
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
