package com.example.restaurantapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantapp.Fragment.HomeFrag;
import com.example.restaurantapp.Fragment.ProfileFrag;
import com.example.restaurantapp.Fragment.SearchFrag;
import com.example.restaurantapp.Fragment.SettingFrag;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList;
    private  RecyclerView recyclerViewPopularList;
    private ConstraintLayout startBtn;
    BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        navigationView = findViewById(R.id.bottomNavigationBarView);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new HomeFrag()).commit();
        navigationView.setSelectedItemId(R.id.nav_home);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.nav_home:
                        fragment = new HomeFrag();
                        break;
                    case R.id.nav_search:
                        fragment = new SearchFrag();
                        break;
                    case R.id.nav_profile:
                        fragment = new ProfileFrag();
                        break;
                    case R.id.nav_setting:
                        fragment = new SettingFrag();
                        break;
                    default:
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();
                return true;
            }
        });
    }
}