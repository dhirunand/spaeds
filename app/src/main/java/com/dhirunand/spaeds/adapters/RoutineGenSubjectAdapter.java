package com.dhirunand.spaeds.adapters;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.dhirunand.spaeds.R;
import com.dhirunand.spaeds.entity.RoutineGenSubjectEntity;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class RoutineGenSubjectAdapter extends ArrayAdapter<RoutineGenSubjectEntity> {
    private AppCompatActivity activity;
    private List<RoutineGenSubjectEntity> movieList;


    public RoutineGenSubjectAdapter(@NonNull Context context, int resource, @NonNull List<RoutineGenSubjectEntity> objects) {
        super(context, resource, objects);
        this.activity = (AppCompatActivity) context;
        this.movieList = objects;
    }

//    public void RoutineGenSubjectAdapter(AppCompatActivity context, int resource, List<RoutineGenSubjectEntity> objects) {
//        super(context, resource, objects);
//        this.activity = context;
//        this.movieList = objects;
//    }

    @Override
    public RoutineGenSubjectEntity getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.subject_li, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
            //holder.ratingBar.getTag(position);
        }

        holder.ratingBar.setOnRatingBarChangeListener(onRatingChangedListener(holder, position));

        holder.ratingBar.setTag(position);
        holder.ratingBar.setRating(getItem(position).getRatingBarInt());
        holder.movieName.setText(getItem(position).getTextInputEditTextString());
        holder.movieName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                getItem(position).setTextInputEditTextString();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                getItem(position).setTextInputEditTextString(editable.toString());
//                Log.v("Dhirua", editable.toString());
            }
        });

        return convertView;
    }

    private RatingBar.OnRatingBarChangeListener onRatingChangedListener(final ViewHolder holder, final int position) {
        return new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                RoutineGenSubjectEntity item = getItem(position);
                item.setRatingBarInt((int) v);
//                Log.i("Adapter", "star: " + v);
            }
        };
    }

    private static class ViewHolder {
        private RatingBar ratingBar;
        private EditText movieName;

        public ViewHolder(View view) {
            ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
            movieName = view.findViewById(R.id.textInputEditText);
        }
    }

    public List<RoutineGenSubjectEntity> getMovieList(){
        return movieList;
    }
}