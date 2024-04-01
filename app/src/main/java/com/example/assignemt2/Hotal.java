package com.example.assignemt2;

public class Hotal {
    String name;
    String Phone;
    String Location;
    String desc;
    Float ratting;
    Hotal(String name,String phone,String location,String desc,Float ratting)
    {
        this.name = name;
        this.Phone = phone;
        this.desc=desc;
        this.Location= location;
        this.ratting = ratting;
    }
    public String getName() {
        return this.name;
    }

    public Float getRatting() {
        return ratting;
    }

    public String getDesc() {
        return desc;
    }

    public String getLocation() {
        return Location;
    }

    public String getPhone() {
        return Phone;
    }
}
