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
	}
	
	function navigateTo(forwardName) {
		document.forms[0].forwardname.value=forwardName;
		document.forms[0].submit();		
	}	
    //]]>
</script>


<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />
<link rel="stylesheet" type="text/css" href="css/navigation.css" />


<head>
<logic:equal name="ProductForm" property="action"
            scope="session" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="ProductForm" property="action"
            scope="session" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="ProductForm" property="action"
            scope="session" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	





</head>


<body onLoad="onLoad();"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td colspan="2"><span class="header2">
    			<logic:equal name="ProductForm" property="action" scope="session" value="Create">
		    		<bean:message key="product.title.create"/>
    			</logic:equal>
		    	<logic:equal name="ProductForm" property="action" scope="session" value="Delete">
		      		<bean:message key="product.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="ProductForm" property="action" scope="session" value="Edit">
		        	<bean:message key="product.title.edit"/>
     			</logic:equal>	  
          		&gt;
            </span>
			             
      	  		<html:link action="/ListProduct"><span class="header3"><bean:message key="product.title.list"/></span></html:link>     						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td colspan="2">
	
				<div style="OVERFLOW:auto; width:1000px; height:650px; position:relative;">	




  
<html:form action="/SaveProduct" focus="chemname">
<html:hidden property="action"/>
<html:hidden property="readonly"/>
<html:hidden property="forwardname" value=""/>

<html:hidden property="hazardous"/>
<html:hidden property="eqpidkey"/>
<html:hidden property="eqpidkeyp1"/>
<html:hidden property="eqpidkeyp2"/>
<html:hidden property="eqpidkeyp3"/>
<html:hidden property="eqpidkeyp4"/>
<html:hidden property="eqpidkeyp5"/>
<html:hidden property="eqpidkeyp6"/>
<html:hidden property="eqpidkeyp7"/>
<html:hidden property="eqpidkeyp8"/>
<html:hidden property="eqpidkeyp9"/>
<html:hidden property="eqpidkeyp10"/>

<html:hidden property="dotRegulated"/>
<html:hidden property="hazardousImo"/>
<html:hidden property="productclass"/>
<html:hidden property="industryClass"/>
<html:hidden property="supplieraddrkey"/>
<html:hidden property="emergency1"/>
<html:hidden property="emergency2"/>
<html:hidden property="emergency3"/>
<html:hidden property="email"/>
<html:hidden property="instructions"/>
<html:hidden property="active"/>
<html:hidden property="prodcode"/>

<!--product1-->
<html:hidden property="productkey"/>
<html:hidden property="chemname"/>
<html:hidden property="tradname"/>
<html:hidden property="ldesc"/>
<html:hidden property="fleetgrpkey"/>
<html:hidden property="colourkey"/>
<html:hidden property="prodcatgkey"/>
<html:hidden property="evilsmelling"/>
<html:hidden property="bottomfill"/>
<html:hidden property="heaterpad"/>
<html:hidden property="specgrav"/>
<html:hidden property="minimumCapacity"/>
<html:hidden property="txt"/>

<!--product3-->
<html:hidden property="imdg"/>
<html:hidden property="imdgsc1"/>
<html:hidden property="imdgsc2"/>
<html:hidden property="imdglabel"/>
<html:hidden property="unno"/>
<html:hidden property="icao"/>
<html:hidden property="untcode"/>
<html:hidden property="iataclass"/>
<html:hidden property="imo"/>
<html:hidden property="ems1"/>
<html:hidden property="ems2"/>
<html:hidden property="ems3"/>
<html:hidden property="ems4"/>
<html:hidden property="kemmler"/>
<html:hidden property="mfag"/>
<html:hidden property="hommel"/>
<html:hidden property="ggve"/>
<html:hidden property="ggveref"/>  
<html:hidden property="ggvsclass"/>
<html:hidden property="ggvsref"/>
<html:hidden property="adr"/>
<html:hidden property="adrref"/>
<html:hidden property="rid"/>
<html:hidden property="ridref"/>   
<html:hidden property="dot51only"/>
<html:hidden property="nacode1"/>
<html:hidden property="nacode2"/>
<html:hidden property="hazid"/>
<html:hidden property="harmcode"/>
<html:hidden property="prdid"/>  
<html:hidden property="tramcard"/>
<html:hidden property="cleangrp"/>
<html:hidden property="casnumber"/>
<html:hidden property="packingGroup"/>
<html:hidden property="reachcode"/>
<html:hidden property="intlharmcode"/> 
<html:hidden property="opcl"/>
<html:hidden property="opcu"/>

<!--product4-->
<html:hidden property="dgsflag"/>
<html:hidden property="dgsnotes"/>
<html:hidden property="dgstechnicalname"/>
<html:hidden property="dgsinformation"/>
<html:hidden property="dgscontact1"/>
<html:hidden property="dgsphone1"/>

        

<div id="secondaryNav">
    
    <div class="secNavOuterPane">
    
    <div id="secNavDividerLeft"></div>
    <div id="secNavDividerTitle"></div>
    <div id="secNavDividerRight"></div>
    
<div id="secNavPane">
      
   <div id="General" class="secNavBtn SecNavBg">    
    <span class="secNavBtnSpan">
    <a class="secNavBtnLnk" href="#" title="" onClick="navigateTo('product1');">
    <span class="secNavBtnLnkContent"><img class="secNavBtnLnkIcon MainNavigationSprite General" alt="" title="" src="images/buttons/clear1x1.gif"  /><br />General</span>
    </a>
    </span>
    </div>

    <div id="Measurements" class="secNavBtnSelected HorizontalSprite SecNavBg">   
    <span class="secNavBtnSpan">
    <a class="secNavBtnLnk" href="#" title="" onClick="navigateTo('product2');">
    <span class="secNavBtnLnkContent"><img class="secNavBtnLnkIcon MainNavigationSprite Measurement" alt="" title="" src="images/buttons/clear1x1.gif"  /><br />Temperatures</span>
    </a>
    </span>
    </div>
          
    <div id="Certificate" class="secNavBtn SecNavBg">
    <span class="secNavBtnSpan">
    <a class="secNavBtnLnk" href="#" title="" onClick="navigateTo('product3');">
    <span class="secNavBtnLnkContent">
    <img class="secNavBtnLnkIcon MainNavigationSprite Certficate" alt="" title="" src="images/buttons/clear1x1.gif"  /><br />Classification</span>
    </a>
    </span>
    </div>
    
   <div id="DangerousGoods" class="secNavBtn SecNavBg">
    <span class="secNavBtnSpan">
    <a class="secNavBtnLnk" href="#" title="" onClick="navigateTo('product4');">
    <span class="secNavBtnLnkContent"><img class="secNavBtnLnkIcon MainNavigationSprite Dangerous" alt="" title="" src="images/buttons/clear1x1.gif"  /><br />Dangerous Goods</span>
    </a>
    </span>
    </div>
           
    </div>       
     
    </div>
    
</div>


<div style="position:relative;">


				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="2"><html:errors/></td></tr>
                               
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    	
    
          
				        	<logic:notEqual name="ProductForm" property="action"  scope="session" value="Delete"> 


				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
                            
                             
								<tr><td class="label1" colspan="2">Temperatures&nbsp;<html:select property="tempunit" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.units"/></html:option>
			<html:options collection="tempunits" property="id.codekey" labelProperty="descr"/>	
            </html:select></td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                       
    
             						<tr><td class="label2"><bean:message key="prompt.mintemp"/>:</td></tr>
              						<tr><td class="label2">
<html:text property="mintemp" size="15" maxlength="10" styleClass="forminput1"/>
                                    </td></tr>

             						<tr><td class="label2"><bean:message key="prompt.maxtemp"/>:</td></tr>
              						<tr><td class="label2">
<html:text property="maxtemp" size="15" maxlength="10" styleClass="forminput1"/> 
                                    </td></tr>    
                                    
             						<tr><td class="label2"><bean:message key="prompt.meltingpoint"/>:</td></tr>
              						<tr><td class="label2">
<html:text property="meltp" size="15" maxlength="10" styleClass="forminput1"/>
                                    </td></tr>

             						<tr><td class="label2"><bean:message key="prompt.boilingpoint"/>:</td></tr>
              						<tr><td class="label2">
<html:text property="boilp" size="15" maxlength="10" styleClass="forminput1"/>
                                    </td></tr>   

             						<tr><td class="label2"><bean:message key="prompt.fillingtemp"/>:</td></tr>
              						<tr><td class="label2">
<html:text property="fillt" size="15" maxlength="10" styleClass="forminput1"/>
                                    </td></tr>   
                                    
             						<tr><td class="label2"><bean:message key="prompt.dischargetemp"/>:</td></tr>
              						<tr><td class="label2">
<html:text property="dischgt" size="15" maxlength="10" styleClass="forminput1"/>
                                    </td></tr>                                              

             						<tr><td class="label2"><bean:message key="prompt.flashpoint"/>:</td></tr>
              						<tr><td class="label2">
<html:text property="flashp" size="15" maxlength="10" styleClass="forminput1"/>
                                    </td></tr> 
                                             
             						<tr><td class="label2"><bean:message key="prompt.maxcontacttemp"/>:</td></tr>
              						<tr><td class="label2">
<html:text property="maxcontacttemp" size="15" maxlength="10" styleClass="forminput1"/>
                                    </td></tr> 
                                           
             						<tr><td class="label2"><bean:message key="prompt.gaskets"/>:</td></tr>
              						<tr><td class="label2">
<html:text property="gaskets" size="40" maxlength="40" styleClass="forminput1"/>
                                    </td></tr> 
                                                                                                                                  
								</table>
    						</td>
						    </tr>
     					

                                                                                                                                     
           					</logic:notEqual>
              
              
              
							<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="2">
    
				        <div class="btnPane"> 
				            <logic:equal name="ProductForm" property="action"   scope="session" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="ProductForm" property="action"   scope="session" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="ProductForm" property="action"   scope="session" value="Edit">
				                <button id="buttonSave" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.save"/></span>
				                </button>  
          					</logic:equal>
			                <button id="buttonCancel" class="btn btnFF" type="submit" onClick="bCancel=true;" name="org.apache.struts.taglib.html.CANCEL">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        <span><bean:message key="button.cancel"/></span>
			                </button>                            
				        </div>
                 
      				</td>
				</tr>


    				</table>
                    
                    </div>
                    
    
</html:form>
    


				</div>
              

			</td>
		</tr>

		<tr><td colspan="2"><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

	</table>

</body>
</html:html>
