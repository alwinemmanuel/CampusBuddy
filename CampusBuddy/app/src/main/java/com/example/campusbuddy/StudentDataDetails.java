package com.example.campusbuddy;

public class StudentDataDetails {
    String sub, mrk, tmr;


    StudentDataDetails(String sub, String mrk, String tmr){
        this.sub = sub;
        this.mrk = mrk;
        this.tmr = tmr;
    }

    public String getSub() { return sub; }

    public void setSub(String sub) { this.sub = sub; }

    public String getMrk() { return mrk; }

    public void setMrk(String mrk) { this.mrk = mrk; }

    public String getTmr() { return tmr; }

    public void setTmr(String tmr) { this.tmr = tmr; }
}
