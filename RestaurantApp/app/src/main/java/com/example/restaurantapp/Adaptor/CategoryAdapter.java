package com.example.restaurantapp.Adaptor;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.Domain.CategoryDomain;
import com.example.restaurantapp.R;

import java.util.ArrayList;
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>  {
    ArrayList<CategoryDomain> categoryDomains;

    public  CategoryAdapter(ArrayList<CategoryDomain> categoryDomains){
        this.categoryDomains = categoryDomains;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View infalte = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new ViewHolder(infalte);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(categoryDomains.get(position).getTitle());
        String url = "";
        int position_temp = position;
        if(position > 4){
            position_temp = position - 4;
        }
        switch (position_temp){
            case 0: {
                url = "cat_1";
                break;
            }
            case 1: {
                url = "cat_2";
                break;
            }
            case 2: {
                url = "cat_3";
                break;
            }
            case 3: {
                url = "cat_4";
                break;
            }
            case 4: {
                url = "cat_5";
                break;
            }
        }
        holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.category_background));
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(url, "drawable", holder.itemView.getContext().getPackageName());

//        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.categoryPic);

        holder.categoryPic.setImageResource(drawableResourceId);
    }


    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView){
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryImage);
            mainLayout = itemView.findViewById(R.id.cate_id);
        }
    }
}
