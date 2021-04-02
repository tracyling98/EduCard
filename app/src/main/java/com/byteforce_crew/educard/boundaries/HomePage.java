package com.byteforce_crew.educard.boundaries;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.byteforce_crew.educard.R;
import com.byteforce_crew.educard.entities.User;
import com.google.android.material.navigation.NavigationView;

// Show navigation and user profile details in this page
public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    /* -- Navigation Drawer -- */
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        User user = getIntent().getParcelableExtra("user");

        // -- Debug --
        System.out.println(user.toString());

        /* -- Tagged to home page UIs -- */
        // -- Navigation Drawer  --
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        // NavigationView
        NavigationView navigationView = findViewById(R.id.nav_drawer_view);
        navigationView.setNavigationItemSelectedListener(this);

        // NavigationView Header (Child View)
        View headerView =  navigationView.getHeaderView(0);

        ImageView profile_pic = headerView.findViewById(R.id.user_image);
        TextView account_name = headerView.findViewById(R.id.account_name);
        TextView account_email = headerView.findViewById(R.id.account_email);

        // -- Setting User Information In The Drawer --
        String user_fullname = user.getFirstname() + " " + user.getLastname();
        account_name.setText(user_fullname);
        account_email.setText(user.getEmail());

        // profile_pic.setImageResource(R.drawable.ic_person);

        /* ================
         Listeners
        ===================*/
        // -- Drawer --
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        /* -- Toggle around the different navigation fragments -- */
        switch (item.getItemId()){
            case R.id.nav_student_account:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AccountFragment()).commit();
                break;
            case R.id.nav_student_modules:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EnrolledModulesFragment()).commit();
                break;
            case R.id.nav_logout:
                break;
        }

        // -- Close back the drawer when any navigation is being clicked on --
        drawer.closeDrawer(GravityCompat.START);

        // If return false: No item will be selected even when the action is triggered [Unexpected]
        return true;
    }

    // -- Close the navigation drawer: When in opened state --
    @Override
    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



}