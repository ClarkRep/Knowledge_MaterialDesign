package com.example.zhaodanyang.knowledge_materialdesign.snackbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhaodanyang.knowledge_materialdesign.R;

/**
 * Description
 * Company Beijing icourt
 *
 * @author zhaodanyang  E-mail:zhaodanyang@icourt.cc
 *         date createTime：2017/12/12
 *         version
 */
public class SnackbarActivity extends AppCompatActivity implements View.OnClickListener {

    NestedScrollView container;

    private Snackbar.Callback snackbarCallback = new Snackbar.Callback() {
        @Override
        public void onShown(Snackbar sb) {
            super.onShown(sb);
            Log.i("haha", "Snackbar显示了");
        }

        @Override
        public void onDismissed(Snackbar transientBottomBar, int event) {
            super.onDismissed(transientBottomBar, event);
            /*
            0 - via a swipe                          如果父布局是CoordinatorLayout，显示的Snackbar右滑可以消失。
            1 - via an action click                  Snackbar点击事件，可以消失。
            2 - via a timeout                        Snackbar时间到了消失。
            3 - via a call to {@link #dismiss()}     Snackbar触发了dismiss消失，如：Activity销毁。
            4 - a new Snackbar being shown           当一个新的Snackbar显示的时候，导致这个Snackbar消失。
             */
            Log.i("haha", "Snackbar消失的event：" + event);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);
        setTitle("SnackbarActivity");

        container = findViewById(R.id.container);

        findViewById(R.id.snackbar_normal).setOnClickListener(this);
        findViewById(R.id.snackbar_with_action).setOnClickListener(this);
        findViewById(R.id.snackbar_by_setting).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.snackbar_normal:
                showNormalSnackbar();
                break;
            case R.id.snackbar_with_action:
                showSnackbarWithAction();
                break;
            case R.id.snackbar_by_setting:
                showModifySnackbar();
                break;
            default:
                break;
        }
    }

    /**
     * 普通的Snackbar
     */
    private void showNormalSnackbar() {
        //Snackbar必须依赖UI
        Snackbar snackbar = Snackbar.make(container, "我是最基础的Snackbar", 2000);
        snackbar.removeCallback(snackbarCallback);
        snackbar.addCallback(snackbarCallback);
        snackbar.show();
    }

    /**
     * 带有action的Snackbar
     */
    private void showSnackbarWithAction() {
        final Snackbar snackbar = Snackbar.make(container, "我是带Action的Snackbar", 2000);
        snackbar.setAction("点我", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SnackbarActivity.this, "我被点了", Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.removeCallback(snackbarCallback);
        snackbar.addCallback(snackbarCallback);
        snackbar.show();
    }

    /**
     * 设置相关参数的Snackbar
     */
    private void showModifySnackbar() {
        final Snackbar snackbar = Snackbar.make(container, "我是带Action的Snackbar", 2000);
        View view = snackbar.getView();

        TextView textView = view.findViewById(R.id.snackbar_text);
        textView.setTextSize(20);
        textView.setTextColor(Color.RED);

        Button button = view.findViewById(R.id.snackbar_action);
        button.setTextSize(20);
        snackbar.setActionTextColor(Color.BLUE);
        snackbar.setAction("点我", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });

        snackbar.removeCallback(snackbarCallback);
        snackbar.addCallback(snackbarCallback);
        snackbar.show();
    }

}
