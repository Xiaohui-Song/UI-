package com.example.exp_03;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    //字体大小标识
    private static final int FONT_10 = 0x111;
    private static final int FONT_16 = 0x112;
    private static final int FONT_20 = 0x113;
    //普通菜单项标识
    private static final int PLAIN_ITEM = 0x11b;
    //颜色标识
    private static final int FONT_RED = 0x114;
    private static final int FONT_BLACK = 0x115;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exp_03);
        text = findViewById(R.id.txt);
    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        //向menu中添加 字体大小 子菜单
        SubMenu fontMenu = menu.addSubMenu("字体大小");
        //设置子菜单头标题
        fontMenu.setHeaderTitle("选择字体大小");
        fontMenu.add(0,FONT_10,0,"10号字体");
        fontMenu.add(0,FONT_16,0,"16号字体");
        fontMenu.add(0,FONT_20,0,"20号字体");
        menu.add(0,PLAIN_ITEM,0,"普通菜单项");
        SubMenu colorMenu = menu.addSubMenu("字体颜色");
        colorMenu.setHeaderTitle("选择文字颜色");
        colorMenu.add(0,FONT_RED,0,"红色");
        colorMenu.add(0,FONT_BLACK,0,"黑色");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem mi){

        switch (mi.getItemId()){
            case FONT_10: text.setTextSize(10*2); break;
            case FONT_16: text.setTextSize(16*2); break;
            case FONT_20: text.setTextSize(20*2); break;
            case FONT_BLACK: text.setTextColor(Color.BLACK); break;
            case FONT_RED: text.setTextColor(Color.RED); break;
            case PLAIN_ITEM:
                Toast.makeText(Main3Activity.this,"单击普通菜单项",Toast.LENGTH_SHORT)
                        .show();
                break;
        }
        return true;
    }
}
