package com.SaludNaturalApp;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.SaludNaturalBusinessLogic.SymptomsModel;


public class SelectableListviewAdapter extends ArrayAdapter<SymptomsModel>{

	private final List<SymptomsModel> list;
    private final Activity context;
    
	public SelectableListviewAdapter(Activity pContext, List<SymptomsModel> pList) {
		super(pContext, R.layout.listview_row_selectable, pList);
		list = pList;
		context = pContext;
	}
	
	static class ViewHolder {
	    protected TextView text;
	    protected CheckBox checkbox;
	}
	
	@Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    View view = null;
	    
	    if (convertView == null) 
	    {
	      LayoutInflater inflator = context.getLayoutInflater();
	      view = inflator.inflate(R.layout.listview_row_selectable, null);
	      final ViewHolder viewHolder = new ViewHolder();
	      viewHolder.text = (TextView) view.findViewById(R.id.labelSymp);
	      viewHolder.checkbox = (CheckBox) view.findViewById(R.id.check);
	      viewHolder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

	            @Override
	            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) 
	            {
	            	SymptomsModel element = (SymptomsModel) viewHolder.checkbox.getTag();
	            	element.setSelected(buttonView.isChecked());
	            }
	          });
	      
	      view.setTag(viewHolder);
	      viewHolder.checkbox.setTag(list.get(position));
	    } 
	    
	    else 
	    {
	      view = convertView;
	      ((ViewHolder) view.getTag()).checkbox.setTag(list.get(position));
	    }
	    
	    ViewHolder holder = (ViewHolder) view.getTag();
	    holder.text.setText(list.get(position).getName());
	    holder.checkbox.setChecked(list.get(position).isSelected());
	    return view;
	  }
}
