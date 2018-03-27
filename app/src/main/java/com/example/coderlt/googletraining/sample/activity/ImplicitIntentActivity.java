package com.example.coderlt.googletraining.sample.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.coderlt.googletraining.R;
import com.example.coderlt.googletraining.sample.util.ToastUtil;

import java.util.List;

public class ImplicitIntentActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "ImplicitIntentActivity";
    private static final int PICK_CONTACTS_REQUEST = 0x1111;
    private Button dailBtn;
    private Button emailBtn;
    private Button browserBtn;
    private Button mapsBtn;
    private Button resultBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        dailBtn = findViewById(R.id.dail_btn);
        emailBtn = findViewById(R.id.email_btn);
        browserBtn = findViewById(R.id.browser_btn);
        mapsBtn = findViewById(R.id.maps_btn);
        resultBtn = findViewById(R.id.start_for_result_btn);

        dailBtn.setOnClickListener(this);
        emailBtn.setOnClickListener(this);
        browserBtn.setOnClickListener(this);
        mapsBtn.setOnClickListener(this);
        resultBtn.setOnClickListener(this);
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
            case R.id.maps_btn:
                Uri mapsUri = Uri.parse("http://maps.google.com/maps?f=d&saddr=startLat%20startLng&daddr=endLat%20endLng&hl=en");
                Intent mapsIntent = new Intent(Intent.ACTION_VIEW,mapsUri);
                startActivity(mapsIntent);
                break;
            case R.id.start_for_result_btn:
                Intent resultIntent=new Intent(Intent.ACTION_PICK,Uri.parse("content://contacts"));
                resultIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(resultIntent,PICK_CONTACTS_REQUEST);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode == PICK_CONTACTS_REQUEST){
            if(resultCode == RESULT_OK){
                Uri contactUri = data.getData();
                // 提取需要的列 ,Cursor是一个 interface
                String[] projections = {ContactsContract.CommonDataKinds.Phone.NUMBER};
                Cursor cursor = getContentResolver()
                        .query(contactUri,projections,null,null,null);
                cursor.moveToFirst();
                String number = cursor.
                        getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                ToastUtil.showToast("Number is : "+number);
            }
        }
    }
}
