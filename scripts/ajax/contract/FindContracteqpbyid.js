
function processFindcontracteqpbyid() {
	var id = document.forms[0].elements['contracteqpId'];


if (id.options[id.selectedIndex].value != '') {
 	var req = newXMLHttpRequest();

 	req.onreadystatechange = getReadyStateHandler(req, updateFindcontracteqpbyid);
	
 	req.open("POST", "FindContracteqpbyid", true);
 	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 	req.send("action=view&id="+id.options[id.selectedIndex].value);
}
}


function updateFindcontracteqpbyid(findcontracteqpbyidXML) {	
	
 	var findcontracteqpbyid = findcontracteqpbyidXML.getElementsByTagName("contracteqps")[0];

	var generated = findcontracteqpbyid.getAttribute("generated");
   		lastUpdate = generated;
   
	    var items = findcontracteqpbyid.getElementsByTagName("item");
    	var item = items[0]; 
		//document.forms['OnhireForm'].eqpkeyp1.value = item.getElementsByTagName("eqpkeyp1")[0].firstChild.nodeValue;
		//document.forms['OnhireForm'].eqpkeyp2.value = item.getElementsByTagName("eqpkeyp2")[0].firstChild.nodeValue;
		document.forms['OnhireForm'].mindays.value  = item.getElementsByTagName("mindays")[0].firstChild.nodeValue;
		document.forms['OnhireForm'].freedays.value = item.getElementsByTagName("freedays")[0].firstChild.nodeValue;		
	 
}

