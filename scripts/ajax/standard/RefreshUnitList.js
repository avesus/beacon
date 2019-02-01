


// retrieve XML document (reusable generic function);
// parameter is URL string (relative or complete) to
// an .xml file whose Content-Type is a valid XML
// type, such as text/xml; XML source must be from
// same domain as HTML file
function loadXMLDocRefreshUnitList() {
	var url = '';
	url = "RefreshUnitList?invsts="+document.forms[0].invsts.value;			

    // branch for native XMLHttpRequest object
    if (window.XMLHttpRequest) {
        req = new XMLHttpRequest();
            req.onreadystatechange = processReqRefreshUnitList;
        req.open("GET", url, true);
        req.send(null);
    // branch for IE/Windows ActiveX version
    } else if (window.ActiveXObject) {
        isIE = true;
        req = new ActiveXObject("Microsoft.XMLHTTP");
        if (req) {
            req.onreadystatechange = processReqRefreshUnitList;	
            req.open("GET", url, true);
            req.send();
        }
    }
}



function processRefreshUnitList() {
	try {
    	loadXMLDocRefreshUnitList();
            }
            catch(e) {
                var msg = (typeof e == "string") ? e : ((e.message) ? e.message : "Unknown Error");
                alert("Unable to get XML data:\n" + msg);
                return;
            }
}

// handle onreadystatechange event of req object
function processReqRefreshUnitList() {
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
            							buildRefreshUnitList();											   
                           }
                           break;
           }
   }	
}


// fill select list with items from
// the current XML document
function buildRefreshUnitList() {
	var resultsDiv = document.getElementById("saved_results3");	
    removeChildren(resultsDiv);	
	
    var items = req.responseXML.getElementsByTagName("unitlist");		
    for (var i = 0; i < items.length; i++) {	
		var unitkey = getElementTextNS("", "unitkey", items[i], 0);
		var invsts = getElementTextNS("", "invsts", items[i], 0);
		var movedate = getElementTextNS("", "movedate", items[i], 0);
		var movelocationkey = getElementTextNS("", "movelocationkey", items[i], 0);
		var unitid = getElementTextNS("", "unitid", items[i], 0);		
		var url = '/beacon/EditUnit.do?action=Edit&id='+unitid;
		addRowUnitList(unitkey,invsts,movedate,movelocationkey,"",url);
    }	
}





      //var rowCounter = 3;
      function addRowUnitList(value1, value2, value3, value4, value5, value6) {

        //if (rowCounter == 3) {
        //}
        var t = createTable("sb-result3");
        var tr = createTableRow(t);
        //var rowCell = createTableCell(tr,"sb-row");
        var cell1 = createTableCell(tr,"sb-cell31");
        var cell2 = createTableCell(tr,"sb-cell32");
		var cell3 = createTableCell(tr,"sb-cell33");
        var cell4 = createTableCell(tr,"sb-cell34");				
        //var cell5 = createTableCell(tr,"sb-cell35");	
		
        //var str = rowCounter++;
        //rowCell.innerHTML = str;

        //str = "<a href='"+value6+"'>" + value1 + "</a>";
		//
		var str = value1;
        cell1.innerHTML = str;
		
		str = value4;
        cell2.innerHTML = str;
		
		//
		str = value2;
		//str = "<a href='/beacon/EditUnit.do?id="+value1+"&amp;action=Edit'>"+value2+"</a>";
		//
		//str = str+"&nbsp;&nbsp;<a href='/beacon/PrintOrder.do?id="+value1+"'><img src='images/icon_mini_reports.gif' border='0' alt='Report'/></a>";		
        cell3.innerHTML = str;
		//
        str = value3;	
        cell4.innerHTML = str;
		
		
		//str = value5;
        //cell5.innerHTML = str;
		
        // attach it
        var savedResults = document.getElementById("saved_results3");
        savedResults.appendChild(t);

        //leads.push(result);


      }



	  
	  
