package ca.uwaterloo.jobmine.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.uwaterloo.jobmine.models.Job;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<Job> ITEMS = new ArrayList<Job>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, Job> ITEM_MAP = new HashMap<String, Job>();

    static {
        // Add sample items.
        addJob(new Job("00000000", "Job Title", "Company Name", "Location"));
        addJob(new Job("00000000", "Job Title", "Company Name", "Location"));
        addJob(new Job("00000000", "Job Title", "Company Name", "Location"));
        addJob(new Job("00000000", "Job Title", "Company Name", "Location"));
        addJob(new Job("00000000", "Job Title", "Company Name", "Location"));
        addJob(new Job("00000000", "Job Title", "Company Name", "Location"));
    }

    private static void addJob(Job job) {
        ITEMS.add(job);
        ITEM_MAP.put(job.getId(), job);
    }
}
