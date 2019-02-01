/*
 * $Id: Breadcrumb.java	2006-12-23	nt
 */


package com.bureaueye.beacon.bean;


public final class Breadcrumb {

    private String label;
    private String url;
    private String sequence;    
    
    public Breadcrumb() {
        label = "";
        url = "";
        sequence = "";     	
    }
    
    public void setLabel(String _label) {this.label = _label;}
    public String getLabel() {return this.label;}
    
    public void setUrl(String _url) {this.url = _url;}
    public String getUrl() {return this.url;}
    
    public void setSequence(String _sequence) {this.sequence = _sequence;}
    public String getSequence() {return this.sequence;}
    
}
