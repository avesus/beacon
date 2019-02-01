<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags/app"    prefix="app" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@ page session="false" %>
 


<html:html>
<head>
<title>Beacon</title>
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />

<link rel="icon" href="favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
</head>

 

<body> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td colspan="2">
	
<!-- sheader -->
<table cellpadding="0" cellspacing="0" border="0" width="100%">	 				  
    <tr><td><img src="images/_line-top.gif" border="0" width="100%" height="2" align="top"/></td></tr>
	<tr><td bgcolor="#E3E6E8"><span class="header1">&nbsp;</span></td></tr>
    <tr><td><img src="images/_line-bottom.gif" border="0" width="100%" height="2" align="top"/></td></tr>			
</table>
<!-- eheader -->

	</td>
</tr>

<!-- BREADCRUMBS -----------------> 
<tr bgcolor="#F1F1F1">
	<td rowspan="3" width="121" valign="top" align="center" class="sidebar">
	</td>  
	<td><span class="header2">Confirmation</span>			 				
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1"></td>
</tr>

<tr>
	<td>
		<div style="OVERFLOW:auto; position:relative;">

<div class="divDesktop2">
			
<!-- BODY GOES HERE ----------------->
<table border="0" cellpadding="10" cellspacing="10" width="100%">
                <tr>
<td class="label2">&nbsp;You have successfully logged off&nbsp;&nbsp;<html:link forward="mainmenu"><span class="label12">go to Welcome page</span></html:link></td>
                </tr>
							  
</table>

</div>

		</div>
	</td>
</tr>

<tr>
	<td colspan="2">
	
<!-- sfooter -->
                  <table cellpadding="0" cellspacing="0" border="0" width="100%">
    <tr>
		<td colspan="2"><img src="images/_line-top.gif" border="0" width="100%" height="2" align="top"/></td>
	</tr>				  
                        <tr bgcolor="#330066">
                              <td height="19" bgcolor="#E5E7E9">
                                    <div class="footer2blk" align="left">
                                          &nbsp;
                                    </div>
                          </td>						
                              <td height="19" bgcolor="#E5E7E9">
                                    <div class="footer2blk" align="right">
                                    <img src="images/png/bureaueye_logo_copy.png" border="0" align="middle"/>                                    </div>
                          </td>
                        </tr>
    <tr>
		<td colspan="2"><img src="images/_line-bottom.gif" border="0" width="100%" height="2" align="top"/></td>
	</tr>							 				  
                  </table>
<!-- efooter -->

	</td>
</tr>

</table>

</body>

</html:html>
