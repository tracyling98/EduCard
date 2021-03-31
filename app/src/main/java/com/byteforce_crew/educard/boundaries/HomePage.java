package com.byteforce_crew.educard.boundaries;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;


import com.byteforce_crew.educard.R;

// Show navigation and user profile details in this page
public class HomePage extends AppCompatActivity {

    /* -- Navigation Drawer -- */
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        /* -- Tagged to home page UIs -- */
        // -- Navigation Drawer --
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        ImageView profile_pic = findViewById(R.id.user_image);
        TextView account_name = findViewById(R.id.account_name);
        TextView account_email = findViewById(R.id.account_email);

        //profile_pic.setImageResource(R.drawable.ic_person);

        /* ================
         Listeners
        ===================*/
        // -- Drawer --
        drawer.addDrawerListener(toggle);
        toggle.syncState();


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