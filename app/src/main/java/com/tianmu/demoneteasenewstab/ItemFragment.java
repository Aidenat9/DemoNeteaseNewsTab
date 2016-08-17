package com.tianmu.demoneteasenewstab;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author TianMu on 2016/8/10 0010 23:04
 * @email
 */
public class ItemFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.itemfragment, container, false);
        TextView tView = (TextView) view.findViewById(R.id.textView);
        //在oncreate方法里//获取Activity传递过来的参数
        Bundle bundle = getArguments();
        String arg = bundle.getString("arg");
        tView.setText(arg);
        tView.setTextSize(28f);
        tView.setTextColor(Color.WHITE);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
