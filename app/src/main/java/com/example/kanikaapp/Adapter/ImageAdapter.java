package com.example.kanikaapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;


import android.view.ContextMenu;

import android.view.Menu;
import android.view.MenuItem;

import androidx.recyclerview.widget.RecyclerView;

import com.example.kanikaapp.Model.SparePart;
import com.example.kanikaapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> implements Filterable {
    private Context mContext;
    private List<SparePart> mSpareParts;
    private OnItemClickListener mListener;
    private List<SparePart> mSparePartsFull;

    public ImageAdapter(Context context, List<SparePart> uploads){
        mContext= context;
        mSpareParts= uploads;
        mSparePartsFull= uploads;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int  position) {
        SparePart sparePartCurrent = mSpareParts.get(position);
        holder.textViewName.setText(sparePartCurrent.getName());
        Picasso.with(mContext)
                .load(sparePartCurrent.getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(holder.imageView);

        holder.categoryView.setText(sparePartCurrent.getCategory());
        holder.priceView.setText(sparePartCurrent.getPrice());
        holder.phoneView.setText(sparePartCurrent.getPhoneNumber());

    }

    @Override
    public int getItemCount() {
        return mSpareParts.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
    private Filter exampleFilter= new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<SparePart> filteredList= new ArrayList<>();

            if(constraint == null || constraint.length()==0){
                filteredList.addAll(mSparePartsFull);
            }else {
                String filterPattern= constraint.toString().toLowerCase().trim();

                for (SparePart item : mSparePartsFull){
                    if(item.getCategory().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results= new FilterResults();
            results.values= filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mSpareParts.clear();
            mSpareParts.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        public TextView textViewName;
        public TextView categoryView;
        public TextView priceView;
        public TextView phoneView;
        public ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);

            textViewName= itemView.findViewById(R.id.text_view_name);
            imageView= itemView.findViewById(R.id.image_view_upload);
            categoryView= itemView.findViewById(R.id.compName);
            priceView= itemView.findViewById(R.id.price);
            phoneView= itemView.findViewById(R.id.phoneNumber);

            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {

                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(position);
                }
            }
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Select Action");
            MenuItem showItem= menu.add(Menu.NONE, 1, 1, "Show");
            MenuItem delete = menu.add(Menu.NONE, 2, 2, "Delete");

            showItem .setOnMenuItemClickListener(this);
            delete.setOnMenuItemClickListener(this);
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {

                    switch (item.getItemId()) {
                        case 1:
                            mListener.onShowItemClick(position);
                            return true;

                        case 2:
                            mListener.onDeleteClick(position);
                            return true;
                    }
                }
            }
            return false;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onShowItemClick (int position);


        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {

         mListener = listener;
    }
}
