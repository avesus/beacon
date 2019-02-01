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

<%if (session == null || session.getAttribute(Constants.USER_KEY) == null) { %>
<html:html>
<head>

<title>Unit Lookup Search</title>


<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<script language="JavaScript">
	window.opener.location.href = "<html:rewrite forward='welcome'/>";
	window.opener.focus();
</script>
</head>
<body/>
</html:html>
<%} else { %>

<html:html>
<head>


<title>Unit Lookup Search</title>


<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<script language="JavaScript">
var searchWin;

function locationcodeSearch(field){
	var url  = 'EditLocationcodeSearch.do?maxResults=999&headerInfo1=&headerInfo2='+field+
					'&id='+document.forms[0].elements[field].value+
					'&searchString1='+document.forms[0].searchString4.value;
	searchWin   = window.open('<html:rewrite href="'+url+'"></html:rewrite>', null, 'status=no,menubar=no,location=no,resizable,scrollbars,width=950,height=600');
	searchWin.focus();
}
function clearLocationcode(){
    document.forms[0].searchString5.value = '';
}
</script>





<script language="javascript">
// global flag
var isIE = false;

// global request and XML document objects
var req;
var strURL;

// retrieve XML document (reusable generic function);
// parameter is URL string (relative or complete) to
// an .xml file whose Content-Type is a valid XML
// type, such as text/xml; XML source must be from
// same domain as HTML file
function loadXMLDoc(value) {
strURL = "RefreshLocationcodeList?countrykey="+value;
    // branch for native XMLHttpRequest object
    if (window.XMLHttpRequest) {
        req = new XMLHttpRequest();
        req.onreadystatechange = processReqChange;
        req.open("GET", strURL, true);
        req.send(null);
    // branch for IE/Windows ActiveX version
    } else if (window.ActiveXObject) {
        isIE = true;
        req = new ActiveXObject("Microsoft.XMLHTTP");
        if (req) {
            req.onreadystatechange = processReqChange;
            req.open("GET", strURL, true);
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
function RefreshLocationcodeList(evt) {
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
    var select = document.getElementById('searchString5');
    while (select.length > 0) {
        select.remove(0);
    }
}
// fill select list with items from
// the current XML document
function buildLocationcodeList() {
    var select = document.getElementById('searchString5');
    var items = req.responseXML.getElementsByTagName('locationcode');
    // loop through <locationcode> elements, and add each nested
    // <key> element to select element
        appendToSelect(
					select, 
					'',
		            document.createTextNode('- No Selection -')
					);
    for (var i = 0; i < items.length; i++) {
	var key = getElementTextNS("", "key", items[i], 0);	
	//var ldesc = document.createTextNode(getElementTextNS("", "ldesc", items[i], 0));
        appendToSelect(
					select, 
					getElementTextNS("", "key", items[i], 0),
		            document.createTextNode(getElementTextNS("", "ldesc", items[i], 0))
					);
    }
}
</script>


<script language="javascript">
        function onLoadFunctions() {
loadXMLDoc(document.getElementById('searchString4').value);

        }
</script>



</head>


<body onUnload="if (searchWin != null) {searchWin.close()}" onLoad="onLoadFunctions();">


<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr bgcolor="#F1F1F1"><td><span class="header2">Unit Lookup Search</span></td></tr>

  <tr valign="top" bgcolor="#D0D0D0">
    <td height="1" colspan="2"></td>
  </tr>
    
  <tr>
    <td>
	
	            <html:form action="/ListUnitSearch" focus="searchString1">
				
<html:hidden property="maxResults" />
<html:hidden property="searchString5" />
				
	<div style="OVERFLOW:auto; width:850px; height:450px;">
	
	
        <table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
          <tr>
            <td>

              <table width="80%" border="0" cellspacing="1" cellpadding="0" bgcolor="#999999">
			  
                <tr>
                  <td><table width="100%" border="0" cellspacing="2" cellpadding="2" bgcolor="#ffffff">
                      <tr>
                        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                </table></td>
                            </tr>
                            
							<tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td width="22%" class="label2"><div align="right"> Unit: </div></td>
                                    <td width="78%" class="label2"><html:text property="searchString1" size="50" styleClass="forminput1"/> </td>
                                  </tr>
                                </table></td>
                            </tr>
                            
							<tr>
                              <td><table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
                                  <tr>
                                    <td width="22%" class="label2"><div align="right">Location:</div></td>
                                    <td width="78%" class="label2">
		<html:select property="searchString3" styleClass="forminput1">
			<html:option value="">- No Selection -</html:option>
			<html:options collection="locations" property="locationkey" labelProperty="labelProperty"/>	
		</html:select> 
									</td>
                                  </tr>
                                  <tr>
                                    <td width="22%" class="label2"><div align="right">Country:</div></td>
                                    <td width="78%" class="label2">
									<html:select 
										property="searchString4" 
										styleClass="forminput1" 
										onchange="RefreshLocationcodeList(event)"> 
									<html:option value="">- No Selection -</html:option> 
									<html:options collection="countrys" property="countrykey" labelProperty="country"/> 
									</html:select>									
									</td>
                                  </tr>							  

<%--                                  <tr>
                                    <td width="22%" class="label2"><div align="right">Location UN Code:</div></td>
                                    <td width="78%" class="label2">
									<html:select 
										property="searchString5" 
										styleClass="forminput1"> 
									<html:option value="">- No Selection -</html:option> 
									</html:select>
									 </td>
                                  </tr>	--%>
		
								  
                                </table></td>
                            </tr>

<tr>
    <td>
	<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#ffffff">
        <tr>
          <td class="label2" width="100%">
		        &nbsp;<strong><bean:message key="prompt.equipmentparameters"/></strong>
		  </td>
		</tr>		
              <tr> 
                <td class="label2" width="100%"> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ffffff">
              <TR> 
                <TD class="label2">&nbsp;</TD>
                <TD class="label2">
		<html:select property="searchString7" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp1s" property="id.codekey" labelProperty="descr"/>
		</html:select>				 
				</TD>
              </TR>
              <TR> 
                <TD class="label2" width="22%" align="right"></TD>
                <TD class="label2" width="78%">
		<html:select property="searchString8" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp2s" property="id.codekey" labelProperty="descr"/>
		</html:select>
						</TD>
              </TR>
              <TR> 
                <TD class="label2" width="22%" align="right"></TD>
                <TD class="label2" width="78%">
		<html:select property="searchString9" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp3s" property="id.codekey" labelProperty="descr"/>
		</html:select>
						</TD>
              </TR>
              <TR> 
                <TD class="label2" width="22%" align="right"></TD>
                <TD class="label2" width="78%">
		<html:select property="searchString10" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp4s" property="id.codekey" labelProperty="descr"/>
		</html:select>
						</TD>
              </TR>
              <TR> 
                <TD class="label2" width="22%" align="right"></TD>
                <TD class="label2" width="78%">
		<html:select property="searchString11" styleClass="forminput1">
			<html:option value=""><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp5s" property="id.codekey" labelProperty="descr"/>
		</html:select>
						</TD>
              </TR>			  			  			  
            </table>
			</td>
              </tr>
    </table></td>
  </tr>
  
                            
                            <tr>
			        <td>
    
				        <div class="btnPane"> 
						<button id="searchButton" class="btn btnFF" type="submit">
						<img class=" IM search-default" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        					<span>Search</span>
        				</button>    

						<button id="buttonCancel" class="btn btnFF" type="submit" onClick="window.close();window.opener.focus()" property="ignore">
			                    <img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        						<span><bean:message key="button.cancel"/></span>
			            </button>                               
				        </div>
                 
      				</td>
				</tr>
                            
                            
                          </table></td>
                      </tr>
                    </table></td>
                </tr>
				
              </table> 
			  
			  </td>
          </tr>
        </table>
      </div>
	  
</html:form>
	  
	  </td>
  </tr>
  
</table>
</body>
</html:html>
<% } %>