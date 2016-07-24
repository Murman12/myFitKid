package com.example.lalel.myfitkid;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.home);

        Button b1 = (Button) findViewById(R.id.walkBtn);
        if (b1 != null) {
            b1.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i1 = new Intent(HomeActivity.this, Walk.class);
                    startActivity(i1);
                }
            });
        }

        Button b2 = (Button) findViewById(R.id.exerciseBtn);
        if (b2 != null) {
            b2.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i2 = new Intent(HomeActivity.this, ExerciseInfo.class);
                    startActivity(i2);
                }
            });
        }
        Button b3 = (Button) findViewById(R.id.achieveBtn);
        if (b3 != null) {
            b3.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i3 = new Intent(HomeActivity.this, Achievement.class);
                    startActivity(i3);
                }
            });
        }

        Button b4 = (Button) findViewById(R.id.questBtn);
        if (b4 != null) {
            b4.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i4 = new Intent(HomeActivity.this, Feedback.class);
                    startActivity(i4);
                }
            });
        }
    }

}
