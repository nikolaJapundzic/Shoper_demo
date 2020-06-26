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
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //String[] ninjaList1 = {"Hyannis", "Falmouth", "Orleans", "South Yarmouth", "Harwhich Port"};
    //ArrayList<String> listItems=new ArrayList<>(Arrays.asList(ninjaList1));

    String[] townsStringArray = {"Hyannis, Ma", "East Falmouth, Ma", "Orleans, Ma", "South Yarmouth, Ma", "Harwhich Port, Ma"};
    String[] addresStringArray = {"Shaw's ∙ 1070 Iyannough Rd, STE 1", "Shaw's ∙ 137 Tea Ticket Highway", "Shaw's ∙ 9 West Road", "Shaw's ∙ 1108 Route 28", "Shaw's ∙ 18 Sisson Road"};

    ArrayList<String> listItemsViewValue=new ArrayList<>();
    ArrayList<String> listItemsViewMiles=new ArrayList<>();
    ArrayList<String> listItemsItemsUnits=new ArrayList<>();

    //ArrayList<String> listItemsViewTownString=new ArrayList<>(Arrays.asList(townsStringArray));
    ArrayList<String> listItemsViewTown=new ArrayList<>();
    ArrayList<String> listItemsViewAddres=new ArrayList<>();
    Random rand = new Random();


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
                boolean Flag = false;
                double valueDolar = 0;
                while(Flag == false){
                    valueDolar = rand.nextInt(10000 - 700);
                    valueDolar = valueDolar / 100;
                    valueDolar = valueDolar + 7;
                    if(String.valueOf(valueDolar).length()<=5){
                        Flag = true;
                    }
                }
                

                listItemsViewValue.add(String.valueOf(valueDolar));
                listItemsViewMiles.add((Double.valueOf(rand.nextInt(300))/10) + " miles");
                listItemsItemsUnits.add(rand.nextInt(100)+ "\\" + rand.nextInt(100));

                int pos = rand.nextInt(townsStringArray.length);
                listItemsViewTown.add(townsStringArray[pos]);
                listItemsViewAddres.add(addresStringArray[pos]);

                customadapter1.notifyDataSetChanged();
                handler.postDelayed( this, 30 * 100 );
            }
        }, 30 * 100 );





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
            return listItemsViewValue.size();
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
            TextView textViewValue = (TextView)view.findViewById(R.id.textViewValue);
            TextView textViewMiles = (TextView)view.findViewById(R.id.textViewMiles);
            TextView textViewItemsUnits = (TextView)view.findViewById(R.id.textViewItemsUnits);
            TextView textViewTown = (TextView)view.findViewById(R.id.textViewTown);
            TextView textViewAddres = (TextView)view.findViewById(R.id.textViewAddres);

            textViewValue.setText(listItemsViewValue.get(i));
            textViewMiles.setText(listItemsViewMiles.get(i));
            textViewItemsUnits.setText(listItemsItemsUnits.get(i));
            textViewTown.setText(listItemsViewTown.get(i));
            textViewAddres.setText(listItemsViewAddres.get(i));
            //This line belowe add frame around items in list view
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                view.setBackground(getDrawable(R.drawable.listview_item_border));
            }
            return view;
        }

    }


}