package com.stoyanov5.material;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by B3f0r on 27-Feb-18.
 */

public class CardContentFragment extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);
        ContentAdapter contentAdapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(contentAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView cardImage;
        public TextView cardTitle;
        public TextView cardText;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card, parent, false));
            cardImage = itemView.findViewById(R.id.card_photo);
            cardTitle = itemView.findViewById(R.id.card_title);
            cardText = itemView.findViewById(R.id.card_text);
        }
    }

    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        public static int LENGTH = 20;
        private final String[] titles;
        private final String[] descriptions;
        private final Drawable[] photos;

        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            titles = resources.getStringArray(R.array.place_locations);
            descriptions = resources.getStringArray(R.array.place_description);

            TypedArray typedArray = resources.obtainTypedArray(R.array.place_photo_normal);
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
            holder.cardTitle.setText(titles[position % titles.length]);
            holder.cardText.setText(descriptions[position % descriptions.length]);
            holder.cardImage.setImageDrawable(photos[position % photos.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}
