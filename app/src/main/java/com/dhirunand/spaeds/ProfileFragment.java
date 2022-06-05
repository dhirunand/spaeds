package com.dhirunand.spaeds;

import static com.dhirunand.spaeds.CommonFunctions.userGetDisplayName;
import static com.dhirunand.spaeds.CommonFunctions.userGetEmail;
import static com.dhirunand.spaeds.CommonFunctions.userGetPhoneNumber;
import static com.dhirunand.spaeds.CommonFunctions.userGetPhotoUrl;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.dhirunand.spaeds.databinding.FragmentProfileBinding;
import com.squareup.picasso.Picasso;


public class ProfileFragment extends Fragment {

    FragmentProfileBinding binding;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(getLayoutInflater());


        binding.textInputLayoutName.getEditText().setText(CommonFunctions.APNAGHAROWNERSHAREDPREF.getString(userGetDisplayName, "Priyanshu Kumar"));
        binding.textInputLayoutMobile.getEditText().setText(CommonFunctions.APNAGHAROWNERSHAREDPREF.getString(userGetPhoneNumber, "+91 76679 50570"));
        binding.textInputLayoutEmail.getEditText().setText(CommonFunctions.APNAGHAROWNERSHAREDPREF.getString(userGetEmail, "priyanshu9876@gmail.com"));
        binding.textInputLayoutCurrentlyPursuing.getEditText().setText("College");
        binding.userName.setText(CommonFunctions.APNAGHAROWNERSHAREDPREF.getString(userGetDisplayName, "Priyanshu Kumar"));

        Picasso.get()
                .load(CommonFunctions.APNAGHAROWNERSHAREDPREF.getString(userGetPhotoUrl, "https://i.pravatar.cc/300"))
                .into(binding.profileImage);

        Log.v("userGetPhotoUrl", CommonFunctions.APNAGHAROWNERSHAREDPREF.getString(userGetPhotoUrl, "https://i.pravatar.cc/300"));

        binding.button2.setOnClickListener(view -> startActivity(new Intent(requireActivity(), RegistrationActivity.class)));

        return binding.getRoot();
    }
}