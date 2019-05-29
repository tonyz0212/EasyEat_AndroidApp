package com.cse110easyeat.easyeat;

import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends Activity {
    private FirebaseAuth mAuth;
    private static final String TAG = "SignupActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);

        // Create firebase user
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart(){
        super.onStart();

        String email = null;
        String password = null;

        // Handle Input here
        // Put email into email, password into password
        // Following code attempts account creation

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            // Sign in success
                            Log.d(TAG, "createUser:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            // updateUI(user)

                            // Update next page UI with (user) as parameter
                        }else{
                            // Sign in fails
                            Log.w(TAG, "createUser:failure", task.getException());
                            Toast.makeText(SignupActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                            // updateUI(user)
                            // Update next page UI with (null) as parameter
                        }

                    }
            });
    }
}
