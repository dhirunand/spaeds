package com.dhirunand.spaeds;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.dhirunand.spaeds.databinding.FragmentThird1Binding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ThirdFragment1 extends Fragment {

    FragmentThird1Binding binding;

    public ThirdFragment1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentThird1Binding.inflate(getLayoutInflater());

        assert getArguments() != null;
        ThirdFragment1Args args = ThirdFragment1Args.fromBundle(getArguments());
        String stringKey = args.getData();

        List<String> subjectList = new ArrayList<>();
        for (Map.Entry<String, HashMap<String, String>> mapElement : ThirdFragment.hmhmhm.get(stringKey).entrySet()) {
            subjectList.add(mapElement.getKey());
        }

        ArrayAdapter adapter = new ArrayAdapter<>(requireContext(), R.layout.details_list_item, R.id.containerTextView_details, subjectList);


        binding.recyclerView.setAdapter(adapter);

        NavController navController = Navigation.findNavController(container);

        binding.recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ThirdFragment1Directions.ActionThirdFragment1ToThirdFragment2 action;
                action = ThirdFragment1Directions.actionThirdFragment1ToThirdFragment2(subjectList.get(i), stringKey);

                Log.v("Dku", subjectList.get(i));

                navController.navigate(action);
            }
        });
//        ThirdFragment.hmhmhm.get();



        return binding.getRoot();
    }
}