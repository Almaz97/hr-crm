package com.erkprog.zensofthrcrm.ui.interviews.interviewsList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.erkprog.zensofthrcrm.R;
import com.erkprog.zensofthrcrm.data.entity.Candidate;
import com.erkprog.zensofthrcrm.data.entity.Department;
import com.erkprog.zensofthrcrm.data.entity.Interview;
import java.util.List;


public class InterviewsAdapter extends RecyclerView.Adapter<InterviewsAdapter.InterviewViewHolder>{

    private List<Interview> mInterview;
    private Context mContext;

    public InterviewsAdapter(Context mContext, List<Interview> mInterviews){
        this.mInterview = mInterviews;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public InterviewsAdapter.InterviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.interview_item, parent, false);
        return new InterviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InterviewViewHolder holder, int position) {

        Interview interview = mInterview.get(position);
        Department department = interview.getRequest().getDepartment();
        Candidate candidate = interview.getCandidate();

        holder.department.setText(department.getName() != null ? department.getName() : null );
        holder.firstName.setText(candidate.getFirstName() != null ? candidate.getFirstName() : null);
        holder.lastName.setText(candidate.getLastName() != null ? candidate.getLastName() : null);
        holder.date.setText(interview.getDate() != null ? interview.getDate().toString() : null);
        holder.status.setText(interview.getStatus() != null ? interview.getStatus() : null);

    }

    @Override
    public int getItemCount() {
        return (mInterview != null ? mInterview.size() : 0);
    }
    static class InterviewViewHolder extends RecyclerView.ViewHolder {

        TextView firstName;
        TextView lastName;
        TextView department;
        TextView date;
        TextView status;

        public InterviewViewHolder(View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.iitem_firstName);
            lastName = itemView.findViewById(R.id.iitem_lastName);
            department = itemView.findViewById(R.id.iitem_department);
            date = itemView.findViewById(R.id.iitem_date);
            status = itemView.findViewById(R.id.iitem_status);
        }
    }
}
