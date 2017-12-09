package com.example.fistinbone.myapplication.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

/**
 * Created by fistinbone on 9/19/2017.
 */


public class UpdateProfile extends AsyncTask<Void,Void,Void> {
    Context context;
    String name;
    String gender;


    public UpdateProfile(Context context,String name,String gender){
        this.context = context;
        this.name = name;
        this.gender = gender;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params) {
     //update the user infomation in database
        FeedReaderDbHelper feedReaderDbHelper = new FeedReaderDbHelper(context);
        SQLiteDatabase sqLiteDatabase = feedReaderDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        String selection = FeedReaderContract.FeedEntry._ID + " = ?";
        String[] selectionArgs = {"2"};
        values.put(FeedReaderContract.FeedEntry._ID, 2);
        values.put(FeedReaderContract.FeedEntry.NAME,name);
        values.put(FeedReaderContract.FeedEntry.GENDER,gender);
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