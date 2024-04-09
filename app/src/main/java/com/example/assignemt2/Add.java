package com.example.assignemt2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Add extends AppCompatActivity {
    EditText Name,phone,address,dic,ratting;

    Button add1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adding);
        add1 = findViewById(R.id.addin);
        Name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.location);
        dic = findViewById(R.id.disc);
        ratting = findViewById(R.id.ratting);
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString();
                String phone1 = phone.getText().toString();
                String Location = address.getText().toString();
                String Disc = dic.getText().toString();
                String rat = Name.getText().toString();
                if(!(name.isEmpty() || rat.isEmpty() || Disc.isEmpty() || Location.isEmpty() || phone1.isEmpty()))
                {
                    SharedPreferences sp = getSharedPreferences("Hottel", Context.MODE_PRIVATE);
                    String size = sp.getString("size","0");
                    int a = Integer.parseInt(size);
                    Toast.makeText(Add.this ,"size"+a, Toast.LENGTH_SHORT).show();
                    if(!size.isEmpty())
                    {
                        int size1= Integer.parseInt(size);
                        size1+=1;

                        String num = Integer.toString(size1);
                        String name1 = "Name"+" "+num;
                        String phone2 = "Phone"+" "+num;
                        String Location1 = "Location"+" "+num;
                        String Disc1 = "Disc"+" "+num;
                        String ratting1 = "Ratting"+" "+num;
                        SharedPreferences.Editor e1 = sp.edit();
                        e1.putString("size",Integer.toString(size1));
                        e1.putString(name1,name);
                        e1.putString(phone2,phone1);
                        e1.putString(Location1,Location);
                        e1.putString(Disc1,Disc);
                        e1.putString(ratting1,rat);
                        boolean b1  =e1.commit();
                        if(!b1)
                        {
                            Toast.makeText(Add.this ,"Masla Aya", Toast.LENGTH_SHORT).show();
                        }
                        finish();
                    }
                }
                else {
                    Toast.makeText(Add.this ,"Please fill All credentials", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
