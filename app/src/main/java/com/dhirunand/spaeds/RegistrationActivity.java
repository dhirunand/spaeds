package com.dhirunand.spaeds;

import static com.dhirunand.spaeds.CommonFunctions.USERUIDFIREBASEAUTH;
import static com.dhirunand.spaeds.CommonFunctions.userGetDisplayName;
import static com.dhirunand.spaeds.CommonFunctions.userGetEmail;
import static com.dhirunand.spaeds.CommonFunctions.userGetPhoneNumber;
import static com.dhirunand.spaeds.CommonFunctions.userGetPhotoUrl;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {
    public static FirebaseUser user;
    private final ActivityResultLauncher<Intent> signInLauncher = registerForActivityResult(
            new FirebaseAuthUIActivityResultContract(),
            new ActivityResultCallback<FirebaseAuthUIAuthenticationResult>() {
                @Override
                public void onActivityResult(FirebaseAuthUIAuthenticationResult result) {
                    onSignInResult(result);
                }
            }
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        createSignInIntent();
    }


    public void createSignInIntent() {
        // Choose authentication providers
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.GoogleBuilder().build(),
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.PhoneBuilder().build());

        // Create and launch sign-in intent
        Intent signInIntent = AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setLogo(R.drawable.logo)
                .setTheme(R.style.Theme_Spaeds_Registration)
                .setTosAndPrivacyPolicyUrls(
                        "https://example.com/terms.html",
                        "https://example.com/privacy.html")
                .build();
        signInLauncher.launch(signInIntent);
    }

    // [START auth_fui_result]
    private void onSignInResult(FirebaseAuthUIAuthenticationResult result) {
        IdpResponse response = result.getIdpResponse(); //        response.isNewUser()

        //If response is null the user canceled the sign-in flow using the back button
        if (response == null) {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
//            finish();
            return;
        }

        if (result.getResultCode() == RESULT_OK) {
            // Successfully signed in
            user = FirebaseAuth.getInstance().getCurrentUser();
            assert user != null;
            CommonFunctions.SHAREDPREFEDITOR.putString(USERUIDFIREBASEAUTH, user.getUid());
            CommonFunctions.SHAREDPREFEDITOR.apply();


//          user.getPhotoUrl(); user.updatePhoneNumber()
            CommonFunctions.SHAREDPREFEDITOR.putString(userGetDisplayName, user.getDisplayName());
            CommonFunctions.SHAREDPREFEDITOR.putString(userGetEmail, user.getEmail());
            CommonFunctions.SHAREDPREFEDITOR.putString(userGetPhoneNumber, user.getPhoneNumber());
            CommonFunctions.SHAREDPREFEDITOR.putString(userGetPhotoUrl, String.valueOf(user.getPhotoUrl()));


            CommonFunctions.SHAREDPREFEDITOR.putBoolean("registrationNotDone", false);
            CommonFunctions.SHAREDPREFEDITOR.apply();
            startActivity(new Intent(this, BasicActivity.class));

        } else {
            // Sign in failed. If response is null the user canceled the
            // sign-in flow using the back button. Otherwise check
            // response.getError().getErrorCode() and handle the error.

            Log.e("Dhiru response.getError", response.getError() + "");
            Toast.makeText(this, response.getError() + "", Toast.LENGTH_SHORT).show();
        }
    }
}