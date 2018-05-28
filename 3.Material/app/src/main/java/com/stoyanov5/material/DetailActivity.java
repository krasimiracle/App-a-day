package com.stoyanov5.material;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by B3f0r on 01-Mar-18.
 */

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "position";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar_detail));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);

        // Set up resources
        Resources resources = getResources();

        int position = getIntent().getIntExtra(EXTRA_POSITION, 0);
        String[] places = resources.getStringArray(R.array.places);
        collapsingToolbarLayout.setTitle(places[position % places.length]);

        String[] placeDetails = resources.getStringArray(R.array.place_details);
        TextView placeDetail = findViewById(R.id.place_detail);
        placeDetail.setText(placeDetails[position % placeDetails.length]);

        String[] placeLocations = resources.getStringArray(R.array.place_locations);
        TextView placeLocation = findViewById(R.id.place_location);
        placeLocation.setText(placeLocations[position % placeLocations.length]);

        TypedArray placePhotos = resources.obtainTypedArray(R.array.place_photo_normal);
        ImageView placePhoto = findViewById(R.id.collapsing_image);
        Glide.with(this).load(placePhotos.getResourceId(position % placePhotos.length(), 0)).into(placePhoto);

        placePhotos.recycle();
    }
}
