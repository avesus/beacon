<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<!--
 *
 * Amendments
 * ----------
 * 
-->
 
<!-- start taglib -->
<%@ include file="/includes/taglibs.inc.jsp" %>
<!-- end taglib -->
  
<!-- start datapool -->
<%@ include file="/includes/datapool.inc.jsp" %>
<!-- end datapool -->
  
<!-- start scripts -->
<%@ include file="/includes/scripts.inc.jsp" %>
<!-- end scripts -->
  

<app:checkLogon/>


<html:html>


<script language="JavaScript">
	function screenRefresh() 
	{
	}
</script>


<script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>
<script language="javascript" type="text/javascript">
//<![CDATA[
	function onLoad() {	
	}
    //]]>
</script>


<script language="JavaScript">
<!--	
	function showHideSearch(div1,div2) { 
		var v,obj1,obj2;

		obj1=MM_findObj(div1);
		obj1=obj1.style; 
		v=obj1.visibility;
		if (v=='hidden') {
			obj1.visibility='visible';	
		}
		else {
			obj1.visibility='hidden'; 
		}

		obj2=MM_findObj(div2);
		obj2=obj2.style; 
		v=obj2.visibility;
		if (v=='hidden') {
			obj2.visibility='visible';	
		}
		else {
			obj2.visibility='hidden'; 
		}
	}
-->
</script>

<style>
.label1Local { font-family: Arial, Verdana, Helvetica; font-size: 13px; font-weight: bold; color: #007DDF; line-height: 100%; padding:0px 1px 1px 1px; background:#007DDF; border: solid #CECFD6 1px ;}
</style>

<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<title><bean:message key="generatemovementscosts.title"/></title>


</head>


<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td>
<span class="header2"><bean:message key="generatemovementscosts.title"/></span>
<span class="header2">&gt;</span>
<html:link action="/ListQuomov"><span class="header4"><bean:message key="quomov.title.list"/></span></html:link>
  </td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1"></td></tr>
<!-- BREADCRUMBS ----------------->
	
    
    
<!-- HEADER INFORMATION ----------------->
<tr><td> 
<div id="header" style="position:absolute; left:5px; width:600px; height:50px; z-index:10; visibility: visible; border-left:solid 1px #C6C6C6;  border-right:solid 1px #C6C6C6; border-bottom:solid 1px #C6C6C6; background-color:#FFF;">
	<table border="0" cellpadding="0" cellspacing="5" width="100%">
    
    <tr>
		<td class="label11" width="33%"><bean:message key="heading.quotno"/></td>
		<td class="label11" width="33%"><bean:message key="heading.shipmethod"/></td>           
		<td align="right" width="33%">
<a href="javascript:showHideSearch('header','header2');" >        
<img class="NavigationSprite Expand" title="Show More Information" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;"/>
</a>
		</td>   
    </tr>
    <tr>
      <td class="label10"><bean:write name="GenerateXtemplateForm" property="headerInfo[1]" scope="session"/></td>
      <td class="label10"><bean:write name="GenerateXtemplateForm" property="headerInfo[10]" scope="session"/></td>
      <td class="label10"></td>              
    </tr>

	</table>
</div>

<div id="header2" style="position:absolute; left:5px; width:600px; height:240px; z-index:10; visibility: hidden; border-left:solid 1px #C6C6C6; border-right:solid 1px #C6C6C6; border-bottom:solid 1px #C6C6C6; background-color:#FFF;">
	<table border="0" cellpadding="0" cellspacing="5" width="100%">
    
    	<tr>
      		<td class="label11" width="33%"><bean:message key="heading.quotno"/></td>
		    <td class="label11" width="33%"><bean:message key="heading.shipmethod"/></td> 
			<td align="right" width="33%">
<a href="javascript:showHideSearch('header','header2');" >        
<img class="NavigationSprite Collapse" title="Hide More Information" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;"/>
</a>
			</td>
 		</tr>        
    	<tr>
		    <td class="label10"><bean:write name="GenerateXtemplateForm" property="headerInfo[1]" scope="session"/></td>
		    <td class="label10"><bean:write name="GenerateXtemplateForm" property="headerInfo[10]" scope="session"/></td>        
		    <td class="label10"></td>      
		</tr>       
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>        
    	<tr>
      		<td class="label11" colspan="2"><bean:message key="heading.customer"/></td>
      		<td class="label11"><bean:message key="heading.quotecurrency"/></td>            
 		</tr>      
    	<tr>
		    <td class="label10" colspan="2"><bean:write name="GenerateXtemplateForm" property="headerInfo[4]" scope="session"/></td>   
		    <td class="label10"><bean:write name="GenerateXtemplateForm" property="headerInfo[9]" scope="session"/></td>                        
		</tr>           
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.product"/></td>
		    <td class="label11"><bean:message key="heading.hazard"/></td>
			<td class="label11"><bean:message key="heading.weight"/></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="GenerateXtemplateForm" property="headerInfo[11]" scope="session"/></td>
		    <td class="label10"><bean:write name="GenerateXtemplateForm" property="headerInfo[12]" scope="session"/></td>
		    <td class="label10"><bean:write name="GenerateXtemplateForm" property="headerInfo[13]" scope="session"/></td>                 
		</tr>                
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.expirydate"/></td>
		    <td class="label11"><bean:message key="heading.createdby"/></td>
			<td class="label11"><bean:message key="heading.quotedate"/></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="GenerateXtemplateForm" property="headerInfo[3]" scope="session"/></td>
		    <td class="label10"><bean:write name="GenerateXtemplateForm" property="headerInfo[5]" scope="session"/></td>
		    <td class="label10"><bean:write name="GenerateXtemplateForm" property="headerInfo[2]" scope="session"/></td>                 
		</tr>
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	<tr>
      		<td class="label11"><bean:message key="heading.loadingport"/></td>
		    <td class="label11"><bean:message key="heading.dischargeport"/></td>
			<td class="label11"></td>   
 		</tr>       
    	<tr>
		    <td class="label10"><bean:write name="GenerateXtemplateForm" property="headerInfo[7]" scope="session"/></td>
		    <td class="label10"><bean:write name="GenerateXtemplateForm" property="headerInfo[8]" scope="session"/></td>
		    <td class="label10"></td>                 
		</tr>
                 
	</table>
</div>
</td></tr> 
<!-- HEADER INFORMATION ----------------->


<tr><td><img src="images/spacer.gif" height="45"/></td></tr>
        	  	  
<tr><td>
	<div style="OVERFLOW:auto; width:1400px; height:650px; position:relative;">	

    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">

          
		<tr><td colspan="2">
            <html:messages id="error" name="APP_ERROR_KEY" header="errors.header" footer="errors.footer">
              <bean:message key="errors.prefix"/>
              <bean:write name="error"/>
              <bean:message key="errors.suffix"/>
            </html:messages>
            <html:messages id="msg" name="APP_INFORMATION_KEY" header="messages.header" footer="messages.footer">
              <bean:message key="messages.prefix"/>
              <bean:write name="msg"/>
              <bean:message key="messages.suffix"/>
            </html:messages>                
        </td></tr>

    
<html:form action="/GenerateXtemplate1">
          
    	
		
    
    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
      
				<tr><td colspan="2">	              
					<div class="btnPane3">	

<input type="hidden" name="btnSubmit" id="form-action" />                               
<html:hidden name="GenerateXtemplateForm" property="id"/>

<logic:notEmpty name="GenerateXtemplateForm" property="list1">                          
               <button class="btn btnFF" type="submit" value="GENERATE" onClick="document.getElementById('form-action').value='GENERATE'" title="Click button to generate Movements/Costs"> 
		                    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />                           
			        <span><bean:message key="button.generate"/></span>
				 </button>
                 
                <button class="btn btnFF" type="submit" value="REFRESH" onClick="document.getElementById('form-action').value='REFRESH'" title="Click Refresh button to find Vendor Tariffs using Movement and Cost parameters">
		                    <img class=" IM BZ-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />                
			        <span><bean:message key="button.refresh"/></span>
				</button>
</logic:notEmpty>
                           
				<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListQuomov.do'">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.exit"/></span>
			    </button>   

					</div>
				</td></tr>
 

    
				<tr><td>
				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
  


<!-- SECTIONS ----------------->
<logic:notEmpty name="GenerateXtemplateForm" property="list1">
                
<%int row1=0;%>			
	<logic:iterate id="stLineItem" name="GenerateXtemplateForm" property="list1">
<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>                            
<%String _class1 = "column-cell2";
//if ((row1 % 2) == 0) _class1 = "column-cell1";%>      
<%row1++;%>	 
      
<%
	       	com.bureaueye.beacon.form.quotation.SectiontemplateLineItem _stLineItem = 
	       	(com.bureaueye.beacon.form.quotation.SectiontemplateLineItem)stLineItem;
	       %>

<input type="hidden" name="stSectiontemplateId<%=_stLineItem.getRow()%>" value="<%=_stLineItem.getSectiontemplateId()%>">	
   
<tr><td colspan="3">
	<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">                                                                 
		<tr><td class="label1Local"></td></tr>
	</table>
</td></tr> 
     
<tr>                           
	<td colspan="3">     
		<table border="0" cellpadding="0" cellspacing="0" width="100%">	
                           
                            <td width="5%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                                                                        
									<tr><td class="label2">&nbsp;</td></tr>
              						<tr><td class="label1">                              
<%=_stLineItem.getSeqno()%>
                                    </td></tr>            
                                                                                
								</table>
    						</td>
                                    						
                            <td width="15%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                                                                        
									<tr><td class="label2">&nbsp;</td></tr>
              						<tr><td class="label1">                              
<%=_stLineItem.getSection().getDescr()%>
                                    </td></tr>            
                                                                                
								</table>
    						</td>

							<td width="25%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         							<tr><td class="label2"><bean:message key="prompt.fromlocation"/>:</td></tr>
              						<tr><td class="label2">
  <select name="stFromlocationkey<%=_stLineItem.getRow()%>" class="forminput1" title="select Movement From Location - used to find Vendor Tariffs">
		<option selected value=""><bean:message key="prompt.selectalocation"/></option>
<%
	String s="";
	java.util.List list = null;
	list = (java.util.List)locations;	
	if (list != null) {
      		java.util.Iterator it = list.iterator();
      		while (it.hasNext()) {
         		com.bureaueye.beacon.model.standard.dto.LocationDTO location = 
			(com.bureaueye.beacon.model.standard.dto.LocationDTO) it.next();
		s = "";
		if (location.getLocationkey().equals(_stLineItem.getFromlocationkey())) s = "Selected";
%>
		<option <%=s%> value="<%=location.getLocationkey()%>"><%=location.getShortName()%></option>
<%
	}
	}
%>			
  </select>                                    
              						</td></tr>	 
								</table>
    						</td>                                  
                                              
                            <td width="25%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">           
         							<tr><td class="label2"><bean:message key="prompt.tolocation"/>:</td></tr>
              						<tr><td class="label2">
  <select name="stTolocationkey<%=_stLineItem.getRow()%>" class="forminput1" title="select Movement To Location - used to find Vendor Tariffs">
		<option selected value=""><bean:message key="prompt.selectalocation"/></option>
<%
	s="";
	list = null;
	list = (java.util.List)locations;	
	if (list != null) {
      		java.util.Iterator it = list.iterator();
      		while (it.hasNext()) {
         		com.bureaueye.beacon.model.standard.dto.LocationDTO location = 
			(com.bureaueye.beacon.model.standard.dto.LocationDTO) it.next();
		s = "";
		if (location.getLocationkey().equals(_stLineItem.getTolocationkey())) s = "Selected";
%>
		<option <%=s%> value="<%=location.getLocationkey()%>"><%=location.getShortName()%></option>
<%
	}
	}
%>			
  </select>  
              						</td></tr>
                                                                                                                                                                         
     						</table>
					    </td>
                        
						<td width="30%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         							<tr><td class="label2"><bean:message key="prompt.vendor"/>:</td></tr>
              						<tr><td class="label2">
  <select name="stVendoraddrkey<%=_stLineItem.getRow()%>" class="forminput1" title="select Movement Vendor">
		<option selected value=""><bean:message key="prompt.selectavendor"/></option>
<%
	s="";
	list = null;
	list = (java.util.List)addresss;	
	if (list != null) {
      		java.util.Iterator it = list.iterator();
      		while (it.hasNext()) {
         		com.bureaueye.beacon.model.standard.dto.AddressDTO dto= 
			(com.bureaueye.beacon.model.standard.dto.AddressDTO) it.next();
		s = "";
		if (dto.getAddrkey().equals(_stLineItem.getVendoraddrkey())) s = "Selected";
%>
		<option <%=s%> value="<%=dto.getAddrkey()%>"><%=dto.getShortname()%></option>
<%
	}
	}
%>			
  </select> 
              						</td></tr>	 
                                              
                                                                                                                      
     						</table>
					    </td> 
		</table>
	</td>                                               						                                                     
</tr>


<!-- COSTS ----------------->
<%
	java.util.List ctlineitems =	(java.util.List)_stLineItem.getCtlineitems();
if (ctlineitems.size() > 0) {
%>  	
<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="0"/></td>  
       				<td width="100%" colspan="2">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
<td class="column-header3" width="3%">&nbsp;</td>                               
		  						<td class="column-header4" width="15%">              
                    				<span><bean:message key="heading.costcode"/></span>
								</td>

		  						<td class="column-header4" width="15%">
							         <span><bean:message key="heading.costtype"/></span>                                                           
								</td>

		  						<td class="column-header4" width="15%">
							         <span><bean:message key="heading.units"/></span>                                                           
								</td>
                                
		  						<td class="column-header4" width="15%">
							         <span><bean:message key="heading.localcurrency"/></span>                                                          
								</td>
                                                                                    
		  						<td class="column-header4" width="30%">
							         <span><bean:message key="heading.vendor"/></span>                                                          
								</td>
                       
							</tr>
            
<%
            	int row2=0;
            %>	
<%
		for (java.util.Iterator ctit = ctlineitems.iterator(); ctit.hasNext();) {	
		com.bureaueye.beacon.form.quotation.CosttemplateLineItem _ctLineItem = 
			(com.bureaueye.beacon.form.quotation.CosttemplateLineItem)ctit.next();
	%>	
<%--<tr><td colspan="6"><img src="images/spacer.gif" height="2"/></td></tr> --%>                           
<%
                           	String _class2 = "column-cell3";//light pink
                           //if ((row2 % 2) == 0) _class2 = "column-cell2";
                           %>      
<%
      	row2++;
      %>	 
      

<input type="hidden" name="ctCosttemplateId<%=_stLineItem.getRow()%>_<%=_ctLineItem.getRow()%>" value="<%=_ctLineItem.getCosttemplateId()%>">	                
<input type="hidden" name="ctTariffvarianceflag<%=_stLineItem.getRow()%>_<%=_ctLineItem.getRow()%>" value="<%=_ctLineItem.isTariffvarianceflag()%>">	           
<input type="hidden" name="ctMaxtariffvariance<%=_stLineItem.getRow()%>_<%=_ctLineItem.getRow()%>" value="<%=_ctLineItem.getMaxtariffvariance()%>">	        
<input type="hidden" name="ctMintariffvariance<%=_stLineItem.getRow()%>_<%=_ctLineItem.getRow()%>" value="<%=_ctLineItem.getMintariffvariance()%>">	    
		          
<tr>
									<td class="<%=_class2%>" align="center" nowrap>								                	
                                    </td>         
									<td class="<%=_class2%>" nowrap valign="top">
						<%=_ctLineItem.getCostkey()%>
                                    </td> 
									<td class="<%=_class2%>" nowrap valign="top">
						<%=_ctLineItem.getCosttype()%>							
                        </td>
						<td class="<%=_class2%>" nowrap>
<%
	String _disabled="disabled";
if (_ctLineItem.getCosttype().equals("UNIT") || _ctLineItem.getCosttype().equals("DISTANCE")) _disabled="";
%>                        
<input type="text" size="5" <%=_disabled%> name="ctUnits<%=_stLineItem.getRow()%>_<%=_ctLineItem.getRow()%>" value="<%=_ctLineItem.getUnits()%>" title="enter Cost Units">                        							
                        </td>                           
									<td class="<%=_class2%>" nowrap>
<select name="ctCcykey<%=_stLineItem.getRow()%>_<%=_ctLineItem.getRow()%>" class="forminput1" title="select Cost Local Currency - used to find Vendor Tariffs">
		<option selected value=""><bean:message key="prompt.selectacurrency"/></option>
<%
	s="";
	list = null;
	list = (java.util.List)ccys;	
	if (list != null) {
      		java.util.Iterator it = list.iterator();
      		while (it.hasNext()) {
         		com.bureaueye.beacon.model.standard.Ccy dto= 
			(com.bureaueye.beacon.model.standard.Ccy) it.next();
		s = "";
		if (dto.getCcykey().equals(_ctLineItem.getCcykey())) s = "Selected";
%>
		<option <%=s%> value="<%=dto.getCcykey()%>"><%=dto.getCcykey()%></option>
<%
	}
	}
%>			
  </select>
                        			</td>                                                              
									<td class="<%=_class2%>" nowrap>
<select name="ctVendoraddrkey<%=_stLineItem.getRow()%>_<%=_ctLineItem.getRow()%>" class="forminput1" title="select Cost Vendor - used to find Vendor Tariffs">
		<option selected value=""><bean:message key="prompt.selectavendor"/></option>
<%
	s="";
	list = null;
	list = (java.util.List)addresss;	
	if (list != null) {
      		java.util.Iterator it = list.iterator();
      		while (it.hasNext()) {
         		com.bureaueye.beacon.model.standard.dto.AddressDTO dto= 
			(com.bureaueye.beacon.model.standard.dto.AddressDTO) it.next();
		s = "";
		if (dto.getAddrkey().equals(_ctLineItem.getVendoraddrkey())) s = "Selected";
%>
		<option <%=s%> value="<%=dto.getAddrkey()%>"><%=dto.getShortname()%></option>
<%
	}
	}
%>			
  </select> 							
</td></tr>
 
                  
                  
<!-- VENDOR TARIFFS ----------------->
<%
	java.util.List vtlineitems =	(java.util.List)_ctLineItem.getVtlineitems();	
if (vtlineitems.size() > 0) {
%>
<tr>  
    <td width="100%" colspan="6">   
 		<table width="100%" border="0" cellspacing="0" cellpadding="0"> 	
			<tr>
				<td width="3%">&nbsp;</td>                              
				<td class="column-header3" width="3%">&nbsp;</td>                               
		  		<td class="column-header4" width="8%">              
                    				<span><bean:message key="heading.tariffcode"/></span>
				</td>
		  		<td class="column-header4" width="12%">
							         <span><bean:message key="heading.vendor"/></span>                                                           
				</td>
		  		<td class="column-header4" width="12%">
							         <span><bean:message key="heading.fromlocation"/></span>                                                           
				</td>
		  		<td class="column-header4" width="12%">
							         <span><bean:message key="heading.tslocation"/></span>                                                           
				</td>
		  		<td class="column-header4" width="12%">
							         <span><bean:message key="heading.tolocation"/></span>                                                           
				</td>
		  		<td class="column-header4" width="6%">
							         <span><bean:message key="heading.hazprod"/></span>                                                           
				</td>                                                                
		  		<td class="column-header4" width="6%">
							         <span><bean:message key="heading.currency"/></span>                                                           
				</td>                               
		  		<td class="column-header4" width="7%" align="right">
							         <span><bean:message key="heading.unitrate"/></span>                                                          
				</td>
		  		<td class="column-header4" width="8%" align="right">
							         <span><bean:message key="heading.baseccyrate"/></span>                                                          
				</td> 
		  		<td class="column-header4" width="8%" align="right">
							         <span>Avg Base Ccy Rate</span>                                                          
				</td>                                                                      
			</tr>
            
<%int row3=0;%>	
<%
		com.bureaueye.beacon.formatter.CurrencyFormatter cf =new com.bureaueye.beacon.formatter.CurrencyFormatter();
for (java.util.Iterator vtit = vtlineitems.iterator(); vtit.hasNext();) {	
		com.bureaueye.beacon.form.quotation.VendortariffLineItem _vtLineItem = 
			(com.bureaueye.beacon.form.quotation.VendortariffLineItem)vtit.next();
			
	//check variance here==============================>
	double maxavgtariffratebase=0.0;
	double minavgtariffratebase=0.0;
	java.math.BigDecimal unitrateavg=new java.math.BigDecimal(0.0);
	boolean display=true;

		if (_ctLineItem.getCosttype().equals("UNIT") || _ctLineItem.getCosttype().equals("DISTANCE")) {
			unitrateavg=_vtLineItem.getUnitrateavg();	
		} else {
			unitrateavg=_vtLineItem.getLumpsumavg();	
		}
			
//should tariff variance be checked?
	if (_ctLineItem.isTariffvarianceflag()) {
		
		if (_ctLineItem.getCosttype().equals("UNIT") || _ctLineItem.getCosttype().equals("DISTANCE")) {
			maxavgtariffratebase=_vtLineItem.getUnitrateavg().doubleValue()*_ctLineItem.getMaxtariffvariance().doubleValue()/100;
			minavgtariffratebase=_vtLineItem.getUnitrateavg().doubleValue()*_ctLineItem.getMintariffvariance().doubleValue()/100;
		}
		else {
			maxavgtariffratebase=_vtLineItem.getLumpsumavg().doubleValue()*_ctLineItem.getMaxtariffvariance().doubleValue()/100;
			minavgtariffratebase=_vtLineItem.getLumpsumavg().doubleValue()*_ctLineItem.getMintariffvariance().doubleValue()/100;				
		}
		
		if (_vtLineItem.getUnitratebase().doubleValue() < minavgtariffratebase || _vtLineItem.getUnitratebase().doubleValue() > maxavgtariffratebase) {
			display=false;
		}	
	}
	%>
<input type="hidden" name="maxavgtariffratebase<%= _vtLineItem.getRow() %>" value="<%= maxavgtariffratebase %>">	 
<input type="hidden" name="minavgtariffratebase<%= _vtLineItem.getRow() %>" value="<%= minavgtariffratebase %>">
    	
<!--<tr><td colspan="3"><img src="images/spacer.gif" height="2"/></td></tr>-->                            
<%String _class3 = "column-cell8";
//if ((row3 % 2) == 0) _class3 = "column-cell2";%>      
<%row3++;%>	 
      
<%
if (display) {
	//String vtselectedValue=_stLineItem.getSectiontemplateId()+"|"+_ctLineItem.getCosttemplateId()+"|"+_vtLineItem.getVendtarfhdrId();
%>
<input type="hidden" name="vtVendtarfhdrId<%= _vtLineItem.getRow() %>" value="<%= _vtLineItem.getVendtarfhdrId() %>">	                
		          
				<tr>
					<td align="center" nowrap></td>
					<td class="<%= _class3 %>" align="center" nowrap>
<input type="radio" name="vtSelectedObjects<%= _stLineItem.getRow() %>_<%= _ctLineItem.getRow() %>" value="<%= _vtLineItem.getId() %>" title="click radio button to select Vendor Tariff"

<%
if (_ctLineItem.getVtselectedValue().equals(_vtLineItem.getId())) {
%>
 checked="checked"
<%
}
%>
>                    
                    </td>         
					<td class="<%= _class3 %>" nowrap valign="top">
						<%= _vtLineItem.getVendtarfhdrId() %>
                    </td> 
					<td class="<%= _class3 %>" nowrap valign="top">
						<%= _vtLineItem.getVendoraddrkey().getShortname() %>							
                    </td> 
					<td class="<%= _class3 %>" nowrap valign="top">
<%                    
if (_vtLineItem.getFromlocationkey().getShortName()!=null) {					
%>
                   
						<%= _vtLineItem.getFromlocationkey().getShortName() %>		
<%
}
%>
                    </td> 
					<td class="<%= _class3 %>" nowrap valign="top">
<%                    
if (_vtLineItem.getTslocationkey().getShortName()!=null) {					
%>
                   
						<%= _vtLineItem.getTslocationkey().getShortName() %>		
<%
}
%>                    							
                    </td> 
					<td class="<%= _class3 %>" nowrap valign="top">
<%                    
if (_vtLineItem.getTolocationkey().getShortName()!=null) {					
%>
                   
						<%= _vtLineItem.getTolocationkey().getShortName() %>		
<%
}
%>                        							
                    </td> 
					<td class="<%= _class3 %>" nowrap valign="top">
						<%= _vtLineItem.getProducthazardous() %>							
                    </td>                                                                                                        
					<td class="<%= _class3 %>" nowrap valign="top">
						<%= _vtLineItem.getCcykey() %>	
                    </td>                                                              
					<td class="<%= _class3 %>" nowrap valign="top" align="right">
						<%= cf.format(_vtLineItem.getUnitrate()) %> 							
                    </td>
					<td class="<%= _class3 %>" nowrap valign="top" align="right">
						<%= cf.format(_vtLineItem.getUnitratebase()) %> 							
                    </td>    
					<td class="<%= _class3 %>" nowrap valign="top" align="right">
							<%= cf.format(unitrateavg) %> 					
                    </td>                                        
				</tr>
                                                          
<%	
}//display check
%>

<%	
}//logic:iterate
%>

</table></td></tr>
<%
}//logic:notEmpty
%>
<!-- VENDOR TARIFFS ----------------->      

                                                          
<%	
}//logic:iterate
%> 

</table></td></tr>                
<%	
}//logic:notEmpty
%>
<!-- COSTS ----------------->      

                            
                                                           
	</logic:iterate>

<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
                             
<tr><td colspan="3">
	<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">                                                                 
		<tr><td class="label1Local"></td></tr>
	</table>
</td></tr>

</logic:notEmpty>                  
<!-- SECTIONS ----------------->            
                            
 
 


  
  
  
  
 
                                       
                                          
							<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>  


					</table>
				</td></tr>
                    
			</html:form>
      
		</table>

</div>
</td></tr>

<tr><td><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

</table>

</body>
</html:html>
