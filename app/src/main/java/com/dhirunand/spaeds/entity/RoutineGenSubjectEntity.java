package com.dhirunand.spaeds.entity;

import android.widget.RatingBar;

import com.google.android.material.textfield.TextInputEditText;

public class RoutineGenSubjectEntity {
    private String textInputEditTextString;
    private int ratingBarInt;

    public RoutineGenSubjectEntity() {
    }

    public RoutineGenSubjectEntity(String textInputEditTextString, int ratingBarInt) {
        this.textInputEditTextString = textInputEditTextString;
        this.ratingBarInt = ratingBarInt;
    }

    public String getTextInputEditTextString() {
        return textInputEditTextString;
    }

    public void setTextInputEditTextString(String textInputEditTextString) {
        this.textInputEditTextString = textInputEditTextString;
    }

    public int getRatingBarInt() {
        return ratingBarInt;
    }

    public void setRatingBarInt(int ratingBarInt) {
        this.ratingBarInt = ratingBarInt;
    }

    @Override
    public String toString() {
        return "RoutineGenSubjectEntity{" +
                "textInputEditTextString='" + textInputEditTextString + '\'' +
                ", ratingBarInt=" + ratingBarInt +
                '}';
    }
}
