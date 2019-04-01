package com.example.manu.homedecor;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText useremail,userpassword;
    Button btnsignin;
    TextView txt1,txt2;
    PreferenceManager preferenceManager;
    Button login;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        useremail = (EditText)findViewById(R.id.et_email);
        userpassword = (EditText)findViewById(R.id.et_password);
        login=(Button)findViewById(R.id.login);
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        FirebaseUser user=firebaseAuth.getCurrentUser();

//            if (user != null)
//            {
//                finish();
//                startActivity(new Intent(Login_Activity.this,MainActivity.class));
//            }


    }

    public void login(View view) {
        if (validate()) {
            validate(useremail.getText().toString(), userpassword.getText().toString());
        }
    }

    public void create_new_account(View view) {
        Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);

    }

    public void forgot_password(View view) {
        Intent intent=new Intent(LoginActivity.this,ForgotPasswordActivity.class);
        startActivity(intent);

    }
    private Boolean validate(){


        Boolean result=false;
        String name1=useremail.getText().toString();
        String password1=userpassword.getText().toString();

        if (name1.isEmpty() || password1.isEmpty()){
            Toast.makeText(LoginActivity.this,"Please enter all the details",Toast.LENGTH_LONG).show();
        }else {
            result =true;
        }
        return result;
    }
    private  void validate(String userName,String userPassword)
    {
        progressDialog.setMessage("Please Wait");
        progressDialog.show();
        progressDialog.setCancelable(false);
        firebaseAuth.signInWithEmailAndPassword(userName,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    checkEmailVerification();
                    progressDialog.dismiss();
                }
                else {
                    Toast.makeText(LoginActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
        });
    }
    private void checkEmailVerification()
    {
        FirebaseUser firebaseUser=firebaseAuth.getInstance().getCurrentUser();
        Boolean emailflag=firebaseUser.isEmailVerified();
        if (emailflag)
        {
            finish();
            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
        }
        {
            Toast.makeText(LoginActivity.this,"Verify your email",Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
    }
}


