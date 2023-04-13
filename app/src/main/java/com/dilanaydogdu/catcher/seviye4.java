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
import com.dilanaydogdu.catcher.databinding.ActivitySeviye4Binding;

import java.util.Random;

public class seviye4 extends AppCompatActivity {
    private ActivitySeviye4Binding binding;
    int skor;
    ImageView[] imageArray2;
    Handler handler;
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySeviye4Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        dokunma();
        skor=0;
        imageArray2=new ImageView[] {binding.imageView5,binding.imageView6,binding.imageView7,binding.imageView8,binding.imageView9,
                binding.imageView10,binding.imageView11,binding.imageView12,binding.imageView13,binding.imageView14,binding.imageView15,
                binding.imageView16,binding.imageView17,binding.imageView18,binding.imageView19,binding.imageView20};
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                binding.timetext4.setText("Time: "+l/1000);}
            @Override
            public void onFinish() {
                binding.timetext4.setText("TIME OFF");
                handler.removeCallbacks(runnable);
                for(ImageView image :imageArray2){
                    image.setVisibility(View.INVISIBLE);}
                if(skor>=8){
                AlertDialog.Builder alert=new AlertDialog.Builder(seviye4.this);
                alert.setCancelable(false);
                alert.setMessage("Congratulations You Won");
                alert.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(android.content.DialogInterface dialogInterface, int i) {
                        Intent intent4= new Intent(seviye4.this,son.class);
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
            }else{
                    AlertDialog.Builder alert=new AlertDialog.Builder(seviye4.this);
                    alert.setCancelable(false);
                    alert.setMessage("You Lost.Do you want to play again?");
                    alert.setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(android.content.DialogInterface dialogInterface, int i) {
                            Intent intent4= new Intent(seviye4.this,MainActivity.class);
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
                }}
        }.start();
    }
    public void skorarttir4(View view) {
        skor++;
        binding.skortext4.setText("Score: "+skor);}
    public void dokunma(){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                for(ImageView image :imageArray2){
                    image.setVisibility(View.INVISIBLE);

                }
                Random random=new Random();
                int i=random.nextInt(16);
                imageArray2[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,500);
            }
        };
        handler.post(runnable);
    }
}

