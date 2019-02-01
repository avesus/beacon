<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>



<script language="javascript" type="text/javascript" src="/beacon/scripts/general.js"></script>

<style type="text/css">
<!--
.linkMenubar { font-family: Arial, Verdana, Helvetica; font-size: 14px; font-weight: normal; color: black; line-height: 150%; padding:0px 10px 0px 10px; background:#ffffff; }
-->
</style>

<!--
<logic:present name="user">

    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>

              <logic:iterate id="usermenu" name="usermenus">
                <logic:equal name="usermenu" property="programtype" value="O">
                
                <logic:notEqual name="usermenu" property="menuid" value="LINE"> 
                    <td class="linkMenubar">
					<logic:equal name="usermenu" property="disabledflag" value="false">
					<a href="<bean:write name="usermenu" property="programid"/>">
                      <bean:write name="usermenu" property="menuid"/>
                      </a>
					</logic:equal>
					<logic:equal name="usermenu" property="disabledflag" value="true">
                      <bean:write name="usermenu" property="menuid"/>
					</logic:equal>					  
					</td>
                </logic:notEqual>  
                  
                </logic:equal>
              </logic:iterate>
		  
            </table>

</logic:present>
-->


