package com.example.lenovo.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.myapplication.GameActivity;
import com.example.lenovo.myapplication.R;


public class GameMain extends Activity implements Button.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_main);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if(viewId == R.id.btnGame){
            startGame();
        }
    }

    public void startGame(){
        Intent intent = new Intent();
        intent.setClass(GameMain.this, GameActivity.class);
        startActivity(intent);
    }
}