package com.bureaueye.beacon.bean.standard;
 
import java.text.DecimalFormat;
import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;


import com.bureaueye.beacon.bean.LabelValue;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.model.print.bd.CompanyheaderBD;
import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.AddrtypeBD;
import com.bureaueye.beacon.model.standard.bd.CcyBD;
import com.bureaueye.beacon.model.standard.bd.ChargeBD;
import com.bureaueye.beacon.model.standard.bd.CityBD;
import com.bureaueye.beacon.model.standard.bd.CompanyBD;
import com.bureaueye.beacon.model.standard.bd.CostBD;
import com.bureaueye.beacon.model.standard.bd.CountryBD;
import com.bureaueye.beacon.model.standard.bd.FitgrpBD;
import com.bureaueye.beacon.model.standard.bd.FittypBD;
import com.bureaueye.beacon.model.standard.bd.G1codeBD;
import com.bureaueye.beacon.model.standard.bd.G2codeBD;
import com.bureaueye.beacon.model.standard.bd.G3codeBD;
import com.bureaueye.beacon.model.standard.bd.G4codeBD;
import com.bureaueye.beacon.model.standard.bd.ImdgBD;
import com.bureaueye.beacon.model.standard.bd.IncotermBD;
import com.bureaueye.beacon.model.standard.bd.LeasetypeBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.LocationtypeBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;
import com.bureaueye.beacon.model.standard.bd.RejectreasonBD;
import com.bureaueye.beacon.model.standard.bd.RepairstatusBD;
import com.bureaueye.beacon.model.standard.bd.SectionBD;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;
import com.bureaueye.beacon.model.standard.bd.TaxcodeBD;
import com.bureaueye.beacon.model.standard.bd.TesttypeBD;
import com.bureaueye.beacon.model.standard.bd.TransportmodeBD;
import com.bureaueye.beacon.model.standard.bd.UserBD;
import com.bureaueye.beacon.model.standard.bd.UsergroupBD;
import com.bureaueye.beacon.model.standard.bd.VesselBD;
import com.bureaueye.beacondms.model.dms.bd.DocumenttypeBD;
import com.bureaueye.beacon.model.standard.bd.CategoryBD;
import com.bureaueye.beacon.model.standard.bd.SubcategoryBD;



/**
 * 
 * Amendments
 * ----------
 * 												
 * NT	2012-07-26		ITT-201207-0001		Add Contract Type 
 *   
 */
public class DataPool {
	
	/**
	 * The <code>Log</code> instance for this application.
	 */
	public static Log log = LogFactory.getLog(com.bureaueye.beacon.bean.Constants.PACKAGE); 
	
	
	
	
	// constructors
	public DataPool() {
	}
	public DataPool(SessionFactory _factory) {
		setSessionFactory1(_factory);		
	}
	public DataPool(SessionFactory _factory1, SessionFactory _factory2) {
		setSessionFactory1(_factory1);
		setSessionFactory2(_factory2);
	}	
	
	
	
	public DataPool(Map<String, SessionFactory> sfcm) {
		setSessionFactoryClusterMap(sfcm);		
	}
	
	protected static Map<String, SessionFactory> _sessionFactoryClusterMap;
	/**
	 * Set the session factory cluster to Map
	 */
	public void setSessionFactoryClusterMap (Map<String, SessionFactory> sfcm) {
		_sessionFactoryClusterMap = sfcm;
	}	
	/**
	 * get the session factory cluster Map
	 */
	public Map<String, SessionFactory> getSessionFactoryClusterMap () {
		return _sessionFactoryClusterMap;
	}	
	/**
	 * Get the session factory cluster from Map
	 */
	public SessionFactory getSessionFactoryCluster(String configFileName) {
		if (null == configFileName) configFileName = "";
		SessionFactory sf = (SessionFactory) this.getSessionFactoryClusterMap().get(configFileName);
		if (null == sf)
			throw new RuntimeException(
					"The session factory for Config Filename '" + 
					configFileName + 
					"' has not been found"
			);
		else {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" getSessionFactoryCluster:  Found Session Factory for Config Filename '" + 
					configFileName + 
					"'"
			);
			return sf;
		}
	}
	/**
	 * Get the session factory cluster from Map by class
	 */
	public SessionFactory getSessionFactoryClusterByClass(String className) {
		if (null == className) className = "";
		SessionFactory sf = null;
		for (Iterator it = this.getSessionFactoryClusterMap().values().iterator(); it.hasNext();) {
			sf = (SessionFactory)it.next();
			if (!(sf.getAllClassMetadata().containsKey(className))) sf = null;
			// break loop if session factory cluster found
			if (null != sf) break;
		}
		if (null == sf)
			throw new RuntimeException(
					"The session factory for Class Name '" + 
					className + 
					"' has not been found"
			);
		else {
			log.debug("["+this.getClass().getName()+"] "+new java.util.Date()+
					" getSessionFactoryClusterByClass:  Found Session Factory for Class Name '" + 
					className + 
					"'"
			);			
			return sf;
		}
	}
	
	
	
	
	private SessionFactory _sessionFactory1;
	
	public SessionFactory getSessionFactory1 () {
		return _sessionFactory1;
	}
	public void setSessionFactory1 (SessionFactory _factory) {
		this._sessionFactory1 = _factory;
	}
	
	private SessionFactory _sessionFactory2;
	
	public SessionFactory getSessionFactory2 () {
		return _sessionFactory2;
	}
	public void setSessionFactory2 (SessionFactory _factory) {
		this._sessionFactory2 = _factory;
	}
	
	
	
	// standard model objects
	private List addresss;
	
	private List lessees;
	private List lessors;
	private List agents;
	private List owners;
	
	private List customerlessees;
	
	private List vessels;
	
	private List consignees;
	
	private List fwdagents;
	
	private List brokers;
	
	private List testtypes;
	
	private List leasetypes;
	
	private List shippers;
	
	private List customers;
	
	private List vendors;
	
	private List depots;
	
	private List ccys;
	
	private List charges;
	
	private List costs;
	private List mandrcosts;
	
	
	private List statuscodes;
	
	private List addrtypes;
	
	private List locationtypes;
	
	private List transportmodes;
	
	private List rejectreasons;
	
	private List dispositions;
	
	private List users;
	
	private List usergroups;
	
	private List products;
	
	private List ports;
	
	private List plants;
	
	private List deliverylocations1;
	
	private List pickuplocations1;
	
	private List deliverylocations2;
	
	private List pickuplocations2;
	
	private List piers;
	
	private List<LabelValue> days;
	
	private List<LabelValue> hours;
	private List<LabelValue> minutes;
	
	private List<LabelValue> months;
	
	private List<LabelValue> years;
	
	private List shipmethods;
	
	private List companys;
	
	private List departments;
	
	private List activitys;
	
	private List volunits;
	
	private List wghtunits;
	
	private List tempunits;
	
	private List locations;
	
	private List prioritys;
	
	private List notecatgs;
	
	private List invoicestatuss;
	
	private List taxcodes;
	
	private List sections;
	
	private List citys;
	
	private List countrys;
	
	private List companyheaders;
	
	private List pageresults;
	
	private List eqpkeyp1s;
	private List eqpkeyp2s;
	private List eqpkeyp3s;
	private List eqpkeyp4s;
	private List eqpkeyp5s;
	
	private List movestatuss;
	
	
	private List fittyps;
	private List fitgrps;
	
	
	private List incoterms;

	private List damagecodes;
	private List repaircodes;
	private List componentcodes;	
	private List materialtypecodes;
	private List locationcode1s;	
	private List locationcode2s;	
	private List repairstatuss;	
	private List responsibilitycodes;
	private List unitmeasurecodes;	
	
	private List mandrcancelreasons;
	
	
	private List productcolors;	
	private List productfleetgroups;
	private List productcategorys;
	private List imdgs;	
	
	private List g1codes;	
	private List g2codes;		
	private List g3codes;		
	private List g4codes;	
	

	
	private List categorys;
	private List subcategorys;	
	private List doctypes;
	

	
	private List contracttypes;//ITT-201207-0001
	

	
	//sITT-201207-0001
	// Set the value 
	public void setContracttypes() throws ApplicationException {
		contracttypes = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("CONTRACTTYPE");
	}
	// Get the value 
	public List getContracttypes() { return contracttypes; }
	//eITT-201207-0001
	
	
	
	// Set the value 
	public void setDoctypes() throws ApplicationException {
		doctypes = new DocumenttypeBD(this.getSessionFactoryClusterMap()).findDocumenttypes();
	}
	// Get the value 
	public List getDoctypes() { return doctypes; }
	
	// Set the value 
	public void setCategorys() throws ApplicationException {
		categorys = new CategoryBD(this.getSessionFactoryClusterMap()).findCategorys();
	}
	// Get the value 
	public List getCategorys() { return categorys; }
		
	// Set the value 
	public void setSubcategorys() throws ApplicationException {
		subcategorys = new SubcategoryBD(this.getSessionFactoryClusterMap()).findSubcategorys();
	}
	// Get the value 
	public List getSubcategorys() { return subcategorys; }
	
	
	
	// Set the value 
	public void setEqpkeyp1s() throws ApplicationException {
		eqpkeyp1s = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("EQPKEYP1");
	}
	// Get the value 
	public List getEqpkeyp1s() { return eqpkeyp1s; }
	
	// Set the value 
	public void setEqpkeyp2s() throws ApplicationException {
		eqpkeyp2s = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("EQPKEYP2");
	}
	// Get the value 
	public List getEqpkeyp2s() { return eqpkeyp2s; }
	
	// Set the value 
	public void setEqpkeyp3s() throws ApplicationException {
		eqpkeyp3s = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("EQPKEYP3");
	}
	// Get the value 
	public List getEqpkeyp3s() { return eqpkeyp3s; }
	
	// Set the value 
	public void setEqpkeyp4s() throws ApplicationException {
		eqpkeyp4s = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("EQPKEYP4");
	}
	// Get the value 
	public List getEqpkeyp4s() { return eqpkeyp4s; }	
	
	// Set the value 
	public void setEqpkeyp5s() throws ApplicationException {
		eqpkeyp5s = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("EQPKEYP5");
	}
	// Get the value 
	public List getEqpkeyp5s() { return eqpkeyp5s; }
	
	
	
	
	// Set the value 
	public void setMovestatuss() throws ApplicationException {
		movestatuss = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("MOVESTATUS");
	}
	// Get the value 
	public List getMovestatuss() { return movestatuss; }
	
	
	public void setHours() {
		hours = new ArrayList<LabelValue>();
		DecimalFormat df = new DecimalFormat("00");
		int count = 0;
		while (count < 24) {
			LabelValue lv = new LabelValue();
			lv.setLabel(df.format(count));
			lv.setValue(df.format(count));
			this.hours.add(lv);
			++count;
		}
	}
	// Get the value
	public List getHours() {return hours;}
	
	
	public void setMinutes() {
		minutes = new ArrayList<LabelValue>();
		DecimalFormat df = new DecimalFormat("00");
		int count = 0;
/*		while (count < 60) {
			LabelValue lv = new LabelValue();
			lv.setLabel(df.format(count));
			lv.setValue(df.format(count));
			this.minutes.add(lv);
			++count;
		}*/
		LabelValue lv = new LabelValue();
		lv.setLabel(df.format(15));
		lv.setValue(df.format(15));
		this.minutes.add(lv);
		 lv = new LabelValue();
		lv.setLabel(df.format(30));
		lv.setValue(df.format(30));
		this.minutes.add(lv);
		 lv = new LabelValue();
		lv.setLabel(df.format(45));
		lv.setValue(df.format(45));
		this.minutes.add(lv);		
	}
	// Get the value
	public List getMinutes() {return minutes;}
	
	
	// Set the value
	public void setMonths() {
		months = new ArrayList<LabelValue>();
		DecimalFormat df = new DecimalFormat("00");
		StringTokenizer st = new StringTokenizer(Constants.MONTH_LIST, ",");
		int count = 0;
		while (st.hasMoreTokens()) {
			LabelValue lv = new LabelValue();
			lv.setLabel(st.nextToken());
			lv.setValue(df.format(++count));
			months.add(lv);
		}
	}
	
	// Get the value
	public List getMonths() {
		return months;
	}
	
	public void setYears() { 
		years = new ArrayList<LabelValue>();
		StringTokenizer st = new StringTokenizer(Constants.YEAR_LIST, ",");
		while (st.hasMoreTokens()) {
			String year = st.nextToken();
			LabelValue lv = new LabelValue();
			lv.setLabel(year);
			lv.setValue(year);
			years.add(lv);
		}
	}
	
	// Get the value
	public List getYears() {
		return years;
	}
	
	public void setDays() {
		days = new ArrayList<LabelValue>();
		DecimalFormat df = new DecimalFormat("00");
		int count = 0;
		while (count < 31) {
			LabelValue lv = new LabelValue();
			lv.setLabel(df.format(++count));
			lv.setValue(df.format(count));
			this.days.add(lv);
		}
	}
	
	// Get the value
	public List getDays() {
		return days;
	}
	
	// Set the value
	public void setVessels() throws ApplicationException {
		vessels = new VesselBD(this.getSessionFactoryClusterMap()).findVessels();
	}
	// Get the value
	public List getVessels() {
		return vessels;
	}
	
	// Set the value
	public void setADDRESSS() throws ApplicationException {
		addresss = new AddressBD(this.getSessionFactoryClusterMap()).findAddressesAll("Name");
	}
	// Get the value
	public List getAddresss() {return addresss;}
	
	
	// Set the value
	public void setCUSTOMERLESSEES() throws ApplicationException {
		String typelist="CUSTOMER|LESSEE";
		// change required to use Typekey List
		customerlessees = new AddressBD().findAddresslistByType(this.addresss,typelist,"Name");	
	}
	// Get the value
	public List getCustomerlessees() {return customerlessees;}
	
	
	
	// Set the value
	public void setLESSEES() throws ApplicationException {
		String typelist="LESSEE";
		// change required to use Typekey List
		lessees = new AddressBD().findAddresslistByType(this.addresss,typelist,"Name");	
	}
	// Get the value
	public List getLessees() {return lessees;}
	
	// Set the value
	public void setLESSORS() throws ApplicationException {
		String typelist="LESSOR";
		// change required to use Typekey List
		lessors = new AddressBD().findAddresslistByType(this.addresss,typelist,"Name");	
	}
	// Get the value
	public List getLessors() {return lessors;}
	
	// Set the value
	public void setAGENTS() throws ApplicationException {
		String typelist="AGENT";
		// change required to use Typekey List
		agents = new AddressBD().findAddresslistByType(this.addresss,typelist,"Name");	
	}
	// Get the value
	public List getAgents() {return agents;}
	
	
	// Set the value
	public void setOWNERS() throws ApplicationException {
		String typelist="OWNER";
		// change required to use Typekey List
		owners = new AddressBD().findAddresslistByType(this.addresss,typelist,"Name");
	}
	// Get the value
	public List getOwners() {return owners;}
	
	
	
	// Set the value
	public void setCONSIGNEES() throws ApplicationException {
		String typelist="CONSIGNEE";
		// change required to use Typekey List
		consignees = new AddressBD().findAddresslistByType(this.addresss,typelist,"Name");
	}
	// Get the value
	public List getConsignees() {return consignees;}
	
	// Set the value
	public void setCUSTOMERS() throws ApplicationException {
		String typelist="CUSTOMER";
		// change required to use Typekey List
		customers = new AddressBD().findAddresslistByType(this.addresss,typelist,"Name");
	}
	
	// Get the value
	public List getCustomers() {
		return customers;
	}
	
	// Set the value
	public void setBROKERS() throws ApplicationException {
		String typelist="BROKER";
		// change required to use Typekey List
		brokers = new AddressBD().findAddresslistByType(this.addresss,typelist,"Name");
	}
	
	// Get the value
	public List getBrokers() {
		return brokers;
	}
	
	// Set the value
	public void setSHIPPERS() throws ApplicationException {
		String typelist="SHIPPER";
		// change required to use Typekey List
		shippers = new AddressBD().findAddresslistByType(this.addresss,typelist,"Name");
	}
	
	// Get the value
	public List getShippers() {
		return shippers;
	}
	
	// Set the value
	public void setFWDAGENTS() throws ApplicationException {
		String typelist="FWDAGENT";
		// change required to use Typekey List
		fwdagents = new AddressBD().findAddresslistByType(this.addresss,typelist,"Name");
	}
	
	// Get the value
	public List getFwdagents() {
		return fwdagents;
	}
	
	// Set the value
	public void setVENDORS() throws ApplicationException {
		String typelist="VENDOR";
		// change required to use Typekey List
		vendors = new AddressBD().findAddresslistByType(this.addresss,typelist,"Name");
	}
	
	// Get the value
	public List getVendors() {
		return vendors;
	}
	
	// Set the value
	public void setDEPOTS() throws ApplicationException {
		String typelist="DEPOT";
		// change required to use Typekey List
		depots = new LocationBD().findLocationlistByType(this.locations,typelist,"LocationName");
	}
	
	// Get the value
	public List getDepots() {
		return depots;
	}
	
	// Set the value
	public void setLocations() throws ApplicationException {
		locations = new LocationBD(this.getSessionFactoryClusterMap()).findLocationsAll("LocationName");
	}
	
	// Get the value
	public List getLocations() {
		return locations;
	}
	
	// Set the value
	public void setPORTS() throws ApplicationException {
		String typelist="PORT";
		// change required to use Typekey List
		ports = new LocationBD().findLocationlistByType(this.locations,typelist,"LocationName");
	}
	
	// Get the value
	public List getPorts() {
		return ports;
	}
	
	// Set the value
	public void setPLANTS() throws ApplicationException {
		String typelist="PLANT";
		// change required to use Typekey List
		plants = new LocationBD().findLocationlistByType(this.locations,typelist,"LocationName");
	}
	
	// Get the value
	public List getPlants() {
		return plants;
	}
	
	// Set the value
	public void setPIERS() throws ApplicationException {
		String typelist="PIER";
		// change required to use Typekey List
		piers = new LocationBD().findLocationlistByType(this.locations,typelist,"LocationName");
	}
	
	// Get the value
	public List getPiers() {
		return piers;
	}
	
	// Set the value
	public void setAddrtypes() throws ApplicationException  {
		addrtypes = new AddrtypeBD(this.getSessionFactoryClusterMap()).findAddrtypes();
	}
	
	// Get the value
	public List getAddrtypes() {
		return addrtypes;
	}
	
	// Set the value
	public void setLocationtypes() throws ApplicationException  {
		locationtypes = new LocationtypeBD(this.getSessionFactoryClusterMap()).findLocationtypes();
	}
	
	// Get the value
	public List getLocationtypes() {
		return locationtypes;
	}
	
	// Set the value
	public void setTesttypes() throws ApplicationException {
		testtypes = new TesttypeBD(this.getSessionFactoryClusterMap()).findTesttypes();
	}
	// Get the value
	public List getTesttypes() {
		return testtypes;
	}
	
	// Set the value
	public void setLeasetypes() throws ApplicationException {leasetypes = new LeasetypeBD(this.getSessionFactoryClusterMap()).findLeasetypes();}
	// Get the value
	public List getLeasetypes() {return leasetypes;}
	
	
	// Set the value
	public void setTransportmodes() throws ApplicationException {
		transportmodes = new TransportmodeBD(this.getSessionFactoryClusterMap()).findTransportmodes();
	}
	// Get the value
	public List getTransportmodes() {
		return transportmodes;
	}
	
	
	
	
	
	// Set the value 
	public void setStatuscodes() throws ApplicationException {
		statuscodes = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("STATUSCODE");
	}
	// Get the value 
	public List getStatuscodes() { return statuscodes; }
	
	
	
	// Set the value
	public void setRejectreasons() throws ApplicationException  {
		rejectreasons = new RejectreasonBD(this.getSessionFactoryClusterMap()).findRejectreasons();
	}
	
	// Get the value
	public List getRejectreasons() {
		return rejectreasons;
	}
	
	// Set the value
	public void setCcys() throws ApplicationException {
		ccys = new CcyBD(this.getSessionFactoryClusterMap()).findCcys();
	}
	
	// Get the value
	public List getCcys() {
		return ccys;
	}
	
	// Set the value
	public void setCharges() throws ApplicationException {
		charges = new ChargeBD(this.getSessionFactoryClusterMap()).findCharges();
	}
	
	// Get the value
	public List getCharges() {
		return charges;
	}
	
	// Set the value
	public void setCosts() throws ApplicationException {
		costs = new CostBD(this.getSessionFactoryClusterMap()).findCosts();
	}
	
	// Get the value
	public List getCosts() {
		return costs;
	}

	// Set the value
	public void setMandrcosts() throws ApplicationException {
		mandrcosts = new CostBD(this.getSessionFactoryClusterMap()).findMandrCosts();
	}
	
	// Get the value
	public List getMandrcosts() {
		return mandrcosts;
	}
	
	
	// Set the value
	public void setSections() throws ApplicationException {
		sections = new SectionBD(this.getSessionFactoryClusterMap()).findSections();
	}
	
	// Get the value
	public List getSections() {
		return sections;
	}
	
	
	// Set the value
	public void setDispositions() throws ApplicationException {
		dispositions = new SystemcodeBD(this.getSessionFactoryClusterMap())
		.findSystemcodesByTypekey("DISPOSITIO");
	}
	
	// Get the value
	public List getDispositions() {
		return dispositions;
	}
	
	// Set the value
	public void setUsers() throws ApplicationException {
		users = new UserBD(this.getSessionFactoryClusterMap()).findUsers();
	}
	
	// Get the value
	public List getUsers() {
		return users;
	}
	
	// Set the value
	public void setUsergroups() throws ApplicationException {
		usergroups = new UsergroupBD(this.getSessionFactoryClusterMap()).findUsergroups();
	}
	
	// Get the value
	public List getUsergroups() {
		return usergroups;
	}
	
	// Set the value
	public void setProducts() throws ApplicationException {
		products = new ProductBD(this.getSessionFactoryClusterMap()).findProducts();
	}
	
	// Get the value
	public List getProducts() {
		return products;
	}
	
	// Set the value
	public void setShipmethods() throws ApplicationException {
		shipmethods = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("SHIPMETHOD");
	}
	
	// Get the value
	public List getShipmethods() {
		return shipmethods;
	}
	
	// Set the value
	public void setActivitys() throws ApplicationException {
		activitys = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("ACTIVITY");
	}
	
	// Get the value
	public List getActivitys() {
		return activitys;
	}
	
	// Set the value
	public void setDepartments() throws ApplicationException {
		departments = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("DEPARTMENT");
	}
	
	// Get the value
	public List getDepartments() {
		return departments;
	}
	
	// Set the value
	public void setCompanys() throws ApplicationException {
		companys = new CompanyBD(this.getSessionFactoryClusterMap()).findCompanys();
	}
	
	// Get the value
	public List getCompanys() {
		return companys;
	}
	
	// Set the value
	public void setCompanyheaders() throws ApplicationException {
		companyheaders = new CompanyheaderBD(this.getSessionFactoryClusterMap()).findCompanyheaders();
	}
	
	// Get the value
	public List getCompanyheaders() {
		return companyheaders;
	}
	
	
	
	// Set the value 
	public void setVolunits() throws ApplicationException {
		volunits = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("VOLUNIT");
		
	}
	// Get the value 
	public List getVolunits() { return volunits; }
	
	// Set the value 
	public void setWghtunits() throws ApplicationException {
		wghtunits = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("WGHTUNIT");
	}
	// Get the value 
	public List getWghtunits() { return wghtunits; }	
	
	// Set the value 
	public void setTempunits() throws ApplicationException {
		tempunits = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("TEMPUNIT");
	}
	// Get the value 
	public List getTempunits() { return tempunits; }
	
	
	// Set the value 
	public void setPrioritys() throws ApplicationException {
		prioritys = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("PRIORITY");
	}
	// Get the value 
	public List getPrioritys() { return prioritys; }
	
	// Set the value 
	public void setNotecatgs() throws ApplicationException {
		notecatgs = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("NOTECATG");
	}
	// Get the value 
	public List getNotecatgs() { return notecatgs; }
	
	// Set the value 
	public void setTaxcodes() throws ApplicationException {
		// removed from Systemcode table as rate is required to new TAXCODE table built 2007-04-01
		//taxcodes = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("TAXCODE");
		taxcodes = new TaxcodeBD(this.getSessionFactoryClusterMap()).findTaxcodes();
	}
	// Get the value 
	public List getTaxcodes() { return taxcodes; }
	
	
	// Set the value 
	public void setPageresults() throws ApplicationException {
		pageresults = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("PAGERESULT");
	}
	// Get the value 
	public List getPageresults() { return pageresults; }
	
	
	
	// Set the value 
	public void setCitys() throws ApplicationException {
		citys = new CityBD(this.getSessionFactoryClusterMap()).findCitys();
	}
	// Get the value 
	public List getCitys() { return citys; }
	
	// Set the value 
	public void setCountrys() throws ApplicationException {
		countrys = new CountryBD(this.getSessionFactoryClusterMap()).findCountrys();
	}
	// Get the value 
	public List getCountrys() { return countrys; }
	
	
	// Set the value 
	public void setInvoicestatuss() throws ApplicationException {
		invoicestatuss = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("INVOICESTATUS");
	}
	// Get the value 
	public List getInvoicestatuss() { return invoicestatuss; }
	
	
	// Set the value 
	public void setIncoterms() throws ApplicationException {
		incoterms = new IncotermBD(this.getSessionFactoryClusterMap()).findIncoterms();
	}
	// Get the value 
	public List getIncoterms() { return incoterms; }
	
	// Set the value 
	public void setImdgs() throws ApplicationException {
		imdgs = new ImdgBD(this.getSessionFactoryClusterMap()).findImdgs();
	}
	// Get the value 
	public List getImdgs() { return imdgs; }

	
	
	// Set the value 
	public void setG1codes() throws ApplicationException {
		g1codes = new G1codeBD(this.getSessionFactoryClusterMap()).findG1codes();
	}
	// Get the value 
	public List getG1codes() { return g1codes; }
	
	// Set the value 
	public void setG2codes() throws ApplicationException {
		g2codes = new G2codeBD(this.getSessionFactoryClusterMap()).findG2codes();
	}
	// Get the value 
	public List getG2codes() { return g2codes; }
	
	// Set the value 
	public void setG3codes() throws ApplicationException {
		g3codes = new G3codeBD(this.getSessionFactoryClusterMap()).findG3codes();
	}
	// Get the value 
	public List getG3codes() { return g3codes; }
	
	// Set the value 
	public void setG4codes() throws ApplicationException {
		g4codes = new G4codeBD(this.getSessionFactoryClusterMap()).findG4codes();
	}
	// Get the value 
	public List getG4codes() { return g4codes; }
	
	
	
	
	// Set the value 
	public void setFittyps() throws ApplicationException {
		fittyps = new FittypBD(this.getSessionFactoryClusterMap()).findFittyps();
	}
	// Get the value 
	public List getFittyps() { return fittyps; }
	
	
	// Set the value 
	public void setFitgrps() throws ApplicationException {
		fitgrps = new FitgrpBD(this.getSessionFactoryClusterMap()).findFitgrps();
	}
	// Get the value 
	public List getFitgrps() { return fitgrps; }
	
	
	// Set the value
	public void setDeliverylocations1() throws ApplicationException {
		String typelist="";
		try {
			typelist = new SystemcodeBD(this.getSessionFactoryClusterMap())
			.findSystemcodesByTypekeyCodekey("LOCATIONTYPELIST","DELIVERYLOCATIONS1").getDescr();
		} catch (Exception e) {
		}
		// change required to use Typekey List
		deliverylocations1 = new LocationBD().findLocationlistByType(this.locations,typelist,"LocationName");		
	}
	
	// Get the value
	public List getDeliverylocations1() {
		return deliverylocations1;
	}
	
	// Set the value
	public void setPickuplocations1() throws ApplicationException {
		String typelist="";
		try {
			typelist = new SystemcodeBD(this.getSessionFactoryClusterMap())
			.findSystemcodesByTypekeyCodekey("LOCATIONTYPELIST","PICKUPLOCATIONS1").getDescr();
		} catch (Exception e) {
		}
		// change required to use Typekey List
		pickuplocations1 = new LocationBD().findLocationlistByType(this.locations,typelist,"LocationName");			
	}
	
	// Get the value
	public List getPickuplocations1() {
		return pickuplocations1;
	}
	
	// Set the value
	public void setDeliverylocations2() throws ApplicationException {;
	String typelist="";
	try {
		typelist = new SystemcodeBD(this.getSessionFactoryClusterMap())
		.findSystemcodesByTypekeyCodekey("LOCATIONTYPELIST","DELIVERYLOCATIONS2").getDescr();
	} catch (Exception e) {
	}
	// change required to use Typekey List
	deliverylocations2 = new LocationBD().findLocationlistByType(this.locations,typelist,"LocationName");			
	}
	
	// Get the value
	public List getDeliverylocations2() {
		return deliverylocations2;
	}
	
	// Set the value
	public void setPickuplocations2() throws ApplicationException {
		String typelist="";
		try {
			typelist = new SystemcodeBD(this.getSessionFactoryClusterMap())
			.findSystemcodesByTypekeyCodekey("LOCATIONTYPELIST","PICKUPLOCATIONS2").getDescr();
		} catch (Exception e) {
		}
		// change required to use Typekey List
		pickuplocations2 = new LocationBD().findLocationlistByType(this.locations,typelist,"LocationName");		
	}
	
	// Get the value
	public List getPickuplocations2() {
		return pickuplocations2;
	}
	

	
	
	// Set the value 
	public void setDamagecodes() throws ApplicationException {
		damagecodes = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("DAMAGECODE");
	}
	// Get the value 
	public List getDamagecodes() { return damagecodes; }

	// Set the value 
	public void setRepaircodes() throws ApplicationException {
		repaircodes = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("REPAIRCODE");
	}
	// Get the value 
	public List getRepaircodes() { return repaircodes; }

	// Set the value 
	public void setMaterialtypecodes() throws ApplicationException {
		materialtypecodes = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("MATERIALTYPECODE");
	}
	// Get the value 
	public List getMaterialtypecodes() { return materialtypecodes; }
	
	// Set the value 
	public void setRepairstatuss() throws ApplicationException {
		repairstatuss = new RepairstatusBD(this.getSessionFactoryClusterMap()).findRepairstatuss();
	}
	// Get the value 
	public List getRepairstatuss() { return repairstatuss; }

	// Set the value 
	public void setLocationcode1s() throws ApplicationException {
		locationcode1s = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("LOCATIONCODE1");
	}
	// Get the value 
	public List getLocationcode1s() { return locationcode1s; }
	
	// Set the value 
	public void setLocationcode2s() throws ApplicationException {
		locationcode2s = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("LOCATIONCODE2");
	}
	// Get the value 
	public List getLocationcode2s() { return locationcode2s; }
	
	// Set the value 
	public void setComponentcodes() throws ApplicationException {
		componentcodes = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("COMPONENTCODE");
	}
	// Get the value 
	public List getComponentcodes() { return componentcodes; }
	
	// Set the value 
	public void setResponsibilitycodes() throws ApplicationException {
		responsibilitycodes = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("RESPONSIBILITYCODE");
	}
	// Get the value 
	public List getResponsibilitycodes() { return responsibilitycodes; }
	
	// Set the value 
	public void setUnitmeasurecodes() throws ApplicationException {
		unitmeasurecodes = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("UNITMEASURECODE");
	}
	// Get the value 
	public List getUnitmeasurecodes() { return unitmeasurecodes; }
	
	
	// Set the value 
	public void setMandrcancelreasons() throws ApplicationException {
		mandrcancelreasons = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("MANDRCANCELREASON");
	}
	// Get the value 
	public List getMandrcancelreasons() { return mandrcancelreasons; }
	
	
	// Set the value 
	public void setProductcolors() throws ApplicationException {
		productcolors = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("PRODUCTCOLOR");
	}
	// Get the value 
	public List getProductcolors() { return productcolors; }	

	// Set the value 
	public void setProductfleetgroups() throws ApplicationException {
		productfleetgroups = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("PRODUCTFLEETGROUP");
	}
	// Get the value 
	public List getProductfleetgroups() { return productfleetgroups; }	

	// Set the value 
	public void setProductcategorys() throws ApplicationException {
		productcategorys = new SystemcodeBD(this.getSessionFactoryClusterMap()).findSystemcodesByTypekey("PRODUCTCATEGORY");
	}
	// Get the value 
	public List getProductcategorys() { return productcategorys; }	
	
	
	
}
