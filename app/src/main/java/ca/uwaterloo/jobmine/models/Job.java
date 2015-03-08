package ca.uwaterloo.jobmine.models;

/**
 * Created by Minghao on 2015-03-08.
 */
public class Job {
    String id;
    String title;
    String employer;
    String location;
    String status;
    String numapps;

    public Job(String id, String title, String employer, String location, String status, String numapps) {
        this.id = id;
        this.title = title;
        this.employer = employer;
        this.location = location;
        this.status = status;
        this.numapps = numapps;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getEmployer() {
        return employer;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() { return status; }

    public String getNumApps() { return numapps; }
}
