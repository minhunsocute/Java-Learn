package com.example.restaurantapp.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.Adaptor.CartAdapter;
import com.example.restaurantapp.Domain.FoodDomain;
import com.example.restaurantapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingFrag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SettingFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingFrag newInstance(String param1, String param2) {
        SettingFrag fragment = new SettingFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCartList;
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

        return inflater.inflate(R.layout.fragment_setting, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        recyclerViewCart(view);
    }

    private void recyclerViewCart(View view ) {
        Context context = getActivity().getApplicationContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerViewCartList = (RecyclerView) view.findViewById(R.id.cartList);
        recyclerViewCartList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Pepperoni pizza","pop_1","slices,mozzerella cheese,fresh oregano, ground black pepper , pizza sauce", 9.78, 0));
        foodList.add(new FoodDomain("Cheese Burger","pop_2","slices,mozzerella cheese,fresh oregano, ground black pepper , pizza sauce", 8.76, 0));
        foodList.add(new FoodDomain("Vegetable Pizza","pop_3","slices,mozzerella cheese,fresh oregano, ground black pepper , pizza sauce", 10.78, 0));
        foodList.add(new FoodDomain("Vegetable Pizza","pop_3","slices,mozzerella cheese,fresh oregano, ground black pepper , pizza sauce", 10.78, 0));

        adapter = new CartAdapter(foodList);
        recyclerViewCartList.setAdapter(adapter);
    }
}