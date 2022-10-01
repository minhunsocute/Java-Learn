package com.example.restaurantapp.Activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurantapp.Domain.FoodDomain;
import com.example.restaurantapp.R;

public class ShowDetailActivity extends AppCompatActivity {
    private Button addToCartBtn;
    private TextView name, fee, description,numberOrder;
    private ImageView plusBtn, minusBtn,picFood;
    private FoodDomain select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
//        initView();
//        getBundle();
    }

    private void getBundle(){
        select = (FoodDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId = this.getResources().getIdentifier(select.getPic(), "drawable", this.getPackageName());
        picFood.setImageResource(drawableResourceId);
        name.setText(select.getTitle());
        fee.setText(String.valueOf(select.getFee()));
        description.setText(select.getDescription());
    }

    private void initView(){
        name = findViewById(R.id.detailName);
        fee = findViewById(R.id.detailFee);
        description  = findViewById(R.id.detailDescription);
        numberOrder = findViewById(R.id.detailCount);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        picFood = findViewById(R.id.detailPic);
    }
}
