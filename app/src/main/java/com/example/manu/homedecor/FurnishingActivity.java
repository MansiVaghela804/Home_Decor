package com.example.manu.homedecor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FurnishingActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Models> furnishingmodelsList;
    ImageView back;
    private RecyclerView.LayoutManager fLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furnishing);

        furnishingmodelsList = new ArrayList<>();
        FurnishingModelsAdappter mAdapter = new FurnishingModelsAdappter(furnishingmodelsList);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview3);

        Models models[] = {new Models(R.drawable.furniture_1, "Android"),
                new Models(R.drawable.furniture_2, "Rate"),
                new Models(R.drawable.furniture_3, "Send"),
                new Models(R.drawable.furniture_4, "Share"),
                new Models(R.drawable.furniture_5, "Share"),
                new Models(R.drawable.furniture_6, "Share"),
                new Models(R.drawable.furniture_8, "Share")};


        for (int j = 0; j < 1; j++) {
            for (int i = 0; i < models.length; i++) {
                furnishingmodelsList.add(models[i]);
            }
        }
        // 2. set layoutManger
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(fLayoutManager);
        // 3. create an adapter

        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        back = (ImageView)findViewById(R.id.back_furnishing);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FurnishingActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
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
    public class FurnishingModelsAdappter extends RecyclerView.Adapter<FurnishingModelsAdappter.ViewHolder>{

        private List<Models> furnishingmodelsList;

        public FurnishingModelsAdappter(List<Models> furnishingmodelsList) {
            this.furnishingmodelsList = furnishingmodelsList;
        }


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
            ViewHolder viewHolder = new ViewHolder(itemView);
            return new FurnishingModelsAdappter.ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
                Models models = furnishingmodelsList.get(position);
            holder.data.setText(models.getData());
            holder.imagelist.setImageResource(models.getImagelist());

        }

        @Override
        public int getItemCount() {
            return furnishingmodelsList.size();
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
