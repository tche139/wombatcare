package com.example.fistinbone.myapplication.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by fistinbone on 9/13/2017.
 */

public final class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "wombatcare";
        public static final String COLUMN_NAME_STAGE = "stage";
        public static final String COLUMN_NAME_QUIZ = "quiz";
        public static final String NAME = "name";
        public static final String GENDER = "gender";
    }

    //create entries in SQL
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_STAGE + " integer," +
                    FeedEntry.COLUMN_NAME_QUIZ + " integer," +
                    FeedEntry.NAME + " text," +
                    FeedEntry.GENDER + " text)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
}
