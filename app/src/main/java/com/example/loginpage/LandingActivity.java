package com.example.loginpage; // Aapka package name

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        // Yahaan filhaal koi extra setup ki zaroorat nahi hai.
    }

    /**
     * Handles the Logout button click event.
     * User ko wapas Login screen par bhejta hai.
     */
    public void logout(View view) {
        // Ek chhota message dikhana
        Toast.makeText(this, "Logged out successfully!", Toast.LENGTH_SHORT).show();

        // Intent: Landing Screen se wapas MainActivity (Login) par jaana
        Intent intent = new Intent(LandingActivity.this, MainActivity.class);

        // FLAG_ACTIVITY_CLEAR_TASK aur FLAG_ACTIVITY_NEW_TASK isliye use karte hain
        // taaki user 'Back' button dabakar Landing screen par wapas na ja sake.
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(intent);
        finish(); // Current Activity ko band karna
    }
}