package com.example.android.pingpongscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    int score_A = 0;
    int score_B = 0;

    String ADMOB_APP_ID = "ca-app-pub-5769766240110227~5892263464";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, ADMOB_APP_ID);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        displayScore_A(score_A);
        displayScore_B(score_B);
    }

    /**
     * Add point for player A
     */
    public void addPoint_A(View view) {
        score_A++;
        displayScore_A(score_A);
    }

    /**
     * Add point for player B
     */
    public void addPoint_B(View view) {
        score_B++;
        displayScore_B(score_B);
    }

    /**
     * Reset Score
     */
    public void resetScore(View view) {
        score_A = 0;
        score_B = 0;
        displayScore_A(score_A);
        displayScore_B(score_B);
    }

    /**
     * Display Score for Player A
     *
     * @param score
     */
    private void displayScore_A(int score) {
        TextView score_A_textView = findViewById(R.id.scoreA_textView);
        score_A_textView.setText(String.valueOf(score));
    }

    /**
     * Display Score for Player B
     *
     * @param score
     */
    private void displayScore_B(int score) {
        TextView score_B_textView = findViewById(R.id.scoreB_textView);
        score_B_textView.setText(String.valueOf(score));
    }


}
