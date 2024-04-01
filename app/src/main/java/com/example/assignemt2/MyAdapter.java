package com.example.assignemt2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context c1 ;
    ArrayList<Hotal> name;

    MyAdapter(Context c2 ,ArrayList<Hotal> p1)
    {
        c1=c2;
        name = p1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(c1).inflate(R.layout.hotal,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Rating.setText(name.get(position).getRatting().toString());
        holder.t1.setText(name.get(position).getName());
        holder.t2.setText(name.get(position).getPhone());
        holder.t3.setText(name.get(position).getLocation());
        holder.t4.setText(name.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return name.size();
    }
}
