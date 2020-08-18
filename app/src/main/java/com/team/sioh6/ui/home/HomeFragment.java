package com.team.sioh6.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.team.sioh6.R;

public class HomeFragment extends Fragment {

    FloatingActionButton chat;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        BottomNavigationView navigationView = root.findViewById(R.id.nav_view);
        navigationView.setOnNavigationItemSelectedListener(listener);
        //NavController navController = Navigation.findNavController(getActivity(),R.id.nav_host_home_fragment);
        //NavigationUI.setupWithNavController(navigationView,navController);
        chat = root.findViewById(R.id.chat_bot);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),ChatActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }

    BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()){
                case R.id.socials:
                    fragment = new SocialFragment();
                    break;

                case R.id.experts:
                    fragment = new ExpertFragment();
                    break;
            }
            getChildFragmentManager().beginTransaction().replace(R.id.nav_host_home_fragment,fragment).commit();
            return true;
        }
    };

}