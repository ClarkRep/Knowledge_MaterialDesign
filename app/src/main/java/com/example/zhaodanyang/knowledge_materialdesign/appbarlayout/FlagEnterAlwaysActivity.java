package com.example.zhaodanyang.knowledge_materialdesign.appbarlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zhaodanyang.knowledge_materialdesign.R;
import com.example.zhaodanyang.knowledge_materialdesign.adapter.BaseAdapter;

/**
 * Description
 * Company Beijing icourt
 *
 * @author zhaodanyang  E-mail:zhaodanyang@icourt.cc
 *         date createTime：2017/12/21
 *         version
 */
public class FlagEnterAlwaysActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag_enter_always);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setAdapter(new BaseAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}
