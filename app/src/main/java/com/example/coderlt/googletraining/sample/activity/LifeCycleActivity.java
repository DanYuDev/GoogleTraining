package com.example.coderlt.googletraining.sample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.coderlt.googletraining.R;

public class LifeCycleActivity extends AppCompatActivity {
    private static final String TAG = "LifeCycleActivity";

    /**
     * onCreate函数尽量完成较少的事情，避免程序启动太久都看不到界面
     * @param savedInstanceState 重新创建 activity 时会使用到
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
    }

    /**
     * 加了 @CallSuper 注解 ，如果不调用 super，会有一个编译时的错误
     */
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"onResume");
    }

    /*
    当系统调用activity中的onPause()，从技术上讲，意味着activity仍然处于部分可见的状态.但
    更多时候意味着用户正在离开这个activity，并马上会进入Stopped state. 通常应该在onPause()回调方法里面做以下事情:
    停止动画或者是其他正在运行的操作，那些都会导致CPU的浪费.。
    提交在用户离开时期待保存的内容(例如邮件草稿).
    释放系统资源，例如broadcast receivers, sensors (比如GPS), 或者是其他任何会影响到电量的资源。
    */
    //如果activity实际上是要被Stop，那么我们应该为了切换的顺畅而减少在OnPause()方法里面的工作量。
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"onPause");
    }


    /**
     * 不同于暂停状态的部分阻塞UI，停止状态是UI不再可见并且用户的焦点转移到另一个activity中.
     */
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG,"onStop");
    }
    /*
    大多数 app并不需要实现这个方法，因为局部类的references会随着activity的销毁而销毁，
    并且我们的activity应该在onPause()与onStop()中执行清除activity资源的操作。
    然而，如果activity含有在onCreate调用时创建的后台线程，或者是其他有可能导致内存泄漏的资源，
    则应该在OnDestroy()时进行资源清理，杀死后台线程
    */
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    /**
     *  onRestart之后再执行 onStart 就处于 started 状态
     */
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG,"onRestart");
    }
}       /*
        正如您将要在以下课程中要学习的，有Activity会在图 1 所示不同状态之间过渡的几种情况。但是，这些状态中只有三种可以是静态。
                也就是说，Activity只能在三种状态之一下存在很长时间。

        Resumed：在这种状态下，Activity处于前台，且用户可以与其交互。（有时也称为“运行”状态。）
        Paused：在这种状态下，Activity被在前台中处于半透明状态或者未覆盖整个屏幕的另一个Activity—部分阻挡。
                暂停的Activity不会接收用户输入并且无法执行任何代码。
        Stopped：在这种状态下，Activity被完全隐藏并且对用户不可见；它被视为处于后台。停止时，
                Activity实例及其诸如成员变量等所有状态信息将保留，但它无法执行任何代码。

        其他状态（“创建”和“开始”）是瞬态，
        其它状态 (Created与Started)都是短暂的瞬态，系统会通过调用下一个生命周期回调方法从这些状态快速移到下一个状态。
                也就是说，在系统调用 onCreate()) 之后，它会快速调用 onStart())，紧接着快速调用 onResume())。
        */
