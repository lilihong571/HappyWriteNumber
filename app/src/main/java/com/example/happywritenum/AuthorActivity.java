package com.example.happywritenum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AuthorActivity extends AppCompatActivity {
    //声明返回按钮
    private Button button_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
        //给返回按钮赋值
        button_back = (Button)findViewById(R.id.btn_back);
        //设置按钮监听
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //页面跳转
                Intent intent = new Intent(AuthorActivity.this,StartActivity.class);
                startActivity(intent);
            }
        });
    }
}
