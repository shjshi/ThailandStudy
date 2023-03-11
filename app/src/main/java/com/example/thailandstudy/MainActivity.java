package com.example.thailandstudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.example.thailandstudy.data.Letter;
import com.example.thailandstudy.two.MainTestActivity1;
import com.example.thailandstudy.utils.JsonUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private List<Letter> letters;
    private SearchView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

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
                Intent intent = new Intent(MainActivity.this, LetterDetailActivity.class);
                intent.putExtra("type",position);
                startActivity(intent);
            }
        });

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                intent.putExtra("query",query);
                startActivity(intent);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    private void findView() {
        lv = findViewById(R.id.lv);
        sv = findViewById(R.id.sv);
        sv.setSubmitButtonEnabled(true);
    }


//    private void initData() {
//        String jsonStrs = JsonUtils.getFromAssets(this,"elements2.txt");
//        letters = JsonUtils.getDataList(jsonStrs, Letter.class);
//    }
}