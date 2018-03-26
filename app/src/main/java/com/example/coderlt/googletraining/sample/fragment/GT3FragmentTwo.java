package com.example.coderlt.googletraining.sample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coderlt.googletraining.R;

/**
 * Created by coderlt on 2018/2/25.
 */

public class GT3FragmentTwo extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_two,container,false);
        return v;
    }
}
