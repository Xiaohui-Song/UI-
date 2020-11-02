package com.example.exp_03;

import android.graphics.Color;
import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.view.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class Main4Activity extends AppCompatActivity {

    private String[] names = new String[]{"one","two","three","four","five"};
    private int[] image_id = new int[]{R.drawable.robot};
    private int[] index = new int[]{1,1,1,1,1};
    public int num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exp_04);
        List<Map<String,Object>> listItems = new ArrayList<>();
        for (int i = 0 ;i<names.length;i++){
            Map<String,Object> listItem = new HashMap<>();
            listItem.put("pictures",image_id[0]);
            listItem.put("name",names[i]);
            listItems.add(listItem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.exp_04_item,
                new String[]{"pictures","name"},new int[]{R.id.exp4_pic,R.id.exp4_text});
        final ListView list = findViewById(R.id.exp_04_list);
        list.setAdapter(simpleAdapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(index[position]%2==1){
                    view.setBackgroundColor(Color.LTGRAY);
                    index[position] += 1;
                    num +=1;
                }
                else if(index[position]%2==0){
                    view.setBackgroundColor(Color.WHITE);
                    index[position] +=1 ;
                    num -= 1;
                }
            }
        });

        //设置listview允许多选模式
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        list.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                mode.setTitle(""+num+" Selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.exp_04_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }

}
