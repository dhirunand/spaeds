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

import com.dhirunand.spaeds.databinding.FragmentThird2Binding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ThirdFragment2 extends Fragment {

    FragmentThird2Binding binding;

    public ThirdFragment2() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentThird2Binding.inflate(getLayoutInflater());

        assert getArguments() != null;
        ThirdFragment2Args args = ThirdFragment2Args.fromBundle(getArguments());
        String stringKey = args.getData();
        String parentKey = args.getDataParent();

        List<String> subjectList = new ArrayList<>();
        List<String> url = new ArrayList<>();
        for (Map.Entry<String, String> mapElement : ThirdFragment.hmhmhm.get(parentKey).get(stringKey).entrySet()) {
            subjectList.add(mapElement.getKey());
            url.add(mapElement.getValue());
        }

        ArrayAdapter adapter = new ArrayAdapter<>(requireContext(), R.layout.details_list_item, R.id.containerTextView_details, subjectList);


        binding.recyclerView.setAdapter(adapter);

        NavController navController = Navigation.findNavController(container);

        binding.recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ThirdFragment2Directions.ActionThirdFragment2ToWebFragment action;
                action = ThirdFragment2Directions.actionThirdFragment2ToWebFragment(url.get(i), subjectList.get(i));

//                Log.v("Dku", url.get(i));

                navController.navigate(action);
            }
        });


        return binding.getRoot();
    }
}