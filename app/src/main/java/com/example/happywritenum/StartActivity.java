package com.example.happywritenum;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {
    //声明开始游戏按钮，音乐开关按钮，关于作者按钮
    private Button button_play;
    private Button button_music;
    private Button button_author;
    //声明媒体对象
    private MediaPlayer mediaPlayer;
    //设置音乐初始状态，true为播放
    public static boolean truePlay = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //初始化按钮
        init();
        //进这个页面就放歌
        if(truePlay == true){
            PlayMusic();
            button_music.setBackgroundResource(R.drawable.btn_music1);
        }
        else {
            button_music.setBackgroundResource(R.drawable.btn_music2);
        }
        //设置按钮监听
        button_play.setOnClickListener(onClickListener);
        button_music.setOnClickListener(onClickListener);
        button_author.setOnClickListener(onClickListener);
    }
    //按钮初始化
    public void init(){
        button_play = (Button)findViewById(R.id.btn_play);
        button_music = (Button)findViewById(R.id.btn_music);
        button_author = (Button)findViewById(R.id.btn_author);
    }
    //按钮监听函数
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //创建一个意图
            Intent intent = null;
            switch (view.getId()){
                case R.id.btn_play:
                    //页面跳转
                    intent = new Intent(StartActivity.this,ChoiceActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_music:
                    //如果当前是播放状态
                    if(truePlay == true){
                        //点击此按钮停止播放
                        mediaPlayer.pause();
                        truePlay = false;
                        //设置图片资源
                        button_music.setBackgroundResource(R.drawable.btn_music2);
                    }else {
                        //点击此按钮播放
                        PlayMusic();
                        truePlay = true;
                        button_music.setBackgroundResource(R.drawable.btn_music1);
                    }
                    break;
                case R.id.btn_author:
                    //页面跳转
                    intent = new Intent(StartActivity.this,AuthorActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
    //后台处理

    @Override
    protected void onStop() {
        super.onStop();
        if(mediaPlayer!=null){
            //停止音乐
            mediaPlayer.stop();
        }
    }
    //重新回到这个界面处理
    @Override
    protected void onRestart() {
        super.onRestart();
        if(truePlay == true){
            //播放音乐
            PlayMusic();
        }
    }

    //销毁音乐
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer!=null){
            //停止音乐
            mediaPlayer.stop();
            //释放
            mediaPlayer.release();
            //设为null
            mediaPlayer = null;
        }
    }

    //播放音乐函数
    private void PlayMusic(){
        //给媒体对象赋值
        mediaPlayer = MediaPlayer.create(StartActivity.this,R.raw.main_music);
        //设置播放属性
        mediaPlayer.setLooping(true);
        //播放
        mediaPlayer.start();
    }
}

