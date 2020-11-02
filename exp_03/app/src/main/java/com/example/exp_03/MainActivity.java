package com.example.exp_03;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import android.widget.Toast;

import java.util.ArrayList;

import  java.util.*;

public class MainActivity extends AppCompatActivity {

    private String[] names = new String[]{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] imageIds = new int[]{ R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    private int index=-9999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        List<Map<String,Object>> listItems = new ArrayList<>();
        for(int i = 0;i<names.length;i++){
            Map<String,Object> listItem = new HashMap<>();
            listItem.put("header",imageIds[i]);
            listItem.put("desc",names[i]);
            listItems.add(listItem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.simple_item,new String[]{"desc","header"},new int[]{R.id.desc,R.id.header});
        final ListView list = findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(index==-9999){
                    index = position;
                    view.setBackgroundColor(Color.RED);
                }
                else if(index == position){
                    index = -9999;
                    view.setBackgroundColor(Color.WHITE);
                }
                else{
                    list.getChildAt(index).setBackgroundColor(Color.WHITE);
                    view.setBackgroundColor(Color.RED);
                    index = position;
                }
                Toast toast = Toast.makeText(MainActivity.this,names[position],Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }


}
