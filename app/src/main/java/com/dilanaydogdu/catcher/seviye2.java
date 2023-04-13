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
import android.widget.Toast;

import com.dilanaydogdu.catcher.databinding.ActivityMainBinding;
import com.dilanaydogdu.catcher.databinding.ActivitySeviye2Binding;

import java.util.Random;

public class seviye2 extends AppCompatActivity {
    private ActivitySeviye2Binding binding;
    int skor;
    ImageView[] imageArray2;
    Handler handler;
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySeviye2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        dokunma();
        skor=0;
        imageArray2=new ImageView[] {binding.imageView5,binding.imageView6,binding.imageView7,binding.imageView8,binding.imageView9,
                binding.imageView10,binding.imageView11,binding.imageView12,binding.imageView13};
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                binding.timetext2.setText("Time: "+l/1000);}
            @Override
            public void onFinish() {
                binding.timetext2.setText("TIME OFF");
                handler.removeCallbacks(runnable);
                for(ImageView image :imageArray2){
                    image.setVisibility(View.INVISIBLE);}
                if(skor>=10){
                AlertDialog.Builder alert=new AlertDialog.Builder(seviye2.this);
                alert.setCancelable(false);
                alert.setMessage("Congratulations You Won");
                alert.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(android.content.DialogInterface dialogInterface, int i) {
                        Intent intent= new Intent(seviye2.this,seviye3.class);
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
            }else{
                    AlertDialog.Builder alert=new AlertDialog.Builder(seviye2.this);
                    alert.setCancelable(false);
                    alert.setMessage("You Lost.Do you want to play again?");
                    alert.setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(android.content.DialogInterface dialogInterface, int i) {
                            Intent intent= new Intent(seviye2.this,MainActivity.class);
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
            }
        }.start();
    }
  public void skorarttir2(View view) {
        skor++;
        binding.skortext2.setText("Score: "+skor);}
    public void dokunma(){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                for(ImageView image :imageArray2){
                    image.setVisibility(View.INVISIBLE);

                }
                Random random=new Random();
                int i=random.nextInt(9);
                imageArray2[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,1000);
            }
        };
        handler.post(runnable);
    }
    }
