package com.stoyanov5.material;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by B3f0r on 27-Feb-18.
 */

public class TileContentFragment extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);
        ContentAdapter contentAdapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(contentAdapter);
        recyclerView.setHasFixedSize(true);
        // Padding for recyclerview items
        int tilePadding = getResources().getDimensionPixelSize(R.dimen.tile_padding);
        recyclerView.setPadding(tilePadding,tilePadding,tilePadding,tilePadding);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView photo;
        public TextView name;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_tile, parent, false));
            photo = itemView.findViewById(R.id.tile_image);
            name = itemView.findViewById(R.id.tile_title);
        }
    }

    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {

        public static final int LENGTH = 20;
        private final String[] places;
        private final Drawable[] photos;

        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            places = resources.getStringArray(R.array.place_locations);
            TypedArray typedArray  = resources.obtainTypedArray(R.array.place_photo_normal);
            photos = new Drawable[typedArray.length()];
            for (int i = 0; i < photos.length; i++) {
                photos[i] = typedArray.getDrawable(i);
            }
            typedArray.recycle();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.photo.setImageDrawable(photos[position % photos.length]);
            holder.name.setText(places[position % places.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }

}
