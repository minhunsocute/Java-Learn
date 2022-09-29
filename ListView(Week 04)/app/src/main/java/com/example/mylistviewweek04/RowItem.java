package com.example.mylistviewweek04;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.example.mylistviewweek04.Model.User;

import java.util.ArrayList;
import java.util.List;

public class RowItem extends ArrayAdapter<String> {

    private Context context;
    private List<User>  users;


    @RequiresApi(api = Build.VERSION_CODES.N)
    public RowItem(Context context, int layoutToBeInflated, List<User> items){
        super(context,
                R.layout.activity_row_item,
                items.stream().map(user -> user.getName()).toArray(String[]::new)
        );
        this.context = context;
        this.users = items;
    }

    public ArrayList<String> getListName(List<User> arr){
        ArrayList<String> result = new ArrayList<>();
        if(arr.isEmpty()){
            return new ArrayList<>();
        }
        for(User item : arr){
            result.add(item.getName());
        }
        return result;
    }
    @Override
    public View getView(int position, View convertView , ViewGroup parent){
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.activity_row_item, null);
        ImageView avatar = (ImageView) row.findViewById(R.id.avatar);
        TextView name = (TextView) row.findViewById(R.id.name);
        TextView phone = (TextView) row.findViewById(R.id.phone);

        User user= users.get(position);
        name.setText(user.getName());
        phone.setText(user.getPhoneNumber());
        avatar.setImageResource(user.getAvatar());

        return (row);
    }
}

