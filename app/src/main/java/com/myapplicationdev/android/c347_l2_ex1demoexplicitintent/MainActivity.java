package com.myapplicationdev.android.c347_l2_ex1demoexplicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int requestCodeForSupermanStats = 1;
    int requestCodeForBatmanStats = 2;
    TextView tvSuperman, tvBatman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvSuperman = findViewById(R.id.textViewSuperman);
        TextView tvBatman = findViewById(R.id.textViewBatman);

        // Set listener to handle the clicking of Superman TextView
        tvSuperman.setOnClickListener(arg0 -> {

            // Create Hero object of strength 100 & technical 60
            Hero superman = new Hero("Superman", 100, 60);

            // Put hero object in intent
            Intent i = new Intent(MainActivity.this, HeroStatsActivity.class);
            i.putExtra("hero", superman);
            startActivityForResult(i, requestCodeForSupermanStats);   // Start the activity
        });

        // Set listener to handle the clicking of Batman TextView
        tvBatman.setOnClickListener(arg0 -> {

            // Create Hero object of strength 60 & technical 90
            Hero batman = new Hero("Batman", 60, 90);

            // Put hero object in intent
            Intent i = new Intent(MainActivity.this, HeroStatsActivity.class);
            i.putExtra("hero", batman);
            startActivityForResult(i, requestCodeForBatmanStats);   // Start the activity
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if (resultCode == RESULT_OK) {
            if (data != null) {

                // Get data passed back from 2nd activity
                String liking = data.getStringExtra("liking");
                String statement;

                // If it is activity started by clicking  Superman, create corresponding String
                if (requestCode == requestCodeForSupermanStats) {
                    statement = "You " + liking + " Superman.";
                    // If 2nd activity started by clicking Batman, create a corresponding String
                } else {
                    statement = "You " + liking + " Batman.";
                }


                Toast.makeText(MainActivity.this, statement, Toast.LENGTH_LONG).show();

            }
        }
    }
}
