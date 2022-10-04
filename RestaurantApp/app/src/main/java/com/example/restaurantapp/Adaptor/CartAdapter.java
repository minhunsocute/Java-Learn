package com.example.restaurantapp.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.Domain.FoodDomain;
import com.example.restaurantapp.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    ArrayList<FoodDomain> cartDomains;
    public CartAdapter(ArrayList<FoodDomain> cartDomains){this.cartDomains = cartDomains;}
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View infalte = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);
        return new CartAdapter.ViewHolder(infalte);
    }


    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        FoodDomain item = cartDomains.get(position);
        holder.name.setText(item.getTitle());
        holder.fee.setText(String.format("$%s", String.valueOf(item.getFee())));
        holder.count.setText(String.valueOf(item.getNumberInCart()));
        holder.sumFee.setText(String.valueOf(item.getNumberInCart() * item.getFee()));
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(item.getPic(),"drawable",holder.itemView.getContext().getPackageName());
        holder.pic.setImageResource(drawableResourceId);
        holder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.setNumberInCart(item.getNumberInCart() + 1);
            }
        });
        holder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(item.getNumberInCart() > 0){
                    item.setNumberInCart(item.getNumberInCart() -1 );
                }
            }
        });
        //        holder.name.setText(String);
    }

    @Override
    public int getItemCount() {
        return cartDomains.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,fee, count, sumFee;
        ImageView pic;
        ImageView btnMinus, btnPlus;

        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.cartName);
            fee = itemView.findViewById(R.id.cartFee);
            pic = itemView.findViewById(R.id.cartItemPic);
            btnMinus = itemView.findViewById(R.id.cartBtnMinus);
            btnPlus = itemView.findViewById(R.id.cartBtnPlus);
            count = itemView.findViewById(R.id.cartCount);
            sumFee = itemView.findViewById(R.id.cartSumFee);
        }


    }
}
