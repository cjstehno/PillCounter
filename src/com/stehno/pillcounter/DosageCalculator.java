package com.stehno.pillcounter;

/**
 * A simple wrapper around the dosage calculation.
 * 
 * @author cjstehno
 */
public class DosageCalculator {

    static DosageDto calculate( double startMg, double mgPerPill, double reduceMg, int reduceDay, int numDays ){
        final DosageDto dto = new DosageDto();

        int daysOnMg = 0;
        double currentMg = startMg - reduceMg;

        for( int day = 1; day <= numDays; day++){
            double numPills = currentMg / mgPerPill;
            dto.addPills(numPills);

            dto.addDailyDosage( new DailyDosage( currentMg, numPills ) );

            if( ++daysOnMg >= reduceDay ){
                currentMg -= reduceMg;
                daysOnMg = 0;
            }
        }

        return dto;
    }

}
