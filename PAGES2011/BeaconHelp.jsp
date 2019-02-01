<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags/app"    prefix="app" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<app:checkLogon/>


<html:html>
<head>
<title>Beacon Help</title>

<link rel="stylesheet" type="text/css" href="css/base.css" />

</head>



<body>  

<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>


<!-- BREADCRUMBS -----------------> 
<tr>
<%--      <td height="20" bgcolor="#CCCCCC">&nbsp;</td>--%>  
	<td class="tdwht">
		<span class="heading2">    
			<strong>	
				<bean:message key="heading.beacon.help"/>	
			</strong>			
		</span>
						 				
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>


<tr>
	<td bgcolor="#CCCCCC" width="121" valign="top" align="center">
<jsp:include page="/pages/sidebar.jsp" flush="true" />
	</td>

	
	<td>
		<div style="OVERFLOW:auto; width:600px; height:650px; position:relative;">	
		
<!-- BODY GOES HERE ----------------->
<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td class="tdwht">
<logic:present name="user">

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr>

	<td>
		<img src='images/spacer.gif' width='20' height='1' alt='*' border='0' />
	</td>

<td>


<table border="0" cellpadding="1" cellspacing="1" width="100%" bgcolor="#ffffff">

	<tr>
		<td colspan="2" class="textHelp"><strong>
			System
		</strong></td>		
		<td colspan="2" class="textHelp"><strong>
		</strong></td>	
	</tr>
	<tr>
		<td colspan="2">
			<img src='images/spacer.gif' width='1' height='1' alt='*' class='greynavline250' border='0' />
		</td> 
		<td colspan="2">
		</td> 		
	</tr>	
	<tr>
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/lghtgrey_arrow_right.gif' width='4' height='11' alt='*' border='0'/>
			</div>
		</td>
		<td width="48%" class="textHelpRed">
			<a class="textHelpRed">General</a>
		</td>		
		<td width="2%">
			<div class='helpdeskitems'>
			</div>				
		</td>
		<td width="48%" class="textHelpRed">
		</td>		
	</tr>

	<tr>
		<td colspan="4" class="textHelp"><strong>
			<img src='images/spacer.gif' width='1' height='20' alt='*' border='0' />
		</strong></td>		
	</tr>
		
	<tr>
		<td colspan="2" class="textHelp"><strong>
			Operations
		</strong></td>		
		<td colspan="2" class="textHelp"><strong>
			Maintenance
		</strong></td>	
	</tr>
	<tr>
		<td colspan="2">
			<img src='images/spacer.gif' width='1' height='1' alt='*' class='greynavline250' border='0' />
		</td> 
		<td colspan="2">
			<img src='images/spacer.gif' width='1' height='1' alt='*' class='greynavline250' border='0' />
		</td> 		
	</tr>	
	<tr>
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/lghtgrey_arrow_right.gif' width='4' height='11' alt='*' border='0'/>
			</div>
		</td>
		<td width="48%" class="textHelpRed">
			<a class="textHelpRed">Quotation</a>
		</td>		
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/lghtgrey_arrow_right.gif' width='4' height='11' alt='*' border='0' />
			</div>				
		</td>
		<td width="48%" class="textHelpRed">
			<a class="textHelpRed">Address</a>
		</td>		
	</tr>
	<tr>
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/lghtgrey_arrow_right.gif' width='4' height='11' alt='*' border='0' />
			</div>	
		</td>
		<td width="48%" class="textHelpRed">
			<a class="textHelpRed">Workflow</a>
		</td>		
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/lghtgrey_arrow_right.gif' width='4' height='11' alt='*' border='0' />
			</div>	
		</td>
		<td width="48%" class="textHelpRed">
			<a class="textHelpRed">Charge</a>
		</td>		
	</tr>
	<tr>
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/lghtgrey_arrow_right.gif' width='4' height='11' alt='*' border='0' />
			</div>	
		</td>
		<td width="48%" class="textHelpRed">
			<a class="textHelpRed">Order</a>
		</td>		
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/lghtgrey_arrow_right.gif' width='4' height='11' alt='*' border='0' />
			</div>	
		</td>
		<td width="48%" class="textHelpRed">
			<a class="textHelpRed">Cost</a>
		</td>		
	</tr>
	<tr>
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/lghtgrey_arrow_right.gif' width='4' height='11' alt='*' border='0' />
			</div>			</td>
		<td width="48%" class="textHelpRed">
			<a class="textHelpRed">Create Sales Invoices</a>
		</td>		
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/lghtgrey_arrow_right.gif' width='4' height='11' alt='*' border='0' />
			</div>			</td>
		<td width="48%" class="textHelpRed">
			<a class="textHelpRed">Location</a>
		</td>		
	</tr>
	<tr>
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/lghtgrey_arrow_right.gif' width='4' height='11' alt='*' border='0' />
			</div>			</td>
		<td width="48%" class="textHelpRed">
			<a class="textHelpRed">Print Sales Invoices</a>
		</td>		
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/lghtgrey_arrow_right.gif' width='4' height='11' alt='*' border='0' />
			</div>			</td>
		<td width="48%" class="textHelpRed">
			<a class="textHelpRed">Product</a>
		</td>		
	</tr>
	<tr>
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/lghtgrey_arrow_right.gif' width='4' height='11' alt='*' border='0' />
			</div>			
		</td>
		<td width="48%" class="textHelpRed">
			<a class="textHelpRed">Customer Tariff</a>
		</td>		
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/lghtgrey_arrow_right.gif' width='4' height='11' alt='*' border='0' />
			</div>			</td>
		<td width="48%" class="textHelpRed">
			<a class="textHelpRed">Section</a>
		</td>		
	</tr>
	<tr>
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/lghtgrey_arrow_right.gif' width='4' height='11' alt='*' border='0' />
			</div>			
		</td>
		<td width="48%" class="textHelpRed">
			<a class="textHelpRed">Vendor Tariff</a>
		</td>		
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/lghtgrey_arrow_right.gif' width='4' height='11' alt='*' border='0' />
			</div>			
		</td>
		<td width="48%" class="textHelpRed">
			<a class="textHelpRed">Unit</a>
		</td>		
	</tr>	

	
	<tr>
		<td colspan="4" class="textHelp"><strong>
			<img src='images/spacer.gif' width='1' height='20' alt='*' border='0' />
		</strong></td>		
	</tr>
		
	<tr>
		<td colspan="2" class="textHelp"><strong>
			Reports
		</strong></td>		
		<td colspan="2" class="textHelp"><strong>
			System
		</strong></td>	
	</tr>
	<tr>
		<td colspan="2">
			<img src='images/spacer.gif' width='1' height='1' alt='*' class='greynavline250' border='0' />
		</td> 
		<td colspan="2">
			<img src='images/spacer.gif' width='1' height='1' alt='*' class='greynavline250' border='0' />
		</td> 		
	</tr>	
	<tr>
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/lghtgrey_arrow_right.gif' width='4' height='11' alt='*' border='0' />
			</div>			</td>
		<td width="48%" class="textHelpRed">
			<a class="textHelpRed">Quotation Expiry Report</a>
		</td>		
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/spacer.gif' width='4' height='11' alt='*' border='0' />
			</div>			</td>
		<td width="48%" class="textHelpRed">
		</td>		
	</tr>
	<tr>
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/lghtgrey_arrow_right.gif' width='4' height='11' alt='*' border='0' />
			</div>			</td>
		<td width="48%" class="textHelpRed">
			<a class="textHelpRed">Quotation Takeup Analysis</a>
		</td>		
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/spacer.gif' width='4' height='11' alt='*' border='0' />
			</div>			</td>
		<td width="48%" class="textHelpRed">
		</td>		
	</tr>	
	<tr>
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/lghtgrey_arrow_right.gif' width='4' height='11' alt='*' border='0' />
			</div>			</td>
		<td width="48%" class="textHelpRed">
			<a class="textHelpRed">Unit Test Due Report</a>
		</td>		
		<td width="2%">
			<div class='helpdeskitems'>
				<img src='images/spacer.gif' width='4' height='11' alt='*' border='0' />
			</div>			</td>
		<td width="48%" class="textHelpRed">
		</td>		
	</tr>					
</table>

</td>
</tr>
</table>

</logic:present>
</td>
</tr>
</table>
	
		</div>
	</td>
</tr>

<tr>
	<td colspan="2">
<jsp:include page="/pages/footer.jsp" flush="true" />
	</td>
</tr>

</table>

</body>
</html:html>
