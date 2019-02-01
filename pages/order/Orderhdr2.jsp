<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 *
 *  												
 --%>
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
	
	function navigateTo(forwardName) {
		document.forms[0].forwardname.value=forwardName;	
		document.forms[0].submit();		
	}	
    //]]>
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
var url2 = "RefreshCustomerToObject?customeraddrkey="+url;
//alert(url2);
    // branch for native XMLHttpRequest object
//    if (window.XMLHttpRequest) {
//        req = new XMLHttpRequest();
//        req.onreadystatechange = processReqChange;
//        req.open("GET", url2, true);
//        req.send(null);
//    // branch for IE/Windows ActiveX version
//    } else if (window.ActiveXObject) {
//        isIE = true;
//        req = new ActiveXObject("Microsoft.XMLHTTP");
//        if (req) {
//            req.onreadystatechange = processReqChange;
//            req.open("GET", url2, true);
//            req.send();
//        }
//    }
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
            						clearConsigneeaddrkeyList();
            						buildConsigneeaddrkeyList();
            						clearBrokeraddrkeyList();
            						buildBrokeraddrkeyList();	
            						clearShipperaddrkeyList();
            						buildShipperaddrkeyList();	
            						clearForwardagentaddrkeyList();
            						buildForwardagentaddrkeyList();								   
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
function clearConsigneeaddrkeyList() {
    var select = document.getElementById("consigneeaddrkey");
    while (select.length > 0) {
        select.remove(0);
    }
}
// fill select list with items from
// the current XML document
function buildConsigneeaddrkeyList() {
    var select = document.getElementById("consigneeaddrkey");
    var items = req.responseXML.getElementsByTagName("consignee");
    // loop through <consignee> elements, and add each nested
    // <key> element to select element
    for (var i = 0; i < items.length; i++) {	
        appendToSelect(
					select, 
					getElementTextNS("", "key", items[i], 0),
		            document.createTextNode(getElementTextNS("", "name", items[i], 0))
					);
    }
}


// empty select list content
function clearBrokeraddrkeyList() {
    var select = document.getElementById("brokeraddrkey");
    while (select.length > 0) {
        select.remove(0);
    }
}
// fill select list with items from
// the current XML document
function buildBrokeraddrkeyList() {
    var select = document.getElementById("brokeraddrkey");
    var items = req.responseXML.getElementsByTagName("broker");
    // loop through <consignee> elements, and add each nested
    // <key> element to select element	
    for (var i = 0; i < items.length; i++) {	
        appendToSelect(
					select, 
					getElementTextNS("", "key", items[i], 0),
		            document.createTextNode(getElementTextNS("", "name", items[i], 0))
					);
    }
}


// empty select list content
function clearForwardagentaddrkeyList() {
    var select = document.getElementById("fwdagentaddrkey");
    while (select.length > 0) {
        select.remove(0);
    }
}
// fill select list with items from
// the current XML document
function buildForwardagentaddrkeyList() {
    var select = document.getElementById("fwdagentaddrkey");
    var items = req.responseXML.getElementsByTagName("forwardagent");
    // loop through <forwardagent> elements, and add each nested
    // <key> element to select element
    for (var i = 0; i < items.length; i++) {	
        appendToSelect(
					select, 
					getElementTextNS("", "key", items[i], 0),
		            document.createTextNode(getElementTextNS("", "name", items[i], 0))
					);
    }
}


// empty select list content
function clearShipperaddrkeyList() {
    var select = document.getElementById("shipperaddrkey");
    while (select.length > 0) {
        select.remove(0);
    }
}
// fill select list with items from
// the current XML document
function buildShipperaddrkeyList() {
    var select = document.getElementById("shipperaddrkey");
    var items = req.responseXML.getElementsByTagName("shipper");
    // loop through <shipper> elements, and add each nested
    // <key> element to select element
    for (var i = 0; i < items.length; i++) {	
        appendToSelect(
					select, 
					getElementTextNS("", "key", items[i], 0),
		            document.createTextNode(getElementTextNS("", "name", items[i], 0))
					);
    }
}


function checkExchgdateupd() 
{
	var dd = document.forms[0].exchgdatedd.value;
	var mm = document.forms[0].exchgdatemm.value;
	var yyyy = document.forms[0].exchgdateyyyy.value;
	var dd_ = document.forms[0].exchgdatedd_.value;
	var mm_ = document.forms[0].exchgdatemm_.value;
	var yyyy_ = document.forms[0].exchgdateyyyy_.value;
	var ele = document.getElementById('div_exchgrateupd');
	ele.style.display = "none";
	if (dd!=dd_||mm!=mm_||yyyy!=yyyy_) {
		ele.style.display = "block";
	}
}

</script>







<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />
<link rel="stylesheet" type="text/css" href="css/navigation.css" />


<head>
<logic:equal name="OrderhdrForm" property="action"
            scope="session" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="OrderhdrForm" property="action"
            scope="session" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="OrderhdrForm" property="action"
            scope="session" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="OrderhdrForm" property="action"
            scope="session" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>




</head>

<un:bind var="servletKey" type="ord.apache.struts.Globals" field="SERVLET_KEY"/>


<body onLoad="onLoad();"> 

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr><td colspan="2"><jsp:include page="/pages/header.jsp" flush="true" /></td></tr>
	

<!-- BREADCRUMBS -----------------> 
		<tr bgcolor="#F1F1F1"><td colspan="2">
<span class="header2">
    			<logic:equal name="OrderhdrForm" property="action" scope="session" value="Create">
		    		<bean:message key="orderhdr.title.create"/>
    			</logic:equal>
		    	<logic:equal name="OrderhdrForm" property="action" scope="session" value="Delete">
		      		<bean:message key="orderhdr.title.delete"/>
      			</logic:equal>
		    	<logic:equal name="OrderhdrForm" property="action" scope="session" value="Edit">
		        	<bean:message key="orderhdr.title.edit"/>
     			</logic:equal>	
		    	<logic:equal name="OrderhdrForm" property="action" scope="session" value="View">
		        	<bean:message key="orderhdr.title.view"/>
     			</logic:equal>	                	  
</span>
<span class="header2">&gt;</span>			             
<html:link action="/ListOrderhdr"><span class="header4"><bean:message key="orderhdr.title.list"/></span></html:link>            						
		</td></tr>  
		<tr valign="top" bgcolor="#CCCCCC"><td height="1" colspan="2"></td></tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
		<tr>
			<td colspan="2">
	
				<div style="OVERFLOW:auto; width:900px; height:650px; position:relative;">	




<html:form action="/SaveOrderhdr" focus="orderno">
<html:hidden property="action"/>
<html:hidden property="forwardname" value=""/>
<html:hidden property="id"/>
<html:hidden property="orderstatus"/>
<html:hidden property="invoicestatus"/>
<html:hidden property="quohdrId"/>
<html:hidden property="copyId"/>
<html:hidden name="user" property="securitylevel"/>

<html:hidden property="ldgg1key1"/>
<html:hidden property="ldgg2key1"/>
<html:hidden property="ldgg3key1"/>
<html:hidden property="ldgg4key1"/>
<html:hidden property="ldgg1key2"/>
<html:hidden property="ldgg2key2"/>
<html:hidden property="ldgg3key2"/>
<html:hidden property="ldgg4key2"/>
<html:hidden property="dchg1key1"/>
<html:hidden property="dchg2key1"/>
<html:hidden property="dchg3key1"/>
<html:hidden property="dchg4key1"/>
<html:hidden property="dchg1key2"/>
<html:hidden property="dchg2key2"/>
<html:hidden property="dchg3key2"/>
<html:hidden property="dchg4key2"/>

<html:hidden property="shipvendoraddrkey"/>
<html:hidden property="shipvessel"/>
<html:hidden property="shipvoyage"/>


        

<div id="secondaryNav">
    
    <div class="secNavOuterPane">
    
    <div id="secNavDividerLeft"></div>
    <div id="secNavDividerTitle"></div>
    <div id="secNavDividerRight"></div>
    
<div id="secNavPane">
      
    <div id="General" class="secNavBtn SecNavBg">
    <span class="secNavBtnSpan">
    <a class="secNavBtnLnk" href="#" title="" onClick="navigateTo('orderhdr1');">
    <span class="secNavBtnLnkContent"><img class="secNavBtnLnkIcon MainNavigationSprite General" alt="" title="" src="images/buttons/clear1x1.gif"  /><br />General
    </span>
    </a>
    </span>
    </div>

   <div id="Customer" class="secNavBtnSelected HorizontalSprite SecNavBg">
    <span class="secNavBtnSpan">
    <a class="secNavBtnLnk" href="#" title="" onClick="navigateTo('orderhdr2');">
    <span class="secNavBtnLnkContent"><img class="secNavBtnLnkIcon MainNavigationSprite Address" alt="" title="" src="images/buttons/clear1x1.gif"  /><br />Customer
    </span>
    </a>
    </span>
    </div>
          
    <div id="Logistic" class="secNavBtn SecNavBg">
    <span class="secNavBtnSpan">
    <a class="secNavBtnLnk" href="#" title="" onClick="navigateTo('orderhdr3');">
    <span class="secNavBtnLnkContent">
    <img class="secNavBtnLnkIcon MainNavigationSprite Logistic" alt="" title="" src="images/buttons/clear1x1.gif"  /><br />Logistic
    </span>
    </a>
    </span>
    </div>
          
    <div id="Document" class="secNavBtn SecNavBg">
    <span class="secNavBtnSpan">
    <a class="secNavBtnLnk" href="#" title="" onClick="navigateTo('orderhdr4');">
    <span class="secNavBtnLnkContent">
    <img class="secNavBtnLnkIcon MainNavigationSprite Document" alt="" title="" src="images/buttons/clear1x1.gif"  /><br />Documentation
    </span>
    </a>
    </span>
    </div>
               
    </div>       
     
    </div>
    
</div>


<div style="position:relative;">


				    <table border="0" cellpadding="0" cellspacing="2" width="100%" bgcolor="#ffffff">
      
						<tr><td colspan="3"><html:errors/></td></tr>
                               
				       		<tr><td><img src="images/spacer.gif" height="5"/></td></tr>  
    

          
				        	<logic:notEqual name="OrderhdrForm" property="action"  scope="session" value="Delete"> 


                            
			       				<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr>  
                                                         
								<tr><td class="label1" colspan="3"><bean:message key="prompt.customerdetails"/></td></tr>

								<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
								<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">                                 
                                    
             						<tr><td class="label2"><bean:message key="prompt.customer"/>:</td></tr>
              						<tr><td class="label2">
		<html:select property="customeraddrkey" 
			styleClass="forminput1" 
			onchange="loadDoc(event)">
			<html:option value=""><bean:message key="prompt.selectacustomer"/></html:option>
			<html:options collection="customers" property="addrkey" labelProperty="name"/><!--201000006-->
		</html:select>	
                                    </td></tr>   
                                                                       
             						<tr><td class="label2"><bean:message key="prompt.reference"/>:</td></tr>
              						<tr><td class="label2">
        <html:text property="customerref" size="30"  maxlength="20" styleClass="forminput1"/>	
                                    </td></tr>                                                                                
                                                         
								</table>
    							</td>                               
                                                                
							    </tr>
                                                      

 			       			<tr><td colspan="3"><img src="images/spacer.gif" height="5"/></td></tr> 
                                                         
							<tr><td class="label1" colspan="3"><bean:message key="prompt.addressdetails"/></td></tr>

							<tr>                       
                            	<td><html:img src="images/spacer.gif" border="0" width="1" height="1"/></td>    
							
                            	<td width="100%" colspan="2">     
									<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                                                                        
             							<tr>
                                        	<td class="label2" width="30%"><bean:message key="prompt.shipper"/>:</td>
											<td class="label2" width="70%"><bean:message key="prompt.reference"/>:</td>
                                        </tr>
	              						<tr>
                                        	<td class="label2">
		<html:select property="shipperaddrkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectashipper"/></html:option>
			<html:options collection="shippers" property="addrkey" labelProperty="name"/>	
		</html:select>		
    	                                	</td>
                                        	<td class="label2">
        <html:text property="shipperref" size="30"  maxlength="20" styleClass="forminput1"/>		
    	                                	</td>                                            
                                        </tr>

             							<tr>
                                        	<td class="label2" width="30%"><bean:message key="prompt.consignee"/>:</td>
											<td class="label2" width="70%"><bean:message key="prompt.reference"/>:</td>
                                        </tr>
	              						<tr>
                                        	<td class="label2">
		<html:select property="consigneeaddrkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaconsignee"/></html:option>
			<html:options collection="consignees" property="addrkey" labelProperty="name"/>	
		</html:select>	
    	                                	</td>
                                        	<td class="label2">
        <html:text property="consigneeref" size="30"  maxlength="20" styleClass="forminput1"/>		
    	                                	</td>                                            
                                        </tr>
 
              							<tr>
                                        	<td class="label2" width="30%"><bean:message key="prompt.forwardagent"/>:</td>
											<td class="label2" width="70%"><bean:message key="prompt.reference"/>:</td>
                                        </tr>
	              						<tr>
                                        	<td class="label2">
		<html:select property="fwdagentaddrkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaforwardagent"/></html:option>
			<html:options collection="fwdagents" property="addrkey" labelProperty="name"/>	
		</html:select>		
    	                                	</td>
                                        	<td class="label2">
        <html:text property="fwdagentref" size="30"  maxlength="20" styleClass="forminput1"/>		
    	                                	</td>                                            
                                        </tr>

              							<tr>
                                        	<td class="label2" width="30%"><bean:message key="prompt.broker"/>:</td>
											<td class="label2" width="70%"><bean:message key="prompt.reference"/>:</td>
                                        </tr>
	              						<tr>
                                        	<td class="label2">
		<html:select property="brokeraddrkey" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectabroker"/></html:option>
			<html:options collection="brokers" property="addrkey" labelProperty="name"/>	
		</html:select>
    	                                	</td>
                                        	<td class="label2">
        <html:text property="brokerref" size="30"  maxlength="20" styleClass="forminput1"/>		
    	                                	</td>                                            
                                        </tr>                                                                                                                       
                                	</table>
    							</td>
						    </tr>   
                            
                                                                                                                                                   
           					</logic:notEqual>
              
              
              
							<tr><td colspan="3"><img src="images/spacer.gif" height="10"/></td></tr>  
      
		    				<tr>
			        <td colspan="3">
    
				        <div class="btnPane"> 
				            <logic:equal name="OrderhdrForm" property="action"   scope="session" value="Create">  
				                <button id="buttonStore" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.add"/></span>
                				</button>      
				            </logic:equal>
          					<logic:equal name="OrderhdrForm" property="action"   scope="session" value="Delete">
				                <button id="buttonDelete" class="btn btnFF" type="submit">
                				    <img class=" IM L-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
				                    <span><bean:message key="button.delete"/></span>
                				</button>  
							</logic:equal>
							<logic:equal name="OrderhdrForm" property="action"   scope="session" value="Edit">
				                <button id="buttonSave" class="btn btnFF" type="submit">
                				    <img class=" IM tick-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
                    				<span><bean:message key="button.save"/></span>
				                </button>  
          					</logic:equal>                                 
							<logic:notEqual name="OrderhdrForm" property="action"   scope="session" value="View">                            
			                	<button id="buttonCancel" class="btn btnFF" type="submit" onClick="bCancel=true;" name="org.apache.struts.taglib.html.CANCEL">
			                    	<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        	<span><bean:message key="button.cancel"/></span>
			                	</button>
          					</logic:notEqual>  
							<logic:equal name="OrderhdrForm" property="action"   scope="session" value="View">                            
								<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='ListOrderhdr.do'">
			                    	<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
            			        	<span><bean:message key="button.exit"/></span>
					            </button>   
          					</logic:equal>                                                                                  
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
