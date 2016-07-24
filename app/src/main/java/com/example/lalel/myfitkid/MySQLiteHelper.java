package com.example.lalel.myfitkid;

/**
 *
 */

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String TABLE_HIGHSCORE = "highscore";
    private static final String KEY_ID = "_id";
    private static final String SCORE = "score";
    private static final String DATABASE_NAME = "score.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "CREATE TABLE "
            + TABLE_HIGHSCORE + "( " + KEY_ID
            + " INTEGER PRIMARY KEY DEFAULT 1 " + ", " + SCORE
            + " INTEGER DEFAULT 0 );";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HIGHSCORE);
        onCreate(db);
    }

    public void addOrUpdateScore(int score) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, 1);
        values.put(SCORE, score + getScore());

        db.insertWithOnConflict(TABLE_HIGHSCORE, null,
                values, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }

    public int getScore() {
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.rawQuery("SELECT " + SCORE + " FROM " + TABLE_HIGHSCORE
                + " WHERE " + KEY_ID + " = 1 ", null);
        if (c !=null && c.moveToFirst()) {
            int i = c.getInt(c.getColumnIndex("SCORE") + 1);
            c.close();
            return i;
        } else {
            c.close();
            return 0;
        }

    }
}