package com.example.lenovo.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class CntactAdapter extends RecyclerView.Adapter<CntactAdapter.ViewHolder> implements View.OnClickListener{

    private List<Msg_contact> mMsgList;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    Msg_contact msg_contact;
    public CntactAdapter(List<Msg_contact> msgList){                                            //构造方法，传值为List<Msg>
        this.mMsgList=msgList;}

    @Override
    public CntactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cotact_item,parent,false);
        System.out.println("this is content creatview");
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CntactAdapter.ViewHolder holder, int position) {

        holder.itemView.setTag(position);
         msg_contact=  mMsgList.get(position);
  //      int id = R.mipmap.xindepengyou;
        LinearLayout.LayoutParams para= (LinearLayout.LayoutParams) holder.contact_fengxi.getLayoutParams();
         if (msg_contact.getislast())
           {
               para.height = 60;
               holder.textView.setText(msg_contact.getfirst().toUpperCase());
           }else {
             para.height = 1;
         }
         holder.contact_name.setText(msg_contact.getname());
         holder.contact_fengxi.setLayoutParams(para);
         holder.contact_layout.setVisibility(View.VISIBLE);
         holder.contact_icon.setImageResource(msg_contact.getId());
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }

    @Override
    public void onClick(View v) {
        System.out.println("this is click item");
        if (mOnItemClickListener != null) {      //getTag获取的即是点击位置
            System.out.println(v.getTag());
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        System.out.println("this is listener");
        this.mOnItemClickListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout contact_layout,contact_fengxi;

        TextView contact_name,textView;
        View head;
        ImageView contact_icon;

        public ViewHolder(View itemview){
            super(itemview);
            contact_name =(TextView) itemview.findViewById(R.id.contact_name);
            textView = (TextView) itemview.findViewById(R.id.text_fengexian);
            contact_layout = (LinearLayout) itemview.findViewById(R.id.contact_layout);
            contact_fengxi=(LinearLayout) itemview.findViewById(R.id.contact_fengexian);
            contact_icon=(ImageView)itemview.findViewById(R.id.contact_icon);
        }

    }

}
