package com.example.manu.homedecor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BathLaundaryActivity extends AppCompatActivity {

    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bath_laundary);
        back = (ImageView)findViewById(R.id.back_bath_laundry);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BathLaundaryActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
