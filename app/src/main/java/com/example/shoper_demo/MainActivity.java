package com.example.shoper_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    String[] ninjaList1 = {"11.3", "55.21"};

    ArrayList<String> listItems=new ArrayList<>(Arrays.asList(ninjaList1));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ListView listView =(ListView)findViewById(R.id.theListView);


        final Customadapter1 customadapter1 = new Customadapter1();
        listView.setAdapter(customadapter1);

        final Handler handler = new Handler();
        handler.postDelayed( new Runnable() {

            @Override
            public void run() {
                listItems.add("sadas");
                customadapter1.notifyDataSetChanged();
                handler.postDelayed( this, 60 * 100 );
            }
        }, 60 * 100 );





        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                System.out.println("helo "+ position);

                Intent myIntent = new Intent(MainActivity.this, Slider.class);
                MainActivity.this.startActivity(myIntent);
            }
        });





    }
    class Customadapter1 extends BaseAdapter{

        @Override
        public int getCount() {
            return listItems.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint({"ViewHolder", "InflateParams"})
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.batch,null);
            TextView textViewValue = (TextView)view.findViewById(R.id.textView2);

            textViewValue.setText(listItems.get(i));
            //This line belowe add frame around items in list view
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                view.setBackground(getDrawable(R.drawable.listview_item_border));
            }
            return view;
        }

    }


}