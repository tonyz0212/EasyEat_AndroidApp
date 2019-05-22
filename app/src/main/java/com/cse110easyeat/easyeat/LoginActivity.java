package com.cse110easyeat.easyeat;

import com.cse110easyeat.controller.EasyEatController;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cse110easyeat.easyeat.R;

public class LoginActivity extends Activity {
    private Button loginButton;
    private EditText emailField;
    private EditText passwordField;
    private EasyEatController backendController;

    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page_layout);
        getActionBar().setDisplayHomeAsUpEnabled(true);
//        backendController = new EasyEatController(getApplicationContext());

        // Assign listeners to button
        loginButton = (Button) findViewById(R.id.loginBtn);
        emailField = (EditText) findViewById(R.id.login_emailid);
        passwordField = (EditText) findViewById(R.id.login_password);
        Log.d(TAG, "buttons created");

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean loginSuccess = false;
                // Check for input
                Log.d(TAG, "LOGIN BUTTON CLICKED");
                if (emailField.getText().length() > 0 && passwordField.getText().length() > 0) {
                    loginSuccess = backendController.loginUser(emailField.getText().toString(),
                            passwordField.getText().toString());
                }

                if (!loginSuccess) {
                    Toast.makeText(LoginActivity.this, "TEST", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private View.OnClickListener createLoginListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean loginSuccess = false;
                // Check for input
                Log.d(TAG, "LOGIN BUTTON CLICKED");
                if (emailField.getText().length() > 0 && passwordField.getText().length() > 0) {
//                    loginSuccess = backendController.loginUser(emailField.getText().toString(),
//                            passwordField.getText().toString());
                    Toast.makeText(getApplicationContext(), "TEST true", Toast.LENGTH_SHORT).show();
                }

                if (!loginSuccess) {
                    Toast.makeText(getApplicationContext(), "TEST", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }


}
