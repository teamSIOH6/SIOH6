package com.team.sioh6.ui.sell;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.team.sioh6.R;

public class SellFragment extends Fragment {

    private SellModel sellModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sellModel =
                ViewModelProviders.of(this).get(SellModel.class);
        View root = inflater.inflate(R.layout.fragment_sell, container, false);
        final TextView textView = root.findViewById(R.id.text_sell);
        sellModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}