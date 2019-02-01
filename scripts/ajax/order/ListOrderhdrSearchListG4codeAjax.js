

/*---------------------------------------------------------------------------------------------
 * PROCESS FOR SEARCHSTRING23
 */
function processListG4code23(field1,field2,field3,field4) {
	var obj1,obj2,obj3,obj4;
	obj1=MM_findObj(field1);
	obj2=MM_findObj(field2);
	obj3=MM_findObj(field3);
	obj4=MM_findObj(field4);

		var url = '';
		url =
				"action=view"+
				"&key1="+obj1.value+
				"&key2="+obj2.value+
				"&key3="+obj3.value
				;
	
    clearList(obj4);					
		
 	var req = newXMLHttpRequest();

 	req.onreadystatechange = getReadyStateHandler(req, updateListG4code23);
	
 	req.open("POST", "listg4code.do", true);
 	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 	req.send(url);

}

/*
 * Update area of page to reflect contents of XML
 * described in XML document.
 */
function updateListG4code23(listXML) {	
	
 	var list = listXML.getElementsByTagName("list")[0];

	var generated = list.getAttribute("generated");
	//if (generated > lastUpdate) {
   		lastUpdate = generated;
   
	    var items = list.getElementsByTagName("item");
		for (var I = 0 ; I < items.length ; I++) {
			var item = items[I];
			var codekey =  item.getElementsByTagName("g4codekey")[0].firstChild.nodeValue;			
			addRowElementToListG4code23(codekey,codekey,"");
    	}
		
	//}
	 
}

function addRowElementToListG4code23(value1, value2, url) {
	var select = document.forms[0].elements['searchString23'];
    appendToListG4code(select, value1, document.createTextNode(value2));
}


/*---------------------------------------------------------------------------------------------	
 */	
	

/*---------------------------------------------------------------------------------------------
 * PROCESS FOR SEARCHSTRING27
 */
function processListG4code27(field1,field2,field3,field4) {
	var obj1,obj2,obj3,obj4;
	obj1=MM_findObj(field1);
	obj2=MM_findObj(field2);
	obj3=MM_findObj(field3);
	obj4=MM_findObj(field4);

	
		var url = '';
		url =
				"action=view"+
				"&key1="+obj1.value+
				"&key2="+obj2.value+
				"&key3="+obj3.value
				;
	
    clearList(obj4);					
		
 	var req = newXMLHttpRequest();

 	req.onreadystatechange = getReadyStateHandler(req, updateListG4code27);
	
 	req.open("POST", "listg4code.do", true);
 	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 	req.send(url);

}

/*
 * Update area of page to reflect contents of XML
 * described in XML document.
 */
function updateListG4code27(listXML) {	
	
 	var list = listXML.getElementsByTagName("list")[0];

	var generated = list.getAttribute("generated");
	//if (generated > lastUpdate) {
   		lastUpdate = generated;
   
	    var items = list.getElementsByTagName("item");
		for (var I = 0 ; I < items.length ; I++) {
			var item = items[I];
			var codekey =  item.getElementsByTagName("g4codekey")[0].firstChild.nodeValue;			
			addRowElementToListG4code27(codekey,codekey,"");
    	}
		
	//}
	 
}

function addRowElementToListG4code27(value1, value2, url) {
	var select = document.forms[0].elements['searchString27'];
    appendToListG4code(select, value1, document.createTextNode(value2));
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
function appendToListG4code(select, value, content) {
    var opt;
    opt = document.createElement("option");
    opt.value = value;	
    opt.appendChild(content);
    select.appendChild(opt);
}


