package com.SaludNaturalApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends ArrayAdapter<String> {

	private final Context context;
	private final String[] values;
	
	public ListViewAdapter(Context context, String[] values) 
	{
	    super(context, R.layout.menu_listview_row, values);
	    this.context = context;
	    this.values = values;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) 
	{
	    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.menu_listview_row, parent, false);
	    TextView textView = (TextView) rowView.findViewById(R.id.label);
	    ImageView imageView = (ImageView) rowView.findViewById(R.id.menuIcon);
	    textView.setText(values[position]);
	    
	    // set icons
	    String option = values[position];
	    
	    if(option.startsWith("Programar")) 
	    	imageView.setImageResource(R.drawable.cita);
	    
	    else if(option.startsWith("Consultar"))
	    	imageView.setImageResource(R.drawable.sintomas);
	    
	    else if(option.startsWith("Catálogo"))
	    	imageView.setImageResource(R.drawable.productos);
	    

	    return rowView;
	  }
}
