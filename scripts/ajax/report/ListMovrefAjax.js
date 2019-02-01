// Timestamp of process that page was last updated with
//var lastUpdate = 0;

/*
 */
function processListMovref() {


		var url = '';
		var searchDate1yyyy = document.forms[0].elements['searchDate1yyyy'];	
		var searchDate1mm = document.forms[0].elements['searchDate1mm'];
		var searchDate1dd = document.forms[0].elements['searchDate1dd'];
		var searchDate2yyyy = document.forms[0].elements['searchDate2yyyy'];	
		var searchDate2mm = document.forms[0].elements['searchDate2mm'];
		var searchDate2dd = document.forms[0].elements['searchDate2dd'];
		url =
				"action=view"+
				"&searchString1="+document.forms[0].searchString1.value+
				"&searchString3="+document.forms[0].searchString3.value+
				"&searchDate1dd="+searchDate1dd.options[searchDate1dd.selectedIndex].value+
				"&searchDate1mm="+searchDate1mm.options[searchDate1mm.selectedIndex].value+
				"&searchDate1yyyy="+searchDate1yyyy.options[searchDate1yyyy.selectedIndex].value+
				"&searchDate2dd="+searchDate2dd.options[searchDate2dd.selectedIndex].value+
				"&searchDate2mm="+searchDate2mm.options[searchDate2mm.selectedIndex].value+
				"&searchDate2yyyy="+searchDate2yyyy.options[searchDate2yyyy.selectedIndex].value+
				"&orderBy=jobmov.Movref"
				;
			
    clearMovref();			

 	var req = newXMLHttpRequest();

 	req.onreadystatechange = getReadyStateHandler(req, updateListMovref);
	
 	req.open("POST", "listmovref.do", true);
 	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 	req.send(url);

}


/*
 * Update area of page to reflect contents of XML
 * described in XML document.
 */
function updateListMovref(listMovrefXML) {	
	
 	var list = listMovrefXML.getElementsByTagName("list")[0];

	var generated = list.getAttribute("generated");
	//if (generated > lastUpdate) {
   		lastUpdate = generated;
   
	    var items = list.getElementsByTagName("item");
		for (var I = 0 ; I < items.length ; I++) {
			var item = items[I];
			var movref =  item.getElementsByTagName("movref")[0].firstChild.nodeValue;	
			addRowMovref(movref,movref,"");
    	}
		
	//}
	 
}


function addRowMovref(value1, value2, url) {
	var select = document.forms[0].elements['searchString2'];
    appendToListmovref(select, value1, document.createTextNode(value2));
}
	  
	  
// empty select list content
function clearMovref() {
    var select = document.forms[0].elements['searchString2'];
    while (select.length > 1) {
        select.remove(1);
    }	
}



// add item to select element the less
// elegant, but compatible way.
function appendToListmovref(select, value, content) {
    var opt;
    opt = document.createElement("option");
    opt.value = value;	
    opt.appendChild(content);
    select.appendChild(opt);
}


