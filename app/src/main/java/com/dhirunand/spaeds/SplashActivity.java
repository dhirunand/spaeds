package com.dhirunand.spaeds;

import static com.dhirunand.spaeds.CommonFunctions.APNAGHAROWNERSHAREDPREF;
import static com.dhirunand.spaeds.CommonFunctions.SHAREDPREFSTRING;
import static com.dhirunand.spaeds.CommonFunctions.SHAREDPREFEDITOR;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        APNAGHAROWNERSHAREDPREF = getSharedPreferences(SHAREDPREFSTRING, MODE_PRIVATE);
        SHAREDPREFEDITOR = APNAGHAROWNERSHAREDPREF.edit();

        boolean isFirstTime = APNAGHAROWNERSHAREDPREF.getBoolean("firstTime", true);
        boolean isRegistrationNotDone = APNAGHAROWNERSHAREDPREF.getBoolean("registrationNotDone", true);

        Log.v("CommonFunctions.USERUIDFIREBASEAUTH", CommonFunctions.USERUIDFIREBASEAUTH + "");

        new Handler().postDelayed(() -> {

            if (false) { //isFirstTime
//
//                SHAREDPREFEDITOR.putBoolean("firstTime", false);
//                SHAREDPREFEDITOR.apply();  //Consider using apply() instead; commit writes its data to persistent storage immediately, whereas apply will handle it in the background
//
////                startActivity(new Intent(this, OnBoardingActivity.class));
//                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                finish();
            } else if (isRegistrationNotDone) {
                startActivity(new Intent(this, RegistrationActivity.class));
                finish();
            } else {
                startActivity(new Intent(this, BasicActivity.class));
                finish();
            }



        }, 2000);
    }
}