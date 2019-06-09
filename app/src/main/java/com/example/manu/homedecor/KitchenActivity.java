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

public class KitchenActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Models> kitchenmodelsList;
    private Context context = this;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);

        kitchenmodelsList = new ArrayList<>();
        KitchenModelsAdapter mAdapter = new KitchenModelsAdapter(kitchenmodelsList);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview3);

        Models models[] = {new Models(R.drawable.kitchen_1, "Model 1"),
                new Models(R.drawable.kitchen_2, "Model 2"),
                new Models(R.drawable.kitchen_3, "Model 3"),
                new Models(R.drawable.kitchen_4, "Model 4"),
                new Models(R.drawable.kitchen_5, "Model 5"),
                new Models(R.drawable.kitchen_6, "Model 6"),
                new Models(R.drawable.kitchen_7,"Model 7"),
                new Models(R.drawable.kitchen_8, "Model 8")};


        for (int j = 0; j < 1; j++) {
            for (int i = 0; i < models.length; i++) {
                kitchenmodelsList.add(models[i]);
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

    public void backKitchen(View view) {
        Intent intent = new Intent(KitchenActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    public class Models {
        private int kitchenimgList;
        private String data;

        public Models(int kitchenimgList, String data) {
            this.kitchenimgList = kitchenimgList;
            this.data = data;
        }

        public int getKitchenimgList() {
            return kitchenimgList;
        }

        public void setKitchenimgList(int kitchenimgList) {
            this.kitchenimgList = kitchenimgList;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
    public class KitchenModelsAdapter extends RecyclerView.Adapter<KitchenModelsAdapter.ViewHolder> {

        private List<Models> kitchenmodelsList;

        public KitchenModelsAdapter(List<Models> kitchenmodelsList) {
            this.kitchenmodelsList = kitchenmodelsList;
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
            Models models = kitchenmodelsList.get(position);
            holder.data.setText(models.getData());
            holder.kitchenimgList.setImageResource(models.getKitchenimgList());
            holder.kitchenimgList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position == 0) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.kitchen_model_one,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_kitchen_1);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_kitchen_1);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();

                    }
                    if (position == 1) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.kitchen_model_two,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_kitchen_2);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_kitchen_2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 2) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.kitchen_model_three,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_kitchen_3);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_kitchen_3);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 3) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.kitchen_model_four,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_kitchen_4);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_kitchen_4);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 4) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.kitchen_model_five,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_kitchen_5);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_kitchen_5);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 5) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.kitchen_model_six,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_kitchen_6);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_kitchen_6);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 6) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.kitchen_model_seven,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_kitchen_7);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_kitchen_7);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 7) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.kitchen_model_eight,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_kitchen_8);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_kitchen_8);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return kitchenmodelsList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView data;
            ImageView kitchenimgList;

            public ViewHolder(View itemView) {
                super(itemView);
                data = (TextView)itemView.findViewById(R.id.data);
                kitchenimgList = (ImageView) itemView.findViewById(R.id.imagelist);
            }
        }
    }
}
