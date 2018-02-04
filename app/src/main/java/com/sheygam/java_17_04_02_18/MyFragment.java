package com.sheygam.java_17_04_02_18;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gregorysheygam on 04/02/2018.
 */

public class MyFragment extends Fragment {
    public MyFragment() {
        Log.d("MY_TAG", "MyFragment: constructor()");
    }

    @Override
    public void onAttach(Activity activity) {
        Log.d("MY_TAG", "onAttach: ");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("MY_TAG", "onCreate: ");
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("MY_TAG", "onCreateView: ");
        View view  = new View(getActivity());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(Color.rgb(0,0,0));
        return view;
    }

    @Override
    public void onDestroyView() {
        Log.d("MY_TAG", "onDestroyView: ");
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        Log.d("MY_TAG", "onDetach: ");
        super.onDetach();
    }
}
