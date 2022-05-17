package com.dhirunand.spaeds;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.dhirunand.spaeds.databinding.ActivityBasicBinding;

public class BasicActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityBasicBinding binding;


    private NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBasicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
//
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_basic);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);




        BottomNavigationView bottom_nav = findViewById(R.id.bottom_navigation);

//        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
//
//        assert navHostFragment != null;
//        navController = navHostFragment.getNavController();
//        NavigationUI.setupWithNavController(bottom_nav, navController);
//
//
//        // Passing each menu ID as a set of Ids because each menu is the top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.FirstFragment, R.id.SecondFragment, R.id.thirdFragment, R.id.profileFragment).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView);
        appBarConfiguration = new AppBarConfiguration.Builder(R.id.FirstFragment, R.id.SecondFragment, R.id.thirdFragment, R.id.profileFragment).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView);
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }
}