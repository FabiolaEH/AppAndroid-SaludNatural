package com.SaludNaturalBusinessLogic;

public class SymptomsModel {
		
	  private String name;
	  private boolean selected;

	public SymptomsModel(String pName) {
	    name = pName;
	    selected = false;
	  }
	
	  public String getName() {
	    return name;
	  }
	
	  public void setName(String name) {
	    this.name = name;
	  }
	
	  public boolean isSelected() {
	    return selected;
	  }
	
	  public void setSelected(boolean pSelected) {
	    selected = pSelected;
	  }

}
