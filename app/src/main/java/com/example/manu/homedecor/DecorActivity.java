package com.example.manu.homedecor;

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

public class DecorActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Models> modelsList;
    ImageView back;
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
                new Models(R.drawable.decor_16, "Model 16"),
                new Models(R.drawable.decor_17, "Model 17"),
                new Models(R.drawable.decor_18, "Model 18"),
                new Models(R.drawable.decor_19, "Model 19"),
                new Models(R.drawable.decor_20,"Model 20")};


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
        back = (ImageView)findViewById(R.id.back_decor);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DecorActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
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
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Models models = modelsList.get(position);
            holder.data.setText(models.getData());
            holder.imagelist.setImageResource(models.getImagelist());

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
