package com.example.fragmenttest;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirstFragment extends Fragment {

    FirstFragmentChangeListener mCallBack;
    Button passButton;
    EditText text;

    //Setting up an interface to pass data
    public interface FirstFragmentChangeListener {
        void onDataChange(String data);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mCallBack = (FirstFragmentChangeListener)context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment__one_layout, container, false);


        passButton=view.findViewById(R.id.btn_press);
        text=view.findViewById(R.id.et_id);

       passButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               mCallBack.onDataChange(text.getText().toString());
           }
       });

        return  view;
    }
}