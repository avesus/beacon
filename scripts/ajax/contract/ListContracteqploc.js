
function processListcontracteqploc() {
	var id = document.forms[0].elements['contracteqpId'];
		
    clearContracteqploc();	
	
if (id.options[id.selectedIndex].value != '') {
 	var req = newXMLHttpRequest();

 	req.onreadystatechange = getReadyStateHandler(req, updateListcontracteqploc);
	
 	req.open("POST", "ListContracteqploc", true);
 	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 	req.send("action=view&searchString1="+id.options[id.selectedIndex].value+"&searchString2=ONHIRE");	
}
}



function updateListcontracteqploc(listcontracteqplocXML) {
	
 	var listcontracteqploc = listcontracteqplocXML.getElementsByTagName("listcontracteqploc")[0];

	var generated = listcontracteqploc.getAttribute("generated");
   		lastUpdate = generated;
   
	    var items = listcontracteqploc.getElementsByTagName("item");
		for (var I = 0 ; I < items.length ; I++) {
			var item = items[I];
			var contracteqplocid =  item.getElementsByTagName("contracteqplocid")[0].firstChild.nodeValue;
			var locationkey = item.getElementsByTagName("locationkey")[0].firstChild.nodeValue;		
			var locationname = item.getElementsByTagName("locationname")[0].firstChild.nodeValue;				
			var url = 'javascript:processListcontracteqploc("'+contracteqplocid+'");';		
			addRowListcontracteqploc(contracteqplocid,locationkey,locationname,url);
    	}
	 
}


function addRowListcontracteqploc(value1, value2, value3, url) {
	var select = document.forms[0].elements['contracteqplocId'];	
    appendToSelect(select, value1, document.createTextNode(value3));
}
	  


function clearContracteqploc() {
	var select = document.forms[0].elements['contracteqplocId'];		
    while (select.length > 1) {
        select.remove(1);
    }
}





