package com.stehno.pillcounter;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cjstehno
 */
public class DosageDto implements Serializable {

    public static final String KEY = "dto";

    private List<DailyDosage> dailyDosages = new LinkedList<DailyDosage>();
    private double totalPills;

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
}

