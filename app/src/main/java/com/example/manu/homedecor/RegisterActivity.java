package com.example.manu.homedecor;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    String userfirstname,userlastname,useremail,usercontactno,userpsw,userconfirmpsw;
    EditText first_name,last_name,email,contact_no,psw,confirm_psw;
    Button register;

    PreferenceManager preferenceManager;
    private FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    private ImageView userpic;
    String firstname,lastname,email1,contactno,password,confirmpsw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        preferenceManager = new PreferenceManager(this);
        setupUIView();

        progressDialog=new ProgressDialog(this);
        firebaseAuth =FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate())
                {
                    //upload data to the database
                    String user_email=email.getText().toString().trim();
                    String user_password=psw.getText().toString().trim();
                    progressDialog.setMessage("Please Wait");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                sendemailverification();
                            }
                        }
                    });
                }
            }
        });
    }

    private void setupUIView(){
        first_name = (EditText) findViewById(R.id.textfirstname);
        last_name = (EditText) findViewById(R.id.textlastname);
        email = (EditText) findViewById(R.id.textemail);
        contact_no = (EditText)findViewById(R.id.textcontactno);
        psw = (EditText) findViewById(R.id.textpassword);
        confirm_psw = (EditText) findViewById(R.id.textconfirmpassword);
        register=(Button)findViewById(R.id.register);
//        userpic=(ImageView)findViewById(R.id.user_pic);

    }
    private Boolean validate(){


        Boolean result=false;
        firstname=first_name.getText().toString();
        lastname = last_name.getText().toString();
        password=psw.getText().toString();
        email1=email.getText().toString();
        contactno=contact_no.getText().toString();
        password = psw.getText().toString();
        confirmpsw=confirm_psw.getText().toString();

        if (firstname.isEmpty() || lastname.isEmpty() ||email1.isEmpty() || contactno.isEmpty() || password.isEmpty() || confirmpsw.isEmpty()){
            Toast.makeText(RegisterActivity.this,"please enter all the details",Toast.LENGTH_LONG).show();

        }else {
            result =true;
        }
        return result;
    }
    public void backtologin(View view) {
        Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
    private void sendemailverification()
    {
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if (firebaseUser!=null)
        {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        sendUserData();
                        preferenceManager.setKeyValueString(VariableBag.FIRSTNAME,firstname);
                        preferenceManager.setKeyValueString(VariableBag.LASTNAME,lastname);
                        preferenceManager.setKeyValueString(VariableBag.EMAIL,email1);
                        preferenceManager.setKeyValueString(VariableBag.CONTACT_NO,contactno);
                        preferenceManager.setKeyValueString(VariableBag.CONFIRM_PASSWORD,confirmpsw);
                        Toast.makeText(RegisterActivity.this,"Successfully Registered, Verification Mail Send",Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    }else {
                        Toast.makeText(RegisterActivity.this,"verification mail has not been send !",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendUserData()
    {
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference myref=firebaseDatabase.getReference(firebaseAuth.getUid());
        UserProfile userProfile=new UserProfile(userfirstname,userlastname,useremail,usercontactno,userpsw,userconfirmpsw);
        myref.setValue(userProfile);
    }
}

