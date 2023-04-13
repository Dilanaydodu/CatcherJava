package com.dilanaydogdu.catcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class son extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_son);
    }
    public void yeniden(View view){
        Intent intent= new Intent(son.this,MainActivity.class);
        finish();
        startActivity(intent);
    }
    public void exit(View view){

        finish();
    }
}