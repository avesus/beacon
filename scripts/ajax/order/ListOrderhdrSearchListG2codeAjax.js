

/*---------------------------------------------------------------------------------------------
 * PROCESS FOR SEARCHSTRING21
 */
function processListG2code21(field1,field2,field3,field4) {
	var obj1,obj2,obj3,obj4;
	obj1=MM_findObj(field1);
		obj2=MM_findObj(field2);
			obj3=MM_findObj(field3);
				obj4=MM_findObj(field4);

		var url = '';
		url =
				"action=view"+
				"&key1="+obj1.value
				;
	
    clearList(obj2);			
    clearList(obj3);	
    clearList(obj4);	
		
 	var req = newXMLHttpRequest();

 	req.onreadystatechange = getReadyStateHandler(req, updateListG2code21);
	
 	req.open("POST", "listg2code.do", true);
 	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 	req.send(url);

}

/*
 * Update area of page to reflect contents of XML
 * described in XML document.
 */
function updateListG2code21(listXML) {	
	
 	var list = listXML.getElementsByTagName("list")[0];

	var generated = list.getAttribute("generated");
	//if (generated > lastUpdate) {
   		lastUpdate = generated;
   
	    var items = list.getElementsByTagName("item");
		for (var I = 0 ; I < items.length ; I++) {
			var item = items[I];
			var codekey =  item.getElementsByTagName("g2codekey")[0].firstChild.nodeValue;			
			addRowElementToListG2code21(codekey,codekey,"");
    	}
		
	//}
	 
}

function addRowElementToListG2code21(value1, value2, url) {
	var select = document.forms[0].elements['searchString21'];
    appendToListG2code(select, value1, document.createTextNode(value2));
}


/*---------------------------------------------------------------------------------------------	
 */	
	

/*---------------------------------------------------------------------------------------------
 * PROCESS FOR SEARCHSTRING25
 */
function processListG2code25(field1,field2,field3,field4) {
	var obj1,obj2,obj3,obj4;
	obj1=MM_findObj(field1);
		obj2=MM_findObj(field2);
			obj3=MM_findObj(field3);
				obj4=MM_findObj(field4);
	
		var url = '';
		url =
				"action=view"+
				"&key1="+obj1.value
				;
	
    clearList(obj2);			
    clearList(obj3);	
    clearList(obj4);	
		
 	var req = newXMLHttpRequest();

 	req.onreadystatechange = getReadyStateHandler(req, updateListG2code25);
	
 	req.open("POST", "listg2code.do", true);
 	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 	req.send(url);

}

/*
 * Update area of page to reflect contents of XML
 * described in XML document.
 */
function updateListG2code25(listXML) {	
	
 	var list = listXML.getElementsByTagName("list")[0];

	var generated = list.getAttribute("generated");
	//if (generated > lastUpdate) {
   		lastUpdate = generated;
   
	    var items = list.getElementsByTagName("item");
		for (var I = 0 ; I < items.length ; I++) {
			var item = items[I];
			var codekey =  item.getElementsByTagName("g2codekey")[0].firstChild.nodeValue;			
			addRowElementToListG2code25(codekey,codekey,"");
    	}
		
	//}
	 
}

function addRowElementToListG2code25(value1, value2, url) {
	var select = document.forms[0].elements['searchString25'];
    appendToListG2code(select, value1, document.createTextNode(value2));
}
/*---------------------------------------------------------------------------------------------	
 */	
 
 
// empty select list content
function clearList(select) {
    while (select.length > 1) {
        select.remove(1);
    }	
}


// add item to select element the less
// elegant, but compatible way.
function appendToListG2code(select, value, content) {
    var opt;
    opt = document.createElement("option");
    opt.value = value;	
    opt.appendChild(content);
    select.appendChild(opt);
}


