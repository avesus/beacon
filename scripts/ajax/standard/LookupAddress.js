var isIE = false;
var req;

function loadXMLDocLookupAddress(field) {
	var url = '';
	var elem = document.forms[0].elements[field];	
	var value = elem.value;
	
	if (value!="") {
		url = "LookupAddress?addrkey="+value+"&xfield="+field;

	    if (window.XMLHttpRequest) {
    	    req = new XMLHttpRequest();
        	req.onreadystatechange = processReqChangeLookupAddress;
	        req.open("GET", url, true);
    	    req.send(null);
	    } else if (window.ActiveXObject) {
    	    isIE = true;
        	req = new ActiveXObject("Microsoft.XMLHTTP");
	        if (req) {
    	        req.onreadystatechange = processReqChangeLookupAddress;	
        	    req.open("GET", url, true);
            	req.send();
	        }
    	}
	}
	
}


function processLookupAddress(field) {
            try {
                    loadXMLDocLookupAddress(field);
            }
            catch(e) {
                var msg = (typeof e == "string") ? e : ((e.message) ? e.message : "Unknown Error");
                alert("Unable to get XML data:\n" + msg);
                return;
            }
}


function processReqChangeLookupAddress() {
	if (req.readyState == 4) {
           strResponse = req.responseText;	   
           switch (req.status) {	   
                   case 404:
                           alert('Error: Not Found. The requested URL ' + 
                                   strURL + ' could not be found.');
                           break;
                   case 500:			   
                           handleErrFullPage(strResponse);						   
                           break;
                   default:
                           if (strResponse.indexOf('Error:') > -1 || 
                                   strResponse.indexOf('Debug:') > -1) {
                                   alert(strResponse);
                           }
                           else {
            					buildLookupAddress();											   
                           }
                           break;
           }
   }	
}



function buildLookupAddress() {	
    var items = req.responseXML.getElementsByTagName("address");
	
	try {
		var ccykey = document.forms[0].elements['ccykey'];
		ccykey.value = getElementTextNS("", "ccykey", items[0], 0);	
	} catch(e) {
	}	
	try {
		var paymentterm = document.forms[0].elements['paymentterm'];	
		paymentterm.value = getElementTextNS("", "paytermstext", items[0], 0);
	} catch(e) {
	}
	try {
		var invoiceccykey = document.forms[0].elements['invoiceccykey'];	
		invoiceccykey.value = getElementTextNS("", "ccykey", items[0], 0);
	} catch(e) {
	}
	try {
		var customername = document.forms[0].elements['customername'];	
		customername.value = getElementTextNS("", "name", items[0], 0);		
		var customeraddr1 = document.forms[0].elements['customeraddr1'];	
		customeraddr1.value = getElementTextNS("", "addr1", items[0], 0);
		var customeraddr2 = document.forms[0].elements['customeraddr2'];	
		customeraddr2.value = getElementTextNS("", "addr2", items[0], 0);
		var customeraddr3 = document.forms[0].elements['customeraddr3'];	
		customeraddr3.value = getElementTextNS("", "addr3", items[0], 0);
		var customeraddr4 = document.forms[0].elements['customeraddr4'];	
		customeraddr4.value = getElementTextNS("", "addr4", items[0], 0);	
		var customertelno = document.forms[0].elements['customertelno'];	
		customertelno.value = getElementTextNS("", "telno", items[0], 0);	
		var customerfaxno = document.forms[0].elements['customerfaxno'];	
		customerfaxno.value = getElementTextNS("", "faxno", items[0], 0);	
		var customeremail = document.forms[0].elements['customeremail'];	
		customeremail.value = getElementTextNS("", "email", items[0], 0);		
	} catch(e) {
	}	
	
}


function getElementTextNS(prefix, local, parentElem, index) {
    var result = "";
    if (prefix && isIE) {
        result = parentElem.getElementsByTagName(prefix + ":" + local)[index];
    } else {
        result = parentElem.getElementsByTagName(local)[index];
    }
    if (result) {
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
        try {
                errorWin = window.open('', 'errorWin');
                errorWin.document.body.innerHTML = strIn;
        }
        catch(e) {
                alert('An error occurred, but the error message cannot be' +
                        ' displayed because of your browser\'s pop-up blocker.\n' +
                        'Please allow pop-ups from this Web site.');
        }
}

