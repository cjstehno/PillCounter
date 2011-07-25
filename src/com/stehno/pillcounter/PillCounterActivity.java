package com.stehno.pillcounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class PillCounterActivity extends Activity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Spinner reduceDaysSpinner = (Spinner)findViewById(R.id.reduceDays_spinner);
        ArrayAdapter<CharSequence> reduceDaysAdapter = ArrayAdapter.createFromResource(this, R.array.reduceDays_array, android.R.layout.simple_spinner_item);
        reduceDaysAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reduceDaysSpinner.setAdapter(reduceDaysAdapter);
        reduceDaysSpinner.setSelection(2);

        Spinner numDaysSpinner = (Spinner)findViewById(R.id.numDays_spinner);
        ArrayAdapter<CharSequence> numDaysAdapter = ArrayAdapter.createFromResource(this, R.array.numDays_array, android.R.layout.simple_spinner_item);
        numDaysAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numDaysSpinner.setAdapter(numDaysAdapter);
        numDaysSpinner.setSelection(6);

        final Button button = (Button) findViewById(R.id.calc_button);
        button.setOnClickListener(this);
    }

    public void onClick(View view) {
        final double startingMg = extractMgValue(R.id.startingMg_text);
        final double mgPerPill = extractMgValue(R.id.mgPerPill_text);
        final double reduceMg = extractMgValue(R.id.reduceMg_text);

        final int reduceDays = extractDays(R.id.reduceDays_spinner);
        final int numDays = extractDays(R.id.numDays_spinner);

        DosageDto dto = DosageCalculator.calculate( startingMg, mgPerPill, reduceMg, reduceDays, numDays );

        final Intent intent = new Intent( this, DosageScheduleActivity.class );
        intent.putExtra(DosageDto.KEY, dto);

        startActivity(intent);
    }

    private double extractMgValue( int viewId ){
        final EditText startingMg = (EditText)findViewById(viewId);
        final String text = startingMg.getText().toString();
        return text.isEmpty() ? 0d : Double.valueOf(text);
    }

    private int extractDays( int viewId ){
        Spinner reduceDaysSpinner = (Spinner)findViewById(viewId);
        String value = (String)reduceDaysSpinner.getSelectedItem();
        return Integer.valueOf( value.replace(" days","") );
    }
}
