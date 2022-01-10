package com.example.n_template.ui.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.n_template.R;
import com.example.n_template.ui.Models.SliderModel;
import com.smarteist.autoimageslider.SliderViewAdapter;
import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderViewHolder> {
    Context context;
    List<SliderModel> sliderModels;

    public SliderAdapter(Context context, List<SliderModel> sliderModels) {
        this.context = context;
        this.sliderModels = sliderModels;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item,parent,false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {

        viewHolder.sliderimageview.setImageResource(sliderModels.get(position).getImage());

    }

    @Override
    public int getCount() {
        return sliderModels.size();
    }
}

class SliderViewHolder extends SliderViewAdapter.ViewHolder{
    ImageView sliderimageview;
    public SliderViewHolder(View itemView) {
        super(itemView);

        sliderimageview = itemView.findViewById(R.id.imgv_autoslider);
    }
}
