package com.stehno.pillcounter;

import java.io.Serializable;

/**
 * @author cjstehno
 */
public class DailyDosage implements Serializable {

    private double mg;
    private double pills;

    public DailyDosage( final double mg, final double pills ){
        this.mg = mg;
        this.pills = pills;
    }

    public double getMg() {
        return mg;
    }

    public double getPills() {
        return pills;
    }
}
