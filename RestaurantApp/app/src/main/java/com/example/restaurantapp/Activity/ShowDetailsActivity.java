package com.example.restaurantapp.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurantapp.Domain.FoodDomain;
import com.example.restaurantapp.R;

public class ShowDetailsActivity extends AppCompatActivity {
    private Button addToCartBtn;
    private TextView name, fee, description,numberOrder;
    private ImageView plusBtn, minusBtn,picFood;
    private FoodDomain select;
    int countOrder = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        initView();
        getBundle();
    }

    private void getBundle(){
        select = (FoodDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId = this.getResources().getIdentifier(select.getPic(), "drawable", this.getPackageName());
        picFood.setImageResource(drawableResourceId);
        name.setText(select.getTitle());
        fee.setText(String.valueOf(select.getFee()));
        description.setText(select.getDescription());
        numberOrder.setText(String.valueOf(countOrder));
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countOrder += 1 ;
                numberOrder.setText(String.valueOf(countOrder));
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countOrder = (countOrder > 0 )? countOrder - 1: countOrder;
                numberOrder.setText(String.valueOf(countOrder));
            }
        });
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