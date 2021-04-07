package com.example.lh;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout tabweixin;
    LinearLayout tabfriend;
    LinearLayout tabtxl;
    LinearLayout tabsetting;

    FragmentManager fragmentManager;

    ImageView imgweixin;
    ImageView imgfriend;
    ImageView imgtxl;
    ImageView imgsetting;


    private Fragment tab01 = new weixinFragment();
    private Fragment tab02 = new frendFragment();
    private Fragment tab03 = new txlFragment();
    private Fragment tab04 = new settingFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_main);

        tabweixin = findViewById(R.id.td_tab_weixin);
        tabfriend = findViewById(R.id.td_tab_friend);
        tabtxl = findViewById(R.id.td_tab_txl);
        tabsetting = findViewById(R.id.td_tab_setting);

        imgweixin = findViewById(R.id.imageView1);
        imgfriend = findViewById(R.id.imageView2);
        imgtxl = findViewById(R.id.imageView3);
        imgsetting =findViewById(R.id.imageView4);


        initFragment();


        tabweixin.setOnClickListener(this);
        tabfriend.setOnClickListener(this);
        tabtxl.setOnClickListener(this);
        tabsetting.setOnClickListener(this);

        SelectTab(0);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.td_tab_weixin:
                Log.v("lh","第一个tab被点击1");
                SelectTab(0);
                break;
            case R.id.td_tab_friend:
                Log.v("lh","第二个tab被点击");
                SelectTab(1);
                break;
            case R.id.td_tab_txl:
                Log.v("lh","第三个tab被点击");
                SelectTab(2);
                break;
            case R.id.td_tab_setting:
                Log.v("lh","第四个tab被点击");
                SelectTab(3);
                break;
            default:
                break;
        }

    }


    private void SelectTab(int i) {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        hideImg();
        hideFragment(transaction);


        switch (i){
            case 0:
                transaction.show(tab01);
                imgweixin.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                transaction.show(tab02);
                imgfriend.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                transaction.show(tab03);
                imgtxl.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                transaction.show(tab04);
                imgsetting.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
                break;
        }
        transaction.commit();
    }
    public void initFragment(){
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.content,tab01);
        transaction.add(R.id.content,tab02);
        transaction.add(R.id.content,tab03);
        transaction.add(R.id.content,tab04);
        
        transaction.commit();

    }
    private void hideFragment(FragmentTransaction transaction) {
        transaction.hide(tab01);
        transaction.hide(tab02);
        transaction.hide(tab03);
        transaction.hide(tab04);
    }
    private  void hideImg(){
        imgweixin.setImageResource(R.drawable.tab_weixin_normal);
        imgfriend.setImageResource(R.drawable.tab_find_frd_normal);
        imgtxl.setImageResource(R.drawable.tab_address_normal);
        imgsetting.setImageResource(R.drawable.tab_settings_normal);
    }


}
