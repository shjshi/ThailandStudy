package com.example.thailandstudy.two;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thailandstudy.LetterDetailActivity;
import com.example.thailandstudy.MainActivity;
import com.example.thailandstudy.R;
import com.example.thailandstudy.data.Letter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainTestActivity1 extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1_main);

        findView();

        //ListView 要顯示的內容
        String[] str = getResources().getStringArray(R.array.type);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                str);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainTestActivity1.this, LetterDetailActivity.class);
                intent.getIntExtra("type",position);
                startActivity(intent);
            }
        });

    }

    private void findView() {
        lv = findViewById(R.id.lv);
    }

}
