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


<SCRIPT LANGUAGE="JavaScript">
<!-- 	
// by Nannette Thacker
// http://www.shiningstar.net
// This script checks and unchecks boxes on a form
// Checks and unchecks unlimited number in the group...
// Pass the Checkbox group name...
// call buttons as so:
// <input type=button name="CheckAll"   value="Check All"
	//onClick="checkAll(document.myform.list)">
// <input type=button name="UnCheckAll" value="Uncheck All"
	//onClick="uncheckAll(document.myform.list)">
// -->

<!-- Begin
function checkAll(field)
{
for (i = 0; i < field.length; i++)
	field[i].checked = true ;
}

function uncheckAll(field)
{
for (i = 0; i < field.length; i++)
	field[i].checked = false ;
}
//  End -->
</script>



<logic:equal name="JobmovForm" property="action"
            scope="request" value="Edit">
  <title>View Job Movement Section</title>
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
		<strong>Job Movement Section</strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListTimetrack" styleClass="link4">
				Time Tracking	
			</html:link>
		</span>								
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
	
		<div style="OVERFLOW:auto; width:1200px; height:650px; position:relative;">	


<html:errors/>

<html:form action="/SaveJobmov" focus="sectionkey.sectionkey">
<html:hidden property="action"/>
<html:hidden property="readonly"/>
<html:hidden property="jobmovId"/>
<html:hidden property="jobhdrId"/>
<html:hidden property="unitId"/>
<html:hidden property="actfromtimeinmillis"/>
<html:hidden property="acttotimeinmillis"/>
<html:hidden property="invsts"/>
<html:hidden property="movsts"/>
		
<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>



<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">

<html:messages property="informationMessage" message="true" id="message" header="messages.header" footer="messages.footer">
<tr><td><span class="text2">-&nbsp;<bean:write name="message"/></span></td></tr>
</html:messages>

  <tr>
    <td>
<table width="100%" border="0" cellspacing="2" cellpadding="2" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">

  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7"><strong>
<logic:equal name="JobmovForm" property="action"
            scope="request" value="Edit">
   View Job Movement Section
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>
	

<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	    
        <td width="20%" class="td2"><div align="right"> Section: </div></td>
        <td width="80%" class="td2">
		<html:select property="sectionkey.sectionkey" disabled="true" styleClass="ftforminputsmall">
			<html:option value="">- select a Section -</html:option> 
			<html:options collection="sections" property="sectionkey" labelProperty="descr"/> 
		</html:select>  
		</td>			
      </tr>
      <tr>
        <td rowspan="1"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	    
        <td width="20%" class="td2"><div align="right">Movement Status: </div></td>
        <td width="80%" class="td2">
<bean:write name="JobmovForm" property="sectionkey.statcode" scope="request"/>
		</td>			
      </tr>	  
    </table></td>
</tr>	

<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="2"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  
          <td width="20%" class="td2">
		  <div align="right">
		  From Location:
		  </div>
		  </td>
          <td width="80%" class="td2">
		<html:select property="fromlocationkey.locationkey" disabled="true" styleClass="ftforminputsmall">
			<html:option value="">- select a Location -</html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>		  
          </td>	  		
      </tr>
      <tr>	  
          <td width="20%" class="td2">
		  <div align="right">
		  To Location:
		  </div>
		  </td>
          <td width="80%" class="td2">
		<html:select property="tolocationkey.locationkey" disabled="true" styleClass="ftforminputsmall">
			<html:option value="">- select a Location -</html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>	    
          </td>	  		
      </tr>	  
    </table></td>
</tr>	
	
<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
      <tr>
        <td rowspan="2"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>	  
          <td width="20%" class="td2">
		  <div align="right">
		  Vendor:
		  </div>
		  </td>
          <td width="80%" class="td2" colspan="3">
		<html:select property="vendoraddrkey.addrkey" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectavendor"/></html:option>
			<html:options collection="vendors" property="addrkey" labelProperty="name"/>	
		</html:select>			  
          </td>	  		
      </tr>
      <tr>	  
          <td width="20%" class="td2">
		  <div align="right">
		  Movement Reference:
		  </div>
		  </td>
          <td width="30%" class="td2">
<html:text property="movref" size="20" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>			  			  
          </td>	 
          <td width="20%" class="td2">
		  <div align="right">
		  Vessel:
		  </div>
		  </td>
          <td width="30%" class="td2">
		<html:select property="vessel" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectavessel"/></html:option>
			<html:options collection="vessels" property="vesselkey" labelProperty="vesselname"/>	
		</html:select>			  
          </td>		   		
      </tr>
	  
    </table></td>
</tr>	
  
  
    	
  <tr>
	    <td width="100%" valign="top" colspan="2">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
		
			
        <tr>
		        <td rowspan="2"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
				
          <td class="td2"><div align="right">Estimate Date/Time:</div></td>
          <td class="td2">
		  <table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#999999">
            <tr>
              <td width="5%" class="td2"><div align="right">From:</div></td>
              <td width="45%" class="td2">
		<html:select property="estfromdatedd" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="estfromdatemm" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="estfromdateyyyy" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
		/
		<html:select property="estfromtimehh" disabled="true" styleClass="ftforminputsmall">
			<html:option value="00">HH</html:option>				
			<html:options collection="hours" property="value" labelProperty="label"/>	
		</html:select>:		  
		<html:select property="estfromtimemm" disabled="true" styleClass="ftforminputsmall">
			<html:option value="00">MM</html:option>				
			<html:options collection="minutes" property="value" labelProperty="label"/>	
		</html:select>			  
			  </td>
              <td width="5%" class="td2"><div align="right">To:</div></td>
              <td width="45%" class="td2">
		<html:select property="esttodatedd" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="esttodatemm" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="esttodateyyyy" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
		/
		<html:select property="esttotimehh" disabled="true" styleClass="ftforminputsmall">
			<html:option value="00">HH</html:option>				
			<html:options collection="hours" property="value" labelProperty="label"/>	
		</html:select>:		  
		<html:select property="esttotimemm" disabled="true" styleClass="ftforminputsmall">
			<html:option value="00">MM</html:option>				
			<html:options collection="minutes" property="value" labelProperty="label"/>	
		</html:select>				  
			  </td>
            </tr>
          </table>		  
		  </td>
        </tr>
		
		
        <tr>
          <td class="td2"><div align="right">Actual Date/Time:</div></td>
          <td class="td2">
		  <table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#999999">
            <tr>
              <td width="5%" class="td2"><div align="right">From:</div></td>
              <td width="45%" class="td2">
		<html:select property="actfromdatedd" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="actfromdatemm" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="actfromdateyyyy" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
		/
		<html:select property="actfromtimehh" disabled="true" styleClass="ftforminputsmall">
			<html:option value="00">HH</html:option>				
			<html:options collection="hours" property="value" labelProperty="label"/>	
		</html:select>:		  
		<html:select property="actfromtimemm" disabled="true" styleClass="ftforminputsmall">
			<html:option value="00">MM</html:option>				
			<html:options collection="minutes" property="value" labelProperty="label"/>	
		</html:select>			  
			  </td>
              <td width="5%" class="td2"><div align="right">To:</div></td>
              <td width="45%" class="td2">
		<html:select property="acttodatedd" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="acttodatemm" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="acttodateyyyy" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
		/
		<html:select property="acttotimehh" disabled="true" styleClass="ftforminputsmall">
			<html:option value="00">HH</html:option>				
			<html:options collection="hours" property="value" labelProperty="label"/>	
		</html:select>:		  
		<html:select property="acttotimemm" disabled="true" styleClass="ftforminputsmall">
			<html:option value="00">MM</html:option>				
			<html:options collection="minutes" property="value" labelProperty="label"/>	
		</html:select>				  
			  </td>
            </tr>
          </table>		  
		  </td>
        </tr>


				  													
    </table>
	</td>
  </tr>		

		  


  
</table>

</td></tr>


</table>

</td></tr>

</table>



</td>
</tr>


<logic:notEmpty name="JobmovForm" property="list">
      <logic:equal name="JobmovForm" property="action"
                  scope="request" value="Edit">

<tr><td>
<table width="20%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">

  <tr>
    <td>
<table width="100%" border="0" cellspacing="2" cellpadding="2" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">

  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1">
		  
  <tr>
    <td>
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7">
		  <table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#ffffff">
		  <tr>
		  <td width="5%" class="td7"> 
		<img src="images/black_arrow_right.gif" border="0" name="multipleArrow"/>
		</td>
		<td width="95%" class="td7">
		  <strong>
		<html:link href="javascript:void(onClickMultiple())">
		&nbsp;Multiple Unit Movement Update
		</html:link>		  
		  </strong>
		  </td>
		  </tr>
		  </table>
		  </td>
        </tr>
    </table>
	</td>
  </tr>
  
</table>
</td></tr>
</table>
</td></tr>
</table>
</td></tr>
</table>
</td></tr>	


  <tr>
    <td>				
<div 	id="multipleLayer" 
		style="position:absolute; width:1178px; height:200px; z-index:2; left: 10px; top: 328px; overflow: auto; border: 1px solid #999999; background-color: #ffffff; layer-background-color: #ffffff; visibility: visible;">

					<table width="100%" border="0" cellspacing="2" cellpadding="5" valign="top" bgcolor="#FFFFFF">
                      <tr>
                        <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
                            <tr>	
                              <td class="tddkgry" width="5%">
                              
							  	<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<tr>
    									<td class="heading4">
		<html:link href="javascript:void(checkAll(document.forms[0].selectedObjects))">
		Check All
		</html:link>
									    </td>
  									</tr>								
  									<tr>
    									<td class="heading4">
		<html:link href="javascript:void(unCheckAll(document.forms[0].selectedObjects))">
		Uncheck All
		</html:link>										
										</td>
  									</tr>
								</table>							  

							  </td>													
                              <td class="tddkgry">
							  	<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<tr>
    									<td class="heading4"> Unit</td>
  									</tr>								
  									<tr>
    									<td class="heading4">&nbsp; </td>
  									</tr>
								</table>
							  </td>							
                            <td class="tddkgry">
							  	<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<tr>
    									<td class="heading4"> <bean:message key="prompt.section"/></td>
  									</tr>								
  									<tr>
    									<td class="heading4"> <bean:message key="prompt.vendor"/> </td>
  									</tr>
								</table>
							</td>
                            <td class="tddkgry">
							  	<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<tr>
    									<td class="heading4"> <bean:message key="prompt.fromlocation"/></td>
  									</tr>
  									<tr>
    									<td class="heading4"> <bean:message key="prompt.tolocation"/> </td>
  									</tr>
								</table>
							</td>
                              <td class="tddkgry">
							  	<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<tr>
    									<td class="heading4">Reference</td>
  									</tr>
  									<tr>
    									<td class="heading4">Vessel</td>
  									</tr>
								</table>
							  </td>
                            </tr>
                            <%
int row=0;
%>
                            <logic:iterate id="jobmovDTO" name="JobmovForm" property="list">
<%
String _class = row++ % 2 == 0 ? "tdlghtgry2" : "tdlghtgry";
%>
                            <tr> <span class="text2">	
                             <td class="<%= _class %>" align="center">
									<html:multibox property="selectedObjects">
									<bean:write name="jobmovDTO" property="jobmovId" />
									</html:multibox>
                            </td>												
                            <td class="<%= _class %>">
<html:hidden name="jobmovDTO" property="jobmovId" indexed="true" />	
<bean:write name="jobmovDTO" property="unit" />						
							</td>
                            <td class="<%= _class %>">
		<html:select property="section.sectionkey" name="jobmovDTO" disabled="true" styleClass="ftforminputsmall">
	
			<html:options collection="sections" property="sectionkey" labelProperty="descr"/> 
		</html:select> 
							</td>
                            <td class="<%= _class %>">
		<html:select property="fromlocation.locationkey" name="jobmovDTO" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""> </html:option>			
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>								  
							</td>
                              <td class="<%= _class %>">
<html:text name="jobmovDTO" indexed="true" property="movref" styleClass="ftforminputsmall" disabled="true"/>
							</td>
                              </span> </tr>
							  
							  
                            <tr> <span class="text2">
                              <td class="<%= _class %>" align="center">
                              </td>													
                            <td class="<%= _class %>">						
							</td>
                            <td class="<%= _class %>">
		<html:select property="vendoraddr.addrkey" name="jobmovDTO" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""> </html:option>			
			<html:options collection="vendors" property="addrkey" labelProperty="name"/>	
		</html:select>							  
							</td>
                            <td class="<%= _class %>">
		<html:select property="tolocation.locationkey" name="jobmovDTO" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""> </html:option>			
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select>														  
							</td>
                              <td class="<%= _class %>">
		<html:select property="vessel" name="jobmovDTO" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""> </html:option>		
			<html:options collection="vessels" property="vesselkey" labelProperty="vesselname"/>	
		</html:select>
							</td>
                              </span> </tr>							  
                            </logic:iterate>
                          </table></td>
                      </tr>
                    </table>	
									
</div>
	</td>
  </tr>						
				
	</logic:equal>					
</logic:notEmpty>


</table>

</html:form>


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
