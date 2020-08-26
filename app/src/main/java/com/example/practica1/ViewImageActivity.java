package com.example.practica1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.practica1.logic.ImageSaver;

import java.io.File;

public class ViewImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);
        // toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Image");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        //get image chosen from bundle
        ImageSaver imageSaver = new ImageSaver(this);
        ContextWrapper cw = new ContextWrapper(getApplicationContext());

        String path;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                path= null;
            } else {
                path= extras.getString("path");
            }
        } else {
            path= (String) savedInstanceState.getSerializable("path");
        }
        Bitmap bitmap = imageSaver.loadImageFromStorage(path);
        ImageView image = (ImageView) findViewById(R.id.image_transition);
        image.setImageBitmap(bitmap);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finishAfterTransition();  // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }
}