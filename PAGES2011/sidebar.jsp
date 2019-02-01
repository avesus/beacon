<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>



<script language="javascript" type="text/javascript" src="/beacon/scripts/general.js"></script>
<script language="javascript" type="text/javascript">
//<![CDATA[
	function onLoadSidebar(menu) {
		P7_autoLayers(menu,'closer');										
	}
    //]]>
</script>



<style type="text/css">
<!--
fieldset {
  border: none;
  border-top: 1px solid #D0D0D0;
}
-->
</style>


<logic:present name="user">

<table cellpadding="2" cellspacing="2" border="0" width="120">
  <tr>
    <td class="text4"><strong>
      <bean:message key="heading.welcome"/>
      </strong> </td>
  </tr>
  <tr>
    <td class="text4"><bean:write name="user" property="name" />
    </td>
  </tr>
  <tr>
    <td height="5"></td>
  </tr>
  <tr>
    <td><html:link forward="logoff">
        <html:img page="/images/logout.gif" border="0"/>
      </html:link>
    </td>
  </tr>
  <tr>
    <td><img src="/images/sidebar.gif" width="113" height="1" border="0"/></td>
  </tr>
  <tr>
    <td>
	<div id="nav" style="position:absolute; left:0px; top:55px; width:120px; z-index:1; visibility: visible;">
        
<div id="menu1" style="position:absolute; width:120px; height:300px; z-index:2; left:0px; top:75px; visibility: hidden;">
          <div id="menusub1" style="position:absolute; width:120px; height:100px; z-index:3; left:0px; top:0px;">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><img src="images/menu_title_home.gif" border="0" height="30" width="120"/></td>
              </tr>
            </table>
            <table bgcolor="#ffffff" width="100%" border="0" cellspacing="3" cellpadding="1">
              <logic:iterate id="usermenu" name="usermenus">
                <logic:equal name="usermenu" property="programtype" value="H">
                  <tr bgcolor="#FFFFFF" onMouseOver="pviiW3Cbg(this, '#C3D0E6')" onMouseOut="pviiW3Cbg(this, '#FFFFFF')">
                    <td width="5%" align="center" valign="middle"><html:img src="images/sidebar_arrow.png" border="0"/></td>
                    <td class="text5">
					<logic:equal name="usermenu" property="disabledflag" value="false">
					<a href="<bean:write name="usermenu" property="programid"/>">
                      <bean:write name="usermenu" property="menuid"/>
                      </a>
					</logic:equal>
					<logic:equal name="usermenu" property="disabledflag" value="true">
                      <bean:write name="usermenu" property="menuid"/>
					</logic:equal>					  
					   </td>
                  </tr>
                </logic:equal>
              </logic:iterate>
			  <tr bgcolor="#FFFFFF"><td colspan="2">
			  	<img src="images/spacer.gif" border="0" height="400" width="1"/>
			  </td></tr>
            </table>
          </div>
          <div id="menutabs1" style="position:absolute; width:120px; z-index:4; left:0px; top:400px;">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td height="30"><a href="/beacon/BeaconMenu.do" onClick="P7_autoLayers('menu1','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu1tab1','','images/menu_tab_home_down.gif','_menu1tab1','','images/menu_tab_home_over.gif',1);"><img src="images/menu_tab_home_down.gif" border="0" name="_menu1tab1" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td height="30"><a href="#" onClick="P7_autoLayers('menu2','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu1tab2','','images/menu_tab_operations.gif','_menu1tab2','','images/menu_tab_operations_over.gif',1);"><img src="images/menu_tab_operations.gif" border="0" name="_menu1tab2" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td height="30"><a href="#" onClick="P7_autoLayers('menu3','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu1tab3','','images/menu_tab_maintenance.gif','_menu1tab3','','images/menu_tab_maintenance_over.gif',1);"><img src="images/menu_tab_maintenance.gif" border="0" name="_menu1tab3" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td><a href="#" onClick="P7_autoLayers('menu4','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu1tab4','','images/menu_tab_reports.gif','_menu1tab4','','images/menu_tab_reports_over.gif',1);"><img src="images/menu_tab_reports.gif" border="0" name="_menu1tab4" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td><a href="#" onClick="P7_autoLayers('menu5','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu1tab5','','images/menu_tab_system.gif','_menu1tab5','','images/menu_tab_system_over.gif',1);"><img src="images/menu_tab_system.gif" border="0" name="_menu1tab5" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
            </table>
          </div>
        </div>		


<div id="menu2" style="position:absolute; width:120px; height:300px; z-index:2; left:0px; top:75px; visibility: hidden;">
          <div id="menusub2" style="position:absolute; width:120px; height:100px; z-index:3; left:0px; top:0px; ">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><img src="images/menu_title_operations.gif" border="0" height="30" width="120"/></td>
              </tr>
            </table>
            <table bgcolor="#ffffff" width="100%" border="0" cellspacing="3" cellpadding="1">
              <logic:iterate id="usermenu" name="usermenus">
                <logic:equal name="usermenu" property="programtype" value="O">
                
                <logic:notEqual name="usermenu" property="menuid" value="LINE">                
                  <tr bgcolor="#FFFFFF" onMouseOver="pviiW3Cbg(this, '#C3D0E6')" onMouseOut="pviiW3Cbg(this, '#FFFFFF')">
                    <td width="5%" align="center" valign="middle"><html:img src="images/sidebar_arrow.png" border="0"/></td>
                    <td width="95%" class="text5">
					<logic:equal name="usermenu" property="disabledflag" value="false">
					<a href="<bean:write name="usermenu" property="programid"/>">
                      <bean:write name="usermenu" property="menuid"/>
                      </a>
					</logic:equal>
					<logic:equal name="usermenu" property="disabledflag" value="true">
                      <bean:write name="usermenu" property="menuid"/>
					</logic:equal>
					  </td>
                  </tr>
                </logic:notEqual>  
                  
                <logic:equal name="usermenu" property="menuid" value="LINE">
                    <tr>
<td colspan="2" align="center" valign="middle">
<html:img src="images/sidebar_line.png" border="0"/>
</td>
                    </tr>
                </logic:equal>  
                                  
                </logic:equal>
              </logic:iterate>
			  <tr bgcolor="#FFFFFF"><td colspan="2">
			  	<img src="images/spacer.gif" border="0" height="250" width="1"/>
			  </td></tr>
			</table>
          </div>
          <div id="menutabs2" style="position:absolute; width:120px; z-index:4; left:0px; top:400px;">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td height="30"><a href="/beacon/BeaconMenu.do" onClick="P7_autoLayers('menu1','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu2tab1','','images/menu_tab_home.gif','_menu2tab1','','images/menu_tab_home_over.gif',1);"><img src="images/menu_tab_home.gif" border="0" name="_menu2tab1" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td height="30"><a href="#" onClick="P7_autoLayers('menu2','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu2tab2','','images/menu_tab_operations_down.gif','_menu2tab2','','images/menu_tab_operations_over.gif',1);"><img src="images/menu_tab_operations_down.gif" border="0" name="_menu2tab2" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td height="30"><a href="#" onClick="P7_autoLayers('menu3','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu2tab3','','images/menu_tab_maintenance.gif','_menu2tab3','','images/menu_tab_maintenance_over.gif',1);"><img src="images/menu_tab_maintenance.gif" border="0" name="_menu2tab3" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td><a href="#" onClick="P7_autoLayers('menu4','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu2tab4','','images/menu_tab_reports.gif','_menu2tab4','','images/menu_tab_reports_over.gif',1);"><img src="images/menu_tab_reports.gif" border="0" name="_menu2tab4" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td><a href="#" onClick="P7_autoLayers('menu5','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu2tab5','','images/menu_tab_system.gif','_menu2tab5','','images/menu_tab_system_over.gif',1);"><img src="images/menu_tab_system.gif" border="0" name="_menu2tab5" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
            </table>
          </div>
        </div>
		

<div id="menu3" style="position:absolute; width:120px; height:300px; z-index:2; left:0px; top:75px; visibility: hidden;">
          <div id="menusub3" style="position:absolute; width:120px; height:100px; z-index:3; left:0px; top:0px; ">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><img src="images/menu_title_maintenance.gif" border="0" height="30" width="120"/></td>
              </tr>
            </table>
            <table bgcolor="#ffffff" width="100%" border="0" cellspacing="3" cellpadding="1">
              <logic:iterate id="usermenu" name="usermenus">
                <logic:equal name="usermenu" property="programtype" value="M">
                  <tr bgcolor="#FFFFFF" onMouseOver="pviiW3Cbg(this, '#C3D0E6')" onMouseOut="pviiW3Cbg(this, '#FFFFFF')">
                    <td width="5%" align="center" valign="middle"><html:img src="images/sidebar_arrow.png" border="0"/></td>
                    <td class="text5">
					<logic:equal name="usermenu" property="disabledflag" value="false">
					<a href="<bean:write name="usermenu" property="programid"/>">
                      <bean:write name="usermenu" property="menuid"/>
                      </a>
					</logic:equal>
					<logic:equal name="usermenu" property="disabledflag" value="true">
                      <bean:write name="usermenu" property="menuid"/>
					</logic:equal>
					  </td>
                  </tr>
                </logic:equal>
              </logic:iterate>
			  <tr bgcolor="#FFFFFF"><td colspan="2">
			  	<img src="images/spacer.gif" border="0" height="100" width="1"/>
			  </td></tr>			  
            </table>
          </div>
          <div id="menutabs3" style="position:absolute; width:120px; z-index:4; left:0px; top:400px;">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td height="30"><a href="/beacon/BeaconMenu.do" onClick="P7_autoLayers('menu1','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu3tab1','','images/menu_tab_home.gif','_menu3tab1','','images/menu_tab_home_over.gif',1);"><img src="images/menu_tab_home.gif" border="0" name="_menu3tab1" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td height="30"><a href="#" onClick="P7_autoLayers('menu2','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu3tab2','','images/menu_tab_operations.gif','_menu3tab2','','images/menu_tab_operations_over.gif',1);"><img src="images/menu_tab_operations.gif" border="0" name="_menu3tab2" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td height="30"><a href="#" onClick="P7_autoLayers('menu3','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu3tab3','','images/menu_tab_maintenance_down.gif','_menu3tab3','','images/menu_tab_maintenance_over.gif',1);"><img src="images/menu_tab_maintenance_down.gif" border="0" name="_menu3tab3" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td><a href="#" onClick="P7_autoLayers('menu4','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu3tab4','','images/menu_tab_reports.gif','_menu3tab4','','images/menu_tab_reports_over.gif',1);"><img src="images/menu_tab_reports.gif" border="0" name="_menu3tab4" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td><a href="#" onClick="P7_autoLayers('menu5','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu3tab5','','images/menu_tab_system.gif','_menu3tab5','','images/menu_tab_system_over.gif',1);"><img src="images/menu_tab_system.gif" border="0" name="_menu3tab5" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
            </table>
          </div>
        </div>
		
		
<div id="menu4" style="position:absolute; width:120px; height:300px; z-index:2; left:0px; top:75px; visibility: hidden;">
          <div id="menusub4" style="position:absolute; width:120px; height:100px; z-index:3; left:0px; top:0px; ">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><img src="images/menu_title_reports.gif" border="0" height="30" width="120"/></td>
              </tr>
            </table>
            <table bgcolor="#ffffff" width="100%" border="0" cellspacing="3" cellpadding="1">
              <logic:iterate id="usermenu" name="usermenus">
                <logic:equal name="usermenu" property="programtype" value="R">
                
                <logic:notEqual name="usermenu" property="menuid" value="LINE">
                  <tr bgcolor="#FFFFFF" onMouseOver="pviiW3Cbg(this, '#C3D0E6')" onMouseOut="pviiW3Cbg(this, '#FFFFFF')">
                    <td width="5%" align="center" valign="middle"><html:img src="images/sidebar_arrow.png" border="0"/></td>
                    <td class="text5">
					<logic:equal name="usermenu" property="disabledflag" value="false">
					<a href="<bean:write name="usermenu" property="programid"/>">
                      <bean:write name="usermenu" property="menuid"/>
                      </a>
					</logic:equal>
					<logic:equal name="usermenu" property="disabledflag" value="true">
                      <bean:write name="usermenu" property="menuid"/>
					</logic:equal>
					  </td>
                  </tr>
                </logic:notEqual>                  
 
                <logic:equal name="usermenu" property="menuid" value="LINE">
                    <tr>
                    <td colspan="2" align="center" valign="middle"><html:img src="images/sidebar_line.png" border="0"/></td>
                    </tr>
                </logic:equal>  
                                 
                </logic:equal>
              </logic:iterate>
			  <tr bgcolor="#FFFFFF"><td colspan="2">
			  	<img src="images/spacer.gif" border="0" height="200" width="1"/>
			  </td></tr>			  
            </table>
          </div>
          <div id="menutabs4" style="position:absolute; width:120px; z-index:4; left:0px; top:400px;">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td height="30"><a href="/beacon/BeaconMenu.do" onClick="P7_autoLayers('menu1','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu4tab1','','images/menu_tab_home.gif','_menu4tab1','','images/menu_tab_home_over.gif',1);"><img src="images/menu_tab_home.gif" border="0" name="_menu4tab1" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td height="30"><a href="#" onClick="P7_autoLayers('menu2','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu4tab2','','images/menu_tab_operations.gif','_menu4tab2','','images/menu_tab_operations_over.gif',1);"><img src="images/menu_tab_operations.gif" border="0" name="_menu4tab2" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td height="30"><a href="#" onClick="P7_autoLayers('menu3','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu4tab3','','images/menu_tab_maintenance.gif','_menu4tab3','','images/menu_tab_maintenance_over.gif',1);"><img src="images/menu_tab_maintenance.gif" border="0" name="_menu4tab3" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td><a href="#" onClick="P7_autoLayers('menu4','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu4tab4','','images/menu_tab_reports_down.gif','_menu4tab4','','images/menu_tab_reports_over.gif',1);"><img src="images/menu_tab_reports_down.gif" border="0" name="_menu4tab4" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td><a href="#" onClick="P7_autoLayers('menu5','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu4tab5','','images/menu_tab_system.gif','_menu4tab5','','images/menu_tab_system_over.gif',1);"><img src="images/menu_tab_system.gif" border="0" name="_menu4tab5" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
            </table>
          </div>
        </div>
		
		
<div id="menu5" style="position:absolute; width:120px; height:300px; z-index:2; left:0px; top:75px; visibility: hidden;">
          <div id="menusub5" style="position:absolute; width:120px; height:100px; z-index:3; left:0px; top:0px; ">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><img src="images/menu_title_system.gif" border="0" height="30" width="120"/></td>
              </tr>
            </table>
            <table bgcolor="#ffffff" width="100%" border="0" cellspacing="3" cellpadding="1">
              <logic:iterate id="usermenu" name="usermenus">
                <logic:equal name="usermenu" property="programtype" value="S">

               <logic:notEqual name="usermenu" property="menuid" value="LINE">
                  <tr bgcolor="#FFFFFF" onMouseOver="pviiW3Cbg(this, '#C3D0E6')" onMouseOut="pviiW3Cbg(this, '#FFFFFF')">
                    <td width="5%" align="center" valign="middle"><html:img src="images/sidebar_arrow.png" border="0"/></td>
                    <td class="text5">
					<logic:equal name="usermenu" property="disabledflag" value="false">
					<a href="<bean:write name="usermenu" property="programid"/>">
                      <bean:write name="usermenu" property="menuid"/>
                      </a>
					</logic:equal>
					<logic:equal name="usermenu" property="disabledflag" value="true">
                      <bean:write name="usermenu" property="menuid"/>
					</logic:equal>
					  </td>
                  </tr>
               </logic:notEqual>
                  
               <logic:equal name="usermenu" property="menuid" value="LINE">
                    <tr>
                    <td colspan="2" align="center" valign="middle"><html:img src="images/sidebar_line.png" border="0"/></td>
                    </tr>
                </logic:equal> 
                                  
                </logic:equal>
              </logic:iterate>
			  <tr bgcolor="#FFFFFF"><td colspan="2">
			  	<img src="images/spacer.gif" border="0" height="300" width="1"/>
			  </td></tr>			  
            </table>
          </div>
          <div id="menutabs5" style="position:absolute; width:120px; z-index:4; left:0px; top:400px;">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td height="30"><a href="/beacon/BeaconMenu.do" onClick="P7_autoLayers('menu1','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu5tab1','','images/menu_tab_home.gif','_menu5tab1','','images/menu_tab_home_over.gif',1);"><img src="images/menu_tab_home.gif" border="0" name="_menu5tab1" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td height="30"><a href="#" onClick="P7_autoLayers('menu2','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu5tab2','','images/menu_tab_operations.gif','_menu5tab2','','images/menu_tab_operations_over.gif',1);"><img src="images/menu_tab_operations.gif" border="0" name="_menu5tab2" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td height="30"><a href="#" onClick="P7_autoLayers('menu3','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu5tab3','','images/menu_tab_maintenance.gif','_menu5tab3','','images/menu_tab_maintenance_over.gif',1);"><img src="images/menu_tab_maintenance.gif" border="0" name="_menu5tab3" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td><a href="#" onClick="P7_autoLayers('menu4','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu5tab4','','images/menu_tab_reports.gif','_menu5tab4','','images/menu_tab_reports_over.gif',1);"><img src="images/menu_tab_reports.gif" border="0" name="_menu5tab4" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
              <tr>
                <td><a href="#" onClick="P7_autoLayers('menu5','closer');" onmouseout="MM_swapImgRestore();" onmouseover="MM_swapImage('_menu5tab5','','images/menu_tab_system_down.gif','_menu5tab5','','images/menu_tab_system_over.gif',1);"><img src="images/menu_tab_system_down.gif" border="0" name="_menu5tab5" height="30" width="120"/></a></td>
              </tr>
              <tr>
                <td><img src="images/menu_tab_line.gif" border="0"/></td>
              </tr>
            </table>
          </div>
        </div>
						
      </div></td>
  </tr>
  <tr>
    <td></td>
  </tr>
</table>

</logic:present>



<logic:notPresent name="user">
<html:errors />

  <html:form action="/SubmitLogon" focus="userid">
    <table cellpadding="2" cellspacing="2" border="0" width="120">
      <tr>
        <td class="text4"><strong>
          <bean:message key="prompt.userid"/>
          : </strong> </td>
      </tr>
      <tr>
        <td><html:text property="userid" size="15" maxlength="15" styleClass="ftforminputsmall"/>
        </td>
      </tr>
      <tr>
        <td class="text4"><strong>
          <bean:message key="prompt.password"/>
          : </strong> </td>
      </tr>
      <tr>
        <td><html:password property="password" size="15" maxlength="15"
                    redisplay="false" styleClass="ftforminputsmall"/>
        </td>
      </tr>
      <tr>
        <td><html:image page="/images/login.gif" property="Submit" value="Submit"/>
        </td>
      </tr>
  <tr>
    <td><img src="/images/sidebar.gif" width="113" height="1" border="0"/></td>
  </tr>	  
    </table>
  </html:form>
</logic:notPresent>
<!-- esidebar -->

