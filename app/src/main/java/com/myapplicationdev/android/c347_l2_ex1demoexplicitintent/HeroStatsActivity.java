package com.myapplicationdev.android.c347_l2_ex1demoexplicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HeroStatsActivity extends AppCompatActivity {

    TextView tvName, tvStrength, tvTechnicalProwess;
    Button btnLike, btnDislike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stats);

        // Get the intent
        Intent i = getIntent();

        // Get the Hero object first activity put in Intent
        Hero hero = (Hero) i.getSerializableExtra("hero");

        TextView tvName = findViewById(R.id.textViewName);
        TextView tvStrength = findViewById(R.id.textViewStrength);
        TextView tvTechnicalProwess = findViewById(R.id.textViewTechnicalProwess);
        btnLike = findViewById(R.id.buttonLike);
        btnDislike = findViewById(R.id.buttonDislike);


        // Use getters of Hero object to get the attributes
        tvName.setText(hero.getName());
        tvStrength.setText("Strength: " + hero.getStrength());
        tvTechnicalProwess.setText("Technical: " + hero.getTechnicalProwess());

        // When button Like is clicked, set the results
        //  accordingly and finish() to close this act.
        btnLike.setOnClickListener(arg0 -> {

            // Create intent & pass in String data
            Intent i12 = new Intent();
            i12.putExtra("liking", "liked");

            // Set result to RESULT_OK to indicate normal
            // response and pass in the intent containing the "like"
            setResult(RESULT_OK, i12);
            finish();
        });

        // When button Dislike is clicked, set the results
        // accordingly and finish() to close this activity
        btnDislike.setOnClickListener(arg0 -> {

            //Create intent & pass in String data
            Intent i1 = new Intent();
            i1.putExtra("liking", "disliked");

            // Set result to RESULT_OK to indicate normal
            // response and pass in the intent containing the "dislike"
            setResult(RESULT_OK, i1);
            finish();
        });

    }

}