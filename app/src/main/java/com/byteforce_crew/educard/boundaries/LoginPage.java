package com.byteforce_crew.educard.boundaries;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.byteforce_crew.educard.entities.User;
import com.byteforce_crew.educard.testinfo.Credentials;
import com.byteforce_crew.educard.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginPage extends AppCompatActivity {

    // Some variable
    public boolean valid = false;

    // User attributes from Firestore: database
    public static final String PASSWORD = "password";
    public static final String USER_TYPE = "user_type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        // UI element tag to variables
        EditText UsernameField = findViewById(R.id.etUsername);
        EditText PasswordField = findViewById(R.id.etPassword);
        Button loginButton = findViewById(R.id.bLogin);
        TextView registerLink = findViewById(R.id.tvRegisterLink);

        /* ================
         On click listener
        ===================*/

        // Direct to Register Page
        registerLink.setOnClickListener(v -> goRegisterPage());

        // Validate and Direct to Home Page: Pass in variable fields for validation
        loginButton.setOnClickListener(v -> loginValidate(UsernameField, PasswordField));
    }

    // Some methods to be used for the login
    private void verifyCredentials(String username, String password) {

        // Cross check with the credentials in the Firestore
        CollectionReference userRef = FirebaseFirestore.getInstance().collection("User"); // User Collection

        // Attach listener: check if user document found
        userRef.document(username).get().addOnSuccessListener(documentSnapshot -> {

            // If the user is found
            if(documentSnapshot.exists()) {

                // Store found user information from database
                User user = documentSnapshot.toObject(User.class);

                // User object not null and password correct
                if (user != null && user.getPassword().equals(password)) {

                    // Go to the home page if credentials is correct (pass in user_type)
                    goHomePage();

                } else{
                    Toast.makeText(LoginPage.this, "Incorrect credentials!", Toast.LENGTH_SHORT).show();
                }
            }
        })
        .addOnFailureListener(e-> Toast.makeText(LoginPage.this, "Error getting data", Toast.LENGTH_SHORT).show());

    }

    /*  Validate the login fields */
    private void loginValidate(EditText usernameField, EditText passwordField){

        // Get string values from the fields
        String Username = usernameField.getText().toString();
        String Password = passwordField.getText().toString();

        // login fields string are empty to display message
        if (Username.isEmpty() || Password.isEmpty()) {
            Toast.makeText(LoginPage.this, "Fields cannot be empty!", Toast.LENGTH_SHORT).show();
        } else {

            // Check the credentials
            verifyCredentials(Username, Password);
        }
    }

    private void goHomePage(){

        /* Direct to respective home pages -- by user_type (if any) */
        // Go to home page
        startActivity(new Intent(LoginPage.this, HomePage.class));
    }

    private void goRegisterPage(){

        // Go to register page activity
        startActivity(new Intent(LoginPage.this, RegistrationPage.class));
    }
}