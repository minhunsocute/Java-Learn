package com.example.restaurantapp.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.Adaptor.CategoryAdapter;
import com.example.restaurantapp.Adaptor.PopularAdapter;
import com.example.restaurantapp.Adaptor.SaleAdapter;
import com.example.restaurantapp.Domain.CategoryDomain;
import com.example.restaurantapp.Domain.FoodDomain;
import com.example.restaurantapp.Domain.SaleDomain;
import com.example.restaurantapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFrag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFrag newInstance(String param1, String param2) {
        HomeFrag fragment = new HomeFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    private RecyclerView.Adapter adapter, adapter2, adapter3;
    private RecyclerView recyclerViewCategoryList;
    private RecyclerView recyclerViewPopularList;
    private RecyclerView recyclerViewSaleList;
    private ConstraintLayout startBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        recyclerViewCategory(view);
        recyclerViewPopular(view);
        recyclerViewSale(view);

    }

    private void recyclerViewSale(View view){
        Context context = getActivity().getApplicationContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerViewSaleList = (RecyclerView)view.findViewById(R.id.listViewSale);
        recyclerViewSaleList.setLayoutManager(linearLayoutManager);

        ArrayList<SaleDomain> sales = new ArrayList<>();
        sales.add(new SaleDomain("pop_1", "Pepperoni pizza", 30.1, 50, "Ok","Italia"));
        sales.add(new SaleDomain("pop_2", "Cheese Burger", 20.1, 40, "Ok","Germany"));
        sales.add(new SaleDomain("pop_3", "Vegetable Pizza", 10.1, 30, "Ok","France"));
        adapter3 = new SaleAdapter(sales);
        recyclerViewSaleList.setAdapter(adapter3);

    }
    private void recyclerViewCategory(View view){
        Context context = getActivity().getApplicationContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = (RecyclerView)view.findViewById(R.id.listViewCalo);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Pizza", "cat_1"));
        category.add(new CategoryDomain("Burger", "cat_2"));
        category.add(new CategoryDomain("Hot dog", "cat_3"));
        category.add(new CategoryDomain("Drink", "cat_4"));
        category.add(new CategoryDomain("Donut", "cat_5"));
        category.add(new CategoryDomain("Pizza", "cat_1"));
        category.add(new CategoryDomain("Burger", "cat_2"));
        category.add(new CategoryDomain("Hot dog", "cat_3"));
        category.add(new CategoryDomain("Drink", "cat_4"));

        adapter = new CategoryAdapter(category);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    private void recyclerViewPopular(View view) {
        Context context = getActivity().getApplicationContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList =(RecyclerView)view.findViewById(R.id.listViewPopular);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);
        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Pepperoni pizza","pop_1","slices,mozzerella cheese,fresh oregano, ground black pepper , pizza sauce", 9.78, 0));
        foodList.add(new FoodDomain("Cheese Burger","pop_2","slices,mozzerella cheese,fresh oregano, ground black pepper , pizza sauce", 8.76, 0));
        foodList.add(new FoodDomain("Vegetable Pizza","pop_3","slices,mozzerella cheese,fresh oregano, ground black pepper , pizza sauce", 10.78, 0));

        adapter2 = new PopularAdapter(foodList);
        recyclerViewPopularList.setAdapter(adapter2);

    }
}