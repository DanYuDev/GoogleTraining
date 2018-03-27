package com.example.coderlt.googletraining.sample.activity;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.coderlt.googletraining.R;
import com.example.coderlt.googletraining.sample.util.ToastUtil;

public class ShareActivity extends AppCompatActivity implements View.OnClickListener{
    private boolean workIsDone = false;
    private Button pickBtn,cancelBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        Intent intent = getIntent();
        Uri data = intent.getData();

        pickBtn = findViewById(R.id.pick_btn);
        cancelBtn = findViewById(R.id.cancel_btn);

        pickBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.pick_btn:
                setResult(RESULT_OK, new Intent("com.example.RESULT_ACTION",
                        Uri.parse("content://result_uri")));
                finish();
                break;
            case R.id.cancel_btn:
                setResult(RESULT_CANCELED);
                finish();
                break;
            default:
                break;
        }
    }
}
