package com.example.exp_03;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.*;


public class Main2Activity extends AppCompatActivity {
    private TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void customView(View source){
        //加载设置好的布局 onclick绑定该事件
        LinearLayout login = (LinearLayout)getLayoutInflater().inflate(R.layout.exp_02,null);
        new AlertDialog.Builder(Main2Activity.this)
                .setView(login)
                .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();
    }

}
