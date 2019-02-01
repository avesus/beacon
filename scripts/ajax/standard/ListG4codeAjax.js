// Timestamp of process that page was last updated with
//var lastUpdate = 0;

/*
 */
function processListG4code() { 

		var url = '';
		url =
				"action=view"+
				"&key1="+document.forms[0].g1codekey.value+
				"&key2="+document.forms[0].g2codekey.value+
				"&key3="+document.forms[0].g3codekey.value
				;
	
    clearListG4code();			

 	var req = newXMLHttpRequest();

 	req.onreadystatechange = getReadyStateHandler(req, updateListG4code);
	
 	req.open("POST", "listg4code.do", true);
 	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 	req.send(url);

}


/*
 * Update area of page to reflect contents of XML
 * described in XML document.
 */
function updateListG4code(listXML) {	
	
 	var list = listXML.getElementsByTagName("list")[0];

	var generated = list.getAttribute("generated");
	//if (generated > lastUpdate) {
   		lastUpdate = generated;
   
	    var items = list.getElementsByTagName("item");
		for (var I = 0 ; I < items.length ; I++) {
			var item = items[I];
			var g4codekey =  item.getElementsByTagName("g4codekey")[0].firstChild.nodeValue;			
			addRowElementToListG4code(g4codekey,g4codekey,"");
    	}
		
	//}
	 
}


function addRowElementToListG4code(value1, value2, url) {
	var select = document.forms[0].elements['g4codekey'];
    appendToListG4code(select, value1, document.createTextNode(value2));
}
	  
	  
// empty select list content
function clearListG4code() {
    var select = document.forms[0].elements['g4codekey'];
    while (select.length > 1) {
        select.remove(1);
    }	
}



// add item to select element the less
// elegant, but compatible way.
function appendToListG4code(select, value, content) {
    var opt;
    opt = document.createElement("option");
    opt.value = value;	
    opt.appendChild(content);
    select.appendChild(opt);
}


