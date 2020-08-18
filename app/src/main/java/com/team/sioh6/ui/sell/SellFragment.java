package com.team.sioh6.ui.sell;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.team.sioh6.R;

import java.util.ArrayList;
import java.util.List;

public class SellFragment extends Fragment implements View.OnClickListener {

    private List<SellModel> sellModelList;
    private RecyclerView recyclerView;
    private SellAdapter adapter;
    private FloatingActionButton addProduct;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sell, container, false);
        addProduct = root.findViewById(R.id.addProduct);
        recyclerView = root.findViewById(R.id.recycler_view);
        sellModelList = new ArrayList<>();
        adapter = new SellAdapter(getContext(),sellModelList);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        getSellModels();

        addProduct.setOnClickListener(this);
        return root;
    }

    private void getSellModels() {
        for (int i = 1 ; i <= 5 ; i++){
            SellModel model = new SellModel("Product Name "+i, "Product Details "+i, "2020-17-8 12:23:00",0,0,0);
            sellModelList.add(model);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addProduct:
                Intent intent = new Intent(getContext(),AddProduct.class);
                startActivity(intent);
                break;
        }
    }
}