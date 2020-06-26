package com.example.shoper_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Batch_is_gone_window_002 extends AppCompatActivity {

    Button close_batch_is_gone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.batch_is_gone_002);

        final Random rand = new Random();


        close_batch_is_gone=(Button) findViewById(R.id.close_batch_is_gone_002);
        close_batch_is_gone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //TO DO put it back on 50
                String random =  rand.nextInt(50)+"";

                if(Integer.valueOf(random)<=25){


                    Intent myIntent = new Intent(Batch_is_gone_window_002.this, Batch_is_gone_window_001.class);
                    Batch_is_gone_window_002.this.startActivity(myIntent);


                }else {
                    Intent myIntent = new Intent(Batch_is_gone_window_002.this, MainActivity.class);
                    Batch_is_gone_window_002.this.startActivity(myIntent);
                }
            }
        });




    }
}
