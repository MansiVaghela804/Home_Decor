package com.example.manu.homedecor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText useremail,userpassword;
    DatabaseHelper myhelper;
    Button btnsignin;
    TextView txt1,txt2;

    int counter = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        useremail = (EditText)findViewById(R.id.et_email);
        userpassword = (EditText)findViewById(R.id.et_password);
//        myhelper = new DatabaseHelper(LoginActivity.this);

        btnsignin = (Button)findViewById(R.id.signin);
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(useremail.getText().toString().equals("admin") &&
                        userpassword.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Login Sucessfully",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

//                    txt2.setVisibility(View.VISIBLE);
//                    txt2.setBackgroundColor(Color.RED);
//                    counter--;
//                    txt2.setText(Integer.toString(counter));
//
//                    if (counter == 0) {
//                        btnsignin.setEnabled(false);
//                    }
                }

//                Toast.makeText(LoginActivity.this, "Login Sucessfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(intent);
//                TableNotes notes = new TableNotes();
//                notes.setUsername(useremail.getText().toString());
//                notes.setUserpassword(userpassword.getText().toString());
//                myhelper.insertData(notes);
            }
        });
        txt1 = (TextView)findViewById(R.id.registration);
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
