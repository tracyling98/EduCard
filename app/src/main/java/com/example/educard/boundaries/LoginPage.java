package com.example.educard.boundaries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.educard.testinfo.Credentials;
import com.example.loginapp.R;

public class LoginPage extends AppCompatActivity {

    // Some variables tag to the view UIs (private variables)
    private EditText UsernameField;
    private EditText PasswordField;
    private Button LoginButton;

    // Some String Variables
    String Username = "";
    String Password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        // Some actions to be done for the login Page
        UsernameField = findViewById(R.id.etUsername);
        PasswordField = findViewById(R.id.etPassword);
        LoginButton = findViewById(R.id.bLogin);

        // When the LoginButton is clicked (onclick listener)
        LoginButton.setOnClickListener(v -> {

            // Get string values from the fields
            Username = UsernameField.getText().toString();
            Password = PasswordField.getText().toString();

            // Make sure the login fields are not empty
            if(Username.isEmpty() || Password.isEmpty()){
                Toast.makeText(LoginPage.this, "Fields cannot be empty!", Toast.LENGTH_SHORT).show();
            } else {
                /*  Validate the login fields */
                // Go to the home page if credentials is correct
                if(validateCredential(Username, Password)){
                    Intent homepage_intent = new Intent(LoginPage.this, HomePage.class);
                    startActivity(homepage_intent);
                } else {
                    Toast.makeText(LoginPage.this, "Incorrect credentials!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Some methods to be used for the login
    private boolean validateCredential(String username, String password){
        Credentials credentials = new Credentials();
        return username.equals(credentials.adminUser()) && password.equals(credentials.adminPassword());
    }

}