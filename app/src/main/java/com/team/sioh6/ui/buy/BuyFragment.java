package com.team.sioh6.ui.buy;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.team.sioh6.R;

import java.util.ArrayList;
import java.util.List;

public class BuyFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<BuyModel> buyModelList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_buy, container, false);
        getBuyModels();
        recyclerView = root.findViewById(R.id.recyclerView);
        Log.e("BuyFragment","check:- " + getActivity());
        BuyAdapter adapter = new BuyAdapter(getActivity(),buyModelList,getChildFragmentManager());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        return root;
    }

    private void getBuyModels() {
        buyModelList = new ArrayList<>();
        BuyModel buyModel = new BuyModel();
        buyModel.setId(1);
        buyModel.setUserName("User Name 1");
        buyModelList.add(buyModel);
        buyModel = new BuyModel();
        buyModel.setId(2);
        buyModel.setUserName("User Name 2");
        buyModelList.add(buyModel);
        buyModel = new BuyModel();
        buyModel.setId(3);
        buyModel.setUserName("User Name 3");
        buyModelList.add(buyModel);
        buyModel = new BuyModel();
        buyModel.setId(4);
        buyModel.setUserName("User Name 4");
        buyModelList.add(buyModel);
    }
}