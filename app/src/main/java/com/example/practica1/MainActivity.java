package com.example.practica1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.practica1.customViews.CustomViewPager;
import com.example.practica1.adapters.SildePagerAdapter;
import com.example.practica1.fragments.fragment_colors;
import com.example.practica1.fragments.fragment_main;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private CustomViewPager viewPager;
    private SildePagerAdapter pagerAdapter;
     private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creacion de toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigation= findViewById(R.id.bottom_navigation_nav);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                bottomNavigation.setItemBackgroundResource(R.color.colorBlue);

                switch (menuItem.getItemId()){
                    case R.id.menu_home:
                       viewPager.setCurrentItem(0);break;
                    case R.id.menu_picture:
                        viewPager.setCurrentItem(1);break;
                //    case R.id.menu_pinture:
                }
                return true;

            }
        });
        // creacion de viewpager y su adapter
        viewPager =findViewById(R.id.view_pager);
        pagerAdapter = new SildePagerAdapter(getSupportFragmentManager(),getFragments());
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigation.getMenu().findItem(R.id.menu_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigation.getMenu().findItem(R.id.menu_picture).setChecked(true);
                        break;
                    case 2:
                        //  bottomNavigation.getMenu().findItem(R.id.menu_pinture).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

   private List<Fragment> getFragments(){
       List<Fragment> fragmentList = new ArrayList<>();
       fragmentList.add(new fragment_main());
       fragmentList.add(new fragment_colors());
       return fragmentList;
   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.toolbar_item_share:
               Toast.makeText(this,"Funcion de compartir no disponible",Toast.LENGTH_SHORT).show();
                return  true;
            case R.id.toolbar_item_configuration:
                startActivity(new Intent(this,SettingsActivity.class));
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
       // MenuInflater inflater = getMenuInflater();
       // inflater.inflate(R.menu.toolbar_menu, menu);
        menu.getItem(0).setEnabled(false);
        menu.getItem(0).setVisible(false);
        return super.onPrepareOptionsMenu(menu);
    }
}