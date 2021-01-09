package com.example.currencyexchange.ui.adapters;

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
import java.util.ArrayList;
import java.util.List;


public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> implements Filterable {

    List<Course> courses = new ArrayList<>();

    public void setCourses(List<Course> courses) {
        this.courses = courses;
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
        holder.txtCourse.setText(String.valueOf(courses.get(position).getCourse()));
        holder.txtCurrency.setText(courses.get(position).getCurrencyName());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btnLike;
        TextView txtOne;
        TextView txtBaseCurrency;
        TextView txtEquals;
        TextView txtCourse;
        TextView txtCurrency;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btnLike = itemView.findViewById(R.id.btn_like);
            txtOne = itemView.findViewById(R.id.txt_one);
            txtBaseCurrency = itemView.findViewById(R.id.txt_base_currency);
            txtEquals = itemView.findViewById(R.id.txt_equals);
            txtCourse = itemView.findViewById(R.id.txt_course);
            txtCurrency = itemView.findViewById(R.id.txt_currency);

        }
    }
}
