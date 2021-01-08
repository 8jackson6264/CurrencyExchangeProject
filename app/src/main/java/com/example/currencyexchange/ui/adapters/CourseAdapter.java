package com.example.currencyexchange.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencyexchange.R;
import com.example.currencyexchange.data.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    List<Course> courses = new ArrayList<>();

    public void setCourses(List<Course> courses) {
        this.courses = courses;
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
        
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btnHeart;
        TextView txtBaseCurrency;
        TextView txtCourseCurrency;
        TextView txt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btnHeart = itemView.findViewById(R.id.btn_like);
            txtBaseCurrency = itemView.findViewById(R.id.txt_base_currency);
            txtCourseCurrency = itemView.findViewById(R.id.txt_exchange_rate);
            txt = itemView.findViewById(R.id.one_bgn_equals);

        }
    }
}
