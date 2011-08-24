package com.stehno.pillcounter;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Simple holder for input information and calculation results.
 * 
 * @author cjstehno
 */
public class DosageDto implements Serializable {

    public static final String KEY = "dto";

    private List<DailyDosage> dailyDosages = new LinkedList<DailyDosage>();
    private double totalPills;
    private double pillMg, startingMg, reduceMg;
    private int reduceDays;

    public void addDailyDosage( DailyDosage dailyDosage ){
        dailyDosages.add( dailyDosage );
    }

    public Iterable<DailyDosage> dailyDosages(){
        return dailyDosages;
    }

    public void addPills( double pills ){
        totalPills += pills;
    }

    public double getTotalPills(){ return totalPills; }

    public double getPillMg() {
        return pillMg;
    }

    public void setPillMg(double pillMg) {
        this.pillMg = pillMg;
    }

    public double getStartingMg() {
        return startingMg;
    }

    public void setStartingMg(double startingMg) {
        this.startingMg = startingMg;
    }

    public double getReduceMg() {
        return reduceMg;
    }

    public void setReduceMg(double reduceMg) {
        this.reduceMg = reduceMg;
    }

    public int getReduceDays() {
        return reduceDays;
    }

    public void setReduceDays(int reduceDays) {
        this.reduceDays = reduceDays;
    }
}

