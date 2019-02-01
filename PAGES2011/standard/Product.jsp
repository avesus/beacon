<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 *
 * NT	2010-04-20		201000020		Make Product Maintenance compatible with ITT Tank Traker system 
 *										(new fields changed to text fields not lists as the collections are not available for ITT)
 * 												
--%>
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


<jsp:useBean
  id="ProductForm"
  class="com.bureaueye.beacon.form.standard.ProductForm"
  scope="request"
/>


<html:html>
<head>
<logic:equal name="ProductForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="ProductForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="ProductForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<link rel="stylesheet" type="text/css" href="css/base.css" />


<script type="text/javascript" language="javascript"> 
		var ie4adj = 0;
		var isMac  = false;
		window.onload = onLoadFunctions;
		document.onload = onLoadFunctions; 
		function onLoadFunctions() {		
		}
</script>
    





    
</head>





<body> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>
	

<!-- BREADCRUMBS -----------------> 
<tr>
<%--      <td height="20" bgcolor="#CCCCCC">&nbsp;</td>--%>  
	<td class="tdwht"><span class="heading2">     
		<strong><bean:message key="heading.product"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListProduct" styleClass="link4">
				<bean:message key="title.list"/> 	
			</html:link>
		</span>		
		<span class="text6">&gt;</span>
			<span class="text6"><strong>
				<bean:message key="title.maintenance"/> 	
			</strong></span> 						
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
<tr>
<%--	<td bgcolor="#CCCCCC" width="121" valign="top" align="center">
<jsp:include page="/pages/sidebarWelcome.jsp" flush="true" />
	</td>--%>
	
	<td>
	
		<div style="OVERFLOW:auto; width:950px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:errors/>

<html:form action="/SaveProduct" focus="chemname">
<html:hidden property="action"/>
<html:hidden property="readonly"/>
<html:hidden property="hazardous"/>

<!--s201000020-->
<html:hidden property="dotRegulated"/>
<html:hidden property="hazardousImo"/>
<html:hidden property="productclass"/>
<html:hidden property="industryClass"/>
<html:hidden property="supplieraddrkey"/>
<html:hidden property="viscosity"/>
<html:hidden property="emergency1"/>
<html:hidden property="emergency2"/>
<html:hidden property="emergency3"/>
<html:hidden property="email"/>
<html:hidden property="instructions"/>
<html:hidden property="active"/>
<!--e201000020-->

	
		
<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
  <tr>
    <td>
<table width="100%" border="0" cellspacing="2" cellpadding="2" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">
  <tr>
    <td colspan="2"><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7"><strong>
<logic:equal name="ProductForm" property="action"
            scope="request" value="Create">
  <bean:message key="title.create"/>
</logic:equal>
<logic:equal name="ProductForm" property="action"
            scope="request" value="Delete">
  <bean:message key="title.delete"/>
  </logic:equal>
<logic:equal name="ProductForm" property="action"
            scope="request" value="Edit">
 	<bean:message key="title.edit"/> 
 </logic:equal>		  
		  </strong></td>
        </tr>
    </table></td>
  </tr>
  
  
        <logic:equal name="ProductForm" property="action"
                     scope="request" value="Delete">  
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">  				
        <tr>
			<td>
		  		<img src="images/spacer.gif" width="1" border="0"/>
		  	</td>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.product"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
        <strong><html:hidden property="productkey" write="true"/></strong>
          </td>
        </tr>
	</table>
	</td>
	</tr>
	</logic:equal>		
	
  
        <logic:notEqual name="ProductForm" property="action"
                     scope="request" value="Delete"> 
                     

<tr>
    <td width="60%">
    <table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
			<td rowspan="4">
		  		<img src="images/spacer.gif" width="1" border="0"/>
		  	</td>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.product"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
		          <logic:equal name="ProductForm" property="action"
                     scope="request" value="Create"> 
        <html:text property="productkey" size="15" maxlength="10" styleClass="ftforminputsmall"/>
					</logic:equal>
			<logic:equal name="ProductForm" property="action"
                     scope="request" value="Edit"> 
        		&nbsp;<strong><html:hidden property="productkey" write="true"/></strong>
			</logic:equal>
          </td>
        </tr>	
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.chemname"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
        <html:text property="chemname" size="40" maxlength="40" styleClass="ftforminputsmall"/>
          </td>
        </tr>
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.tradname"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
        <html:text property="tradname" size="40" maxlength="40" styleClass="ftforminputsmall"/>
          </td>
        </tr>
        <tr>
          <td width="22%" class="td2" valign="top">
		  <div align="right">
		       <bean:message key="prompt.description"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
           		<html:textarea rows="2" cols="60"  property="ldesc" styleClass="ftforminputsmall"/>        
          </td>
        </tr>						
    </table>
    </td>  
    <td width="40%">
    <table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
			<td rowspan="3">
		  		<img src="images/spacer.gif" width="1" height="103" border="0"/>
		  	</td>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.fleetgroup"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
<%--		<html:select property="fleetgrpkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectafleetgroup"/></html:option>
			<html:options collection="productfleetgroups" property="id.codekey" labelProperty="descr"/>	
		</html:select>--%>	
<html:text property="fleetgrpkey" size="15" maxlength="10" styleClass="ftforminputsmall"/>         		
          </td>
        </tr>	
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.color"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
<%--		<html:select property="colourkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacolor"/></html:option>
			<html:options collection="productcolors" property="id.codekey" labelProperty="descr"/>	
		</html:select>--%>
<html:text property="colourkey" size="15" maxlength="10" styleClass="ftforminputsmall"/>          
          </td>
        </tr>
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.category"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
<%--		<html:select property="prodcatgkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacategory"/></html:option>
			<html:options collection="productfleetgroups" property="id.codekey" labelProperty="descr"/>	
		</html:select>--%>
<html:text property="prodcatgkey" size="15" maxlength="10" styleClass="ftforminputsmall"/>        
          </td>
        </tr>					
    </table></td>
  </tr>



<tr>

            <td width="60%">
				<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
              <tr>
                <td rowspan="6"><img src="images/spacer.gif" width="1" border="0"/> </td>
                <td class="td2" colspan="4">&nbsp;<strong><bean:message key="prompt.temperatures"/></strong> 
&nbsp;
		<html:select property="tempunit" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.units"/></html:option>
			<html:options collection="tempunits" property="id.codekey" labelProperty="descr"/>	
		</html:select>				</td>
              </tr>				
                    <TR>
                      <TD class="td2" width="22%" align="right"><bean:message key="prompt.mintemp"/>:</TD>
                      <TD class="td2" width="22%"><html:text property="mintemp" size="15" maxlength="10" styleClass="ftforminputsmall"/></TD>
                      <TD class="td2" width="20%"><div align="right"><bean:message key="prompt.maxtemp"/>: </div></TD>
                      <TD class="td2" width="36%"><html:text property="maxtemp" size="15" maxlength="10" styleClass="ftforminputsmall"/></TD>
                    </TR>
                    <TR>
                      <TD class="td2" align="right"><bean:message key="prompt.meltingpoint"/>: </TD>
                      <TD class="td2"><html:text property="meltp" size="15" maxlength="10" styleClass="ftforminputsmall"/></TD>
                      <TD class="td2"><div align="right"><bean:message key="prompt.boilingpoint"/>: </div></TD>
                      <TD class="td2"><html:text property="boilp" size="15" maxlength="10" styleClass="ftforminputsmall"/></TD>
                    </TR>
                    <TR>
                      <TD class="td2" align="right"><bean:message key="prompt.fillingtemp"/>: </TD>
                      <TD class="td2"><html:text property="fillt" size="15" maxlength="10" styleClass="ftforminputsmall"/></TD>
                      <TD class="td2"><div align="right"><bean:message key="prompt.dischargetemp"/>: </div></TD>
                      <TD class="td2"><html:text property="dischgt" size="15" maxlength="10" styleClass="ftforminputsmall"/></TD>
                    </TR>
                    <TR>
                      <TD class="td2" width="22%" align="right"><bean:message key="prompt.flashpoint"/>:</TD>
                      <TD width="22%" class="td2"><html:text property="flashp" size="15" maxlength="10" styleClass="ftforminputsmall"/></TD>
                       <TD class="td2" width="22%" align="right"><bean:message key="prompt.maxcontacttemp"/>:</TD>
                      <TD width="22%" class="td2"><html:text property="maxcontacttemp" size="15" maxlength="10" styleClass="ftforminputsmall"/></TD>
                      </TR>
                    <TR>
                      <TD class="td2" width="22%" align="right"><bean:message key="prompt.gaskets"/>:</TD>
                      <TD width="22%" class="td2" colspan="3"><html:text property="gaskets" size="40" maxlength="40" styleClass="ftforminputsmall"/></TD>
                      </TR>                      
                     
            </table>
            </td>

            <td width="40%">
				<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
              <tr>
                <td rowspan="5"><img src="images/spacer.gif" width="1" height="144" border="0"/> </td>
    	<td class="td2" align="left" colspan="2">
    		<html:checkbox property="evilsmelling" />&nbsp;<bean:message key="prompt.evilsmelling"/>
		</td>
        </tr>
        <tr>
		<td class="td2" align="left" colspan="2">
		<html:checkbox property="bottomfill" />&nbsp;<bean:message key="prompt.bottomfill"/>
		</td>
        </tr>
        <tr>
		<td class="td2" align="left" colspan="2">
		<html:checkbox property="heaterpad" />&nbsp;<bean:message key="prompt.heaterpad"/>
		</td>
        </tr>        
        <tr>
        <td class="td2" width="40%"><div align="right"><bean:message key="prompt.specificgravity"/>: </div></td>
        <td class="td2" width="60%">
        <html:text property="specgrav" size="15" maxlength="10" styleClass="ftforminputsmall"/>		</td>        
        </tr>
       <tr>
        <td class="td2"><div align="right"><bean:message key="prompt.minimumcapacity"/>: </div></td>
        <td class="td2">
        <html:text property="minimumCapacity" size="15" maxlength="10" styleClass="ftforminputsmall"/>		</td>        
        </tr>                              
            </table>
            </td>
</tr>


  
<tr>
    <td colspan="2">
    <table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
      <tr>
              <tr>
                <td rowspan="13"><img src="images/spacer.gif" width="1" border="0"/> </td>
                <td class="td2" colspan="6">&nbsp;<strong><bean:message key="prompt.classification"/></strong>       
</td>
</tr>
<tr>
        <td class="td2"><div align="right"> <bean:message key="prompt.imdgcode"/>: </div></td>
        <td class="td2">
<%--		<html:select property="imdg" styleClass="ftforminputsmall">
			<html:option value=""> <bean:message key="prompt.selectacode"/></html:option>
			<html:options collection="imdgs" property="imdgkey" labelProperty="description"/>	
		</html:select>--%>
<html:text property="imdg" size="15" maxlength="10" styleClass="ftforminputsmall"/>        
        </td>
        <td colspan="4">
        <table width="100%"  border="0" cellpadding="0" cellspacing="0">
        <td class="td2"><div align="right"><bean:message key="prompt.subclass1"/>: </div></td>
        <td class="td2">
<html:text property="imdgsc1" size="15" maxlength="50" styleClass="ftforminputsmall"/>
        </td>
        <td class="td2"><div align="right"><bean:message key="prompt.subclass2"/>: </div></td>
        <td class="td2">
<html:text property="imdgsc2" size="15" maxlength="50" styleClass="ftforminputsmall"/>
        </td>
        <td class="td2"><div align="right"><bean:message key="prompt.label"/>: </div></td>
        <td class="td2"><html:text property="imdglabel" size="15" maxlength="10" styleClass="ftforminputsmall"/>		</td>        
        </table>
        </td>
      </tr>
<tr>
        <td class="td2"><div align="right"> <bean:message key="prompt.unnumber"/>: </div></td>
        <td class="td2"><html:text property="unno" size="15" maxlength="4" styleClass="ftforminputsmall"/>		</td>
        <td  class="td2"><div align="right"><bean:message key="prompt.icaocode"/>: </div></td>
        <td class="td2"><html:text property="icao" size="15" maxlength="10" styleClass="ftforminputsmall"/>		</td>
        
<td rowspan="11"  class="td2">
        <table width="100%"  border="0" cellpadding="0" cellspacing="0">

<tr><td  class="td2">
        <table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
          <tr>
            <td class="td2"><div align="right"></div></td>
            <td class="td2"><strong><bean:message key="prompt.code"/></strong></td>
            <td class="td2"><strong><bean:message key="prompt.reference"/></strong></td>
          </tr>
          <tr>
            <td class="td2"><div align="right"> <bean:message key="prompt.ggve"/>: </div></td>
            <td class="td2"><html:text property="ggve" size="15" maxlength="10" styleClass="ftforminputsmall"/>            </td>
            <td class="td2"><html:text property="ggveref" size="15" maxlength="10" styleClass="ftforminputsmall"/></td>
          </tr>
          <tr>
            <td class="td2"><div align="right"><bean:message key="prompt.ggvs"/>: </div></td>
            <td class="td2"><html:text property="ggvsclass" size="15" maxlength="10" styleClass="ftforminputsmall"/>            </td>
            <td class="td2"><html:text property="ggvsref" size="15" maxlength="10" styleClass="ftforminputsmall"/></td>
          </tr>
          <tr>
            <td class="td2"><div align="right"><bean:message key="prompt.adr"/>: </div></td>
            <td class="td2"><html:text property="adr" size="15" maxlength="10" styleClass="ftforminputsmall"/>            </td>
            <td class="td2"><html:text property="adrref" size="15" maxlength="10" styleClass="ftforminputsmall"/></td>
          </tr>
          <tr>
            <td class="td2"><div align="right"><bean:message key="prompt.rid"/>:</div></td>
            <td class="td2"><html:text property="rid" size="15" maxlength="10" styleClass="ftforminputsmall"/>            </td>
            <td class="td2"><html:text property="ridref" size="15" maxlength="10" styleClass="ftforminputsmall"/></td>
          </tr>
                 
        </table>
</td></tr>

<tr><td><img src="images/spacer.gif" width="1" height="1" border="0"/></td></tr>

<tr><td  class="td2">
        <table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">  
 		<td class="td2" align="left" colspan="3">
		<html:checkbox property="dot51only" />&nbsp;<bean:message key="prompt.dot51only"/>
		</td>
        </tr>
          <tr>
            <td class="td2"><div align="right"><bean:message key="prompt.nacode"/>:</div></td>
            <td class="td2" colspan="2">
            <html:text property="nacode1" size="15" maxlength="10" styleClass="ftforminputsmall"/>&nbsp;
            <html:text property="nacode2" size="15" maxlength="10" styleClass="ftforminputsmall"/>
            </td>
          </tr>          
          </table>
</td></tr>

</table>               
                  
</td>

      </tr>
      
      
      
      <tr>
        <td class="td2"><div align="right"> <bean:message key="prompt.untcode"/>: </div></td>
        <td class="td2">
        <html:text property="untcode" size="15" maxlength="4" styleClass="ftforminputsmall"/>		</td>
        <td class="td2"><div align="right"><bean:message key="prompt.iataclass"/>: </div></td>
        <td class="td2">
        <html:text property="iataclass" size="15" maxlength="10" styleClass="ftforminputsmall"/>		</td>


      </tr>
      <tr>
        <td class="td2"><div align="right"><bean:message key="prompt.imocode"/>: </div></td>
        <td class="td2">
        <html:text property="imo" size="15" maxlength="10" styleClass="ftforminputsmall"/>		</td>
        <td class="td2"><div align="right"><bean:message key="prompt.ems"/>:</div></td>
        <td class="td2">
        <html:text property="ems1" size="2" maxlength="1" styleClass="ftforminputsmall"/>&nbsp;
        <html:text property="ems2" size="2" maxlength="1" styleClass="ftforminputsmall"/>&nbsp;
        <html:text property="ems3" size="2" maxlength="1" styleClass="ftforminputsmall"/>&nbsp;
        <html:text property="ems4" size="2" maxlength="1" styleClass="ftforminputsmall"/>
        </td>
      </tr>
      <tr>
        <td class="td2"><div align="right"><bean:message key="prompt.kemmelercode"/>: </div></td>
        <td class="td2">
        <html:text property="kemmler" size="15" maxlength="10" styleClass="ftforminputsmall"/>		</td>
        <td class="td2"><div align="right"><bean:message key="prompt.mfag"/>:</div></td>
        <td class="td2">
        <html:text property="mfag" size="15" maxlength="10" styleClass="ftforminputsmall"/>		</td>
      </tr>
      
      <tr>
        <td class="td2"><div align="right"><bean:message key="prompt.hommel"/>:</div></td>
        <td class="td2"><html:text property="hommel" size="15" maxlength="10" styleClass="ftforminputsmall"/>		</td>
                <td class="td2"><div align="right"><bean:message key="prompt.hazid"/>: </div></td>
        <td class="td2"><html:text property="hazid" size="15" maxlength="10" styleClass="ftforminputsmall"/>		</td>    
  
      </tr>
      <tr>
        <td class="td2"><div align="right"><bean:message key="prompt.harmonisedcode"/>: </div></td>
        <td class="td2">
        <html:text property="harmcode" size="15" maxlength="10" styleClass="ftforminputsmall"/>		</td>
                 <td class="td2"><div align="right"><bean:message key="prompt.prdid"/>: </div></td>
        <td class="td2"><html:text property="prdid" size="15" maxlength="10" styleClass="ftforminputsmall"/>		</td>   
 
        </tr>
      <tr>
        <td class="td2"><div align="right"><bean:message key="prompt.tramcard"/>: </div></td>
        <td class="td2"><html:text property="tramcard" size="15" maxlength="10" styleClass="ftforminputsmall"/>	</td>
       <td class="td2"><div align="right"><bean:message key="prompt.cleaninggroup"/>: </div></td>
        <td class="td2"><html:text property="cleangrp" size="15" maxlength="10" styleClass="ftforminputsmall"/>		</td>    
        </tr>
        


        <tr>
        <td class="td2"><div align="right"><bean:message key="prompt.casnumber"/>: </div></td>
        <td class="td2"><html:text property="casnumber" size="15" maxlength="10" styleClass="ftforminputsmall"/>		</td>   
         <td class="td2"><div align="right"><bean:message key="prompt.packinggroup"/>: </div></td>
        <td class="td2"><html:text property="packingGroup" size="15" maxlength="10" styleClass="ftforminputsmall"/>		</td>    
        </tr>
 
        <tr>
        <td class="td2"><div align="right"><bean:message key="prompt.reachcode"/>: </div></td>
        <td class="td2"><html:text property="reachcode" size="15" maxlength="10" styleClass="ftforminputsmall"/>		</td>
         <td class="td2"><div align="right"><bean:message key="prompt.intlhscode"/>: </div></td>
        <td class="td2"><html:text property="intlharmcode" size="15" maxlength="10" styleClass="ftforminputsmall"/>		</td>
        </tr>

        <tr>
        <td class="td2" colspan="2">
<%--        <html:checkbox property="marinepollutant" />&nbsp;<bean:message key="prompt.marinepollutant"/>--%>
        </td> 
               <td class="td2"><div align="right"><bean:message key="prompt.opcl"/>: </div></td>
        <td class="td2"><html:text property="opcl" size="15" maxlength="10" styleClass="ftforminputsmall"/>		</td>    

        </tr>
    	
        <tr>
        <td class="td2" colspan="2">&nbsp;</td>   
                <td class="td2"><div align="right"><bean:message key="prompt.opcu"/>: </div></td>
        <td class="td2"><html:text property="opcu" size="15" maxlength="10" styleClass="ftforminputsmall"/>		</td>       

        </tr>        	        
                       
    </table>
    </td>
  </tr>
  



<!--DGS-->
<tr>
            <td colspan="2">
				<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
              <tr>
                <td rowspan="6"><img src="images/spacer.gif" width="1" border="0"/> </td>
<td class="td2" colspan="4">&nbsp;<strong><bean:message key="prompt.dangerousgoods"/></strong>&nbsp;<html:checkbox property="dgsflag" />				
</td>
              </tr>				
                    <TR>
                      <TD class="td2" width="22%" align="right" valign="top"><bean:message key="prompt.additionalinformation"/>:</TD>
                      <TD class="td2">
           		<html:textarea rows="2" cols="100"  property="dgsnotes" styleClass="ftforminputsmall"/>                      
                      </TD>
                    </TR>
                    <TR>
                      <TD class="td2" align="right"><bean:message key="prompt.technicalname"/>: </TD>
                      <TD class="td2"><html:text property="dgstechnicalname" size="100" maxlength="250" styleClass="ftforminputsmall"/></TD>
                    </TR>
                    <TR>
                      <TD class="td2" align="right"><bean:message key="prompt.hazardinformation"/>: </TD>
                      <TD class="td2"><html:text property="dgsinformation" size="100" maxlength="250" styleClass="ftforminputsmall"/></TD>
                    </TR>
                    <TR>
                      <TD class="td2" align="right"><bean:message key="prompt.contact"/>:</TD>
                      <TD class="td2">
        <table width="70%"  border="0" cellpadding="0" cellspacing="0">
        <td class="td2"><div align="right"><bean:message key="prompt.name"/>: </div></td>
        <td class="td2">
<html:text property="dgscontact1" size="30" maxlength="50" styleClass="ftforminputsmall"/>
        </td>
        <td class="td2"><div align="right"><bean:message key="prompt.phone"/>: </div></td>
        <td class="td2">
<html:text property="dgsphone1" size="30" maxlength="50" styleClass="ftforminputsmall"/> 	
        </td>     
        </table>                      
                      </TD>
                      </TR>                   
                     
            </table>
            </td>
           
</tr>


  
  
  	      <tr>
            <td colspan="2"><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
              <tr>
                <td width="0%"><img src="images/spacer.gif" width="1" border="0"/> </td>
                <td width="22%" class="td2" valign="top"><div align="right"><bean:message key="prompt.specialtext"/></div></td>
                <td width="78%" class="td2">
           		<html:textarea rows="3" cols="80"  property="txt" styleClass="ftforminputsmall"/>
                </td>
              </tr>
              
            </table></td>
  	      </tr>
  
 
  	</logic:notEqual>
	
  
  
  <tr>
    <td colspan="2"><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td1">
      <logic:equal name="ProductForm" property="action"
                  scope="request" value="Create">
        <html:submit styleClass="button1">
          <bean:message key="button.add"/>
        </html:submit>
      </logic:equal>		  
      <logic:equal name="ProductForm" property="action"
                  scope="request" value="Delete">
        <html:submit styleClass="button1">
          <bean:message key="button.confirm"/>
        </html:submit>
      </logic:equal>
      <logic:equal name="ProductForm" property="action"
                  scope="request" value="Edit">
        <html:submit styleClass="button1">
          <bean:message key="button.save"/>
        </html:submit>
      </logic:equal>
      <logic:notEqual name="ProductForm" property="action"
                     scope="request" value="Delete">
        <html:reset styleClass="button1">
          <bean:message key="button.reset"/>
        </html:reset>
      </logic:notEqual>
      <html:cancel styleClass="button1">
        <bean:message key="button.cancel"/>
      </html:cancel>
    </td>
  </tr>		  
    </table></td>
  </tr>
</table>

</td></tr></table>
</td></tr></table>
</html:form>

</td>
</tr>
</table>

</div>
</td>
</tr>



<tr>
	<td colspan="2">
<jsp:include page="/pages/footer.jsp" flush="true" />
	</td>
</tr>

</table>

</body>
</html:html>
