<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 * 												
 * NT	2010-03-06		ITT-201003-0001		User Access Module (changes not commented) 
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


<html:html>
<head>


<script type="text/javascript" language="javascript">
		window.onload = onLoadFunctions;
		document.onload = onLoadFunctions;
		function onLoadFunctions() {	
			var i; i=0; 
			if ( 
				document.forms[0].action.value == 'View'
			) {
				while (i < document.forms[0].elements.length) {
					document.forms[0].elements[i].disabled = true;
					i++;	
				}
			}
		}
</script>


<logic:equal name="QuonoteForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="quonote.title.create"/></title>
</logic:equal>
<logic:equal name="QuonoteForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="quonote.title.delete"/></title>
</logic:equal>
<logic:equal name="QuonoteForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="quonote.title.edit"/></title>
</logic:equal>
<logic:equal name="QuonoteForm" property="action"
            scope="request" value="View">
  <title><bean:message key="quonote.title.view"/></title>
</logic:equal>
		
<link rel="stylesheet" type="text/css" href="css/base.css" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

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
	<td class="tdwht">
	  <span class="heading2"><html:link action="/ListQuohdr"><bean:message key="quohdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	  <span class="heading2"><html:link action="/ListQuonote"><bean:message key="quonote.title.list"/></html:link></span>
	<span class="text6">&gt;</span>    
	<span class="heading2">
<logic:equal name="QuonoteForm" property="action"
            scope="request" value="Create">
   <bean:message key="quonote.title.create"/>
</logic:equal>
<logic:equal name="QuonoteForm" property="action"
            scope="request" value="Delete">
   <bean:message key="quonote.title.delete"/>
</logic:equal>
<logic:equal name="QuonoteForm" property="action"
            scope="request" value="Edit">
   <bean:message key="quonote.title.edit"/>
</logic:equal>
<logic:equal name="QuonoteForm" property="action"
            scope="request" value="View">
  <bean:message key="quonote.title.view"/>
</logic:equal>			
</span>
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
<tr>
	
	<td>
	
		<div style="OVERFLOW:auto; width:650px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:errors/>

<html:form action="/SaveQuonote" focus="priority">
<html:hidden property="action"/>
<html:hidden property="quonoteId"/>
<html:hidden property="quohdrId"/>


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
<logic:equal name="QuonoteForm" property="action"
            scope="request" value="Create">
   <bean:message key="quonote.title.create"/>
</logic:equal>
<logic:equal name="QuonoteForm" property="action"
            scope="request" value="Delete">
   <bean:message key="quonote.title.delete"/>
</logic:equal>
<logic:equal name="QuonoteForm" property="action"
            scope="request" value="Edit">
   <bean:message key="quonote.title.edit"/>
</logic:equal>
<logic:equal name="QuonoteForm" property="action"
            scope="request" value="View">
  <bean:message key="quonote.title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>


      <logic:notEqual name="QuonoteForm" property="action"
                     scope="request" value="Delete">  

  <tr>
    <td width="50%" valign="top">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">  				
      <tr>
        <td rowspan="3"><img src="images/spacer.gif" height="70" width="1" border="0"/> </td>	  
          <td width="30%" class="td2">
		  <div align="right">
		  <bean:message key="prompt.priority"/>:
		  </div>
		  </td>
          <td width="70%" class="td2">
		<html:select property="priority" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectapriority"/></html:option>
			<html:options collection="prioritys" property="id.codekey" labelProperty="descr"/>	
		</html:select>
          </td>	  		
      </tr>
      <tr>  
        <td width="30%" class="td2">
		<div align="right"> 
			<bean:message key="prompt.category"/>: 
		</div>
		</td>
        <td width="70%" class="td2">
		<html:select property="category" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacategory"/></html:option>
			<html:options collection="notecatgs" property="id.codekey" labelProperty="descr"/>	
		</html:select>
		</td>			
      </tr>	  
      <tr>  
        <td width="30%" class="td2">
		<div align="right"> 
			<bean:message key="prompt.status"/>: 
		</div>
		</td>
        <td width="70%" class="td2">
        <html:text property="status" size="20" maxlength="10" styleClass="ftforminputsmall"/>				
		</td>			
      </tr>																
    </table>	
	</td>
    <td width="50%" valign="top">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
      <tr>
        <td rowspan="3"><img src="images/spacer.gif" height="70" width="1" border="0"/> </td>	  
          <td width="40%" class="td2">
		  <div align="right">
		  <bean:message key="prompt.createdate"/>:
		  </div>
		  </td>
        <td width="60%" class="td2">
		<span  styleClass="ftforminputsmall">
		&nbsp;<bean:write name="QuonoteForm" property="createdate_" format="dd-MMM-yyyy" scope="request"/>
</span>
		</td>	      </tr>
      <tr>  
        <td width="40%" class="td2">
		<div align="right"> 
			<bean:message key="prompt.createtime"/>: 
		</div>
		</td>
        <td width="60%" class="td2">
		<span  styleClass="ftforminputsmall">
		&nbsp;<bean:write name="QuonoteForm" property="createtime_" scope="request"/>
</span>
		</td>			
      </tr>	  
      <tr>  
        <td width="40%" class="td2">
		<div align="right"> 
			<bean:message key="prompt.createdby"/>: 
		</div>
		</td>
        <td width="60%" class="td2">
		<span  styleClass="ftforminputsmall">
		&nbsp;<bean:write name="QuonoteForm" property="createuserid_" scope="request"/>
</span>
		</td>	      </tr>		 											
    </table>
	</td>	
  </tr>	
  
	
<tr>
    <td width="100%" valign="top" colspan="2">
		<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="2">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td2">
		  <strong><bean:message key="prompt.notes"/></strong> &nbsp;
		  </td>
		</tr>	
        <tr>
          <td width="100%" class="td2">
        <html:textarea rows="10" cols="110" property="note1" styleClass="ftforminputsmall"/>	
		  </td>  
		</tr>	  								
    </table>
	</td>
  </tr>		
  
    	
        </logic:notEqual>
		  

		
<logic:notEqual name="QuonoteForm" property="action" scope="request" value="View"> 			  
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7">
      <logic:equal name="QuonoteForm" property="action"
                  scope="request" value="Create">
        <html:submit styleClass="button1">
          <bean:message key="button.add"/>
        </html:submit>
      </logic:equal>		  
      <logic:equal name="QuonoteForm" property="action"
                  scope="request" value="Delete">
        <html:submit styleClass="button1">
          <bean:message key="button.confirm"/>
        </html:submit>
      </logic:equal>
      <logic:equal name="QuonoteForm" property="action"
                  scope="request" value="Edit">
        <html:submit styleClass="button1">
          <bean:message key="button.save"/>
        </html:submit>
      </logic:equal>
      <logic:notEqual name="QuonoteForm" property="action"
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
</logic:notEqual>


  
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
