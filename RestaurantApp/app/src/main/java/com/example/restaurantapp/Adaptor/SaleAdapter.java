package com.example.restaurantapp.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.Domain.SaleDomain;
import com.example.restaurantapp.R;

import java.util.ArrayList;

public class SaleAdapter extends RecyclerView.Adapter<SaleAdapter.ViewHolder> {
    ArrayList<SaleDomain> saleDomains;

    public SaleAdapter(ArrayList<SaleDomain> saleDomains){this.saleDomains = saleDomains;}
    @Override
    public SaleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View infalte = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_sale, parent, false);
        return new SaleAdapter.ViewHolder(infalte);
    }

    @Override
    public void onBindViewHolder(@NonNull SaleAdapter.ViewHolder holder, int position) {
        holder.name.setText(saleDomains.get(position).getName());
        holder.country.setText(String.format("%s Food", saleDomains.get(position).getCountry()));
        holder.sale.setText(String.format("Sale %s%%", String.valueOf(saleDomains.get(position).getSale())));
        holder.fee.setText(String.format("$ %s", String.valueOf(saleDomains.get(position).getFee())));
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(saleDomains.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        holder.pic.setImageResource(drawableResourceId);
    }

    @Override
    public int getItemCount() {
        return saleDomains.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, fee, sale, country;
        ImageView pic;
        ConstraintLayout clickFunc;
        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.saleName);
            fee = itemView.findViewById(R.id.saleFee);
            sale = itemView.findViewById(R.id.salePercent);
            country = itemView.findViewById(R.id.countryFood);
            pic = itemView.findViewById(R.id.salePic);
            clickFunc = itemView.findViewById(R.id.saleView);
        }
    }
}
