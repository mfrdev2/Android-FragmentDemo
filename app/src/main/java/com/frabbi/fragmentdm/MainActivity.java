package com.frabbi.fragmentdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator{
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.container1,new FragmentOne(),"fOne")
                .add(R.id.container2,new FragmentTwo(),"fTwo")
                .commit();
    }

    @Override
    public void dataController(String eData) {
        FragmentTwo fTwo = (FragmentTwo) manager.findFragmentByTag("fTwo");
        fTwo.setData(eData);

    }
}