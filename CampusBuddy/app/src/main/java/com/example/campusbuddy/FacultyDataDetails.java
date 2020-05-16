package com.example.campusbuddy;

public class FacultyDataDetails {
    String tym;
    String sub;
    String topic;

    FacultyDataDetails(String tym,String sub, String topic){
        this.tym = tym;
        this.sub = sub;
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTym() {
        return tym;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public void setTym(String tym) {
        this.tym = tym;
    }
}
