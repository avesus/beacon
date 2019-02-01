<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<!--
 *
 * Amendments
 * ----------
 * 
-->
 
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


<script language="JavaScript">
	function screenRefresh() 
	{
	}
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






<script language="JavaScript">
var searchWin;

function refreshData(){
}



function addresscontactSearch(field){
	var url     = 'ListAddresscontactSearch.do?'+
					'action=REFRESH'+
					'&maxResults=999'+
					'&headerInfo1='+
					'&headerInfo2='+				
					'&headerInfo3='+
					field
					;
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=700');
	searchWin.focus();
}
</script>








<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<title><bean:message key="prompt.emailsalesinvoice"/></title>


</head>


<body onLoad="onLoad();"> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<tr><td><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1"><td>
<span class="header2"><bean:message key="prompt.emailsalesinvoice"/></span>
<span class="header2">&gt;</span>
<html:link action="/ListSihdr"><span class="header4"><bean:message key="sihdr.title.list"/></span></html:link>        
  </td></tr>  
<tr valign="top" bgcolor="#CCCCCC"><td height="1"></td></tr>
<!-- BREADCRUMBS ----------------->
	
    



<!--<tr><td><img src="images/spacer.gif" height="75"/></td></tr>-->
        	  	  
<tr><td>
<div style="OVERFLOW:auto; width:1000px; height:650px; position:relative;">	

    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">

          
		<tr><td colspan="2">
            <html:messages id="error" name="APP_ERROR_KEY" header="errors.header" footer="errors.footer">
              <bean:message key="errors.prefix"/>
              <bean:write name="error"/>
              <bean:message key="errors.suffix"/>
            </html:messages>
            <html:messages id="msg" name="APP_INFORMATION_KEY" header="messages.header" footer="messages.footer">
              <bean:message key="messages.prefix"/>
              <bean:write name="msg"/>
              <bean:message key="messages.suffix"/>
            </html:messages>                
        </td></tr>

    
<html:form action="/EmailSalesinvoice">
<html:hidden property="action" value="Email" />
	
    
    			<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
      
				<tr><td colspan="2">
					<div class="btnPane3">	 
                <button class="btn btnFF" type="submit" name="btnSubmit" value="Email" >                 
        			<img class=" IM Z-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
			        <span><bean:message key="button.email"/></span>
				</button>  
                           
				<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListSihdr.do'">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.exit"/></span>
			    </button>                                                  
					</div> 
				</td></tr>
 


				<tr><td>
				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
  
        


<!-- EMAIL DETAILS ----------------->                            	                                 
<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
                                                         
<tr><td class="label1" colspan="3"><bean:message key="prompt.email"/></td></tr>

<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    							
                            	<td colspan="2">               
                   
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
  
<tr>
	<td width="10%">
        	<div class="btnPane3">	
			<button id="addButton" class="btn btnFF" type="button" onClick="javascript:void(addresscontactSearch('headerInfo3'))">
        		<img class=" IM2 Searchadd-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        		<span>To</span>
        	</button> 
        </div>
	</td>
	<td class="label2" width="90%"><html:textarea property="headerInfo3" rows="2" cols="110" styleClass="forminput1"/></td>
</tr>  
<tr>
	<td>
    	<div class="btnPane3">	
			<button id="addButton" class="btn btnFF" type="button" onClick="javascript:void(addresscontactSearch('headerInfo4'))">
        		<img class=" IM2 Searchadd-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        		<span>Cc</span>
        	</button> 
        </div>
	</td>
	<td class="label2"><html:textarea property="headerInfo4" rows="2" cols="110" styleClass="forminput1"/></td>
</tr>

<tr>
	<td class="label2"><bean:message key="heading.emailfrom"/></td>
	<td class="label2"><html:text property="headerInfo2" size="50"  maxlength="50" styleClass="forminput1"/></td>
  </tr>
<tr>
	<td class="label2"><bean:message key="heading.emailsubject"/></td>
	<td class="label2"><html:text property="headerInfo1" size="50"  maxlength="50" styleClass="forminput1"/></td>
</tr> 
<tr>
	<td class="label2" valign="top"><bean:message key="heading.emailtext"/></td>
	<td class="label2"><html:textarea property="headerInfo6" rows="10" cols="110" styleClass="forminput1"/></td>
</tr>
  
</table>
								
    							</td>                            
						    </tr>
<!-- EMAIL DETAILS ----------------->

 
 
 
 <!-- ATTACHED INVOICES ----------------->
<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
                                                         
<tr><td class="label1" colspan="3"><bean:message key="prompt.attachedsalesinvoicedocuments"/></td></tr>
                                
<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="0"/></td>  
       				<td width="100%" colspan="2">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
<td class="column-header3" width="3%">&nbsp;</td>                               
		  						<td class="column-header4" width="47%">              
                    				<span><bean:message key="heading.docid"/></span>
								</td>

		  						<td class="column-header4" width="50%">
							         <span><bean:message key="heading.invoiceno"/></span>                                                           
								</td>
                                                    

							</tr>

<logic:notEmpty name="ListSihdrForm" property="lineItems">
                
<%int row=0;%>			
                <logic:iterate id="lineItem" name="ListSihdrForm" property="lineItems">
                            
<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";%>      
<%row++;%>	  
			
<!-- row1 -->            
		<tr>
									<td class="<%= _class %>" align="center" nowrap>
								
<html:img src="images/icons/icon_document.png" alt="Attached Document" border="0" align="middle"/>
                	
                                    </td>         
									<td class="<%= _class %>" nowrap valign="top">
                    <bean:write name="lineItem" property="sihdrId" filter="true"/>
                                    </td> 
									<td class="<%= _class %>" nowrap valign="top">
                    <bean:write name="lineItem" property="invoiceno" filter="true"/>							
                        </td>                                       
                                                                                                             
								</tr>
                                  
	</logic:iterate>

</logic:notEmpty> 
   
            			</table>
					</td>
				</tr>                  
 <!-- ATTACHED INVOICES ----------------->    



 <!-- ATTACHED STORED DOCUMENTS ----------------->
<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
                                                         
<tr><td class="label1" colspan="3"><bean:message key="prompt.selecttoattachstoreddocuments"/></td></tr>
                                
<tr>
					<td><html:img src="images/spacer.gif" border="0" width="1" height="0"/></td>  
       				<td width="100%" colspan="2">   
 						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
<td class="column-header3" width="3%">&nbsp;</td>                               
		  						<td class="column-header4" width="17%">              
                    				<span><bean:message key="heading.orderno"/></span>
								</td>

		  						<td class="column-header4" width="80%">
							         <span><bean:message key="heading.documentname"/></span>                                                           
								</td>
                                                    

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

String _class = "column-cell1";if ((row2 % 2) == 0) _class = "column-cell2";

row2++;
%>
                            
    
  
			
<!-- row1 -->            
		<tr>
									<td class="<%= _class %>" align="center" nowrap>
								
<html:multibox property="selectedObjects">
<%= _orderfile.getOrderfileId() %>
</html:multibox>
                	
                                    </td>         
									<td class="<%= _class %>" nowrap valign="top">
<%= _orderno %>
                                    </td> 
									<td class="<%= _class %>" nowrap valign="top">
<%= _description %>							
                        </td>                                       
                                                                                                             
								</tr>
                                  
<%
}
}
%>
   
            			</table>
					</td>
				</tr>                  
 <!-- ATTACHED INVOICES SELECTION ----------------->   
 
 
                                     
                                          
							<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>  


					</table>
				</td></tr>

</html:form>

</table>

</div>
</td></tr>

<tr><td><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

</table>

</body>
</html:html>
