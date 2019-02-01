function processListvendorjobs() {
	var key1 = document.forms[0].elements['vendoraddrkey'];
	var key2 = document.forms[0].elements['ccykey'];
	
    clearJobno();	
	
	if (key1.options[key1.selectedIndex].value != '') {
	 	var req = newXMLHttpRequest();	
	 	req.onreadystatechange = getReadyStateHandler(req, updateListvendorjobs);		
	 	req.open("POST", "ListVendorjobs", true);
 		req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 		req.send("searchString1="+key1.options[key1.selectedIndex].value+"&searchString2="+key2.options[key2.selectedIndex].value);		
	}
}



function updateListvendorjobs(listXML) {	
	
 	var listvendorjobs = listXML.getElementsByTagName("listvendorjobs")[0];
   
	var items = listvendorjobs.getElementsByTagName("item");
	for (var I = 0 ; I < items.length ; I++) {
		var item = items[I];
		var jobno =  item.getElementsByTagName("jobno")[0].firstChild.nodeValue;
		var orderno = item.getElementsByTagName("orderno")[0].firstChild.nodeValue;
		var jobhdrid = item.getElementsByTagName("jobhdrid")[0].firstChild.nodeValue;	
		var value1 = jobno;
		var value2 = "Job number: "+jobno+" > Order number: "+orderno;	
		var url = "";		
		addRowListvendorjobs(value1,value2,url);
    }
	 
}


function addRowListvendorjobs(value1, value2, url) {
	var select = document.forms[0].elements['jobno'];
    appendToSelect(select, value1, document.createTextNode(value2));	
}
	  

function clearJobno() {
	var select = document.forms[0].elements['jobno'];
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


