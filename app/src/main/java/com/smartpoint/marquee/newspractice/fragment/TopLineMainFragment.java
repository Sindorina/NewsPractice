package com.smartpoint.marquee.newspractice.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartpoint.marquee.newspractice.R;

/**
 * Created by Administrator on 2018/8/10
 * 邮箱 18780569202@163.com
 * 头条号
 */
public class TopLineMainFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test,container,false);
        initView(view);
        return view;
    }
    private void initView(View view){
        TextView textView = view.findViewById(R.id.textView);
        textView.setText("首页头条号");
    }
}
