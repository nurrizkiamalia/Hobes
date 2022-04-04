package com.tib.hobes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class slideradapter extends RecyclerView.Adapter<slideradapter.sliderviewholder>{

    private List<slideractivity> slideritem;
    private ViewPager2 viewPager2;

    public slideradapter(List<slideractivity> slideritem, ViewPager2 viewPager2) {
        this.slideritem = slideritem;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public sliderviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new sliderviewholder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slide_item_container,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull sliderviewholder holder, int position) {
        holder.setImage(slideritem.get(position));
        if (position == slideritem.size() - 2){
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return slideritem.size();
    }

    class sliderviewholder extends RecyclerView.ViewHolder{
        private RoundedImageView imageView;

        sliderviewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageslide);
        }

        void setImage(slideractivity sliderActivity){
            // Kalo mau nampilin foto dari internet
            // Bisa buat kodenya disini pake glide atau picasso

            imageView.setImageResource(sliderActivity.getImage());
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            slideritem.addAll(slideritem);
            notifyDataSetChanged();
        }
    };
}
