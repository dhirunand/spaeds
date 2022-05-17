package com.dhirunand.spaeds;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.dhirunand.spaeds.databinding.FragmentWebBinding;


public class WebFragment extends Fragment {

    FragmentWebBinding binding;

    public WebFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWebBinding.inflate(getLayoutInflater());


        assert getArguments() != null;
        WebFragmentArgs args = WebFragmentArgs.fromBundle(getArguments());
        String url = args.getData();
        String header = args.getHeader();

        if (!url.equals(""))
            binding.webview.loadUrl(url);
        else Toast.makeText(requireContext(), "Not Found", Toast.LENGTH_SHORT).show();



        return binding.getRoot();
    }
}