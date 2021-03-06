package com.SaludNaturalApp;

import com.SaludNaturalApp.R;
import android.support.v4.app.FragmentActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class StartActivity extends FragmentActivity  {
	
	private MainFragment mainFragment;
	boolean sessionStarted = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
			
        // Start fragment
		if (savedInstanceState == null) 
		{	
			// Add the fragment on initial activity setup
		    mainFragment = new MainFragment(this);
		    getSupportFragmentManager()
		    .beginTransaction()
		    .add(android.R.id.content, mainFragment)
		    .commit();
		} 	
		else 
		{
	        // Or set the fragment from restored state info
	        mainFragment = (MainFragment) getSupportFragmentManager()
	        .findFragmentById(android.R.id.content);
		}
	
	}
	
	public void startMainMenu()
	{	
    	sessionStarted = true; // flag to redirect to MainMenu activity
		Intent intent = new Intent(this,MainMenu.class); 
		//start the second Activity
		this.startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
        
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void logGuest(View view)
	{
		Intent intent = new Intent(this,MainMenu.class); 
		//start the second Activity
		this.startActivity(intent);
	}
}
