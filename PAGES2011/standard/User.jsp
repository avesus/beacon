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
<logic:equal name="UserForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="user.title.create"/></title>
</logic:equal>
<logic:equal name="UserForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="user.title.delete"/></title>
</logic:equal>
<logic:equal name="UserForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="user.title.edit"/></title>
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
		<strong><bean:message key="user.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListUser" styleClass="link4">
				<bean:message key="user.title.list"/> 	
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


<html:form action="/SaveUser" focus="userid">
<html:hidden property="action"/>
<html:hidden property="readonly"/>
<html:hidden property="language"/>
<html:hidden property="country"/>
<html:hidden property="locale"/>	
<html:hidden property="copyId"/>
		
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
<logic:equal name="UserForm" property="action"
            scope="request" value="Create">
<bean:message key="user.title.create"/>
</logic:equal>
<logic:equal name="UserForm" property="action"
            scope="request" value="Delete">
  <bean:message key="user.title.delete"/>
  </logic:equal>
<logic:equal name="UserForm" property="action"
            scope="request" value="Edit">
 	<bean:message key="user.title.edit"/>
 </logic:equal>		  
		  </strong></td>
        </tr>
    </table></td>
  </tr>
  
  
        <logic:equal name="UserForm" property="action"
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
		        <bean:message key="prompt.userid"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
        <strong><html:hidden property="userid" write="true"/></strong>
          </td>
        </tr>
	</table>
	</td>
	</tr>
	</logic:equal>		
	

	  
        <logic:notEqual name="UserForm" property="action"
                     scope="request" value="Delete"> 
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
			<td rowspan="8">
		  		<img src="images/spacer.gif" width="1" border="0"/>
		  	</td>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.userid"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
		  <c:if test="${UserForm.action == 'Create'}">
        	<html:text property="userid" size="30" maxlength="20" styleClass="ftforminputsmall"/>
		  </c:if>
		  <c:if test="${UserForm.action != 'Create'}">
        	<html:text property="userid" size="30" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>
			<html:hidden property="userid"/>			
		  </c:if>		  
          </td>
        </tr>	
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.name"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
        	<html:text property="name" size="30" maxlength="20" styleClass="ftforminputsmall"/>	  
          </td>
        </tr>		
        <tr>
          <td width="22%" class="td2">
		  <div align="right"><bean:message key="prompt.password"/>:		  </div>		  </td>
          <td width="78%" class="td2">
		  <html:text property="password" size="15" maxlength="10" styleClass="ftforminputsmall"/>
          </td>
        </tr>		
        <tr>
          <td width="22%" class="td2">
		  <div align="right"><bean:message key="prompt.groupid"/>:		  </div>		  </td>
          <td width="78%" class="td2">
		<html:select property="usergroupid" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectagroupid"/></html:option>
			<html:options collection="usergroups" property="usergroupid" labelProperty="usergroupid"/>	
		</html:select>		  
          </td>
        </tr>		
        <tr>
          <td width="22%" class="td2">
		  <div align="right"><bean:message key="prompt.email"/>:		  </div>		  </td>
          <td width="78%" class="td2">
		  <html:text property="email" size="30" maxlength="50" styleClass="ftforminputsmall"/>
          </td>
        </tr>
        <tr>
          <td width="22%" class="td2">
		  <div align="right"><bean:message key="prompt.mailhost"/>:		  </div>		  </td>
          <td width="78%" class="td2">
		  <html:text property="mailhost" size="50" maxlength="50" styleClass="ftforminputsmall"/>
          </td>
        </tr>		
        <tr>
          <td width="22%" class="td2">
		  <div align="right"><bean:message key="prompt.securitylevel"/>:		  </div>		  </td>
          <td width="78%" class="td2">
		<html:select property="securitylevel" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalevel"/></html:option>
			<html:options collection="prioritys" property="id.codekey" labelProperty="descr"/>	
		</html:select>
          </td>
        </tr>		
        <tr>
          <td width="22%" class="td2">
		  <div align="right"><bean:message key="prompt.pagesize"/>:		  </div>		  </td>
          <td width="78%" class="td2">
		  <html:text property="pagesize" size="15" maxlength="10" styleClass="ftforminputsmall"/>
          </td>
        </tr>			  			
    </table>
	</td>
  </tr>
  
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
      <tr>
        <td rowspan="3"><img src="images/spacer.gif" height="60" width="1" border="0"/> </td>	  
        <td width="22%" class="td2"><div align="right">
            <bean:message key="prompt.company"/>
          : </div></td>
        <td width="78%" class="td2"><html:select property="companykey" styleClass="ftforminputsmall">
            <html:option value="">
              <bean:message key="prompt.selectacompany"/>
            </html:option>
            <html:options collection="companys" property="compid" labelProperty="name"/>
          </html:select>
        </td>
      </tr>
      <tr>
        <td width="22%" class="td2"><div align="right">
            <bean:message key="prompt.department"/>
          : </div></td>
        <td width="78%" class="td2"><html:select property="departmentkey" styleClass="ftforminputsmall">
            <html:option value="">
              <bean:message key="prompt.selectadepartment"/>
            </html:option>
            <html:options collection="departments" property="id.codekey" labelProperty="descr"/>
          </html:select>
        </td>
      </tr>
      <tr>
        <td width="22%" class="td2"><div align="right">
            <bean:message key="prompt.activity"/>
          : </div></td>
        <td width="78%" class="td2"><html:select property="activitykey" styleClass="ftforminputsmall">
            <html:option value="">
              <bean:message key="prompt.selectaactivity"/>
            </html:option>
            <html:options collection="activitys" property="id.codekey" labelProperty="descr"/>
          </html:select>
        </td>
      </tr>
    </table></td>
  </tr>
  
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">  			
        <tr>
        <td rowspan="2"><img src="images/spacer.gif" height="80" width="1" border="0"/> </td>        
          <td width="50%" class="td2">
		  <bean:message key="prompt.accessaddresses"/>
		  </td>
          <td width="50%" class="td2">
		  <bean:message key="prompt.accesslocations"/>
		  </td>		  
        </tr>								
        <tr>
          <td width="50%" class="td2">
<html:select property="arraytypekeylist" multiple="true" size="10" styleClass="ftforminputsmall">
			<html:options collection="addrtypes" property="typekey" labelProperty="typekey"/>	
</html:select> 
          </td>
          <td width="50%" class="td2">
<html:select property="arraylocationtypelist" multiple="true" size="10" styleClass="ftforminputsmall">
			<html:options collection="locationtypes" property="typekey" labelProperty="typekey"/> 	
</html:select> 
          </td>
        </tr>					
    </table></td>
  </tr>   
    
  	</logic:notEqual>
	
  
  
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>
          <td class="td1">
      <logic:equal name="UserForm" property="action"
                  scope="request" value="Create">
        <html:submit styleClass="button1">
          <bean:message key="button.add"/>
        </html:submit>
      </logic:equal>		  
      <logic:equal name="UserForm" property="action"
                  scope="request" value="Delete">
        <html:submit styleClass="button1">
          <bean:message key="button.confirm"/>
        </html:submit>
      </logic:equal>
      <logic:equal name="UserForm" property="action"
                  scope="request" value="Edit">
        <html:submit styleClass="button1">
          <bean:message key="button.save"/>
        </html:submit>
      </logic:equal>
      <logic:notEqual name="UserForm" property="action"
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
