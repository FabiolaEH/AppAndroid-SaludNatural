package com.SaludNaturalApp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import android.widget.ArrayAdapter;
import com.SaludNaturalBusinessLogic.SymptomsModel;

public class SymptomsConsult extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.activity_symptoms);
        
        fillSymptomsList();
	}
	
	public void fillRecProducts()
	{
		 ListView listView = (ListView) findViewById(R.id.recProductsList);
         
         // Defined Array values to show in ListView
         String[] values = new String[] { "Gel aloe vera", 
                                          "C�psulas de manzanilla",
                                          "Unguento de Gengibre"
                                         };
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                 android.R.layout.simple_list_item_1, android.R.id.text1, values);
         listView.setAdapter(adapter); 
	}
	
	public void fillSymptomsList()
	{
		ListView listView = (ListView)findViewById(R.id.symptomsList);
		
		ArrayAdapter<SymptomsModel> adapter = new SelectableListviewAdapter(this, getSymptomsModel());
		listView.setAdapter(adapter); 
		
	}
	

	  private List<SymptomsModel> getSymptomsModel() 
	  {
	    List<SymptomsModel> list = new ArrayList<SymptomsModel>();
	    list.add(new SymptomsModel("Fiebre"));
	    list.add(new SymptomsModel("V�mito"));
	    list.add(new SymptomsModel("Diarrea"));
	    list.add(new SymptomsModel("Dolor de Cabeza"));
	    list.add(new SymptomsModel("Dolor de Cuerpo"));
	    list.add(new SymptomsModel("Fatiga"));
	    list.add(new SymptomsModel("Nauseas"));
	    
	    list.add(new SymptomsModel("Fiebre"));
	    list.add(new SymptomsModel("V�mito"));
	    list.add(new SymptomsModel("Diarrea"));
	    list.add(new SymptomsModel("Dolor de Cabeza"));
	    list.add(new SymptomsModel("Dolor de Cuerpo"));
	    list.add(new SymptomsModel("Fatiga"));
	    list.add(new SymptomsModel("Nauseas"));
	    
	    list.add(new SymptomsModel("Fiebre"));
	    list.add(new SymptomsModel("V�mito"));
	    list.add(new SymptomsModel("Diarrea"));
	    list.add(new SymptomsModel("Dolor de Cabeza"));
	    list.add(new SymptomsModel("Dolor de Cuerpo"));
	    list.add(new SymptomsModel("Fatiga"));
	    list.add(new SymptomsModel("Nauseas"));
	    
	    // Initially select one of the items
	    //list.get(1).setSelected(true);
	    return list;
	  }

}
