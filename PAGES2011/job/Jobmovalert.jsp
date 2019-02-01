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


<!-- init extra property methods -->
<bean:define id="jobmovs" name="JobmovalertForm" property="jobmovs"/>

<jsp:useBean
  id="JobmovalertForm"
  class="com.bureaueye.beacon.form.alert.AlertForm"
  scope="session"
/>
  
<app:checkLogon/>


<html:html>
<head>


  


<script type="text/javascript" language="javascript">
		window.onload = onLoadFunctions;
		document.onload = onLoadFunctions;
		function onLoadFunctions() {	
			var i; i=0; 
			if ( document.forms[0].action.value == 'View') {
			while (i < document.forms[0].elements.length) {
				document.forms[0].elements[i].disabled = true;
				i++;	
			}
			}
		}
</script>

	  

<script language="JavaScript">
var searchWin;

function addresscontactSearch(field){
	var url     = 'ListAddresscontactSearch.do?'+
					'maxResults=999'+
					'&headerInfo1='+
					'&headerInfo2='+				
					'&headerInfo3='+
					field
					;
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=600');
	searchWin.focus();
}
</script>



<logic:equal name="JobmovalertForm" property="action"
            scope="session" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="JobmovalertForm" property="action"
            scope="session" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="JobmovalertForm" property="action"
            scope="session" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="JobmovalertForm" property="action"
            scope="session" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>

<link rel="stylesheet" type="text/css" href="css/base.css" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

</head>


<body onUnload="if (searchWin != null) {searchWin.close();}"> 
 
<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>
 	

<!-- BREADCRUMBS -----------------> 
<tr>
 
	<td class="tdwht">
	<span class="heading2"><strong><bean:message key="alert.title"/></strong></span>
	<span class="heading2"><html:link action="/ListOrderhdr" styleClass="link4">Order List</html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2"><html:link action="/ListJobhdr" styleClass="link5">Job Unit List</html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2"><html:link action="/ListJobmovalert" styleClass="link5">Movement Alerts List</html:link></span>     
	<span class="text6">&gt;</span>
	<span class="text6"><strong><bean:message key="title.maintenance"/></strong></span>
    
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
<tr>

	
	<td>
	
		<div style="OVERFLOW:auto; width:1150px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>
<html:errors/>


<html:form action="/SaveJobmovalert" focus="alertmodule">
<html:hidden property="action"/>
<html:hidden property="record1Id"/>
<html:hidden property="readonly"/>




<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#ffffff">

  <tr>
    <td>
<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">
<%--  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="bgcolor99">
        <tr>
          <td class="td11"><strong>
<logic:equal name="JobmovalertForm" property="action"
            scope="session" value="Create">
  <bean:message key="alert.title.create"/>
</logic:equal>
<logic:equal name="JobmovalertForm" property="action"
            scope="session" value="Delete">
  <bean:message key="alert.title.delete"/>
</logic:equal>
<logic:equal name="JobmovalertForm" property="action"
            scope="session" value="Edit">
  <bean:message key="alert.title.edit"/>
</logic:equal>
<logic:equal name="JobmovalertForm" property="action"
            scope="session" value="View">
  <bean:message key="alert.title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>	</td>
  </tr>--%>
		


	
	
<logic:equal name="JobmovalertForm" property="action"
                     scope="session" value="Delete"> 	
      <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
                  <tr>
                <td rowspan="2"><img src="images/spacer.gif" width="1" border="0"/> </td>
<td class="td2" colspan="2">&nbsp;
<strong><bean:message key="alert.title.delete"/></strong>
</td>
              </tr>	 
              				
        <tr>	
          <td width="20%" class="td9">
		  <div align="right">
		        <bean:message key="prompt.alertid"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
        <html:text property="alertId" size="10" disabled="true" maxlength="10" styleClass="ftforminputsmall"/> 
        	<html:hidden property="alertId"/>   
          </td>
        </tr>
	</table>
	</td>
	</tr>
</logic:equal>
    
                     
                       
<logic:notEqual name="JobmovalertForm" property="action"
                     scope="session" value="Delete"> 

	<html:hidden property="alertId"/>   
    
<tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
              <tr>
                <td rowspan="3"><img src="images/spacer.gif" width="1" border="0"/> </td>
<td class="td2" colspan="2">&nbsp;
<strong>
<logic:equal name="JobmovalertForm" property="action"
            scope="session" value="Create">
  <bean:message key="alert.title.create"/>
</logic:equal>
<logic:equal name="JobmovalertForm" property="action"
            scope="session" value="Delete">
  <bean:message key="alert.title.delete"/>
</logic:equal>
<logic:equal name="JobmovalertForm" property="action"
            scope="session" value="Edit">
  <bean:message key="alert.title.edit"/>
</logic:equal>
<logic:equal name="JobmovalertForm" property="action"
            scope="session" value="View">
  <bean:message key="alert.title.view"/>
</logic:equal>		  
		  </strong>
		
</td>
              </tr>	
              

         <tr>
          <td class="td9">
		  <div align="right">
		  <bean:message key="prompt.alertmodule"/>:
		  </div>
		  </td>
          <td width="85%" class="td9">
 		<html:select property="alertmodule" styleClass="ftforminputsmall">
			<html:option value="JOBMOV">JOB MOVEMENT</html:option>
		</html:select>
          </td>
        </tr>	

      <tr>	  
          <td class="td9">
		  <div align="right">
		  <bean:message key="prompt.alerttype"/>:
		  </div>
		  </td>
          <td class="td9">
 		<html:select property="alerttype" styleClass="ftforminputsmall">
			<html:option value="DATE">DATE</html:option>
		</html:select>      	    
          </td>	  		
      </tr>	     
                     
            </table>
    </td>          
</tr> 
 
 


<!-- ALERT WHEN --> 
<tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
              <tr>
                <td rowspan="2"><img src="images/spacer.gif" width="1" border="0"/> </td>
<td class="td13">&nbsp;<strong><bean:message key="prompt.alertwhen"/></strong>			
</td>
              </tr>	
              
         <tr>
          <td class="td9">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">  
        <tr>
		  <td rowspan="1">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>			
          
                    <TD class="td9" valign="top">
			<table width="100%"  border="0" cellpadding="0" cellspacing="0">  
        <tr>		
          <td class="td9">
          For&nbsp;
          
<logic:equal name="JobmovalertForm" property="action"
            scope="session" value="Create">    
 		<html:select property="ruleparam1" styleClass="ftforminputsmall">
			<html:option value="ANY_MOVEMENT">Any Movement</html:option>
<%--<html:option value="DEPO_MOVEMENT">Depot Movement</html:option><html:option value="LOAD_MOVEMENT">Loading Movement</html:option>           
<html:option value="SHIP_MOVEMENT">Ship Movement</html:option>
<html:option value="DSCH_MOVEMENT">Discharge Movement</html:option>   
<html:option value="RTDP_MOVEMENT">Return to Depot Movement</html:option> 
<html:option value="AVDP_MOVEMENT">Empty Available Movement</html:option>  --%>           
			<html:options collection="jobmovs" property="sectionkey.sectionkey" labelProperty="sectionkey.sectionkey"/>         
		</html:select>        
 </logic:equal>  
<logic:notEqual name="JobmovalertForm" property="action"
            scope="session" value="Create">     
            <html:text property="ruleparam1" disabled="true" size="20" styleClass="ftforminputsmall"/> 
        	<html:hidden property="ruleparam1"/>             
 </logic:notEqual>         
        	<html:hidden property="ruleparam2"/> 
            
            
		  </td> 
          <td class="td9">
          &nbsp;start alert when the current date is&nbsp;
		  </td> 
          <td class="td9">
 		<html:select property="ruleparam4" styleClass="ftforminputsmall">
			<html:option value="3 days before">3 days before</html:option>
			<html:option value="2 days before">2 days before</html:option> 
            <html:option value="1 day before">1 day before</html:option> 
            <html:option value="equal to">equal to</html:option>  
			<html:option value="1 day after">1 day after</html:option>
			<html:option value="2 days after">2 days after</html:option> 
            <html:option value="3 days after">3 days after</html:option>                                    
		</html:select>
		  </td>  
          <td class="td9">
          &nbsp;the Planned Date
		  </td> 
          <td class="td9" width="38%">
		  </td>                                                    
        </tr>        																						
          </table>						  
 </td>	 
  
        </tr>
        																						
    </table>	
		  </td>

        </tr>	
   
            </table>
    </td>          
</tr> 

 
			 
 
 
 
 
 
 
<!-- ALERT WHO --> 
<tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
              <tr>
                <td rowspan="4"><img src="images/spacer.gif" width="1" border="0"/> </td>
<td class="td13">&nbsp;<strong><bean:message key="prompt.alerthow"/></strong>			
</td>
              </tr>	
   
   

<!-- ALERT MAIL -->              
<TR>
	<TD class="td9" valign="top">
		<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
                                
              <tr>
                <td rowspan="7"><img src="images/spacer.gif" width="1" border="0"/> </td>
<td class="td9" colspan="2"><html:checkbox property="mailflag" />&nbsp;<strong><bean:message key="prompt.alertmail"/></strong>				
</td>
              </tr>	
              
                   <TR>
                      <TD class="td9">
                      		  <div align="right">
                      		<html:link href="javascript:void(addresscontactSearch('mailto'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search Contact" border="0" align="middle"/>
		</html:link>
                      <bean:message key="prompt.emailto"/>:
                      </div>
                      </TD>
                      <TD class="td9" width="85%">
<html:text property="mailto" size="100" maxlength="250" styleClass="ftforminputsmall"/>                     
                      </TD>
                    </TR>

                   <TR>
                      <TD class="td9">
                      		  <div align="right">
                      		<html:link href="javascript:void(addresscontactSearch('mailcc'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search Contact" border="0" align="middle"/>
		</html:link>
                      <bean:message key="prompt.emailcc"/>:
                      </div>
                      </TD>
                      <TD class="td9">
<html:text property="mailcc" size="100" maxlength="250" styleClass="ftforminputsmall"/>                     
                      </TD>
                    </TR>
                    
                  <TR>
                      <TD class="td9">
                      		  <div align="right">
                      		<html:link href="javascript:void(addresscontactSearch('mailbcc'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search Contact" border="0" align="middle"/>
		</html:link>
                      <bean:message key="prompt.emailbcc"/>:
                      </div>
                      </TD>
                      <TD class="td9">
<html:text property="mailbcc" size="100" maxlength="250" styleClass="ftforminputsmall"/>                     
                      </TD>
                    </TR>

                  <TR>
                      <TD class="td9">
                      		  <div align="right">
                      <bean:message key="prompt.emailfrom"/>:
                      </div>
                      </TD>
                      <TD class="td9">
<html:text property="mailfrom" size="100" maxlength="250" styleClass="ftforminputsmall"/>                     
                      </TD>
                    </TR>
                                                            
                    <TR>
                      <TD class="td9">
                      		  <div align="right">
                      <bean:message key="prompt.emailsubject"/>:
                      </div>
                      </TD>
                      <TD class="td9">
<html:text property="mailsubject" size="100" maxlength="250" styleClass="ftforminputsmall"/>                     
                      </TD>
                    </TR>
                    
                    <TR>
                      <TD class="td9" valign="top">
                      		  <div align="right">
                      <bean:message key="prompt.emailmessage"/>: 
                      </div>
                      </TD>
                      <TD class="td9">
<html:textarea rows="2" cols="100"  property="mailmessage" styleClass="ftforminputsmall"/>  
                  </TD>
                    </TR>               
                     
    	</table>                            
	</TD>
</TR>
                      


<!-- ALERT TEXT -->          
<TR>
	<TD class="td9" valign="top">
		<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
                                
              <tr>
                <td rowspan="3"><img src="images/spacer.gif" width="1" border="0"/> </td>
<td class="td9" colspan="2"><html:checkbox property="textflag" />&nbsp;<strong><bean:message key="prompt.alerttext"/></strong>				
</td>
              </tr>	
              
                   <TR>
                      <TD class="td9">
                      		  <div align="right">
                      <bean:message key="prompt.textto"/>:
                      </div>
                      </TD>
                      <TD class="td9" width="85%">
<html:text property="textto" size="100" maxlength="250" styleClass="ftforminputsmall"/>                     
                      </TD>
                    </TR> 
                    
                    <TR>
                      <TD class="td9" valign="top">
                      		  <div align="right">
                      <bean:message key="prompt.textmessage"/>: 
                      		  </div>
                      </TD>
                      <TD class="td9">
<html:textarea rows="2" cols="100"  property="textmessage" styleClass="ftforminputsmall"/>  
                  </TD>
                    </TR>               
                     
    	</table>                            
	</TD>
</TR>


 
<!-- ALERT TASK --> 
<%
com.bureaueye.beacon.form.alert.AlertForm jobmovalertForm = 
	(com.bureaueye.beacon.form.alert.AlertForm)JobmovalertForm;	             
%>
<TR>
	<TD class="td9" valign="top">
		<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
        
              <tr>
                <td rowspan="4"><img src="images/spacer.gif" width="1" border="0"/> </td>
<td class="td9" colspan="2"><html:checkbox property="taskflag" />&nbsp;<strong><bean:message key="prompt.alerttask"/></strong>				
</td>
              </tr>				
                    <TR>
                      <TD class="td9">
                      		  <div align="right">
                      <bean:message key="prompt.taskuser"/>:
                      </div>
                      </TD>
                      <TD class="td9" width="85%">
  <select name="taskuserid" class="ftforminputsmall">
		<option selected value=""><bean:message key="prompt.selectauserid"/></option>
<%
	String s="";
	java.util.List list = null;
	list = (java.util.List)users;	
	if (list != null) {
      		java.util.Iterator it = list.iterator();
      		while (it.hasNext()) {
         		com.bureaueye.beacon.model.standard.User user = 
					(com.bureaueye.beacon.model.standard.User) it.next();
					s="";
				if (user.getUserid().equals(jobmovalertForm.getTaskuserid())) s = "Selected";					
%>
		<option <%= s %> value="<%= user.getUserid() %>"><%= user.getUserid() %></option>
<%
		}
	}
%>			
  </select>	                    
                      </TD>
                    </TR>
                    <TR>
                      <TD class="td9">
                      		  <div align="right">
                      <bean:message key="prompt.taskusergroup"/>:
                      </div>
                      </TD>
                      <TD class="td9">
  <select name="taskusergroupid" class="ftforminputsmall">
		<option selected value=""><bean:message key="prompt.selectagroupid"/></option>
<%
	s="";
	list = null;
	list = (java.util.List)usergroups;	
	if (list != null) {
      		java.util.Iterator it = list.iterator();
      		while (it.hasNext()) {
         		com.bureaueye.beacon.model.standard.Usergroup usergroup = 
					(com.bureaueye.beacon.model.standard.Usergroup) it.next();
					s="";
				if (usergroup.getUsergroupid().equals(jobmovalertForm.getTaskusergroupid())) s = "Selected";
%>
		<option <%= s %> value="<%= usergroup.getUsergroupid() %>"><%= usergroup.getUsergroupid() %></option>
<%
		}
	}
%>			
  </select>                   
                      </TD>
                    </TR>
                    <TR>
                      <TD class="td9">
                      		  <div align="right">
                      <bean:message key="prompt.taskpriority"/>:
                      </div> 
                      </TD>
                      <TD class="td9">
                      
		<html:select property="taskpriority" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectapriority"/></html:option>
			<html:options collection="prioritys" property="id.codekey" labelProperty="descr"/>	
		</html:select>
                              
                  </TD>
                    </TR>                                 
                     
    	</table>                            
	</TD>
</TR>
  
                     
    	</table>                            
	</TD>
</TR>

 
<!-- ALERT UNTIL --> 
<tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
              <tr>
<td rowspan="2"><img src="images/spacer.gif" width="1" border="0"/></td>
<td class="td13" colspan="2">&nbsp;<strong><bean:message key="prompt.alertuntil"/></strong>			
</td>
              </tr>	
              
         <tr>
          <td class="td9">
		  <div align="right">
		  <bean:message key="prompt.validto"/>:
		  </div>
		  </td>
          <td width="85%" class="td9">
		<html:select property="validtodd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="validtomm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="validtoyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	
          </td>
        </tr>	
   
            </table>
    </td>          
</tr> 

 


        	
</logic:notEqual>
  
  
<!--buttons-->
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" class="bgcolor99">
	
<logic:notEqual name="JobmovalertForm" property="action" scope="session" value="View"> 

        <tr>
		          <td class="td11">

<logic:equal name="JobmovalertForm" property="action" scope="session" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="JobmovalertForm" property="action"
                  scope="session" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="JobmovalertForm" property="action"
                  scope="session" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 

<logic:notEqual name="JobmovalertForm" property="action" scope="session" value="Delete"> 
	<html:reset styleClass="button1"> <bean:message key="button.reset"/> </html:reset> 
</logic:notEqual>
  
	<input type="submit" name="org.apache.struts.taglib.html.CANCEL" value='<bean:message key="button.cancel"/>' onClick="if (searchWin != null) {searchWin.close();}; bCancel=true;" class="button1">	  
	
	</td>
	
  </tr>	
  
</logic:notEqual> 
  	  
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
