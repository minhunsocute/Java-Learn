package com.example.mylistviewweek04;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mylistviewweek04.Constant.Resources;
import com.example.mylistviewweek04.Model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {
     TextView title = null;
     List<User> listUser = null;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String userNames = "ABCDEFGHYJK";

        listUser = new ArrayList<>();
        listUser.add(new User(
            "Nguyen Minh Hung",
            "09357.03991",
                        R.drawable.face
        ));
        listUser.add(new User(
                "Truong Huynh Duc Hoang",
                "09357.03991",
                R.drawable.hoang
        ));
        listUser.add(new User(
                "Nguyen Trung Hieu",
                "09357.03991",
                R.drawable.gmail
        ));
        for(int i = 0; i< userNames.length(); i++){
            String avatar_name="avatar_" +(int)Math.ceil(Math.random() * 2);
            listUser.add(new User("Nguyen Minh " + userNames.charAt(i),
                    randomPhone(10),
                    Resources.getDrawableByName(this, avatar_name)));
        }
        title = (TextView) findViewById(R.id.title);
        RowItem adapter= new RowItem(this, R.layout.activity_row_item,listUser);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v , int position, long id ){
        super.onListItemClick(l, v, position, id);
        title.setText("You choose: " + listUser.get(position).getName());
    }

    private String randomPhone(int n) {
        StringBuffer phone = new StringBuffer("");
        for (int i = 0; i < n; i++) {
            phone.append(Math.round(Math.random() * 9));
        }
        return phone.toString();
    }

}

