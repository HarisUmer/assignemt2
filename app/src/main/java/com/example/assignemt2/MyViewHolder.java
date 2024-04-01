package com.example.assignemt2;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView t1,t2,t3,t4,Rating;
    Button b1;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        Rating = itemView.findViewById(R.id.rating);
        t1 = itemView.findViewById(R.id.t1);
        t2 = itemView.findViewById(R.id.t2);
        t3 = itemView.findViewById(R.id.t3);
        t4 = itemView.findViewById(R.id.t4);
        b1 = itemView.findViewById(R.id.Add);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
