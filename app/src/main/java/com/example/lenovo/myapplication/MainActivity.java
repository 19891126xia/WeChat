package com.example.lenovo.myapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class MainActivity extends FragmentActivity {


    private Button msg_b;
    private Button dhb_b;
    private Button search_b;
    private Button me_b;
    private List<Msg> mMsgList=new ArrayList<>();

    private ViewPager viewPager;

    private LinearLayout wechatLayout,contactLayout,findLayout,profileLayout;
    private RecyclerView recyclerView;
    private DiaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msg_b = (Button) findViewById(R.id.msg_button);
        dhb_b = (Button) findViewById(R.id.dianhuabu_button);
        search_b = (Button) findViewById(R.id.search_button);
        me_b = (Button) findViewById(R.id.me_button);
        initView();
        initFragmentView();
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
        initMsg();
      /*  recyclerView= (RecyclerView) findViewById(R.id.main_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new DiaAdapter(mMsgList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int data) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,Dialog.class);
                startActivity(intent);
            }
        });*/



    }

    private void initMsg()
    {
        mMsgList.clear();
        Msg msg1 = new Msg("hello", Msg.TYPE_SENT_FC);
        mMsgList.add(msg1);
    }

    private void initParticular(){
        mMsgList.clear();
        Msg msg1 = new Msg("wangbing", Msg.TYPE_SENT_FC);
        mMsgList.add(msg1);

    }
  void initView(){

      wechatLayout = (LinearLayout) findViewById(R.id.msg);
      contactLayout = (LinearLayout) findViewById(R.id.dianhuabu);
      findLayout = (LinearLayout) findViewById(R.id.search);
      profileLayout = (LinearLayout) findViewById(R.id.me);
      msg_b.setBackgroundResource(R.mipmap.weixin_pressed);


      msg_b.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              viewPager.setCurrentItem(0);
              msg_b.setBackgroundResource(R.mipmap.weixin_pressed);
              dhb_b.setBackgroundResource(R.mipmap.contact_list_normal);
              search_b.setBackgroundResource(R.mipmap.find_normal);
              me_b.setBackgroundResource(R.mipmap.profile_normal);
          }
      });
      dhb_b.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              viewPager.setCurrentItem(1);
              msg_b.setBackgroundResource(R.mipmap.weixin_normal);
              dhb_b.setBackgroundResource(R.mipmap.contact_list_pressed);
              search_b.setBackgroundResource(R.mipmap.find_normal);
              me_b.setBackgroundResource(R.mipmap.profile_normal);
          }
      });
      search_b.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              viewPager.setCurrentItem(2);
              msg_b.setBackgroundResource(R.mipmap.weixin_normal);
              dhb_b.setBackgroundResource(R.mipmap.contact_list_normal);
              search_b.setBackgroundResource(R.mipmap.find_pressed);
              me_b.setBackgroundResource(R.mipmap.profile_normal);
          }
      });
      me_b.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              viewPager.setCurrentItem(3);
              msg_b.setBackgroundResource(R.mipmap.weixin_normal);
              dhb_b.setBackgroundResource(R.mipmap.contact_list_normal);
              search_b.setBackgroundResource(R.mipmap.find_normal);
              me_b.setBackgroundResource(R.mipmap.profile_pressed);
          }
      });

  }


    void initFragmentView() {
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new Fragment_wechat());
        fragments.add(new Fragment_contact());
        fragments.add(new Fragment_find());
        fragments.add(new Fragment_profile());
        FragmentAdapter fadapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(fadapter);

    }

        class FragmentAdapter extends FragmentPagerAdapter {
        private List<Fragment>mFragments;
        public FragmentAdapter(FragmentManager fm, List<Fragment>fragments){
            super(fm);
            this.mFragments=fragments;
        }

        @Override
        public void setPrimaryItem(ViewGroup container, int position, Object object) {
            super.setPrimaryItem(container, position, object);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageSelected(int position) {
            switch (position){

                //当前为页卡1
                case 0:
                    viewPager.setCurrentItem(0);
                    msg_b.setBackgroundResource(R.mipmap.weixin_pressed);
                    dhb_b.setBackgroundResource(R.mipmap.contact_list_normal);
                    search_b.setBackgroundResource(R.mipmap.find_normal);
                    me_b.setBackgroundResource(R.mipmap.profile_normal);
                    break;

                //当前为页卡2
                case 1:
                    viewPager.setCurrentItem(1);
                    msg_b.setBackgroundResource(R.mipmap.weixin_normal);
                    dhb_b.setBackgroundResource(R.mipmap.contact_list_pressed);
                    search_b.setBackgroundResource(R.mipmap.find_normal);
                    me_b.setBackgroundResource(R.mipmap.profile_normal);
                    break;

                //当前为页卡3
                case 2:
                    viewPager.setCurrentItem(2);
                    msg_b.setBackgroundResource(R.mipmap.weixin_normal);
                    dhb_b.setBackgroundResource(R.mipmap.contact_list_normal);
                    search_b.setBackgroundResource(R.mipmap.find_pressed);
                    me_b.setBackgroundResource(R.mipmap.profile_normal);
                    break;
                case 3:
                    viewPager.setCurrentItem(3);
                    msg_b.setBackgroundResource(R.mipmap.weixin_normal);
                    dhb_b.setBackgroundResource(R.mipmap.contact_list_normal);
                    search_b.setBackgroundResource(R.mipmap.find_normal);
                    me_b.setBackgroundResource(R.mipmap.profile_pressed);
                    break;
            }


        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}
