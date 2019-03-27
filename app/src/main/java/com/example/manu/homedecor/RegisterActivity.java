package com.example.manu.homedecor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manu.homedecor.APIInterface.APIinterface;
import com.example.manu.homedecor.APIManager.APICilent;
import com.example.manu.homedecor.Api_response.Registration;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText first_name,last_name,email,contact_no,psw,confirm_psw;
    Button register;
    TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        first_name = (EditText) findViewById(R.id.textfirstname);
        last_name = (EditText) findViewById(R.id.textlastname);
        email = (EditText) findViewById(R.id.textemail);
        contact_no = (EditText)findViewById(R.id.textcontactno);
        psw = (EditText) findViewById(R.id.textpassword);
        confirm_psw = (EditText) findViewById(R.id.textconfirmpassword);
        register = (Button)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Loaddata();
            }
        });

        textView1 = (TextView)findViewById(R.id.signin);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    public void Loaddata() {
        String firstname = first_name.getText().toString();
        String lastname = last_name.getText().toString();
        String email1 = email.getText().toString();
        String contactno = contact_no.getText().toString();
        String pass = psw.getText().toString();
        String confirmpass = confirm_psw.getText().toString();

        APIinterface apIinterface = APICilent.getClient().create(APIinterface.class);

        Call<Registration> getBrandResponseCall = apIinterface.GET_BRAND_RESPONSE_CALL_REGISTER(firstname, lastname, email1,contactno,pass,confirmpass);

        getBrandResponseCall.enqueue(new Callback<Registration>() {
            @Override
            public void onResponse(Call<Registration> call, Response<Registration> response) {
                Toast.makeText(RegisterActivity.this,response.body().getMsg(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Registration> call, Throwable t) {
                Toast.makeText(RegisterActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("##", t.getMessage());
            }
        });
    }
}
