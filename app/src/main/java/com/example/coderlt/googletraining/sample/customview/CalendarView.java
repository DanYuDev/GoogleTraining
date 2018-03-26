package com.example.coderlt.googletraining.sample.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import java.util.Calendar;

/**
 * Created by coderlt on 2018/2/27.
 */

public class CalendarView extends ViewPager {
    private int mWidth,mHeight;
    private Paint mPaint;

    public CalendarView(Context context){
        super(context);
    }

    public CalendarView(Context context, AttributeSet attrs){
        super(context,attrs);
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
    }
}
