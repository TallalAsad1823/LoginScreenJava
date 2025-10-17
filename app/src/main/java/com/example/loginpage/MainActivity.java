package com.example.loginpage;

import android.content.Intent; // ⭐️ Ye line zaroori hai Intent use karne ke liye ⭐️
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Get references to UI components
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        messageTextView = findViewById(R.id.messageTextView);

        // Reset Button Listener
        findViewById(R.id.resetButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameEditText.setText("");
                passwordEditText.setText("");
                messageTextView.setText("");
                Toast.makeText(MainActivity.this, "Input fields reset!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Handles the Login button click event.
     */
    public void login(View v) {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // 1. Validate user input (prevent empty fields)
        if (username.isEmpty() || password.isEmpty()) {
            messageTextView.setText("ERROR: Username and password cannot be empty.");
            Toast.makeText(this, "Please fill in both fields.", Toast.LENGTH_SHORT).show();
            return;
        }

        // 2. Hardcoded validation
        if (username.equals("admin") && password.equals("password")) {
            // SUCCESS block: Redirect to Landing Screen
            messageTextView.setText("SUCCESS: Logging in...");
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_LONG).show();

            // Intent: Login Screen se Landing Screen par jaana
            Intent intent = new Intent(MainActivity.this, LandingActivity.class);
            startActivity(intent);
            finish(); // Optional: Login screen ko band kar deta hai

        } else {
            // ⭐️ FAILURE block: Ye code pehle missing tha ⭐️
            String failureMessage = "FAILURE: Invalid username or password.";
            messageTextView.setText(failureMessage);
            Toast.makeText(this, "Login Failed. Try again.", Toast.LENGTH_LONG).show();
        }
    }

    // ⭐️ Naye methods: Register aur Forgot Password pages kholne ke liye ⭐️
    public void openRegistration(View view) {
        Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void openForgotPassword(View view) {
        Intent intent = new Intent(MainActivity.this, ForgotPasswordActivity.class);
        startActivity(intent);
    }
}