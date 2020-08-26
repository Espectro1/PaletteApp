package com.example.practica1.fragments;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.palette.graphics.Palette;
import com.example.practica1.R;
import com.example.practica1.ViewImageActivity;
import com.example.practica1.logic.ImageSaver;
import java.io.IOException;

public class fragment_colors extends Fragment {
    private TextView txtVibrant,txtMuted, txtDominat,txtDarkMuted,txtDarkVibrant,txtLigthVibrant,txtLigthMuted;
    private ImageView mimage;
    private Button btn1;
    private String pathImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_colors,container,false);
        initViews(rootView);
       Bitmap  bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.top);// Test image
        createPalette(bitmap);
        ImageSaver imageSaver = new ImageSaver(getActivity().getApplicationContext());
        pathImage = imageSaver.saveToInternalStorage(bitmap);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/");
                startActivityForResult(intent.createChooser(intent,"Seleccione la aplicación"),10);
            }
        });
       mimage = rootView.findViewById(R.id.image);
        mimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ViewImageActivity.class);
                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), mimage, ViewCompat.getTransitionName(mimage));
                    intent.putExtra("path",pathImage);
                    startActivity(intent, options.toBundle());
            }
        });

        return rootView;
    }
public void initViews(ViewGroup rootView){
    mimage=rootView.findViewById(R.id.image);
    btn1= rootView.findViewById(R.id.btn1);
    this.txtVibrant= rootView.findViewById(R.id.txtvibrant);
    this.txtMuted= rootView.findViewById(R.id.txtmuted);
    this.txtDominat= rootView.findViewById(R.id.txtDominat);
    this.txtDarkMuted= rootView.findViewById(R.id.txtDarkMuted);
    this.txtDarkVibrant= rootView.findViewById(R.id.txtDarkVibrant);
    this.txtLigthVibrant= rootView.findViewById(R.id.ligthVibrant);
    this.txtLigthMuted= rootView.findViewById(R.id.ligthMuted);
}
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode== Activity.RESULT_OK){
            Uri path= data.getData();
            mimage.setImageURI(path);
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getActivity().getContentResolver(), path);
               createPalette(bitmap);
               ImageSaver imageSaver = new ImageSaver(getActivity().getApplicationContext());
               pathImage = imageSaver.saveToInternalStorage(bitmap);


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    private void createPalette(final Bitmap bitmap) {
        Palette.Builder builder = new Palette.Builder(bitmap);
        builder.maximumColorCount(32);
        builder.resizeBitmapArea(1048576);// resize bitmap area to (1024*1024 =1048576) default: 112 * 112= 12544
         builder.generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                assert palette != null;
                Palette.Swatch vibrant = palette.getVibrantSwatch();
                Palette.Swatch muted = palette.getMutedSwatch();
                Palette.Swatch dominat = palette.getDominantSwatch();
                Palette.Swatch darkMuted = palette.getDarkMutedSwatch();
                Palette.Swatch darkVibrant = palette.getDarkVibrantSwatch();
                Palette.Swatch ligthVibrant = palette.getLightVibrantSwatch();
                Palette.Swatch ligthMuted = palette.getLightMutedSwatch();
                if (vibrant != null){
                    setVisibilityGone(txtVibrant,false);
                    txtVibrant.setBackgroundColor(vibrant.getRgb());
                    txtVibrant.setTextColor(vibrant.getTitleTextColor());
                    txtVibrant.setText("Vibrant");
                }
                else {
                  //  txtVibrant.setBackgroundColor(Color.parseColor("#80FFFFFF"));
                   // txtVibrant.setTextColor(Color.parseColor("#50000000"));
                    setVisibilityGone(txtVibrant,true);
                }
                if (muted != null){
                    setVisibilityGone(txtMuted,false);
                    txtMuted.setBackgroundColor(muted.getRgb());
                    txtMuted.setTextColor(muted.getTitleTextColor());
                    txtMuted.setText("Muted");
                }
                else{
                    setVisibilityGone(txtMuted,true);
                }
                if (dominat != null){
                    setVisibilityGone(txtDominat,false);
                    txtDominat.setBackgroundColor(dominat.getRgb());
                    txtDominat.setTextColor(dominat.getTitleTextColor());
                    txtDominat.setText("Dominat");

                }
                else{
                    setVisibilityGone(txtDominat,true);
                }
                if (darkMuted != null){
                    setVisibilityGone(txtDarkMuted,false);
                    txtDarkMuted.setBackgroundColor(darkMuted.getRgb());
                    txtDarkMuted.setTextColor(darkMuted.getTitleTextColor());
                    txtDarkMuted.setText("DarkMuted");
                }else {
                    setVisibilityGone(txtDarkMuted,true);
                }
                if (darkVibrant != null){
                    setVisibilityGone(txtDarkVibrant,false);
                    txtDarkVibrant.setBackgroundColor(darkVibrant.getRgb());
                    txtDarkVibrant.setTextColor(darkVibrant.getTitleTextColor());
                    txtDarkVibrant.setText("DarkVibrant");

                }else{
                    setVisibilityGone(txtDarkVibrant,true);
                }
                if (ligthMuted != null){
                    setVisibilityGone(txtLigthMuted,false);
                    txtLigthMuted.setBackgroundColor(ligthMuted.getRgb());
                    txtLigthMuted.setTextColor(ligthMuted.getTitleTextColor());
                    txtLigthMuted.setText("LigthMuted");
                }else{
                    setVisibilityGone(txtLigthMuted,true);
                }
                if (ligthVibrant!= null){
                    setVisibilityGone(txtLigthVibrant,false);
                    txtLigthVibrant.setBackgroundColor(ligthVibrant.getRgb());
                    txtLigthVibrant.setTextColor(ligthVibrant.getTitleTextColor());
                    txtLigthVibrant.setText("LigthVibrant");
                }else{
                    setVisibilityGone(txtLigthVibrant,true);
                }
                if(dominat == darkVibrant){
                    //Toast.makeText(getContext(), "Somos iguales", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    private void setVisibilityGone(TextView textView,boolean b) {
        if (b){
            textView.setVisibility(View.GONE);
        }else {
            textView.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void onPrepareOptionsMenu(@NonNull Menu menu) {
        menu.getItem(0).setEnabled(true);
        menu.getItem(0).setVisible(true);
        super.onPrepareOptionsMenu(menu);
    }
}
