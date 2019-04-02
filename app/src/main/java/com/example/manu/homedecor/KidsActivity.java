package com.example.manu.homedecor;
//model image pending
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class KidsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Models> kidsmodelsList;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids);

        kidsmodelsList = new ArrayList<>();
        KidsModelsAdapter mAdapter = new KidsModelsAdapter(kidsmodelsList);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview6);

        Models models[] = {new Models(R.drawable.kids_1, "Model 1"),
                new Models(R.drawable.kids_2, "Model 2"),
                new Models(R.drawable.kids_3, "Model 3"),
                new Models(R.drawable.kids_4, "Model 4"),
                new Models(R.drawable.kids_5, "Model 5"),
                new Models(R.drawable.kids_6, "Model 6"),
                new Models(R.drawable.kids_7,"Model 7"),
                new Models(R.drawable.kids_8, "Model 8"),
                new Models(R.drawable.kids_9, "Model 9"),
                new Models(R.drawable.kids_10, "Model 10")};


        for (int j = 0; j < 1; j++) {
            for (int i = 0; i < models.length; i++) {
                kidsmodelsList.add(models[i]);
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

    public void backKids(View view) {
        Intent intent = new Intent(KidsActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    public class Models {
        private int kidsimgList;
        private String data;

        public Models(int kidsimgList, String data) {
            this.kidsimgList = kidsimgList;
            this.data = data;
        }

        public int getKidsimgList() {
            return kidsimgList;
        }

        public void setKidsimgList(int kidsimgList) {
            this.kidsimgList = kidsimgList;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
    public class KidsModelsAdapter extends RecyclerView.Adapter<KidsModelsAdapter.ViewHolder> {

        private List<Models> kidsmodelsList;

        public KidsModelsAdapter(List<Models> kidsmodelsList) {
            this.kidsmodelsList = kidsmodelsList;
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
            Models models = kidsmodelsList.get(position);
            holder.data.setText(models.getData());
            holder.kidsimgList.setImageResource(models.getKidsimgList());
        }

        @Override
        public int getItemCount() {
            return kidsmodelsList.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView data;
            ImageView kidsimgList;

            public ViewHolder(View itemView) {
                super(itemView);
                data = (TextView)itemView.findViewById(R.id.data);
                kidsimgList = (ImageView) itemView.findViewById(R.id.imagelist);
            }
        }
    }
}
