// global flag
var isIE = false;

// global request and XML document objects
var req;

// retrieve XML document (reusable generic function);
// parameter is URL string (relative or complete) to
// an .xml file whose Content-Type is a valid XML
// type, such as text/xml; XML source must be from
// same domain as HTML file
function loadXMLDocRefreshCcyex(value) {
	var url = '';
		var ccykey = document.forms[0].elements['ccykey'];	
		var invoiceccykey = document.forms[0].elements['invoiceccykey'];
		if (value == 'xrateinv') {
			url = "RefreshQuotationCcyex?"+
				"fromccykey="+ccykey.options[ccykey.selectedIndex].value+
				"&toccykey="+invoiceccykey.options[invoiceccykey.selectedIndex].value+
				"&xfield="+value+
				"&id1="+document.forms[0].quohdrId.value+
				"&id2="+document.forms[0].quomovId.value;			
		} else {
			url = "RefreshQuotationCcyex?"+
				"fromccykey="+ccykey.options[ccykey.selectedIndex].value+
				"&toccykey="+document.forms[0].baseccykey.value+
				"&xfield="+value+
				"&id1="+document.forms[0].quohdrId.value+
				"&id2="+document.forms[0].quomovId.value;				
		}
		//alert(url);
    // branch for native XMLHttpRequest object
    if (window.XMLHttpRequest) {
        req = new XMLHttpRequest();
            req.onreadystatechange = processReqChangeRefreshCcyex;
        req.open("GET", url, true);
        req.send(null);
    // branch for IE/Windows ActiveX version
    } else if (window.ActiveXObject) {
        isIE = true;
        req = new ActiveXObject("Microsoft.XMLHTTP");
        if (req) {
            req.onreadystatechange = processReqChangeRefreshCcyex;	
            req.open("GET", url, true);
            req.send();
        }
    }
}


// invoked by "Category" select element change;
// loads chosen XML document, clears Fromlocationkeys select
// element, loads new items into Fromlocationkeys select element
function processRefreshCcyex(value) {
	//alert(value);
            try {
                    loadXMLDocRefreshCcyex(value);
            }
            catch(e) {
                var msg = (typeof e == "string") ? e : ((e.message) ? e.message : "Unknown Error");
                alert("Unable to get XML data:\n" + msg);
                return;
            }
}

// handle onreadystatechange event of req object
function processReqChangeRefreshCcyex() {
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
            							buildRefreshCcyex();											   
                           }
                           break;
           }
   }	
}

//function clearXratebase() {
//	document.forms[0].xratebase.value = "1.0";									   
//}
// fill select list with items from
// the current XML document
function buildRefreshCcyex() {
    var items = req.responseXML.getElementsByTagName("ccyex");
	var xfield = document.forms[0].elements[getElementTextNS("", "xfield", items[0], 0)];
	xfield.value = getElementTextNS("", "exrate", items[0], 0);
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

