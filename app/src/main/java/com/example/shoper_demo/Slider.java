package com.example.shoper_demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;



public class Slider extends AppCompatActivity {

    public static int slider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.batch_detail_info);

        SeekBar seekBar;
        seekBar = (SeekBar)findViewById(R.id.seekBar);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                slider = seekBar.getProgress();
                System.out.println("slin "+slider);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                slider = seekBar.getProgress();
                if (slider == 100){
                    System.out.println("slin "+slider+ " good job!");
                    seekBar.setProgress(0);
                    Intent myIntent = new Intent(Slider.this, Batch_is_gone_window.class);
                    Slider.this.startActivity(myIntent);
                }else{
                    seekBar.setProgress(0);
                }


            }
        });


    }
}
