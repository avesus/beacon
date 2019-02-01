// Timestamp of process that page was last updated with
//var lastUpdate = 0;

/*
 */
function processListG3code() { 

		var url = '';
		url =
				"action=view"+
				"&key1="+document.forms[0].g1codekey.value+
				"&key2="+document.forms[0].g2codekey.value
				;
	
    clearListG3code();			
    clearListG4code();	
	
 	var req = newXMLHttpRequest();

 	req.onreadystatechange = getReadyStateHandler(req, updateListG3code);
	
 	req.open("POST", "listg3code.do", true);
 	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 	req.send(url);

}


/*
 * Update area of page to reflect contents of XML
 * described in XML document.
 */
function updateListG3code(listXML) {	
	
 	var list = listXML.getElementsByTagName("list")[0];

	var generated = list.getAttribute("generated");
	//if (generated > lastUpdate) {
   		lastUpdate = generated;
   
	    var items = list.getElementsByTagName("item");
		for (var I = 0 ; I < items.length ; I++) {
			var item = items[I];
			var g3codekey =  item.getElementsByTagName("g3codekey")[0].firstChild.nodeValue;			
			addRowElementToListG3code(g3codekey,g3codekey,"");
    	}
		
	//}
	 
}


function addRowElementToListG3code(value1, value2, url) {
	var select = document.forms[0].elements['g3codekey'];
    appendToListG3code(select, value1, document.createTextNode(value2));
}
	  
	  
// empty select list content
function clearListG3code() {
    var select = document.forms[0].elements['g3codekey'];
    while (select.length > 1) {
        select.remove(1);
    }	
}
function clearListG4code() {
    var select = document.forms[0].elements['g4codekey'];
    while (select.length > 1) {
        select.remove(1);
    }	
}


// add item to select element the less
// elegant, but compatible way.
function appendToListG3code(select, value, content) {
    var opt;
    opt = document.createElement("option");
    opt.value = value;	
    opt.appendChild(content);
    select.appendChild(opt);
}


