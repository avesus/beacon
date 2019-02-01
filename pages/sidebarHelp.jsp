<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<link rel="stylesheet" type="text/css" href="css/base.css" />


<logic:present name="user">
<!-- ssidebar -->
<table cellpadding="2" cellspacing="2" border="0" width="108" bgcolor="#CCCCCC">
	<tr>
		<td class="text4"><strong>
		<bean:message key="heading.welcome"/> 
		</strong>
		</td>
	</tr>
	<tr>
		<td class="text4">		
		<bean:write name="user" property="name" />
		</td>
</td>
	</tr>	
					<tr>
						<td height="5"></td>
					</tr>		
  	<tr>
    	<td>
	  		<html:img page="/images/sidebar_space.gif" border="0"/>
    	</td>
  	</tr>  	
</table>

<!-- esidebar -->
</logic:present>



