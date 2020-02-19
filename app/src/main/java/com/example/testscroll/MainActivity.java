package com.example.testscroll;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvTest;
    ListView lvLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);
        //沉浸式状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        WindowManager.LayoutParams lp = getWindow().getAttributes();

        lp.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;

        getWindow().setAttributes(lp);

        lvLv = findViewById(R.id.lv_lv);
        lvLv.setAdapter(new ListAdapter() {
            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEnabled(int position) {
                return false;
            }

            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getCount() {
                return 89;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = new TextView(MainActivity.this);
                textView.setHeight(100);
                if (position == 7) {
                    tvTest = textView;
                    textView.setText("我是目标");
                }
                return convertView == null ? textView : convertView;
            }

            @Override
            public int getItemViewType(int position) {
                return 1;
            }

            @Override
            public int getViewTypeCount() {
                return 1;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }
        });
//        tvTest = findViewById(R.id.tv_test);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("坐标检测", "tvTest.getY()" + tvTest.getY() + "|=|tvTest.getTop():" + tvTest.getTop() + "|=|tvTest.getScrollY():" + tvTest.getScrollY()+ "|=|lvLv.getTranslationY():"+lvLv.getTranslationY());
        return super.dispatchTouchEvent(ev);
    }
    //验证：在一个scrollview中，frameLayout会不会调用scrollY方法？答案：不会。但是scrollView会调用。
}
//hahaha