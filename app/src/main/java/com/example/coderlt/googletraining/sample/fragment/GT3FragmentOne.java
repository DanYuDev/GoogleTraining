package com.example.coderlt.googletraining.sample.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.coderlt.googletraining.R;

/**
 * Created by coderlt on 2018/2/25.
 */

public class GT3FragmentOne extends Fragment {
    private OnImageSelectedListener mCallback = null;
    private ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_one,container,false);
        imageView = v.findViewById(R.id.fragment1_iv);
        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v ){
                if (mCallback!=null){
                    mCallback.onImageSelect();
                }
            }
        });
        return v;
    }

    public interface OnImageSelectedListener{
        void onImageSelect();
    }

    /**
     * 其实这个函数一般不这样，很麻烦
     * 一般回调注册是写在 onAttach 函数里，当然功能是类似，就是给 mCallback 赋值
     * @param
     */
    /*public void setOnImageSelectedListener(OnImageSelectedListener mCallback){
        this.mCallback = mCallback;
    }*/

    @Override
    public void onAttach(Context activity){
        super.onAttach(activity);
        try{
            mCallback = (OnImageSelectedListener)activity;
        }catch(ClassCastException ex){
            throw new ClassCastException(activity.toString()+
                "must implements OnImageSelectedListener.");
        }
    }
}
