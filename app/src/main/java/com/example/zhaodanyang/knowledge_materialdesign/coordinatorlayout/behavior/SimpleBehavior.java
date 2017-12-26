package com.example.zhaodanyang.knowledge_materialdesign.coordinatorlayout.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import com.example.zhaodanyang.knowledge_materialdesign.R;

/**
 * Description 一个简单的自定义behavior，范型是Child View
 * Company Beijing icourt
 *
 * @author zhaodanyang  E-mail:zhaodanyang@icourt.cc
 *         date createTime：2017/12/23
 *         version
 */
public class SimpleBehavior extends CoordinatorLayout.Behavior<Button> {

    private int width;
    private int height;

    public SimpleBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        width = displayMetrics.widthPixels;
        height = displayMetrics.heightPixels;
    }

    /**
     * 判断child的布局所依赖的dependency
     *
     * @param parent
     * @param child
     * @param dependency
     * @return false - 表示Child View 不依赖dependency；true - 表示依赖
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Button child, View dependency) {
        if (dependency.getId() == R.id.dependency) {
            return true;
        }
        return false;
    }

    /**
     * 当dependency发生改变时（位置、宽高等），执行这个函数。
     *
     * @param parent
     * @param child
     * @param dependency
     * @return true - 表示Child View要随着dependency的改变而改变（宽高、位置等）；否则就返回false
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, Button child, View dependency) {
        int top = dependency.getTop();
        int left = dependency.getLeft();

        CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) child.getLayoutParams();
        layoutParams.topMargin = top + dependency.getHeight();
        layoutParams.leftMargin = left;
        child.setLayoutParams(layoutParams);

        return true;
    }

}
