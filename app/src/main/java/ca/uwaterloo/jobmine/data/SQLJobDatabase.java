package ca.uwaterloo.jobmine.data;

/**
 * Created by Aaron Lam on 2015-03-08.
 */
import android.provider.BaseColumns;

public class SQLJobDatabase {

    public SQLJobDatabase() {

    }

    public static abstract class DatabaseListing implements BaseColumns {

        public static final String JOB_ID = "job_id";
        public static final String JOB_NAME = "job_name";
        public static final String JOB_EMPLOYER = "job_employer";
        public static final String JOB_LOCATION = "job_location";
        public static final String JOB_STATUS = "job_status";
        public static final String JOB_NUMAPPS = "job_numapps";
        public static final String DATABASE_NAME = "job_info";
        public static final String TABLE_NAME = "jobmine_list";


    }
}
