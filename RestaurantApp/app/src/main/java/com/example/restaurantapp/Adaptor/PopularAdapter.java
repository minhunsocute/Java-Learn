package com.example.restaurantapp.Adaptor;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.Activity.ShowDetailsActivity;
import com.example.restaurantapp.Domain.FoodDomain;
import com.example.restaurantapp.R;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    ArrayList<FoodDomain> foodDomains;

    public  PopularAdapter(ArrayList<FoodDomain> foodDomains){
        this.foodDomains = foodDomains;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View infalte = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular, parent, false);
        return new ViewHolder(infalte);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.ViewHolder holder, int position) {
        int positionTemp =position;
        holder.title.setText(foodDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(foodDomains.get(position).getFee()));
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(foodDomains.get(position).getPic(),"drawable", holder.itemView.getContext().getPackageName());
        holder.pic.setImageResource(drawableResourceId);

        holder.addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailsActivity.class);
//                intent.putExtra("object", foodDomains.get(positionTemp));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodDomains.size();
    }

    class ViewHolder extends  RecyclerView.ViewHolder{
        TextView title, fee;
        ImageView pic;
        TextView addBtn;
        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.popularName);
            fee = itemView.findViewById(R.id.popularFee);
            pic = itemView.findViewById(R.id.popularPic);
            addBtn =  itemView.findViewById(R.id.addBtn);

        }

    }
}
