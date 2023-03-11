package com.wisky.thaistudygame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;


import java.util.List;

public class SearchActivity extends AppCompatActivity {
    SearchView sv;
//    Button bt;
    TextView tv;
    private List<Letter> letters;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initData();
        findView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
               for (Letter letter:letters){
                   if (letter.name.equals(query)){
                       tv.setText(letter.dec);
                   }
               }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        sv.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        sv.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

            }
        });
    }

    private void findView() {
        sv = findViewById(R.id.sv);
        sv.setSubmitButtonEnabled(true);
//        bt = findViewById(R.id.bt);
        tv = findViewById(R.id.tv);
    }

    private void initData() {
        String jsonStrs = JsonUtils.getFromAssets(this,"elements2.txt");
        letters = JsonUtils.getDataList(jsonStrs, Letter.class);
    }
}
