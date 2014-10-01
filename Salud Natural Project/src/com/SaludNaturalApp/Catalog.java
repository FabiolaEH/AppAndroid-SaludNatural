package com.SaludNaturalApp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Catalog extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	 // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.activity_catalog);
        fillProducts();
	}
	
	public void fillProducts()
	{
		 ListView listView = (ListView) findViewById(R.id.productsList);
         
         // Defined Array values to show in ListView
         String[] values = new String[] { "Gel aloe vera", 
                                          "Cápsulas de manzanilla",
                                          "Unguento de Gengibre",
                                          "Gel aloe vera", 
                                          "Cápsulas de manzanilla",
                                          "Unguento de Gengibre",
                                          "Gel aloe vera", 
                                          "Cápsulas de manzanilla",
                                          "Unguento de Gengibre",
                                          "Gel aloe vera", 
                                          "Cápsulas de manzanilla",
                                          "Unguento de Gengibre",
                                          "Gel aloe vera", 
                                          "Cápsulas de manzanilla",
                                          "Unguento de Gengibre",
                                          "Gel aloe vera", 
                                          "Cápsulas de manzanilla",
                                          "Unguento de Gengibre",
                                          "Gel aloe vera", 
                                          "Cápsulas de manzanilla",
                                          "Unguento de Gengibre",
                                          "Gel aloe vera", 
                                          "Cápsulas de manzanilla",
                                          "Unguento de Gengibre"
                                         };
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                 android.R.layout.simple_list_item_1, android.R.id.text1, values);
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
                ListView listView = (ListView)findViewById(R.id.productsList);
                String  itemValue    = (String) listView.getItemAtPosition(position);
                
                redirectToProduct(itemValue);
                   
                /* // Show Alert 
                 Toast.makeText(getApplicationContext(),
                   "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                   .show();*/
             }
         });           
	}
	
	public void redirectToProduct(String producto)
	{
		
	}

}
