package com.example.fistinbone.myapplication.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

/**
 * Created by fistinbone on 9/15/2017.
 */

public class Update extends AsyncTask<Void,Void,Void> {
    Context context;
    int stage;
    int quiz;
    int id;


    public Update(Context context, int stage, int quiz, int id){
        this.context = context;
        this.quiz = quiz;
        this.stage = stage;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params) {
        //update the wombat usage information
        FeedReaderDbHelper feedReaderDbHelper = new FeedReaderDbHelper(context);
        SQLiteDatabase sqLiteDatabase = feedReaderDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        String selection = FeedReaderContract.FeedEntry._ID + " = ?";
        String[] selectionArgs = {id+""};
        values.put(FeedReaderContract.FeedEntry._ID, id);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_STAGE, stage);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_QUIZ, quiz);
        int count = sqLiteDatabase.update(
                FeedReaderContract.FeedEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs
        );
        feedReaderDbHelper.close();
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}


/**
 * Created by fistinbone on 9/15/2017.
 */
