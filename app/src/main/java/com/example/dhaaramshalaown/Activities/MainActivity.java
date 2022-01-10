package com.example.dhaaramshalaown.Activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.dhaaramshalaown.Fragments.Toolbar;
import com.example.dhaaramshalaown.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fg1 = new Toolbar();
        FragmentTransaction transaction;
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.id_frameLayout, fg1);
        transaction.commit();

    }

    @Override
    public void finish() {
        FragmentManager fm = getSupportFragmentManager();
        int count = fm.getBackStackEntryCount();
        if(count > 0) {
            super.finish();
        }
        else {
            Toast.makeText(this, "No More Fragments!", Toast.LENGTH_SHORT).show();
        }
    }
}