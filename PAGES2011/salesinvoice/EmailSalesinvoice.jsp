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

<jsp:useBean
  id="ListSihdrForm"
  class="com.bureaueye.beacon.form.ListForm"
  scope="session"
/>

<html:html>
<head>
<title><bean:message key="prompt.emailsalesinvoice"/></title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/print.css" />



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

 
</head> 

 
<body onUnload="if (searchWin != null) {searchWin.close()}">  


<table cellpadding="0" cellspacing="0" border="0" width="100%">

  	<tr>
   		<td bgcolor="#f6f6f6"><html:img src="images/spacer.gif" border="0" width="2" height="15"/>	      
   <span class="heading9">
   <bean:message key="prompt.emailsalesinvoice"/> </span>&nbsp;		   
   		</td>  
  	</tr>	
	<tr valign="top" bgcolor="#f6f6f6">
		<td height="2" colspan="2"></td>
  	</tr>
  	<tr valign="top" bgcolor="#D0D0D0">
		<td height="1" colspan="2"></td>
  	</tr>
	<tr valign="top" bgcolor="#ffffff">
		<td height="5" colspan="2"></td>
  	</tr>
	
		  	  
<tr>	
	<td>
	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/EmailSalesinvoice">
<html:hidden property="action" value="Email" />


<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999"><tr><td>
	
<table width="100%" border="0" cellspacing="2" cellpadding="2" bgcolor="#ffffff"><tr><td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">


<tr>
    <td width="100%" valign="top" colspan="2">	
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
		<tr>
		  <td class="td7">
		<html:submit styleClass="button1" property="btnSubmit" value="Email" onclick="if (searchWin != null) {searchWin.close();}">
		  <bean:message key="button.email"/>
		</html:submit>
		<html:cancel styleClass="button1" onclick="if (searchWin != null) {searchWin.close();}">
		  <bean:message key="button.cancel"/>
		</html:cancel>					
	</td>
  </tr>		  
	</table>	
	</td>
</tr>	
	
  
   
  <tr>
	    <td width="100%" valign="top">
<table class="body2" style="border-right: 2px #FFFFFF solid" cellpadding="2" cellspacing="1" border="0" width="100%">
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td width="12%" class="body3black"><bean:message key="prompt.date"/>:</td>
	<td width="52%" class="body2"><span class="body3">
	
<bean:write name="ListSihdrForm" property="headerInfo5" format="dd-MMM-yyyy" scope="session"/>
	
	</span>	
	</td>
	<td width="30%" class="body3black">&nbsp;</td>
	<td width="5%" class="body2">&nbsp;</td>
  </tr>
  <tr class="row0">
	<td width="1%" class="body3" valign="top">
		<html:link href="javascript:void(addresscontactSearch('headerInfo3'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search Contact" border="0" align="middle"/>
		</html:link>	
	</td>
	<td class="body3black" valign="top">	
	<bean:message key="heading.emailto"/>:</td>
	<td><span class="body3black"><span class="ftformtext3"><b>
	
<html:textarea property="headerInfo3" rows="2" cols="110" styleClass="ftforminputsmall"/>
	  
	</b></span></span></td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>
  <tr class="row0">
	<td class="body3" valign="top">
		<html:link href="javascript:void(addresscontactSearch('headerInfo4'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search Contact" border="0" align="middle"/>
		</html:link>	
	</td>
	<td class="body3black" valign="top"><bean:message key="heading.emailcc"/>:</td>
	<td><span class="body3black"><span class="ftformtext3"><b>
	
<html:textarea property="headerInfo4" rows="2" cols="110" styleClass="ftforminputsmall"/>	
  
	</b></span></span></td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><bean:message key="heading.emailfrom"/>:</td>
	<td><span class="body3black"><span class="ftformtext3"><b><b>
	
<html:text property="headerInfo2" size="50"  maxlength="50" styleClass="ftforminputsmall"/>
	  
	</b>
	</b></span></span></td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>
  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black"><bean:message key="heading.emailsubject"/>:</td>
	<td><span class="body3black"><span class="ftformtext3"><b>
	
<html:text property="headerInfo1" size="50"  maxlength="50" styleClass="ftforminputsmall"/>
	
	</b></span></span></td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>

  <tr class="row0">
	<td class="body3">&nbsp;</td>
	<td class="body3black" valign="top"><bean:message key="heading.emailtext"/>:</td>
	<td><span class="body3black"><span class="ftformtext3"><b>
	
		<html:textarea rows="4" cols="110"  property="headerInfo6" styleClass="ftforminputsmall"/>  
        	
	</b></span></span></td>
	<td class="body3black">&nbsp;</td>
	<td class="body2">&nbsp;</td>
  </tr>
    
  <tr class="row1">
	<td height="10"></td>
  </tr>
</table>
	</td>
  </tr>


<tr valign="top" bgcolor="#ffffff"><td colspan="5">&nbsp;</td></tr>	

<tr valign="top" bgcolor="#ffffff"><td colspan="5">
       <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
<tr><td class="resultsHeader98"><bean:message key="prompt.attachedsalesinvoicedocuments"/></td></tr>       
          <tr>
            <td><table width="30%"  border="0" cellpadding="0" cellspacing="1" class="resultsBgcolor99">
                <tr>                  
                  <td class="resultsHeader99" width="5%"></td>	
                  <td class="resultsHeader99" width="45%"><bean:message key="heading.docid"/></td>
                  <td class="resultsHeader99" width="50%"><bean:message key="heading.invoiceno"/></td>                  	
                </tr>
                <%
int row=0;
%>
                <logic:iterate id="lineItem" name="ListSihdrForm" property="lineItems">
                  <%
String _class = "tdlghtgry";
if ((row % 2) == 0) _class = "tdlghtgry3"; 
row++;
%>
                  <!-- row1 -->
                  <tr>	
                    <td class="<%= _class %>" align="left" nowrap="nowrap" >
<html:img src="images/icons/icon_document.png" alt="Attached Document" border="0" align="middle"/>
                    </td>												  
                    <td class="<%= _class %>" align="left" nowrap="nowrap">
                    <bean:write name="lineItem" property="sihdrId" filter="true"/>
                    </td>
                    <td class="<%= _class %>" align="left" nowrap="nowrap">
                    <bean:write name="lineItem" property="invoiceno" filter="true"/>
                    </td>                    			
                  </tr>
                  <!-- row2 -->
					<tr><td colspan="3" background="images/border_dotted.gif"></td></tr>				  
                </logic:iterate>
              </table></td>
          </tr>
        </table>		
</td></tr>	        

<tr valign="top" bgcolor="#ffffff"><td colspan="5">&nbsp;</td></tr>	

<tr valign="top" bgcolor="#ffffff"><td colspan="5">
       <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF">
<tr><td class="resultsHeader98"><bean:message key="prompt.selecttoattachstoreddocuments"/></td></tr>        
          <tr>
            <td><table width="50%"  border="0" cellpadding="0" cellspacing="1" class="resultsBgcolor99">
                <tr>
                  <td class="resultsHeader99" width="1%"></td>			
                  <td class="resultsHeader99" width="10%"><bean:message key="heading.orderno"/></td>
                  <td class="resultsHeader99" width="90%"><bean:message key="heading.documentname"/></td>                  
                </tr>
<%
int row2=0;

java.util.Hashtable _ht =
	(java.util.Hashtable)ListSihdrForm.getLineItemsHt();

if (_ht!=null) {
	
for (java.util.Enumeration e2 = _ht.keys(); e2.hasMoreElements();) {

	String _key = (String)e2.nextElement();
	
	java.util.StringTokenizer _st = new java.util.StringTokenizer(_key, "|");	
	String _orderno = "";
	try {_orderno = _st.nextToken();} catch (Exception e) {}
	String _description = "";
	try {_description = _st.nextToken();} catch (Exception e) {}

	com.bureaueye.beacon.model.order.Orderfile _orderfile = (com.bureaueye.beacon.model.order.Orderfile)_ht.get(_key); 

String _class = "tdlghtgry";
if ((row2 % 2) == 0) _class = "tdlghtgry3"; 
row2++;
%>
                  <!-- row1 -->
                  <tr>	
<td class="<%= _class %>" align="left" nowrap="nowrap">				  
<html:multibox property="selectedObjects">
<%= _orderfile.getOrderfileId() %>
</html:multibox>
</td>														  
                    <td class="<%= _class %>" align="left" nowrap="nowrap">
<%= _orderno %>
                    </td>
                    <td class="<%= _class %>" align="left" nowrap="nowrap">
<%= _description %>
                    </td>                    
                  </tr>
                  <!-- row2 -->
					<tr><td colspan="3" background="images/border_dotted.gif"></td></tr>				  
<%
}
}
%>
              </table></td>
          </tr>
        </table>		
</td></tr>	

                    
                    

</table>

</td></tr></table>

</td></tr></table>

</html:form>

</td>
</tr>
</table>


</td>
</tr>

	

</table>

</body>
</html:html>
