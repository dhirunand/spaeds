package com.dhirunand.spaeds;

import static com.dhirunand.spaeds.FirstFragment.hour;
import static com.dhirunand.spaeds.FirstFragment.routineGenSubjectEntityList;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dhirunand.spaeds.adapters.RoutineAdapter;
import com.dhirunand.spaeds.databinding.FragmentRoutineBinding;
import com.dhirunand.spaeds.entity.RoutineListEntity;

import java.util.ArrayList;
import java.util.List;


public class RoutineFragment extends Fragment {

    FragmentRoutineBinding binding;
    RoutineAdapter adapter;

    public RoutineFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRoutineBinding.inflate(getLayoutInflater());

//        Log.v("Dhirua RotineFragment", routineGenSubjectEntityList.toString());
//        hour
        List<RoutineListEntity> routineListEntityList = new ArrayList<>();
        for (int i = 0; i < routineGenSubjectEntityList.size(); i++) {
            routineListEntityList.add(new RoutineListEntity(routineGenSubjectEntityList.get(i).getTextInputEditTextString(), "5:00 - 8:00 AM", false));
        }

//        routineListEntityList.add(new RoutineListEntity("Algorithm", "5:00 - 7:00 AM", false));
//        routineListEntityList.add(new RoutineListEntity("DBMS", "7:00 - 8:30 AM", false));
//        routineListEntityList.add(new RoutineListEntity("Java", "5:00 - 7:30 PM", false));
//        routineListEntityList.add(new RoutineListEntity("Operating System", "7:30 - 8:30 PM", false));
//        routineListEntityList.add(new RoutineListEntity("Computer Networking", "8:30 - 9:30 PM", false));

        adapter = new RoutineAdapter(requireContext(), R.layout.routine_li, routineListEntityList);
        binding.recyclerViewRoutine.setAdapter(adapter);




        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}