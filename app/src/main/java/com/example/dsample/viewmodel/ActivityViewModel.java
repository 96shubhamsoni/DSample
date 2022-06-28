package com.example.dsample.viewmodel;

import android.app.Application;
import android.content.ClipData;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.dsample.R;

import com.example.dsample.model.Data;
import com.example.dsample.model.Grocery;
import com.example.dsample.model.Items;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActivityViewModel extends AndroidViewModel {

    List<Grocery> mList;
    private static final String TAG = "ActivityViewModel";
    Application application;

    public ActivityViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
         mList = new ArrayList<>();
    }

    public List<Grocery> getListGrocery(){
        InputStream raw =  application.getResources().openRawResource(R.raw.productlist);
        String jsonString;
        try {
            InputStream is = application.getResources().openRawResource(R.raw.productlist);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        Gson gson = new Gson();
//        Log.d(TAG+ " hi ",jsonString);

        Type listUserType = new TypeToken<Items>(){ }.getType();
        Items obj = gson.fromJson(jsonString, listUserType);


        mList = obj.abc.groceries;
        Log.d(TAG,obj.toString());

        Log.d(TAG,mList.size()+"");

        return mList;
    }

}
