package com.example.lenovo.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.myapplication.zxing.activity.CaptureActivity;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_find.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_find#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_find extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView youxi;
    private TextView circlefriend;
    private TextView jiaweisi;
    private TextView bottle;
    private TextView saoyisao;
    private TextView yaoyiyao;

    public Fragment_find() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_find.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_find newInstance(String param1, String param2) {
        Fragment_find fragment = new Fragment_find();
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
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        youxi = (TextView) view.findViewById(R.id.youxi_tx);
        circlefriend = (TextView) view.findViewById(R.id.pengyou_tx);
        jiaweisi = (TextView) view.findViewById(R.id.jiaweisi_tx);
        bottle = (TextView) view.findViewById(R.id.ping_tx);
        saoyisao =(TextView)view.findViewById(R.id.saoyisao_tx);
        yaoyiyao=(TextView)view.findViewById(R.id.yaoyiyao_tx);
        youxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(), GameMain.class);
                startActivity(intent);
            }
        });

        circlefriend.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent intent =new Intent();
                intent.setClass(getActivity(),CircleFrend.class);
                startActivity(intent);
            }
        });

        jiaweisi.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent intent =new Intent();
                intent.setClass(getActivity(),JiaWeiSi.class);
                startActivity(intent);
            }
        });

        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setClass(getActivity(),FloatBottle.class);
                startActivity(intent);
            }
        });

        yaoyiyao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),ShakeActivity.class);
                startActivity(intent);
            }
        });
        saoyisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, 1);
                } else {
                    Intent intent = new Intent(getActivity(), CaptureActivity.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }

}
