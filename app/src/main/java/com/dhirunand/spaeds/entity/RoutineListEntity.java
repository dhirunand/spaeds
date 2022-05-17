package com.dhirunand.spaeds.entity;

public class RoutineListEntity {
    String subjectName;
    String timeString;
    boolean checkBox;

    public RoutineListEntity(String subjectName, String timeString, boolean checkBox) {
        this.subjectName = subjectName;
        this.timeString = timeString;
        this.checkBox = checkBox;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public boolean isCheckBox() {
        return checkBox;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }
}
