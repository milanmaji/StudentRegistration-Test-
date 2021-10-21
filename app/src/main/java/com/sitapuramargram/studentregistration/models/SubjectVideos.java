package com.sitapuramargram.studentregistration.models;

public class SubjectVideos {

    private String sujectName,videoId;

    public SubjectVideos(String sujectName, String videoId) {
        this.sujectName = sujectName;
        this.videoId = videoId;
    }

    public String getSujectName() {
        return sujectName;
    }

    public void setSujectName(String sujectName) {
        this.sujectName = sujectName;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
