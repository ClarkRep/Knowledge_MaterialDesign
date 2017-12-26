package com.example.zhaodanyang.knowledge_materialdesign.appbarlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.zhaodanyang.knowledge_materialdesign.R;

/**
 * Description
 * Company Beijing icourt
 *
 * @author zhaodanyang  E-mail:zhaodanyang@icourt.cc
 *         date createTime：2017/12/20
 *         version
 */
public class AppbarLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    /*
       AppbarLayout是一种支持响应滚动收拾的appbar布局（如工具栏滚出或滚入屏幕）；
       CollapsingToolbarLayout则是专门用来实现子布局内不同元素响应滚动细节的布局。
     */

    /*
       AppbarLayout的子布局有5种滚动标识（app:layout_scrollFlags对应的属性参数）:
       1.scroll：将此布局和滚动事件关联（注意：这个标识要在其他标识之前，没有这个标识则布局不会滚动，并且其他标识设置无效）；
       2.enterAlways：这个标识通常被称为"快速返回"模式，其实就是向下滚动时Scrolling View和Child View之间滚动优先级问题；
       （对比scroll和scroll|enterAlways设置 - 向下滚动时：前者Scrolling View优先于Child View滚动；后者Child View优先于Scrolling View滚动）。
       3.enterAlwaysCollapsed：enterAlways的附加值。这里涉及到Child View的高度和最小高度，向下滚动时，Child View先向下滚动最小高度值，然后Scrolling View开始滚动，
       到达边界时，Child View再向下滚动，直至显示完全。
       4.exitUntilCollapsed：这里也涉及到最小高度。向上发生滚动事件的时候，Child View向上滚动退出直至最小高度，然后Scrolling View开始滚动。也就是说，Child View不会完全退出屏幕。
       5.snap：简单理解，就是Child View滚动比例的一个吸附效果。也就是说，Child View不会存在局部显示的情况，要么完全显示，要么完全隐藏。
     */

    /*
        CollapsingToolbarLayout 可以通过app:contentScrim设置折叠时工具栏布局的颜色，用过app:statusBarScrim设置折叠时状态栏的颜色。
        默认contentScrim时colorPrimary的色值，statusBarScrim是colorPrimaryDark的色值。

        CollapsingToolbarLayout的子布局有3种折叠模式（Toolbar中设置的app:layout_collapseMode）：
        1.off：这是个默认属性，布局将正常显示，没有折叠的行为。
        2.pin：CollapsingToolbarLayout折叠后，此布局将固定在顶部。
        3.parallax：CollapsingToolbarLayout折叠后，此布局也会有视差折叠效果。
     */

    /*
     布局结构：
        <AppBarLayout>
            <CollapsingToolbarLayout>
                <ImageView app:layout_collapseMode="parallax"/>
                <Toolbar app:layout_collapseMode="pin">
                    <TextView/>
                </Toolbar>
            </CollapsingToolbarLayout>
        </AppBarLayout>
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbar_layout);
        setTitle("AppbarLayoutActivity");

        AppBarLayout appBarLayout = findViewById(R.id.appBarLayout);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.ctl);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
            }
        });

        findViewById(R.id.btn_scroll).setOnClickListener(this);
        findViewById(R.id.btn_enterAlways).setOnClickListener(this);
        findViewById(R.id.btn_enterAlwaysCollapsed).setOnClickListener(this);
        findViewById(R.id.btn_exitUntilsCollapsed).setOnClickListener(this);
        findViewById(R.id.btn_snap).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_scroll:
                startActivity(new Intent(this, FlagScrollActivity.class));
                break;
            case R.id.btn_enterAlways:
                startActivity(new Intent(this, FlagEnterAlwaysActivity.class));
                break;
            case R.id.btn_enterAlwaysCollapsed:
                startActivity(new Intent(this, FlagEnterAlwaysCollapsedActivity.class));
                break;
            case R.id.btn_exitUntilsCollapsed:
                startActivity(new Intent(this, FlagExitUntilCollapsedActivity.class));
                break;
            case R.id.btn_snap:
                startActivity(new Intent(this, FlagSnapActivity.class));
                break;
            default:
                break;
        }
    }
}
