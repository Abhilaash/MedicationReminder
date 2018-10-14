package com.hackgmu.medicationreminder;
import java.util.ArrayList;

public class medication {
    String name;
    int num;
    ArrayList<String> sched = new ArrayList<>();

    public medication(String medname, int numpills) {
        name = medname;
        num = numpills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void addSchedule(String time) {
        this.sched.add(time);
    }

    public void rmSchedule(String time) {
        int i = this.sched.indexOf(time);
        this.sched.remove(i);
    }

    public ArrayList<String> getSchedule() {
        return sched;
    }

}
