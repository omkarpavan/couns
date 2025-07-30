package com.example.couns;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button presentBtn, absentBtn, notNeededBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure this matches your layout file name

        // Initialize buttons
        presentBtn = findViewById(R.id.button1); // Present
        absentBtn = findViewById(R.id.button2);  // Absent
        notNeededBtn = findViewById(R.id.button3); // Not Needed

        // Present button logic
        presentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Disable the other buttons
                absentBtn.setEnabled(false);
                notNeededBtn.setEnabled(false);

                // Navigate to feedback page
                Intent intent = new Intent(MainActivity.this, FeedbackActivity.class);
                startActivity(intent);
            }
        });

        // Absent button logic
        absentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Disable the other buttons
                presentBtn.setEnabled(false);
                notNeededBtn.setEnabled(false);

                // Show popup
                showPopup("You are absent. No need to fill the form.");
            }
        });

        // Not Needed button logic
        notNeededBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Disable the other buttons
                presentBtn.setEnabled(false);
                absentBtn.setEnabled(false);

                // Show popup
                showPopup("No need to fill the form you are absent.");
            }
        });
    }

    // Function to show a popup message
    private void showPopup(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Info")
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }
}
