package com.byteforce_crew.educard.boundaries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.byteforce_crew.educard.entities.User;
import com.byteforce_crew.educard.R;
import com.byteforce_crew.educard.enums.Country;
import com.byteforce_crew.educard.enums.Gender;
import com.byteforce_crew.educard.enums.User_Type;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginPage extends AppCompatActivity {

    // Some variable
    public boolean valid = false;

    // User attributes for parcelable -- If any --
    public static final String USER = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        // UI element tag to variables
        EditText UsernameField = findViewById(R.id.etLogin_username);
        EditText PasswordField = findViewById(R.id.etLogin_password);
        Button loginButton = findViewById(R.id.btnLogin);
        TextView registerLink = findViewById(R.id.tvLogin_RegisterLink);

        /* ================
         On click listener
        ===================*/

        // Direct to Register Page
        registerLink.setOnClickListener(v -> goRegisterPage());

        // Validate and Direct to Home Page: Pass in variable fields for validation
        loginButton.setOnClickListener(v -> loginValidate(UsernameField, PasswordField));
    }

    // -- Some methods to be used for the login --
    private void verifyCredentials(String username, String password) {

        // -- Access Firestore Instance from activity --
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // -- Attach listener: check if user document found --
        db.collection("User").document(username).get().addOnSuccessListener(documentSnapshot -> {

            // -- If the user is found --
            if(documentSnapshot.exists()) {

                // -- Store found user information from database --
                User user = documentSnapshot.toObject(User.class);

                // -- User object not null and password correct --
                if (user != null && user.getPassword().equals(password)) {
                    user.setUsername(username);
                    System.out.println(user.toString());

                    // -- Go to the home page if credentials is correct (pass in user_type) --
                    User user_no_password = new User(user.getUsername(), user.getEmail(), user.getFirstname(), user.getLastname(),
                            user.getUsertype(), user.getGender(), user.getNationality());
                    goHomePage(user_no_password);

                } else{
                    // -- Wrong password
                    Toast.makeText(LoginPage.this, "Incorrect credentials!", Toast.LENGTH_SHORT).show();
                }
            } else {
                // -- Wrong username --
                Toast.makeText(LoginPage.this, "Incorrect credentials!", Toast.LENGTH_SHORT).show();
            }
        })
        .addOnFailureListener(e-> Toast.makeText(LoginPage.this, "Error getting data", Toast.LENGTH_SHORT).show());

    }

    /*  -- Validate the login fields -- */
    private void loginValidate(EditText usernameField, EditText passwordField){

        // -- Get string values from the fields --
        String Username = usernameField.getText().toString();
        String Password = passwordField.getText().toString();

        // -- login fields string are empty to display message --
        if (Username.isEmpty() || Password.isEmpty()) {
            Toast.makeText(LoginPage.this, "Fields cannot be empty!", Toast.LENGTH_SHORT).show();
        } else {

            // -- Check the credentials --
            verifyCredentials(Username, Password);
        }
    }

    private void goHomePage(User user){

        /* -- Direct to respective home pages -- by user_type (if any) -- */

        // Using gson + shared preferences to transfer data

        // -- Go to home page --
        Intent HomeIntent = new Intent(LoginPage.this, HomePage.class);
        HomeIntent.putExtra(USER, user);
        startActivity(HomeIntent);
    }

    private void goRegisterPage(){

        // -- Go to register page activity --
        startActivity(new Intent(LoginPage.this, RegistrationPage.class));
    }
}