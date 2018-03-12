package com.stoyanov5.a5auto;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.widget.TextView;

public class FragmentMainFragment extends Fragment {

    private ConstraintLayout framentTest;
    private TextView someText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        framentTest = (ConstraintLayout) view.findViewById(R.id.frament_test);
        someText = (TextView) view.findViewById(R.id.someText);
    }

}
