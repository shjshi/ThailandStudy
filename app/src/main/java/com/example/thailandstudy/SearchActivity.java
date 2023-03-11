package com.wisky.thaistudygame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;


import com.example.thailandstudy.R;
import com.example.thailandstudy.data.Letter;
import com.example.thailandstudy.utils.JsonUtils;

import java.util.List;

public class SearchActivity extends AppCompatActivity {
//    SearchView sv;
//    Button bt;
    TextView tv;
    private List<Letter> letters;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initData();
        findView();

        Intent intent = getIntent();
        String query = intent.getStringExtra("query");
        setTitle(query);
        for (Letter letter:letters){
            if (letter.name.equals(query)){
                tv.setText(letter.dec);
            }
        }
    }

    private void findView() {
//        sv = findViewById(R.id.sv);
//        sv.setSubmitButtonEnabled(true);
        tv = findViewById(R.id.tv);
    }

    private void initData() {
        String jsonStrs = JsonUtils.getFromAssets(this,"elements2.txt");
        letters = JsonUtils.getDataList(jsonStrs, Letter.class);
    }
}
