package com.example.lenovo.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

public class DiaAdapter extends RecyclerView.Adapter<DiaAdapter.ViewHolder> implements View.OnClickListener {

    private List<Msg> mMsgList;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public DiaAdapter(List<Msg> mMsgList){                                            //构造方法，传值为List<Msg>
        this.mMsgList=mMsgList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.diag_item,parent,false);
        System.out.println("this is onCreateViewHolder");

        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg=mMsgList.get(position);
        holder.itemView.setTag(position);
        holder.ItemLayout.setVisibility(View.VISIBLE);

    }

    public void onClick(View v) {
        System.out.println("this is click item");
        if (mOnItemClickListener != null) {      //getTag获取的即是点击位置
            System.out.println(v.getTag());
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout ItemLayout;
        public ViewHolder(View itemView){
            super(itemView);
            ItemLayout = (LinearLayout) itemView.findViewById(R.id.item_layout);
        }

    }
}
