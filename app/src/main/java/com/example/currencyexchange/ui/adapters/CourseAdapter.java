package com.example.currencyexchange.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencyexchange.R;
import com.example.currencyexchange.data.Course;
import com.example.currencyexchange.data.db.CourseDBService;

import java.util.ArrayList;
import java.util.List;


public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> implements Filterable {

    List<Course> courses = new ArrayList<>();
    List<Course> coursesListFiltered = new ArrayList<>();
    private String base;
    private boolean isCourseAdapterInExchangeRatesTabUsed;
    CourseDBService service;

    public CourseAdapter(Context context) {
        this.service = new CourseDBService(context);
    }

    public void setCourseAdapterInExchangeRatesTabUsed(boolean courseAdapterInExchangeRatesTabUsed) {
        isCourseAdapterInExchangeRatesTabUsed = courseAdapterInExchangeRatesTabUsed;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
        coursesListFiltered = courses;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exchange_rate,
                parent,
                false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtCourse.setText(String.valueOf(coursesListFiltered.get(position).getCourse()));
        holder.txtCurrency.setText(coursesListFiltered.get(position).getCurrencyName());
        if (isCourseAdapterInExchangeRatesTabUsed){
            holder.txtBaseCurrency.setText(base);
            holder.btnNotLiked.setOnClickListener((v -> saveCourse(position, holder)));
        } else
        {
            holder.txtBaseCurrency.setText(coursesListFiltered.get(position).getBase());
            holder.btnLiked.setEnabled(true);
            holder.btnLiked.setOnClickListener((v -> deleteCourse(position)));
        }
    }

    private void saveCourse(int position, ViewHolder holder) {
        Course course = new Course(coursesListFiltered.get(position).getCurrencyName(),
                coursesListFiltered.get(position).getCourse());
        service.addCourse(course);
        holder.btnLiked.setEnabled(true);
    }

    private void deleteCourse(int position){
        service.deleteCourseByCourse(coursesListFiltered.get(position).getCourse());
        coursesListFiltered.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return coursesListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    coursesListFiltered = courses;
                } else {
                    List<Course> filteredList = new ArrayList<>();
                    for (Course row : courses) {
                        if (row.getCurrencyName().toLowerCase().contains(charString.toLowerCase())){
                            filteredList.add(row);
                        }
                    }

                    coursesListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = coursesListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                coursesListFiltered = (ArrayList<Course>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btnNotLiked;
        Button btnLiked;
        TextView txtOne;
        TextView txtBaseCurrency;
        TextView txtEquals;
        TextView txtCourse;
        TextView txtCurrency;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btnNotLiked = itemView.findViewById(R.id.btn_not_liked);
            btnLiked = itemView.findViewById(R.id.btn_liked);
            txtOne = itemView.findViewById(R.id.txt_one);
            txtBaseCurrency = itemView.findViewById(R.id.txt_base_currency);
            txtEquals = itemView.findViewById(R.id.txt_equals);
            txtCourse = itemView.findViewById(R.id.txt_course);
            txtCurrency = itemView.findViewById(R.id.txt_currency);

        }
    }
}
