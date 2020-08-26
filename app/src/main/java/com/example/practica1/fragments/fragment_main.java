package com.example.practica1.fragments;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.practica1.R;

public class fragment_main extends Fragment {
    private Switch aSwitch;
    private ToggleButton tgIzq,tgDer;
    private Window window;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main,container,false);


        this.aSwitch = rootView.findViewById(R.id.switch1);
        this.tgDer = rootView.findViewById(R.id.tgDer);
        this.tgIzq = rootView.findViewById(R.id.tgIzq);
        this.window = getActivity().getWindow();
        rootView.findViewById(R.id.btnShow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aSwitch.setVisibility(View.VISIBLE);
                tgDer.setVisibility(View.VISIBLE);
                tgIzq.setVisibility(View.VISIBLE);
            }
        });

        rootView.findViewById(R.id.btnSwipe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aSwitch.isChecked()){
                    tgIzq.setVisibility(View.GONE);
                }else{
                    tgDer.setVisibility(View.GONE);
                }
                aSwitch.setVisibility(View.GONE);

            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String primaryDark;
                String primary;
                String background ;
                if(b){
                    tgDer.setChecked(true);
                    tgIzq.setChecked(false);

                    primaryDark = "#df2a2a";
                    primary ="#000000";
                    background ="#8d0000";
                    //int colors[]={Color.parseColor(primaryDark),Color.parseColor(primary),Color.parseColor(background)};
                    //changeColor(primaryDark,primary,background,colors);
                }else{
                    tgDer.setChecked(false);
                    tgIzq.setChecked(true);
                    window.setBackgroundDrawableResource(R.drawable.bg_color);
                    primaryDark = "#000000";
                    primary ="#eaeaea";
                    background ="#7a7070";

                }

               // int colors[]={Color.parseColor(primaryDark),Color.parseColor(primary),Color.parseColor(background)};

            }
        });

        return  rootView;
    }//End OnCreate

    private void changeColor(String primaryDark,String primary,String background,int colors[]){
        //colorPrimaryDark
        window.setStatusBarColor(Color.parseColor(primaryDark));
        //colorPrimary
       // getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(primary)));
        //background
        //window.setBackgroundDrawable(new ColorDrawable(Color.parseColor(background)));
        window.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM,colors));

        //bottom navigation
        window.setNavigationBarColor(Color.parseColor(primary));
    }


}
