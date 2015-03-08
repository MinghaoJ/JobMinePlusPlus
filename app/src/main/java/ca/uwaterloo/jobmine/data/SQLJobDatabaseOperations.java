package ca.uwaterloo.jobmine.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ca.uwaterloo.jobmine.data.SQLJobDatabase.DatabaseListing;
import ca.uwaterloo.jobmine.models.Job;

/**
 * Created by Aaron Lam on 2015-03-08.
 */
public class SQLJobDatabaseOperations extends SQLiteOpenHelper {

    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE " + DatabaseListing.TABLE_NAME +
            "("+ DatabaseListing.JOB_ID + " TEXT,"+
            DatabaseListing.JOB_TITLE + " TEXT,"+
            DatabaseListing.JOB_EMPLOYER + " TEXT,"+
            DatabaseListing.JOB_LOCATION + " TEXT,"+
            DatabaseListing.JOB_STATUS + " TEXT,"+
            DatabaseListing.JOB_NUMAPPS + " TEXT)";

    public SQLJobDatabaseOperations (Context context) {
        super(context, DatabaseListing.DATABASE_NAME, null, database_version);
        Log.d("Database operations", "Database created");
    }

    //Creating the database object
    @Override
    public void onCreate (SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sdb, int arg1, int arg2 ) {

    }

    //Insert a job into the database.
    public void insertJob(Job job) {

        SQLiteDatabase dbWrite = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(DatabaseListing.JOB_ID, job.getId());
        cv.put(DatabaseListing.JOB_TITLE, job.getTitle());
        cv.put(DatabaseListing.JOB_EMPLOYER, job.getEmployer());
        cv.put(DatabaseListing.JOB_LOCATION, job.getLocation());
        cv.put(DatabaseListing.JOB_STATUS, job.getStatus());
        cv.put(DatabaseListing.JOB_NUMAPPS, job.getNumApps());
        dbWrite.insert(DatabaseListing.TABLE_NAME, null, cv);

        dbWrite.close();
        Log.d("Database operations", "One job inserted into database");

    }


    public int getJobCount()
    {
        SQLiteDatabase dbWrite = getReadableDatabase();
        Cursor cursor = dbWrite.rawQuery("SELECT * FROM " + DatabaseListing.TABLE_NAME, null);
        int count = cursor.getCount();
        dbWrite.close();
        cursor.close();
        return count;
    }

    /*public Job getJob (){
        SQLiteDatabase dbReader = this.getReadableDatabase();
        String[] columns = {DatabaseListing.JOB_ID, DatabaseListing.JOB_TITLE,
                            DatabaseListing.JOB_EMPLOYER, DatabaseListing.JOB_LOCATION,
                            DatabaseListing.JOB_STATUS, DatabaseListing.JOB_NUMAPPS};
        Cursor CR = dbReader.query(DatabaseListing.TABLE_NAME, columns, null, null, null, null, null);

        if (CR != null)
            CR.moveToFirst();

        Job job = new Job (CR.getString(0), CR.getString(1), CR.getString(2),
                           CR.getString(4), CR.getString(5), CR.getString(6));

        dbReader.close();
        CR.close();
        return job;
    }*/

    public List<Job> searchJob(String param) {
        List<Job> searchList = new ArrayList<>();

        SQLiteDatabase dbReader = this.getReadableDatabase();
        Log.d("Database operations", "Read loader Successful");
        Cursor cursor = dbReader.rawQuery("SELECT * FROM " + DatabaseListing.TABLE_NAME, null);
        Log.d("Database operations", "Cursor default Successful");
        if (cursor.moveToFirst()){
            do {
                for (int i = 0; i <= 5 ; i ++ )
                {
                    if (cursor.getString(i).contains(param)){
                        Job job = new Job (cursor.getString(0), cursor.getString(1), cursor.getString(2),
                                cursor.getString(3), cursor.getString(4), cursor.getString(5));
                        searchList.add(job);
                    }
                }

                Log.d("Database operations", "One job loaded into the array list");
            } while (cursor.moveToNext());
        }

        dbReader.close();
        cursor.close();
        return searchList;

    }

    public List<Job> getJobList() {

        List<Job> jobList = new ArrayList<>();

        SQLiteDatabase dbReader = this.getReadableDatabase();
        Log.d("Database operations", "Read loader Successful");
        Cursor cursor = dbReader.rawQuery("SELECT * FROM " + DatabaseListing.TABLE_NAME, null);
        Log.d("Database operations", "Cursor default Successful");
        if (cursor.moveToFirst()){
            do {
                Job job = new Job (cursor.getString(0), cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4), cursor.getString(5));
                jobList.add(job);
                Log.d("Database operations", "One job loaded into the array list");
            } while (cursor.moveToNext());
        }

        dbReader.close();
        cursor.close();
        return jobList;
    }
}
