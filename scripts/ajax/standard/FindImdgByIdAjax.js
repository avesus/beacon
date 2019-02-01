// Timestamp of process that page was last updated with
//var lastUpdate = 0;

/*
 * Adds the specified item to the shopping cart, via Ajax call
 * itemCode - product code of the item to add
 */
function processFindimdgbyid() {
	var id = document.forms[0].elements['imdg'];

if (id.options[id.selectedIndex].value != '') {
 	var req = newXMLHttpRequest();

 	req.onreadystatechange = getReadyStateHandler(req, updateFindimdgbyid);
	
 	req.open("POST", "findimdgbyid.do", true);
 	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 	req.send("action=view&id="+id.options[id.selectedIndex].value);
}
}


/*
 * Update area of page to reflect contents of XML
 * described in XML document.
 */
function updateFindimdgbyid(findimdgbyidXML) {	
	
 	var findimdgbyid = findimdgbyidXML.getElementsByTagName("imdgs")[0];

	var generated = findimdgbyid.getAttribute("generated");
	//if (generated > lastUpdate) {
   		lastUpdate = generated;
   
	    var items = findimdgbyid.getElementsByTagName("item");
    	var item = items[0]; 
		//document.forms['OnhireForm'].eqpkeyp1.value = item.getElementsByTagName("eqpkeyp1")[0].firstChild.nodeValue;
		//document.forms['OnhireForm'].eqpkeyp2.value = item.getElementsByTagName("eqpkeyp2")[0].firstChild.nodeValue;
		//document.forms['OnhireForm'].mindays.value  = item.getElementsByTagName("mindays")[0].firstChild.nodeValue;
		//document.forms['OnhireForm'].freedays.value = item.getElementsByTagName("freedays")[0].firstChild.nodeValue;	
		alert(item.getElementsByTagName("imdgsc1")[0].firstChild.nodeValue);
		alert(item.getElementsByTagName("imdgsc2")[0].firstChild.nodeValue);
		
	//}
	 
}

