<script type="text/javascript">
function disable_enable(){
if (document.all || document.getElementById){
if (document.test1.test2.disabled==true)
document.test1.test2.disabled=false
else
document.test1.test2.disabled=true
}
}
</script>


<script>
function checkifempty(){
if (document.aform.contentarea.value=='')
document.aform.button.disabled=true
else
document.aform.button.disabled=false
}
if (document.all || document.getElementById)
setInterval("checkifempty()",100)
</script>


<script>

//Check all radio/check buttons script- by javascriptkit.com
//Visit JavaScript Kit (http://javascriptkit.com) for script
//Credit must stay intact for use  

function checkall(formname,checkname,thestate){
var el_collection=eval("document.forms."+formname+"."+checkname)
for (c=0;c<el_collection.length;c++)
el_collection[c].checked=thestate
}

</script>


<form name="test">
<input type="checkbox" name="v1"> Peter<br>
<input type="checkbox" name="v1"> Jane<br>
<input type="checkbox" name="v1"> George<br>
</form>

<!-- checkall(name of form, common name of checkbox group, true or false)-->

<a href="javascript:checkall('test','v1',true)">Check All</a><br>
<a href="javascript:checkall('test','v1',false)">Uncheck All</a>



function checknumeric(field)
{
	pattern = /^[0-5](\.[05]|)$/;

	if(pattern.test(field.value)==false)
	{
	alert("You can only use 1 to 5 and .5");
	}
}



function amtCalc() 
{
	var _units = parseInt(document.forms[0].units.value);
	if (_units == 0) _units = 1;
	var _rate = parseFloat(document.forms[0].rate.value);

	document.forms[0].chgamt.value = (_units*_rate);
}

