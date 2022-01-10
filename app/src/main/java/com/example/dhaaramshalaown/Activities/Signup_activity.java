package com.example.dhaaramshalaown.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Domain.User;
import com.example.dhaaramshalaown.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Signup_activity extends AppCompatActivity {

    private EditText mname,contactNumber,mpassword,mmail,cpassword;
    private ProgressBar progressBar;
    private Button signupbtn;
    private FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup);

        mname=findViewById(R.id.nameSignupPage);
        cpassword=findViewById(R. id.confirmPasswordSignupPage);
        mmail=findViewById(R.id.emailAddressSignupPage);
        mpassword=findViewById(R.id.passwordSignupPage);
        signupbtn=findViewById(R.id.signupSignupPageBtn);
        contactNumber=findViewById(R.id.numberSignupPage);
        progressBar=findViewById(R.id.progressBar);
        mauth=FirebaseAuth.getInstance();

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=mname.getText().toString();
                String email=mmail.getText().toString();
                String password=mpassword.getText().toString();
                String number=contactNumber.getText().toString();
                String ccpassword=cpassword.getText().toString();

                if (number.isEmpty()){
                    contactNumber.setError("Enter your number!");
                    contactNumber.requestFocus();
                    return;
                }
                if(number.length()!=10){
                    contactNumber.setError("Enter valid phone number");
                    contactNumber.requestFocus();
                    return;

                }

                if(name.isEmpty()){
                    mname.setError("Full name is required!");
                    mname.requestFocus();
                    return;
                }
                if(email.isEmpty()){
                    mmail.setError("Enter the mail id!");
                    mmail.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    mmail.setError("email not valid!");
                    mmail.requestFocus();
                    return;
                }
                if (password.isEmpty()){
                    mpassword.setError("enter password!");
                    mpassword.requestFocus();
                    return;
                }
                if (password.length()<6){
                    mpassword.setError("password too short!");
                    mpassword.requestFocus();
                    return;
                }
                if(!(ccpassword.equals(password)))
                {
                    cpassword.setError("password does not match");
                    cpassword.requestFocus();
                    return;
                }



                User user =new User(name,email,number,"00");

                progressBar.setVisibility(View.VISIBLE);
                mauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                                                               @Override public void onComplete(@NonNull Task<AuthResult> task)
                                                                                               {
                                                                                                   if(task.isSuccessful()){
                                                                                                       String uid=FirebaseAuth.getInstance().getCurrentUser().getUid();
                                                                                                       FirebaseDatabase.getInstance().getReference("User").child(uid).setValue(user)
                                                                                                               .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                                                   @Override
                                                                                                                   public void onComplete(@NonNull Task<Void> task) {
                                                                                                                       if(task.isSuccessful()) {
                                                                                                                           Toast.makeText(Signup_activity.this, "User successfully registered", Toast.LENGTH_LONG).show();
                                                                                                                           progressBar.setVisibility(View.GONE);
                                                                                                                           // redirect to home
                                                                                                                           //for testing to login
                                                                                                                           FirebaseAuth.getInstance().signOut();
                                                                                                                           startActivity(new Intent(Signup_activity.this,MainActivity.class));
                                                                                                                       }else {
                                                                                                                           Toast.makeText(Signup_activity.this, "some error occurred", Toast.LENGTH_LONG).show();
                                                                                                                           progressBar.setVisibility(View.GONE);
                                                                                                                       }
                                                                                                                   }
                                                                                                               });




                                                                                                   }else {Toast.makeText(Signup_activity.this, ""+task.getException(), Toast.LENGTH_LONG).show();
                                                                                                       progressBar.setVisibility(View.GONE);

                                                                                                   }
                                                                                               }
                                                                                           }
                );



            }

        });






    }
}