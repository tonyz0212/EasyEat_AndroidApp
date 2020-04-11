package com.cse110easyeat.easyeat;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cse110easyeat.controller.EasyEatController;
import com.cse110easyeat.database.service.FirebaseHandlerService;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends Activity {
    private FirebaseAuth mAuth;
    //private FirebaseDatabase firebaseDb;

    private static final String TAG = "SignupActivity";
    private EditText fullNameField;
    private EditText passwordField;
    private EditText confirmPasswordField;
    private EditText emailField;
    private TextView loginLink;
    private Button signUpButton;
    private String fullName;
    private String email;
    private String password;
    private String verifyPassword;

//    private EasyEatController backendController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);
        Log.d(TAG, "created activity");
        // Create firebase user
        Log.d(TAG, "TEST");
        mAuth = FirebaseAuth.getInstance();
        fullNameField = (EditText) findViewById(R.id.fullName);
        passwordField = (EditText) findViewById(R.id.password);
        confirmPasswordField = (EditText) findViewById(R.id.confirmPassword);
        emailField = (EditText) findViewById(R.id.userEmailId);
        loginLink = (TextView) findViewById(R.id.already_user);
        signUpButton = (Button) findViewById(R.id.signUpBtn);

        // TODO: INTEGRATE IT WITH FIREBASE
       //backendController = new EasyEatController(getApplicationContext());

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Extract the input fields
                if (validateForm()) {
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        //backendController.registerUser(email, password, fullName);
                                        Log.d(TAG, "Account creation successful");
                                        final FirebaseUser user = mAuth.getCurrentUser();
                                        user.sendEmailVerification()
                                                .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            Log.d(TAG, "Email sent successfully");
                                                        } else {
                                                            Log.d(TAG, "Email not sent successfully");
                                                        }
                                                    }
                                                });
                                        Toast.makeText(getApplicationContext(), "Signup success - verify your email", Toast.LENGTH_SHORT).show();
                                        finish();
                                        // added
                                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                    } else {
                                        Log.d(TAG, "Account creation failed" + task.getException());
                                        Toast.makeText(getApplicationContext(), "Signup failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                // added
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();
    }

    private boolean validateForm() {
        fullName = fullNameField.getText().toString();
        email = emailField.getText().toString();
        password = passwordField.getText().toString();
        verifyPassword = confirmPasswordField.getText().toString();
        if (fullName.matches("") || email.matches("") ||
                password.matches("") || verifyPassword.matches("")) {
            Log.d(TAG, "One of the input fields is empty");
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!password.matches(verifyPassword)) {
            Log.d(TAG, "Password does not match");
            Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}