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

public class DecorActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Models> modelsList;
    private Context context = this;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decor);

        modelsList = new ArrayList<>();
        DecorModelsAdapter mAdapter = new DecorModelsAdapter(modelsList);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview2);


        Models models[] = {new Models(R.drawable.decor_1, "Model 1"),
                new Models(R.drawable.decor_2, "Model 2"),
                new Models(R.drawable.decor_3, "Model 3"),
                new Models(R.drawable.decor_4, "Model 4"),
                new Models(R.drawable.decor_5, "Model 5"),
                new Models(R.drawable.decor_6, "Model 6"),
                new Models(R.drawable.decor_7, "Model 7"),
                new Models(R.drawable.decor_8, "Model 8"),
                new Models(R.drawable.decor_9, "Model 9"),
                new Models(R.drawable.decor_10, "Model 10"),
                new Models(R.drawable.decor_11, "Model 11"),
                new Models(R.drawable.decor_12, "Model 12"),
                new Models(R.drawable.decor_13, "Model 13"),
                new Models(R.drawable.decor_14, "Model 14"),
                new Models(R.drawable.decor_15, "Model 15"),
                new Models(R.drawable.decor_16, "Model 16")};


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

    public void backDecor(View view) {
        Intent intent = new Intent(DecorActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    public class Models{
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
    public class DecorModelsAdapter extends RecyclerView.Adapter<DecorModelsAdapter.ViewHolder>{

        private List<Models> decormodelsList;

        public DecorModelsAdapter(List<Models> decormodelsList) {
            this.decormodelsList = decormodelsList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
            DecorModelsAdapter.ViewHolder viewHolder = new DecorModelsAdapter.ViewHolder(itemView);
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
                        View layout_inflate = inflater.inflate(R.layout.decor_model_one,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_decor_one);
                        image1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_decor_one);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();

                    }
                    if (position == 1) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.decor_model_two,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_decor_two);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_decor_two);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 2) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.decor_model_three,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_decor_three);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_decor_three);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 3) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.decor_model_four,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_decor_four);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_decor_four);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 4) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.decor_model_five,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_decor_five);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_decor_five);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 5) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.decor_model_six,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_decor_six);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_decor_six);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 6) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.decor_model_seven,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_decor_seven);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_decor_seven);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 7) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.decor_model_eight,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_decor_eight);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_decor_eight);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 8) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.decor_model_nine,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_decor_nine);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_decor_nine);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 9) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.decor_model_ten,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_decor_ten);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_decor_ten);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 10) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.decor_model_11,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_decor_11);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_decor_11);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 11) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.decor_model_12,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_decor_12);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_decor_12);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 12) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.decor_model_13,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_decor_13);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_decor_13);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 13) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.decor_model_14,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_decor_14);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_decor_14);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 14) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.decor_model_15,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_decor_15);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_decor_15);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 15) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.decor_model_16,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_decor_16);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_decor_16);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return decormodelsList.size();
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
