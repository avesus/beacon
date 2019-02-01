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


<!-- tell jsp to use the user bean -->
<jsp:useBean
  id="user"
  class="com.bureaueye.beacon.model.standard.User"
  scope="session"
/>

<app:checkLogon/>


<html:html>
<head>
<title>Job Actual Vs Estimate Report</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<script type="text/javascript">
<!--
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
//-->
</script>


<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/ajaxV2.js"></script> 
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/order/ListOrderhdrSearchListG2codeAjax.js"></script>
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/order/ListOrderhdrSearchListG3codeAjax.js"></script>
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/order/ListOrderhdrSearchListG4codeAjax.js"></script>

<script language="javascript">
<!--
function check() {	

	if (document.forms[0].elements['searchString6'].value == "") {
		alert("Base Ccy must be entered");
		document.forms[0].elements['searchString6'].focus();
		return false;
	}
	
}
// -->
</script>


</head>


<body> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<%-- HEADER -----------------%>
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>

<%-- BREADCRUMBS -----------------%> 
<tr>
	<td class="tdwht"><span class="heading2">     
		<strong>Job Actual Vs Estimate Report</strong> 
		</span>					
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>
<%-- BREADCRUMBS -----------------%> 


<tr>
<%-- SIDEBAR -----------------%>

	
<%-- BODY -----------------%>	
	<td>
	
		<div style="OVERFLOW:auto; width:850px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ReportCashSettlement" focus="searchDate1">
<html:hidden property="gotoPage" />


<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	

<table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>

    <table border="0" cellpadding="1" cellspacing="2" width="100%" bgcolor="#EEEEEE">
      <tr>
        <td colspan="3" valign="middle"><h1 class="underline mtb0">
          <INPUT name="reportButton" border="0" type="image" id="reportButton" src="/beacon/images/buttons/btn_report.png" align="bottom" 
onMouseOut="MM_swapImgRestore();" 
onMouseOver="MM_swapImage('reportButton','','/beacon/images/buttons/btn_report.png','reportButton','','/beacon/images/buttons/btn_report_over.png',1);" onClick="return check();"/>
&nbsp;
        </h1></td>
      </tr>
      <tr>
        <td><img src="images/spacer.gif" alt="" height="10"/></td>
        <td>&nbsp;</td>
      </tr>


      <tr>
        <td align="left" class="text7"><bean:message key="prompt.loadingdate"/>
          :</td>
        <td rowspan="13" align="left" class="text7" valign="top">
        <table width="100%"  border="0" cellpadding="0" cellspacing="1">
          <tr>
            <td width="40%" class="text7">
              <bean:message key="prompt.company"/>
              : </td>
              </tr>
              <tr>
            <td width="60%">
            <html:select property="searchString7" styleClass="ftforminputsmall">
              <html:options collection="companys" property="compid" labelProperty="name"/>
            </html:select></td>
          </tr>
          <tr>
            <td width="40%" class="text7">
              <bean:message key="prompt.department"/>
              : </td>
              </tr>
              <tr>
            <td width="60%"><html:select property="searchString8" styleClass="ftforminputsmall">
              <html:option value="">- select a Department -</html:option>
              <html:options collection="departments" property="id.codekey" labelProperty="descr"/>
            </html:select></td>
          </tr>
          <tr>
            <td width="40%" class="text7">
              <bean:message key="prompt.activity"/>
              : </td>
              </tr>
              <tr>
            <td width="60%"><html:select property="searchString9" styleClass="ftforminputsmall">
              <html:option value="">- select a Role -</html:option>
              <html:options collection="activitys" property="id.codekey" labelProperty="descr"/>
            </html:select></td>
          </tr>
          <tr>
            <td><img src="images/spacer.gif" height="10" width="1" border="0"/></td>
          </tr>
          <tr>
            <td width="40%" class="text7">
              <bean:message key="prompt.baseccy"/>
              : </td>
              </tr>
              <tr>
            <td width="60%">
            		<html:select property="searchString6" styleClass="ftforminputsmall">
						<html:option value=""><bean:message key="prompt.selectacurrency"/></html:option> 
						<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
					</html:select>	
            </td>
          </tr>
          <tr>
            <td colspan="2"><img src="images/spacer.gif" height="41" width="1" border="0"/></td>
          </tr>
        </table>
        
        
         <table width="100%"  border="0" cellpadding="0" cellspacing="1">       
           <tr>
             <td align="left" class="text7"><bean:message key="prompt.gcodes"/>
               :</td>
             <td align="left" class="text7">&nbsp;</td>
             </tr>
           <tr>
             <td align="left">
               <table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#EEEEEE">
                 <tr>
                   <td align="left" class="text7">&nbsp;
                     <bean:message key="prompt.portloading"/>
                     : </td>
                   </tr>
                 <tr>
                   <td align="left">&nbsp;
                     <html:select property="searchString20" styleClass="ftforminputsmall" onchange="processListG2code21('searchString20','searchString21','searchString22','searchString23');">
                       <html:option value="">
                         <bean:message key="prompt.selectag1code"/>
                         </html:option>
                       <html:options collection="g1codes" property="g1codekey" labelProperty="g1codekey"/>
                       </html:select></td>
                   </tr>
                 <tr>
                   <td align="left">&nbsp;
                     <html:select property="searchString21" styleClass="ftforminputsmall" onchange="processListG3code22('searchString20','searchString21','searchString22','searchString23');">
                       <html:option value="">
                         <bean:message key="prompt.selectag2code"/>
                         </html:option>
                       </html:select></td>
                   </tr>
                 <tr>
                   <td align="left">&nbsp;
                     <html:select property="searchString22" styleClass="ftforminputsmall" onchange="processListG4code23('searchString20','searchString21','searchString22','searchString23');">
                       <html:option value="">
                         <bean:message key="prompt.selectag3code"/>
                         </html:option>
                       </html:select></td>
                   </tr>
                 <tr>
                   <td align="left">&nbsp;
                     <html:select property="searchString23" styleClass="ftforminputsmall">
                       <html:option value="">
                         <bean:message key="prompt.selectag4code"/>
                         </html:option>
                       </html:select></td>
                   </tr>
                 </table>        
               </td>
             <td align="left">&nbsp;</td>
             </tr>
           <tr>
             <td align="left">
               <table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#EEEEEE">
                 <tr>
                   <td align="left" class="text7">&nbsp;
                     <bean:message key="prompt.portdischarge"/>
                     : </td>
                   </tr>
                 <tr>
                   <td align="left">&nbsp;
                     <html:select property="searchString24" styleClass="ftforminputsmall" onchange="processListG2code25('searchString24','searchString25','searchString26','searchString27');">
                       <html:option value="">
                         <bean:message key="prompt.selectag1code"/>
                         </html:option>
                       <html:options collection="g1codes" property="g1codekey" labelProperty="g1codekey"/>
                       </html:select></td>
                   </tr>
                 <tr>
                   <td align="left">&nbsp;
                     <html:select property="searchString25" styleClass="ftforminputsmall" onchange="processListG3code26('searchString24','searchString25','searchString26','searchString27');">
                       <html:option value="">
                         <bean:message key="prompt.selectag2code"/>
                         </html:option>
                       </html:select></td>
                   </tr>
                 <tr>
                   <td align="left">&nbsp;
                     <html:select property="searchString26" styleClass="ftforminputsmall" onchange="processListG4code27('searchString24','searchString25','searchString26','searchString27');">
                       <html:option value="">
                         <bean:message key="prompt.selectag3code"/>
                         </html:option>
                       </html:select></td>
                   </tr>
                 <tr>
                   <td align="left">&nbsp;
                     <html:select property="searchString27" styleClass="ftforminputsmall">
                       <html:option value="">
                         <bean:message key="prompt.selectag4code"/>
                         </html:option>
                       </html:select></td>
                   </tr>
                 </table>          
               </td>
             <td align="left">&nbsp;</td>
             </tr>        
         </table>        </td>
      </tr>
      <tr>
        <td>
          <table border="0" cellpadding="0" cellspacing="1" width="100%">
            <tr>
              <td class="text7">&nbsp;
                <bean:message key="prompt.from"/>
                :</td>
              </tr>
            <tr>
              <td>&nbsp;
                <html:select property="searchDate1dd" styleClass="ftforminputsmall">
                  <html:option value="">
                    <bean:message key="prompt.day"/>
                    </html:option>
                  <html:options collection="days" property="value" labelProperty="label"/>
                  </html:select>
                <html:select property="searchDate1mm" styleClass="ftforminputsmall">
                  <html:option value="">
                    <bean:message key="prompt.month"/>
                    </html:option>
                  <html:options collection="months" property="value" labelProperty="label"/>
                  </html:select>
                <html:select property="searchDate1yyyy" styleClass="ftforminputsmall">
                  <html:option value="">
                    <bean:message key="prompt.year"/>
                    </html:option>
                  <html:options collection="years" property="value" labelProperty="label"/>
                  </html:select></td>
              </tr>
            <tr>
              <td class="text7">&nbsp;
                <bean:message key="prompt.to"/>
                :</td>
              </tr>
            <tr>
              <td>&nbsp;
                <html:select property="searchDate2dd" styleClass="ftforminputsmall">
                  <html:option value="">
                    <bean:message key="prompt.day"/>
                    </html:option>
                  <html:options collection="days" property="value" labelProperty="label"/>
                  </html:select>
                <html:select property="searchDate2mm" styleClass="ftforminputsmall">
                  <html:option value="">
                    <bean:message key="prompt.month"/>
                    </html:option>
                  <html:options collection="months" property="value" labelProperty="label"/>
                  </html:select>
                <html:select property="searchDate2yyyy" styleClass="ftforminputsmall">
                  <html:option value="">
                    <bean:message key="prompt.year"/>
                    </html:option>
                  <html:options collection="years" property="value" labelProperty="label"/>
                  </html:select></td>
              </tr>
          </table></td>
        </tr>  
      
        
      <tr>
        <td><img src="images/spacer.gif" alt="" height="5"/></td>
        </tr>
      
      
      <tr>
        <td align="left" class="text7"><bean:message key="prompt.ordernumber"/>
          :</td>
        </tr>
      <tr>
        <td>
          <table border="0" cellpadding="0" cellspacing="1" width="100%">
            <tr>
              <td>&nbsp;
                <html:text property="searchString5" size="15" maxlength="10" styleClass="ftforminputsmall" onkeypress="return noenter()"/>
                
                </td>
            </tr>
            </table></td>
        </tr>    


      <tr>
        <td><img src="images/spacer.gif" alt="" height="5"/></td>
        </tr>
      
      
      <tr>
        <td align="left" class="text7"><bean:message key="prompt.customer"/>:</td>
        </tr>
      <tr>
        <td align="left" ><html:select property="searchString2" styleClass="ftforminputsmall">
          <html:option value="">
            <bean:message key="prompt.selectacustomer"/>
            </html:option>
          <html:options collection="customers" property="addrkey" labelProperty="shortLabel"/>
        </html:select></td>
        </tr>
 
       <tr>
        <td align="left" class="text7"><bean:message key="prompt.customerref"/>:</td>
        </tr>
      <tr>
        <td align="left" >
          <html:text property="searchString4" size="35" maxlength="40" styleClass="ftforminputsmall" onkeypress="return noenter()"/>
</td>
        </tr>
                    
      <tr>
        <td><img src="images/spacer.gif" alt="" height="5"/></td>
        </tr>



 


      <tr>
        <td><img src="images/spacer.gif" alt="" height="5"/></td>
        </tr>


   <tr><td>
     <table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#EEEEEE">
       <tr>
         <td align="left" class="text7">Output: </td>
         </tr>
       <tr>
         <td align="left" class="text7"><span class="ftformradiosmall">
           <html:radio property="searchString3" value="EXCEL"/>
           Excel </span></td>
         </tr>
       
       
       <tr>
         <td align="left" width="40%" class="text7">Max Results: </td>
         </tr>
       <tr>
         <td align="left" valign="top">
           <html:select property="maxResults" styleClass="ftforminputsmall">
             <html:options collection="pageresults" property="id.codekey" labelProperty="descr"/>                               
             </html:select>   
           </td>
         </tr> 
       
       <tr>
         <td><img src="images/spacer.gif" alt="" height="5"/></td>
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
</table>

</html:form>

</td>
</tr>
</table>

</div>
</td>
</tr>


<%-- FOOTER -----------------%>
<tr>
	<td colspan="2">
<jsp:include page="/pages/footer.jsp" flush="true" />
	</td>
</tr>

</table>

</body>
</html:html>
