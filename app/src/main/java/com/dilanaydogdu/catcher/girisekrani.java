package com.dilanaydogdu.catcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dilanaydogdu.catcher.databinding.ActivityGirisekraniBinding;
import com.dilanaydogdu.catcher.databinding.ActivityMainBinding;

public class girisekrani extends AppCompatActivity {
    private ActivityGirisekraniBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGirisekraniBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }
    public void start(View view){
        Intent intent= new Intent(girisekrani.this,MainActivity.class);
        finish();
        startActivity(intent);
    }
}