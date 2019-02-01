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
    //]]>
</script>




<script language="JavaScript">
var searchWin;

function locationcodeSearch(field, value){
	var url     = 'EditLocationcodeSearch.do?maxResults=999&headerInfo1=&headerInfo2='+field
					+'&id='
					+document.forms[0].locationcode.value
					+'&searchString1='
					//+document.forms[0].country.value
					;					  
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=600');
	searchWin.focus();
}

function clearLocationcode(){
    document.forms[0].locationcode.value = '';
}
</script>


<script type="text/javascript">
// global flag
var isIE = false;

// global request and XML document objects
var req;

// retrieve XML document (reusable generic function);
// parameter is URL string (relative or complete) to
// an .xml file whose Content-Type is a valid XML
// type, such as text/xml; XML source must be from
// same domain as HTML file
function loadXMLDoc(url) {
var url2 = "RefreshLocationcodeList?countrykey="+url;
//alert(url2);
    // branch for native XMLHttpRequest object
    if (window.XMLHttpRequest) {
        req = new XMLHttpRequest();
        req.onreadystatechange = processReqChange;
        req.open("GET", url2, true);
        req.send(null);
    // branch for IE/Windows ActiveX version
    } else if (window.ActiveXObject) {
        isIE = true;
        req = new ActiveXObject("Microsoft.XMLHTTP");
        if (req) {
            req.onreadystatechange = processReqChange;
            req.open("GET", url2, true);
            req.send();
        }
    }
}

// handle onreadystatechange event of req object
function processReqChange() {
if (req.readyState == 4) {
           strResponse = req.responseText;
           switch (req.status) {	   
                   // Page-not-found error
                   case 404:
                           alert('Error: Not Found. The requested URL ' + 
                                   strURL + ' could not be found.');
                           break;
                   // Display results in a full window for server-side errors
                   case 500:
                           handleErrFullPage(strResponse);
                           break;
                   default:
                           // Call JS alert for custom error or debug messages
                           if (strResponse.indexOf('Error:') > -1 || 
                                   strResponse.indexOf('Debug:') > -1) {
                                   alert(strResponse);
                           }
                           // Call the desired result function
                           else {
                                   //eval(strResultFunc + '(strResponse);');
            						clearLocationcodeList();
            						buildLocationcodeList();							   
                           }
                           break;
           }
   }
}


function handleErrFullPage(strIn) {

        var errorWin;

        // Create new window and display error
        try {
                errorWin = window.open('', 'errorWin');
                errorWin.document.body.innerHTML = strIn;
        }
        // If pop-up gets blocked, inform user
        catch(e) {
                alert('An error occurred, but the error message cannot be' +
                        ' displayed because of your browser\'s pop-up blocker.\n' +
                        'Please allow pop-ups from this Web site.');
        }
}


// invoked by "Category" select element change;
// loads chosen XML document, clears Fromlocationkeys select
// element, loads new items into Fromlocationkeys select element
function loadDoc(evt) {
    // equalize W3C/IE event models to get event object
    evt = (evt) ? evt : ((window.event) ? window.event : null);
    if (evt) {
        // equalize W3C/IE models to get event target reference
        var elem = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null);
        if (elem) {
            try {
                if (elem.selectedIndex > 0) {
                    loadXMLDoc(elem.options[elem.selectedIndex].value);
                }
            }
            catch(e) {
                var msg = (typeof e == "string") ? e : ((e.message) ? e.message : "Unknown Error");
                alert("Unable to get XML data:\n" + msg);
                return;
            }
        }
    }
}

// retrieve text of an XML document element, including
// elements using namespaces
function getElementTextNS(prefix, local, parentElem, index) {
    var result = "";
    if (prefix && isIE) {
        // IE/Windows way of handling namespaces
        result = parentElem.getElementsByTagName(prefix + ":" + local)[index];
    } else {
        // the namespace versions of this method
        // (getElementsByTagNameNS()) operate
        // differently in Safari and Mozilla, but both
        // return value with just local name, provided
        // there aren't conflicts with non-namespace element
        // names
        result = parentElem.getElementsByTagName(local)[index];
    }
    if (result) {
        // get text, accounting for possible
        // whitespace (carriage return) text nodes
        if (result.childNodes.length > 1) {
            return result.childNodes[1].nodeValue;
        } else {
            return result.firstChild.nodeValue;
        }
    } else {
        return "n/a";
    }
}

// add item to select element the less
// elegant, but compatible way.
function appendToSelect(select, value, content) {
    var opt;
    opt = document.createElement("option");
    opt.value = value;	
    opt.appendChild(content);
    select.appendChild(opt);
}


// empty select list content
function clearLocationcodeList() {
    var select = document.getElementById("locationcode");
    while (select.length > 0) {
        select.remove(0);
    }
}
// fill select list with items from
// the current XML document
function buildLocationcodeList() {
    var select = document.getElementById("locationcode");
    var items = req.responseXML.getElementsByTagName("locationcode");
    // loop through <locationcode> elements, and add each nested
    // <key> element to select element
    for (var i = 0; i < items.length; i++) {	
        appendToSelect(
					select, 
					getElementTextNS("", "key", items[i], 0),
		            document.createTextNode(getElementTextNS("", "ldesc", items[i], 0))
					);
    }
}
</script>



<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<logic:equal name="LocationForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="LocationForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="LocationForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	





</head>


<body onLoad="onLoad();" onUnload="if (searchWin != null) {searchWin.close();}"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td><span class="header2">
    			<logic:equal name="LocationForm" property="action" scope="request" value="Create">
		    		<bean:message key="location.title.create"/>
    			</logic:equal>
		    	<logic:equal name="LocationForm" property="action" scope="request" value="Delete">
		      		<bean:message key="location.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="LocationForm" property="action" scope="request" value="Edit">
		        	<bean:message key="location.title.edit"/>
     			</logic:equal>		  
            </span>
<span class="header2">&gt;</span>            
<html:link action="/ListLocation"><span class="header4"><bean:message key="location.title.list"/></span></html:link>        
          	      						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td>
	
				<div style="OVERFLOW:auto; width:750px; height:650px; position:relative;">	

				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="2"><html:errors/></td></tr>
  
			<html:form action="/SaveLocation" focus="locationkey"> 
			<html:hidden property="action"/>
			<html:hidden property="description1"/>
			<html:hidden property="description2"/>
			<html:hidden property="description3"/>
			<html:hidden property="portUnicon"/>
			<html:hidden property="plantCode"/>
<html:hidden property="locationType"/> 
        
        
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    
    
							<logic:equal name="LocationForm" property="action"  scope="request" value="Delete">  
 
				        	<tr><td class="label1" colspan="2">General</td></tr>
       
				       		<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
       							<td width="100%">      
				      				<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                   
							            <tr><td class="label2"><bean:message key="prompt.code"/>:</td></tr>
							    		<tr><td class="label2">
                                        <html:text property="locationkey" size="20" maxlength="10" disabled="true" styleClass="forminput1"/>
                                        <html:hidden property="locationkey"/>
                                        </td></tr>
								    </table>
							    </td>
						    </tr>
    
						</logic:equal>			
    
          
				        	<logic:notEqual name="LocationForm" property="action"  scope="request" value="Delete"> 
 
								<tr><td class="label1" colspan="2">General</td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                    
									<tr><td class="label2"><bean:message key="prompt.code"/>:</td></tr>
              						<tr><td class="label2">
		  <c:if test="${LocationForm.action == 'Create'}">
        	<html:text property="locationkey" size="30" maxlength="20" styleClass="forminput1"/>
		  </c:if>
		  <c:if test="${LocationForm.action != 'Create'}">
        	<html:text property="locationkey" size="30" disabled="true" maxlength="20" styleClass="forminput1"/>
			<html:hidden property="locationkey"/>			
		  </c:if>	                                    
                                    </td></tr>
    
    
             						<tr><td class="label2"><bean:message key="prompt.type"/>:</td></tr>
              						<tr><td class="label2">
<html:select property="arraylocationtypelist" multiple="true" size="10" styleClass="forminput1">
			<html:options collection="locationtypes" property="typekey" labelProperty="typekey"/> 	
</html:select>  
                                    </td></tr>

             						<tr><td class="label2"><bean:message key="prompt.name"/>:</td></tr>
              						<tr><td class="label2"><html:text property="locationName" size="50" maxlength="50" styleClass="forminput1"/></td></tr>    
                                    
             						<tr><td class="label2"><bean:message key="prompt.shortname"/>:</td></tr>
              						<tr><td class="label2"><html:text property="shortName" size="20" maxlength="10" styleClass="forminput1"/></td></tr>                                              
                      
								</table>
    						</td>
						    </tr>
     					
                            
                        		<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="2">Address Details</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr><td class="label2"><bean:message key="prompt.location"/>:</td></tr>
              					<tr><td class="label2"><html:text property="address1" size="50" maxlength="50" styleClass="forminput1"/></td></tr>
              					<tr><td class="label2"><html:text property="address2" size="50" maxlength="50" styleClass="forminput1"/></td></tr>
              					<tr><td class="label2"><html:text property="address3" size="50" maxlength="50" styleClass="forminput1"/></td></tr>

         						<tr><td class="label2"><bean:message key="prompt.postalcode"/>:</td></tr>
              					<tr><td class="label2"><html:text property="postalCode" size="20" maxlength="10" styleClass="forminput1"/></td></tr>
                                
         						<tr><td class="label2"><bean:message key="prompt.city"/>:</td></tr>
              					<tr><td class="label2">
<html:select property="city" styleClass="forminput1"> 
									<html:option value=""><bean:message key="prompt.city"/>
                                    </html:option> 
									<html:options collection="citys" property="city" labelProperty="city"/> 
									</html:select>
                                </td></tr>                                
 
         						<tr><td class="label2"><bean:message key="prompt.state"/>:</td></tr>
              					<tr><td class="label2"><html:text property="state" size="20" maxlength="20" styleClass="forminput1"/></td></tr>        
         						<tr><td class="label2"><bean:message key="prompt.country"/>:</td></tr>
              					<tr><td class="label2">
<html:select property="country" styleClass="forminput1"> <html:option value=""><bean:message key="prompt.country"/></html:option> <html:options collection="countrys" property="country" labelProperty="country"/> </html:select>
                                </td></tr>                                                                                                                                                             						<tr><td class="label2"><bean:message key="prompt.locationuncode"/>:</td></tr>
              					<tr><td class="label2">
<html:text property="locationcode" styleClass="forminput1"/>&nbsp;
		<html:link href="javascript:void(locationcodeSearch('locationcode'))">
		<html:img src="images/buttons/btn_search_12x12.png" alt="Search" border="0" align="middle"/>
		</html:link> 
                                </td></tr>
                                                                                                             
     						</table>
					    </td>
        					</tr>
                                           

                            
                        		<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="2">Contact Details</td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr><td class="label2"><bean:message key="prompt.contact"/>:</td></tr>
              					<tr><td class="label2"><html:text property="contact" size="50" maxlength="50" styleClass="forminput1"/></td></tr>
                                
<tr><td class="label2"><bean:message key="prompt.phone"/>:</td></tr>
              					<tr><td class="label2"><html:text property="phone" size="50" maxlength="50" styleClass="forminput1"/></td></tr>                                
         						<tr><td class="label2"><bean:message key="prompt.fax"/>:</td></tr>
              					<tr><td class="label2"><html:text property="fax" size="50" maxlength="50" styleClass="forminput1"/></td></tr>                                                                                                                                              						
                                                                              
     						</table>
					    </td>
        					</tr>


<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/ajaxV2.js"></script> 
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/standard/ListG2codeAjax.js"></script>
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/standard/ListG3codeAjax.js"></script>
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/standard/ListG4codeAjax.js"></script>

                        		<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr>  
           
             					<tr><td class="label1" colspan="2"><bean:message key="gcode.title"/></td></tr>  

								<tr>
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>
       
						       	<td width="100%">     
							<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">   
                      
         						<tr><td class="label2"><bean:message key="heading.g1code"/>:</td></tr>
              					<tr><td class="label2">
        <html:select property="g1codekey" styleClass="forminput1" onchange="processListG2code();">
			<html:option value=""> <bean:message key="prompt.selectacode"/></html:option>
			<html:options collection="g1codes" property="g1codekey" labelProperty="g1codekey"/>	
		</html:select>	
                                </td></tr>
                                
         						<tr><td class="label2"><bean:message key="heading.g2code"/>:</td></tr>
              					<tr><td class="label2">
        <html:select property="g2codekey" styleClass="forminput1" onchange="processListG3code();">
			<html:option value=""> <bean:message key="prompt.selectacode"/></html:option>	
            			<html:options collection="g2codes" property="g2codekey" labelProperty="g2codekey"/>	
		</html:select>		
                                </td></tr>                                                                                                                                              						<tr><td class="label2"><bean:message key="heading.g3code"/>:</td></tr>
              					<tr><td class="label2">
        <html:select property="g3codekey" styleClass="forminput1" onchange="processListG4code();">
			<html:option value=""> <bean:message key="prompt.selectacode"/></html:option>	
			<html:options collection="g3codes" property="g3codekey" labelProperty="g3codekey"/>	            
		</html:select>
                                </td></tr>
                                
         						<tr><td class="label2"><bean:message key="heading.g4code"/>:</td></tr>
              					<tr><td class="label2">
        <html:select property="g4codekey" styleClass="forminput1">
			<html:option value=""> <bean:message key="prompt.selectacode"/></html:option>
			<html:options collection="g4codes" property="g4codekey" labelProperty="g4codekey"/>	            	
		</html:select>	
                                </td></tr>                                
                                                                                                                
     						</table>
					    </td>
        					</tr>

                            
                                                                                                                                           
           					</logic:notEqual>
              
              
              
							<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="2">
    
				        <div class="btnPane"> 
				            <logic:equal name="LocationForm" property="action"   scope="request" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="LocationForm" property="action"   scope="request" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="LocationForm" property="action"   scope="request" value="Edit">
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
    
						</html:form>
    
    				</table>

				</div>

			</td>
		</tr>

		<tr><td colspan="2"><jsp:include page="/pages/footer.jsp" flush="true" /></td></tr>

	</table>

</body>
</html:html>
