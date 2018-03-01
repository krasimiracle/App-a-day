package com.stoyanov5.material;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

public class ListContentFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view, container, false);
        ContentAdapter contentAdapter = new ContentAdapter(recyclerView.getContext());
        recyclerView.setAdapter(contentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView photo;
        public TextView title;
        public TextView description;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_list, parent, false));
            photo = itemView.findViewById(R.id.list_item_photo);
            title = itemView.findViewById(R.id.list_title);
            description = itemView.findViewById(R.id.list_decription);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }
    }

    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Number of items in RecyclerView
        private static final int LENGTH = 20;
        private final Drawable[] photos;
        private final String[] titles;
        private final String[] descriptions;

        public ContentAdapter(Context context) {
            Resources resources = context.getResources();
            TypedArray typedArray = resources.obtainTypedArray(R.array.place_photo_rounded);
            photos = new Drawable[typedArray.length()];
            for (int i = 0; i < photos.length; i++) {
                photos[i] = typedArray.getDrawable(i);
            }
            typedArray.recycle();

            titles = resources.getStringArray(R.array.place_description);
            descriptions = resources.getStringArray(R.array.place_details);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.photo.setImageDrawable(photos[position % photos.length]);
            holder.title.setText(titles[position % titles.length]);
            holder.description.setText(descriptions[position % descriptions.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}
