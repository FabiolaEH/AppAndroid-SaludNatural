package com.SaludNaturalApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.AdapterView;
import android.view.View;
import android.content.Intent;

public class MainMenu extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.activity_menu);
        
        fillMenuList();
	}
	
	public void fillMenuList()
	{
		 ListView listView = (ListView)findViewById(R.id.menuList);
		 
		 String[] values = new String[] {"Programar Cita", 
						                 "Consultar S�ntomas",
						                 "Cat�logo Productos" 
						                };
		 
		 ListViewAdapter adapter = new ListViewAdapter(this, values);
        
        listView.setAdapter(adapter); 
        

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() 
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
            {      
               // ListView Clicked item index
               int itemPosition     = position;
               
               // ListView Clicked item value
               ListView listView = (ListView)findViewById(R.id.menuList);
               String  itemValue    = (String) listView.getItemAtPosition(position);
               
               redirectToActivity(itemValue);
                  
               /* // Show Alert 
                Toast.makeText(getApplicationContext(),
                  "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                  .show();*/
            }
        });           
	 }
	
	public void redirectToActivity(String activity)
	{
		Intent intent = null;
		
		 switch(activity)
         {
         		case "Programar Cita": 
         		{
         			intent = new Intent(this,AppointmentsScreen.class); 
         			this.startActivity(intent);
         			break;
         		}
         		
         		case "Consultar S�ntomas": 
         		{
         			intent = new Intent(this,SymptomsConsult.class); 
         			this.startActivity(intent);
         			break;
         		}
         		
         		case "Cat�logo Productos": 
         		{
         			intent = new Intent(this,Catalog.class); 
         			this.startActivity(intent);
         			break;
         		}
         		
         		default: break;
         }	
	}
}
