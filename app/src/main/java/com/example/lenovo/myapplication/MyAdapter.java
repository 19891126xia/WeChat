package com.example.lenovo.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<Msg> mMsgList;

    public MyAdapter(List<Msg> msgList){                                            //构造方法，传值为List<Msg>
        this.mMsgList=msgList;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.send_msg,parent,false);
        System.out.println("this is onCreateViewHolder");
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        Msg msg=mMsgList.get(position);
        System.out.println("this is onBindViewHolde");

        if(msg.getType() == Msg.TYPE_RECEIVED_SD) {
            holder.leftLayout.setVisibility(View.VISIBLE);                          //设置左侧消息框可见
            holder.rightLayout.setVisibility(View.GONE);                            //设置右侧消息框隐藏
            holder.leftMsg.setText(msg.getContent());                               //设置接收到的内容
        }else if(msg.getType()==Msg.TYPE_SENT_FC)                                   //如果是发出消息 显示右侧消息，隐藏左侧消息
            {
                holder.leftLayout.setVisibility(View.GONE);                             //设置左侧消息框可见
                holder.rightLayout.setVisibility(View.VISIBLE);                         //设置右侧消息框隐藏
                holder.rightMsg.setText(msg.getContent());                              //设置发送消息

        }
    }

    @Override
    public int getItemCount() {
        System.out.println("this is getitemcount");
        return mMsgList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout leftLayout,rightLayout;
        TextView leftMsg,rightMsg;
        public ViewHolder(View itemView) {
            super(itemView);

            System.out.println("this is viewholder");
            leftLayout= (LinearLayout) itemView.findViewById(R.id.left_layout);
            rightLayout= (LinearLayout) itemView.findViewById(R.id.right_layout);
            leftMsg= (TextView) itemView.findViewById(R.id.receive_msg);
            rightMsg= (TextView) itemView.findViewById(R.id.send_msg);
        }
    }
}