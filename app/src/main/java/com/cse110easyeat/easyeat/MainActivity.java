package com.cse110easyeat.easyeat;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.text.Collator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cse110easyeat.Profile;
import com.cse110easyeat.TinderCard;
import com.cse110easyeat.Utils;
import com.cse110easyeat.accountservices.login.FirebaseLoginService;
import com.google.firebase.auth.FirebaseAuth;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

public class MainActivity extends AppCompatActivity {
    private SwipePlaceHolderView mSwipeView;
    private Context mContext;
    private FirebaseAuth authenticator;
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    private FirebaseAuth mAuth;

//    private DrawerLayout dl;
//    private ActionBarDrawerToggle abdt;

    private Button loginButton;
    private EditText emailField;
    private EditText passwordField;
    private TextView signUpLink;

    private ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //    FirebaseLoginService testLogin = new FirebaseLoginService(this);
        //testLogin.createNewAccount("thisisbullshit310294912jdqkwjff1rh@gmail.com", "pwtest");
        //      testLogin.validateAccount("thisisbullshit310294912jdqkwjff1rh@gmail.com", "pwtest");
//        testLogin.sendEmailVerification();
        //  testLogin.signOut();
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.swipe_main);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Begin the transaction

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final NavigationView nav_view =  (NavigationView)findViewById(R.id.nav_view);

//        setContentView(R.layout.activity_main);
        dl=(DrawerLayout)findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(abdt);
        abdt.syncState();


        //nav_view.bringToFront();
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
                int id = Item.getItemId();
                if (id == R.id.setting){
                    Toast.makeText(MainActivity.this, "Setting", Toast.LENGTH_SHORT);
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    // Replace the contents of the container with the new fragment
                    ft.replace(R.id.mainFragment, new inputFragment());
                    // or ft.add(R.id.your_placeholder, new FooFragment());
                    // Complete the changes added above
                    ft.commit();
                }
//                else if (id == R.id.history){
//                    Toast.makeText(MainActivity.this, "History", Toast.LENGTH_SHORT);
//                    // TODO: TEST PAGE TEST
//                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                    ft.replace(R.id.mainFragment, new swipeCardFragment());
//                    ft.commit();
//                }
                else if (id == R.id.logout){
                    Toast.makeText(MainActivity.this, "Log Out", Toast.LENGTH_SHORT);
                    authenticator = FirebaseAuth.getInstance();
                    authenticator.getInstance().signOut();
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    // TODO: PAGE SHOULD NOT BE IN RETAINED FORM (TEMP WORKAROUND)
                    setContentView(R.layout.activity_main);
                    dl=(DrawerLayout)findViewById(R.id.dl);
                    abdt = new ActionBarDrawerToggle(MainActivity.this,dl,R.string.Open,R.string.Close);
                    abdt.setDrawerIndicatorEnabled(true);

                    dl.addDrawerListener(abdt);
                    abdt.syncState();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.mainFragment, new inputFragment());
                    ft.commit();

                    // END OF REPLACEMENT
                    startActivity(intent);

                }

                return true;
            }

        });
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.mainFragment, new inputFragment());
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Complete the changes added above
        ft.commit();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    // LOAD ANIMATION



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    // TRYING TO SAVE FRAGMENT INSTANCES
//    public void onCreate(Bundle savedInstanceState) {
//    ...
//        if (savedInstanceState != null) {
//            //Restore the fragment's instance
//            mContent = getSupportFragmentManager().getFragment(savedInstanceState, "myFragmentName");
//        ...
//        }
//    ...
//    }
//
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//        //Save the fragment's instance
//        getSupportFragmentManager().putFragment(outState, "myFragmentName", mContent);
//    }

}
