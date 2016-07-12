package com.example.kimminhyeok.list_view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kimminhyeok on 2016. 7. 13..
 */
public class ListViewAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    // 데이터 셋. 리스트에 표현될 데이터들은 모두 이곳에 존재한다. 나중에 DB가 대신해야 할 변수.
    private ArrayList<ListViewItem> mItemList = new ArrayList<ListViewItem>() ;

    // ListViewAdapter의 생성자
    public ListViewAdapter() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return mItemList.size() ;
    }

    // i번째 위치한 데이터를 화면에 출력하는데 사용될 Item들의 단일 View를 리턴. : 필수 구현
    // 즉 1개 아이템을 출력하는 함수.
    @Override
    public View getView(int i, View aItemView, ViewGroup parent) {
        final Context context = parent.getContext();

        // "show_item.xml" Layout을 inflate(*역자주:포장)하여 itemViews의 실체 얻기. 이후 단일 item을 만질 수 있습니다.
        // show_item.xml은 개발자가 item을 보여주고 싶은 형태로 따로 만들어야 합니다.
        if (aItemView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            aItemView = inflater.inflate(R.layout.show_item, parent, false);    //해당 view에 레이아웃(show_item(확장자ㄴㄴ))을 씌웁니다.
        }

        // 이제 aItemView에 값을 넣으면 됩니다.
        // 화면에 표시될 한 item View의 레이아웃이 가진 내부 뷰들의 id들을 잡습니다.
        // 어짜피 한번 반환하고나면 해당 뷰는 다시 설정할 일이 없으므로 잊어도 됨. 지역변수.
        TextView nameTextView = (TextView) aItemView.findViewById(R.id.item_name_text_view) ;
        TextView teamTextView = (TextView) aItemView.findViewById(R.id.item_team_text_view) ;

        // ItemList 에서 i번째 데이터 획득
        ListViewItem aItem = mItemList.get(i);

        // 아이템 뷰에 데이터 반영
        nameTextView.setText(aItem.getName());
        teamTextView.setText(aItem.getTeam());

        return aItemView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int i) {
        return i ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int i) {
        return mItemList.get(i) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String name, String team) {
        ListViewItem item = new ListViewItem();
        item.setName(name);
        item.setTeam(team);
        mItemList.add(item);
    }
}
