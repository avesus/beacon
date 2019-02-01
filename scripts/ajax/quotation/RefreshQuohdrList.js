

// retrieve XML document (reusable generic function);
// parameter is URL string (relative or complete) to
// an .xml file whose Content-Type is a valid XML
// type, such as text/xml; XML source must be from
// same domain as HTML file
function loadXMLDocRefreshQuohdrList() {
	var url = '';
	url = "RefreshQuohdrList?userid="+document.forms[0].userid.value;			

    // branch for native XMLHttpRequest object
    if (window.XMLHttpRequest) {
        req = new XMLHttpRequest();
            req.onreadystatechange = processReqRefreshQuohdrList;
        req.open("GET", url, true);
        req.send(null);
    // branch for IE/Windows ActiveX version
    } else if (window.ActiveXObject) {
        isIE = true;
        req = new ActiveXObject("Microsoft.XMLHTTP");
        if (req) {
            req.onreadystatechange = processReqRefreshQuohdrList;	
            req.open("GET", url, true);
            req.send();
        }
    }
}



function processRefreshQuohdrList() {
	try {
    	loadXMLDocRefreshQuohdrList();
            }
            catch(e) {
                var msg = (typeof e == "string") ? e : ((e.message) ? e.message : "Unknown Error");
                alert("Unable to get XML data:\n" + msg);
                return;
            }
}

// handle onreadystatechange event of req object
function processReqRefreshQuohdrList() {
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
            							buildRefreshQuohdrList();											   
                           }
                           break;
           }
   }	
}


// fill select list with items from
// the current XML document
function buildRefreshQuohdrList() {
	
	var resultsDiv = document.getElementById("saved_results");	
    removeChildren(resultsDiv);	
	
    var items = req.responseXML.getElementsByTagName("quohdrlist");		
    for (var i = 0; i < items.length; i++) {	
		var quohdrid = getElementTextNS("", "quohdrid", items[i], 0);
		var quotno = getElementTextNS("", "quotno", items[i], 0);
		var customeraddrkey = getElementTextNS("", "customeraddrkey", items[i], 0);
		var quotestatus = getElementTextNS("", "quotestatus", items[i], 0);
		var quotedate = getElementTextNS("", "quotedate", items[i], 0);		
		var url = '/beacon/EditQuohdr.do?action=Edit&id='+quohdrid;
		//alert("quohdrid="+quohdrid+" quoteno="+quoteno);
		addRowQuohdrList(quohdrid,quotno,customeraddrkey,quotestatus,quotedate,url);
    }	
}





      //var rowCounter = 3;
      function addRowQuohdrList(value1, value2, value3, value4, value5, value6) {

        //if (rowCounter == 3) {
        //}

        var t = createTable("sb-result");
        var tr = createTableRow(t);
        //var rowCell = createTableCell(tr,"sb-row");
        var cell1 = createTableCell(tr,"sb-cell1");
        var cell2 = createTableCell(tr,"sb-cell2");
		var cell3 = createTableCell(tr,"sb-cell3");
        var cell4 = createTableCell(tr,"sb-cell4");				
        var cell5 = createTableCell(tr,"sb-cell5");	
		
        //var str = rowCounter++;
        //rowCell.innerHTML = str;

        //str = "<a href='"+value6+"'>" + value1 + "</a>";
		//quohdrid
		var str = value1;
        cell1.innerHTML = str;
		//quoteno
		str = value2;
		//str = "<a href='/beacon/EditQuohdr.do?id="+value1+"&amp;action=Edit'>"+value2+"</a>";
		//charges link
		//str = str+"&nbsp;&nbsp;<a href='/beacon/ListQuocharge.do?id="+value1+"&amp;breadX=/beacon/BeaconMenu.do|Home|1'><img src='images/icon_mini_charges.gif' border='0' alt='Charges'/></a>";
		//movements link		
		//str = str+"&nbsp;<a href='/beacon/ListQuomov.do?id="+value1+"'><img src='images/icon_mini_movements.gif' border='0' alt='Movements'/></a>";
		//costs link
		//str = str+"&nbsp;<a href='/beacon/ListQuocost.do?id="+value1+"'><img src='images/icon_mini_costs.gif' border='0' alt='Costs'/></a>";		
		//notes link
		//str = str+"&nbsp;<a href='/beacon/ListQuonote.do?id="+value1+"'><img src='images/icon_mini_notes.gif' border='0' alt='Notes'/></a>";
		//analysis link
		//str = str+"&nbsp;<a href='/beacon/ListQuosummary.do?id="+value1+"'><img src='images/icon_mini_analysis.gif' border='0' alt='Analysis'/></a>";
		//reports link
		str = str+"&nbsp;&nbsp;<a href='/beacon/PrintQuotation.do?id="+value1+"'><img src='images/icon_mini_reports.gif' border='0' alt='Report'/></a>";		
        cell2.innerHTML = str;
		//customeraddrkey
        str = value3;	
        cell3.innerHTML = str;
		
		str = value4;
        cell4.innerHTML = str;
		
		str = value5;
        cell5.innerHTML = str;
		
        // attach it
        var savedResults = document.getElementById("saved_results");
        savedResults.appendChild(t);

        //leads.push(result);


      }

