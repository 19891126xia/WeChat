package com.example.lenovo.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Personal extends Activity {

    private List<Msg_contact> msglist=new ArrayList<>();
    Msg_contact Msg;
    private ImageView touxiang;
    private TextView mingzi;
    private TextView weixinhao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        touxiang=(ImageView)findViewById(R.id.touxiang);
        mingzi=(TextView)findViewById(R.id.mingzi);
        weixinhao=(TextView)findViewById(R.id.weixinhao);
        int index=(int)getIntent().getIntExtra("index",0);
        msglist = (List<Msg_contact>) getIntent().getSerializableExtra("message");
        Msg = msglist.get(index);
        touxiang.setImageResource(Msg.getId());
        mingzi.setText(Msg.getname());
        weixinhao.setText(Msg.getpinyin());
    }
}
