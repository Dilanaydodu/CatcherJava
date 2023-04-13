package com.dilanaydogdu.catcher;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

import com.dilanaydogdu.catcher.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    int skor;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        dokunma();
        skor=0;
        imageArray=new ImageView[] {binding.imageView1,binding.imageView2,binding.imageView3,binding.imageView4};
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                binding.timetext.setText("Time: "+l/1000);}
            @Override
            public void onFinish() {
                binding.timetext.setText("TIME OFF");
                handler.removeCallbacks(runnable);
                for(ImageView image :imageArray){
                    image.setVisibility(View.INVISIBLE);}
                if(skor>=10){
                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                alert.setCancelable(false);
                alert.setMessage("Congratulations You Won");
                alert.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(android.content.DialogInterface dialogInterface, int i) {
                        Intent intent= new Intent(MainActivity.this,seviye2.class);
                        finish();
                        startActivity(intent);
                    }
                });
                alert.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(android.content.DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                alert.show();
            }
                else{
                    AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                    alert.setCancelable(false);
                    alert.setMessage("You Lost.Do you want to play again?");
                    alert.setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(android.content.DialogInterface dialogInterface, int i) {
                            Intent intent2= new Intent(MainActivity.this,MainActivity.class);
                            finish();
                            startActivity(intent2);
                        }
                    });
                    alert.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(android.content.DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    alert.show();
                }
            }
        }.start();
    }
    public void skorarttir(View view) {
        skor++;
        binding.skortext.setText("Score: "+skor);}
    public void dokunma(){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                for(ImageView image :imageArray){
                    image.setVisibility(View.INVISIBLE);

                }
                Random random=new Random();
                int i=random.nextInt(4);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,500);
            }
        };
        handler.post(runnable);
    }
}