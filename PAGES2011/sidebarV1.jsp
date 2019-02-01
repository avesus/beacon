<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<link rel="stylesheet" type="text/css" href="css/base.css" />

<script language="javascript" type="text/javascript" src="scripts/general.js"></script>

<script language="javascript" type="text/javascript">
	function onLoadFunctions() {
		P7AniMagic('navmid',0,250,20,1,0,0);
		P7AniMagic('navmid2',0,270,20,1,0,0);		
		P7AniMagic('navbot',0,290,20,1,0,0);
		P7_autoLayers('subtop');
		MM_swapImage('buttop','','images/nav_operations_down_over.gif','butmid2','','images/nav_reports_over.gif','butmid','','images/nav_maintenance_over.gif','butbot','','images/nav_system_over.gif',1);
	}	
</script>


<!-- ssidebar -->
<logic:present name="user">

<table cellpadding="2" cellspacing="2" border="0" width="120" bgcolor="#cccccc">
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
	</tr>	
	<tr>
		<td height="5"></td>
	</tr>		
  	<tr>
    	<td>
	  		<html:link forward="logoff">
	  		<html:img page="/images/logout.gif" border="0"/>
	  		</html:link>
    	</td>
  	</tr>	
  	<tr>
    	<td><img src="/images/sidebar.gif" width="1" height="1" border="0"/></td>
  	</tr>	

	<tr>
		<td>
	
<div id="nav" style="position:absolute; left:0px; top:65px; width:120px; height:449px; z-index:1; visibility: visible"> 

  <div id="scrollarea" style="position:absolute; width:120px; height:300px; z-index:2; left:0px; top: 75px">

    <div id="subtop" style="position:absolute; left:0; top:20px; width:120px; height:100px; z-index:3; visibility: hidden"> 
      <table bgcolor="#ffffff" width="100%" border="0" cellspacing="3" cellpadding="1">
<logic:iterate id="usermenu" name="usermenus">
	<logic:equal name="usermenu" property="programtype" value="O">
        <tr bgcolor="#FFFFFF" onMouseOver="pviiW3Cbg(this, '#E5E5E5')" onMouseOut="pviiW3Cbg(this, '#FFFFFF')"> 
          <td width="10%" align="center" valign="middle"><html:img src="images/app_bullet2.gif" border="0"/></td>
          <td class="text5"> 			     
			<a href="<bean:write name="usermenu" property="programid"/>">
				<bean:write name="usermenu" property="menuid"/>
			</a>
		  </td>
        </tr>
	</logic:equal>		
</logic:iterate>		      
       </table>
    </div>
	
    <div id="submid" style="position:absolute; width:120px; height:100px; z-index:4; left:0px; top: 40px; visibility: hidden"> 
      <table bgcolor="#FFFFFF" width="100%" border="0" cellspacing="3" cellpadding="1">  	  
<logic:iterate id="usermenu" name="usermenus">
	<logic:equal name="usermenu" property="programtype" value="M">
        <tr bgcolor="#FFFFFF" onMouseOver="pviiW3Cbg(this, '#E5E5E5')" onMouseOut="pviiW3Cbg(this, '#FFFFFF')"> 
          <td width="10%" align="center" valign="middle"><html:img src="images/app_bullet2.gif" border="0"/></td>
          <td class="text5"> 			     
			<a href="<bean:write name="usermenu" property="programid"/>">
				<bean:write name="usermenu" property="menuid"/>
			</a>
		  </td>
        </tr>
	</logic:equal>		
</logic:iterate>	  										
		</table>
    </div>

    <div id="submid2" style="position:absolute; width:120px; height:100px; z-index:5; left:0px; top: 60px; visibility: hidden"> 
      <table bgcolor="#ffffff" width="100%" border="0" cellspacing="3" cellpadding="1">
<logic:iterate id="usermenu" name="usermenus">
	<logic:equal name="usermenu" property="programtype" value="R">
        <tr bgcolor="#FFFFFF" onMouseOver="pviiW3Cbg(this, '#E5E5E5')" onMouseOut="pviiW3Cbg(this, '#FFFFFF')"> 
          <td width="10%" align="center" valign="middle"><html:img src="images/app_bullet2.gif" border="0"/></td>
          <td class="text5"> 			     
			<a href="<bean:write name="usermenu" property="programid"/>">
				<bean:write name="usermenu" property="menuid"/>
			</a>
		  </td>
        </tr>
	</logic:equal>		
</logic:iterate>
		</table>
    </div>
	    
    <div id="subbot" style="position:absolute; width:120px; height:100px; z-index:6; left: 0; top: 80px; visibility: hidden"> 
      <table bgcolor="#FFFFFF" width="100%" border="0" cellspacing="3" cellpadding="1">	
<logic:iterate id="usermenu" name="usermenus">
	<logic:equal name="usermenu" property="programtype" value="S">
        <tr bgcolor="#FFFFFF" onMouseOver="pviiW3Cbg(this, '#E5E5E5')" onMouseOut="pviiW3Cbg(this, '#FFFFFF')"> 
          <td width="10%" align="center" valign="middle"><html:img src="images/app_bullet2.gif" border="0"/></td>
          <td class="text5"> 			     
			<a href="<bean:write name="usermenu" property="programid"/>">
				<bean:write name="usermenu" property="menuid"/>
			</a>
		  </td>
        </tr>
	</logic:equal>		
</logic:iterate>		  
      </table>
    </div>
	
	
    <div id="navtop" style="position:absolute; left:0px; top:0px; width:120px; height:20px; z-index:7">
    <a href="#" 
		onFocus="if(this.blur)this.blur()" 
		onClick="
				MM_swapImage('buttop','','images/nav_operations_down_over.gif','butmid2','','images/nav_reports_over.gif','butmid','','images/nav_maintenance_over.gif','butbot','','images/nav_system_over.gif');
				P7AniMagic('navmid',0,250,20,1,0,0);
				P7AniMagic('navmid2',0,270,20,1,0,0);
				P7AniMagic('navbot',0,290,20,1,0,0);
				P7_autoLayers('subtop','closer')
				"			
		>
	<img src="images/nav_operations_over.gif" border="0" name="buttop"/></a>
    </div>

    <div id="navmid" style="position:absolute; left:0px; top:20px; width:120px; height:20px; z-index:8"> 
      <a href="#" 
	  	onClick="
				MM_swapImage('butmid2','','images/nav_reports_over.gif','butmid','','images/nav_maintenance_down_over.gif','buttop','','images/nav_operations_over.gif','butbot','','images/nav_system_over.gif');
				P7AniMagic('navtop',0,0,20,1,0,0);
				P7AniMagic('navmid',0,20,20,1,0,0);
				P7AniMagic('navmid2',0,270,20,1,0,0);
				P7AniMagic('navbot',0,290,20,1,0,0);
				P7_autoLayers('submid','closer')" 
				onFocus="if(this.blur)this.blur()"
		>
		<img src="images/nav_maintenance_over.gif" border="0" name="butmid"/>
		</a> 
    </div>
    
    <div id="navmid2" style="position:absolute; left:0px; top:40px; width:120px; height:20px; z-index:9"> 
      <a href="#" 
	  	onClick="
				MM_swapImage('butmid2','','images/nav_reports_down_over.gif','butmid','','images/nav_maintenance_over.gif','buttop','','images/nav_operations_over.gif','butbot','','images/nav_system_over.gif');
				P7AniMagic('navtop',0,0,20,1,0,0);
				P7AniMagic('navmid',0,20,20,1,0,0);
				P7AniMagic('navmid2',0,40,20,1,0,0);
				P7AniMagic('navbot',0,290,20,1,0,0);
				P7_autoLayers('submid2','closer')
				" 
		onFocus="if(this.blur)this.blur()"
		>
		<img src="images/nav_reports_over.gif" border="0" name="butmid2"/>
		</a> 
    </div>
		
    <div id="navbot" style="position:absolute; left:0px;  top: 60px; width:120px; height:20px; z-index:10">
		<a href="#" 
			onClick="
					MM_swapImage('butmid2','','images/nav_reports_over.gif','butmid','','images/nav_maintenance_over.gif','buttop','','images/nav_operations_over.gif','butbot','','images/nav_system_down_over.gif');
					P7AniMagic('navtop',0,0,20,1,0,0);
					P7AniMagic('navmid',0,20,20,1,0,0);
					P7AniMagic('navmid2',0,40,20,1,0,0);
					P7AniMagic('navbot',0,60,20,1,0,0);
					P7_autoLayers('subbot','closer')" 
			onFocus="if(this.blur)this.blur()"
			>
		<img src="images/nav_system_over.gif" border="0" name="butbot"/>
		</a>
    </div>



      
  </div>
  
</div>
	
		</td>
	</tr>

<tr>
<td>

</td>
</tr>
		
</table>

</logic:present>



<logic:notPresent name="user">

<html:form action="/SubmitLogon" focus="userid">
<table cellpadding="2" cellspacing="2" border="0" width="120" bgcolor="#cccccc">

  <tr>
    <td class="text4"><strong>
      <bean:message key="prompt.userid"/>:
	  </strong>
    </td>
	</tr>
	
	<tr>
    	<td>
      <html:text property="userid" size="15" maxlength="15" styleClass="ftforminputsmall"/>
    	</td>
  	</tr>

  <tr>
    <td class="text4"><strong>
      <bean:message key="prompt.password"/>:
	  </strong>
    </td>
	</tr>
	
	<tr>
    <td>
      <html:password property="password" size="15" maxlength="15"
                    redisplay="false" styleClass="ftforminputsmall"/>
    </td>
  </tr>

  <tr>
    <td>
	  <html:image page="/images/login.gif" property="Submit" value="Submit"/>
    </td>
  </tr>
		
</table>

</html:form>


</logic:notPresent>
<!-- esidebar -->
