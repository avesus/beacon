/*
 * $Id: LabelValue.java 54929 2004-10-16 16:38:42Z germuska $ 
 */


package com.bureaueye.beacon.bean;


public final class LabelValue {



    private String label = "";
    private String value = "";
    
    public LabelValue() {}
    public LabelValue(String _label, String _value) {
    	this.label = _label;
    	this.value = _value;
    }
    
    public void setLabel(String _label) {this.label = _label;}
    public String getLabel() {return this.label;}
    public void setValue(String _value) {this.value = _value;}
    public String getValue() {return this.value;}
    
}
