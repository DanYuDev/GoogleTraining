package com.example.coderlt.googletraining.sample.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.coderlt.googletraining.R;

import java.net.Proxy;
import java.util.List;

import static java.net.Proxy.Type.HTTP;

public class ImplicitIntentActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "ImplicitIntentActivity";
    private Button dailBtn;
    private Button emailBtn;
    private Button browserBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        dailBtn = findViewById(R.id.dail_btn);
        emailBtn = findViewById(R.id.email_btn);
        browserBtn = findViewById(R.id.browser_btn);

        dailBtn.setOnClickListener(this);
        emailBtn.setOnClickListener(this);
        browserBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.dail_btn:
                Uri uri = Uri.parse("tel:15068159967");
                Intent dailIntent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(dailIntent);
                break;
            case R.id.email_btn:
                /**
                 * 如果系统找不到接受这个 intent 的 activity，而启动startActivity，则 app 崩溃。
                 * 系统是如何崩溃的呢？为什么系统不会自愈？
                 */
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                // The intent does not have a URI, so declare the "text/plain" MIME type
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"jon@example.com"}); // recipients
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
                emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));

                // 判断有无 activity  handle这个intent
                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(emailIntent,0);

                if(activities.size()>0){
                    Log.d(TAG,"activities length is "+activities.size()+","+activities.get(0).toString());
                    startActivity(emailIntent);
                }
                break;
            case R.id.browser_btn:
                Uri webPage = Uri.parse("https://www.baidu.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW,webPage);
                startActivity(webIntent);
                break;
            default:
                break;
        }
    }
}
