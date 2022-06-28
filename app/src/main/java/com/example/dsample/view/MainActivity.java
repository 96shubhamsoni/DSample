package com.example.dsample.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dsample.R;
import com.example.dsample.model.Grocery;
import com.example.dsample.model.GroceryAdapter;
import com.example.dsample.model.Items;
import com.example.dsample.viewmodel.ActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityViewModel mViewModel;
    RecyclerView recyclerView;
    List<Grocery> mList;
    GroceryAdapter groceryAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.grocery_rv);
        mViewModel = new ViewModelProvider(this).get(ActivityViewModel.class);
        loadData();
        initRecyclerView();
    }

    public void loadData(){
        mList = mViewModel.getListGrocery();
    }

    public void initRecyclerView(){
        groceryAdapter = new GroceryAdapter(this,mList);
        LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(groceryAdapter);
    }
}
