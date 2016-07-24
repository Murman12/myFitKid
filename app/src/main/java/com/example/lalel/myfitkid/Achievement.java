package com.example.lalel.myfitkid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;



/**
 * Created by lalel on 16/04/2016.
 */
public class Achievement extends AppCompatActivity {

    private TextView textViewScore;
    private TextView textScoreInfo;
    private TextView achievementOne;
    private TextView achievementTwo;
    private TextView achievementThree;
    private TextView achievementFour;
    private TextView achievementFive;
    private ImageButton achieved1;
    private ImageButton achieved2;
    private ImageButton achieved3;
    private ImageButton achieved4;
    private ImageButton achieved5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.achievement);

        int highScore = getScoreFromDatabase();

        textScoreInfo = (TextView) findViewById(R.id.viewScoreInfo);
        textScoreInfo.setText("Click the tick image when you've earned an achievement!");
        textViewScore = (TextView) findViewById(R.id.viewScore);
        textViewScore.setText("Total Steps Taken: " + Integer.toString(highScore));

        achievementOne = (TextView) findViewById(R.id.achieve1);
        achievementTwo = (TextView) findViewById(R.id.achieve2);
        achievementThree = (TextView) findViewById(R.id.achieve3);
        achievementFour = (TextView) findViewById(R.id.achieve4);
        achievementFive = (TextView) findViewById(R.id.achieve5);

        achieved1 = (ImageButton) findViewById(R.id.tick1);
        achieved2 = (ImageButton) findViewById(R.id.tick2);
        achieved3 = (ImageButton) findViewById(R.id.tick3);
        achieved4 = (ImageButton) findViewById(R.id.tick4);
        achieved5 = (ImageButton) findViewById(R.id.tick5);

        achieved1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder helpBuilder =
                        new AlertDialog.Builder(Achievement.this);
                helpBuilder.setMessage("Ask your Parent for a Petite Fleur Yogurt!");
                LayoutInflater inflater = getLayoutInflater();
                View checkboxLayout = inflater.inflate(R.layout.popwindow1, null);
                helpBuilder.setView(checkboxLayout);
                helpBuilder.setPositiveButton(android.R.string.yes,
                        new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface helpDialog, int which) {
                       helpDialog.cancel();
                    }
                });
                AlertDialog helpDialog = helpBuilder.create();
                helpDialog.show();
            }
        });

        achieved2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder helpBuilder = new AlertDialog.Builder(Achievement.this);
                helpBuilder.setMessage("Ask your Parent for a Cheese String!");
                LayoutInflater inflater = getLayoutInflater();
                View checkboxLayout = inflater.inflate(R.layout.popwindow2, null);
                helpBuilder.setView(checkboxLayout);
                helpBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface helpDialog, int which) {
                        helpDialog.cancel();
                    }
                });
                AlertDialog helpDialog = helpBuilder.create();
                helpDialog.show();
            }
        });
        achieved3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder helpBuilder = new AlertDialog.Builder(Achievement.this);
                helpBuilder.setMessage("Ask your Parent for StrawBerries!");
                LayoutInflater inflater = getLayoutInflater();
                View checkboxLayout = inflater.inflate(R.layout.popwindow3, null);
                helpBuilder.setView(checkboxLayout);
                helpBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface helpDialog, int which) {
                        helpDialog.cancel();
                    }
                });
                AlertDialog helpDialog = helpBuilder.create();
                helpDialog.show();

            }
        });
        achieved4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder helpBuilder = new AlertDialog.Builder(Achievement.this);
                helpBuilder.setMessage("Ask your Parent for an Apple!");
                LayoutInflater inflater = getLayoutInflater();
                View checkboxLayout = inflater.inflate(R.layout.popwindow4, null);
                helpBuilder.setView(checkboxLayout);
                helpBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface helpDialog, int which) {
                        helpDialog.cancel();
                    }
                });
                AlertDialog helpDialog = helpBuilder.create();
                helpDialog.show();

            }
        });
        achieved5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder helpBuilder = new AlertDialog.Builder(Achievement.this);
                helpBuilder.setMessage("Ask your Parent for a Rice Krispie Square!");
                LayoutInflater inflater = getLayoutInflater();
                View checkboxLayout = inflater.inflate(R.layout.popwindow5, null);
                helpBuilder.setView(checkboxLayout);
                helpBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface helpDialog, int which) {
                        helpDialog.cancel();
                    }
                });
                AlertDialog helpDialog = helpBuilder.create();
                helpDialog.show();
            }
        });
        displayImage(highScore);

    }

    public int getScoreFromDatabase () {
        MySQLiteHelper db = new MySQLiteHelper(this);
        return db.getScore();
    }

    public void displayImage(int score) {
        if (score >= 250) {
            achieved1.setVisibility(View.VISIBLE);

        } if (score >= 1000) {
            achieved2.setVisibility(View.VISIBLE);

        }  if (score >= 3000) {
            achieved3.setVisibility(View.VISIBLE);

        }  if (score >= 6000) {
            achieved4.setVisibility(View.VISIBLE);

        }  if (score >= 10000) {
            achieved5.setVisibility(View.VISIBLE);

        } else {

        }
    }
}

