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
        val.put("Java Control Statements", "https://www.javatpoint.com/control-flow-in-java");
        val.put("Java If-Else Statement", "https://www.javatpoint.com/java-if-else");
        val.put("Java Switch Statement", "https://www.javatpoint.com/java-switch");
        val.put("Loops in Java", "https://www.javatpoint.com/java-for-loop");
        val.put("Java While Loop", "https://www.javatpoint.com/java-while-loop");
        val.put("Java Do-While Loop", "https://www.javatpoint.com/java-do-while-loop");
        val.put("Java Break Statement", "https://www.javatpoint.com/java-break");
        val.put("Java OOPs Concepts", "https://www.javatpoint.com/java-oops-concepts");
        val.put("Java Naming Convention", "https://www.javatpoint.com/java-naming-conventions");
        val.put("Objects and Classes in Java", "https://www.javatpoint.com/object-and-class-in-java");
        val.put("Method in Java", "https://www.javatpoint.com/method-in-java");
        val.put("Constructor in Java", "https://www.javatpoint.com/java-constructor");
        val.put("Java Static Keyword", "https://www.javatpoint.com/static-keyword-in-java");
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
        val2.put("Types of Operating System", "https://www.javatpoint.com/types-of-operating-systems");
        val2.put("Process Management in OS", "https://www.javatpoint.com/process-management-in-os");
        val2.put("Process States", "https://www.javatpoint.com/os-process-states");
        val2.put("CPU Scheduling", "https://www.javatpoint.com/os-cpu-scheduling");
        val2.put("Scheduling Algorithms", "https://www.javatpoint.com/os-scheduling-algorithms");
        val2.put("Synchronization", "https://www.javatpoint.com/os-process-synchronization-introduction");
        val2.put("Critical Section", "https://www.javatpoint.com/os-critical-section-problem");
        val2.put("Semaphore", "https://www.javatpoint.com/os-semaphore-introduction");
        val2.put("Counting Semaphore", "https://www.javatpoint.com/os-counting-semaphore");
        val2.put("Binary Semaphores", "https://www.javatpoint.com/os-binary-semaphore-or-mutex");
        val2.put("Deadlock", "https://www.javatpoint.com/os-deadlocks-introduction");
        val2.put("Deadlock Prevention", "https://www.javatpoint.com/os-deadlock-prevention");
        val2.put("Deadlock Avoidance", "https://www.javatpoint.com/os-deadlock-avoidance");
        val2.put("Memory Management", "https://www.javatpoint.com/os-memory-management-introduction");
        val2.put("Paging", "https://www.javatpoint.com/os-need-for-paging");
        val2.put("Physical and Logical Address", "https://www.javatpoint.com/os-physical-and-logical-address-space");
        val2.put("Paging Table", "https://www.javatpoint.com/os-page-table");
        val2.put("Virtual Memory", "https://www.javatpoint.com/os-virtual-memory");
        val2.put("Demand Paging", "https://www.javatpoint.com/os-demand-paging");
        val2.put("Page Replacement", "https://www.javatpoint.com/os-page-replacement-algorithms");
        val2.put("Belady's Anomaly", "https://www.javatpoint.com/os-beladys-anamoly");

        hmhm1.put("OS", val2);

        HashMap<String, String> val3 = new HashMap<String, String>();
        val3.put("String", "https://www.javatpoint.com/java-string");
        val3.put("OOPS", "https://www.javatpoint.com/java-oops-concepts");
        val3.put("STL", "https://www.javatpoint.com/cpp-stl-components");
        val3.put("Virtual Classes", "https://www.javatpoint.com/virtual-function-in-java#:~:text=A%20virtual%20function%20or%20virtual,signature%20to%20achieve%20the%20polymorphism.");
        hmhm1.put("Computer Networking", val3);

        hmhmhm.put("Core Subjects", hmhm1);










        //DSA & Algorithms
        hmhmhm.put("DSA & Algoriths", hmhm);


        //DBMS
        HashMap<String, HashMap<String, String>> hmhm2 = new HashMap<>();
       /* HashMap<String, String> val4 = new HashMap<String, String>();
        val.put("What is java", "https://www.javatpoint.com/java-tutorial");

        hmhm2.put("DBMS", val4);

        */
        hmhmhm.put("DBMS", hmhm2);


        //Science
        HashMap<String, HashMap<String, String>> hmhm3 = new HashMap<>();

        hmhmhm.put("Science", hmhm3);

        //Mathematics
        HashMap<String, HashMap<String, String>> hmhm4 = new HashMap<>();

        hmhmhm.put("Mathematics", hmhm4);


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