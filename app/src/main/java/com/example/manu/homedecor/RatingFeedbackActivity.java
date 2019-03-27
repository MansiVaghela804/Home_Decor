package com.example.manu.homedecor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manu.homedecor.APIInterface.APIinterface;
import com.example.manu.homedecor.APIManager.APICilent;
import com.example.manu.homedecor.Api_response.Registration;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RatingFeedbackActivity extends AppCompatActivity {

    TextView txt1,txt2,rate;
    EditText fb;
    RatingBar ratingBar;
    View view;
    ImageView back;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_feedback);

        txt1 = (TextView) findViewById(R.id.text_feedback1);
        txt2 = (TextView) findViewById(R.id.text_feedback2);
        ratingBar = (RatingBar)findViewById(R.id.rating) ;

        view = (View)findViewById(R.id.view);
        fb = (EditText)findViewById(R.id.edittext_feedback);
        btn = (Button) findViewById(R.id.submit_feedback);

        back = (ImageView)findViewById(R.id.back_rating_feedback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RatingFeedbackActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Loaddata();
            }
        });
    }
    public void Loaddata(){
        String feedback = fb.getText().toString();
        APIinterface apIinterface = APICilent.getClient().create(APIinterface.class);

        Call<Registration> getBrandResponseCall = apIinterface.GET_BRAND_RESPONSE_CALL_RATING_FEEDBACK(feedback);

        getBrandResponseCall.enqueue(new Callback<Registration>() {
            @Override
            public void onResponse(Call<Registration> call, Response<Registration> response) {
                Toast.makeText(RatingFeedbackActivity.this,response.body().getMsg(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Registration> call, Throwable t) {
                Toast.makeText(RatingFeedbackActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("##", t.getMessage());
            }
        });
    }
}
