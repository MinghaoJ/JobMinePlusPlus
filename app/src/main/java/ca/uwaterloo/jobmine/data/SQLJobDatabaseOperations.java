package ca.uwaterloo.jobmine.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2 ) {

    }


    public void insertJob(Job job) {

        SQLiteDatabase SQ = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(DatabaseListing.JOB_ID, job.getId());
        cv.put(DatabaseListing.JOB_TITLE, job.getTitle());
        cv.put(DatabaseListing.JOB_EMPLOYER, job.getEmployer());
        cv.put(DatabaseListing.JOB_LOCATION, job.getLocation());
        cv.put(DatabaseListing.JOB_STATUS, job.getStatus());
        cv.put(DatabaseListing.JOB_NUMAPPS, job.getNumApps());
        long k = SQ.insert(DatabaseListing.TABLE_NAME, null, cv);

        Log.d("Database operations", "One job inserted into database");

    }

}
