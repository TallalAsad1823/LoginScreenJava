package com.example.loginpage; // Aapka package name

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // UI components ko reference karna
        usernameEditText = findViewById(R.id.regUsernameEditText);
        passwordEditText = findViewById(R.id.regPasswordEditText);
        confirmPasswordEditText = findViewById(R.id.regConfirmPasswordEditText);
    }

    /**
     * Handles the Register button click event.
     */
    public void registerUser(View view) {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String confirmPassword = confirmPasswordEditText.getText().toString().trim();

        // 1. Validation: Check if fields are empty
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_LONG).show();
            return;
        }

        // 2. Validation: Check if passwords match
        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_LONG).show();
            return;
        }

        // 3. SUCCESS (Hard-coded registration)
        // Note: Real apps mein yahaan database/Firebase mein data save hota hai.
        Toast.makeText(this, "Registration Successful! Please log in.", Toast.LENGTH_LONG).show();

        // Registration ke baad, user ko wapas Login Screen par bhej do
        finish();
    }
}