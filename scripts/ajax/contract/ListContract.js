
function processListcontract() {
	var id = document.forms[0].elements['lesseeaddrkey'];
	
    clearContract();	
    clearContracteqp();
    clearContracteqploc();	
	
if (id.options[id.selectedIndex].value != '') {
 	var req = newXMLHttpRequest();

 	req.onreadystatechange = getReadyStateHandler(req, updateListcontract);
	
	req.open("POST", "ListContract", true);	
 	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 	req.send("action=view&searchString1="+id.options[id.selectedIndex].value);
}
}



function updateListcontract(listcontractXML) {	
	
 	var listcontract = listcontractXML.getElementsByTagName("listcontract")[0];

	var generated = listcontract.getAttribute("generated");
   		lastUpdate = generated;
   
	    var items = listcontract.getElementsByTagName("item");
		for (var I = 0 ; I < items.length ; I++) {
			var item = items[I];
			var contractid =  item.getElementsByTagName("contractid")[0].firstChild.nodeValue;
			var contractno = item.getElementsByTagName("contractno")[0].firstChild.nodeValue;
			var url = 'javascript:processListcontracteqp("'+contractno+'");';		
			addRowListcontract(contractid,contractno,url);
    	}
	 
}


function addRowListcontract(value1, value2, url) {
	var select = document.forms[0].elements['contractId'];		
    appendToSelect(select, value1, document.createTextNode(value2));
}
	  


function clearContract() {
	var select = document.forms[0].elements['contractId'];	
    while (select.length > 1) {
        select.remove(1);
    }
}



function appendToSelect(select, value, content) {
    var opt;
    opt = document.createElement("option");
    opt.value = value;	
    opt.appendChild(content);
    select.appendChild(opt);
}


