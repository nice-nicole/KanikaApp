package com.example.kanikaapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kanikaapp.Model.SparePart;
import com.example.kanikaapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private Context mContext;
    private List<SparePart> mSpareParts;

    public ImageAdapter(Context context, List<SparePart> uploads){
        mContext= context;
        mSpareParts= uploads;
    }


    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.image_item,parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        SparePart sparePartCurrent = mSpareParts.get(position);
        holder.textViewName.setText(sparePartCurrent.getName());
        Picasso.with(mContext)
                .load(sparePartCurrent.getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mSpareParts.size();
    }

    public class ImageViewHolder extends  RecyclerView.ViewHolder{
        public TextView textViewName;
        public ImageView imageView;

        public ImageViewHolder(View itemView){
            super(itemView);

            textViewName= itemView.findViewById(R.id.text_view_name);
            imageView= itemView.findViewById(R.id.image_view_upload);
        }
    }
}
