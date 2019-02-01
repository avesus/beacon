// JavaScript Document

// XML Ticker JavaScript
// (c) 2002 Premshree Pillai
// http://www.qiksearch.com
// Use freely as long as all messages are as it is
// Location of script:  
http://www.qiksearch.com/javascripts/xml/ticker.htm
var xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
function loadXML(xmlFile)
{
xmlDoc.async="false";
xmlDoc.onreadystatechange=verify;
xmlDoc.load(xmlFile);
ticker=xmlDoc.documentElement;
}
function verify()
{  
if (xmlDoc.readyState != 4)
{  
 return false;  
}
}
loadXML('ticker_items.xml');
document.write('<style type="text\/css">');
document.write('.ticker_style{font-family:' +  
ticker.childNodes(1).childNodes(0).getAttribute('font') + ';  
font-size:' +  
ticker.childNodes(1).childNodes(0).getAttribute('size')
+ '; color:' +  
ticker.childNodes(1).childNodes(0).getAttribute('color') +  
'; font-weight:' +  
ticker.childNodes(1).childNodes(0).getAttribute('weight') +
'; text-decoration:' +  
ticker.childNodes(1).childNodes(0).getAttribute('decoration')  
+ '}');document.write('.ticker_style:hover{font-family:' +  
ticker.childNodes(1).childNodes(1).getAttribute('font') +  
'; font-size:' +  
ticker.childNodes(1).childNodes(1).getAttribute('size')  
+ '; color:' +  
ticker.childNodes(1).childNodes(1).getAttribute('color') +  
'; font-weight:' +  
ticker.childNodes(1).childNodes(1).getAttribute('weight') +  
'; text-decoration:' +  
ticker.childNodes(1).childNodes(1).getAttribute
('decoration') + '}<br>');
document.write('</style>');
document.write('<table style="border:' +  
ticker.childNodes(0).getAttribute('border')  
+ ' solid ' + ticker.childNodes(0).getAttribute('bordercolor') +  
'; background:' + ticker.childNodes(0).getAttribute('background') +  
'; width:' + ticker.childNodes(0).getAttribute('width') + '; height:'  
+ ticker.childNodes(0).getAttribute('height') + '">
<tr><td><div id="ticker_space"></div>
</td></tr></table>');
var item_count=2;
var timeOutVal=(ticker.childNodes(0).getAttribute('timeout'))*1000;
var original_timeOutVal=timeOutVal;
var isPauseContent;
if(ticker.childNodes(0).getAttribute('pause')=="true")
{
isPauseContent=' onmouseover="setDelay();" onmouseout="reset();"';
}
else
{
isPauseContent='';
}
function setTicker()
{
document.all.ticker_space.innerHTML='<center><a href="' +  
ticker.childNodes(item_count).getAttribute('URL') + '" target="'  
+ ticker.childNodes(item_count).getAttribute('target') +  
'" class="ticker_style"' + isPauseContent + '>' +  
ticker.childNodes(item_count).firstChild.text + '</a></center>';
if(item_count==ticker.childNodes.length-1)
{
 item_count=2;
}
else
{
 item_count++;
}
setTimeout("setTicker()",timeOutVal);
}
function setDelay()
{
timeOutVal=10000000000000;
item_count--;
}
function reset()
{
timeOutVal=original_timeOutVal;
setTicker();
}
setTicker();
