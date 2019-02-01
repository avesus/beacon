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


<html:html>


<script language="JavaScript">
var searchWin;

function refreshData(){
	var url     = 'EditMail.do';
	window.location.href = url;
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
<title>Email Attachments</title>





</head>


<body onUnload="if (searchWin != null) {searchWin.close()}">  

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<%--<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">Email Attachments</span>      						
		</td></tr>  
		<tr bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->--%>
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="2"><html:errors/></td></tr>
  
<html:form action="/SaveTrackMail"> 
<html:hidden property="action"/> 
        
        
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
        

 
							<tr><td class="label1" colspan="2">Email Attachments</td></tr>

							<tr><td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            <td width="100%">     
                            
                            
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
  
<tr>
	<td width="10%">
        	<div class="btnPane3">	
			<button id="addButton" class="btn btnFF" type="button" onClick="javascript:void(addresscontactSearch('mailto'))">
        		<img class=" IM2 Searchadd-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        		<span>TO</span>
        	</button> 
        </div>
	</td>
	<td class="label2" width="90%"><html:textarea property="mailto" rows="2" cols="110" styleClass="forminput1"/></td>
</tr>  
<tr>
	<td>
    	<div class="btnPane3">	
			<button id="addButton" class="btn btnFF" type="button" onClick="javascript:void(addresscontactSearch('mailcc'))">
        		<img class=" IM2 Searchadd-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        		<span>CC</span>
        	</button> 
        </div>
	</td>
	<td class="label2"><html:textarea property="mailcc" rows="2" cols="110" styleClass="forminput1"/></td>
</tr>
<tr>
	<td>
        	<div class="btnPane3">	
			<button id="addButton" class="btn btnFF" type="button" onClick="javascript:void(addresscontactSearch('mailbcc'))">
        		<img class=" IM2 Searchadd-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        		<span>BCC</span>
        	</button> 
	</td>
	<td class="label2"><html:textarea property="mailbcc" rows="2" cols="110" styleClass="forminput1"/></td>
  </tr>
<tr>
	<td class="label2">FROM</td>
	<td class="label2"><html:text property="mailfrom" size="50"  maxlength="50" styleClass="forminput1"/></td>
  </tr>
<tr>
	<td class="label2">SUBJECT</td>
	<td class="label2"><html:text property="mailsubject" size="50"  maxlength="50" styleClass="forminput1"/></td>
</tr> 
<tr>
	<td class="label2" valign="top">TEXT</td>
	<td class="label2"><html:textarea property="mailtext" rows="10" cols="110" styleClass="forminput1"/></td>
</tr>
  
</table>
                            
    						</td>
					    </tr>
              
    
							<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
      
		    				<tr>
        			<td colspan="2">
    
	<div class="btnPane"> 
 
			<button id="buttonEmail" class="btn btnFF" type="submit">
        		<img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        		<span><bean:message key="button.email"/></span>
        	</button>      

			<button id="buttonCancel" class="btn btnFF" type="submit" onClick="bCancel=true;" name="org.apache.struts.taglib.html.CANCEL">
        		<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        		<span><bean:message key="button.cancel"/></span>
        	</button>                            
 	</div>				        
                 
      				</td>
				</tr>
    
</html:form>
    
    				</table>

				</div>

			</td>
		</tr>

		<tr><td colspan="2"><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

	</table>

</body>
</html:html>
