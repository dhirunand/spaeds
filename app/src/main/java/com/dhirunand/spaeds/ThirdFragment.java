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

import com.dhirunand.spaeds.databinding.FragmentThirdBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ThirdFragment extends Fragment {

    FragmentThirdBinding binding;
    //    ArrayList<ArrayList<HashMap<String, String>>> aahm;
//    ArrayList<HashMap<String, HashMap<String, String>>> ahmhm;
    public static HashMap<String, HashMap<String, HashMap<String, String>>> hmhmhm;

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        hmhmhm = new HashMap<>();

        //Prog. lang
        HashMap<String, HashMap<String, String>> hmhm = new HashMap<>();
        HashMap<String, String> val = new HashMap<String, String>();
        val.put("What is java", "https://www.javatpoint.com/java-tutorial");
        val.put("History of java", "https://www.javatpoint.com/history-of-java");
        val.put("Features of Java", "https://www.javatpoint.com/features-of-java");
        val.put("First Java Program", "https://www.javatpoint.com/simple-program-of-java");
        val.put("Difference Between JDK, JRE and JVM", "https://www.javatpoint.com/difference-between-jdk-jre-and-jvm");
        val.put("JVM Architecture", "https://www.javatpoint.com/jvm-java-virtual-machine");
        val.put("Java Variables", "https://www.javatpoint.com/java-variables");
        val.put("Data Types in Java", "https://www.javatpoint.com/java-data-types");
        val.put("Operators in Java", "https://www.javatpoint.com/operators-in-java");
        val.put("Java Keywords", "https://www.javatpoint.com/java-keywords");
        val.put("Java Control Statements", "");
        val.put("Java If-Else Statement", "");
//        val.put("Java Switch Statement", "");
//        val.put("Loops in Java", "");
//        val.put("Java While Loop", "");
//        val.put("Java Do-While Loop", "");
//        val.put("Java Break Statement", "");
//        val.put("Java OOPs Concepts", "");
//        val.put("Java Naming Convention", "");
//        val.put("Objects and Classes in Java", "");
//        val.put("Method in Java", "");
//        val.put("Constructor in Java", "");
        val.put("Java Static Keyword", "");
        hmhm.put("Java", val);

        HashMap<String, String> val1 = new HashMap<String, String>();
        val1.put("String", "https://jhggfhdgf");
        val1.put("OOPS", "https://jhgjgg");
        val1.put("STL", "https://jbddvh");
        val1.put("Virtual Classes", "https://vhfhfgh");
        hmhm.put("C++", val1);

        hmhmhm.put("Prog. lang", hmhm);



        //core subjects
        HashMap<String, HashMap<String, String>> hmhm1 = new HashMap<>();
        HashMap<String, String> val2 = new HashMap<String, String>();
        val2.put("Types of Operating System", "");
        val2.put("2 Process Management in OS", "");
        val2.put("Process States", "");
        val2.put("CPU Scheduling", "");
        val2.put("Scheduling Algorithms", "");
        val2.put("Synchronization", "");
        val2.put("Critical Section", "");
        val2.put("Semaphore", "");
        val2.put("Counting Semaphore", "");
        val2.put("Binary Semaphores", "");
        val2.put("Deadlock", "");
        val2.put("Deadlock Prevention", "");
        val2.put("Deadlock Avoidance", "");
        val2.put("Memory Management", "");
        val2.put("Paging", "");
        val2.put("Physical and Logical Address", "");
        val2.put("Paging Table", "");
        val2.put("Virtual Memory", "");
        val2.put("Demand Paging", "");
        val2.put("Page Replacement", "");
        val2.put("Belady's Anomaly", "");

        hmhm1.put("OS", val2);

        HashMap<String, String> val3 = new HashMap<String, String>();
        val3.put("String", "https://jhggfhdgf");
        val3.put("OOPS", "https://jhgjgg");
        val3.put("STL", "https://jbddvh");
        val3.put("Virtual Classes", "https://vhfhfgh");
        hmhm1.put("Computer Networking", val3);

        hmhmhm.put("Core Subjects", hmhm1);










        //DSA & Algorithms
        hmhmhm.put("DSA & Algoriths", hmhm);








//        ahmhm.add(new HashMap<String, HashMap<String, String>>().put("Prog. lang", val));

        Log.v("Dhiru", hmhmhm.toString());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentThirdBinding.inflate(getLayoutInflater());


        List<String> subjectList = new ArrayList<>();
        for (Map.Entry<String, HashMap<String, HashMap<String, String>>> mapElement : hmhmhm.entrySet()) {
            subjectList.add(mapElement.getKey());
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(requireContext(), R.layout.details_list_item, R.id.containerTextView_details, subjectList);


        binding.recyclerView.setAdapter(adapter);

        NavController navController = Navigation.findNavController(container);

        binding.recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ThirdFragmentDirections.ActionThirdFragmentToThirdFragment1 action;
                action = ThirdFragmentDirections.actionThirdFragmentToThirdFragment1(subjectList.get(i));

                Log.v("Dku", subjectList.get(i));

                navController.navigate(action);
            }
        });

        return binding.getRoot();
    }
}