package com.example.manu.homedecor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.manu.homedecor.APIInterface.APIinterface;
import com.example.manu.homedecor.APIManager.APICilent;
import com.example.manu.homedecor.Api_response.Registration;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.OnClickListener;

public class ContactUsActivity extends AppCompatActivity {

    ImageView back;
    EditText contact_problem;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        back = (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactUsActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        contact_problem =(EditText)findViewById(R.id.contact_problem);
        save=(Button) findViewById(R.id.contact_btn);
        save.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Loaddata();
            }
        });
    }
    public void Loaddata(){
        String contactproblem = contact_problem.getText().toString();

        APIinterface apIinterface = APICilent.getClient().create(APIinterface.class);

        Call<Registration> getBrandResponseCall = apIinterface.GET_BRAND_RESPONSE_CALL_CONTACT_US(contactproblem);

        getBrandResponseCall.enqueue(new Callback<Registration>() {
            @Override
            public void onResponse(Call<Registration> call, Response<Registration> response) {
                Toast.makeText(ContactUsActivity.this,response.body().getMsg(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Registration> call, Throwable t) {
                Toast.makeText(ContactUsActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("##", t.getMessage());
            }
        });

    }
}
