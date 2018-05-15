package com.example.a12037.mytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private CheckBox allcheck;
    private Button bt;
    private MyAdapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //控件初始化
        Viewcount();
        //具体的实施步骤
        init();

    }
   public void  Viewcount(){
        listview=findViewById(R.id.listview);
        allcheck=findViewById(R.id.allcheck);
        bt=findViewById(R.id.sure);
    }
    public void init(){

      final String[]  datalist ={"18686000000110","18686000000111","18686000000112","18686000000113",
                    "18686000000114","18686000000115", "18686000000116","18686000000117",
                    "18686000000118","18686000000119"};
      //加载adapter
        myadapter=new MyAdapter(this,datalist,false);
        listview.setAdapter(myadapter);
        allcheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){


            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){//如果点击了 不管是否勾选
                    //先判断状态是狗被选中
                    if(allcheck.isChecked()){//如果是选中的状态  new MyAdapter(this,datalist,true);
                        myadapter=new MyAdapter(MainActivity.this,datalist,true);
                        listview.setAdapter(myadapter);
                    }else{
                        myadapter=new MyAdapter(MainActivity.this,datalist,false);
                        listview.setAdapter(myadapter);
                    }
                }
            }
        });
bt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(allcheck.isChecked()){
            //所有的id都传过去
            Toast.makeText(MainActivity.this,"全部id个数"+datalist.length,Toast.LENGTH_LONG).show();
        }else{//传递被标记的id
            String id_name="";
            for(int i=0;i<myadapter.mark_id.size();i++){
                id_name=id_name+myadapter.mark_id.get(i)+"\n";
            }
            Toast.makeText(MainActivity.this, id_name,Toast.LENGTH_LONG).show();
        }
    }
});

    }
}
