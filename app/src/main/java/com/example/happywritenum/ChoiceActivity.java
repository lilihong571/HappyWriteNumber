package com.example.happywritenum;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

public class ChoiceActivity extends AppCompatActivity {
    //声明返回按钮
    private Button button_back;
    //声明一个媒体对象
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        if(StartActivity.truePlay == true){
            //播放音乐
            PlayMusic();
        }
        //给返回按钮赋值
        button_back = (Button)findViewById(R.id.btn_back);
        //设置按钮监听
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //页面跳转
                Intent intent = new Intent(ChoiceActivity.this,StartActivity.class);
                startActivity(intent);
            }
        });
        //创建一个适配器
        MyAdapter myAdapter = new MyAdapter(ChoiceActivity.this);
        //绑定 视图
        GridView gridView = (GridView)findViewById(R.id.gv_view);
        //设置监听事件
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //创建意图
                Intent intent = null;
                switch (i){
                    case 0:
                        intent = new Intent(ChoiceActivity.this,OneActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(ChoiceActivity.this,TwoActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(ChoiceActivity.this,ThreeActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(ChoiceActivity.this,FourActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(ChoiceActivity.this,FiveActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(ChoiceActivity.this,SixActivity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(ChoiceActivity.this,SevenActivity.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(ChoiceActivity.this,EightActivity.class);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(ChoiceActivity.this,NineActivity.class);
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent(ChoiceActivity.this,ZeroActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
        //设置适配器
        gridView.setAdapter(myAdapter);
    }
    //后台处理函数

    @Override
    protected void onStop() {
        super.onStop();
        if(mediaPlayer!=null){
            //停止播放
            mediaPlayer.stop();
        }
    }
    //重新回到这个界面


    @Override
    protected void onRestart() {
        super.onRestart();
        if(StartActivity.truePlay == true){
            //播放音乐
            PlayMusic();
        }
    }
    //销毁函数


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer!=null){
            //停止播放
            mediaPlayer.stop();
            //释放
            mediaPlayer.release();
            //设为空
            mediaPlayer = null;
        }
    }

    //播放函数
    private void PlayMusic(){
        //给媒体对象赋值
        mediaPlayer = MediaPlayer.create(ChoiceActivity.this,R.raw.number_music);
        //设置播放属性
        mediaPlayer.setLooping(true);
        //播放音乐
        mediaPlayer.start();
    }
}
