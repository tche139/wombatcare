package com.example.fistinbone.myapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fistinbone.myapplication.R;

/**
 * Created by fistinbone on 8/18/2017.
 */

public class ConstructionFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(
                R.layout.fragment_screen_slide_constructing,container,false);
        return rootView;
    }
}
