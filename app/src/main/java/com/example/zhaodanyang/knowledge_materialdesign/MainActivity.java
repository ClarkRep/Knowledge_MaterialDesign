package com.example.zhaodanyang.knowledge_materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.zhaodanyang.knowledge_materialdesign.appbarlayout.AppbarLayoutActivity;
import com.example.zhaodanyang.knowledge_materialdesign.snackbar.SnackbarActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_snackbar).setOnClickListener(this);
        findViewById(R.id.btn_appbarlayout).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_snackbar:
                startActivity(new Intent(this, SnackbarActivity.class));
                break;
            case R.id.btn_appbarlayout:
                startActivity(new Intent(this, AppbarLayoutActivity.class));
                break;
            default:
                break;
        }
    }
}
