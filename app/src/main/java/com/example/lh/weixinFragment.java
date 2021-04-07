package com.example.lh;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class weixinFragment extends Fragment {

    RecyclerView recyclerView;
    Context context;
    private List<String> list;
    MyAdpter myadpter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.tab01,container,false);
        recyclerView = view.findViewById(R.id.recyclerView);

        context = this.getContext();
        list = new ArrayList<String>();
        for (int i=0;i<9;i++){
            list.add("这是第"+ i +"个测试例子");
        }

        myadpter = new MyAdpter(context,list);
        LinearLayoutManager Manager = new LinearLayoutManager(context);
        Manager.setOrientation(RecyclerView.VERTICAL);

        recyclerView.setLayoutManager(Manager);
        recyclerView.setAdapter(myadpter);
        return view;
    }
}