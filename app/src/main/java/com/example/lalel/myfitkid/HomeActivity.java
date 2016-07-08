package com.example.lalel.myfitkid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.ImageButton;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        /*
        Creating image button object and setting it to the walkButton then adding an onclick
        listener event to it, which will set the intent to the walkPage class and start its
        activity.
         */
         Button b1 = (Button) findViewById(R.id.walkBtn);
         b1.setOnClickListener(new OnClickListener() {

             @Override
             public void onClick(View v) {
                 Intent i1 = new Intent(HomeActivity.this, WalkPage.class);
                 startActivity(i1);
             }
         });
        /*
        Creating image button object and setting it to the accountButton then adding an onclick
        listener event to it, which will set the intent to the accountPage class and start its
        activity.
         */
        Button b2 = (Button) findViewById(R.id.accountBtn);
        b2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(HomeActivity.this, AccountPage.class);
                startActivity(i2);
            }
        });
         /*
        Creating image button object and setting it to the exerciseButton then adding an onclick
        listener event to it, which will set the intent to the exercisePage class and start its
        activity.
         */
        Button b3 = (Button) findViewById(R.id.exerciseBtn);
        b3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(HomeActivity.this, ExercisePage.class);
                startActivity(i3);
            }
        });
        Button b4 = (Button) findViewById(R.id.achieveBtn);
        b4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i4 = new Intent(HomeActivity.this, QuestPage.class);
                startActivity(i4);
            }
        });

        Button b5 = (Button) findViewById(R.id.questBtn);
        b5.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i5 = new Intent(HomeActivity.this, QuestPage.class);
                startActivity(i5);
            }
        });
    }

}
