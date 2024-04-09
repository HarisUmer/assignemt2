package com.example.assignemt2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int ADD_HOTEL_REQUEST_CODE = 1001;
    RecyclerView r1;
    Button b1;
    SharedPreferences sp;
    ArrayList<Hotal> p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        p1 = new ArrayList<Hotal>();
         sp = getSharedPreferences("Hottel3", Context.MODE_PRIVATE);
        String size = sp.getString("size","0");
        if(!size.isEmpty())
        {
            int size1= Integer.parseInt(size);
            Toast.makeText(MainActivity.this ,"size"+size1, Toast.LENGTH_SHORT).show();
            for(int i =0;i< size1;i++)
            {
                String num = Integer.toString(i+1);
                String name = "Name"+" "+num;
                String phone = "Phone"+" "+num;
                String Location = "Location"+" "+num;
                String Disc = "Disc"+" "+num;
                String ratting1 = "Ratting"+" "+num;
                String ratting = sp.getString(ratting1,"0.0");
                float ratt = Float.parseFloat(ratting);
                p1.add(new Hotal(sp.getString(name," "),sp.getString(phone," "),sp.getString(Location," "),
                        sp.getString(Disc," "),ratt));
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1 = findViewById(R.id.Rec);
        r1.setLayoutManager(new LinearLayoutManager(this));
        r1.setAdapter(new MyAdapter(this,p1));
        b1 = findViewById(R.id.Add4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  i= new Intent(MainActivity.this,Add.class);
                startActivityIfNeeded(i, ADD_HOTEL_REQUEST_CODE);
                
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_HOTEL_REQUEST_CODE && resultCode == RESULT_OK) {
            int position = data.getIntExtra("position", -1);
            if (position != -1) {
                String num = Integer.toString(position+1);
                String name = "Name"+" "+num;
                String phone = "Phone"+" "+num;
                String Location = "Location"+" "+num;
                String Disc = "Disc"+" "+num;
                String ratting1 = "Ratting"+" "+num;
                String ratting = sp.getString(ratting1,"0.0");
                float ratt = Float.parseFloat(ratting);
                p1.add(new Hotal(sp.getString(name," "),sp.getString(phone," "),sp.getString(Location," "),
                        sp.getString(Disc," "),ratt));
                r1.getAdapter().notifyItemInserted(position);
            }
        }
    }

}