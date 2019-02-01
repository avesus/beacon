<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!--
 *
 * Amendments
 * ----------
 *
 * NT 2014-01-29 WSI-201311-0003 BEACON LAKER (WSI LINER) - Add 'Copy' function to Sales Invoice module (changes not commented)
 * 
 * NT 2014-07-10 201400029 Modify Zero Units Amount calculation in Order, Quotation and Sales Invoice modules
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
function screenRefresh(){}
</script>



  <script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>
<script language="javascript" type="text/javascript">
//<![CDATA[
	function onLoad() {	
			var i; i=0; 
			if ( 
				document.forms[0].action.value == 'View' 
			) {
				while (i < document.forms[0].elements.length) {
					document.forms[0].elements[i].disabled = true;
					i++;	
				}
				document.forms[0].exitButton.disabled = false;	
				document.forms[0].action.disabled = false;		
			}	
	}
    //]]>
</script>



<script language="JavaScript">
var searchWin;
var typeValue = "UNIT";

function setTypeValue()
{
for (var i=0; i < document.forms[0].chargetype.length; i++)
   {
   if (document.forms[0].chargetype[i].checked)
      {
      typeValue = document.forms[0].chargetype[i].value;
      }
   }
}


function amtCalc() 
{
	var _units = parseFloat(document.forms[0].units.value);
	//if (_units == 0) _units = 1.00;//201400029
	var _rate = parseFloat(document.forms[0].rate.value);

	// 201400029
	if (_units == 0) document.forms[0].chgamt.value = 0.00;	
	else document.forms[0].chgamt.value = (_units*_rate);	
	if (_units == 0) document.forms[0].invoiceamt.value = 0.00;	
	else document.forms[0].invoiceamt.value = (_units*_rate);		
}


</script>




<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<logic:equal name="SidtlForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="SidtlForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="SidtlForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="SidtlForm" property="action"
            scope="request" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>	




</head>


<body onLoad="onLoad();" onUnload="if (searchWin != null) {searchWin.close();}"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td>
  <span class="header2">
	<bean:message key="prompt.docid"/>&nbsp;-&nbsp;<bean:write name="ListSidtlForm" property="headerInfo10" scope="session"/>&nbsp;
</span>      
		    <span class="header2">
    			<logic:equal name="SidtlForm" property="action" scope="request" value="Create">
		    		<bean:message key="sidtl.title.create"/>
    			</logic:equal>
		    	<logic:equal name="SidtlForm" property="action" scope="request" value="Delete">
		      		<bean:message key="sidtl.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="SidtlForm" property="action" scope="request" value="Edit">
		        	<bean:message key="sidtl.title.edit"/>
     			</logic:equal>	
		    	<logic:equal name="SidtlForm" property="action" scope="request" value="View">
		        	<bean:message key="sidtl.title.view"/>
     			</logic:equal>	 
                </span>
                <span class="header2">&gt;</span>               	  

			             
<html:link action="/ListSidtl"><span class="header4"><bean:message key="sidtl.title.list"/></span></html:link>
<span class="header2">&gt;</span>                             
<html:link action="/ListSihdr"><span class="header4"><bean:message key="sihdr.title.list"/></span></html:link>        
     						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:900px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="3"><html:errors/></td></tr>
  
<html:form action="/SaveSidtl" focus="chargekey" onsubmit="return amtCalc();">
	
<html:hidden property="sidtlId"/>
<html:hidden property="sihdrId"/>
<html:hidden property="action"/>
<html:hidden property="invoiceccykey"/>
<html:hidden property="ccykey"/>
<html:hidden property="xrateinv"/>
<html:hidden property="xratebase"/>
<html:hidden property="baseccykey"/>
<html:hidden property="chgamt"/>
<html:hidden property="orderno"/>
<html:hidden property="taxcode"/>
<html:hidden property="invoiceref"/>
<html:hidden property="invoicegroupref"/>
        
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
    
							<logic:equal name="SidtlForm" property="action"  scope="request" value="Delete">  
 
				        	<tr><td class="label1" colspan="3">General</td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%" colspan="2">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.charge"/>:</td></tr>
							    		<tr><td class="label2">
		<html:select property="chargekey" disabled="true" styleClass="inputform1"> 
		<html:option value=""><bean:message key="prompt.selectacharge"/></html:option> 
		<html:options collection="charges" property="chargekey" labelProperty="ldesc"/> 
		</html:select> 		
                                        </td></tr>
                                        
                                                                                
								    </table>
							    </td>
						    </tr>
    
						</logic:equal>			
    
          
				        	<logic:notEqual name="SidtlForm" property="action"  scope="request" value="Delete"> 
 
								<tr><td class="label1" colspan="3">General</td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
							    	<tr><td class="label2"><bean:message key="prompt.charge"/>:</td></tr>
							    	<tr><td class="label2">
		<html:select property="chargekey" styleClass="inputform1"> 
		<html:option value=""><bean:message key="prompt.selectacharge"/></html:option> 
		<html:options collection="charges" property="chargekey" labelProperty="ldesc"/> 
		</html:select>  
                                    </td></tr>
                                                                                                        
									<tr><td class="label2"><bean:message key="prompt.chargetype"/>:</td></tr>
              						<tr><td class="label2">
		<span class="forminput1">
<html:radio property="chargetype" value="UNIT"/><bean:message key="prompt.unit"/>
<html:radio property="chargetype" value="LUMPSUM"/><bean:message key="prompt.lumpsum"/>
<html:radio property="chargetype" value="PTOP"/><bean:message key="prompt.pointtopoint"/>
<html:radio property="chargetype" value="DISTANCE"/><bean:message key="prompt.distance"/>
		</span>	                                  
                                    </td></tr>   
                                                          
								</table>
    						</td>
						    </tr>
     					
                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.invoice"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         							<tr><td class="label2"><bean:message key="prompt.invoiceccy"/>:</td></tr>
              						<tr><td class="label2">
<bean:write property="invoiceccykey" name="SidtlForm" />
              						</td></tr>	 
                                                                                                                                                                         
     						</table>
					    </td>
      	
                                                
        					</tr>
                            

                            
                                                       
                            
                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.tariffdetails"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         							<tr><td class="label2"><bean:message key="prompt.noofunits"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="units" size="20" onblur="amtCalc()" maxlength="20" styleClass="inputform1"/>	
              						</td></tr>	 
                                              

         							<tr><td class="label2"><bean:message key="prompt.unitname"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="uname" size="20"  maxlength="20" styleClass="inputform1"/>
              						</td></tr>

                                    
         							<tr><td class="label2"><bean:message key="prompt.unitrate"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="rate" size="20" maxlength="20" onblur="amtCalc()" styleClass="inputform1"/>	
              						</td></tr>

         							<tr><td class="label2"><bean:message key="prompt.invoiceamt"/>:</td></tr>
              						<tr><td class="label2">
         <html:text property="invoiceamt" size="20" maxlength="20" readonly="true" styleClass="inputform1"/>	
              						</td></tr>
                                                                                                                      
     						</table>
					    </td>
                        
                                                
        					</tr>                                          
                                                                                    


                            
                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.notes"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
              						<tr><td class="label2">
        <html:text property="txt1" size="120" styleClass="ftforminputsmall"/>	                                   
									</td></tr>
		
                                                                                                                      
     						</table>
					    </td>
        					</tr>          



                         		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.additionaldata"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="50%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr><td class="label2">1.</td></tr>
              					<tr><td class="label2">
                                <html:text property="adddata1" size="20" maxlength="100" styleClass="forminput1"/>
                                </td></tr>

         						<tr><td class="label2">2.</td></tr>
              					<tr><td class="label2">
                                <html:text property="adddata2" size="20" maxlength="100" styleClass="forminput1"/>
                                </td></tr>
                                
         						<tr><td class="label2">3.</td></tr>
              					<tr><td class="label2">
                                <html:text property="adddata3" size="20" maxlength="100" styleClass="forminput1"/>
                                </td></tr>                                                                         
                                           
         						<tr><td class="label2">4.</td></tr>
              					<tr><td class="label2">
                                <html:text property="adddata4" size="20" maxlength="100" styleClass="forminput1"/>
                                </td></tr> 
         						<tr><td class="label2">5.</td></tr>
              					<tr><td class="label2">
                                <html:text property="adddata5" size="20" maxlength="100" styleClass="forminput1"/>
                                </td></tr>                                                                                                                                                                                                                 </table>
					    </td>

						       	<td width="50%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr><td class="label2">6.</td></tr>
              					<tr><td class="label2">
                                <html:text property="adddata6" size="20" maxlength="100" styleClass="forminput1"/>
                                </td></tr>

         						<tr><td class="label2">7.</td></tr>
              					<tr><td class="label2">
                                <html:text property="adddata7" size="20" maxlength="100" styleClass="forminput1"/>
                                </td></tr>
                                
         						<tr><td class="label2">8.</td></tr>
              					<tr><td class="label2">
                                <html:text property="adddata8" size="20" maxlength="100" styleClass="forminput1"/>
                                </td></tr>                                                                         
                                           
         						<tr><td class="label2">9.</td></tr>
              					<tr><td class="label2">
                                <html:text property="adddata9" size="20" maxlength="100" styleClass="forminput1"/>
                                </td></tr> 
         						<tr><td class="label2">10.</td></tr>
              					<tr><td class="label2">
                                <html:text property="adddata10" size="20" maxlength="100" styleClass="forminput1"/>
                                </td></tr>                                                                                                                                                                                                                 </table>
					    </td>
                                                
        					</tr> 
                            
                                                        
           					</logic:notEqual>
              
              
              
              
							<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="3">
    
				        <div class="btnPane"> 
				            <logic:equal name="SidtlForm" property="action"   scope="request" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="SidtlForm" property="action"   scope="request" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="SidtlForm" property="action"   scope="request" value="Edit">
				                <button id="buttonSave" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.save"/></span>
				                </button>  
          					</logic:equal>
							<logic:notEqual name="SidtlForm" property="action"   scope="request" value="View">                            
			                	<button id="buttonCancel" class="btn btnFF" type="submit" onClick="bCancel=true;" name="org.apache.struts.taglib.html.CANCEL">
			                    	<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        	<span><bean:message key="button.cancel"/></span>
			                	</button>
          					</logic:notEqual>                             
							<logic:equal name="SidtlForm" property="action"   scope="request" value="View">                            
								<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListSidtl.do'">
			                    	<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        	<span><bean:message key="button.exit"/></span>
					            </button>   
          					</logic:equal>                                                         
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
