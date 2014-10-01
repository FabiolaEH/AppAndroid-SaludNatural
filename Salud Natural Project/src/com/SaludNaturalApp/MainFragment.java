package com.SaludNaturalApp;

import android.support.v4.app.Fragment;
import android.view.*;
import android.os.Bundle;
import com.facebook.*;
import android.util.Log;
import android.content.Intent;
import com.facebook.widget.LoginButton;
import android.widget.TextView;
import com.facebook.model.*;


public class MainFragment extends Fragment  {
	
	StartActivity startActv = new StartActivity();
	private View view;
	
	private static final String TAG = "MainFragment"; //BORRARLA
	//Listens to session state changes
	private Session.StatusCallback callback = new Session.StatusCallback() 
	{
	    @Override
	    public void call(Session session, SessionState state, Exception exception) {
	        onSessionStateChange(session, state, exception);
	    }
	};
	private UiLifecycleHelper uiHelper;
	
	//constructor
	public MainFragment(StartActivity startActv) {
		this.startActv = startActv;
	}

	/*******	Methods	*******/
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    uiHelper = new UiLifecycleHelper(getActivity(), callback);
	    uiHelper.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {		
	    view = inflater.inflate(R.layout.activity_start, container, false);
	    
	    //To receive results from the authentication
	    LoginButton authButton = (LoginButton) view.findViewById(R.id.authButton);
	    //authButton.setReadPermissions(Arrays.asList("user_likes", "user_status")); //Permissions
		authButton.setFragment(this);	
	    return view;
	}
	
	//Method to control UI in authenticated and not authenticated states
	private void onSessionStateChange(Session session, SessionState state, Exception exception) {
	    if (state.isOpened()) 
	    {	
	        Log.i(TAG, "Logged in..."); // sends log output
	    } 
	    
	    else if (state.isClosed()) 
	    {
	        Log.i(TAG, "Logged out...");
	        TextView welcomeMessage = (TextView) view.findViewById(R.id.welcome);
        	welcomeMessage.setText("Se ha cerrado la sesión");
        	startActv.sessionStarted = false; // flag to redirect to MainMenu activity
	    }
			
	  //Display authentication UI
		if (session.isOpened()) 
		{		
            // make request to the /me API
            Request.newMeRequest(session, new Request.GraphUserCallback() {

            // callback after Graph API response with user object
            @Override
            public void onCompleted(GraphUser user, Response response) {
              if (user != null) 
              {
            	TextView welcomeMessage = (TextView) view.findViewById(R.id.welcome);
            	welcomeMessage.setText("Bienvenido a Salud Natural " + user.getName() + "!");
            	
            	//open main menu for facebook user
            	if(!startActv.sessionStarted)
            		startActv.startMainMenu();
              }
            }
          }).executeAsync();	          
		}
	}
	
	//To ensure that the sessions are set up correctly, override the fragment lifecycle methods:
	@Override
	public void onResume() {
	    super.onResume();
	    
	    // For scenarios where the main activity is launched and user
	    // session is not null, the session state change notification
	    // may not be triggered. Trigger it if it's open/closed.
	    Session session = Session.getActiveSession();
	    if (session != null &&(session.isOpened() || session.isClosed()) ) 
	    {
	        onSessionStateChange(session, session.getState(), null);
	    }
	    
	    uiHelper.onResume();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);
	    uiHelper.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onPause() {
	    super.onPause();
	    uiHelper.onPause();
	}

	@Override
	public void onDestroy() {
	    super.onDestroy();
	    uiHelper.onDestroy();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);
	    uiHelper.onSaveInstanceState(outState);
	}

}
