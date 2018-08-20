package com.example.lenovo.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Msg_contact implements Serializable{

    public  static final int TYPE_RECEIVED_SD=0;    //收到的消息标记
    public  static final int TYPE_SENT_FC=1;        //发出的消息标记
    private String pinyin;                        //消息内容
    private String name;
    private String first;
    private boolean islast;
    private int id;
    public Msg_contact(int id,String pinyin,String name,String first, boolean islast)           //声明两参构造方法，声明get set方法
    {
        this.pinyin=pinyin;
        this.name=name;
        this.name=name;
        this.first=first;
        this.islast=islast;
        this.id = id;
    }
    public String getpinyin() {
        return pinyin;
    }
    public void setpinyin(String pinyin) {
        this.pinyin = pinyin;
    }
    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }

    public String getfirst(){
        return first;
    }

    public void setfirst(String first){
        this.first = first;
    }

    public boolean getislast(){
        return islast;
    }

    public void setIslast(boolean islast){
        this.islast = islast;
    }

    public int getId(){return id;}
    public void setId(int id){
        this.id = id;
    }


}
