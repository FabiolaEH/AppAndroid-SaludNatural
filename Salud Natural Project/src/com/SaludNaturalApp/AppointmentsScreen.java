package com.SaludNaturalApp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class AppointmentsScreen extends Activity implements OnItemSelectedListener{

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	 // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.activity_appointments);
        
        fillSpinnerLocation();
        fillSpinnerNumbAppoints();
        fillSpinnerTime();
	}
	
	public void fillSpinnerLocation()
	{
		Spinner spinner = (Spinner) findViewById(R.id.spinnerLocations);
		
		String[] locations = new String[] {"San Jos�", 
						                "Cartago",
						                "Alajuela",
						                "Heredia"
						               };
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,locations);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(dataAdapter);
		spinner.setOnItemSelectedListener(this);
	}
	
	public void fillSpinnerNumbAppoints()
	{
		Spinner spinner = (Spinner) findViewById(R.id.spinnerNumbAppoints);
		
		String[] numbAppoints = new String[] {"1","2","3"};
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,numbAppoints);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(dataAdapter);
		spinner.setOnItemSelectedListener(this);
	}
	
	public void fillSpinnerTime()
	{
		Spinner spinner = (Spinner) findViewById(R.id.spinnerTime);
		
		String[] times = new String[] {"8:00am", "8:30am", "9:00am", "...", "5:00pm"};
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,times);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(dataAdapter);
		spinner.setOnItemSelectedListener(this);
	}
	
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) 
	{
		Spinner spinner = (Spinner) parent;
	     if(spinner.getId() == R.id.spinnerLocations)
	     {
	    	 Toast.makeText(parent.getContext(),"SEDES, On Item Select : \n" + parent.getItemAtPosition(pos).toString(),
	                 		Toast.LENGTH_LONG).show();                   
	     }
	     
	     else if(spinner.getId() == R.id.spinnerNumbAppoints)
	     {
	    	 Toast.makeText(parent.getContext(),"CANT CITAS, On Item Select : \n" + parent.getItemAtPosition(pos).toString(),
              		Toast.LENGTH_LONG).show();    
	     }	
	     
	     else if(spinner.getId() == R.id.spinnerTime)
	     {
	    	 Toast.makeText(parent.getContext(),"HORA, On Item Select : \n" + parent.getItemAtPosition(pos).toString(),
              		Toast.LENGTH_LONG).show();    
	     }	
    }

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}	
}
