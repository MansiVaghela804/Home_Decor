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

public class DiningActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Models> diningmodelsList;
    private Context context = this;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining);

        diningmodelsList = new ArrayList<>();
        DiningModelsAdapter mAdapter = new DiningModelsAdapter(diningmodelsList);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview4);

        Models models[] = {new Models(R.drawable.dining_1, "Model 1"),
                new Models(R.drawable.dining_2, "Model 2"),
                new Models(R.drawable.dining_3, "Model 3"),
                new Models(R.drawable.dining_4, "Model 4"),
                new Models(R.drawable.dining_5, "Model 5"),
                new Models(R.drawable.dining_6, "Model 6"),
                new Models(R.drawable.dining_7,"Model 7"),
                new Models(R.drawable.dining_8, "Model 8"),
                new Models(R.drawable.dining_9, "Model 9"),
                new Models(R.drawable.dining_10, "Model 10")};


        for (int j = 0; j < 1; j++) {
            for (int i = 0; i < models.length; i++) {
                diningmodelsList.add(models[i]);
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

    public void backDining(View view) {
        Intent intent = new Intent(DiningActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    public class Models {
        private int diningimgList;
        private String data;

        public Models(int diningimgList, String data) {
            this.diningimgList = diningimgList;
            this.data = data;
        }

        public int getDiningimgList() {
            return diningimgList;
        }

        public void setDiningimgList(int diningimgList) {
            this.diningimgList = diningimgList;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }


    public class DiningModelsAdapter extends RecyclerView.Adapter<DiningModelsAdapter.ViewHolder> {

        private List<Models> diningmodelsList;

        public DiningModelsAdapter(List<Models> diningmodelsList) {
            this.diningmodelsList = diningmodelsList;
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
            Models models = diningmodelsList.get(position);
            holder.data.setText(models.getData());
            holder.diningimgList.setImageResource(models.getDiningimgList());
            holder.diningimgList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (position == 0) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.dining_model_one,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_dining_1);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_dining_1);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();

                    }
                    if (position == 1) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.dining_model_two,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_dining_2);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_dining_2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 2) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.dining_model_three,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_dining_3);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_dining_3);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 3) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.dining_model_four,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_dining_4);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_dining_4);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 4) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.dining_model_five,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_dining_5);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_dining_5);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 5) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.dining_model_six,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_dining_6);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_dining_6);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 6) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.dining_model_seven,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_dining_7);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_dining_7);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                    if (position == 7) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.dining_model_eight,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_dining_8);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_dining_8);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }if (position == 8) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.dining_model_nine,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_dining_9);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_dining_9);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }if (position == 9) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout_inflate = inflater.inflate(R.layout.dining_model_ten,null);
                        final  ImageView image1 = layout_inflate.findViewById(R.id.img_dining_10);
                        final TextView text1 = layout_inflate.findViewById(R.id.txt_dining_10);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setView(layout_inflate);
                        builder.show();
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return diningmodelsList.size();
        }
        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView data;
            ImageView diningimgList;

            public ViewHolder(View itemView) {
                super(itemView);
                data = (TextView)itemView.findViewById(R.id.data);
                diningimgList = (ImageView) itemView.findViewById(R.id.imagelist);
            }
        }
    }
}
