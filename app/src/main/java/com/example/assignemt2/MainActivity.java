package com.example.assignemt2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView r1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<Hotal> p1 = new ArrayList<Hotal>();
        p1.add(new Hotal("PC DHABA","+92312-4260721","Punjab University Lahore","Dhaba for Students", 3.410F));
        p1.add(new Hotal("PC DHABA","+92312-4260721","Punjab University Lahore","Dhaba for Students", 3.410F));
        p1.add(new Hotal("PC DHABA","+92312-4260721","Punjab University Lahore","Dhaba for Students", 3.410F));
        p1.add(new Hotal("PC DHABA","+92312-4260721","Punjab University Lahore","Dhaba for Students", 3.410F));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1 = findViewById(R.id.Rec);
        r1.setLayoutManager(new LinearLayoutManager(this));
        r1.setAdapter(new MyAdapter(this,p1));
    }
}