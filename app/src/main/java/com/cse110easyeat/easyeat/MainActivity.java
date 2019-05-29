package com.cse110easyeat.easyeat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button loginButton;
    private EditText emailField;
    private EditText passwordField;
    private static final String TAG = "MainActivity";

    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loginButton = (Button) findViewById(R.id.loginBtn);
        emailField = (EditText) findViewById(R.id.login_emailid);
        passwordField = (EditText) findViewById(R.id.login_password);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                boolean loginSuccess = false;
//                // Check for input
//                Log.d(TAG, "LOGIN BUTTON CLICKED");
//                if (emailField.getText().length() > 0 && passwordField.getText().length() > 0) {
////                    loginSuccess = backendController.loginUser(emailField.getText().toString(),
////                            passwordField.getText().toString());
//                    Toast.makeText(MainActivity.this, "TEST SUCCESS", Toast.LENGTH_SHORT).show();
//                }
//
//                if (!loginSuccess) {
//                    Toast.makeText(MainActivity.this, "TEST", Toast.LENGTH_SHORT).show();
//                }
//                finish();
//                startActivity(new Intent(getApplicationContext(), SignupActivity.class));
                Log.d("Hi","hello");
            }
        });

    }
}
