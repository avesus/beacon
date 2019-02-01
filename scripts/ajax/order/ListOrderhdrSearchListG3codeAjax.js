

/*---------------------------------------------------------------------------------------------
 * PROCESS FOR SEARCHSTRING22
 */
function processListG3code22(field1,field2,field3,field4) {
	var obj1,obj2,obj3,obj4;
	obj1=MM_findObj(field1);
	obj2=MM_findObj(field2);
	obj3=MM_findObj(field3);
	obj4=MM_findObj(field4);

		var url = '';
		url =
				"action=view"+
				"&key1="+obj1.value+
				"&key2="+obj2.value
				;
	
    clearList(obj3);			
    clearList(obj4);		
		
 	var req = newXMLHttpRequest();

 	req.onreadystatechange = getReadyStateHandler(req, updateListG3code22);
	
 	req.open("POST", "listg3code.do", true);
 	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 	req.send(url);

}

/*
 * Update area of page to reflect contents of XML
 * described in XML document.
 */
function updateListG3code22(listXML) {	
	
 	var list = listXML.getElementsByTagName("list")[0];

	var generated = list.getAttribute("generated");
	//if (generated > lastUpdate) {
   		lastUpdate = generated;
   
	    var items = list.getElementsByTagName("item");
		for (var I = 0 ; I < items.length ; I++) {
			var item = items[I];
			var codekey =  item.getElementsByTagName("g3codekey")[0].firstChild.nodeValue;			
			addRowElementToListG3code22(codekey,codekey,"");
    	}
		
	//}
	 
}

function addRowElementToListG3code22(value1, value2, url) {
	var select = document.forms[0].elements['searchString22'];
    appendToListG3code(select, value1, document.createTextNode(value2));
}


/*---------------------------------------------------------------------------------------------	
 */	
	

/*---------------------------------------------------------------------------------------------
 * PROCESS FOR SEARCHSTRING26
 */
function processListG3code26(field1,field2,field3,field4) {
	var obj1,obj2,obj3,obj4;
	obj1=MM_findObj(field1);
	obj2=MM_findObj(field2);
	obj3=MM_findObj(field3);
	obj4=MM_findObj(field4);
				
		var url = '';
		url =
				"action=view"+
				"&key1="+obj1.value+
				"&key2="+obj2.value
				;
	
    clearList(obj3);			
    clearList(obj4);		
		
 	var req = newXMLHttpRequest();

 	req.onreadystatechange = getReadyStateHandler(req, updateListG3code26);
	
 	req.open("POST", "listg3code.do", true);
 	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 	req.send(url);

}

/*
 * Update area of page to reflect contents of XML
 * described in XML document.
 */
function updateListG3code26(listXML) {	
	
 	var list = listXML.getElementsByTagName("list")[0];

	var generated = list.getAttribute("generated");
	//if (generated > lastUpdate) {
   		lastUpdate = generated;
   
	    var items = list.getElementsByTagName("item");
		for (var I = 0 ; I < items.length ; I++) {
			var item = items[I];
			var codekey =  item.getElementsByTagName("g3codekey")[0].firstChild.nodeValue;			
			addRowElementToListG3code26(codekey,codekey,"");
    	}
		
	//}
	 
}

function addRowElementToListG3code26(value1, value2, url) {
	var select = document.forms[0].elements['searchString26'];
    appendToListG3code(select, value1, document.createTextNode(value2));
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
function appendToListG3code(select, value, content) {
    var opt;
    opt = document.createElement("option");
    opt.value = value;	
    opt.appendChild(content);
    select.appendChild(opt);
}


