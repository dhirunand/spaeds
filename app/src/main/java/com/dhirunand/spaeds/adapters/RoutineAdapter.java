package com.dhirunand.spaeds.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dhirunand.spaeds.R;
import com.dhirunand.spaeds.entity.RoutineListEntity;

import java.util.List;
import java.util.Objects;

public class RoutineAdapter extends ArrayAdapter<RoutineListEntity> {
    private AppCompatActivity activity;
    List<RoutineListEntity> routineListEntityList;

    public RoutineAdapter(@NonNull Context context, int resource, @NonNull List<RoutineListEntity> objects) {
        super(context, resource, objects);
        this.activity = (AppCompatActivity) context;
        this.routineListEntityList = objects;
    }

    @Nullable
    @Override
    public RoutineListEntity getItem(int position) {
        return routineListEntityList.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = inflater.inflate(R.layout.routine_li, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.subject.setText(Objects.requireNonNull(getItem(position)).getSubjectName());
        holder.time.setText(Objects.requireNonNull(getItem(position)).getTimeString());
        holder.checkBox.setChecked(Objects.requireNonNull(getItem(position)).isCheckBox());


        return convertView;
    }

    private static class ViewHolder{
        private TextView subject;
        private TextView time;
        private CheckBox checkBox;

        public ViewHolder(View view) {
            subject = (TextView) view.findViewById(R.id.subjectTv);
            time =    view.findViewById(R.id.timeTv);
            checkBox =view.findViewById(R.id.checkBoxView);
        }
    }
}
