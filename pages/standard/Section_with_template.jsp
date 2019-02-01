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


<script language="JavaScript">
function screenRefresh(){}
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



<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<logic:equal name="SectionForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="SectionForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="SectionForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
</head>


<body onLoad="onLoad();" onUnload="if (searchWin != null) {searchWin.close();}"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>
	

<!-- BREADCRUMBS -----------------> 
<tr>
	<td class="tdwht"><span class="heading2">     
		<strong><bean:message key="section.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListSection" styleClass="link4">
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
	
	<td>
	
		<div style="OVERFLOW:auto; width:650px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">

<tr><td colspan="2"><html:errors/></td></tr>

<tr><td>

<html:form action="/SaveSection" focus="sectionkey">
<html:hidden property="action"/>



<table width="80%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
  <tr>
    <td>
<table width="100%" border="0" cellspacing="2" cellpadding="2" bgcolor="#ffffff">
  <tr>
    <td>	
	
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>
          <td class="td7"><strong>
<logic:equal name="SectionForm" property="action"
            scope="request" value="Create">
  <bean:message key="section.title.create"/>
</logic:equal>
<logic:equal name="SectionForm" property="action"
            scope="request" value="Delete">
  <bean:message key="section.title.delete"/>
</logic:equal>
<logic:equal name="SectionForm" property="action"
            scope="request" value="Edit">
  <bean:message key="section.title.edit"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.section"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
      <logic:equal name="SectionForm" property="action"
                  scope="request" value="Create">
        <html:text property="sectionkey" size="10" styleClass="ftforminputsmall"/>
      </logic:equal>
      <logic:notEqual name="SectionForm" property="action"
                     scope="request" value="Create">
        <strong><html:hidden property="sectionkey" write="true"/></strong>
      </logic:notEqual>
          </td>
        </tr>
    </table></td>
  </tr>	
  
      <logic:notEqual name="SectionForm" property="action"
                     scope="request" value="Delete">  
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">  		
        <tr>
          <td width="22%" class="td2">
		<div align="right">
			<bean:message key="prompt.description"/>:
		</div>
		  </td>
          <td width="78%" class="td2">
        <html:text property="descr" size="50" styleClass="ftforminputsmall"/>
          </td>
        </tr>
        <tr>
          <td width="22%" class="td2">&nbsp;

		  </td>
          <td width="78%" class="td2">
                <html:checkbox property="mandrflag" /> <bean:message key="prompt.section.mandrflag"/>
          </td>
        </tr>					
    </table></td>
  </tr>	
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">  			
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.inventorystatus"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
		<html:select property="invsts" disabled="true" styleClass="ftforminputsmall"> 
		<html:option value=""><bean:message key="prompt.selectastatus"/></html:option> 
				<html:options collection="statuscodes" property="id.codekey" labelProperty="descr"/>
		</html:select> 
          </td>
        </tr>								
        <tr>
          <td width="22%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.section.transporttype"/>:
		  </div>
		  </td>
          <td width="78%" class="td2">
		<html:select property="trtype" styleClass="ftforminputsmall">
			<html:option value=""/>
			<html:options collection="transporttypes" property="trtype" labelProperty="descr"/>	
		</html:select>
          </td>
        </tr>					
    </table></td>
  </tr>
  
<logic:equal name="SectionForm" property="action"
            scope="request" value="Edit">   
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">  			
        <tr>
          <td width="50%" class="td2">
		  Section Costs Template
		  </td>	  
        </tr>								
        <tr>
          <td width="50%" class="td2">
<html:select property="arraycost" multiple="true" size="10" styleClass="ftforminputsmall">
			<html:options collection="costs" property="costkey" labelProperty="descr"/>	
</html:select>
          </td>
        </tr>					
    </table></td>
  </tr>        
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">  			
        <tr>
          <td width="50%" class="td2">
		  From Location Valid Types
		  </td>
          <td width="50%" class="td2">
		  To Location Valid Types
		  </td>		  
        </tr>								
        <tr>
          <td width="50%" class="td2">
<html:select property="arrayfromlocationtype" multiple="true" size="10" styleClass="ftforminputsmall">
			<html:options collection="locationtypes" property="typekey"/>	
</html:select>
          </td>
          <td width="50%" class="td2">
<html:select property="arraytolocationtype" multiple="true" size="10" styleClass="ftforminputsmall">
			<html:options collection="locationtypes" property="typekey"/>
</html:select>
          </td>
        </tr>					
    </table></td>
  </tr>    
</logic:equal>

</logic:notEqual>
		
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>
          <td class="td1">
      <logic:equal name="SectionForm" property="action"
                  scope="request" value="Create">
        <html:submit styleClass="button1">
          <bean:message key="button.add"/>
        </html:submit>
      </logic:equal>		  
      <logic:equal name="SectionForm" property="action"
                  scope="request" value="Delete">
        <html:submit styleClass="button1">
          <bean:message key="button.confirm"/>
        </html:submit>
      </logic:equal>
      <logic:equal name="SectionForm" property="action"
                  scope="request" value="Edit">
        <html:submit styleClass="button1">
          <bean:message key="button.save"/>
        </html:submit>
      </logic:equal>
      <logic:notEqual name="SectionForm" property="action"
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
