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


<html:html>
<head>



<script type="text/javascript" language="javascript">
		window.onload = onLoadFunctions;
		document.onload = onLoadFunctions;
		function onLoadFunctions() {	
			var i; i=0; 
			if ( 
				document.forms[0].action.value == 'View' &&
				 document.forms[0].securitylevel.value != '1'
			) {
				while (i < document.forms[0].elements.length) {
					document.forms[0].elements[i].disabled = true;
					i++;	
				}
			}
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






</script>



<logic:equal name="OrderhdrForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="title.create"/></title>
</logic:equal>
<logic:equal name="OrderhdrForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="title.delete"/></title>
</logic:equal>
<logic:equal name="OrderhdrForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="title.edit"/></title>
</logic:equal>	
<logic:equal name="OrderhdrForm" property="action"
            scope="request" value="View">
  <title><bean:message key="title.view"/></title>
</logic:equal>

<link rel="stylesheet" type="text/css" href="css/base.css" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

</head>


<un:bind var="servletKey" type="ord.apache.struts.Globals" field="SERVLET_KEY"/>

<body> 
 
<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>
 	

<!-- BREADCRUMBS -----------------> 
<tr>

	<td class="tdwht">
	<span class="heading2"><html:link action="/ListOrderhdr"><bean:message key="orderhdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2">
<logic:equal name="OrderhdrForm" property="action"
            scope="request" value="Create">
  <bean:message key="orderhdr.title.create"/>
</logic:equal>
<logic:equal name="OrderhdrForm" property="action"
            scope="request" value="Delete">
  <bean:message key="orderhdr.title.delete"/>
</logic:equal>
<logic:equal name="OrderhdrForm" property="action"
            scope="request" value="Edit">
  <bean:message key="orderhdr.title.edit"/>
</logic:equal>
<logic:equal name="OrderhdrForm" property="action"
            scope="request" value="View">
  <bean:message key="orderhdr.title.view"/>
</logic:equal>  
</span>  
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>
<!-- BREADCRUMBS ----------------->
	
	  	  
<tr>

	
	<td>
	
		<div style="OVERFLOW:auto; width:950px; height:650px; position:relative;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>
<html:errors/>


<html:form action="/SaveOrderhdr" focus="orderno">
<html:hidden property="action"/>
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
                    
                    

<table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">

  <tr>
    <td>
<table width="100%" border="0" cellspacing="2" cellpadding="2" bgcolor="#ffffff">
  <tr>
    <td>
	
<table width="100%" border="0" cellspacing="3" cellpadding="0">
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
          <td class="td7"><strong>
<logic:equal name="OrderhdrForm" property="action"
            scope="request" value="Create">
  <bean:message key="orderhdr.title.create"/>
</logic:equal>
<logic:equal name="OrderhdrForm" property="action"
            scope="request" value="Delete">
  <bean:message key="orderhdr.title.delete"/>
</logic:equal>
<logic:equal name="OrderhdrForm" property="action"
            scope="request" value="Edit">
  <bean:message key="orderhdr.title.edit"/>
</logic:equal>
<logic:equal name="OrderhdrForm" property="action"
            scope="request" value="View">
  <bean:message key="orderhdr.title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>

      <logic:equal name="OrderhdrForm" property="action"
                     scope="request" value="Delete">  
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">  				
        <tr>
		  <td rowspan="4">
		  	<img src="images/spacer.gif" width="1" border="0"/>
		  </td>		
          <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.orderno"/>:
		  </div>
		  </td>
          <td width="80%" class="td2">
        <html:text property="orderno" size="30" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>  
          </td>
        </tr>
	</table>
	</td>
	</tr>
	</logic:equal>		

      <logic:notEqual name="OrderhdrForm" property="action"
                     scope="request" value="Delete">  
  <tr>
    <td width="50%" valign="top">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">  				
        <tr>
		  <td rowspan="6">
		  	<img src="images/spacer.gif" height="89" width="1" border="0"/>
		  </td>		
          <td width="40%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.orderno"/>:
		  </div>
		  </td>
          <td width="60%" class="td2">
		  <c:if test="${OrderhdrForm.action == 'Create'}">
        	<html:text property="orderno" size="30" maxlength="20" styleClass="ftforminputsmall"/>
		  </c:if>
		  <c:if test="${OrderhdrForm.action != 'Create'}">
        	<html:text property="orderno" size="30" disabled="true" maxlength="20" styleClass="ftforminputsmall"/>
			<html:hidden property="orderno"/>			
		  </c:if>		   
          </td>
        </tr>	
        <tr>
          <td width="40%" class="td2">
		  <div align="right">
		       <bean:message key="prompt.orderdate"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td2">
		<html:select property="orderdatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="orderdatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="orderdateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	  	  
          </td>
        </tr>
        <tr>
          <td width="40%" class="td2">
		  <div align="right">
		       <bean:message key="prompt.exchgdate"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td2">
		<html:select property="exchgdatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="exchgdatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="exchgdateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>			 	  
          </td>
        </tr>				
        <tr>
          <td width="40%" class="td2">
		  <div align="right"><bean:message key="prompt.quotenumber"/>:</div>		  
		  </td>
          <td width="60%" class="td10">		  
		  <html:hidden property="quotno" write="true"/>   
		  </td>
        </tr>		
        <tr>
          <td width="40%" class="td2"> 
		  <div align="right">
		        <bean:message key="prompt.shipmethod"/>:
		  </div>
		  </td>
          <td width="60%" class="td2">
		<html:select property="shipmethod" styleClass="ftforminputsmall">
			<html:option value="">- select a Ship Method -</html:option>
			<html:options collection="shipmethods" property="id.codekey" labelProperty="descr"/>	
		</html:select>		  
          </td>
        </tr>
        <tr>
          <td width="40%" class="td2"> 
		  <div align="right">
		         <bean:message key="prompt.incoterm"/>:
		  </div>
		  </td>
          <td width="60%" class="td2">
		<html:select property="incotermkey" styleClass="ftforminputsmall">
			<html:option value=""> <bean:message key="prompt.selectaterm"/></html:option>
			<html:options collection="incoterms" property="incotermkey" labelProperty="description"/>	
		</html:select>		  
          </td>
        </tr>        														
    </table>	
	</td>
    <td width="50%" valign="top">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="5">
		  	<img src="images/spacer.gif" height="80" width="1" border="0"/>
		  </td>
          <td width="40%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.createdbyuser"/>:
		  </div>
		  </td>
          <td width="60%" class="td10">
		&nbsp;<html:hidden property="orderbyuserid" styleClass="ftforminputsmall" write="true"/>		  
          </td>
		</tr>	  				
        <tr>
          <td width="40%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.company"/>:
		  </div>
		  </td>
          <td width="60%" class="td2">
		<html:select property="companykey" styleClass="ftforminputsmall">
			<html:option value="">- select a Company -</html:option>
			<html:options collection="companys" property="compid" labelProperty="name"/>	
		</html:select>		  
          </td>
        </tr>	
        <tr>
          <td width="40%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.department"/>:
		  </div>
		  </td>
          <td width="60%" class="td2">
		<html:select property="departmentkey" styleClass="ftforminputsmall">
			<html:option value="">- select a Department -</html:option>
			<html:options collection="departments" property="id.codekey" labelProperty="descr"/>	
		</html:select>			  
          </td>
        </tr>	
        <tr>
          <td width="40%" class="td2">		  
		  <div align="right">		  
		        <bean:message key="prompt.activity"/>:
		  </div>
		  </td>
          <td width="60%" class="td2">
		<html:select property="activitykey" styleClass="ftforminputsmall">
			<html:option value="">- select a Role -</html:option>
			<html:options collection="activitys" property="id.codekey" labelProperty="descr"/>	
		</html:select>				  
          </td>
        </tr>
        <tr>
          <td class="td2" colspan="2">
		<img src="images/spacer.gif" height="41" width="1" border="0"/>		  
		  </td>
        </tr>														
    </table>
	</td>	
  </tr>	


  <tr>	
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">		
        <tr>
	<td rowspan="1">
		<img src="images/spacer.gif" height="20" width="1" border="0"/>
	</td>			
          <td width="20%" class="td2">
		  <div align="right">
<bean:message key="prompt.invoicestatus"/>:
		  </div>
		  </td>
          <td width="80%" class="td9">
                      <c:if test="${OrderhdrForm.invoicestatus == 'NOT INVOICED'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${OrderhdrForm.invoicestatus}"/>'/>
                      </c:if>
                      <c:if test="${OrderhdrForm.invoicestatus == 'FULLY INVOICED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" alt='<c:out value="${OrderhdrForm.invoicestatus}"/>'/>
                      </c:if>	
                      <c:if test="${OrderhdrForm.invoicestatus == 'PART INVOICED'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${OrderhdrForm.invoicestatus}"/>'/>
                      </c:if>			  
        <bean:write name="OrderhdrForm" property="invoicestatus" scope="request"/>
          </td>	  
        </tr>				
    </table>
	</td>
  </tr>
 
 
 		    					 
  <tr>	
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">		
        <tr>
	<td rowspan="2">
		<img src="images/spacer.gif" height="20" width="1" border="0"/>
	</td>			
          <td width="20%" class="td2">
		  <div align="right">
<bean:message key="prompt.bookingnumber"/>:
		  </div>
		  </td>
          <td width="80%" class="td10">
        <html:text property="bookingnumber" size="20" styleClass="ftforminputsmall"/>
          </td>	  
        </tr>	
        <tr>			
          <td class="td2">
		  <div align="right">
<bean:message key="prompt.consignmentno"/>:
		  </div>
		  </td>
          <td class="td10">
        <html:text property="consignmentno" size="30" styleClass="ftforminputsmall"/>
          </td>	  
        </tr>	        			
    </table>
	</td>
  </tr>

  
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
        <tr>
		  <td rowspan="3">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td2" colspan="4">
		  <strong><bean:message key="prompt.customerdetails"/></strong> &nbsp;
		  </td>
		</tr>		 
        <tr>	
          <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.customer"/>:
		  </div>
		  </td>
          <td width="30%" class="td2">
		<html:select property="customeraddrkey" 
			styleClass="ftforminputsmall" 
			onchange="loadDoc(event)">
			<html:option value=""><bean:message key="prompt.selectacustomer"/></html:option>
			<html:options collection="customers" property="addrkey" labelProperty="name"/>	
		</html:select>					  
          </td>
          <td width="5%" class="td2">
		  <div align="right">
		        Ref:
		  </div>
		  </td>
          <td width="45%" class="td2">
        <html:text property="customerref" maxlength="20" size="30" styleClass="ftforminputsmall"/>				  
          </td>		  
        </tr>
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		        Order Currency:
		  </div>
		  </td>
          <td width="80%" class="td2" colspan="3">
		  		<c:if test="${OrderhdrForm.action == 'Create'}">

					<html:select property="ccykey" styleClass="ftforminputsmall"> 
						<html:option value=""><bean:message key="prompt.selectacurrency"/></html:option> 
						<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
					</html:select>				
				</c:if>	
		  		<c:if test="${OrderhdrForm.action != 'Create'}">
        			<bean:write property="ccykey" name="OrderhdrForm"/>
					<html:hidden property="ccykey"/>			
				</c:if>							  
          </td>  
        </tr>										
    </table>
	</td>
  </tr>	
  
 

  
   
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">  

       <tr>
		  <td rowspan="6">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td2" colspan="4">
		  <strong><bean:message key="prompt.addressdetails"/></strong> &nbsp;
		  </td>
		</tr>
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.shipper"/>:
		  </div>
		  </td>
          <td width="30%" class="td2">
		<html:select property="shipperaddrkey" styleClass="ftforminputsmall">
			<html:option value="">- select a Shipper -</html:option>
			<html:options collection="shippers" property="addrkey" labelProperty="name"/>	
		</html:select>					  
          </td>
          <td width="5%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.reference"/>:
		  </div>
		  </td>
          <td width="45%" class="td2">
        <html:text property="shipperref" size="30"  maxlength="20" styleClass="ftforminputsmall"/>				  
          </td>		  
        </tr>		
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		        Consignee:
		  </div>
		  </td>
          <td width="30%" class="td2">
		<html:select property="consigneeaddrkey" styleClass="ftforminputsmall">
			<html:option value="">- select a Consignee -</html:option>
			<html:options collection="consignees" property="addrkey" labelProperty="name"/>	
		</html:select>					  
          </td>
          <td width="5%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.reference"/>:
		  </div>
		  </td>
          <td width="45%" class="td2">
        <html:text property="consigneeref" size="30" maxlength="20" styleClass="ftforminputsmall"/>				  
          </td>		  
        </tr>
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		        Forward Agent:
		  </div>
		  </td>
          <td width="30%" class="td2">
		<html:select property="fwdagentaddrkey" styleClass="ftforminputsmall">
			<html:option value="">- select a Forward Agent -</html:option>
			<html:options collection="fwdagents" property="addrkey" labelProperty="name"/>	
		</html:select>					  
          </td>
          <td width="5%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.reference"/>:
		  </div>
		  </td>
          <td width="45%" class="td2">
        <html:text property="fwdagentref" size="30" maxlength="20" styleClass="ftforminputsmall"/>				  
          </td>		  
        </tr>
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		        Broker:
		  </div>
		  </td>
          <td width="30%" class="td2">
		<html:select property="brokeraddrkey" styleClass="ftforminputsmall">
			<html:option value="">- select a Broker -</html:option>
			<html:options collection="brokers" property="addrkey" labelProperty="name"/>	
		</html:select>					  
          </td>
          <td width="5%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.reference"/>:
		  </div>
		  </td>
          <td width="45%" class="td2">
        <html:text property="brokerref" size="30" maxlength="20" styleClass="ftforminputsmall"/>				  
          </td>		  
        </tr>											
    </table>
	</td>
  </tr>	
 
  
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">		
        <tr>
	<td rowspan="1">
		<img src="images/spacer.gif" height="20" width="1" border="0"/>
	</td>		
          <td width="20%" class="td2">
		  <div align="right">
		         Primary Product:
		  </div>
		  </td>
          <td width="80%" class="td2">
		<html:select property="productkey" styleClass="ftforminputsmall">
			<html:option value="">- select a Product -</html:option>
			<html:options collection="products" property="productkey" labelProperty="tradname"/>	
		</html:select>				  
          </td>	  
        </tr>				
    </table>
	</td>
  </tr>
    	
  <tr>
    <td width="100%" valign="top" colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
	       <tr>
		  <td rowspan="7">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td2" colspan="2">
		  <strong><bean:message key="prompt.locationdetails"/></strong> &nbsp;
		  </td>
		</tr>	 
        <tr>	
          <td width="20%" class="td2">
		  <div align="right">
		         Pickup:		  </div>		  </td>
          <td width="80%" class="td2">
		<html:select property="ldglocationkey1" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="plants" property="locationkey" labelProperty="locationName"/>	
		</html:select>          </td>
        </tr>
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		        Loading Port:		  </div>		  </td>
          <td width="80%" class="td2">
		<html:select property="ldglocationkey2" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="ports" property="locationkey" labelProperty="locationName"/>	
		</html:select>          </td>
        </tr>		
        <tr>
          <td class="td2"><div align="right">Loading Date/Time:</div></td>
          <td class="td2">
		  <table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#999999">
            <tr>
              <td width="5%" class="td2"><div align="right">From:</div></td>
              <td width="45%" class="td2">
		<html:select property="ldgfromdatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="ldgfromdatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="ldgfromdateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
		/
		<html:select property="ldgfromtimehh" styleClass="ftforminputsmall">
			<html:option value="00">HH</html:option>				
			<html:options collection="hours" property="value" labelProperty="label"/>	
		</html:select>:		  
		<html:select property="ldgfromtimemm" styleClass="ftforminputsmall">
			<html:option value="00">MM</html:option>				
			<html:options collection="minutes" property="value" labelProperty="label"/>	
		</html:select>			  
			  </td>
              <td width="5%" class="td2"><div align="right">To:</div></td>
              <td width="45%" class="td2">
		<html:select property="ldgtodatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="ldgtodatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="ldgtodateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
		/
		<html:select property="ldgtotimehh" styleClass="ftforminputsmall">
			<html:option value="00">HH</html:option>				
			<html:options collection="hours" property="value" labelProperty="label"/>	
		</html:select>:		  
		<html:select property="ldgtotimemm" styleClass="ftforminputsmall">
			<html:option value="00">MM</html:option>				
			<html:options collection="minutes" property="value" labelProperty="label"/>	
		</html:select>				  
			  </td>
            </tr>
          </table>		  
		  </td>
        </tr>
		
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		        Discharge Port:		  </div>		  </td>
          <td width="80%" class="td2">
		<html:select property="dchlocationkey2" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="ports" property="locationkey" labelProperty="locationName"/>	
		</html:select>          </td>
        </tr>
		
        <tr>
          <td class="td2"><div align="right">Discharge Date/Time:</div></td>
          <td class="td2">
		  <table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#999999">
            <tr>
              <td width="5%" class="td2"><div align="right">From:</div></td>
              <td width="45%" class="td2">
		<html:select property="dchfromdatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="dchfromdatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="dchfromdateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
		/
		<html:select property="dchfromtimehh" styleClass="ftforminputsmall">
			<html:option value="00">HH</html:option>				
			<html:options collection="hours" property="value" labelProperty="label"/>	
		</html:select>:		  
		<html:select property="dchfromtimemm" styleClass="ftforminputsmall">
			<html:option value="00">MM</html:option>				
			<html:options collection="minutes" property="value" labelProperty="label"/>	
		</html:select>			  
			  </td>
              <td width="5%" class="td2"><div align="right">To:</div></td>
              <td width="45%" class="td2">
		<html:select property="dchtodatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="dchtodatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="dchtodateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>
		/
		<html:select property="dchtotimehh" styleClass="ftforminputsmall">
			<html:option value="00">HH</html:option>				
			<html:options collection="hours" property="value" labelProperty="label"/>	
		</html:select>:		  
		<html:select property="dchtotimemm" styleClass="ftforminputsmall">
			<html:option value="00">MM</html:option>				
			<html:options collection="minutes" property="value" labelProperty="label"/>	
		</html:select>				  
			  </td>
            </tr>
          </table>		  
		  </td>
        </tr>	
						
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		        Delivery:		  </div>		  
				</td>
          <td width="80%" class="td2">
		<html:select property="dchlocationkey1" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="plants" property="locationkey" labelProperty="locationName"/>	
		</html:select>          
		</td>
        </tr>	
									
    </table>
	    </td>
  </tr>	
  
    <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
      <tr>
        <td rowspan="6"><img src="images/spacer.gif" height="89" width="1" border="0"/> </td>
        <td width="20%" class="td2" colspan="2">&nbsp;<strong>Demurrage</strong> </td>
      </tr>
      <tr>
        <td width="20%" class="td2"><div align="right"> Location: </div></td>
        <td width="80%" class="td2"><html:select property="dmrglocationkey" styleClass="ftforminputsmall">
            <html:option value="">
              <bean:message key="prompt.selectalocation"/>
            </html:option>
            <html:options collection="ports" property="locationkey" labelProperty="locationName"/>
          </html:select>
        </td>
      </tr>
	        <tr>
        <td width="20%" class="td2"><div align="right"> Bill To: </div></td>
	            <td width="80%" class="td2">
		<html:select property="dmrgbilltoaddrkey" styleClass="ftforminputsmall">
			<html:option value="">- select a Bill To -</html:option>
			<html:options collection="addresss" property="addrkey" labelProperty="name"/>	
		</html:select>					  
          </td>
		        </tr>
      <tr>
        <td class="td2"><div align="right"> Free Days: </div></td>
        <td class="td2"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td class="td2" colspan="3"><html:text property="dmrgfreedays" size="5" maxlength="5" styleClass="ftforminputsmall"/>
              </td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td class="td2"><div align="right"> <bean:message key="prompt.ccy"/>: </div></td>
        <td class="td2"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td class="td2" colspan="3">
 					<html:select property="dmrgccykey" styleClass="ftforminputsmall"> 
						<html:option value=""><bean:message key="prompt.selectacurrency"/></html:option> 
						<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
					</html:select>	             
              </td>
            </tr>
        </table></td>
      </tr>      
      <tr>
        <td width="20%" class="td2" valign="top"><div align="right"> Rates:
          <INPUT type="image" id="findDmrgratesButton" name="findDmrgratesButton" src="images/arrow_next_grey.gif"/>
        </div></td>
        <td width="80%" class="td2"><table border="0" width="50%" cellpadding="0" cellspacing="1" bgcolor="#999999">
            <tr>
              <td class="td2" align="center"> Period 1 </td>
              <td class="td2" align="center"> Period 2 </td>
              <td class="td2" align="center"> Period 3 </td>
            </tr>
            <tr>
              <td class="td2"><table border="0" width="100%">
                  <tr>
                    <td class="td2"> Days </td>
                    <td class="td2"> Rate </td>
                  </tr>
                  <tr>
                    <td class="td2"><html:text property="dmrgdays1" size="5" maxlength="5" styleClass="ftforminputsmall"/>
                    </td>
                    <td class="td2"><html:text property="dmrgdlyrate1" size="5" maxlength="8" styleClass="ftforminputsmall"/>
                    </td>
                  </tr>
              </table></td>
              <td class="td2"><table border="0" width="100%">
                  <tr>
                    <td class="td2"> Days </td>
                    <td class="td2"> Rate </td>
                  </tr>
                  <tr>
                    <td class="td2"><html:text property="dmrgdays2" size="5" maxlength="5" styleClass="ftforminputsmall"/>
                    </td>
                    <td class="td2"><html:text property="dmrgdlyrate2" size="5" maxlength="8" styleClass="ftforminputsmall"/>
                    </td>
                  </tr>
              </table></td>
              <td class="td2"><table border="0" width="100%">
                  <tr>
                    <td class="td2"> Rate </td>
                  </tr>
                  <tr>
                    <td class="td2"><html:text property="dmrgdlyrate3" size="5" maxlength="8" styleClass="ftforminputsmall"/>
                    </td>
                  </tr>
              </table></td>
            </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>



<tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
        <tr>
		  <td rowspan="4">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td2" colspan="4">
		  <strong><bean:message key="prompt.docsandclosing"/></strong> &nbsp;
		  </td>
		</tr>		 
        <tr>	
          <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.amsdocumentsclosing"/>:
		  </div>
		  </td>
          <td width="80%" class="td2">
		<html:select property="documentclosingdatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="documentclosingdatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="documentclosingdateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>				  
          </td>	  
        </tr>	
        <tr>	
          <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.tankclosing"/>:
		  </div>
		  </td>
          <td width="80%" class="td2">
		<html:select property="tankclosingdatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="tankclosingdatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="tankclosingdateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>				  
          </td>	  
        </tr>
      <tr>
          <td width="20%" class="td2" valign="top">
		  <div align="right">
		        <bean:message key="prompt.deliveryterminaltext"/>:
		  </div>
		  </td>
        <td class="td2" width="80%">
		<html:textarea rows="3" cols="80"  property="deliveryterminaltext" styleClass="ftforminputsmall"/>
		</td>
      </tr>        	        								
    </table>
	</td>
  </tr>
  
  
    <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
      <tr>
        <td rowspan="2"><img src="images/spacer.gif" height="20" width="1" border="0"/> </td>
        <td width="20%" class="td2" colspan="2">&nbsp;<strong><bean:message key="prompt.notes"/></strong> </td>
      </tr>
      <tr>
        <td colspan="2" class="td2" width="100%">
		<html:textarea rows="5" cols="110"  property="notes" styleClass="ftforminputsmall"/>
		</td>
      </tr>
    </table></td>
  </tr>
  
    	  
        </logic:notEqual>
		  

		
		  
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		          <td class="td7">
                  
      <logic:equal name="OrderhdrForm" property="action"
                  scope="request" value="Create">				  
        <html:submit styleClass="button1">
          <bean:message key="button.add"/>
        </html:submit>		
        <html:submit styleClass="button1" property="copyQuotationButton">
          <bean:message key="button.copyquote"/>
        </html:submit>		
		<html:text property="copyQuoteId" size="30" maxlength="20" styleClass="ftforminputsmall"/> 
      </logic:equal>		  
      <logic:equal name="OrderhdrForm" property="action"
                  scope="request" value="Delete">
        <html:submit styleClass="button1">
          <bean:message key="button.confirm"/>
        </html:submit>
      </logic:equal>
      <logic:equal name="OrderhdrForm" property="action"
                  scope="request" value="Edit">
        <html:submit styleClass="button1">
          <bean:message key="button.save"/>
        </html:submit>
      </logic:equal>
      <logic:notEqual name="OrderhdrForm" property="action"
                     scope="request" value="Delete">
        <html:reset styleClass="button1">
          <bean:message key="button.reset"/>
        </html:reset>
      </logic:notEqual>
      <html:cancel styleClass="button1">
        <bean:message key="button.cancel"/>
      </html:cancel>
              
	  </td>
  </tr>		  
    </table></td>
  </tr>
  
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
