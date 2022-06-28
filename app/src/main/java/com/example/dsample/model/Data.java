package com.example.dsample.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public  class Data{

    @SerializedName("total")
    public int total;

    @SerializedName("product_list")
    public List<Grocery> groceries = new ArrayList<>();

}
