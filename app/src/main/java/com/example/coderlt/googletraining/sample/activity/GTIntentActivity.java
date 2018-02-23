package com.example.coderlt.googletraining.sample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.coderlt.googletraining.R;
import com.example.coderlt.googletraining.sample.util.ToastUtil;

public class GTIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gtintent);
        // 无效，不知道哪里出了问题，图表显示了，但是事件不响应
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // 为 ActionBar 扩展菜单项
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.intent_activity_actions,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_search:
                ToastUtil.showToast("Searching ...");
                break;
            case R.id.action_settings:
                ToastUtil.showToast("Settings ...");
                break;
            default:
                break;
        }
        return true;
    }
}
