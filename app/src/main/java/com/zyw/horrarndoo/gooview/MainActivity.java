package com.zyw.horrarndoo.gooview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.zyw.horrarndoo.gooview.view.GooViewAapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GooViewAapter adapter;
    private List<String> list = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setFullScreen(true);
        setContentView(R.layout.activity_main);
        init();
    }

    protected void setFullScreen(boolean on) {
        Window win = getWindow();

        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_FULLSCREEN;

        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }

        win.setAttributes(winParams);

    }

    private void init(){
        for (int i = 0; i < 120; i++){
            list.add("content - " + i);
        }
        adapter = new GooViewAapter(MainActivity.this, list);
        ListView listView= (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
