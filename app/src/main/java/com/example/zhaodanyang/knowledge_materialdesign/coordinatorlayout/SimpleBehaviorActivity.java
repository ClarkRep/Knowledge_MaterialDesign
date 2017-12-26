package com.example.zhaodanyang.knowledge_materialdesign.coordinatorlayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.zhaodanyang.knowledge_materialdesign.R;

/**
 * Description
 * Company Beijing icourt
 *
 * @author zhaodanyang  E-mail:zhaodanyang@icourt.cc
 *         date createTime：2017/12/23
 *         version
 */
public class SimpleBehaviorActivity extends AppCompatActivity {

    private int downX;
    private int downY;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_behavior);

        final TextView dependency = findViewById(R.id.dependency);
        dependency.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        downX = (int) event.getX();
                        downY = (int) event.getY();

                        break;
                    case MotionEvent.ACTION_MOVE:
                        int x = (int) event.getX();
                        int y = (int) event.getY();

                        CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) dependency.getLayoutParams();

                        int leftMargin = layoutParams.leftMargin;
                        int topMargin = layoutParams.topMargin;

                        int moveX = x - downX;
                        int moveY = y - downY;

                        layoutParams.leftMargin = leftMargin + moveX;
                        layoutParams.topMargin = topMargin + moveY;

                        dependency.setLayoutParams(layoutParams);
                        break;

                    case MotionEvent.ACTION_UP:
                        downX = 0;
                        downY = 0;
                        break;
                }
                return true;
            }
        });
    }

}
