package com.example.lenovo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Dialog extends AppCompatActivity {
    private List<Msg> msgList=new ArrayList<>();                                //声明List变量
    private EditText editText;                                                  //声明EdiText类变量
    private Button send;                                                        //声明Button类变量
    private RecyclerView recyclerView;                                          //声明recyclerView类变量
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
   //     initMsg();
        editText= (EditText) findViewById(R.id.input_Text);                     //获取组建，赋值给editText类变量
        send= (Button) findViewById(R.id.send_mess);                            //获取组建，赋值给send类变量
        recyclerView= (RecyclerView) findViewById(R.id.msg_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));           //创建显示方式
        adapter=new MyAdapter(msgList);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setAdapter(adapter);


        send.setOnClickListener(new View.OnClickListener() {                                        //btn发送消息
            public void onClick(View v) {
                String content=editText.getText().toString();                       //获取editext内容
                if(!"".equals(content))                                             //判断context是否是“”,或null
                {
                    Msg msg=new Msg(content,Msg.TYPE_SENT_FC);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size()-1);                   //有消息刷新显示
                    recyclerView.scrollToPosition(msgList.size()-1);                    //将list定位到最后一行
                    editText.setText("");
                }
            }});
    }


    private void initMsg()
    {
        Msg msg1 = new Msg("hello", Msg.TYPE_SENT_FC);
        msgList.add(msg1);

    }

}
