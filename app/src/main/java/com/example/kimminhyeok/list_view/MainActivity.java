package com.example.kimminhyeok.list_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    ListViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new ListViewAdapter();
        mListView = (ListView) findViewById(R.id.main_list_view);
        mListView.setEmptyView(findViewById(R.id.empty));

        //adapter와 listview 연결.
        mListView.setAdapter(mAdapter);

        //현재까지 내용 출력.
        for(int i =0; i<mAdapter.getCount(); i++){
//            mAdapter.addItem();
        }
    }

    public void save(View view){
        EditText name = (EditText) findViewById(R.id.name_text_view);
        EditText team = (EditText) findViewById(R.id.team_text_view);

        mAdapter.addItem(name.getText().toString(), team.getText().toString());
        mAdapter.notifyDataSetChanged();
        name.setText("");
        team.setText("");

    }
}
