package com.team.sioh6.SliderUi;

import android.content.Context;
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
    }

    public String[] pageNo = {
      "Page 1","Page 2","Page 3"
    };

    @Override
    public int getCount() {
        return pageNo.length;
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

        TextView txt = view.findViewById(R.id.page_no);
        txt.setText(pageNo[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
