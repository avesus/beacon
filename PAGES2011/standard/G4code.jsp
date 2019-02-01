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
<logic:equal name="G4codeForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="gcode.title.create"/></title>
</logic:equal>
<logic:equal name="G4codeForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="gcode.title.delete"/></title>
</logic:equal>
<logic:equal name="G4codeForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="gcode.title.edit"/></title>
</logic:equal>	
<link rel="stylesheet" type="text/css" href="css/base.css" />

</head>

<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/ajaxV2.js"></script> 
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/standard/ListG2codeAjax.js"></script>
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/standard/ListG3codeAjax.js"></script>

<body> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>
	

<!-- BREADCRUMBS -----------------> 
<tr>
	<td class="tdwht"><span class="heading2">     
		<strong><bean:message key="gcode.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListG4code" styleClass="link4">
				<bean:message key="gcode.title.list"/> 	
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
	
	<td>
	
		<div style="OVERFLOW:auto; width:650px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>
<html:errors/>


<html:form action="/SaveG4code" focus="g1codekey">
<html:hidden property="action"/>
<html:hidden property="readonly"/>
<html:hidden property="g4codeId"/>
		
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
<logic:equal name="G4codeForm" property="action"
            scope="request" value="Create">
<bean:message key="gcode.title.create"/>
</logic:equal>
<logic:equal name="G4codeForm" property="action"
            scope="request" value="Delete">
  <bean:message key="gcode.title.delete"/>
  </logic:equal>
<logic:equal name="G4codeForm" property="action"
            scope="request" value="Edit">
 	<bean:message key="gcode.title.edit"/>
 </logic:equal>		  
		  </strong></td>
        </tr>
    </table></td>
  </tr>
  
  
        <logic:equal name="G4codeForm" property="action"
                     scope="request" value="Delete">  
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">  				
        <tr>
			<td rowspan="4">
		  		<img src="images/spacer.gif" width="1" border="0"/>
		  	</td>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.g1code"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
        <strong><html:hidden property="g1codekey" write="true"/></strong>
          </td>
        </tr>
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.g2code"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
        <strong><html:hidden property="g2codekey" write="true"/></strong>
          </td>
        </tr> 
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.g3code"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
        <strong><html:hidden property="g3codekey" write="true"/></strong>
          </td>
        </tr> 
                <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.g4code"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
        <strong><html:hidden property="g4codekey" write="true"/></strong>
          </td>
        </tr>                  
	</table>
	</td>
	</tr>
	</logic:equal>		
	

	  
        <logic:notEqual name="G4codeForm" property="action"
                     scope="request" value="Delete"> 
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
			<td rowspan="7">
		  		<img src="images/spacer.gif" width="1" border="0"/>
		  	</td>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.g1code"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
		  <c:if test="${G4codeForm.action == 'Create'}">
        <html:select property="g1codekey" styleClass="ftforminputsmall" onchange="processListG2code();">
			<html:option value=""> <bean:message key="prompt.selectacode"/></html:option>
			<html:options collection="g1codes" property="g1codekey" labelProperty="g1codekey"/>	
		</html:select>	
		  </c:if>
		  <c:if test="${G4codeForm.action != 'Create'}">
        	<html:text property="g1codekey" size="30" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>
			<html:hidden property="g1codekey"/>			
		  </c:if>		  
          </td>
        </tr>
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.g2code"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
		  <c:if test="${G4codeForm.action == 'Create'}">
        <html:select property="g2codekey" styleClass="ftforminputsmall" onchange="processListG3code();">
			<html:option value=""> <bean:message key="prompt.selectacode"/></html:option>	
		</html:select>
		  </c:if>
		  <c:if test="${G4codeForm.action != 'Create'}">
        	<html:text property="g2codekey" size="30" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>
			<html:hidden property="g2codekey"/>			
		  </c:if>		  
          </td>
        </tr>
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.g3code"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
		  <c:if test="${G4codeForm.action == 'Create'}">
        <html:select property="g3codekey" styleClass="ftforminputsmall">
			<html:option value=""> <bean:message key="prompt.selectacode"/></html:option>	
		</html:select>
		  </c:if>
		  <c:if test="${G4codeForm.action != 'Create'}">
        	<html:text property="g3codekey" size="30" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>
			<html:hidden property="g3codekey"/>			
		  </c:if>		  
          </td>
        </tr> 
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.g4code"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
		  <c:if test="${G4codeForm.action == 'Create'}">
        	<html:text property="g4codekey" size="30" maxlength="20" styleClass="ftforminputsmall"/>
		  </c:if>
		  <c:if test="${G4codeForm.action != 'Create'}">
        	<html:text property="g4codekey" size="30" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>
			<html:hidden property="g4codekey"/>			
		  </c:if>		  
          </td>
        </tr>                	        	
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.description"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
        	<html:text property="ldesc" size="50" maxlength="40" styleClass="ftforminputsmall"/>	  
          </td>
        </tr>		
        <tr>
          <td width="22%" class="td2">
		  <div align="right"><bean:message key="prompt.sdesc"/>:		  </div>		  </td>
          <td width="78%" class="td2">
		  <html:text property="sdesc" size="20" maxlength="10" styleClass="ftforminputsmall"/>
          </td>
        </tr>		
         <tr>
          <td width="22%" class="td2">
		  <div align="right"><bean:message key="prompt.locationcode"/>:		  </div>		  </td>
          <td width="78%" class="td2">
		  <html:text property="locationcode" size="20" maxlength="10" styleClass="ftforminputsmall"/>
          </td>
        </tr>	
         			
    </table>
	</td>
  </tr>
     
  	</logic:notEqual>
	
  
  
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>
          <td class="td1">
      <logic:equal name="G4codeForm" property="action"
                  scope="request" value="Create">
        <html:submit styleClass="button1">
          <bean:message key="button.add"/>
        </html:submit>
      </logic:equal>		  
      <logic:equal name="G4codeForm" property="action"
                  scope="request" value="Delete">
        <html:submit styleClass="button1">
          <bean:message key="button.confirm"/>
        </html:submit>
      </logic:equal>
      <logic:equal name="G4codeForm" property="action"
                  scope="request" value="Edit">
        <html:submit styleClass="button1">
          <bean:message key="button.save"/>
        </html:submit>
      </logic:equal>
      <logic:notEqual name="G4codeForm" property="action"
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
