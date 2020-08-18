package com.team.sioh6.SliderUi;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.team.sioh6.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public SliderAdapter(Context context) {
        this.context = context;
        sliderBg[0] = context.getResources().getDrawable(R.drawable.slider_1);
        sliderBg[1] = context.getResources().getDrawable(R.drawable.slider_2);
        sliderBg[2] = context.getResources().getDrawable(R.drawable.slider_3);
    }

    public Drawable[] sliderBg = new Drawable[3];

    @Override
    public int getCount() {
        return sliderBg.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide_layout,container,false);

        RelativeLayout relativeLayout = view.findViewById(R.id.slide_layout_root);
        relativeLayout.setBackground(sliderBg[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
