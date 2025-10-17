package com.example.loginpage; // Aapka package name

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText forgotUserEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        // UI component ko reference karna
        forgotUserEditText = findViewById(R.id.forgotUserEditText);
    }

    /**
     * Handles the Send Reset Link button click event.
     * Yeh password reset ka simulation karta hai.
     */
    public void resetPassword(View view) {
        String userInput = forgotUserEditText.getText().toString().trim();

        // 1. Validation: Check if field is empty
        if (userInput.isEmpty()) {
            Toast.makeText(this, "Please enter your Username or Email.", Toast.LENGTH_LONG).show();
            return;
        }

        // 2. SUCCESS Simulation (Hard-coded)
        // Real app mein yahaan server ko request jaati hai.
        Toast.makeText(this, "If a matching account is found, a reset link has been sent!", Toast.LENGTH_LONG).show();

        // Reset Link bhejne ke baad, user ko wapas Login Screen par bhej do
        finish();
    }
}