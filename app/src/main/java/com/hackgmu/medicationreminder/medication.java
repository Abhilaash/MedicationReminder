package com.hackgmu.medicationreminder;
public class medication {
    String name;
    private int num;
    private boolean[] sched = new boolean[7];

    public medication(String medname, int numpills) {
        name = medname;
        num = numpills;
        for(int x = 0; x < 7; x++) {
            sched[x] = false;
        }
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

    public void addSchedule(int time) {
        this.sched[time] = true;
    }

    public void rmSchedule(int time) {
        this.sched[time] = false;
    }

    public boolean[] getSchedule() {
        return sched;
    }
}
