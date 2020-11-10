package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FirstFragment.FirstFragmentChangeListener {


    private FirstFragment f1;
    private Fragment_Two f2;
    private FirstFragmentDataChangeListener firstFragmentDataChangeListener;

    @Override
    public void onDataChange(String data) {
        //Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        firstFragmentDataChangeListener.onFirstFragmentDataChanged(data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        f1 = new FirstFragment();
        fragmentTransaction.add(R.id.fragment_container1, f1);

        f2 = new Fragment_Two();
        fragmentTransaction.add(R.id.fragment_container2, f2);

        fragmentTransaction.commit();

        firstFragmentDataChangeListener = (FirstFragmentDataChangeListener)f2;

    }


    interface FirstFragmentDataChangeListener{
        void onFirstFragmentDataChanged(String text);
    }

}