package com.example.shoper_demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class Slider extends AppCompatActivity {

    public static int slider;
    Random rand = new Random();


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
                    seekBar.setProgress(0);
                    Intent myIntent_001 = new Intent(Slider.this, Batch_is_gone_window_001.class);
                    Intent myIntent_002 = new Intent(Slider.this, Batch_is_gone_window_002.class);

                    //TO DO put it back on 50
                    String random =  rand.nextInt(50)+"";

                    if(Integer.valueOf(random)<=25){
                        Slider.this.startActivity(myIntent_001);
                    }else {
                        Slider.this.startActivity(myIntent_002);
                    }





                }else{
                    seekBar.setProgress(0);
                }


            }
        });


    }
}
