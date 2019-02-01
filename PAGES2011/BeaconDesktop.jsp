<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags/app"    prefix="app" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<!-- start datapool -->
<%@ include file="/includes/datapool.inc.jsp" %>
<!-- end datapool -->

<!-- start analysispool -->
<%@ include file="/includes/analysispool.inc.jsp" %>
<!-- end analysispool -->


<!-- tell jsp to use the user bean -->
<%--<jsp:useBean
  id="user"
  class="com.bureaueye.beacon.model.standard.User"
  scope="session"
/>--%>

<style type="text/css">
<!--


#desktopBody {
	font-family: Verdana, Arial, Helvetica;
	font-size: 11px;
	font-weight: normal;
	color: #000000;
/*    background-color: #f6f6f6;*/
	padding-left:0px;
	padding-right: 0px;
	padding-top: 0px;
	padding-bottom: 0px; 	
}

/* ---------- big icon buttons  --------- */
.toolsArea .commonButton {
  background-position: top center;
  background-repeat: no-repeat;
  background-color: transparent;
  padding: 0 1px;
  min-height: 32px;
  cursor: pointer;
  text-align: center;
  vertical-align: top;
  margin-bottom: 12px;
/*  float: left;*/
}

.toolsArea .commonButton span {
  display: block;
  text-align: center;
/*  width: 83px;*/
  width: 120px;
/*  padding-top: 34px;*/
  padding-top: 10px;
  vertical-align: top;
  font-size:11px;
}
.screenButtons {
  word-spacing: -1em;
}

.screenButtons .commonButton {
  word-spacing: normal;
}

/*.commonButton a, .commonButton a:hover, */.commonButton a:link, .commonButton a:visited, .commonButton a:active {
  text-decoration: none;
}

.toolsArea span.commonButton {
  cursor: default;
  color: #999999;
  text-decoration: none;
  margin-right: -3px;
}



.toolsArea .screenButtons .commonButton span {
  background: none;
}


/* ---------- slist  --------- */

.list {
}

.list .selected {
  background-color: #ecf0fb;
}

.list td {
font-size:10px;
}

.list th {
font-size:10px;
}

th {
	padding: 5px;
  text-align: left;
  background: #D6DFF7;
  border-right: 1px solid #ffffff;
  border-bottom: 1px solid #ffffff;
}

th a:link, th a:visited, th a:active {
  color: #000000;
  text-decoration: none;
}

th a:hover {
  text-decoration: underline;
}

.sort {
	background-color: #ABBEEF; 
}

.list td {
	border: 0px;
	padding: 5px;
}

.evenrowbg {
background-color: #F0F0F0; 
}

.oddrowbg {
	background-color: #ffffff;
}



.taskevenrowbg {
background-color: #FDF5F9; 
}
.taskoddrowbg {
	background-color: #FBEAF3;
}


/* ---------- elist  --------- */


/* ---------- common.css  --------- */
legend {
  color: #000000;
  font-weight: bold;
/*  background-color: #f6f6f6;*/
  font-size:11px;
}
fieldset {
  border: none;
  border-top: 1px solid #D0D0D0;
}


/* ---------- layout.css  --------- */
fieldset {
 margin: 10px 0 0 0;
 padding: 0;
}
fieldset > legend {
  margin-left: -7px;
  padding-left: 0;
  padding-right: 9px;
  padding-top: 2px;
  margin-top: -2px;
}

legend img {
  vertical-align: middle;
}

fieldset p {
  margin: 5px 0;
}

* html fieldset {
 margin-top: 0;
 padding-top: 10px;
}

.screenButtons {
  padding: 8px 0 0 0;
}

legend {
  margin-bottom: 10px;
  margin-left: -9px;
  padding-right: 10px;
  vertical-align: middle;
  padding-left: 5px;
  padding-bottom: 1px;
}

-->
</style>

<div style="
	color: #000000;
/*    background-color: #f6f6f6;*/
	padding-left:5px;
	padding-right: 5px;
	padding-top: 5px;
	padding-bottom: 0px;
	width:900px">	
	
	<table width="100%" cellspacing="0" cellpadding="0" border="0">
	
<!--	<tr><td>&nbsp;</td></tr>-->
	
	<tr>
	
	<td>
			
	<div class="toolsArea">

<fieldset>

<legend><html:img src="images/icons/icon_operations.png" alt="Operations" border="0" align="left"/> Operations</legend><table width="100%" cellspacing="0" cellpadding="0" border="0"><tr><td>

<div class="screenButtons">

<table width="50%" cellspacing="0" cellpadding="0" border="0">
<tr>
              <logic:iterate id="usermenu" name="usermenus">
                <logic:equal name="usermenu" property="programtype" value="O">
                <logic:equal name="usermenu" property="desktopflag" value="true">
<td>
                <logic:equal name="usermenu" property="disabledflag" value="false">
<div class='commonButton' id='bid-<bean:write name="usermenu" property="menuid"/>' title='<bean:write name="usermenu" property="menuid"/>'>
<a href='<bean:write name="usermenu" property="programid"/>'>
<img src='<bean:write name="usermenu" property="programbutton"/>' border='0' />
<span id='spanid-<bean:write name="usermenu" property="menuid"/>'><bean:write name="usermenu" property="menuid"/></span>
</a>
</div>			
                </logic:equal>
                <logic:equal name="usermenu" property="disabledflag" value="true">
<div class='commonButton' id='bid-<bean:write name="usermenu" property="menuid"/>' title='<bean:write name="usermenu" property="menuid"/>'>
<img src='<bean:write name="usermenu" property="programbuttondisabled"/>' border='0' />
<span id='spanid-<bean:write name="usermenu" property="menuid"/>'><bean:write name="usermenu" property="menuid"/></span>
</div>			
                </logic:equal>				
</td>
                </logic:equal>
                </logic:equal>
              </logic:iterate>
</tr>
</table>

</div>

</td></tr></table>

</fieldset>



<fieldset>

<legend><html:img src="images/icons/icon_maintenance.png" alt="Maintenance" border="0" align="left"/> Maintenance</legend><table width="100%" cellspacing="0" cellpadding="0" border="0"><tr><td>

<div class="screenButtons">

<table width="50%" cellspacing="0" cellpadding="0" border="0"><tr>
              <logic:iterate id="usermenu" name="usermenus">
                <logic:equal name="usermenu" property="programtype" value="M">
				<logic:equal name="usermenu" property="desktopflag" value="true">
<td>
                <logic:equal name="usermenu" property="disabledflag" value="false">
<div class='commonButton' id='bid-<bean:write name="usermenu" property="menuid"/>' title='<bean:write name="usermenu" property="menuid"/>'>
<a href='<bean:write name="usermenu" property="programid"/>'>
<img src='<bean:write name="usermenu" property="programbutton"/>' border='0' />
<span id='spanid-<bean:write name="usermenu" property="menuid"/>'><bean:write name="usermenu" property="menuid"/></span>
</a>
</div>			
                </logic:equal>
                <logic:equal name="usermenu" property="disabledflag" value="true">
<div class='commonButton' id='bid-<bean:write name="usermenu" property="menuid"/>' title='<bean:write name="usermenu" property="menuid"/>'>
<img src='<bean:write name="usermenu" property="programbuttondisabled"/>' border='0' />
<span id='spanid-<bean:write name="usermenu" property="menuid"/>'><bean:write name="usermenu" property="menuid"/></span>
</div>			
                </logic:equal>				
</td>
				</logic:equal>
                </logic:equal>
              </logic:iterate>
</tr>
</table>

</div>

</td></tr></table>

</fieldset>



<%--<fieldset>

<legend><html:img src="images/icons/icon_system.png" alt="System" border="0" align="left"/> System</legend><table width="100%" cellspacing="0" cellpadding="0" border="0"><tr><td>

<div class="screenButtons">

<table width="50%" cellspacing="0" cellpadding="0" border="0"><tr>
              <logic:iterate id="usermenu" name="usermenus">
                <logic:equal name="usermenu" property="programtype" value="S">
				<logic:equal name="usermenu" property="desktopflag" value="true">
<td>
                <logic:equal name="usermenu" property="disabledflag" value="false">
<div class='commonButton' id='bid-<bean:write name="usermenu" property="menuid"/>' title='<bean:write name="usermenu" property="menuid"/>'>
<a href='<bean:write name="usermenu" property="programid"/>'>
<img src='<bean:write name="usermenu" property="programbutton"/>' border='0' />
<span id='spanid-<bean:write name="usermenu" property="menuid"/>'><bean:write name="usermenu" property="menuid"/></span>
</a>
</div>			
                </logic:equal>
                <logic:equal name="usermenu" property="disabledflag" value="true">
<div class='commonButton' id='bid-<bean:write name="usermenu" property="menuid"/>' title='<bean:write name="usermenu" property="menuid"/>'>
<img src='<bean:write name="usermenu" property="programbuttondisabled"/>' border='0' />
<span id='spanid-<bean:write name="usermenu" property="menuid"/>'><bean:write name="usermenu" property="menuid"/></span>
</div>			
                </logic:equal>				
</td>
				</logic:equal>
                </logic:equal>
              </logic:iterate>
</tr>
</table>

</div>

</td></tr></table>

</fieldset>--%>





<!-- TASKS -->
<div class="listArea">

<fieldset>

<legend><html:img src="images/icons/icon_task.png" alt="Tasks" border="0" align="left"/> Tasks</legend><table width="100%" cellspacing="0" cellpadding="0" border="0"><tr><td>



<table class="list" cellspacing="0" width="100%">

<tr>
	<th>Task</th>
	<th>Priority</th>
	<th>Start Date</th>
	<th>Due Date</th>	
</tr>
<%
int row=0;
%>
<logic:present name="analysislist10">
    <logic:iterate id="task" name="analysislist10">
<%
String _class = "taskoddrowbg";
if ((row % 2) == 0) _class = "taskevenrowbg"; 
row++;
%>
<tr class="<%= _class %>">
	<td class="name"><bean:write name="task" property="tasksubject"/></td>
	<td><bean:write name="task" property="taskpriority"/></td>    
    <td><bean:write name="task" property="startdate"/></td>
    <td><bean:write name="task" property="duedate"/></td>
</tr>
    </logic:iterate>
</logic:present>
</table>

</td></tr></table></fieldset>

</div>









<div class="listArea">

<fieldset>

<legend><html:img src="images/icons/icon_analysis.png" alt="Analysis" border="0" align="left"/> Analysis</legend><table width="100%" cellspacing="0" cellpadding="0" border="0"><tr><td>



<table class="list" cellspacing="0" width="100%">

<tr>
	<th>Status</th>
	<th>Current Month [All Users]</th>
	<th>Current Year [All Users]</th>
	<th>Current Month [<bean:write name="user" property="name" />]</th>
	<th>Current Year [<bean:write name="user" property="name" />]</th>	
</tr>
<logic:present name="analysislist1">
<tr class="oddrowbg">
	<td class="name">Quotations Approved </td>
    <logic:iterate id="labelvalue" name="analysislist1">
    	<td><bean:write name="labelvalue" property="value"/></td>
    </logic:iterate>
</tr>
</logic:present>
<logic:present name="analysislist2">
<tr class="evenrowbg">
	<td class="name">Quotations Rejected </td>
    <logic:iterate id="labelvalue" name="analysislist2">
    	<td><bean:write name="labelvalue" property="value"/></td>
    </logic:iterate>
</tr>
</logic:present>
<logic:present name="analysislist3">
<tr class="oddrowbg">
	<td class="name">Quotations Pending </td>
    <logic:iterate id="labelvalue" name="analysislist3">
    	<td><bean:write name="labelvalue" property="value"/></td>
    </logic:iterate>
</tr>
</logic:present>
<logic:present name="analysislist4">
<tr class="evenrowbg">
	<td class="name">Orders Fully Invoiced </td>
    <logic:iterate id="labelvalue" name="analysislist4">
    	<td><bean:write name="labelvalue" property="value"/></td>
    </logic:iterate>
</tr>
</logic:present>
<logic:present name="analysislist5">
<tr class="oddrowbg">
	<td class="name">Orders Part Invoiced </td>
    <logic:iterate id="labelvalue" name="analysislist5">
    	<td><bean:write name="labelvalue" property="value"/></td>
    </logic:iterate>
</tr>
</logic:present>
<logic:present name="analysislist6">
<tr class="evenrowbg">
	<td class="name">Orders Not Invoiced </td>
    <logic:iterate id="labelvalue" name="analysislist6">
    	<td><bean:write name="labelvalue" property="value"/></td>
    </logic:iterate>
</tr>
</logic:present>
<logic:present name="analysislist9">
<tr class="oddrowbg">
	<td class="name">Sales Invoices Ready to Build </td>
    <logic:iterate id="labelvalue" name="analysislist9">
    	<td><bean:write name="labelvalue" property="value"/></td>
    </logic:iterate>
</tr>
</logic:present>
<logic:present name="analysislist7">
<tr class="evenrowbg">
	<td class="name">Sales Invoices Printed </td>
    <logic:iterate id="labelvalue" name="analysislist7">
    	<td><bean:write name="labelvalue" property="value"/></td>
    </logic:iterate>
</tr>
</logic:present>
<logic:present name="analysislist8">
<tr class="oddrowbg">
	<td class="name">Sales Invoices Not Printed </td>
    <logic:iterate id="labelvalue" name="analysislist8">
    	<td><bean:write name="labelvalue" property="value"/></td>
    </logic:iterate>
</tr>
</logic:present>
</table>

</td></tr></table></fieldset>

</div>




<%--
<logic:notEqual name="user" property="securitylevel" value="1">

<div class="listArea">

<fieldset>

<legend><html:img src="images/icons/icon_analysis.png" alt="Analysis" border="0" align="left"/> </legend><table width="100%" cellspacing="0" cellpadding="0" border="0"><tr><td>



</td></tr></table></fieldset>

</div>

</logic:notEqual>

--%>






	</div>
	
	
	</td>
	
	</tr>
	
	</table>


</div>
