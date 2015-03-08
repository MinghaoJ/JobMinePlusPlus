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

/**
 * Created by Aaron Lam on 2015-03-08.
 */
public class SQLJobDatabaseOperations extends SQLiteOpenHelper {

    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE " + DatabaseListing.TABLE_NAME +
            "("+ DatabaseListing.JOB_ID + " TEXT,"+
            DatabaseListing.JOB_NAME + " TEXT,"+
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


    public void insertJob(SQLJobDatabaseOperations dop,
                          String job_id, String job_name,
                          String job_employer, String job_location,
                          String job_status, String job_numapps) {

        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(DatabaseListing.JOB_ID, job_id);
        cv.put(DatabaseListing.JOB_NAME, job_name);
        cv.put(DatabaseListing.JOB_EMPLOYER, job_employer);
        cv.put(DatabaseListing.JOB_LOCATION, job_location);
        cv.put(DatabaseListing.JOB_STATUS, job_status);
        cv.put(DatabaseListing.JOB_NUMAPPS, job_numapps);
        long k = SQ.insert(DatabaseListing.TABLE_NAME, null, cv);

        Log.d("Database operations", "One job inserted into database");
    }

    public List getAllJobs (){
        List joblist = new ArrayList<>();
        String query = "SELECT * FROM " + DatabaseListing.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery (query, null);

        if (cursor.moveToFirst()) {
            do {
                List listing = new List(cursor.getString(0), cursor.getString(1),
                        new String[]{cursor.getString(2)},
                        cursor.getInt(3),
                        cursor.getInt(4),
                        cursor.getInt(5));
x
                joblist.add(listing);
            } while (cursor.moveToNext());
        }

        return joblist;
    }

}
