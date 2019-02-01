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
<link rel="stylesheet" type="text/css" href="/beacon/css/base.css" />
<link rel="icon" href="favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
</head>

 

<body> 

<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td colspan="2">
	
<!-- sheader -->
<table cellpadding="0" cellspacing="0" border="0" width="100%">	 
    <tr>
		<td><img src="images/_line-top.gif" border="0" width="100%" height="2" align="top"/></td>
	</tr>				  
	<tr>	
		<td><img src="images/_nav-left2.gif" border="0" width="100%" height="19"/></td>
	</tr>
    <tr>
		<td><img src="images/_line-bottom.gif" border="0" width="100%" height="2" align="top"/></td>
	</tr>
      <tr>
		<td height="2" bgcolor="#ffffff"><img src="images/spacer.gif" border="0" width="1" height="2"/></td>
      </tr>
      <tr>
		<td height="8" bgcolor="#330066"><img src="images/spacer.gif" border="0" width="1" height="8"/></td>
      </tr>		
</table>
<!-- eheader -->

	</td>
</tr>

<!-- BREADCRUMBS -----------------> 
<tr>
	<td rowspan="3" width="121" valign="top" align="center" class="sidebar">
	</td>  
	<td class="tdwht"><span class="heading2">     
		<strong>
Confirmation			
		</strong>	
			</span>			 				
	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1"></td>
</tr>

<tr>
<%--	<td class="middle">--%>
<td>
<%--		<div style="OVERFLOW:auto; width:650px; height:650px; position:relative;">--%>

		<div style="OVERFLOW:auto; position:relative;">
        
<div class="divDesktop1"> 
			
<!-- BODY GOES HERE ----------------->
<table border="0" cellpadding="10" cellspacing="10" width="100%">
                <tr class="text7">
<td>&nbsp;<strong>You have successfully logged off</strong>&nbsp;&nbsp;<html:link forward="beaconmenu">go to Welcome page</html:link></td>
                </tr>
<%--                <tr bgcolor="#FFFFFF" class="text7">
                  <td><a href="/beacon/BeaconMenu.do">go to Welcome page</a></td>
                </tr>	--%>							  
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
                              <td height="19" bgcolor="#C4DCFB">
                                    <div class="footer2blk" align="left">
                                          &nbsp;
                                    </div>
                          </td>						
                              <td height="19" bgcolor="#C4DCFB">
                                    <div class="footer2blk" align="right">
                                          &copy;2007 BureauEye&nbsp;                                    </div>
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
