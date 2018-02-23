package com.example.coderlt.googletraining.sample.util;

import android.widget.Toast;

import com.example.coderlt.googletraining.sample.application.MyApplication;

/**
 * Created by coderlt on 2018/2/23.
 */

public class ToastUtil {
    public static void showToast(CharSequence s){
        Toast.makeText(MyApplication.getContext(),s,Toast.LENGTH_SHORT)
                .show();
    }
}
