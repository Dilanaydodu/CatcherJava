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
import com.dilanaydogdu.catcher.databinding.ActivitySeviye3Binding;

import java.util.Random;

public class seviye3 extends AppCompatActivity {
    private ActivitySeviye3Binding binding;
    int skor;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySeviye3Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        dokunma();
        skor=0;
        imageArray=new ImageView[] {binding.imageView5,binding.imageView6,binding.imageView7,binding.imageView8,binding.imageView9,
                binding.imageView10,binding.imageView11,binding.imageView12,binding.imageView13};
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                binding.timetext3.setText("Time: "+l/1000);}
            @Override
            public void onFinish() {
                binding.timetext3.setText("TIME OFF");
                handler.removeCallbacks(runnable);
                for(ImageView image :imageArray){
                    image.setVisibility(View.INVISIBLE);}
                if(skor>=8){
                AlertDialog.Builder alert=new AlertDialog.Builder(seviye3.this);
                alert.setCancelable(false);
                alert.setMessage("Congratulations You Won");
                alert.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(android.content.DialogInterface dialogInterface, int i) {
                        Intent intent4= new Intent(seviye3.this,seviye4.class);
                        finish();
                        startActivity(intent4);
                    }
                });
                alert.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(android.content.DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                alert.show();
            }else{ AlertDialog.Builder alert=new AlertDialog.Builder(seviye3.this);
                    alert.setCancelable(false);
                    alert.setMessage("You Lost.Do you want to play again?");
                    alert.setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(android.content.DialogInterface dialogInterface, int i) {
                            Intent intent4= new Intent(seviye3.this,MainActivity.class);
                            finish();
                            startActivity(intent4);
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
    public void skorarttir3(View view) {
        skor++;
        binding.skortext3.setText("Score: "+skor);}
    public void dokunma(){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                for(ImageView image :imageArray){
                    image.setVisibility(View.INVISIBLE);

                }
                Random random=new Random();
                int i=random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,500);
            }
        };
        handler.post(runnable);
    }
    }
