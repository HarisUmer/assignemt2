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
    RecyclerView r1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<Hotal> p1 = new ArrayList<Hotal>();
        SharedPreferences sp = getSharedPreferences("Hottel", Context.MODE_PRIVATE);
        String size = sp.getString("size","0");
        if(!size.isEmpty())
        {
            int size1= Integer.parseInt(size);
            Toast.makeText(MainActivity.this ,"size"+size1, Toast.LENGTH_SHORT).show();
            for(int i =0;i< size1;i++)
            {
                String num = Integer.toString(i);
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
        b1 = findViewById(R.id.Add);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  i= new Intent(MainActivity.this,Add.class);
                startActivity(i);
                String size = sp.getString("size","0");
                int size1= Integer.parseInt(size);
                Toast.makeText(MainActivity.this ,"size"+size1, Toast.LENGTH_SHORT).show();
                r1.getAdapter().notifyItemInserted(size1);
            }
        });
    }

}