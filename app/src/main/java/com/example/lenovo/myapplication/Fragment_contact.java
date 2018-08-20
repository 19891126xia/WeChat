package com.example.lenovo.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_contact.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_contact#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_contact extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private CntactAdapter adapter;
    private List<Msg_contact> mMsgList=new ArrayList<>();
    private List<Msg_contact> mMsgList2=new ArrayList<>();
    final Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {
                initMsg();
                adapter.notifyItemInserted(mMsgList2.size()-1);
            }
        }
    };


    private final static int[] li_SecPosValue = { 1601, 1637, 1833, 2078, 2274,
            2302, 2433, 2594, 2787, 3106, 3212, 3472, 3635, 3722, 3730, 3858,
            4027, 4086, 4390, 4558, 4684, 4925, 5249, 5590 };
    private final static String[] lc_FirstLetter = { "a", "b", "c", "d", "e",
            "f", "g", "h", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",

            "t", "w", "x", "y", "z" };


    public Fragment_contact() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_contact.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_contact newInstance(String param1, String param2) {
        Fragment_contact fragment = new Fragment_contact();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);


        recyclerView= (RecyclerView) view.findViewById(R.id.contact_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL,false));
        adapter=new CntactAdapter(mMsgList2);
        recyclerView.setAdapter(adapter);
        new Thread(new Runnable() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(100);
            }
        }).start();
        adapter.setOnItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int data) {
                Intent intent=new Intent();
                intent.setClass(getActivity(), Personal.class);
                intent.putExtra("index",data);
                intent.putExtra("message", (Serializable) mMsgList2);
                startActivity(intent);
            }
        });
        return view;
    }

    private void initMsg()
    {
        mMsgList.clear();
        mMsgList2.clear();
        String[] sortArray = {"闰土","金三胖" ,"赵四","赵玉田", "谢广坤", "刘能", "王小蒙","谢大脚","奔波儿灞","马云","马化腾","王大拿","王冰"};

        Msg_contact msg;

        msg = new Msg_contact(R.mipmap.runtu,"runtu","闰土"," ",false);
        mMsgList.add(msg);
        msg = new Msg_contact(R.mipmap.jinsanpang,"jinsanpang","金三胖"," ",false);
        mMsgList.add(msg);
        msg = new Msg_contact(R.mipmap.zhaosi,"zhaosi","赵四"," ",false);
        mMsgList.add(msg);
        msg = new Msg_contact(R.mipmap.zhaoyutian,"zhaoyutian","赵玉田"," ",false);
        mMsgList.add(msg);
        msg = new Msg_contact(R.mipmap.xieguangkun,"xieguangkun","谢广坤"," ",false);
        mMsgList.add(msg);
        msg = new Msg_contact(R.mipmap.liuneng,"liuneng","刘能"," ",false);
        mMsgList.add(msg);
        msg = new Msg_contact(R.mipmap.wangxiaomeng,"wangxiaomeng","王小蒙"," ",false);
        mMsgList.add(msg);
        msg = new Msg_contact(R.mipmap.xiedajiao,"xiedajiao","谢大脚"," ",false);
        mMsgList.add(msg);
        msg = new Msg_contact(R.mipmap.benboerba,"benboerba","奔波儿灞"," ",false);
        mMsgList.add(msg);
        msg = new Msg_contact(R.mipmap.mayun,"mayun","马云"," ",false);
        mMsgList.add(msg);
        msg = new Msg_contact(R.mipmap.mahuateng,"mahuateng","马化腾"," ",false);
        mMsgList.add(msg);
        msg = new Msg_contact(R.mipmap.wangdana,"wangdana","王大拿"," ",false);
        mMsgList.add(msg);
        msg = new Msg_contact(R.mipmap.wangbing,"wangbing","王冰"," ",false);
        mMsgList.add(msg);
        arraySort(mMsgList);


        msg = new Msg_contact(R.mipmap.xindepengyou,"xindepengyou","新的朋友"," ",false);
        mMsgList2.add(msg);
        msg = new Msg_contact(R.mipmap.qunliao,"qunliao","群聊"," ",false);
        mMsgList2.add(msg);
        msg = new Msg_contact(R.mipmap.gongzhonghao,"gongzhonghao","公众号"," ",false);
        mMsgList2.add(msg);
        msg = new Msg_contact(R.mipmap.biaoqian,"biaoqian","标签","b",true);
        mMsgList2.add(msg);
        for(int i =0;i<mMsgList.size();i++){
            msg = mMsgList.get(i);
            mMsgList2.add(msg);
        }
        String strs = PinyinUtils.getPingYin("Hello");
        System.out.println(strs);

      //  String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray('金');
      //  for(int i = 0;i < pinyinArray.length;i++) {
      //      System.out.println(pinyinArray[i]);
      //  }
    }


    public void arraySort(List<Msg_contact>  array) {

        Msg_contact msg1;
        boolean islast;
        String first;

//        Comparator<Object> com= Collator.getInstance(java.util.Locale.CHINA);
 //       Arrays.sort(array,com);
        Collections.sort(array, new Comparator<Msg_contact>() {
            @Override
            public int compare(Msg_contact o1, Msg_contact o2) {
 //               Comparator<Object> com = Collator.getInstance(java.util.Locale.CHINA);
                return o1.getpinyin().compareTo(o2.getpinyin());

            }
        });
        String fs;
        for (int i = 0; i < array.size(); i++) {

             first = getAllFirstLetter(array.get(i).getpinyin());
            if ( i < array.size() -1)
               fs = getAllFirstLetter(array.get(i+1).getpinyin());
            else
                fs = getAllFirstLetter(array.get(i).getpinyin());
            if (first.equals(fs)){
                islast=false;
            }else{
                islast = true;
            }
            array.get(i).setfirst(fs);
            array.get(i).setIslast(islast);
        }
    }

    public String getAllFirstLetter(String str) {
        if (str == null || str.trim().length() == 0) {
            return "";
        }

        String _str = "";
        for (int i = 0; i < str.length(); i++) {
            _str = _str + this.getFirstLetter(str.substring(i, i + 1));
        }

        return this.getFirstLetter(str.substring(0, 1));
    }


    public String getFirstLetter(String chinese) {
        if (chinese == null || chinese.trim().length() == 0) {
            return "";
        }
        chinese = this.conversionStr(chinese, "GB2312", "ISO8859-1");

        if (chinese.length() > 1) // 判断是不是汉字
        {
            int li_SectorCode = (int) chinese.charAt(0); // 汉字区码
            int li_PositionCode = (int) chinese.charAt(1); // 汉字位码
            li_SectorCode = li_SectorCode - 160;
            li_PositionCode = li_PositionCode - 160;
            int li_SecPosCode = li_SectorCode * 100 + li_PositionCode; // 汉字区位码
            if (li_SecPosCode > 1600 && li_SecPosCode < 5590) {
                for (int i = 0; i < 23; i++) {
                    if (li_SecPosCode >= li_SecPosValue[i]
                            && li_SecPosCode < li_SecPosValue[i + 1]) {
                        chinese = lc_FirstLetter[i];
                        break;
                    }
                }
            } else // 非汉字字符,如图形符号或ASCII码
            {
                chinese = this.conversionStr(chinese, "ISO8859-1", "GB2312");
                chinese = chinese.substring(0, 1);
            }
        }

        return chinese;
    }


    private String conversionStr(String str, String charsetName,String toCharsetName) {
        try {
            str = new String(str.getBytes(charsetName), toCharsetName);
        } catch (UnsupportedEncodingException ex) {
            System.out.println("字符串编码转换异常：" + ex.getMessage());
        }
        return str;
    }

}
