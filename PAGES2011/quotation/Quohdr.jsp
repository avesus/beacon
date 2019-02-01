<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 *
 * NT	2009-03-23		ITT-200904-0001		Add Quotno Auto Generation
 * 											
 * NT	2010-01-19		201000006			Replace Addresss with Customers in Customer Name pull-down
 *
 * NT	2010-02-15		ITT-201001-0001		Add Demurrage Currency
 *
 * NT	2010-03-06		ITT-201003-0001		User Access Module (changes not commented) 
 *
 * NT	2011-05-23		ITT-201105-0001		Quotation Exchange Rates Update 
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


function checkExchgdateupd() 
{
	var dd = document.forms[0].exchgdatedd.value;
	var mm = document.forms[0].exchgdatemm.value;
	var yyyy = document.forms[0].exchgdateyyyy.value;
	var dd_ = document.forms[0].exchgdatedd_.value;
	var mm_ = document.forms[0].exchgdatemm_.value;
	var yyyy_ = document.forms[0].exchgdateyyyy_.value;
	MM_showHideLayers('div_exchgrateupd','','hide');
	if (dd!=dd_||mm!=mm_||yyyy!=yyyy_) {
		MM_showHideLayers('div_exchgrateupd','','show');
	}
}

</script>






<logic:equal name="QuohdrForm" property="action"
            scope="request" value="Create">
  <title><bean:message key="quohdr.title.create"/></title>
</logic:equal>
<logic:equal name="QuohdrForm" property="action"
            scope="request" value="Delete">
  <title><bean:message key="quohdr.title.delete"/></title>
</logic:equal>
<logic:equal name="QuohdrForm" property="action"
            scope="request" value="Edit">
  <title><bean:message key="quohdr.title.edit"/></title>
</logic:equal>	
<logic:equal name="QuohdrForm" property="action"
            scope="request" value="View">
  <title><bean:message key="quohdr.title.view"/></title>
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
	  <span class="heading2"><html:link action="/ListQuohdr"><bean:message key="quohdr.title.list"/></html:link></span>
	<span class="text6">&gt;</span>
	<span class="heading2">
<logic:equal name="QuohdrForm" property="action"
            scope="request" value="Create">
  <bean:message key="quohdr.title.create"/>
</logic:equal>
<logic:equal name="QuohdrForm" property="action"
            scope="request" value="Delete">
  <bean:message key="quohdr.title.delete"/>
</logic:equal>
<logic:equal name="QuohdrForm" property="action"
            scope="request" value="Edit">
  <bean:message key="quohdr.title.edit"/>
</logic:equal>
<logic:equal name="QuohdrForm" property="action"
            scope="request" value="View">
  <bean:message key="quohdr.title.view"/>
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


<html:form action="/SaveQuohdr" focus="quotno">
<html:hidden property="action"/>
<html:hidden property="id"/>
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
<logic:equal name="QuohdrForm" property="action"
            scope="request" value="Create">
  <bean:message key="quohdr.title.create"/>
</logic:equal>
<logic:equal name="QuohdrForm" property="action"
            scope="request" value="Delete">
  <bean:message key="quohdr.title.delete"/>
</logic:equal>
<logic:equal name="QuohdrForm" property="action"
            scope="request" value="Edit">
  <bean:message key="quohdr.title.edit"/>
</logic:equal>
<logic:equal name="QuohdrForm" property="action"
            scope="request" value="View">
  <bean:message key="quohdr.title.view"/>
</logic:equal>		  
		  </strong></td>
        </tr>
    </table>
	</td>
  </tr>

      <logic:equal name="QuohdrForm" property="action"
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
		        <bean:message key="prompt.quotno"/>:
		  </div>
		  </td>
          <td width="80%" class="td2">
        <html:text property="quotno" size="40" disabled="true" maxlength="40" styleClass="ftforminputsmall"/>  
          </td>
        </tr>
	</table>
	</td>
	</tr>
	</logic:equal>		

      <logic:notEqual name="QuohdrForm" property="action"
                     scope="request" value="Delete">  
  <tr>
    <td width="50%" valign="top">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">  				
        <tr>
		  <td rowspan="7">
		  	<img src="images/spacer.gif" height="89" width="1" border="0"/>
		  </td>		
          <td width="40%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.quotno"/>:
		  </div>
		  </td>
          <td width="60%" class="td2">
		  
<c:set var="quotnoAutoGenerate">
<bean:message bundle="systemResources" key="quotno.auto.generate"/>
</c:set> 
		  
		  <c:if test="${QuohdrForm.action == 'Create' and quotnoAutoGenerate == 'no'}">
        	<html:text property="quotno" size="40" maxlength="40" styleClass="ftforminputsmall"/>
		  </c:if>
		  <c:if test="${QuohdrForm.action != 'Create' or quotnoAutoGenerate == 'yes'}">
        	<html:text property="quotno" size="40" disabled="true" maxlength="40" styleClass="ftforminputsmall"/>
			<html:hidden property="quotno"/>			
		  </c:if>
          </td>
        </tr>	
        <tr>
          <td width="40%" class="td2">
		  <div align="right">
		       <bean:message key="prompt.quotedate"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td2">
		<html:select property="quotedatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="quotedatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="quotedateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	  	  
          </td>
        </tr>
        <tr>
          <td width="40%" class="td2">
		  <div align="right">
		       <bean:message key="prompt.effectivedate"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td2">
		<html:select property="effectivedatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="effectivedatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="effectivedateyyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>	  	  
          </td>
        </tr>			
        <tr>
          <td width="40%" class="td2">
		  <div align="right">
		       <bean:message key="prompt.expirydate"/>:
		  </div>		  
		  </td>
          <td width="60%" class="td2">
		<html:select property="expirydatedd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="expirydatemm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="expirydateyyyy" styleClass="ftforminputsmall">
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
		<html:select property="exchgdatedd" styleClass="ftforminputsmall" onchange="checkExchgdateupd();">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="exchgdatemm" styleClass="ftforminputsmall" onchange="checkExchgdateupd();">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="exchgdateyyyy" styleClass="ftforminputsmall" onchange="checkExchgdateupd();">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>

	        		 	  
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
			<html:option value=""><bean:message key="prompt.selectashipmethod"/></html:option>
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
		  	<img src="images/spacer.gif" height="89" width="1" border="0"/>
		  </td>
          <td width="40%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.createdby"/>:
		  </div>
		  </td>
          <td width="60%" class="td10">
		&nbsp;<html:hidden property="quotebyuserid" styleClass="ftforminputsmall" write="true"/>		  
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
			<html:option value=""><bean:message key="prompt.selectacompany"/></html:option>
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
			<html:option value=""><bean:message key="prompt.selectadepartment"/></html:option>
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
			<html:option value=""><bean:message key="prompt.selectaactivity"/></html:option>
			<html:options collection="activitys" property="id.codekey" labelProperty="descr"/>	
		</html:select>				  
          </td>
        </tr>
        <tr>
          <td width="20%" class="td2" colspan="2">
        	
        
<!--sITT-201105-0001-->       
<input type="hidden" name="exchgdatedd_" value='<bean:write property="exchgdatedd" name="QuohdrForm" />'/>
<input type="hidden" name="exchgdatemm_" value='<bean:write property="exchgdatemm" name="QuohdrForm" />'/>
<input type="hidden" name="exchgdateyyyy_" value='<bean:write property="exchgdateyyyy" name="QuohdrForm" />'/>       	
<div id='div_exchgrateupd' style='position:relative; width:400px; height:41px; visibility:hidden; border: 1px solid #5989D7;'>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#5989D7">
          <tr>
            <td style="font-family: Verdana, Arial, Helvetica;font-size: 10px; font-weight: normal; color: white; padding:2px 2px 2px 2px; background:#5989D7;">Quotation Exchange Rate Update</td>               
          </tr>	          
          <tr>
            <td style="font-family: Verdana, Arial, Helvetica;font-size: 10px; font-weight: normal; color: black; padding:2px 2px 2px 2px; background-color:#ECE9D8;">
              Would you like to update the Quotation Charge and Cost lines<br/> 
              using the new Exchange Rate Date entered? <input type="checkbox" name="exchgrateupd" styleClass="ftforminputsmall" value='YES'/>
            </td>               
          </tr>			 
	</table>
</div>			
<script language="JavaScript">
<!--	
MM_showHideLayers('div_exchgrateupd','','hide');
-->
</script>
<!--eITT-201105-0001-->

		<img src="images/spacer.gif" height="10" width="1" border="0"/>
                	  
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
          <td width="10%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.status"/>:
		  </div>
		  </td>
          <td width="40%" class="td9">
					  
<logic:notEqual name="QuohdrForm" property="action" scope="request" value="Create">

                      <c:if test="${QuohdrForm.quotestatus == 'PENDING'}">
					  	<img src="images/icon_warn_12_12.gif" width="12" height="12" alt='<c:out value="${QuohdrForm.quotestatus}"/>'/>
                      </c:if>
                      <c:if test="${QuohdrForm.quotestatus == 'APPROVED'}">
					  	<img src="images/icon_tick_12_12.gif" width="12" height="12" alt='<c:out value="${QuohdrForm.quotestatus}"/>'/>
                      </c:if>	
                      <c:if test="${QuohdrForm.quotestatus == 'REJECTED'}">
					  	<img src="images/icon_stop_12_12.gif" width="12" height="12" alt='<c:out value="${QuohdrForm.quotestatus}"/>'/>
                      </c:if>


				  					  
	<logic:equal name="QuohdrForm" property="quotestatus" scope="request" value="PENDING">			
       &nbsp;<html:hidden property="quotestatus" styleClass="ftforminputsmall" write="true"/>		
		  &nbsp;	
		<c:if test="${sessionScope.user.userid == requestScope.QuohdrForm.quotebyuserid}">	    	   
<logic:notEqual name="QuohdrForm" property="customeraddrkey" scope="request" value="">	
        	<app:linkQuohdr page="/ListQuoapproveRequest.do?"><bean:message key="prompt.requestapproval"/></app:linkQuohdr>
</logic:notEqual>
<logic:equal name="QuohdrForm" property="customeraddrkey" scope="request" value="">	
        	<bean:message key="prompt.requestapproval"/>
</logic:equal>			
		</c:if>
	</logic:equal>	
	

	
	<logic:notEqual name="QuohdrForm" property="quotestatus" scope="request" value="PENDING">			
		<c:if test="${sessionScope.user.securitylevel == '1'}">
			
		<html:select property="quotestatus" styleClass="ftforminputsmall">
			<html:option value="APPROVED"><bean:message key="prompt.approved"/></html:option>
			<html:option value="PENDING"><bean:message key="prompt.pending"/></html:option>	
			<html:option value="REJECTED"><bean:message key="prompt.rejected"/></html:option>						
		</html:select>		
			
		</c:if>
		<c:if test="${sessionScope.user.securitylevel != '1'}">		
       		&nbsp;<html:hidden property="quotestatus" styleClass="ftforminputsmall" write="true"/>	
		</c:if>		
	</logic:notEqual>
		
</logic:notEqual> 

<logic:equal name="QuohdrForm" property="action" scope="request" value="Create">		
	<html:hidden property="quotestatus"/>	
</logic:equal> 

          </td>
          <td width="15%" class="td2">
		  <div align="right">
                <bean:message key="prompt.rejectreason"/>:
		  </div>
		  </td>
          <td width="35%" class="td9">
						<table border="0" width="100%" cellpadding="0" cellspacing="0">
							<tr>
								<td width="10%" class="td9">
<html:hidden property="rejectreason" styleClass="ftforminputsmall" write="true"/>
								</td>
								<td width="90%" class="td9">	
<logic:notEqual name="QuohdrForm" property="notes" value="">									
									<img src='images/icons/icon_information_12_12.png' 
										border='0' 
										alt='<c:out value="${QuohdrForm.notes}"/>'/>		
</logic:notEqual>
								</td>
							</tr>
						</table>		  		  	  
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
			<html:options collection="customers" property="addrkey" labelProperty="name"/><!--201000006-->
		</html:select>					  
          </td>
          <td width="5%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.reference"/>:
		  </div>
		  </td>
          <td width="45%" class="td2">
        <html:text property="customerref" size="30"  maxlength="20" styleClass="ftforminputsmall"/>				  
          </td>		  
        </tr>																		
    </table>
	</td>
  </tr>	
 
 

  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">  
        <tr>
		  <td rowspan="11">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td2" colspan="4">
		  <strong><bean:message key="prompt.proposedcustomerdetails"/></strong> &nbsp;
		  </td>
		</tr>	
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.name"/>:
		  </div>
		  </td>
          <td width="80%" class="td2" colspan="3">
        <html:text property="customername" size="70"  maxlength="50" styleClass="ftforminputsmall"/>
<logic:notEqual name="QuohdrForm" property="action" scope="request" value="View">		
<app:linkQuohdr page="/EditAddressCreate.do?"><html:img src="images/buttons/btn_add_address.png" alt="Add Customer Address" border="0" align="top"/></app:linkQuohdr>
</logic:notEqual>					  
          </td>		  
        </tr>		
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.address"/>:
		  </div>
		  </td>
          <td width="80%" class="td2" colspan="3">
        <html:text property="customeraddr1" size="70"  maxlength="50" styleClass="ftforminputsmall"/>					  
          </td>		  
        </tr>
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		  </div>
		  </td>
          <td width="80%" class="td2" colspan="3">
        <html:text property="customeraddr2" size="70"  maxlength="50" styleClass="ftforminputsmall"/>						  
          </td>		  
        </tr>
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		  </div>
		  </td>
          <td width="80%" class="td2" colspan="3">
        <html:text property="customeraddr3" size="70"  maxlength="50" styleClass="ftforminputsmall"/>							  
          </td>		  
        </tr>
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		  </div>
		  </td>
          <td width="80%" class="td2" colspan="3">
        <html:text property="customeraddr4" size="70"  maxlength="50" styleClass="ftforminputsmall"/>							  
          </td>		  
        </tr>		
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.contact"/>:
		  </div>
		  </td>
          <td width="80%" class="td2" colspan="3">
        <html:text property="customercontact" size="50"  maxlength="50" styleClass="ftforminputsmall"/>					  
          </td>		  
        </tr>	
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.phone"/>:
		  </div>
		  </td>
          <td width="80%" class="td2" colspan="3">
        <html:text property="customertelno" size="50"  maxlength="50" styleClass="ftforminputsmall"/>					  
          </td>		  
        </tr>
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.fax"/>:
		  </div>
		  </td>
          <td width="80%" class="td2" colspan="3">
        <html:text property="customerfaxno" size="50"  maxlength="50" styleClass="ftforminputsmall"/>					  
          </td>		  
        </tr>
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.email"/>:
		  </div>
		  </td>
          <td width="80%" class="td2" colspan="3">
        <html:text property="customeremail" size="50"  maxlength="50" styleClass="ftforminputsmall"/>					  
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
			<html:option value=""><bean:message key="prompt.selectashipper"/></html:option>
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
		        <bean:message key="prompt.consignee"/>:
		  </div>
		  </td>
          <td width="30%" class="td2">
		<html:select property="consigneeaddrkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaconsignee"/></html:option>
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
		        <bean:message key="prompt.forwardagent"/>:
		  </div>
		  </td>
          <td width="30%" class="td2">
		<html:select property="fwdagentaddrkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaforwardagent"/></html:option>
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
		        <bean:message key="prompt.broker"/>:
		  </div>
		  </td>
          <td width="30%" class="td2">
		<html:select property="brokeraddrkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectabroker"/></html:option>
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
        <tr>
          <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.quotecurrency"/>:
		  </div>
		  </td>
          <td width="80%" class="td2" colspan="3">
		  		<c:if test="${QuohdrForm.action == 'Create'}">
					<html:select property="ccykey" styleClass="ftforminputsmall"> 
						<html:option value=""><bean:message key="prompt.selectacurrency"/></html:option> 
						<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
					</html:select>				
				</c:if>	
		  		<c:if test="${QuohdrForm.action != 'Create'}">
        			<strong><bean:write property="ccykey" name="QuohdrForm"/></strong>
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
	<td rowspan="1">
		<img src="images/spacer.gif" height="20" width="1" border="0"/>
	</td>		
          <td width="20%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.primaryproduct"/>:
		  </div>
		  </td>
          <td width="80%" class="td2">
		<html:select property="productkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectaproduct"/></html:option>
			<html:options collection="products" property="productkey" labelProperty="tradname"/>	
		</html:select>				  
          </td>	  
        </tr>				
    </table>
	</td>
  </tr>
    	
  <tr>
    <td width="50%" valign="top">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999"> 
	       <tr>
		  <td rowspan="6">
		  	<img src="images/spacer.gif" height="20" width="1" border="0"/>
		  </td>
          <td width="20%" class="td2" colspan="2">
		  <strong><bean:message key="prompt.locationdetails"/></strong> &nbsp;
		  </td>
		</tr>	 
        <tr>	
          <td width="40%" class="td2">
		  <div align="right">
		         <bean:message key="prompt.pickupplant"/>:
		  </div>
		  </td>
          <td width="60%" class="td2">
		<html:select property="ldglocationkey1" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="pickuplocations1" property="locationkey" labelProperty="shortName"/>	
		</html:select>			  
          </td>
        </tr>
        <tr>
          <td width="40%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.portloading"/>:
		  </div>
		  </td>
          <td width="60%" class="td2">
		<html:select property="ldglocationkey2" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="ports" property="locationkey" labelProperty="shortLabel"/>	
		</html:select>			  
          </td>
        </tr>		
        <tr>
          <td width="40%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.portdischarge"/>:
		  </div>
		  </td>
          <td width="60%" class="td2">
		<html:select property="dchlocationkey2" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="ports" property="locationkey" labelProperty="shortLabel"/>	
		</html:select>			  
          </td>
        </tr>			
        <tr>
          <td width="40%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.deliveryplant"/>:
		  </div>
		  </td>
          <td width="60%" class="td2">
		<html:select property="dchlocationkey1" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="deliverylocations1" property="locationkey" labelProperty="shortName"/>	
		</html:select>			  
          </td>
        </tr>	
        <tr>
          <td width="20%" class="td2" colspan="2">
		<img src="images/spacer.gif" height="56" width="1" border="0"/>		  
		  </td>
        </tr>									
    </table>
	    </td>
	    <td width="50%" valign="top">
<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">
        <tr>
		  <td rowspan="7">
		  	<img src="images/spacer.gif" height="89" width="1" border="0"/>
		  </td>
          <td width="40%" class="td2" colspan="2">
		        &nbsp;<strong><bean:message key="prompt.demurrage"/></strong>
		  </td>
		</tr>	
                                    
        <tr>
          <td width="40%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.location"/>:
		  </div>
		  </td>
          <td width="60%" class="td2">
		<html:select property="dmrglocationkey" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.selectalocation"/></html:option>
			<html:options collection="ports" property="locationkey" labelProperty="locationName"/>	
		</html:select>
		  </td>
		</tr>
        	  				
        <tr>
          <td class="td2"><div align="right"> <bean:message key="prompt.freedays"/>: </div></td>
          <td class="td2">

<table width="100%"  border="0" cellpadding="0" cellspacing="0">
		  	<tr>
				<td class="td2" colspan="3">
		  <html:text property="dmrgfreedays" size="5" maxlength="5" styleClass="ftforminputsmall"/> 
		  		</td>
			</tr>
		</table>		  

		</td>
        </tr>
  
<!--sITT-201001-0001-->        
                <tr>
          <td width="40%" class="td2">
		  <div align="right">
		        <bean:message key="prompt.ccy"/>:
		  </div>
		  </td>    
          <td width="60%" class="td2">    
					<html:select property="dmrgccykey" styleClass="ftforminputsmall"> 
						<html:option value=""><bean:message key="prompt.selectacurrency"/></html:option> 
						<html:options collection="ccys" property="ccykey" labelProperty="ccykey"/> 										
					</html:select>	
		  </td>
		</tr>
<!--eITT-201001-0001--> 
        
        <tr>
          <td width="40%" class="td2" valign="top">
		  <div align="right">
		        <bean:message key="prompt.rates"/>:		  
<INPUT type="image" id="findDmrgratesButton" name="findDmrgratesButton" src="images/arrow_next_grey.gif"/>	
		  </div>
		  </td>
          <td width="60%" class="td2">
<table border="0" width="100%" cellpadding="0" cellspacing="1" bgcolor="#999999">
	<tr>
		<td class="td2" align="center">
		<bean:message key="prompt.period1"/>
		</td>
		<td class="td2" align="center">
		<bean:message key="prompt.period2"/>
		</td>
		<td class="td2" align="center">
		<bean:message key="prompt.period3"/>
		</td>
	</tr>
	<tr>
		<td class="td2">
			<table border="0" width="100%">
				<tr>
					<td class="td2">
					<bean:message key="prompt.days"/>
					</td>
					<td class="td2">
					<bean:message key="prompt.rate"/>
					</td>
				</tr>
				<tr>
					<td class="td2">
        <html:text property="dmrgdays1" size="5" maxlength="5" styleClass="ftforminputsmall"/>					
					</td>
					<td class="td2">
        <html:text property="dmrgdlyrate1" size="5" maxlength="8" styleClass="ftforminputsmall"/>					
					</td>
				</tr>								
			</table>
		</td>
		<td class="td2">
			<table border="0" width="100%">
				<tr>
					<td class="td2">
					<bean:message key="prompt.days"/>
					</td>
					<td class="td2">
					<bean:message key="prompt.rate"/>
					</td>
				</tr>
				<tr>
					<td class="td2">
        <html:text property="dmrgdays2" size="5" maxlength="5" styleClass="ftforminputsmall"/>					
					</td>
					<td class="td2">
        <html:text property="dmrgdlyrate2" size="5" maxlength="8" styleClass="ftforminputsmall"/>
					</td>
				</tr>								
			</table>		
		</td>
		<td class="td2">
			<table border="0" width="100%">
				<tr>
					<td class="td2">
					<bean:message key="prompt.rate"/>
					</td>
				</tr>
				<tr>
					<td class="td2">
<html:text property="dmrgdlyrate3" size="5" maxlength="8" styleClass="ftforminputsmall"/>					
					</td>
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
  
    	  
        </logic:notEqual>
		  

		
			  
  <tr>
    <td colspan="2">
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#999999">

        <tr>
		          <td class="td7">

<logic:equal name="QuohdrForm" property="action" scope="request" value="Create"> 
	<input type="submit" value='<bean:message key="button.add"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}">		  
</logic:equal> 

<logic:equal name="QuohdrForm" property="action"
                  scope="request" value="Delete"> 
	<html:submit styleClass="button1"> <bean:message key="button.confirm"/> </html:submit> 
</logic:equal> 

<logic:equal name="QuohdrForm" property="action" scope="request" value="Edit"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal> 
<logic:equal name="QuohdrForm" property="action" scope="request" value="View"> 
	<input type="submit" value='<bean:message key="button.save"/>' class="button1" onClick="if (searchWin != null) {searchWin.close();}"> 
</logic:equal>

<logic:notEqual name="QuohdrForm" property="action" scope="request" value="Delete"> 
	<html:reset styleClass="button1"> <bean:message key="button.reset"/> </html:reset> 
</logic:notEqual>
  
	<input type="submit" name="org.apache.struts.taglib.html.CANCEL" value='<bean:message key="button.cancel"/>' onClick="if (searchWin != null) {searchWin.close();}; bCancel=true;" class="button1">	  
	
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
