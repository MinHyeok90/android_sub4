package com.example.kimminhyeok.list_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

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

        mListView.setOnItemClickListener(listener);


        //adapter와 listview 연결.
        mListView.setAdapter(mAdapter);

        //현재까지 내용 출력.
        for(int i =0; i<mAdapter.getCount(); i++){
//            mAdapter.addItem();
        }
    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        //ListView의 아이템 중 하나가 클릭될 때 호출되는 메소드
        //첫번째 파라미터 : 클릭된 아이템을 보여주고 있는 AdapterView 객체(여기서는 ListView객체)
        //두번째 파라미터 : 클릭된 아이템 뷰
        //세번째 파라미터 : 클릭된 아이템의 위치(ListView이 첫번째 아이템(가장위쪽)부터 차례대로 0,1,2,3.....)
        //네번재 파리미터 : 클릭된 아이템의 아이디(특별한 설정이 없다면 세번째 파라이터인 position과 같은 값)
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(MainActivity.this, mAdapter.getItem(i).toString(), Toast.LENGTH_SHORT).show();

        }
    };

    public void onClick(View view){
        Intent intent = new Intent(
                getApplicationContext() //현재화면
                ,ItemDetail.class);     //다음 넘어갈 클래스 지정.
        startActivity(intent);  //다음 화면으로 변경.

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
