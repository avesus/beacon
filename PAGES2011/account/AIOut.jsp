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

<!-- tell jsp to use the user bean -->
<jsp:useBean
  id="user"
  class="com.bureaueye.beacon.model.standard.User"
  scope="session"
/>

<jsp:useBean
  id="AIOutForm"
  class="com.bureaueye.beacon.form.account.AIOutForm"
  scope="request"
/>
  
  
<app:checkLogon/>

<html:html>
  <head>
<logic:equal name="AIOutForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="AIOutForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>
<logic:equal name="AIOutForm" property="action"
            scope="request" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>
<logic:equal name="AIOutForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="AIOutForm" property="action"
            scope="request" value="FixError">
  <title>Fix Error</title>
</logic:equal>
<logic:equal name="AIOutForm" property="action"
            scope="request" value="ReSend">
  <title>Re-Send</title>
</logic:equal>
  <link rel="stylesheet" type="text/css" href="css/base.css" />
  
  <script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>
<script language="javascript" type="text/javascript">
//<![CDATA[
	function onLoad() {	
		//onLoadSidebar('menu2');								
	}
    //]]>
</script>


</head>


  <body onLoad="onLoad();">
      

<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>
	

<!-- BREADCRUMBS -----------------> 
<tr>
	<td height="20" bgcolor="#eeeeee">&nbsp;</td>  
	<td class="tdwht"><span class="heading2">     
		<strong><bean:message key="aiout.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListAIOut" styleClass="link4">
				<bean:message key="title.list"/> 	
			</html:link>
		</span>		
		<span class="text6">&gt;</span>
			<span class="text6"><strong>
				<bean:message key="title.maintenance"/> 	
			</strong></span> 							
	</td> 
</tr>  
<tr valign="top" bgcolor="#eeeeee">
	<td height="1" colspan="2"></td>
</tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
<tr>
	<td bgcolor="#eeeeee" width="121" valign="top" align="center">

	</td>
	
	<td>
	
		<div style="OVERFLOW:auto; width:850px; height:650px;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:errors/>

<html:form action="/SaveAIOut">
<html:hidden property="action"/>
<html:hidden property="aioutId"/>


        
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
          <td class="tdblue">
		  <strong>
<logic:equal name="AIOutForm" property="action"
            scope="request" value="Create">
  <bean:message key="title.create"/>
</logic:equal>          
<logic:equal name="AIOutForm" property="action"
            scope="request" value="Edit">
  <bean:message key="title.edit"/>
</logic:equal>          
<logic:equal name="AIOutForm" property="action"
            scope="request" value="View">
  <bean:message key="title.view"/>
</logic:equal>
<logic:equal name="AIOutForm" property="action"
            scope="request" value="Delete">
  <bean:message key="title.delete"/>
</logic:equal>
<logic:equal name="AIOutForm" property="action"
            scope="request" value="FixError">
  Fix Error
</logic:equal>
<logic:equal name="AIOutForm" property="action"
            scope="request" value="ReSend">
  Re-Send
</logic:equal>		  
		  </strong>
		  </td>
        </tr>
    </table></td>
  </tr>


	<tr><td>
    


<!--edit-->    
<logic:equal name="AIOutForm" property="action" scope="request" value="Edit">
<html:hidden property="aistatus"/>
<html:hidden property="aibatchId"/>
<html:hidden property="errors"/>
<html:hidden property="document"/>
<html:hidden property="createuserid"/>
<html:hidden property="departmentkey"/>


    <table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
		<tr>
          <td width="20%" class="td11">
		  <div align="right">
		        <bean:message key="prompt.documentkey"/>:
		  </div>
		  </td>
          <td width="80%" class="td11">         
        <strong><bean:write name="AIOutForm" property="aioutId" scope="request"/></strong>
          </td>
        </tr>    
		<tr>
          <td width="20%" class="td11">
		  <div align="right">
		        <bean:message key="prompt.doctype"/>:
		  </div>
		  </td>
          <td width="80%" class="td11">         
		<html:select property="doctype" styleClass="ftforminputsmall">
			<html:option value="">- select a Type -</html:option>			
			<html:option value="AR">AR</html:option>
			<html:option value="AP_ACCRUAL">AP_ACCRUAL</html:option>    
            <html:option value="AP_ACTUAL">AP_ACTUAL</html:option>                              															
		</html:select>		
          </td>
        </tr>
		<tr>
          <td width="20%" class="td11">
		  <div align="right">
		        <bean:message key="prompt.companyid"/>:
		  </div>
		  </td>
          <td width="80%" class="td11"> 
		<html:select property="companykey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacompany"/></html:option>				
			<html:options collection="companys" property="compid" labelProperty="compid"/>	
		</html:select>                  
          </td>
        </tr>        
		<tr>
          <td width="20%" class="td11">
		  <div align="right">
		        <bean:message key="prompt.documentkey"/>:
		  </div>
		  </td>
          <td width="80%" class="td11">         
<html:text property="dockey" size="20" maxlength="20" styleClass="ftforminputsmall"/>	
          </td>
        </tr>  
</table>   
</logic:equal>
<!--edit-->


<!--create-->    
<logic:equal name="AIOutForm" property="action" scope="request" value="Create">	
<html:hidden property="aistatus"/>
<html:hidden property="aibatchId"/>
<html:hidden property="errors"/>
<html:hidden property="document"/>
<html:hidden property="createuserid"/> 
<html:hidden property="departmentkey"/> 
    <table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
		<tr>
          <td width="20%" class="td11">
		  <div align="right">
		       <bean:message key="prompt.doctype"/>:
		  </div>
		  </td>
          <td width="80%" class="td11">         
		<html:select property="doctype" styleClass="ftforminputsmall">
			<html:option value="">- select a Type -</html:option>			
			<html:option value="AR">AR</html:option>
			<html:option value="AP_ACCRUAL">AP_ACCRUAL</html:option>    
            <html:option value="AP_ACTUAL">AP_ACTUAL</html:option>                        															
		</html:select>		
          </td>
        </tr>
		<tr>
          <td width="20%" class="td11">
		  <div align="right">
		         <bean:message key="prompt.companyid"/>:
		  </div>
		  </td>
          <td width="80%" class="td11">         
		<html:select property="companykey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectacompany"/></html:option>					
			<html:options collection="companys" property="compid" labelProperty="compid"/>	
		</html:select>	 
          </td>
        </tr>        
		<tr>
          <td width="20%" class="td11">
		  <div align="right">
		        <bean:message key="prompt.documentkey"/>:
		  </div>
		  </td>
          <td width="80%" class="td11">         
<html:text property="dockey" size="20" maxlength="20" styleClass="ftforminputsmall"/>	
          </td>
        </tr>  
</table>   
</logic:equal>
<!--create-->
               
            
<!--view-->    
<logic:equal name="AIOutForm" property="action" scope="request" value="View">	    
    <table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
		<tr>
          <td width="20%" class="td11">
		  <div align="right">
		        <bean:message key="prompt.docid"/>:
		  </div>
		  </td>
          <td width="80%" class="td11">         
        <strong><bean:write name="AIOutForm" property="aioutId" scope="request"/></strong>
          </td>
        </tr>
		<tr>
          <td width="20%" class="td11">
		  <div align="right">
		        <bean:message key="prompt.doctype"/>:
		  </div>
		  </td>
          <td width="80%" class="td11">         
<bean:write name="AIOutForm" property="doctype" scope="request"/>
          </td>
        </tr>
		<tr>
          <td width="20%" class="td11">
		  <div align="right">
		        <bean:message key="prompt.companyid"/>:
		  </div>
		  </td>
          <td width="80%" class="td11">         
<bean:write name="AIOutForm" property="companykey" scope="request"/>
          </td>
        </tr>        
        <tr>
          <td width="20%" class="td11" valign="top">
		  <div align="right">
		        <bean:message key="prompt.status"/>:
		  </div>
		  </td>
          <td width="80%" class="td11">		  
<bean:write name="AIOutForm" property="aistatus" scope="request"/>
          </td>
        </tr>
		<tr>
          <td width="20%" class="td11">
		  <div align="right">
		        <bean:message key="prompt.documentkey"/>:
		  </div>
		  </td>
          <td width="80%" class="td11">         
<bean:write name="AIOutForm" property="dockey" scope="request"/>
          </td>
        </tr>          
        <tr>
          <td class="td11" valign="top">
		  <div align="right">
		        <bean:message key="prompt.createdate"/>:
		  </div>
		  </td>
          <td class="td11">		  
<bean:write name="AIOutForm" property="createdate_" format="dd-MMM-yyyy" scope="request"/>
          </td>
        </tr>
        
        <tr>
          <td class="td11" valign="top">
		  <div align="right">
		        <bean:message key="prompt.senttime"/>:
		  </div>
		  </td>
          <td class="td11">		  
<bean:write name="AIOutForm" property="sentdate_" format="dd-MMM-yyyy" scope="request"/>
          </td>
        </tr>
 
         <tr>
          <td class="td11" valign="top">
		  <div align="right">
		        <bean:message key="prompt.batchid"/>:
		  </div>
		  </td>
          <td class="td11">		  
<bean:write name="AIOutForm" property="aibatchId" scope="request"/>
          </td>
        </tr>


 
<logic:notEqual name="AIOutForm" property="errors"
            scope="request" value=""> 
         <tr>
          <td class="td11" valign="top">
		  <div align="right">
		        <bean:message key="prompt.errorsreceived"/>:
		  </div>
		  </td>
          <td class="td11">		  
           <table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFffff">
           <tr><td>
           <table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FF0000">
		<tr><td class="td3"><bean:message key="prompt.errorid"/></td><td class="td3"><bean:message key="prompt.errorfield"/></td><td class="td3"><bean:message key="prompt.errormsg"/></td></tr>
               
<x:parse var="errorList">
<%
out.write(AIOutForm.getErrors());
%>
</x:parse>
<x:forEach select="$errorList//error">
<tr><td class="td9"><x:out select="errorid"/></td><td class="td9"><x:out select="errorfield"/></td><td class="td9"><x:out select="errormsg"/></td></tr>
</x:forEach> 
      		</table>
            
            </td></tr>
            </table>
            
            </td>
            </tr>
</logic:notEqual> 
	


<logic:notEqual name="AIOutForm" property="document"
            scope="request" value=""> 
         <tr>
          <td class="td11" valign="top">
		  <div align="right">
		        <bean:message key="prompt.headersent"/>:
		  </div>
		  </td>
          <td class="td11">		  
           <table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFffff">
           <tr><td>
           <table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
		<tr><td class="td3"><bean:message key="prompt.name"/></td><td class="td3"><bean:message key="prompt.value"/></td></tr>
               
<x:parse var="documentList">
<%
out.write(AIOutForm.getDocument());
%>
</x:parse>
<x:forEach select="$documentList//header">
<tr><td class="td9"><x:out select="name"/></td><td class="td9"><x:out select="value"/></td></tr>
</x:forEach> 
      		</table>
            
            </td></tr>
            </table>
            
            </td>
            </tr>
                               

         <tr>
          <td class="td11" valign="top">
		  <div align="right">
		        <bean:message key="prompt.detailssent"/>:
		  </div>
		  </td>
          <td class="td11">		  
           <table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFffff">
           <tr><td>
           <table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
		<tr><td class="td3"><bean:message key="prompt.recordno"/></td><td class="td3"><bean:message key="prompt.name"/></td><td class="td3"><bean:message key="prompt.value"/></td></tr>
               
<x:forEach select="$documentList//detail">
<tr><td class="td9"><x:out select="recordno"/></td><td class="td9"><x:out select="name"/></td><td class="td9"><x:out select="value"/></td></tr>
</x:forEach> 
      		</table>
            
            </td></tr>
            </table>
            
            </td>
            </tr>
</logic:notEqual>                                
          
</table>   
</logic:equal>
<!--view--> 

 
<!--delete-->    
<logic:equal name="AIOutForm" property="action" scope="request" value="Delete">	   
    <table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
		<tr>
          <td width="20%" class="td11">
		  <div align="right">
		        <bean:message key="prompt.docid"/>:
		  </div>
		  </td>
          <td width="80%" class="td11">         
        <strong><bean:write name="AIOutForm" property="aioutId" scope="request"/></strong>
          </td>
        </tr>      
</table>   
</logic:equal>
<!--delete-->


<!--resend-->    
<logic:equal name="AIOutForm" property="action" scope="request" value="ReSend">	   
    <table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
		<tr>
          <td width="20%" class="td11">
		  <div align="right">
		        <bean:message key="prompt.docid"/>:
		  </div>
		  </td>
          <td width="80%" class="td11">         
        <strong><bean:write name="AIOutForm" property="aioutId" scope="request"/></strong>
          </td>
        </tr>      
</table>   
</logic:equal>
<!--resend-->

      			
	</td></tr>	
  

<logic:notEqual name="AIOutForm" property="action" scope="request" value="View">
  <tr>
    <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>
          <td class="tdblue">		  
      <logic:equal name="AIOutForm" property="action"
                  scope="request" value="Create">
        <html:submit styleClass="button1">
          <bean:message key="button.add"/>
        </html:submit>
      </logic:equal>		  
      <logic:equal name="AIOutForm" property="action"
                  scope="request" value="Delete">
        <html:submit styleClass="button1">
          <bean:message key="button.confirm"/>
        </html:submit>
      </logic:equal>
      <logic:equal name="AIOutForm" property="action"
                  scope="request" value="Edit">
        <html:submit styleClass="button1">
          <bean:message key="button.save"/>
        </html:submit>
      </logic:equal>
      <logic:notEqual name="AIOutForm" property="action"
                     scope="request" value="Delete">
        <html:reset styleClass="button1">
          <bean:message key="button.reset"/>
        </html:reset>
      </logic:notEqual>
      <logic:equal name="AIOutForm" property="action"
                  scope="request" value="FixError">
        <html:submit styleClass="button1">
          Confirm Fix
        </html:submit>
      </logic:equal>
      <logic:equal name="AIOutForm" property="action"
                  scope="request" value="ReSend">
        <html:submit styleClass="button1">
          Confirm Re-Send
        </html:submit>		
      </logic:equal>			  
      <html:cancel styleClass="button1">
        <bean:message key="button.cancel"/>
      </html:cancel>
    </td>
  </tr>		  
    </table>
    </td>
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
