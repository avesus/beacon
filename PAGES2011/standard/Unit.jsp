<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

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
<head>
<logic:equal name="UnitForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="UnitForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="UnitForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<link rel="stylesheet" type="text/css" href="css/base.css" />

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
		<strong><bean:message key="unit.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListUnit" styleClass="link4">
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
	
		<div style="OVERFLOW:auto; width:650px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:errors/>

<html:form action="/SaveUnit" focus="unitkey">
<html:hidden property="action"/>
<html:hidden property="unitId"/>
<html:hidden property="readonly"/>
<html:hidden property="thleak"/>
<html:hidden property="tmdmax"/>
<html:hidden property="rvalvac"/>
<html:hidden property="ssurarap"/>
<html:hidden property="ssurara"/>
<html:hidden property="teucount"/>
<html:hidden property="tranfro"/>
<html:hidden property="stackno"/>
<html:hidden property="tranto"/>
<html:hidden property="stackw"/>
<html:hidden property="shdepms"/>
<html:hidden property="shdepss"/>
<html:hidden property="mfprice"/>
<html:hidden property="rvalprs"/>
<html:hidden property="allocnumber"/>
<html:hidden property="capcm"/>
<html:hidden property="rvalvacp"/>
<html:hidden property="maxtrips"/>
<html:hidden property="movelocationkey"/>
<html:hidden property="moveaddrkey"/>
<html:hidden property="moveproductkey"/>
<html:hidden property="jobmovlocationkey"/>
<html:hidden property="movests"/>
<html:hidden property="invsts"/>
<html:hidden property="movedatedd"/>
<html:hidden property="movedatemm"/>
<html:hidden property="movedateyyyy"/>
<html:hidden property="jobmovdatedd"/>
<html:hidden property="jobmovdatemm"/>
<html:hidden property="jobmovdateyyyy"/>
<html:hidden property="moveref"/>
<html:hidden property="jobmovref"/>
<html:hidden property="jobmovvessel"/>	
		
		
<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
  <tr>
    <td>
<table width="100%" border="0" cellspacing="2" cellpadding="2" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7"><strong>
<logic:equal name="UnitForm" property="action"
            scope="request" value="Create">
<bean:message key="title.create"/>
</logic:equal>
<logic:equal name="UnitForm" property="action"
            scope="request" value="Delete">
  <bean:message key="title.delete"/>
  </logic:equal>
<logic:equal name="UnitForm" property="action"
            scope="request" value="Edit">
 	<bean:message key="title.edit"/>
 </logic:equal>		  
		  </strong></td>
        </tr>
    </table></td>
  </tr>
  
  
        <logic:equal name="UnitForm" property="action"
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
		        <bean:message key="prompt.unitnumber"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
        <strong><html:hidden property="unitkey" write="true"/></strong>
          </td>
        </tr>
	</table>
	</td>
	</tr>
	</logic:equal>		
	
  
        <logic:notEqual name="UnitForm" property="action"
                     scope="request" value="Delete"> 
					 
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
			<td rowspan="8">
		  		<img src="images/spacer.gif" width="1" border="0"/>		  	</td>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.unitnumber"/>:		  </div>		  </td>
          <td width="78%" class="td2">
        <html:text property="unitkey" size="20" maxlength="20" styleClass="ftforminputsmall"/>          </td>
        </tr>
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.manufacturedate"/>:		  </div>		  </td>
          <td width="78%" class="td2">
		<html:select property="mfdatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="mfdatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="mfdateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>          </td>
        </tr>		
        <tr>
          <td width="22%" class="td2"> 
		  <div align="right">
		        <bean:message key="prompt.manufacturenumber"/>:		  </div>		  </td>
          <td width="78%" class="td2">
        <html:text property="mfnum" size="20" maxlength="20" styleClass="ftforminputsmall"/>          </td>
        </tr>
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.manufacturerlocation"/>:		  </div>		  </td>
          <td width="78%" class="td2">
<html:select property="manuflocationkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>
		</html:select>          </td>
        </tr>
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.owner"/>:		  </div>		  </td>
          <td width="78%" class="td2">
<html:select property="ownerkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaowner"/></html:option>
			<html:options collection="owners" property="addrkey" labelProperty="longLabel"/>
		</html:select>          </td>
        </tr>				
        <tr>
          <td class="td2"><div align="right"><bean:message key="prompt.imo"/>: </div></td>
          <td class="td2"><html:text property="imokey" size="20" maxlength="20" styleClass="ftforminputsmall"/></td>
        </tr>
        <tr>
          <td class="td2"><div align="right"><bean:message key="prompt.inactive"/>:</div></td>
          <td class="td2"><html:checkbox property="xinactive" /></td>
          </tr>	
        <tr>
          <td class="td2"><div align="right"><bean:message key="prompt.foodgrade"/>:</div></td>
          <td class="td2"><html:checkbox property="foodgrad" /></td>
          </tr>			  			
    </table></td>
  </tr>
  


<tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td2" width="100%">
		        &nbsp;<strong><bean:message key="prompt.equipmentparameters"/></strong>
		  </td>
		</tr>		
              <tr> 
                <td class="td2" width="100%"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
              <TR> 
                <TD class="td2">&nbsp;</TD>
                <TD class="td2">
		<html:select property="eqpkeyp1" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp1s" property="id.codekey" labelProperty="descr"/>
		</html:select>				 
				</TD>
                <TD class="td2"></TD>
                <TD class="td2">&nbsp;</TD>
              </TR>
              <TR> 
                <TD class="td2" width="20%" align="right"></TD>
                <TD class="td2" width="20%">
		<html:select property="eqpkeyp2" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp2s" property="id.codekey" labelProperty="descr"/>
		</html:select>
						</TD>
                <TD class="td2" width="20%">
				</TD>
                <TD class="td2" width="20%">&nbsp;</TD>
              </TR>
              <TR> 
                <TD class="td2" width="20%" align="right"></TD>
                <TD class="td2" width="20%">
		<html:select property="eqpkeyp3" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp3s" property="id.codekey" labelProperty="descr"/>
		</html:select>
						</TD>
                <TD class="td2" width="20%">
				</TD>
                <TD class="td2" width="20%">&nbsp;</TD>
              </TR>
              <TR> 
                <TD class="td2" width="20%" align="right"></TD>
                <TD class="td2" width="20%">
		<html:select property="eqpkeyp4" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp4s" property="id.codekey" labelProperty="descr"/>
		</html:select>
						</TD>
                <TD class="td2" width="20%">
				</TD>
                <TD class="td2" width="20%">&nbsp;</TD>
              </TR>
              <TR> 
                <TD class="td2" width="20%" align="right"></TD>
                <TD class="td2" width="20%">
		<html:select property="eqpkeyp5" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp5s" property="id.codekey" labelProperty="descr"/>
		</html:select>
						</TD>
                <TD class="td2" width="20%">
				</TD>
                <TD class="td2" width="20%">&nbsp;</TD>
              </TR>			  			  			  
            </table>
			</td>
              </tr>
    </table></td>
  </tr>
    
      <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td2" width="100%">
		        &nbsp;<strong><bean:message key="prompt.dimensions"/></strong>
		  </td>
		</tr>		
              <tr> 
                <td class="td2" width="100%"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
              <TR> 
                <TD class="td2">&nbsp;</TD>
                <TD class="td2"><strong><bean:message key="prompt.mm"/></strong></TD>
                <TD class="td2"><strong><bean:message key="prompt.ftin"/></strong></TD>
                <TD class="td2">&nbsp;</TD>
              </TR>
              <TR> 
                <TD class="td2" width="20%" align="right"><bean:message key="prompt.length"/>:</TD>
                <TD class="td2" width="20%">
				 <html:text property="length" size="10" maxlength="10" styleClass="ftforminputsmall"/>
				</TD>
                <TD class="td2" width="20%">
								 <html:text property="lengthf" size="10" maxlength="10" styleClass="ftforminputsmall"/>&nbsp;'&nbsp;
								 <html:text property="lengthi" size="10" maxlength="10" styleClass="ftforminputsmall"/>&nbsp;"
				</TD>
                <TD class="td2" width="20%">&nbsp;</TD>
              </TR>
              <tr> 
                <td class="td2" align="right"><bean:message key="prompt.width"/>:</td>
                <TD class="td2">
				 <html:text property="width" size="10" maxlength="10" styleClass="ftforminputsmall"/>
				</TD>
                <TD class="td2">
								 <html:text property="widthf" size="10" maxlength="10" styleClass="ftforminputsmall"/>&nbsp;'&nbsp;
								 <html:text property="widthi" size="10" maxlength="10" styleClass="ftforminputsmall"/>&nbsp;"
				</TD>
                <td class="td2">&nbsp;</td>
              </tr>
              <TR> 
                <TD class="td2" align="right"><bean:message key="prompt.height"/>:</TD>
                <TD class="td2">
				 <html:text property="height" size="10" maxlength="10" styleClass="ftforminputsmall"/>
				</TD>
                <TD class="td2">
								 <html:text property="heightf" size="10" maxlength="10" styleClass="ftforminputsmall"/>&nbsp;'&nbsp;
								 <html:text property="heighti" size="10" maxlength="10" styleClass="ftforminputsmall"/>&nbsp;"
				</TD>
                <TD class="td2">&nbsp;
                  </TD>
              </TR>
            </table>
			</td>
              </tr>
    </table></td>
  </tr>
  
    
	      <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td2" width="100%">
		        &nbsp;<strong><bean:message key="prompt.capacity"/></strong>
		  </td>
		</tr>		
              <tr> 
                <td class="td2" width="100%"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
              <TR> 
                <TD class="td2">&nbsp;</TD>
                <TD class="td2"><B><bean:message key="prompt.liters"/></B></TD>
                <TD class="td2"><B><bean:message key="prompt.gallons"/></B></TD>
                <TD class="td2"><B><bean:message key="prompt.usgallons"/></B></TD>

              </TR>
              <TR> 
                <TD class="td2" width="20%">&nbsp;</TD>
                <TD class="td2" width="20%">
					<html:text property="caplit" size="10" maxlength="10" styleClass="ftforminputsmall"/>
				</TD>
                <TD class="td2" width="20%">
				 	<html:text property="capimpg" size="10" maxlength="10" styleClass="ftforminputsmall"/>
				</TD>
                <TD class="td2" width="20%">
					<html:text property="capusg" size="10" maxlength="10" styleClass="ftforminputsmall"/>
				</TD>

              </TR>
            </table>
			</td>
              </tr>
    </table></td>
  </tr>
  
  
  	      <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td2" width="100%">
		        &nbsp;<strong><bean:message key="prompt.materials"/></strong>
		  </td>
		</tr>
		              <tr> 
                <td class="td2" width="100%"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff"> 		
              <TR> 
                <TD class="td2" width="20%" align="right"><bean:message key="prompt.shell"/>:</TD>
                <TD class="td2" width="20%">
				 <html:text property="matrils" size="15" maxlength="20" styleClass="ftforminputsmall"/>
				</TD>
                <TD class="td2" width="20%">&nbsp;</TD>
                <TD class="td2" width="20%">&nbsp;</TD>
              </TR>
              <TR> 
                <TD class="td2" width="20%" align="right"><bean:message key="prompt.head"/>:</TD>
                <TD class="td2" width="20%">
				 <html:text property="headmat" size="15" maxlength="20" styleClass="ftforminputsmall"/>
				</TD>
                <TD class="td2" width="20%">&nbsp;</TD>
                <TD class="td2" width="20%">&nbsp;</TD>
              </TR>
              <TR> 
                <TD class="td2" width="20%" align="right"><bean:message key="prompt.shelldomethickness"/>:</TD>
                <TD class="td2" width="30%">
				 <html:text property="shthick" size="10" maxlength="10" styleClass="ftforminputsmall"/>&nbsp; / 
				 <html:text property="dmthick" size="10" maxlength="10" styleClass="ftforminputsmall"/>&nbsp;<bean:message key="prompt.mm"/>
				</TD>
                <TD class="td2" width="10%">&nbsp;</TD>
                <TD class="td2" width="20%">&nbsp;</TD>
              </TR>			  			  
            </table>
			</td>
              </tr>
    </table></td>
  </tr>
  
  
    	      <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td2" width="100%">
		        &nbsp;<strong><bean:message key="prompt.pressures"/></strong>
		  </td>
		</tr>
		              <tr> 
                <td class="td2" width="100%"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff"> 		
              <TR> 
                <TD class="td2" width="20%" align="right"><bean:message key="prompt.tankwork"/>:</TD>
                <TD class="td2" width="40%" colpsan="2">
				 <html:text property="tkwork" size="10" maxlength="10" styleClass="ftforminputsmall"/>&nbsp;<bean:message key="prompt.bar"/>&nbsp;
				 <html:text property="tkworkp" size="10" maxlength="10" styleClass="ftforminputsmall"/>&nbsp;<bean:message key="prompt.psi"/>
				</TD>
                <TD class="td2" width="20%">&nbsp;</TD>
              </TR>
              <TR> 
                <TD class="td2" width="20%" align="right"><bean:message key="prompt.tanktest"/>:</TD>
                <TD class="td2" width="40%" colpsan="2">
				 <html:text property="tktest" size="10" maxlength="10" styleClass="ftforminputsmall"/>&nbsp;<bean:message key="prompt.bar"/>&nbsp;
				 <html:text property="tktestp" size="10" maxlength="10" styleClass="ftforminputsmall"/>&nbsp;<bean:message key="prompt.psi"/>
				</TD>
                <TD class="td2" width="20%">&nbsp;</TD>
              </TR>		  			  
            </table>
			</td>
              </tr>
    </table></td>
  </tr>
  
  
      	      <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td2" width="100%">
		        &nbsp;<strong><bean:message key="prompt.temperatures"/></strong>
		  </td>
		</tr>
		              <tr> 
                <td class="td2" width="100%"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff"> 		
              <TR> 
                <TD class="td2" width="20%" align="right"><bean:message key="prompt.design"/>:</TD>
                <TD class="td2" width="80%" colpsan="3">
				 <html:text property="tdesmin" size="10" maxlength="10" styleClass="ftforminputsmall"/>&nbsp;-&nbsp;
				 <html:text property="tdesmax" size="10" maxlength="10" styleClass="ftforminputsmall"/>&nbsp;<bean:message key="prompt.celcius"/>&nbsp;
				 <html:text property="tdesminf" size="10" maxlength="10" styleClass="ftforminputsmall"/>&nbsp;-&nbsp;
				 <html:text property="tdesmaxf" size="10" maxlength="10" styleClass="ftforminputsmall"/>&nbsp;<bean:message key="prompt.fahrenheit"/>				 
				</TD>
              </TR>
              <TR> 
                <TD class="td2" width="20%" align="right"><bean:message key="prompt.maximumcargo"/>:</TD>
                <TD class="td2" width="80%" colpsan="3">
				 <html:text property="tmaxcar" size="10" maxlength="10" styleClass="ftforminputsmall"/>&nbsp;<bean:message key="prompt.celcius"/>&nbsp;
				 <html:text property="tmaxcarf" size="10" maxlength="10" styleClass="ftforminputsmall"/>&nbsp;<bean:message key="prompt.fahrenheit"/>
				</TD>
              </TR>		  			  
            </table>
			</td>
              </tr>
    </table></td>
  </tr>
  
  
      <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td2" width="100%"><strong><bean:message key="prompt.weights"/></strong>
		  </td>
		</tr>		
              <tr> 
                <td class="td2" width="100%"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
              <TR> 
                <TD class="td2">&nbsp;</TD>
                <TD class="td2"><strong><bean:message key="prompt.kgs"/></strong></TD>
                <TD class="td2"><strong><bean:message key="prompt.lbs"/></strong></TD>
                <TD class="td2">&nbsp;</TD>
              </TR>
              <TR> 
                <TD class="td2" width="20%" align="right"><bean:message key="prompt.tare"/>:</TD>
                <TD class="td2" width="20%">
				 <html:text property="tare" size="10" maxlength="10" styleClass="ftforminputsmall"/>
				</TD>
                <TD class="td2" width="20%">
								 <html:text property="tarel" size="10" maxlength="10" styleClass="ftforminputsmall"/>
				</TD>
                <TD class="td2" width="20%">&nbsp;</TD>
              </TR>
              <tr> 
                <td class="td2" align="right"><bean:message key="prompt.maximumpayload"/>:</td>
                <td class="td2">
												 <html:text property="payload" size="10" maxlength="10" styleClass="ftforminputsmall"/>
				</td>
                <td class="td2">
												 <html:text property="payloadl" size="10" maxlength="10" styleClass="ftforminputsmall"/>
				</td>
                <td class="td2">&nbsp;</td>
              </tr>
              <TR> 
                <TD class="td2" align="right"><bean:message key="prompt.gross"/>: 
                  
                  </TD>
                <TD class="td2">
												 <html:text property="gross" size="10" maxlength="10" styleClass="ftforminputsmall"/>
				</TD>
                <TD class="td2">
												 <html:text property="grossl" size="10" maxlength="10" styleClass="ftforminputsmall"/>
				</TD>
                <TD class="td2">&nbsp;
                  </TD>
              </TR>
            </table>
			</td>
              </tr>
    </table></td>
  </tr>
  
  
    <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td2" width="100%">
		        &nbsp;<strong><bean:message key="prompt.approvals"/></strong>
		  </td>
		</tr>		
              <tr> 
                <td class="td2" width="100%"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
                    <tr> 
                      <td class="td2">  
<html:checkbox property="aar" />&nbsp;
                         <bean:message key="prompt.aar"/> </td>
                      <td class="td2">  
<html:checkbox property="asme" />&nbsp;
                        <bean:message key="prompt.asme"/></td>
                      <td class="td2"> 
<html:checkbox property="csc" />&nbsp;
                        <bean:message key="prompt.csc"/></td>
                    </tr>
                    <tr> 
                      <td class="td2"> 
<html:checkbox property="usdot" />&nbsp;
                        <bean:message key="prompt.usdot"/> </td>
                      <td class="td2"> 
<html:checkbox property="ukdot" />&nbsp;
                        <bean:message key="prompt.ukdot"/></td>
                      <td class="td2"> 
<html:checkbox property="adr" />&nbsp;
                        <bean:message key="prompt.adr"/></td>
                    </tr>
                    <tr> 
                      <td class="td2">  
<html:checkbox property="rid" />&nbsp;
                        <bean:message key="prompt.rid"/> </td>
                      <td class="td2">
<html:checkbox property="ctc" />&nbsp;
                        <bean:message key="prompt.ctc"/></td>
                      <td class="td2">
<html:checkbox property="imo" />&nbsp;
                        <bean:message key="prompt.imo"/></td>
                    </tr>
                    <tr> 
                      <td class="td2"> 
<html:checkbox property="uic" />&nbsp;
                        <bean:message key="prompt.uic"/> </td>
                      <td class="td2"> 
<html:checkbox property="bam" />&nbsp;
                        <bean:message key="prompt.bam"/></td>
                      <td class="td2"> 
<html:checkbox property="dot51" />&nbsp;
                        <bean:message key="prompt.dot51"/></td>
                    </tr>
                    <tr> 
                      <td class="td2"> 
<html:checkbox property="dir" />&nbsp;
                        <bean:message key="prompt.dir"/> </td>
                      <td class="td2">
<html:checkbox property="att" />&nbsp;
                        <bean:message key="prompt.att"/> </td>
                      <td class="td2"> 
<html:checkbox property="tir" />&nbsp;
                        <bean:message key="prompt.tir"/> </td>
                    </tr>
                    <tr> 
                     <td class="td2">
<html:checkbox property="un" />&nbsp;
                        <bean:message key="prompt.un"/> </td>
						                     <td class="td2">&nbsp;

                        </td>
						                     <td class="td2">&nbsp;

                        </td>
                    </tr>
                  </table>
                </TD>
              </TR>
    </table></td>
  </tr>
 

  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="5">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td2" width="100%" colspan="2">
		        &nbsp;<strong>Latest Movement</strong>
		  </td>
		</tr>		
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.movementlocation"/>:		  </div>		  </td>
          <td width="78%" class="td2">
<html:select property="movelocationkey" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>
		</html:select>          </td>
        </tr>		
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.movementstatus"/>:		  </div>		  </td>
          <td width="78%" class="td2">      
		<html:select property="movests" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectastatus"/></html:option>
			<html:options collection="movestatuss" property="id.codekey" labelProperty="descr"/>
		</html:select>		   
	   </td>
        </tr>		
        <tr>
          <td class="td2">		  <div align="right">
		        <bean:message key="prompt.movementref"/>:		  </div></td>
          <td class="td2"><html:text property="moveref" disabled="true" size="20" maxlength="20" styleClass="ftforminputsmall"/></td>
        </tr>		
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.movementdate"/>:		  </div>		  </td>
          <td width="78%" class="td2">
		<html:select property="movedatedd" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="movedatemm" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="movedateyyyy" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select> 
		&nbsp;<html:text property="movetime" disabled="true" size="5" maxlength="5" styleClass="ftforminputsmall"/>          
		</td>
        </tr>						
    </table></td>
  </tr>


  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="6">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td2" width="100%" colspan="2">
		        &nbsp;<strong>Operator Latest Movement</strong>
		  </td>
		</tr>	
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.movementlocation"/>:		  </div>		  </td>
          <td width="78%" class="td2">
<html:select property="jobmovlocationkey" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>
		</html:select>          </td>
        </tr>
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.inventorystatus"/>:		  </div>		  </td>
          <td width="78%" class="td2">      
		<html:select property="invsts" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectastatus"/></html:option>
			<html:options collection="statuscodes" property="id.codekey" labelProperty="descr"/>
		</html:select>		   
	   </td>
        </tr>				
        <tr>
          <td class="td2">		  <div align="right">
		        <bean:message key="prompt.movementref"/>:		  </div></td>
          <td class="td2"><html:text property="jobmovref" disabled="true" size="20" maxlength="20" styleClass="ftforminputsmall"/></td>
        </tr>
        <tr>
          <td class="td2">		  <div align="right">
		        <bean:message key="prompt.movementvessel"/>:		  </div></td>
          <td class="td2"><html:text property="jobmovvessel" disabled="true" size="20" maxlength="20" styleClass="ftforminputsmall"/></td>
        </tr>		
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.movementdate"/>:		  </div>		  </td>
          <td width="78%" class="td2">
		<html:select property="jobmovdatedd" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="jobmovdatemm" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="jobmovdateyyyy" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select> 
		&nbsp;<html:text property="jobmovtime" disabled="true" size="5" maxlength="5" styleClass="ftforminputsmall"/>          
		</td>
        </tr>						
    </table></td>
  </tr>
  
  
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td2" width="100%">
		        &nbsp;<strong><bean:message key="prompt.testcertificates"/></strong>
		  </td>
		</tr>
		<tr> 
            <td class="td2" width="100%"> 
<table width="100%" border="0" align="center" cellpadding="1" cellspacing="1">



</table>
			</td>
		</tr>
    </table></td>
  </tr>
  

  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>
          <td class="td2" width="100%">
		        &nbsp;<strong><bean:message key="prompt.calibrationcharts"/></strong>
		  </td>
		</tr>
		<tr> 
            <td class="td2" width="100%"> 
<table width="100%" border="0" align="center" cellpadding="1" cellspacing="1">



</table>
			</td>
		</tr>
    </table></td>
  </tr>
    
  
  	</logic:notEqual>
	
  
  
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>
          <td class="td1">
      <logic:equal name="UnitForm" property="action"
                  scope="request" value="Create">
        <html:submit styleClass="button1">
          <bean:message key="button.add"/>
        </html:submit>
      </logic:equal>		  
      <logic:equal name="UnitForm" property="action"
                  scope="request" value="Delete">
        <html:submit styleClass="button1">
          <bean:message key="button.confirm"/>
        </html:submit>
      </logic:equal>
      <logic:equal name="UnitForm" property="action"
                  scope="request" value="Edit">
        <html:submit styleClass="button1">
          <bean:message key="button.save"/>
        </html:submit>
      </logic:equal>
      <logic:notEqual name="UnitForm" property="action"
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
