package com.example.restaurantapp.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.example.restaurantapp.MainActivity;
import com.example.restaurantapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignInActivity extends AppCompatActivity {
    TextInputLayout userName , password;
    ConstraintLayout btnLogin, logInField, signUpField;
    TextView logInText, signUpText;
    FirebaseFirestore firestore;
    FirebaseAuth mAuth;
    int checkField= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        init();
//        if(checkField == 0){
//            logInField.setBackground(ContextCompat.getDrawable(this, R.drawable.orange_button));
//
//        }
        logInField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logInField.setBackground(ContextCompat.getDrawable(view.getContext(), R.drawable.orange_button));
                logInText.setTextColor(Color.WHITE);
                signUpField.setBackground(ContextCompat.getDrawable(view.getContext(), R.drawable.white_button));
                signUpText.setTextColor(Color.BLACK);
            }
        });
        signUpField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logInField.setBackground(ContextCompat.getDrawable(view.getContext(), R.drawable.white_button));
                logInText.setTextColor(Color.BLACK);
                signUpField.setBackground(ContextCompat.getDrawable(view.getContext(), R.drawable.orange_button));
                signUpText.setTextColor(Color.WHITE);

            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserName = userName.getEditText().getText().toString();
                String Password = password.getEditText().getText().toString();
                Toast.makeText(SignInActivity.this, UserName, Toast.LENGTH_SHORT).show();
                mAuth.signInWithEmailAndPassword(UserName, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(SignInActivity.this, "Login is success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignInActivity.this, MainActivity.class));
                    }
                });
                //Register Account
//                mAuth.createUserWithEmailAndPassword(UserName, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//                            String uid = task.getResult().getUser().getUid();
//                            Map<String,Object> user = new HashMap<>();
//                            user.put("uid", uid);
//                            user.put("username", UserName);
//                            user.put("password", Password);
//                            firestore.collection("users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                @Override
//                                public void onSuccess(DocumentReference documentReference) {
//                                    startActivity(new Intent(SignInActivity.this, MainActivity.class));
//                                }
//                            });
//                        }else{
//                            Toast.makeText(SignInActivity.this, "Failed to register!Try again!", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
            }
        });
    }

    public void init(){
        firestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.loginBtn);
        logInField = findViewById(R.id.logInField);
        signUpField = findViewById(R.id.signUpField);
        signUpText = findViewById(R.id.signUpFieldText);
        logInText = findViewById(R.id.logInFieldText);
    }
}