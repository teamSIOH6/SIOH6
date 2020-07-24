package com.team.sioh6.SliderUi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.team.sioh6.LoginActivity;
import com.team.sioh6.MainActivity;
import com.team.sioh6.R;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

public class InfoSlider extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private WormDotsIndicator dotsIndicator;
    private SliderAdapter sliderAdapter;

    private TextView btnnext, btnskip;

    private int totalPage;
    private int mCurrentPage;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null){
            Intent intent = new Intent(InfoSlider.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        setContentView(R.layout.activity_info_slider);

        btnnext = findViewById(R.id.btn_next);
        btnskip = findViewById(R.id.btn_skip);

        mSlideViewPager = findViewById(R.id.slide_view_pager);
        dotsIndicator = findViewById(R.id.dotIndicator);

        sliderAdapter = new SliderAdapter(this);

        mSlideViewPager.setAdapter(sliderAdapter);
        dotsIndicator.setViewPager(mSlideViewPager);
        mSlideViewPager.addOnPageChangeListener(onPageChangeListener);
        totalPage = sliderAdapter.pageNo.length;

        btnskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoSlider.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentPage == totalPage - 1){
                    Intent intent = new Intent(InfoSlider.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    mSlideViewPager.setCurrentItem(mCurrentPage + 1);
                }
            }
        });

    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            mCurrentPage = position;
            if (position == totalPage - 1){
                btnnext.setText(getResources().getString(R.string.finish));
                btnskip.setEnabled(false);
                btnskip.setVisibility(View.GONE);
            } else {
                btnnext.setText(getResources().getString(R.string.next));
                btnskip.setEnabled(true);
                btnskip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
