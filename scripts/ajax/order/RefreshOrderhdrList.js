


// retrieve XML document (reusable generic function);
// parameter is URL string (relative or complete) to
// an .xml file whose Content-Type is a valid XML
// type, such as text/xml; XML source must be from
// same domain as HTML file
function loadXMLDocRefreshOrderhdrList() {
	var url = '';
	url = "RefreshOrderhdrList?userid="+document.forms[0].userid.value;			

    // branch for native XMLHttpRequest object
    if (window.XMLHttpRequest) {
        req = new XMLHttpRequest();
            req.onreadystatechange = processReqRefreshOrderhdrList;
        req.open("GET", url, true);
        req.send(null);
    // branch for IE/Windows ActiveX version
    } else if (window.ActiveXObject) {
        isIE = true;
        req = new ActiveXObject("Microsoft.XMLHTTP");
        if (req) {
            req.onreadystatechange = processReqRefreshOrderhdrList;	
            req.open("GET", url, true);
            req.send();
        }
    }
}



function processRefreshOrderhdrList() {
	try {
    	loadXMLDocRefreshOrderhdrList();
            }
            catch(e) {
                var msg = (typeof e == "string") ? e : ((e.message) ? e.message : "Unknown Error");
                alert("Unable to get XML data:\n" + msg);
                return;
            }
}

// handle onreadystatechange event of req object
function processReqRefreshOrderhdrList() {
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
            							buildRefreshOrderhdrList();											   
                           }
                           break;
           }
   }	
}


// fill select list with items from
// the current XML document
function buildRefreshOrderhdrList() {
	var resultsDiv = document.getElementById("saved_results2");	
    removeChildren(resultsDiv);	
	
    var items = req.responseXML.getElementsByTagName("orderhdrlist");		
    for (var i = 0; i < items.length; i++) {	
		var orderhdrid = getElementTextNS("", "orderhdrid", items[i], 0);
		var orderno = getElementTextNS("", "orderno", items[i], 0);
		var customeraddrkey = getElementTextNS("", "customeraddrkey", items[i], 0);
		var invoicestatus = getElementTextNS("", "invoicestatus", items[i], 0);
		var orderdate = getElementTextNS("", "orderdate", items[i], 0);		
		var url = '/beacon/EditOrderhdr.do?action=Edit&id='+orderhdrid;
		addRowOrderhdrList(orderhdrid,orderno,customeraddrkey,invoicestatus,orderdate,url);
    }	
}





      //var rowCounter = 3;
      function addRowOrderhdrList(value1, value2, value3, value4, value5, value6) {

        //if (rowCounter == 3) {
        //}
        var t = createTable("sb-result2");
        var tr = createTableRow(t);
        //var rowCell = createTableCell(tr,"sb-row");
        var cell1 = createTableCell(tr,"sb-cell21");
        var cell2 = createTableCell(tr,"sb-cell22");
		var cell3 = createTableCell(tr,"sb-cell23");
        var cell4 = createTableCell(tr,"sb-cell24");				
        var cell5 = createTableCell(tr,"sb-cell25");	
		
        //var str = rowCounter++;
        //rowCell.innerHTML = str;

        //str = "<a href='"+value6+"'>" + value1 + "</a>";
		//orderhdeid
		var str = value1;
        cell1.innerHTML = str;
		//orderno
		str = value2;
		//str = "<a href='/beacon/EditOrderhdr.do?id="+value1+"&amp;action=Edit'>"+value2+"</a>";
		//reports link
		//str = str+"&nbsp;&nbsp;<a href='/beacon/PrintOrder.do?id="+value1+"'><img src='images/icon_mini_reports.gif' border='0' alt='Report'/></a>";		
        cell2.innerHTML = str;
		//customeraddrkey
        str = value3;	
        cell3.innerHTML = str;
		
		str = value4;
        cell4.innerHTML = str;
		
		str = value5;
        cell5.innerHTML = str;
		
        // attach it
        var savedResults = document.getElementById("saved_results2");
        savedResults.appendChild(t);

        //leads.push(result);


      }



	  
	  
