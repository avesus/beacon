
function processListcontracteqp() {
	var id = document.forms[0].elements['contractId'];
		
    clearContracteqp();
    clearContracteqploc();	
		
if (id.options[id.selectedIndex].value != '') {
 	var req = newXMLHttpRequest();

 	req.onreadystatechange = getReadyStateHandler(req, updateListcontracteqp);
	
 	req.open("POST", "ListContracteqp", true);
 	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 	req.send("action=view&searchString1="+id.options[id.selectedIndex].value);
}
}



function updateListcontracteqp(listcontracteqpXML) {	
	
 	var listcontracteqp = listcontracteqpXML.getElementsByTagName("listcontracteqp")[0];

	var generated = listcontracteqp.getAttribute("generated");
   		lastUpdate = generated;
   
	    var items = listcontracteqp.getElementsByTagName("item");
		for (var I = 0 ; I < items.length ; I++) {
			var item = items[I];
			var contracteqpid =  item.getElementsByTagName("contracteqpid")[0].firstChild.nodeValue;
			var eqpkey = item.getElementsByTagName("eqpkeyp1")[0].firstChild.nodeValue+"/"+item.getElementsByTagName("eqpkeyp2")[0].firstChild.nodeValue;
			var eqpkeyp1 = item.getElementsByTagName("eqpkeyp1")[0].firstChild.nodeValue;
			var eqpkeyp2 = item.getElementsByTagName("eqpkeyp2")[0].firstChild.nodeValue;			
			var url = 'javascript:processListcontracteqp("'+contracteqpid+'");';		
			addRowListcontracteqp(contracteqpid,eqpkey,url);
    	}
	 
}


function addRowListcontracteqp(value1, value2, url) {
	var select = document.forms[0].elements['contracteqpId'];		
    appendToSelect(select, value1, document.createTextNode(value2));
}
	  

	  
function clearContracteqp() {
	var select = document.forms[0].elements['contracteqpId'];	
    while (select.length > 1) {
        select.remove(1);
    }	
}





