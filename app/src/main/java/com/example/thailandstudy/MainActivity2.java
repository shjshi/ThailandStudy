package com.example.thailandstudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bt_middle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, LetterDetailActivity.class);
                intent.putExtra("id", 0);
                startActivity(intent);
            }
        });

        findViewById(R.id.bt_high).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, LetterDetailActivity.class);
                intent.putExtra("id", 1);
                startActivity(intent);
            }
        });

        findViewById(R.id.bt_even_low).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity2.this, LetterDetailActivity.class);
                intent.putExtra("id", 2);
                startActivity(intent);
            }
        });

    }
}