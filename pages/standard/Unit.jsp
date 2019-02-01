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
				document.forms[0].action.value == 'View' &&
				 document.forms[0].securitylevel.value != '1'
			) {
				while (i < document.forms[0].elements.length) {
					document.forms[0].elements[i].disabled = true;
					i++;	
				}
				document.forms[0].exitButton.disabled = false;	
				document.forms[0].forwardname.disabled = false;		
				document.forms[0].action.disabled = false;		
			}	
	}
    //]]>
</script>











<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<logic:equal name="UnitForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="UnitForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="UnitForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="UnitForm" property="action"
            scope="request" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>	




</head>


<body onLoad="onLoad();" onUnload="if (searchWin != null) {searchWin.close();}"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
    			<logic:equal name="UnitForm" property="action" scope="request" value="Create">
		    		<bean:message key="unit.title.create"/>
    			</logic:equal>
		    	<logic:equal name="UnitForm" property="action" scope="request" value="Delete">
		      		<bean:message key="unit.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="UnitForm" property="action" scope="request" value="Edit">
		        	<bean:message key="unit.title.edit"/>
     			</logic:equal>	
		    	<logic:equal name="UnitForm" property="action" scope="request" value="View">
		        	<bean:message key="unit.title.view"/>
     			</logic:equal>	                	  
            </span>
<span class="header2">&gt;</span>            
<html:link action="/ListUnit"><span class="header4"><bean:message key="unit.title.list"/></span></html:link>        
          	      						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="2"><html:errors/></td></tr>
  
<html:form action="/SaveUnit" focus="unitkey">
<html:hidden property="action"/>
<html:hidden property="unitId"/>
<html:hidden property="readonly"/>
<html:hidden property="thleak"/>
<html:hidden property="tmdmax"/>
<html:hidden property="rvalvac"/>
<html:hidden property="ssurarap"/>
<html:hidden property="ssurara"/>
<html:hidden property="teucount"/>
<html:hidden property="tranfro"/>
<html:hidden property="stackno"/>
<html:hidden property="tranto"/>
<html:hidden property="stackw"/>
<html:hidden property="shdepms"/>
<html:hidden property="shdepss"/>
<html:hidden property="mfprice"/>
<html:hidden property="rvalprs"/>
<html:hidden property="allocnumber"/>
<html:hidden property="capcm"/>
<html:hidden property="rvalvacp"/>
<html:hidden property="maxtrips"/>
<html:hidden property="movelocationkey"/>
<html:hidden property="moveaddrkey"/>
<html:hidden property="moveproductkey"/>
<html:hidden property="jobmovlocationkey"/>
<html:hidden property="movests"/>
<html:hidden property="invsts"/>
<html:hidden property="movedatedd"/>
<html:hidden property="movedatemm"/>
<html:hidden property="movedateyyyy"/>
<html:hidden property="jobmovdatedd"/>
<html:hidden property="jobmovdatemm"/>
<html:hidden property="jobmovdateyyyy"/>
<html:hidden property="moveref"/>
<html:hidden property="jobmovref"/>
<html:hidden property="jobmovvessel"/>	
        
        
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
    
							<logic:equal name="UnitForm" property="action"  scope="request" value="Delete">  
 
				        	<tr><td class="label1" colspan="3">General</td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%" colspan="2">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.unitnumber"/>:</td></tr>
							    		<tr><td class="label2">
                                        <html:text property="unitkey" size="20" maxlength="10" disabled="true" styleClass="forminput1"/>
                                        <html:hidden property="unitkey"/>
                                        </td></tr>
								    </table>
							    </td>
						    </tr>
    
						</logic:equal>			
    
          
				        	<logic:notEqual name="UnitForm" property="action"  scope="request" value="Delete"> 
 
								<tr><td class="label1" colspan="3">General</td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.unitnumber"/>:</td></tr>
              						<tr><td class="label2">
		  <c:if test="${UnitForm.action == 'Create'}">
        	<html:text property="unitkey" size="30" maxlength="20" styleClass="forminput1"/>
		  </c:if>
		  <c:if test="${UnitForm.action != 'Create'}">
        	<html:text property="unitkey" size="30" disabled="true" maxlength="20" styleClass="forminput1"/>
			<html:hidden property="unitkey"/>			
		  </c:if>	                                    
                                    </td></tr>
    
    
             						<tr><td class="label2"><bean:message key="prompt.manufacturedate"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="mfdatedd" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="mfdatemm" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="mfdateyyyy" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select> 
                                    </td></tr>

             						<tr><td class="label2"><bean:message key="prompt.manufacturenumber"/>:</td></tr>
              						<tr><td class="label2">
                                   <html:text property="mfnum" size="20" maxlength="20" styleClass="forminput1"/>
                                    </td></tr>    
                                    
             						<tr><td class="label2"><bean:message key="prompt.manufacturerlocation"/>:</td></tr>
              						<tr><td class="label2">
<html:select property="manuflocationkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>
		</html:select> 
                                    </td></tr>                                              
                      
             						<tr><td class="label2"><bean:message key="prompt.owner"/>:</td></tr>
              						<tr><td class="label2">
<html:select property="ownerkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaowner"/></html:option>
			<html:options collection="owners" property="addrkey" labelProperty="longLabel"/>
		</html:select> 
                                    </td></tr>   
                                               
             						<tr><td class="label2"><bean:message key="prompt.imo"/>:</td></tr>
              						<tr><td class="label2">
<html:text property="imokey" size="20" maxlength="20" styleClass="forminput1"/>
                                    </td></tr> 

             						<tr><td class="label2"><html:checkbox property="xinactive" />&nbsp;<bean:message key="prompt.inactive"/></td></tr>
              						<tr><td class="label2">
                                    </td></tr> 

             						<tr><td class="label2"><html:checkbox property="foodgrad" />&nbsp;<bean:message key="prompt.foodgrade"/></td></tr>
              						<tr><td class="label2">
                                    </td></tr> 
                                                                                                                                                                      
								</table>
    						</td>
						    </tr>
     					
                            
                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.equipmentparameters"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                                                                                                                                                   
              					<tr><td class="label2">
		<html:select property="eqpkeyp1" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp1s" property="id.codekey" labelProperty="descr"/>
		</html:select>
                                </td></tr>
                                          
              					<tr><td class="label2">
		<html:select property="eqpkeyp2" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp2s" property="id.codekey" labelProperty="descr"/>
		</html:select>
                                </td></tr>
                                
              					<tr><td class="label2">
		<html:select property="eqpkeyp3" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp3s" property="id.codekey" labelProperty="descr"/>
		</html:select>
                                </td></tr>
                                
              					<tr><td class="label2">
		<html:select property="eqpkeyp4" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp4s" property="id.codekey" labelProperty="descr"/>
		</html:select>
                                </td></tr>
                                                                                                                                                                   					<tr><td class="label2">
		<html:select property="eqpkeyp5" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp5s" property="id.codekey" labelProperty="descr"/>
		</html:select>
                                </td></tr>
                                                                                        
     						</table>
					    </td>
        					</tr>
                                           

                            
                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.dimensions"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr>
                                <td class="label2"></td>
                                <td class="label2"><bean:message key="prompt.mm"/></td>
                                <td class="label2"><bean:message key="prompt.ftin"/></td>                                 
                                </tr>
                                
                                 
<tr>
<td class="label2"><bean:message key="prompt.length"/>:</td>
<td class="label2">
<html:text property="length" size="10" maxlength="10" styleClass="forminput1"/>
</td>                       
<td class="label2">
<html:text property="lengthf" size="10" maxlength="10" styleClass="forminput1"/>&nbsp;'&nbsp;
<html:text property="lengthi" size="10" maxlength="10" styleClass="forminput1"/>&nbsp;"
</td>    
</tr> 

<tr>
<td class="label2"><bean:message key="prompt.width"/>:</td>
<td class="label2">
<html:text property="width" size="10" maxlength="10" styleClass="forminput1"/>
</td>                       
<td class="label2">
								 <html:text property="widthf" size="10" maxlength="10" styleClass="forminput1"/>&nbsp;'&nbsp;
								 <html:text property="widthi" size="10" maxlength="10" styleClass="forminput1"/>&nbsp;"
</td>    
</tr>     

<tr>
<td class="label2"><bean:message key="prompt.height"/>:</td>
<td class="label2">
<html:text property="height" size="10" maxlength="10" styleClass="forminput1"/>
</td>                       
<td class="label2">
								 <html:text property="heightf" size="10" maxlength="10" styleClass="forminput1"/>&nbsp;'&nbsp;
								 <html:text property="heighti" size="10" maxlength="10" styleClass="forminput1"/>&nbsp;"
</td>    
</tr>                                                                                                                                          						
                                                                              
     						</table>
					    </td>
        					</tr>



                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.capacity"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr>
                                <td class="label2"></td>
                                <td class="label2"><bean:message key="prompt.mm"/></td>
                                <td class="label2"><bean:message key="prompt.ftin"/></td>  
                                <td class="label2"><bean:message key="prompt.ftin"/></td>                                                              
                                 </tr>
                                
                                 
<tr>
<td class="label2">&nbsp;</td>
<td class="label2">
					<html:text property="caplit" size="10" maxlength="10" styleClass="forminput1"/>
</td>                       
<td class="label2">
				 	<html:text property="capimpg" size="10" maxlength="10" styleClass="forminput1"/>
</td> 
<td class="label2">
					<html:text property="capusg" size="10" maxlength="10" styleClass="forminput1"/>
</td>    
</tr> 
                                                                                                                                         						
                                                                              
     						</table>
					    </td>
        					</tr>
                            

                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.materials"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
 
               					<tr><td class="label2">
<bean:message key="prompt.shell"/>:
                                </td></tr>                                <tr><td class="label2">
				 <html:text property="matrils" size="15" maxlength="20" styleClass="forminput1"/>
                                </td></tr>
                                          
               					<tr><td class="label2">
<bean:message key="prompt.head"/>:
                                </td></tr>                                
                                <tr><td class="label2">
				 <html:text property="headmat" size="15" maxlength="20" styleClass="forminput1"/>
                                </td></tr>

               					<tr><td class="label2">
<bean:message key="prompt.shelldomethickness"/>:
                                </td></tr>                                
                                <tr><td class="label2">
				 <html:text property="shthick" size="10" maxlength="10" styleClass="forminput1"/>&nbsp; / 
				 <html:text property="dmthick" size="10" maxlength="10" styleClass="forminput1"/>&nbsp;<bean:message key="prompt.mm"/>
                                </td></tr>
                                                                                                                        
     						</table>
					    </td>
        					</tr>
                            


                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.pressures"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
 
               					<tr><td class="label2">
<bean:message key="prompt.tankwork"/>:
                                </td></tr>                                <tr><td class="label2">
				 <html:text property="tkwork" size="10" maxlength="10" styleClass="forminput1"/>&nbsp;<bean:message key="prompt.bar"/>&nbsp;
				 <html:text property="tkworkp" size="10" maxlength="10" styleClass="forminput1"/>&nbsp;<bean:message key="prompt.psi"/>
                                </td></tr>
                                          
               					<tr><td class="label2">
<bean:message key="prompt.tanktest"/>:
                                </td></tr>                                
                                <tr><td class="label2">
				 <html:text property="tktest" size="10" maxlength="10" styleClass="forminput1"/>&nbsp;<bean:message key="prompt.bar"/>&nbsp;
				 <html:text property="tktestp" size="10" maxlength="10" styleClass="forminput1"/>&nbsp;<bean:message key="prompt.psi"/>
                                </td></tr>
                                                                                                                        
     						</table>
					    </td>
        					</tr>
                                                                                                               



                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.temperatures"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
 
               					<tr><td class="label2">
<bean:message key="prompt.design"/>:
                                </td></tr>                                <tr><td class="label2">
				 <html:text property="tdesmin" size="10" maxlength="10" styleClass="forminput1"/>&nbsp;-&nbsp;
				 <html:text property="tdesmax" size="10" maxlength="10" styleClass="forminput1"/>&nbsp;<bean:message key="prompt.celcius"/>&nbsp;
				 <html:text property="tdesminf" size="10" maxlength="10" styleClass="forminput1"/>&nbsp;-&nbsp;
				 <html:text property="tdesmaxf" size="10" maxlength="10" styleClass="forminput1"/>&nbsp;<bean:message key="prompt.fahrenheit"/>
                                </td></tr>
                                          
               					<tr><td class="label2">
<bean:message key="prompt.maximumcargo"/>:
                                </td></tr>                                
                                <tr><td class="label2">
				 <html:text property="tmaxcar" size="10" maxlength="10" styleClass="forminput1"/>&nbsp;<bean:message key="prompt.celcius"/>&nbsp;
				 <html:text property="tmaxcarf" size="10" maxlength="10" styleClass="forminput1"/>&nbsp;<bean:message key="prompt.fahrenheit"/>
                                </td></tr>
                                                                                                                        
     						</table>
					    </td>
        					</tr>
                                                                                                                                                     
                       		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.capacity"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr>
                                <td class="label2"></td>
                                <td class="label2"><bean:message key="prompt.kgs"/></td>
                                <td class="label2"><bean:message key="prompt.lbs"/></td>  
                                <td class="label2"></td>                                                              
                                 </tr>
                                
                                 
<tr>
<td class="label2"><bean:message key="prompt.tare"/>:</td>
<td class="label2">
				 <html:text property="tare" size="10" maxlength="10" styleClass="forminput1"/>
</td>                       
<td class="label2">
								 <html:text property="tarel" size="10" maxlength="10" styleClass="forminput1"/>
</td> 
<td class="label2">
</td>    
</tr> 

<tr>
<td class="label2"><bean:message key="prompt.maximumpayload"/>:</td>
<td class="label2">
												 <html:text property="payload" size="10" maxlength="10" styleClass="forminput1"/>
</td>                       
<td class="label2">
												 <html:text property="payloadl" size="10" maxlength="10" styleClass="forminput1"/>
</td> 
<td class="label2">
</td>    
</tr>  

<tr>
<td class="label2"><bean:message key="prompt.gross"/>:</td>
<td class="label2">
												 <html:text property="gross" size="10" maxlength="10" styleClass="forminput1"/>
</td>                       
<td class="label2">
												 <html:text property="grossl" size="10" maxlength="10" styleClass="forminput1"/>
</td> 
<td class="label2">
</td>    
</tr> 
                                                                                                                                        						
                                                                              
     						</table>
					    </td>
        					</tr>
                            
  
  
  
                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.approvals"/></td></tr>  

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="50%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    

             						<tr><td class="label2"><html:checkbox property="aar" />&nbsp;<bean:message key="prompt.aar"/></td></tr>
              						<tr><td class="label2">
                                    </td></tr> 

             						<tr><td class="label2"><html:checkbox property="asme" />&nbsp;<bean:message key="prompt.asme"/></td></tr>
              						<tr><td class="label2">
                                    </td></tr> 
                                                                                                                                                                  						<tr><td class="label2"><html:checkbox property="csc" />&nbsp;<bean:message key="prompt.csc"/></td></tr>
              						<tr><td class="label2">
                                    </td></tr>
                                    
             						<tr><td class="label2"><html:checkbox property="usdot" />&nbsp;<bean:message key="prompt.usdot"/></td></tr>
              						<tr><td class="label2">
                                    </td></tr>
                                    
             						<tr><td class="label2"><html:checkbox property="ukdot" />&nbsp;<bean:message key="prompt.ukdot"/></td></tr>
              						<tr><td class="label2">
                                    </td></tr>
                                    
             						<tr><td class="label2"><html:checkbox property="adr" />&nbsp;<bean:message key="prompt.adr"/></td></tr>
              						<tr><td class="label2">
                                    </td></tr>
                                   
             						<tr><td class="label2"><html:checkbox property="tir" />&nbsp;<bean:message key="prompt.tir"/></td></tr>
              						<tr><td class="label2">
                                    </td></tr>
                                    
             						<tr><td class="label2"><html:checkbox property="un" />&nbsp;<bean:message key="prompt.un"/></td></tr>
              						<tr><td class="label2">
                                    </td></tr>                                                                                                                                      
								</table>
    						</td>

                            	<td width="50%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    

             						<tr><td class="label2"><html:checkbox property="rid" />&nbsp;<bean:message key="prompt.rid"/></td></tr>
              						<tr><td class="label2">
                                    </td></tr> 

             						<tr><td class="label2"><html:checkbox property="ctc" />&nbsp;<bean:message key="prompt.ctc"/></td></tr>
              						<tr><td class="label2">
                                    </td></tr> 
                                                                                                                                                                  						<tr><td class="label2"><html:checkbox property="imo" />&nbsp;<bean:message key="prompt.imo"/></td></tr>
              						<tr><td class="label2">
                                    </td></tr>
                                    
             						<tr><td class="label2"><html:checkbox property="uic" />&nbsp;<bean:message key="prompt.uic"/></td></tr>
              						<tr><td class="label2">
                                    </td></tr>
                                    
             						<tr><td class="label2"><html:checkbox property="bam" />&nbsp;<bean:message key="prompt.bam"/></td></tr>
              						<tr><td class="label2">
                                    </td></tr>
                                    
             						<tr><td class="label2"><html:checkbox property="dot51" />&nbsp;<bean:message key="prompt.dot51"/></td></tr>
              						<tr><td class="label2">
                                    </td></tr>

             						<tr><td class="label2"><html:checkbox property="dir" />&nbsp;<bean:message key="prompt.dir"/></td></tr>
              						<tr><td class="label2">
                                    </td></tr>
                                    
             						<tr><td class="label2"><html:checkbox property="att" />&nbsp;<bean:message key="prompt.att"/></td></tr>
              						<tr><td class="label2">
                                    </td></tr>                                                                                                                                                                          
								</table>
    						</td>
                                                        
                            
						    </tr>
                            
   
                        		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3">Latest Movement</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
 
               					<tr><td class="label2">
<bean:message key="prompt.movementlocation"/>:
                                </td></tr>                                <tr><td class="label2">
<html:select property="movelocationkey" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>
		</html:select>
                                </td></tr>

              					<tr><td class="label2">
<bean:message key="prompt.movementstatus"/>:
                                </td></tr>                                <tr><td class="label2">
		<html:select property="movests" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectastatus"/></html:option>
			<html:options collection="movestatuss" property="id.codekey" labelProperty="descr"/>
		</html:select>	
                                </td></tr>
                                
                                <tr><td class="label2">
<bean:message key="prompt.movementref"/>:
                                </td></tr>                                
                                <tr><td class="label2">
<html:text property="moveref" disabled="true" size="20" maxlength="20" styleClass="ftforminputsmall"/>	
                                </td></tr>
                                
                                <tr><td class="label2">
<bean:message key="prompt.movementdate"/>:
                                </td></tr>                                
                                <tr><td class="label2">
		<html:select property="movedatedd" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="movedatemm" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="movedateyyyy" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select> 
		&nbsp;<html:text property="movetime" disabled="true" size="5" maxlength="5" styleClass="ftforminputsmall"/>  	
                                </td></tr>                                                                                                                                                    
     						</table>
					    </td>
        					</tr>


                            
                         		<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3">Operator Latest Movement</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
 
               					<tr><td class="label2">
<bean:message key="prompt.movementlocation"/>:
                                </td></tr>                                <tr><td class="label2">
<html:select property="jobmovlocationkey" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>
		</html:select>
                                </td></tr>

              					<tr><td class="label2">
<bean:message key="prompt.inventorystatus"/>:
                                </td></tr>                                <tr><td class="label2">
		<html:select property="invsts" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectastatus"/></html:option>
			<html:options collection="statuscodes" property="id.codekey" labelProperty="descr"/>
		</html:select>
                                </td></tr>
                                
                                <tr><td class="label2">
<bean:message key="prompt.movementref"/>:
                                </td></tr>                                
                                <tr><td class="label2">
<html:text property="jobmovref" disabled="true" size="20" maxlength="20" styleClass="ftforminputsmall"/>	
                                </td></tr>
                                
                                <tr><td class="label2">
<bean:message key="prompt.movementvessel"/>:
                                </td></tr>                                
                                <tr><td class="label2">
<html:text property="jobmovvessel" disabled="true" size="20" maxlength="20" styleClass="ftforminputsmall"/> 	
                                </td></tr>
                                
                                <tr><td class="label2">
<bean:message key="prompt.movementdate"/>:
                                </td></tr>                                
                                <tr><td class="label2">
		<html:select property="jobmovdatedd" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="jobmovdatemm" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="jobmovdateyyyy" disabled="true" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select> 
		&nbsp;<html:text property="jobmovtime" disabled="true" size="5" maxlength="5" styleClass="ftforminputsmall"/> 	
                                </td></tr>                                                                                                                                                    
     						</table>
					    </td>
        					</tr>                                                                                                                                                     
                            
<%--                            
                                <tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.testcertificates"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
 
               					<tr><td class="label2">
                                </td></tr>     
                                <tr><td class="label2">

                                </td></tr>
                                                                                                                                                    
     						</table>
					    </td>
        					</tr>



                                <tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="3"><bean:message key="prompt.calibrationcharts"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%" colspan="2">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
 
               					<tr><td class="label2">
                                </td></tr>     
                                <tr><td class="label2">

                                </td></tr>
                                                                                                                                                    
     						</table>
					    </td>
        					</tr>                            
                                                
--%>                                                
                                                                                                                                
           					</logic:notEqual>
              
              
              
							<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="3">
    
				        <div class="btnPane"> 
				            <logic:equal name="UnitForm" property="action"   scope="request" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="UnitForm" property="action"   scope="request" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="UnitForm" property="action"   scope="request" value="Edit">
				                <button id="buttonSave" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.save"/></span>
				                </button>  
          					</logic:equal>
							<logic:notEqual name="UnitForm" property="action"   scope="request" value="View">                              
			                <button id="buttonCancel" class="btn btnFF" type="submit" onClick="bCancel=true;" name="org.apache.struts.taglib.html.CANCEL">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.cancel"/></span>
			                </button>  
          					</logic:notEqual>                              
							<logic:equal name="UnitForm" property="action"   scope="request" value="View">                            
								<button id="exitButton" class="btn btnFF" type="button"  onclick="document.unit.href='ListUnit.do'">
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
