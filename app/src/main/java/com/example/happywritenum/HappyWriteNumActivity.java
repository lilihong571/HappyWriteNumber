package com.example.happywritenum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class HappyWriteNumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_happy_write_num);
        //创建计时器任务
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                //实现页面跳转
                Intent intent = new Intent(HappyWriteNumActivity.this,StartActivity.class);
                startActivity(intent);
            }
        };
        //创建计时器
        Timer timer = new Timer();
        //启动计时器的回调函数
        timer.schedule(timerTask,2000);
    }
}
