package com.example.managestudentexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private List<StudentModel> students;
    private Context mContext;

    public StudentAdapter(Context mContext,List students) {
        this.students = students;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View studentView = inflater.inflate(R.layout.student_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(studentView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StudentModel student = students.get(position);
        holder.fullName.setText(student.getFullName());
        holder.mssv.setText(student.getMSSV());
        holder.email.setText(student.getEmail());
        holder.dateOfBirth.setText(student.getDateOfBirth());
    }



    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mssv,fullName,email,dateOfBirth;
        public Button detail_button;

        public ViewHolder(View itemView) {
            super(itemView);
            mssv = itemView.findViewById(R.id.mssv);
            fullName = itemView.findViewById(R.id.fullName);
            email = itemView.findViewById(R.id.email);
            dateOfBirth = itemView.findViewById(R.id.dateOfBirth);

            detail_button = itemView.findViewById(R.id.detail_button);
            detail_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }


}