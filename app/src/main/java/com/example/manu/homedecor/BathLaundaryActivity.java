package com.example.manu.homedecor;
//model image pending
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

public class BathLaundaryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Models> bathmodelsList;
    ImageView back;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bath_laundary);

        bathmodelsList = new ArrayList<>();
        BathModelsAdapter mAdapter = new BathModelsAdapter(bathmodelsList);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview5);

        Models models[] = {new Models(R.drawable.kitchen_1, "Model 1"),
                new Models(R.drawable.kitchen_2, "Model 2"),
                new Models(R.drawable.kitchen_3, "Model 3"),
                new Models(R.drawable.kitchen_4, "Model 4"),
                new Models(R.drawable.kitchen_5, "Model 5"),
                new Models(R.drawable.kitchen_6, "Model 6"),
                new Models(R.drawable.kitchen_7,"Model 7"),
                new Models(R.drawable.kitchen_8, "Model 8"),
                new Models(R.drawable.kitchen_9, "Model 9"),
                new Models(R.drawable.kitchen_10, "Model 10")};


        for (int j = 0; j < 1; j++) {
            for (int i = 0; i < models.length; i++) {
                bathmodelsList.add(models[i]);
            }
        }
        // 2. set layoutManger
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        // 3. create an adapter

        // 4. set adapter
        recyclerView.setAdapter(mAdapter);

        back = (ImageView)findViewById(R.id.back_bath_laundry);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BathLaundaryActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
    public class Models {
        private int bathimgList;
        private String data;

        public Models(int bathimgList, String data) {
            this.bathimgList = bathimgList;
            this.data = data;
        }

        public int getBathimgList() {
            return bathimgList;
        }

        public void setBathimgList(int bathimgList) {
            this.bathimgList = bathimgList;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
    public class BathModelsAdapter extends RecyclerView.Adapter<BathModelsAdapter.ViewHolder> {

        private List<Models> bathmodelsList;

        public BathModelsAdapter(List<Models> bathmodelsList) {
            this.bathmodelsList = bathmodelsList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
            ViewHolder viewHolder = new ViewHolder(itemView);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Models models = bathmodelsList.get(position);
            holder.data.setText(models.getData());
            holder.bathimgList.setImageResource(models.getBathimgList());
        }

        @Override
        public int getItemCount() {
            return bathmodelsList.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView data;
            ImageView bathimgList;

            public ViewHolder(View itemView) {
                super(itemView);
                data = (TextView)itemView.findViewById(R.id.data);
                bathimgList = (ImageView) itemView.findViewById(R.id.imagelist);
            }
        }
    }
}
