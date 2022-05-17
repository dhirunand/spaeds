package com.dhirunand.spaeds;

import android.content.SharedPreferences;

public class CommonFunctions {

    public static SharedPreferences APNAGHAROWNERSHAREDPREF;
    public static SharedPreferences.Editor SHAREDPREFEDITOR;

    public static final String SHAREDPREFSTRING = "APNAGHAROWNERSHAREDPREF";
    public static final String GENDER = "GENDER";
    public static final String AGE = "AGE";
    public static final String HEIGHTFT = "HEIGHTFT";
    public static final String HEIGHTIN = "HEIGHTIN";
    public static final String HEIGHTCM = "HEIGHTCM";
    public static final String WEIGHT = "WEIGHT";



    //Owner data == Firebase user
    public static final String userGetDisplayName = "userGetDisplayName";
    public static final String userGetEmail = "userGetEmail";
    public static final String userGetPhoneNumber = "userGetPhoneNumber";
    public static final String userGetPhotoUrl = "userGetPhotoUrl";



    public static final String USERUIDFIREBASEAUTH = "USERUIDFIREBASEAUTH";

}
