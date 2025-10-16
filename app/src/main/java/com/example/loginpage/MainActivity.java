package com.example.loginpage; // Replace with your package name

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private TextView messageTextView;
    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Get references to UI components
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        messageTextView = findViewById(R.id.messageTextView);
        resetButton = findViewById(R.id.resetButton);

        // 2. Setup Reset Button Listener
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear fields and show Toast
                usernameEditText.setText("");
                passwordEditText.setText("");
                messageTextView.setText("");
                Toast.makeText(MainActivity.this, "Input fields reset!", Toast.LENGTH_SHORT).show();
            }
        });

        // The Login button's listener is set via the 'android:onClick="login"' attribute in the XML.
    }

    /**
     * Handles the Login button click event (set in XML via android:onClick="login")
     * @param v The view (Button) that was clicked.
     */
    public void login(View v) {
        // Get user input as strings
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // 1. Validate user input (prevent empty fields)
        if (username.isEmpty() || password.isEmpty()) {
            messageTextView.setText("ERROR: Username and password cannot be empty.");
            // Also show a brief Toast for short notification
            Toast.makeText(this, "Please fill in both fields.", Toast.LENGTH_SHORT).show();
            return; // Stop execution if fields are empty
        }

        // 2. Simple, hardcoded validation (for now)
        // You would replace this with actual authentication later.
        if (username.equals("admin") && password.equals("password")) {
            // Successful Login
            String successMessage = "SUCCESS: Welcome, " + username + "!";
            messageTextView.setText(successMessage);
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_LONG).show();
        } else {
            // Failed Login
            String failureMessage = "FAILURE: Invalid username or password.";
            messageTextView.setText(failureMessage);
            Toast.makeText(this, "Login Failed. Try again.", Toast.LENGTH_LONG).show();
        }
    }
}