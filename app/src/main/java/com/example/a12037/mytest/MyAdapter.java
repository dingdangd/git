package com.example.a12037.mytest;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    List<String> mark_id;
    private String[] data;//定义数据。
    private Context mInflater;//定义Inflater,加载我们自定义的布局。
    private boolean allchoose;//定义是否全部选中
    /*
    定义构造器，在Activity创建对象Adapter的时候将数据data和Inflater传入自定义的Adapter中进行处理。
    */
    public MyAdapter(Context inflater, String[]  data, boolean allchoose){
        mInflater = inflater;
        data = data;
        allchoose=allchoose;
    }
    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        //获得ListView中的view
        View item_view = LayoutInflater.from(mInflater).inflate(R.layout.list_item,null);
        //获得自定义布局中每一个控件的对象。
        TextView name =item_view.findViewById(R.id.text);
        CheckBox checkBox=item_view.findViewById(R.id.check);
        name.setText(data[i]);
        if(allchoose){
            //只要显示全部选中就行  不需要记录数据
//            mark_id.add(data[i]);
            checkBox.setChecked(true);//需要在全选按钮选中的时候执行刷新操作
        }else {
            checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    //如果被选中则记录
                    if (b) {
                        mark_id.add(data[i]);
                    } else {//else则取消记录
                        if (mark_id.contains(data[i])) {
                            mark_id.remove(i);
                        }
                    }
                }

            });
        }


        return item_view ;
    }
}
