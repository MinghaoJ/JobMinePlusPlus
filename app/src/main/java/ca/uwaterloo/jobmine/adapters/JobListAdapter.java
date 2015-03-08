package ca.uwaterloo.jobmine.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ca.uwaterloo.jobmine.R;
import ca.uwaterloo.jobmine.models.Job;

/**
* Created by Minghao on 2015-03-08.
*/
public class JobListAdapter extends RecyclerView.Adapter<JobListAdapter.ViewHolder> {
    private List<Job> jobsData;

    public JobListAdapter(List<Job> jobsData) {
        this.jobsData = jobsData;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.job_card, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // - get data from your jobsData at this position
        // - replace the contents of the view with that jobsData

        viewHolder.title.setText(jobsData.get(position).getTitle());
        viewHolder.company.setText(jobsData.get(position).getCompany());
        viewHolder.location.setText(jobsData.get(position).getLocation());
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView company;
        TextView location;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            title = (TextView)itemLayoutView.findViewById(R.id.textView_title);
            company = (TextView)itemLayoutView.findViewById(R.id.textView_company);
            location = (TextView)itemLayoutView.findViewById(R.id.textView_location);
        }
    }


    // Return the size of your jobsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return jobsData.size();
    }
}
