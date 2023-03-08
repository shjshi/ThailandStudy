package com.example.thailandstudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.thailandstudy.data.Letter;
import com.example.thailandstudy.utils.JsonUtils;

import java.util.List;

public class LetterDetailActivity extends AppCompatActivity {
    private List<Letter> letters;
    private TextView tv_symbol;
    private ImageView iv_symbol;
    private TextView tv_ele;
    private TextView tv_tone;
    private TextView tv_combine;
    private TextView tv_vowel_tone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();

        initData();

        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);

        Letter letter = letters.get(id);
        setTitle(letter.name);
        tv_symbol.setText(letter.symbol);

        tv_ele.setText(letter.elements);
        tv_tone.setText(letter.tone);
        tv_combine.setText(letter.combine);
//        tv_combine.setText(letter.vow);

        tv_ele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv_symbol.getVisibility() == View.GONE){
                    tv_symbol.setVisibility(View.VISIBLE);
                    iv_symbol.setVisibility(view.VISIBLE);
                }else{
                    tv_symbol.setVisibility(View.GONE);
                    iv_symbol.setVisibility(view.GONE);
                }

            }
        });

        tv_combine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv_vowel_tone.getVisibility() == View.GONE){
                    tv_vowel_tone.setVisibility(View.VISIBLE);
                }else{
                    tv_vowel_tone.setVisibility(View.GONE);
                }

            }
        });
    }

    private void initView() {
        tv_symbol = findViewById(R.id.symbol);
        tv_ele = findViewById(R.id.elements);
        tv_tone = findViewById(R.id.tone);
        tv_combine = findViewById(R.id.combine);
        tv_vowel_tone = findViewById(R.id.vowel_tone);
        iv_symbol = findViewById(R.id.iv_symbol);
    }

    private void initData() {
        String jsonStrs = JsonUtils.getFromAssets(this,"datas_json.txt");
        letters = JsonUtils.getDataList(jsonStrs, Letter.class);
    }
}
