package com.example.testscroll;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;

public class Main2Activity extends AppCompatActivity {
    ScrollView scrollView;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       scrollView=findViewById(R.id.sv_sv);
       frameLayout=findViewById(R.id.fl_fl);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("坐标信息","scrollView.getScrollY()"+scrollView.getScrollY()+"frameLayout.getScrollY()"+frameLayout.getScrollY());
        return super.dispatchTouchEvent(ev);
    }
    //1
}
