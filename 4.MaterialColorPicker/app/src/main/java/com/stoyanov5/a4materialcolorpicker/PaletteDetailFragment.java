package com.stoyanov5.a4materialcolorpicker;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by B3f0r on 06-Mar-18.
 */

public class PaletteDetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public RadioButton colorRankRadioButton;
        public TextView colorHexText;

        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_color,parent, false));
            colorRankRadioButton = itemView.findViewById(R.id.color_rank);
            colorHexText = itemView.findViewById(R.id.color_hex);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Set the color of the Primary/Accent containers
                }
            });
        }
    }
}
