package com.example.manu.homedecor;

//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.manu.homedecor.Api_response.SubCategoryResponse;
//import com.squareup.picasso.Picasso;
//
//import retrofit2.Response;
//
//public class SubMainCustomAdapter extends RecyclerView.Adapter<SubMainCustomAdapter.ViewHolder>{
//
//    Response<SubCategoryResponse> response;
//    Context context;
//    RecyclerViewClickListener recyclerViewClickListener;
//
//    public SubMainCustomAdapter(Response<SubCategoryResponse> response, Context context) {
//        this.response = response;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
//        holder.id.setText(response.body().getSubModelList().get(position).getSubId());
//        holder.name.setText(response.body().getSubModelList().get(position).getSubName());
//        Picasso.with(context).load(response.body().getSubModelList().get(position).getSubImage()).into(holder.img);
//        holder.name.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                recyclerViewClickListener.onClick(view);
//            }
//        });
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return response.body().getSubModelList().size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        TextView id,name;
//        ImageView img;
//
//        public ViewHolder(View itemView) {
//
//            super(itemView);
//            id=itemView.findViewById(R.id.sub_category_id);
//            name=itemView.findViewById(R.id.sub_category_name);
//            img=itemView.findViewById(R.id.sub_imagelist);
//
//        }
//    }
//    public interface RecyclerViewClickListener{
//        void onClick(View view);
//
//    }
//    public  void Click(RecyclerViewClickListener recyclerViewClickListener){
//        this.recyclerViewClickListener = recyclerViewClickListener;
//    }
//}








