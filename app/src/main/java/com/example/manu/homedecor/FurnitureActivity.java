package com.example.manu.homedecor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FurnitureActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Models> modelsList;
    private Context context = this;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furniture);
        modelsList = new ArrayList<>();
        ModelsAdapter mAdapter = new ModelsAdapter(modelsList);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);

        Models models[] = {new Models(R.drawable.furniture_1, "Model 1"),
                new Models(R.drawable.furniture_2, "Model 2"),
                new Models(R.drawable.furniture_3, "Model 3"),
                new Models(R.drawable.furniture_4, "Model 4"),
                new Models(R.drawable.furniture_5, "Model 5"),
                new Models(R.drawable.furniture_6, "Model 6"),
                new Models(R.drawable.furniture_7,"Model 7"),
                new Models(R.drawable.furniture_8, "Model 8")};


        for (int j = 0; j < 1; j++) {
            for (int i = 0; i < models.length; i++) {
                modelsList.add(models[i]);
            }
        }
        // 2. set layoutManger
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        // 3. create an adapter

        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
    }

    public void backFurniture(View view) {
        Intent intent = new Intent(FurnitureActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public class Models {
        private int imagelist;
        private String data;

        public Models(int imagelist, String data) {
            this.imagelist = imagelist;
            this.data = data;
        }

        public int getImagelist() {
            return imagelist;
        }

        public void setImagelist(int imagelist) {
            this.imagelist = imagelist;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
    public class ModelsAdapter extends RecyclerView.Adapter<ModelsAdapter.ViewHolder> {

        private List<Models> modelsList;

        public ModelsAdapter(List<Models> modelsList) {
            this.modelsList = modelsList;
        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
            ViewHolder viewHolder = new ViewHolder(itemView);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            Models models = modelsList.get(position);
            holder.data.setText(models.getData());
            holder.imagelist.setImageResource(models.getImagelist());
            holder.imagelist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position == 0) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.furniture_model_one,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_furniture_1);
                        image1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_furniture_1);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();

                    }
                    if (position == 1) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.furniture_model_two,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_furniture_2);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_furniture_2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 2) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.furniture_model_three,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_furniture_3);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_furniture_3);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 3) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.furniture_model_four,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_furniture_4);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_furniture_4);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 4) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.furniture_model_five,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_furniture_5);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_furniture_5);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 5) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.furniture_model_six,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_furniture_6);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_furniture_6);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 6) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.furniture_model_seven,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_furniture_7);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_furniture_7);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 7) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.furniture_model_eight,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_furniture_8);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_furniture_8);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return modelsList.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView data;
            ImageView imagelist;

            public ViewHolder(View itemView) {
                super(itemView);
                data = (TextView)itemView.findViewById(R.id.data);
                imagelist = (ImageView) itemView.findViewById(R.id.imagelist);
            }
        }
    }


}
