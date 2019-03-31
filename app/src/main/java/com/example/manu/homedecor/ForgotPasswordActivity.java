package com.example.manu.homedecor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
public class ForgotPasswordActivity extends AppCompatActivity {

    EditText passwordemail;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        passwordemail=(EditText)findViewById(R.id.password_email);
        firebaseAuth=FirebaseAuth.getInstance();
    }
    public void otpverification(View view) {
        String usermail=passwordemail.getText().toString().trim();
        if (usermail.equals(""))
        {
            Toast.makeText(ForgotPasswordActivity.this,"please enter you registered Email Id",Toast.LENGTH_SHORT).show();
        }else {
            firebaseAuth.sendPasswordResetEmail(usermail).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(ForgotPasswordActivity.this,"Password Reset Email Send",Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(ForgotPasswordActivity.this,LoginActivity.class));
                    }else {
                        Toast.makeText(ForgotPasswordActivity.this,"Error in sendind password reset email",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
