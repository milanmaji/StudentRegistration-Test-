package com.sitapuramargram.studentregistration.models;

public class ExamLocation {

    private String exam,location,latLong;

    public ExamLocation(String exam, String location, String latLong) {
        this.exam = exam;
        this.location = location;
        this.latLong = latLong;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLatLong() {
        return latLong;
    }

    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }
}
