package com.example.fragmenttest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Fragment_Two extends Fragment implements MainActivity.FirstFragmentDataChangeListener {

    final static String DATA_RECEIVE="data_receive";
    TextView showReceiveData;

      @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view=inflater.inflate(R.layout.fragment__two_layout, container, false);
         showReceiveData=view.findViewById(R.id.tv_second_fragment);
        return view;
    }

    @Override
    public void onFirstFragmentDataChanged(String text) {
        showReceiveData.setText(text);
    }
}