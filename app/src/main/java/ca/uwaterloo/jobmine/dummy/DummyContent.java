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
        addJob(new Job("000001", "Quality Assurance", "Github", "Silicon Valley", "Open", "238"));
        addJob(new Job("000002", "Electrical Assistant", "Amazon", "Brazil", "Open", "111"));
        addJob(new Job("000003", "Front End Developer", "Google", "California", "Open", "178"));
        addJob(new Job("000004", "Assistant Engineer", "Intel", "Toronto", "Open", "213"));
        addJob(new Job("000005", "Solutions Developer", "Blackberry", "Waterloo", "Open", "97"));
        addJob(new Job("000006", "Electrical Systems Design", "Toronto Transit Commission", "Toronto", "Open", "61"));
        addJob(new Job("000007", "Software Developer", "Facebook", "California", "Open", "126"));
        addJob(new Job("000008", "Junior Developer", "CBC", "Toronto", "Open", "52"));
        addJob(new Job("000009", "IT Developer", "TD Bank Group", "Toronto", "Open", "35"));
        addJob(new Job("000010", "Jr. Technician", "Environment Canada", "Ottawa", "Open", "64"));
        addJob(new Job("000011", "Web Application Developer", "SociaLabra Inc.", "Toronto", "Open", "52"));
        addJob(new Job("000012", "Engineering", "Magna Closures Inc", "Bradford", "Open", "62"));
        addJob(new Job("000013", "Hardware Engineering Internship", "Nest Labs", "Palo Alto, CA, USA", "Open", "73"));
        addJob(new Job("000014", "Application Programmer", "Ontario Board of Education", "China", "Open", "1"));
        addJob(new Job("000015", "Game Programmer Intern", "Ubisoft Toronto", "Toronto", "Open", "352"));
        addJob(new Job("000016", "Technical Support", "Manulife Financial", "Kitchener", "Open", "14"));
        addJob(new Job("000017", "Quality Assurance Developer", "D2L", "Kitchener", "Open", "52"));


    }

    private static void addJob(Job job) {
        ITEMS.add(job);
        ITEM_MAP.put(job.getId(), job);
    }
}
