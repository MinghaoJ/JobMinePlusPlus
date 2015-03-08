package ca.uwaterloo.jobmine.models;

/**
 * Created by Minghao on 2015-03-08.
 */
public class Job {
    String id;
    String title;
    String company;
    String location;

    public Job(String id, String title, String company, String location) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.location = location;
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }
}
