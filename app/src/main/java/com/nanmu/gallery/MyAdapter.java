package com.nanmu.gallery;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import io.supercharge.shimmerlayout.ShimmerLayout;

/**
 * Created by kusunoki on 2020/5/14 0014 17:48.
 */
class MyAdapter extends ListAdapter<PhotoItem, MyAdapter.MyViewHolder> {

    protected MyAdapter() {
        super(new DiffUtil.ItemCallback<PhotoItem>() {
            @Override
            public boolean areItemsTheSame(@NonNull PhotoItem oldItem, @NonNull PhotoItem newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull PhotoItem oldItem, @NonNull PhotoItem newItem) {
                return oldItem.getPreviewURL().equals(newItem.getPreviewURL());
            }
        });
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        ShimmerLayout shimmerLayout;
        ImageView imageView;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            shimmerLayout = itemView.findViewById(R.id.shimmerLayout);
            imageView = itemView.findViewById(R.id.imageView2);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View itemView = inflater.inflate(R.layout.item_photo, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(itemView);
        myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 这里得到了当前显示内容的PhotoItem对象
                PhotoItem photoItem = getItem(myViewHolder.getAdapterPosition());
                Bundle bundle = new Bundle();
                bundle.putParcelable("data",photoItem);
                NavController navController = Navigation.findNavController(itemView);
                navController.navigate(R.id.action_galleryFragment_to_photoFragment, bundle);
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.shimmerLayout.setShimmerColor(0x55ffffff);
        holder.shimmerLayout.setShimmerAngle(0);
        holder.shimmerLayout.startShimmerAnimation();
        Glide.with(holder.itemView)
                .load(getItem(position).getPreviewURL())
                .placeholder(R.drawable.ic_launcher_background)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        if (holder.shimmerLayout != null) {
                            holder.shimmerLayout.stopShimmerAnimation();
                        }
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        if (holder.shimmerLayout != null) {
                            holder.shimmerLayout.stopShimmerAnimation();
                        }
                        return false;
                    }
                })
                .into(holder.imageView);

    }
}


