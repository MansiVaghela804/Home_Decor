package com.example.manu.homedecor;

//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.manu.homedecor.Api_response.CategoryResponse;
//import com.squareup.picasso.Picasso;
//
//import retrofit2.Response;
//
//public class MainCustomAdapter extends RecyclerView.Adapter<MainCustomAdapter.ViewHolder> {
//
//    Response<CategoryResponse> response;
//    Context context;
//    RecyclerViewClickListener recyclerViewClickListener;
//
//    public MainCustomAdapter(Response<CategoryResponse> response, Context context) {
//        this.response = response;
//        this.context = context;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list,parent,false);
//        return  new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(final ViewHolder holder, final int position) {
//        holder.category_id.setText(response.body().getModelList().get(position).getCategoryId());
//        Picasso.with(context).load(response.body().getModelList().get(position).getImage()).into(holder.image_lists);
//        holder.items_lists.setText(response.body().getModelList().get(position).getCategoryName());
//        holder.items_lists.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                recyclerViewClickListener.onClick(position);
//
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//
//        return response.body().getModelList().size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//
//        TextView items_lists, category_id;
//        ImageView image_lists;
//        public ViewHolder(View itemView) {
//            super(itemView);
//            category_id = (TextView)itemView.findViewById(R.id.category_id);
//            items_lists = (TextView)itemView.findViewById(R.id.category_name);
//            image_lists = (ImageView)itemView.findViewById(R.id.image);
//        }
//    }
//
//    public interface RecyclerViewClickListener{
//        void onClick(int position);
//    }
//    public  void Click(RecyclerViewClickListener recyclerViewClickListener){
//        this.recyclerViewClickListener = recyclerViewClickListener;
//    }
//}
