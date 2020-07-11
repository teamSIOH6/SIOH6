package com.team.sioh6.ui.learning;

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

public class LearningFragment extends Fragment {

    private LearningViewModel learningViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        learningViewModel =
                ViewModelProviders.of(this).get(LearningViewModel.class);
        View root = inflater.inflate(R.layout.fragment_learning, container, false);
        final TextView textView = root.findViewById(R.id.text_learning);
        learningViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}