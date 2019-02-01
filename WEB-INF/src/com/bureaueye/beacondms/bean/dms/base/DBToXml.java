package com.bureaueye.beacondms.bean.dms.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;


import com.bureaueye.beacon.bean.Constants;
import com.bureaueye.beacon.exception.ApplicationException;
import com.bureaueye.beacon.formatter.CurrencyFormatter;
import com.bureaueye.beacon.model.job.Jobmov;
import com.bureaueye.beacon.model.job.bd.JobcostBD;
import com.bureaueye.beacon.model.job.bd.JobmovBD;
import com.bureaueye.beacon.model.job.dto.JobhdrDTO;
import com.bureaueye.beacon.model.order.Orderhdr;
import com.bureaueye.beacon.model.order.Ordernote;
import com.bureaueye.beacon.model.order.Orderprod;
import com.bureaueye.beacon.model.order.bd.OrderchargeBD;
import com.bureaueye.beacon.model.order.bd.OrderhdrBD;
import com.bureaueye.beacon.model.order.bd.OrdernoteBD;
import com.bureaueye.beacon.model.order.bd.OrderprodBD;
import com.bureaueye.beacon.model.order.dto.OrdersummaryJobcostDTO;
import com.bureaueye.beacon.model.print.Companyheader;
import com.bureaueye.beacon.model.print.bd.CompanyheaderBD;
import com.bureaueye.beacon.model.purchaseinvoice.bd.PidtlcostBD;
import com.bureaueye.beacon.model.purchaseinvoice.dto.PidtlcostDTO;

import com.bureaueye.beacon.model.salesinvoice.bd.SidtlBD;
import com.bureaueye.beacon.model.salesinvoice.dto.SidtlDTO;
import com.bureaueye.beacon.model.standard.Address;
import com.bureaueye.beacon.model.standard.Company;
import com.bureaueye.beacon.model.standard.G1code;
import com.bureaueye.beacon.model.standard.G2code;
import com.bureaueye.beacon.model.standard.G3code;
import com.bureaueye.beacon.model.standard.G4code;
import com.bureaueye.beacon.model.standard.Location;
import com.bureaueye.beacon.model.standard.Product;
import com.bureaueye.beacon.model.standard.Unit;
import com.bureaueye.beacon.model.standard.Vessel;

import com.bureaueye.beacon.model.standard.User;

import com.bureaueye.beacon.model.standard.bd.AddressBD;
import com.bureaueye.beacon.model.standard.bd.CompanyBD;
import com.bureaueye.beacon.model.standard.bd.G1codeBD;
import com.bureaueye.beacon.model.standard.bd.G2codeBD;
import com.bureaueye.beacon.model.standard.bd.G3codeBD;
import com.bureaueye.beacon.model.standard.bd.G4codeBD;
import com.bureaueye.beacon.model.standard.bd.LocationBD;
import com.bureaueye.beacon.model.standard.bd.ProductBD;
import com.bureaueye.beacon.model.standard.bd.UnitBD;
import com.bureaueye.beacon.model.standard.bd.VesselBD;

import com.bureaueye.beacon.model.system.Systemcode;
import com.bureaueye.beacon.model.system.bd.SystemcodeBD;
import com.bureaueye.beacon.util.Util;
import com.bureaueye.beacondms.form.dms.GenerateXdocumentForm;





/**
 *
 * Amendments
 * ----------
 * 
 */
public class DBToXml  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;









	public static String PROP_CDATA_START = "<![CDATA[";
	public static String PROP_CDATA_END = "]]>";







	// constructors
	public DBToXml () {
		initialize();
	}

	protected void initialize () {
	}











	private String paramDetails;	
	public static String PROP_PARAMDETAILS= "ParamDetails";	
	public static String PROP_USERLOCATION= "UserLocation";		
	public static String PROP_USERLOCATIONCONTACT1= "UserLocationContact1";	
	public static String PROP_TOADDRESS= "ToAddress";
	public static String PROP_CCTOADDRESS= "CCToAddress";

	public java.lang.String getParamDetails() {	return paramDetails; }
	public void setParamDetails(
			GenerateXdocumentForm form,
			User userdao,
			Map<String, SessionFactory> sessionFactoryClusterMap
	) {

		//init bd
		CompanyBD companybd = new CompanyBD(sessionFactoryClusterMap);
		CompanyheaderBD companyheaderbd = new CompanyheaderBD(sessionFactoryClusterMap);	
		//init data objects
		Company companydao = null;
		Companyheader companyheaderdao = null;

		//convert data to xml
		if (userdao!=null) {
			/* <ToEmail>ntankard@bureaueye.es</ToEmail>**
			  <DocumentLanguage>GB</DocumentLanguage> 
			  <UserId>NPEURGR</UserId> 
			  <UserName>GORDON ROGERS</UserName> 
			  <UserFaxNo>+31 (0) 8890 88 899</UserFaxNo> 
			  <UserTelNo>+31 (0) 8890 88 881</UserTelNo> 
			  <UserJobTitle>IT Specialist</UserJobTitle>*/
			this.paramDetails= 
				"<"+PROP_PARAMDETAILS+">"+
				"<ToEmail>"+PROP_CDATA_START+form.getMailto()+PROP_CDATA_END+"</ToEmail>"+
				"<DocumentLanguage>"+PROP_CDATA_START+form.getDocumentLanguage()+PROP_CDATA_END+"</DocumentLanguage>"+
				"<UserId>"+PROP_CDATA_START+userdao.getUserid()+PROP_CDATA_END+"</UserId>"+
				"<UserName>"+PROP_CDATA_START+form.getHeadercontact()+PROP_CDATA_END+"</UserName>"+	
				"<UserFaxNo>"+PROP_CDATA_START+""+PROP_CDATA_END+"</UserFaxNo>"+	
				"<UserTelNo>"+PROP_CDATA_START+""+PROP_CDATA_END+"</UserTelNo>"+	
				"<UserJobTitle>"+PROP_CDATA_START+""+PROP_CDATA_END+"</UserJobTitle>"+
				"<ToAttn>"+PROP_CDATA_START+form.getHeadertoattn()+PROP_CDATA_END+"</ToAttn>"+
				"<CCToAttn>"+PROP_CDATA_START+form.getHeaderccattn()+PROP_CDATA_END+"</CCToAttn>"+
				"<UserEmail>"+PROP_CDATA_START+form.getMailfrom()+PROP_CDATA_END+"</UserEmail>"				
				;



			try{companydao=companybd.read(userdao.getCompanykey());}catch(ApplicationException e){}		
			if (companydao!=null) {

				try{companyheaderdao=companyheaderbd.read(new Integer(form.getCompanyheaderId()));}catch(ApplicationException e){}		
				if (companyheaderdao!=null) {

					this.paramDetails=this.paramDetails+  
					"<"+PROP_USERLOCATION+">"+
					"<addrkey>"+PROP_CDATA_START+companydao.getCompid()+PROP_CDATA_END+"</addrkey>"+
					"<name>"+PROP_CDATA_START+companyheaderdao.getCompanyName()+PROP_CDATA_END+"</name>"+
					"<addr1>"+PROP_CDATA_START+companyheaderdao.getAddress()+PROP_CDATA_END+"</addr1>"+
					"<addr2>"+PROP_CDATA_START+companyheaderdao.getCity()+PROP_CDATA_END+"</addr2>"+
					"<country>"+PROP_CDATA_START+companyheaderdao.getCountry()+PROP_CDATA_END+"</country>"					
					;						
					this.paramDetails=this.paramDetails+  
					"</"+PROP_USERLOCATION+">";		

				}
			}



			/*		- <UserLocationContact1>
		  <Addrkey>NPTUSA</Addrkey> 
		  <contType>GENERAL</contType> 
		  <prefix>Mr</prefix> 
		  <name>Jill/Kim/Pavlin</name> 
		  <email1>OPSMASTER@NEWPORTTANK.COM</email1> 
		  <telNo>001 440 356 8866</telNo> 
		  <faxNo>001 440 356 8877</faxNo> 
		  </UserLocationContact1>*/

			this.paramDetails=this.paramDetails+  
			"<"+PROP_USERLOCATIONCONTACT1+">"+
			"<telNo>"+PROP_CDATA_START+form.getHeaderphone()+PROP_CDATA_END+"</telNo>"+
			"<faxNo>"+PROP_CDATA_START+form.getHeaderfax()+PROP_CDATA_END+"</faxNo>"						
			;						
			this.paramDetails=this.paramDetails+  
			"</"+PROP_USERLOCATIONCONTACT1+">";	



			this.paramDetails=this.paramDetails+  
			"<"+PROP_TOADDRESS+">"+
			"<name>"+PROP_CDATA_START+form.getHeaderto()+PROP_CDATA_END+"</name>"+ 
			"</"+PROP_TOADDRESS+">";	

			this.paramDetails=this.paramDetails+  
			"<"+PROP_CCTOADDRESS+">"+
			"<name>"+PROP_CDATA_START+form.getHeadercc()+PROP_CDATA_END+"</name>"+ 
			"</"+PROP_CCTOADDRESS+">";			


			this.paramDetails=this.paramDetails+  
			"</"+PROP_PARAMDETAILS+">"
			;		
		}


		//clear
		companybd = null;	
		companydao = null;
		companyheaderbd = null;	
		companyheaderdao = null;

	}




	private String company;	
	public static String PROP_COMPANY= "company";	

	public java.lang.String getCompany() {	return company; }
	public void setCompany(
			String key,
			Map<String, SessionFactory> sessionFactoryClusterMap
	) {

		//init bd
		CompanyBD companybd = new CompanyBD(sessionFactoryClusterMap);
		CompanyheaderBD companyheaderbd = new CompanyheaderBD(sessionFactoryClusterMap);	
		//init data objects
		Company companydao = null;
		Companyheader companyheaderdao = null;

		try{companydao=companybd.read(key);}catch(ApplicationException e){}		
		if (companydao!=null) {

			try{companyheaderdao=companyheaderbd.read(new Integer(companydao.getCompanyheaderId()));}catch(ApplicationException e){}		
			if (companyheaderdao!=null) {

				this.company=  
					"<"+PROP_COMPANY+">"+
					"<addrkey>"+PROP_CDATA_START+companydao.getCompid()+PROP_CDATA_END+"</addrkey>"+
					"<name>"+PROP_CDATA_START+companyheaderdao.getCompanyName()+PROP_CDATA_END+"</name>"+
					"<addr1>"+PROP_CDATA_START+companyheaderdao.getAddress()+PROP_CDATA_END+"</addr1>"+
					"<addr2>"+PROP_CDATA_START+companyheaderdao.getCity()+PROP_CDATA_END+"</addr2>"+
					"<country>"+PROP_CDATA_START+companyheaderdao.getCountry()+PROP_CDATA_END+"</country>"				
					;						
				this.company=this.company+  
				"</"+PROP_COMPANY+">";		

			}
		}

		//clear
		companybd = null;	
		companydao = null;
		companyheaderbd = null;	
		companyheaderdao = null;

	}


	/*
	<actvcode>
	<actvcode>DS</actvcode>
	<name>Deep Sea Operations</name>
	<ordtype>1</ordtype>
	<non_revenue>no</non_revenue>
	<deleted>no</deleted>
	</actvcode>
	 */
	private String actvcode;	
	public static String PROP_ACTVCODE= "actvcode";

	public java.lang.String getActvcode() {	return actvcode; }
	public void setActvcode(
			String key,
			Map<String, SessionFactory> sessionFactoryClusterMap
	) {

		//init bd
		SystemcodeBD systemcodebd = new SystemcodeBD(sessionFactoryClusterMap);
		//init data objects
		Systemcode systemcodedao = null;

		try{systemcodedao=systemcodebd.findSystemcodesByTypekeyCodekey("ACTIVITY", key);}catch(ApplicationException e){}		
		if (systemcodedao!=null) {

			this.actvcode=  
				"<"+PROP_ACTVCODE+">"+
				"<actvcode>"+PROP_CDATA_START+systemcodedao.getId().getCodekey()+PROP_CDATA_END+"</actvcode>"+
				"<name>"+PROP_CDATA_START+systemcodedao.getDescr()+PROP_CDATA_END+"</name>"			
				;						
			this.actvcode=this.actvcode+  
			"</"+PROP_ACTVCODE+">";		

		}

		//clear
		systemcodebd = null;	
		systemcodedao = null;

	}



	/*
<deptcode>
<deptcode>041</deptcode>
<actvcode>DE</actvcode>
<compcode>NPTUSA</compcode>
<name>Deep Sea USA</name>
</deptcode>
	 */
	private String deptcode;	
	public static String PROP_DEPTCODE= "deptcode";

	public java.lang.String getDeptcode() {	return deptcode; }
	public void setDeptcode(
			String departmentkey,
			String companykey,
			String activitykey,
			Map<String, SessionFactory> sessionFactoryClusterMap
	) {

		//init bd
		SystemcodeBD systemcodebd = new SystemcodeBD(sessionFactoryClusterMap);	
		//init data objects
		Systemcode systemcodedao = null;

		try{systemcodedao=systemcodebd.findSystemcodesByTypekeyCodekey("DEPARTMENT", departmentkey);}catch(ApplicationException e){}		
		if (systemcodedao!=null) {

			this.deptcode=  
				"<"+PROP_DEPTCODE+">"+
				"<compcode>"+PROP_CDATA_START+companykey+PROP_CDATA_END+"</compcode>"+
				"<actvcode>"+PROP_CDATA_START+activitykey+PROP_CDATA_END+"</actvcode>"+					
				"<deptcode>"+PROP_CDATA_START+systemcodedao.getId().getCodekey()+PROP_CDATA_END+"</deptcode>"+
				"<name>"+PROP_CDATA_START+systemcodedao.getDescr()+PROP_CDATA_END+"</name>"			
				;						
			this.deptcode=this.deptcode+  
			"</"+PROP_DEPTCODE+">";		

		}

		//clear
		systemcodebd = null;	
		systemcodedao = null;

	}





	private String ordhdr;	
	public static String PROP_ORDHDR= "Ordhdr";
	public static String PROP_JOBCOST= "Jobcost";
	public static String PROP_PIDTLCOST= "Pidtlcost";	

	public java.lang.String getOrdhdr() {	return ordhdr; }
	public void setOrdhdr(
			GenerateXdocumentForm form,
			JobhdrDTO jobhdrdto,
			int count,			
			Map<String, SessionFactory> sessionFactoryClusterMap
	) throws Exception {

		//init bd
		OrderhdrBD orderhdrbd = new OrderhdrBD(sessionFactoryClusterMap);
		JobcostBD jobcostbd = new JobcostBD(sessionFactoryClusterMap);
		PidtlcostBD pidtlcostbd = new PidtlcostBD(sessionFactoryClusterMap);			
		OrderchargeBD orderchargebd = new OrderchargeBD(sessionFactoryClusterMap);
		SidtlBD sidtlbd = new SidtlBD(sessionFactoryClusterMap);


		//init data objects
		Orderhdr orderhdrdao = null;

		if (jobhdrdto!=null) 

			try{orderhdrdao=orderhdrbd.read(jobhdrdto.getOrderhdrId());}catch(ApplicationException e){}		
			if (orderhdrdao!=null) {

				String ordno = orderhdrdao.getOrderno();
				this.ordhdr=  
					"<"+PROP_ORDHDR+count+">"+
					"<ordno>"+PROP_CDATA_START+ordno+PROP_CDATA_END+"</ordno>"+
					"<movref>"+PROP_CDATA_START+jobhdrdto.getMovref()+PROP_CDATA_END+"</movref>"+					
					"<ordtype>"+PROP_CDATA_START+"1"+PROP_CDATA_END+"</ordtype>"			
					;	

				this.setActvcode(orderhdrdao.getActivitykey(), sessionFactoryClusterMap);
				this.ordhdr=this.ordhdr+
				this.getActvcode()
				;

				this.setDeptcode(
						orderhdrdao.getDepartmentkey(), 
						orderhdrdao.getCompanykey(),
						orderhdrdao.getActivitykey(), 						
						sessionFactoryClusterMap
				);
				this.ordhdr=this.ordhdr+
				this.getDeptcode()
				;			

				this.setCompany(orderhdrdao.getCompanykey(), sessionFactoryClusterMap);
				this.ordhdr=this.ordhdr+
				this.getCompany()
				;				

				this.ordhdr=this.ordhdr+
				"<quotno>"+PROP_CDATA_START+orderhdrdao.getQuotno()+PROP_CDATA_END+"</quotno>"
				;				

				this.ordhdr=this.ordhdr+
				"<odate>"+PROP_CDATA_START+Util.dateFormatDmy(orderhdrdao.getOrderdate())+PROP_CDATA_END+"</odate>"
				;

				this.ordhdr=this.ordhdr+
				"<cusref>"+PROP_CDATA_START+orderhdrdao.getCustomerref()+PROP_CDATA_END+"</cusref>"
				;
				this.ordhdr=this.ordhdr+
				"<jobno>"+PROP_CDATA_START+jobhdrdto.getMovref()+PROP_CDATA_END+"</jobno>"
				;

				//Ordlogis05//shipper&customer
				this.setAddress(orderhdrdao.getShipperaddrkey(),"ordlogis05",sessionFactoryClusterMap);
				this.ordhdr=this.ordhdr+this.getAddress();	
				//Ordlogis06//consignee
				this.setAddress(orderhdrdao.getConsigneeaddrkey(),"ordlogis06",sessionFactoryClusterMap);
				this.ordhdr=this.ordhdr+this.getAddress();	
				//Ordlogis03//fwd agent
				this.setAddress(orderhdrdao.getFwdagentaddrkey(),"ordlogis03",sessionFactoryClusterMap);
				this.ordhdr=this.ordhdr+this.getAddress();	


				//customer
				this.setAddress(orderhdrdao.getCustomeraddrkey(),"customer",sessionFactoryClusterMap);
				this.ordhdr=this.ordhdr+this.getAddress();	



				this.ordhdr=this.ordhdr+
				"<ordlogis.blno>"+PROP_CDATA_START+jobhdrdto.getMovref()+PROP_CDATA_END+"</ordlogis.blno>"
				;




				this.ordhdr=this.ordhdr+
				"<consignment_num>"+PROP_CDATA_START+orderhdrdao.getConsignmentno()+PROP_CDATA_END+"</consignment_num>"
				;


				this.setLocation(orderhdrdao.getLdglocationkey2(),"ldgaddrkey",sessionFactoryClusterMap);
				this.ordhdr=this.ordhdr+this.getLocation();	

				this.setLocation(orderhdrdao.getDchlocationkey2(),"dchaddrkey",sessionFactoryClusterMap);
				this.ordhdr=this.ordhdr+this.getLocation();	


				//selected primary movement
				this.setJobmov(form.getSelectedPrimaryMovement(),"despmovSELECTED",sessionFactoryClusterMap);
				this.ordhdr=this.ordhdr+this.getJobmov();

				//selected ship movement
				this.setJobmov(form.getSelectedShipMovement(),"despmovshipping",sessionFactoryClusterMap);
				this.ordhdr=this.ordhdr+this.getJobmov();





				this.setProduct(orderhdrdao.getProductkey(),"prodcode",sessionFactoryClusterMap);
				this.ordhdr=this.ordhdr+this.getProduct();



				/*
				<frldgdate>04/03/10</frldgdate>
				<frldgtime>0</frldgtime>
				<toldgdate>04/03/10</toldgdate>
				<toldgtime>0</toldgtime>
				<frdchdate>05/19/10</frdchdate>
				<frdchtime>0</frdchtime>
				<todchdate>05/19/10</todchdate>
				<todchtime>0</todchtime>
				 */
				this.ordhdr=this.ordhdr+
				"<frldgdate>"+PROP_CDATA_START+Util.dateFormatDmy(orderhdrdao.getLdgfromdate())+PROP_CDATA_END+"</frldgdate>"
				;				
				this.ordhdr=this.ordhdr+
				"<frldgtime>"+PROP_CDATA_START+orderhdrdao.getLdgfromtime()+PROP_CDATA_END+"</frldgtime>"
				;	
				this.ordhdr=this.ordhdr+
				"<toldgdate>"+PROP_CDATA_START+Util.dateFormatDmy(orderhdrdao.getLdgtodate())+PROP_CDATA_END+"</toldgdate>"
				;				
				this.ordhdr=this.ordhdr+
				"<toldgtime>"+PROP_CDATA_START+orderhdrdao.getLdgtotime()+PROP_CDATA_END+"</toldgtime>"
				;					
				this.ordhdr=this.ordhdr+
				"<frdchdate>"+PROP_CDATA_START+Util.dateFormatDmy(orderhdrdao.getDchfromdate())+PROP_CDATA_END+"</frdchdate>"
				;				
				this.ordhdr=this.ordhdr+
				"<frdchtime>"+PROP_CDATA_START+orderhdrdao.getDchfromtime()+PROP_CDATA_END+"</frdchtime>"
				;	
				this.ordhdr=this.ordhdr+
				"<todchdate>"+PROP_CDATA_START+Util.dateFormatDmy(orderhdrdao.getDchtodate())+PROP_CDATA_END+"</todchdate>"
				;				
				this.ordhdr=this.ordhdr+
				"<todchtime>"+PROP_CDATA_START+orderhdrdao.getDchtotime()+PROP_CDATA_END+"</todchtime>"
				;	


				this.ordhdr=this.ordhdr+
				"<cutoffdate>"+PROP_CDATA_START+orderhdrdao.getCutoffdate()+PROP_CDATA_END+"</cutoffdate>"+
				"<AMSclosedate>"+PROP_CDATA_START+orderhdrdao.getDocumentclosingdate()+PROP_CDATA_END+"</AMSclosedate>"				
				;	


				this.ordhdr=this.ordhdr+
				"<seal_number>"+
				PROP_CDATA_START+
				jobhdrdto.getSealnumber1()+" "+
				jobhdrdto.getSealnumber2()+" "+
				jobhdrdto.getSealnumber3()+		
				PROP_CDATA_END+"</seal_number>"
				;


				/*
				<delterm>
				<delterm>PP</delterm>
				<descr>Port to Port</descr>
				</delterm>
				 */
				SystemcodeBD systemcodebd = new SystemcodeBD(sessionFactoryClusterMap);
				Systemcode systemcodedao=null;			
				try {
					systemcodedao = systemcodebd.findSystemcodesByTypekeyCodekey(
							"SHIPMETHOD", 
							orderhdrdao.getShipmethod()
					);
				}catch(ApplicationException e){}		
				if (systemcodedao!=null) {	
					this.ordhdr=this.ordhdr+
					"<delterm>"+
					"<delterm>"+PROP_CDATA_START+systemcodedao.getId().getCodekey()+PROP_CDATA_END+"</delterm>"+
					"<descr>"+PROP_CDATA_START+systemcodedao.getDescr()+PROP_CDATA_END+"</descr>"+
					"</delterm>"					
					;	
				}	
				systemcodebd = null;



				this.setUnitkey(jobhdrdto.getUnitId().toString(),sessionFactoryClusterMap);
				this.ordhdr=this.ordhdr+this.getUnitkey();

				this.setUnittec(jobhdrdto.getUnitId().toString(),sessionFactoryClusterMap);
				this.ordhdr=this.ordhdr+this.getUnittec();

				//selected poduct
				this.setOrdprod(form.getSelectedPrimaryProduct(),"ordprod10",sessionFactoryClusterMap);
				this.ordhdr=this.ordhdr+this.getOrdprod();



				//"dmrgfreday",elementOrdhdr1)
				//"ccykey",elementOrdhdr1Dmrgccykey)
				//"dmrgdlyrat",elementOrdhdr1)
				this.ordhdr=this.ordhdr+
				"<dmrgfreday>"+PROP_CDATA_START+orderhdrdao.getDmrgfreedays()+PROP_CDATA_END+"</dmrgfreday>"+
				"<dmrgdlyrat>"+PROP_CDATA_START+orderhdrdao.getDmrgdlyrate3()+PROP_CDATA_END+"</dmrgdlyrat>"
				;
				this.ordhdr=this.ordhdr+
				"<dmrgccykey>"+
				"<ccykey>"+
				PROP_CDATA_START+orderhdrdao.getDmrgccykey()+PROP_CDATA_END+
				"</ccykey>"+
				"</dmrgccykey>"				
				;	

				this.ordhdr=this.ordhdr+
				"<weightactualunit>"+PROP_CDATA_START+jobhdrdto.getWeightactualunit()+PROP_CDATA_END+"</weightactualunit>"+
				"<weightactual>"+PROP_CDATA_START+jobhdrdto.getWeightactual()+PROP_CDATA_END+"</weightactual>"
				;


				//discharge notes
				this.setOrdtxt(orderhdrdao.getId().toString(),"DCHNOTE","ordtxt2",sessionFactoryClusterMap);
				this.ordhdr=this.ordhdr+this.getOrdtxt();

				//loading notes
				this.setOrdtxt(orderhdrdao.getId().toString(),"LDGNOTE","ordtxt1",sessionFactoryClusterMap);
				this.ordhdr=this.ordhdr+this.getOrdtxt();

				//special notes
				this.setOrdtxt(orderhdrdao.getId().toString(),"SPECIAL","ordtxt99",sessionFactoryClusterMap);
				this.ordhdr=this.ordhdr+this.getOrdtxt();


				//need to total all job costs for order
				BigDecimal costtotal = new BigDecimal(0.0);
				// retrieve cost total					
				try{
					costtotal = jobcostbd.jobcostsCstamtbaseTotal(jobhdrdto.getJobhdrId().toString());
				} catch (Exception e) {
				}	
				this.ordhdr=this.ordhdr+
				"<jobcostbasetotal>"+
				PROP_CDATA_START+new CurrencyFormatter().format(costtotal)+PROP_CDATA_END+
				"</jobcostbasetotal>"					
				;	


				BigDecimal chargetotal = new BigDecimal(0.00);	
				// retrieve cost total					
				try{
					chargetotal = orderchargebd.orderchargesChgamtbaseTotal(orderhdrdao.getId().toString());
				} catch (Exception e) {
				}
				this.ordhdr=this.ordhdr+
				"<orderchargebasetotal>"+
				PROP_CDATA_START+new CurrencyFormatter().format(chargetotal)+PROP_CDATA_END+
				"</orderchargebasetotal>"					
				;					



				BigDecimal profittotal = new BigDecimal(0.00);	
				// retrieve cost total					
				try{
					profittotal = chargetotal.subtract(costtotal);
				} catch (Exception e) {
				}
				this.ordhdr=this.ordhdr+
				"<profitbasetotal>"+
				PROP_CDATA_START+new CurrencyFormatter().format(profittotal)+PROP_CDATA_END+
				"</profitbasetotal>"					
				;	



				//get costs for job				
				int count2=0;
				List jobcostdaos = null;
				try{
					jobcostdaos =jobcostbd.findJobmovcostsByJobhdrIdForDisbursement(
							jobhdrdto.getJobhdrId().toString(),
							0,
							Constants.MAX_RESULTS_NOLIMIT,
							"address.Name"
					);		

					Iterator it2 = jobcostdaos.iterator();
					while (it2.hasNext()) {

						count2++;

						this.ordhdr=this.ordhdr+  
						"<"+PROP_JOBCOST+count2+">";

						OrdersummaryJobcostDTO jobcostdto = (OrdersummaryJobcostDTO) it2.next();	

						this.setAddress(jobcostdto.getVendoraddrkey().getAddrkey(),"vendor",sessionFactoryClusterMap);
						this.ordhdr=this.ordhdr+this.getAddress();	

						this.ordhdr=this.ordhdr+
						"<cstamtbase>"+
						PROP_CDATA_START+new CurrencyFormatter().format(jobcostdto.getCstamtbase())+PROP_CDATA_END+
						"</cstamtbase>"					
						;
						this.ordhdr=this.ordhdr+
						"<ccykey>"+PROP_CDATA_START+jobcostdto.getCcykey()+PROP_CDATA_END+"</ccykey>"			
						;					
						this.ordhdr=this.ordhdr+
						"<costkeydescr>"+PROP_CDATA_START+jobcostdto.getCostkey().getDescr()+PROP_CDATA_END+"</costkeydescr>"					
						;
						this.ordhdr=this.ordhdr+
						"<txt>"+PROP_CDATA_START+jobcostdto.getCostdescr()+PROP_CDATA_END+"</txt>"					
						;

						this.ordhdr=this.ordhdr+  
						"</"+PROP_JOBCOST+count2+">";	

					}//end of job costs loop

				} catch (Exception e) {
					throw new Exception("["+this.getClass().getName()+"] "+new Date()+
							" jobcosts: Exception: "+e.getMessage());						
				}


				//get purchase invoice payables for Job number
				float accountspayabletotal = 0;				
				List pidtlcostdtos = null;
				try{
					pidtlcostdtos =pidtlcostbd.findPidtlcostsByJobhdrIdForAccountspayable(
							jobhdrdto.getJobhdrId().toString(),
							0,
							Constants.MAX_RESULTS_NOLIMIT,
							"address.Name,pidtlcost.Txt1"
					);			

					int count4=0;
					Iterator it4 = pidtlcostdtos.iterator();
					while (it4.hasNext()) {	

						PidtlcostDTO pidtlcostdto = (PidtlcostDTO) it4.next();

						count4++;

						this.ordhdr=this.ordhdr+  
						"<accountspayable"+count4+">";

						//init vendor address
						this.setAddress(pidtlcostdto.getVendoraddrkey2(),"vendor",sessionFactoryClusterMap);	
						this.ordhdr=this.ordhdr+this.getAddress();

						this.ordhdr=this.ordhdr+
						"<amount>"+
						PROP_CDATA_START+new CurrencyFormatter().format(pidtlcostdto.getCstamtalloc())+PROP_CDATA_END+
						"</amount>"+
						"<txt>"+
						PROP_CDATA_START+pidtlcostdto.getTxt1()+PROP_CDATA_END+
						"</txt>"+
						"<ccykey>"+
						PROP_CDATA_START+pidtlcostdto.getCcykey()+PROP_CDATA_END+
						"</ccykey>"						
						;

						//increment cost allocation amounts
						try {accountspayabletotal=accountspayabletotal+pidtlcostdto.getCstamtalloc().floatValue();} catch (Exception e) {}	

						this.ordhdr=this.ordhdr+  
						"</accountspayable"+count4+">";


					}//end of purchase invoice loop

				} catch (Exception e) {
					throw new Exception("["+this.getClass().getName()+"] "+new Date()+
							" accountspayable: Exception: "+e.getMessage());						
				}


				//get sales invoice receivables for Job number
				float accountsreceivabletotal = 0;				
				List sidtldtos = null;
				try{
					sidtldtos =sidtlbd.findSidtlsByOrdhdrIdForAccountsreceivable(
							orderhdrdao.getId().toString(),
							0,
							Constants.MAX_RESULTS_NOLIMIT,
							"address.Name,sidtl.Txt1"
					);			


					int count5=0;
					Iterator it5 = sidtldtos.iterator();
					while (it5.hasNext()) {	

						SidtlDTO sidtldto = (SidtlDTO) it5.next();

						count5++;

						this.ordhdr=this.ordhdr+  
						"<accountsreceivable"+count5+">";

						//init customer address
						this.setAddress(sidtldto.getCustomeraddrkey2(),"customer",sessionFactoryClusterMap);	
						this.ordhdr=this.ordhdr+this.getAddress();


						this.ordhdr=this.ordhdr+
						"<amount>"+
						PROP_CDATA_START+new CurrencyFormatter().format(sidtldto.getInvoiceamt())+PROP_CDATA_END+
						"</amount>"+
						"<txt>"+
						PROP_CDATA_START+sidtldto.getTxt1()+PROP_CDATA_END+
						"</txt>"+
						"<ccykey>"+
						PROP_CDATA_START+sidtldto.getInvoiceccykey()+PROP_CDATA_END+
						"</ccykey>"						
						;

						//increment cost allocation amounts
						try {accountsreceivabletotal=accountsreceivabletotal+sidtldto.getInvoiceamt().floatValue();} catch (Exception e) {}	

						this.ordhdr=this.ordhdr+  
						"</accountsreceivable"+count5+">";

					}//end of sales invoice loop

				} catch (Exception e) {
					throw new Exception("["+this.getClass().getName()+"] "+new Date()+
							" accountsreceivable: Exception: "+e.getMessage());						
				}


				// output purchase invoice payable total					
				this.ordhdr=this.ordhdr+
				"<accountspayabletotal>"+
				PROP_CDATA_START+new CurrencyFormatter().format(new BigDecimal(accountspayabletotal))+PROP_CDATA_END+
				"</accountspayabletotal>"					
				;	


				// output sales invoice receivable total					
				this.ordhdr=this.ordhdr+
				"<accountsreceivabletotal>"+
				PROP_CDATA_START+new CurrencyFormatter().format(new BigDecimal(accountsreceivabletotal))+PROP_CDATA_END+
				"</accountsreceivabletotal>"					
				;


				float actualsbalancetotal = 0;	
				// actuals total					
				try{actualsbalancetotal = accountspayabletotal-accountsreceivabletotal;} catch (Exception e) {}
				this.ordhdr=this.ordhdr+
				"<actualsbalancetotal>"+
				PROP_CDATA_START+new CurrencyFormatter().format(new BigDecimal(actualsbalancetotal))+PROP_CDATA_END+
				"</actualsbalancetotal>"					
				;
				//balance due to customer if negative
				if (actualsbalancetotal<0) {
					this.ordhdr=this.ordhdr+
					"<balancedueto>"+
					PROP_CDATA_START+"CUSTOMER"+PROP_CDATA_END+
					"</balancedueto>"					
					;				
				}
				//balance due to company if positive
				else {
					this.ordhdr=this.ordhdr+
					"<balancedueto>"+
					PROP_CDATA_START+"COMPANY"+PROP_CDATA_END+
					"</balancedueto>"					
					;						
				}



				this.ordhdr=this.ordhdr+  
				"</"+PROP_ORDHDR+count+">";		

			}

			//clear
			jobhdrdto = null;		
			orderhdrbd = null;
			jobcostbd = null;
			pidtlcostbd = null;
			orderhdrdao = null;
			sidtlbd = null;

	}















	private String address;	

	public java.lang.String getAddress() {	return address; }
	public void setAddress(
			String key,
			String PROP_ADDRESS,			
			Map<String, SessionFactory> sessionFactoryClusterMap
	) {
		this.address="";

		//init bd
		AddressBD addressbd = new AddressBD(sessionFactoryClusterMap);
		//init data objects
		Address addressdao = null;

		try{addressdao=addressbd.read(key);}catch(ApplicationException e){}		
		if (addressdao!=null) {

			this.address=  
				"<"+PROP_ADDRESS+">"+
				"<addrkey>"+PROP_CDATA_START+addressdao.getAddrkey()+PROP_CDATA_END+"</addrkey>"+
				"<name>"+PROP_CDATA_START+addressdao.getName()+PROP_CDATA_END+"</name>"+
				"<addr1>"+PROP_CDATA_START+addressdao.getAddr1()+PROP_CDATA_END+"</addr1>"+	
				"<addr2>"+PROP_CDATA_START+addressdao.getAddr2()+PROP_CDATA_END+"</addr2>"+	
				"<addr3>"+PROP_CDATA_START+addressdao.getAddr3()+PROP_CDATA_END+"</addr3>"+	
				"<addr4>"+PROP_CDATA_START+addressdao.getAddr4()+PROP_CDATA_END+"</addr4>"+
				"<addr5>"+PROP_CDATA_START+addressdao.getCountry()+PROP_CDATA_END+"</addr5>"+
				"<addr6>"+PROP_CDATA_START+""+PROP_CDATA_END+"</addr6>"+	
				"<addr7>"+PROP_CDATA_START+""+PROP_CDATA_END+"</addr7>"+					
				"<country>"+PROP_CDATA_START+addressdao.getCountry()+PROP_CDATA_END+"</country>"+	
				"<telno>"+PROP_CDATA_START+addressdao.getTelno1()+PROP_CDATA_END+"</telno>"+
				"<faxno>"+PROP_CDATA_START+addressdao.getFaxno1()+PROP_CDATA_END+"</faxno>"+
				"<paymenttoinstructions>"+PROP_CDATA_START+addressdao.getPaymenttoinstructions()+PROP_CDATA_END+"</paymenttoinstructions>"					
				;						
			this.address=this.address+  
			"</"+PROP_ADDRESS+">";		

		}

		//clear
		addressbd = null;	
		addressdao = null;

	}




	private String vessel;	

	public java.lang.String getVessel() {	return vessel; }
	public void setVessel(
			String key,			
			Map<String, SessionFactory> sessionFactoryClusterMap
	) {
		this.vessel="";

		//init bd
		VesselBD vesselbd = new VesselBD(sessionFactoryClusterMap);
		//init data objects
		Vessel vesseldao = null;

		try{vesseldao=vesselbd.read(key);}catch(ApplicationException e){}		
		if (vesseldao!=null) {

			this.vessel=  
				"<vessel>"+
				"<vesselkey>"+PROP_CDATA_START+vesseldao.getVesselkey()+PROP_CDATA_END+"</vesselkey>"+
				"<vesselname>"+PROP_CDATA_START+vesseldao.getVesselname()+PROP_CDATA_END+"</vesselname>"+
				"<regno>"+PROP_CDATA_START+vesseldao.getRegno()+PROP_CDATA_END+"</regno>"	
				;						
			this.vessel=this.vessel+  
			"</vessel>";		

		}

		//clear
		vesselbd = null;	
		vesseldao = null;

	}





	private String unitkey;	
	String PROP_UNITKEY="unitkey";	

	public java.lang.String getUnitkey() {	return unitkey; }
	public void setUnitkey(
			String key,		
			Map<String, SessionFactory> sessionFactoryClusterMap
	) {
		this.unitkey="";

		//init bd
		UnitBD unitbd = new UnitBD(sessionFactoryClusterMap);
		//init data objects
		Unit unitdao = null;

		try{unitdao=unitbd.read(new Integer(key));}catch(ApplicationException e){}		
		if (unitdao!=null) {

			/*
			<foodgrad>no</foodgrad>
			<caplit>24121</caplit>
			<capusg>6373</capusg>
			<capimpg>5306</capimpg>
			<capcfee>852</capcfee>
			<capcm>24</capcm>
			 */
			this.unitkey=  
				"<"+PROP_UNITKEY+">"+
				"<unitkey>"+PROP_CDATA_START+unitdao.getUnitkey()+PROP_CDATA_END+"</unitkey>"+
				"<capcm>"+PROP_CDATA_START+unitdao.getCapcm()+PROP_CDATA_END+"</capcm>"+
				"<caplit>"+PROP_CDATA_START+unitdao.getCaplit()+PROP_CDATA_END+"</caplit>"+
				"<capimpg>"+PROP_CDATA_START+unitdao.getCapimpg()+PROP_CDATA_END+"</capimpg>"+
				"<capcfee>"+PROP_CDATA_START+unitdao.getCapcfee()+PROP_CDATA_END+"</capcfee>"+
				"<invsts>"+PROP_CDATA_START+unitdao.getInvsts()+PROP_CDATA_END+"</invsts>"				
				;

			try {
				this.unitkey=this.unitkey+  
				"<next_test_date>"+PROP_CDATA_START+Util.dateFormatDmy(unitdao.getNexttestdue())+PROP_CDATA_END+"</next_test_date>"
				;						
			} catch (Exception e) {				
			}

			this.unitkey=this.unitkey+  
			"</"+PROP_UNITKEY+">";	

		}

		//clear
		unitbd = null;	
		unitdao = null;

	}




	private String unittec;	
	String PROP_UNITTEC="unittec";	

	public java.lang.String getUnittec() {	return unittec; }
	public void setUnittec(
			String key,		
			Map<String, SessionFactory> sessionFactoryClusterMap
	) {
		this.unittec="";

		//init bd
		UnitBD unitbd = new UnitBD(sessionFactoryClusterMap);
		//init data objects
		Unit unitdao = null;

		try{unitdao=unitbd.read(new Integer(key));}catch(ApplicationException e){}		
		if (unitdao!=null) {

			/*
			<length>6096</length>
			<width>2438</width>
			<height>2591</height>
			<tare>3745</tare>
			<payload>32255</payload>
			<gross>36000</gross>
			 */
			this.unittec=  
				"<"+PROP_UNITTEC+">"+
				"<length>"+PROP_CDATA_START+unitdao.getLength()+PROP_CDATA_END+"</length>"+
				"<lengthf>"+PROP_CDATA_START+unitdao.getLengthf()+PROP_CDATA_END+"</lengthf>"+				
				"<width>"+PROP_CDATA_START+unitdao.getWidth()+PROP_CDATA_END+"</width>"+
				"<height>"+PROP_CDATA_START+unitdao.getHeight()+PROP_CDATA_END+"</height>"+
				"<tare>"+PROP_CDATA_START+unitdao.getTare()+PROP_CDATA_END+"</tare>"+
				"<payload>"+PROP_CDATA_START+unitdao.getPayload()+PROP_CDATA_END+"</payload>"+
				"<gross>"+PROP_CDATA_START+unitdao.getGross()+PROP_CDATA_END+"</gross>"					
				;

			try {
				this.unittec=this.unittec+  
				"<next_test_date>"+PROP_CDATA_START+Util.dateFormatDmy(unitdao.getNexttestdue())+PROP_CDATA_END+"</next_test_date>"
				;						
			} catch (Exception e) {				
			}

			this.unittec=this.unittec+  
			"</"+PROP_UNITTEC+">";	

		}

		//clear
		unitbd = null;	
		unitdao = null;

	}









	private String location;	

	public java.lang.String getLocation() {	return location; }
	public void setLocation (
			String key,
			String PROP_LOCATION,
			Map<String, SessionFactory> sessionFactoryClusterMap
	) {

		this.location="";

		//init bd
		LocationBD locationbd = new LocationBD(sessionFactoryClusterMap);
		//init data objects
		Location locationdao = null;

		try{locationdao=locationbd.read(key);}catch(ApplicationException e){}		
		if (locationdao!=null) {

			this.location=  
				"<"+PROP_LOCATION+">"+
				"<addrkey>"+PROP_CDATA_START+locationdao.getLocationkey()+PROP_CDATA_END+"</addrkey>"+
				"<name>"+PROP_CDATA_START+locationdao.getLocationName()+PROP_CDATA_END+"</name>"+
				"<addr1>"+PROP_CDATA_START+locationdao.getAddress1()+PROP_CDATA_END+"</addr1>"+	
				"<addr2>"+PROP_CDATA_START+locationdao.getAddress2()+PROP_CDATA_END+"</addr2>"+	
				"<addr3>"+PROP_CDATA_START+locationdao.getAddress3()+PROP_CDATA_END+"</addr3>"+					
				"<country>"+PROP_CDATA_START+locationdao.getCountrykey()+PROP_CDATA_END+"</country>"+	
				"<telno>"+PROP_CDATA_START+locationdao.getPhone()+PROP_CDATA_END+"</telno>"+
				"<faxno>"+PROP_CDATA_START+locationdao.getFax()+PROP_CDATA_END+"</faxno>"+
				"<UNLocation>"+PROP_CDATA_START+locationdao.getLocationcode()+PROP_CDATA_END+"</UNLocation>"	
				;	


			G1codeBD g1codebd = new G1codeBD();
			G1code g1codedao = null;			
			try {
				g1codedao = 
					g1codebd.findG1codeByG1codekey(
							locationdao.getG1codekey()
					);
			}catch(ApplicationException e){}		
			if (g1codedao!=null) {	
				this.location=this.location+ 
				"<g1codekey>"+PROP_CDATA_START+g1codedao.getG1codekey()+PROP_CDATA_END+"</g1codekey>"+
				"<g1ldesc>"+PROP_CDATA_START+g1codedao.getLdesc()+PROP_CDATA_END+"</g1ldesc>";	
			}	
			g1codebd = null;

			G2codeBD g2codebd = new G2codeBD();
			G2code g2codedao = null;			
			try {
				g2codedao = 
					g2codebd.findG2codeByG1codekeyG2codekey(
							locationdao.getG1codekey(),
							locationdao.getG2codekey()
					);
			}catch(ApplicationException e){}		
			if (g2codedao!=null) {	
				this.location=this.location+ 
				"<g2codekey>"+PROP_CDATA_START+g2codedao.getG2codekey()+PROP_CDATA_END+"</g2codekey>"+
				"<g2ldesc>"+PROP_CDATA_START+g2codedao.getLdesc()+PROP_CDATA_END+"</g2ldesc>";	
			}	
			g2codebd = null;

			G3codeBD g3codebd = new G3codeBD();
			G3code g3codedao = null;			
			try {
				g3codedao = 
					g3codebd.findG3codeByG1codekeyG2codekeyG3codekey(
							locationdao.getG1codekey(),
							locationdao.getG2codekey(),
							locationdao.getG3codekey()
					);
			}catch(ApplicationException e){}		
			if (g3codedao!=null) {	
				this.location=this.location+ 
				"<g3codekey>"+PROP_CDATA_START+g3codedao.getG3codekey()+PROP_CDATA_END+"</g3codekey>"+
				"<g3ldesc>"+PROP_CDATA_START+g3codedao.getLdesc()+PROP_CDATA_END+"</g3ldesc>";	
			}	
			g3codebd = null;

			G4codeBD g4codebd = new G4codeBD();
			G4code g4codedao = null;			
			try {
				g4codedao = 
					g4codebd.findG4codeByG1codekeyG2codekeyG3codekeyG4codekey(
							locationdao.getG1codekey(),
							locationdao.getG2codekey(),
							locationdao.getG3codekey(),
							locationdao.getG4codekey()
					);
			}catch(ApplicationException e){}		
			if (g4codedao!=null) {	
				this.location=this.location+ 
				"<g4codekey>"+PROP_CDATA_START+g4codedao.getG4codekey()+PROP_CDATA_END+"</g4codekey>"+
				"<g4ldesc>"+PROP_CDATA_START+g4codedao.getLdesc()+PROP_CDATA_END+"</g4ldesc>";	
			}	
			g4codebd = null;


			this.location=this.location+  
			"</"+PROP_LOCATION+">";		

		}

		//clear
		locationbd = null;	
		locationdao = null;

	}





	private String jobmov;	

	public java.lang.String getJobmov() {	return jobmov; }
	public void setJobmov (
			String key,
			String PROP_JOBMOV,
			Map<String, SessionFactory> sessionFactoryClusterMap
	) {

		this.jobmov="";

		//init bd
		JobmovBD jobmovbd = new JobmovBD(sessionFactoryClusterMap);
		//init data objects
		Jobmov jobmovdao = null;

		try{jobmovdao=jobmovbd.read(new Integer(key));}catch(ApplicationException e){}		
		if (jobmovdao!=null) {

			this.jobmov= "<"+PROP_JOBMOV+">";	

			G4codeBD g4codebd = new G4codeBD();
			G4code g4codedao = null;			
			try {
				g4codedao = 
					g4codebd.findG4codeByG1codekeyG2codekeyG3codekeyG4codekey(
							jobmovdao.getFromg1key(),
							jobmovdao.getFromg2key(),
							jobmovdao.getFromg3key(),
							jobmovdao.getFromg4key()
					);
			}catch(ApplicationException e){}		
			if (g4codedao!=null) {	
				this.jobmov=this.jobmov+
				"<frg4key>"+			
				"<g4codekey>"+PROP_CDATA_START+g4codedao.getG4codekey()+PROP_CDATA_END+"</g4codekey>"+
				"<g4ldesc>"+PROP_CDATA_START+g4codedao.getLdesc()+PROP_CDATA_END+"</g4ldesc>"+
				"</frg4key>";	
			}	

			g4codebd = new G4codeBD();
			g4codedao = null;			
			try {
				g4codedao = 
					g4codebd.findG4codeByG1codekeyG2codekeyG3codekeyG4codekey(
							jobmovdao.getTog1key(),
							jobmovdao.getTog2key(),
							jobmovdao.getTog3key(),
							jobmovdao.getTog4key()
					);
			}catch(ApplicationException e){}		
			if (g4codedao!=null) {	
				this.jobmov=this.jobmov+
				"<tog4key>"+			
				"<g4codekey>"+PROP_CDATA_START+g4codedao.getG4codekey()+PROP_CDATA_END+"</g4codekey>"+
				"<g4ldesc>"+PROP_CDATA_START+g4codedao.getLdesc()+PROP_CDATA_END+"</g4ldesc>"+
				"</tog4key>";	
			}	
			g4codebd = null;


			this.setLocation(jobmovdao.getFromlocationkey(),"fraddrkey",sessionFactoryClusterMap);
			this.jobmov=this.jobmov+this.getLocation();
			this.setLocation(jobmovdao.getTolocationkey(),"toaddrkey",sessionFactoryClusterMap);					
			this.jobmov=this.jobmov+this.getLocation();

			this.jobmov=this.jobmov+ 
			"<planfrdate>"+PROP_CDATA_START+Util.dateFormatDmy(jobmovdao.getEstfromdate())+PROP_CDATA_END+"</planfrdate>";

			this.jobmov=this.jobmov+ 
			"<plantodate>"+PROP_CDATA_START+Util.dateFormatDmy(jobmovdao.getEsttodate())+PROP_CDATA_END+"</plantodate>";


			this.jobmov=this.jobmov+ 
			"<Totimeinmillis>"+PROP_CDATA_START+jobmovdao.getTotimeinmillis()+PROP_CDATA_END+"</Totimeinmillis>";



			//carrier
			this.setAddress(jobmovdao.getVendoraddrkey(),"carrier",sessionFactoryClusterMap);
			this.jobmov=this.jobmov+this.getAddress();	


			this.jobmov=this.jobmov+ 
			"<vsbkref>"+PROP_CDATA_START+jobmovdao.getVsbkref()+PROP_CDATA_END+"</vsbkref>";

			this.jobmov=this.jobmov+ 
			"<voyage>"+PROP_CDATA_START+jobmovdao.getVoyage()+PROP_CDATA_END+"</voyage>"+
			"<VesselLloydsNo>"+PROP_CDATA_START+jobmovdao.getLloydsnumber()+PROP_CDATA_END+"</VesselLloydsNo>"
			;

			//vessel
			this.setVessel(jobmovdao.getVessel(),sessionFactoryClusterMap);
			this.jobmov=this.jobmov+this.getVessel();	



			this.jobmov=this.jobmov+ 
			"<movref>"+PROP_CDATA_START+jobmovdao.getMovref()+PROP_CDATA_END+"</movref>";


			this.jobmov=this.jobmov+
			"<todate>"+PROP_CDATA_START+Util.dateFormatDmy(jobmovdao.getTodate())+PROP_CDATA_END+"</todate>"+
			"<totime>"+PROP_CDATA_START+jobmovdao.getTotime()+PROP_CDATA_END+"</totime>"+			
			"<frdate>"+PROP_CDATA_START+Util.dateFormatDmy(jobmovdao.getFromdate())+PROP_CDATA_END+"</frdate>"+
			"<frtime>"+PROP_CDATA_START+jobmovdao.getFromtime()+PROP_CDATA_END+"</frtime>"
			;			



			this.jobmov=this.jobmov+
			"<sectcode>"+
			"<sectcode>"+
			PROP_CDATA_START+jobmovdao.getSectionkey()+PROP_CDATA_END+
			"</sectcode>"+
			"</sectcode>"				
			;	


			this.jobmov=this.jobmov+"</"+PROP_JOBMOV+">";		

		}

		//clear
		jobmovbd = null;	
		jobmovdao = null;

	}






	/*	
	<prodcode>
	<prodcode>PIB 24</prodcode>
	<chemname>Polyisobutene 24</chemname>
	<tradname>Pib 24</tradname>
	<unno>na</unno>
	<specgrav>.9</specgrav>
	<templow>0</templow>
	<temphi>0</temphi>
	<productkey>PIB 24</productkey>
	<botfill>no</botfill>
	<adr>na</adr>
	<rid>na</rid>
	<imo>na</imo>
	<cleangrp>N/A</cleangrp>
	<tempunit>°C</tempunit>
	<evilsmell>no</evilsmell>
	<marinepollutant>no</marinepollutant>
	<minimum_capacity>0</minimum_capacity>
	<heaterpad_flag>no</heaterpad_flag>
	<dot51_only>no</dot51_only>
	<hazardous>no</hazardous>
	<PHValue>0</PHValue>
	<ERAP>no</ERAP>
	<Amount>0</Amount>
	<EnvHazard>no</EnvHazard>
	</prodcode>	
	 */	
	private String product;	

	public java.lang.String getProduct() {	return product; }
	public void setProduct(
			String key,
			String PROP_PRODUCT,			
			Map<String, SessionFactory> sessionFactoryClusterMap
	) {
		this.product="";

		//init bd
		ProductBD productbd = new ProductBD(sessionFactoryClusterMap);
		//init data objects
		Product productdao = null;

		try{productdao=productbd.read(key);}catch(ApplicationException e){}		
		if (productdao!=null) {

			this.product=  
				"<"+PROP_PRODUCT+">"+
				"<prodcode>"+PROP_CDATA_START+productdao.getProductkey()+PROP_CDATA_END+"</prodcode>"+
				"<chemname>"+PROP_CDATA_START+productdao.getChemname()+PROP_CDATA_END+"</chemname>"+
				"<tradname>"+PROP_CDATA_START+productdao.getTradname()+PROP_CDATA_END+"</tradname>"+
				"<imdg>"+PROP_CDATA_START+productdao.getImdg()+PROP_CDATA_END+"</imdg>"+				
				"<flashp>"+PROP_CDATA_START+productdao.getFlashp()+PROP_CDATA_END+"</flashp>"+
				"<unno>"+PROP_CDATA_START+productdao.getUnno()+PROP_CDATA_END+"</unno>"+				
				"<packgrp>"+PROP_CDATA_START+productdao.getPackingGroup()+PROP_CDATA_END+"</packgrp>"+				
				"<txt>"+PROP_CDATA_START+productdao.getTxt()+PROP_CDATA_END+"</txt>"+
				"<txt2>"+PROP_CDATA_START+productdao.getTxt()+PROP_CDATA_END+"</txt2>"+
				"<Class>"+PROP_CDATA_START+productdao.getImdgsc1()+PROP_CDATA_END+"</Class>"+					
				"<marinepollutant>"+PROP_CDATA_START+"na"+PROP_CDATA_END+"</marinepollutant>"+
				"<adr>"+PROP_CDATA_START+productdao.getAdr()+PROP_CDATA_END+"</adr>"+												
				"<imo>"+PROP_CDATA_START+productdao.getImo()+PROP_CDATA_END+"</imo>"+
				"<mfag>"+PROP_CDATA_START+productdao.getMfag()+PROP_CDATA_END+"</mfag>"+	
				"<ems>"+PROP_CDATA_START+productdao.getEms1()+PROP_CDATA_END+"</ems>"+
				"<IHSCode>"+PROP_CDATA_START+productdao.getIntlharmcode()+PROP_CDATA_END+"</IHSCode>"+				
				"<ggve>"+PROP_CDATA_START+productdao.getGgve()+PROP_CDATA_END+"</ggve>"				
				;						
			this.product=this.product+  
			"</"+PROP_PRODUCT+">";		

		}

		//clear
		productbd = null;	
		productdao = null;

	}








	private String ordprod;	

	public java.lang.String getOrdprod() {	return ordprod; }
	public void setOrdprod(
			String key,
			String PROP_ORDPROD,			
			Map<String, SessionFactory> sessionFactoryClusterMap
	) {
		this.ordprod="";

		//init bd
		OrderprodBD orderprodbd = new OrderprodBD(sessionFactoryClusterMap);
		//init data objects
		Orderprod orderproddao = null;

		try{orderproddao=orderprodbd.read(new Integer(key));}catch(ApplicationException e){}		
		if (orderproddao!=null) {


			this.ordprod= 
				"<"+PROP_ORDPROD+">"+
				"<ordno>"+PROP_CDATA_START+""+PROP_CDATA_END+"</ordno>"			
				;

			this.setProduct(orderproddao.getProductkey(), "prodcode", sessionFactoryClusterMap);
			this.ordprod=this.ordprod+this.getProduct();

			/*
			<weight>19090</weight>
			<volume>21211.1</volume>
			<actweight>0</actweight>
			<actvolume>0</actvolume>
			<wghtunit>Kgs</wghtunit>
			<tempunit>°C</tempunit>
			<volunit>Litres</volunit>
			<minweight>0</minweight>
			<maxweight>0</maxweight>
			<quotvolume>23333.3</quotvolume>
			<quotweight>21000</quotweight>
			<loadvolume>0</loadvolume>
			<loadweight>0</loadweight>
			<disvolume>0</disvolume>
			<disweight>0</disweight>
			<lodwghtunit>Kgs</lodwghtunit>
			<lodvolunit>Litres</lodvolunit>
			<diswghtunit>Kgs</diswghtunit>
			<disvolunit>Litres</disvolunit>
			<Tempminload>0</Tempminload>
			<Tempmaxload>0</Tempmaxload>
			<Tempmindisch>0</Tempmindisch>
			<Tempmaxdisch>0</Tempmaxdisch>
			 */
			this.ordprod=this.ordprod+ 
			"<weight>"+PROP_CDATA_START+orderproddao.getWeight()+PROP_CDATA_END+"</weight>"+
			"<volume>"+PROP_CDATA_START+orderproddao.getVolume()+PROP_CDATA_END+"</volume>"+
			"<actvolume>"+PROP_CDATA_START+orderproddao.getVolume()+PROP_CDATA_END+"</actvolume>"+
			"<actweight>"+PROP_CDATA_START+orderproddao.getWeight()+PROP_CDATA_END+"</actweight>"+	
			"<wghtunit>"+PROP_CDATA_START+orderproddao.getWghtunit()+PROP_CDATA_END+"</wghtunit>"+	
			"<tempunit>"+PROP_CDATA_START+orderproddao.getTempunit()+PROP_CDATA_END+"</tempunit>"+
			"<volunit>"+PROP_CDATA_START+orderproddao.getVolunit()+PROP_CDATA_END+"</volunit>"+
			"<minweight>"+PROP_CDATA_START+"0"+PROP_CDATA_END+"</minweight>"+
			"<maxweight>"+PROP_CDATA_START+"0"+PROP_CDATA_END+"</maxweight>"+
			"<loadvolume>"+PROP_CDATA_START+"0"+PROP_CDATA_END+"</loadvolume>"+
			"<loadweight>"+PROP_CDATA_START+"0"+PROP_CDATA_END+"</loadweight>"+
			"<disweight>"+PROP_CDATA_START+"0"+PROP_CDATA_END+"</disweight>"+
			"<disvolume>"+PROP_CDATA_START+"0"+PROP_CDATA_END+"</disvolume>"+
			"<Tempminload>"+PROP_CDATA_START+orderproddao.getLdgtemp()+PROP_CDATA_END+"</Tempminload>"+
			"<Tempmaxload>"+PROP_CDATA_START+orderproddao.getLdgtemp()+PROP_CDATA_END+"</Tempmaxload>"+
			"<Tempmindisch>"+PROP_CDATA_START+orderproddao.getDchtemp()+PROP_CDATA_END+"</Tempmindisch>"+
			"<Tempmaxdisch>"+PROP_CDATA_START+orderproddao.getDchtemp()+PROP_CDATA_END+"</Tempmaxdisch>"					
			;			

			this.ordprod=this.ordprod+  
			"</"+PROP_ORDPROD+">";		

		}

		//clear
		orderprodbd = null;	
		orderproddao = null;

	}





	private String ordtxt;	

	public java.lang.String getOrdtxt() {	return ordtxt; }
	public void setOrdtxt(
			String key,
			String category,
			String PROP_ORDTXT,			
			Map<String, SessionFactory> sessionFactoryClusterMap
	) {
		this.ordtxt="";

		//init bd
		OrdernoteBD ordernotebd = new OrdernoteBD(sessionFactoryClusterMap);
		//init data objects
		Ordernote ordernotedao = null;

		try{ordernotedao=ordernotebd.findOrdernoteByKey1(key, category);}catch(ApplicationException e){}		
		if (ordernotedao!=null) {

			this.ordtxt=  
				"<"+PROP_ORDTXT+">"+
				"<txt>"+PROP_CDATA_START+ordernotedao.getNote1()+PROP_CDATA_END+"</txt>"+
				"<txt2>"+PROP_CDATA_START+""+PROP_CDATA_END+"</txt2>"
				;						
			this.ordtxt=this.ordtxt+  
			"</"+PROP_ORDTXT+">";		

		}

		//clear
		ordernotebd = null;	
		ordernotedao = null;

	}











	@Override
	public String toString () {
		return super.toString();
	}


}