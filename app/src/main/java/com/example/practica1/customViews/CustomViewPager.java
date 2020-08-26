package com.example.practica1.customViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class CustomViewPager extends ViewPager {

    private boolean swipePageChangeEnabled;

    public CustomViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (this.swipePageChangeEnabled) {
            return super.onInterceptTouchEvent(ev);
        }

        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (this.swipePageChangeEnabled) {
            return super.onTouchEvent(ev);
        }
        return false;

    }
    public void setPagingEnabled(boolean swipePageChangeEnabled) {
        this.swipePageChangeEnabled = swipePageChangeEnabled;
    }
}
