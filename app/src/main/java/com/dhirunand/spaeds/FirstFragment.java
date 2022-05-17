package com.dhirunand.spaeds;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.dhirunand.spaeds.adapters.RoutineGenSubjectAdapter;
import com.dhirunand.spaeds.databinding.FragmentFirstBinding;
import com.dhirunand.spaeds.entity.RoutineGenSubjectEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    RoutineGenSubjectAdapter adapter;

    public static List<RoutineGenSubjectEntity> routineGenSubjectEntityList;
    public static int hour;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        routineGenSubjectEntityList = new ArrayList<>();


        binding.submitNoOfSub.setOnClickListener(view -> {
            int n = Integer.parseInt(Objects.requireNonNull(binding.numOfSub.getText()).toString());
            hour = Integer.parseInt(Objects.requireNonNull(binding.numOfHour.getText()).toString());
            if (n<=0)
                return;

            routineGenSubjectEntityList.clear();
            binding.textInputLayout.setVisibility(View.GONE);
            binding.textInputLayout2.setVisibility(View.GONE);
            binding.submitNoOfSub.setVisibility(View.GONE);
            binding.submit2.setVisibility(View.VISIBLE);
            for (int i = 0; i < n; i++) {
                routineGenSubjectEntityList.add(new RoutineGenSubjectEntity("", 0));
            }

            adapter.notifyDataSetChanged();
        });
        adapter = new RoutineGenSubjectAdapter(requireContext(), R.layout.subject_li, routineGenSubjectEntityList);

        binding.recyclerView.setAdapter(adapter);

        Log.v("Dhirua", routineGenSubjectEntityList.toString());

        binding.submit2.setOnClickListener(view -> {
            Log.v("Dhirua onClick", routineGenSubjectEntityList.toString());
            NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_routineFragment);
        });

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}