package com.smartpoint.marquee.newspractice.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.smartpoint.marquee.newspractice.R;
import com.smartpoint.marquee.newspractice.adapter.BasePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/10
 * 邮箱 18780569202@163.com
 * 首页新闻栏目
 */
public class NewsMainFragment extends Fragment implements View.OnClickListener{
    private View view;
    private TabLayout tab_layout_news;
    private ImageView add_channel_iv;
    private ViewPager view_pager_news;
    private List<Fragment> fragmentList;
    private BasePagerAdapter adapter;
    private List<String> newsTab;
    private LinearLayout header_layout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_tab2,container,false);
        initView();
        initData();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void initView(){
        tab_layout_news = view.findViewById(R.id.tab_layout_news);
        add_channel_iv  = view.findViewById(R.id.add_channel_iv);
        view_pager_news = view.findViewById(R.id.view_pager_news);
        add_channel_iv.setOnClickListener(this);
        header_layout = view.findViewById(R.id.header_layout);
        header_layout.setBackgroundColor(Color.parseColor("#FF4081"));
    }
    private void initData(){
        newsTab = new ArrayList<>();
        newsTab.add("推荐");
        newsTab.add("热点");
        newsTab.add("视频");
        newsTab.add("社会");
        newsTab.add("娱乐");
        newsTab.add("科技");
        newsTab.add("问答");
        newsTab.add("汽车");
        fragmentList = new ArrayList<>();
        fragmentList.add(new NewsRecomendFragment());
        fragmentList.add(new NewsHotFragment());
        fragmentList.add(new NewsVideoFragment());
        fragmentList.add(new NewsSocietyFragment());
        fragmentList.add(new NewsEntertainmentFragment());
        fragmentList.add(new NewsScienceFragment());
        fragmentList.add(new NewsAnswerFragment());
        fragmentList.add(new NewsCarsFragment());
        adapter = new BasePagerAdapter(getActivity().getSupportFragmentManager(),fragmentList,newsTab);
        tab_layout_news.setupWithViewPager(view_pager_news);
        tab_layout_news.setTabMode(TabLayout.MODE_SCROLLABLE);
        view_pager_news.setAdapter(adapter);
        view_pager_news.setOffscreenPageLimit(15);
    }

    @Override
    public void onClick(View v) {
        if (v==add_channel_iv){
            Toast.makeText(getContext(),"点击了添加按钮",Toast.LENGTH_SHORT).show();
        }
    }
}
