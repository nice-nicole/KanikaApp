//package com.example.kanika.Adapter;
//
//import android.content.Context;
//import android.view.ContextMenu;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.kanika.Model.SparePart;
//import com.example.kanika.R;
//import com.squareup.picasso.Picasso;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
//    private Context mContext;
//    private List<SparePart> spareParts;
//    private OnItemClickListener mListener;
//
//    public RecyclerAdapter(Context context, List<SparePart> uploads){
//        mContext = context;
//        spareParts= uploads;
//    }
//
//    @Override
//    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
//        View v = LayoutInflater.from(mContext).inflate(R.layout.activity_row_model, parent, false );
//        return  new RecyclerViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerViewHolder holder, int position){
//        SparePart currentSparePart = spareParts.get(position);
//        holder.nameTextView.setText(currentSparePart.getName());
//        holder.descriptionTextView.setText(currentSparePart.getDescription());
//        holder.dateTextView.setText(getDateToday());
//        Picasso.with(mContext)
//                .load(currentSparePart.getImageURL())
//                .placeholder(R.drawable.spareparts33)
//                .fit()
//                .centerCrop()
//                .into(holder.sparePartImageView);
//    }
//
//    @Override
//    public int getItemCount(){
//        return spareParts.size();
//    }
//
//    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener{
//
//        public TextView nameTextView, descriptionTextView, dateTextView;
//        public ImageView sparePartImageView;
//
//        public RecyclerViewHolder(View itemView){
//            super(itemView);
//            nameTextView= itemView.findViewById(R.id.nameTextView);
//            descriptionTextView= itemView.findViewById(R.id.descriptionTextView);
//            dateTextView= itemView.findViewById(R.id.dateTextView);
//            sparePartImageView = itemView.findViewById(R.id.sparepartImageView);
//
//            itemView.setOnClickListener(this);
//            itemView.setOnCreateContextMenuListener(this);
//
//
//        }
//        @Override
//        public void onClick(View v){
//            if(mListener != null){
//                int position = getAdapterPosition();
//                if(position != RecyclerView.NO_POSITION){
//                    mListener.onItemClick(position);
//                }
//            }
//        }
//
//        @Override
//        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
//            menu.setHeaderTitle("Select Action");
//
//            MenuItem showItem = menu.add(Menu.NONE, 1, 1, "Show");
//            MenuItem deleteItem = menu.add(Menu.NONE, 2, 2, "Delete");
//
//            showItem.setOnMenuItemClickListener(this);
//            deleteItem.setOnMenuItemClickListener(this);
//
//        }
//
//        @Override
//        public boolean onMenuItemClick(MenuItem item){
//            if(mListener != null){
//                int position = getAdapterPosition();
//                if (position != RecyclerView.NO_POSITION){
//
//                    switch (item.getItemId()){
//                        case 1:
//                            mListener.onShowItemClick(position);
//                            return true;
//                        case 2:
//                            mListener.onDeleteItemClick(position);
//                            return true;
//                    }
//                }
//            }
//
//            return false;
//        }
//
//    }
//    public interface OnItemClickListener{
//        void onItemClick(int position);
//        void onShowItemClick(int position);
//        void onDeleteItemClick(int position);
//
//    }
//
//    public void setOnItemClickListener(OnItemClickListener listener){
//        mListener= listener;
//    }
//    private String getDateToday(){
//        DateFormat dateFormat= new SimpleDateFormat("yyyy/MM/dd");
//        Date date = new Date();
//        String today= dateFormat.format(date);
//        return today;
//    }
//}
