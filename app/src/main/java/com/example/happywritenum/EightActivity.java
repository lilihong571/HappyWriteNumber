package com.example.happywritenum;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class EightActivity extends AppCompatActivity {

    //声明一个ImageView控件
    private ImageView imageView;
    //声明演示按钮，返回按钮
    private Button button_demo,button_back;
    //设置演示初始状态
    private boolean isDemo = false;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight);
        if(StartActivity.truePlay == true){
            PlayMusic();
        }
        //给ImageView控件赋值
        imageView = (ImageView)findViewById(R.id.iv_picture);
        //给按钮赋值
        button_demo = (Button)findViewById(R.id.btn_demo);
        button_back = (Button)findViewById(R.id.btn_back);
        //创建一个AnimationDrawable
        final AnimationDrawable animationDrawable = (AnimationDrawable)imageView.getBackground();
        //演示按钮监听
        button_demo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isDemo == false){
                    //点击此按钮isDemo变成true,并且播放动画
                    isDemo = true;
                    animationDrawable.start();
                }
                else {
                    //点击此按钮isDemo变成false,并且停止播放动画
                    isDemo = false;
                    animationDrawable.stop();
                }
            }
        });
        //给返回按钮赋值
        button_back = (Button)findViewById(R.id.btn_back);
        //设置按钮监听
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //页面跳转
                Intent intent = new Intent(EightActivity.this,ChoiceActivity.class);
                startActivity(intent);
            }
        });
    }
    //后台处理

    @Override
    protected void onStop() {
        super.onStop();
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }
    }
    //重新回到


    @Override
    protected void onRestart() {
        super.onRestart();
        if(StartActivity.truePlay == true){
            //播放音乐
            PlayMusic();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer!=null){
            //停止
            mediaPlayer.stop();
            //释放
            mediaPlayer.release();
            //赋值空
            mediaPlayer = null;
        }
    }

    //音乐播放
    private void PlayMusic(){
        //给媒体对象赋值
        mediaPlayer = MediaPlayer.create(EightActivity.this,R.raw.music8);
        //设置是否循环播放
        mediaPlayer.setLooping(true);
        //播放音乐
        mediaPlayer.start();
    }
}
