<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- start taglib -->
<%@ include file="/includes/taglibs.inc.jsp" %>
<!-- end taglib -->
<!-- start datapool -->
<%@ include file="/includes/datapool.inc.jsp" %>
<!-- end datapool -->
  
<!-- start scripts -->
<%@ include file="/includes/scripts.inc.jsp" %>
<!-- end scripts -->


<script language="javascript">
<!--
function checkCurrentFleetforLessee() {	

	if (document.getElementById('searchString2').value == "%") {
		alert("Lessee must be entered");
		document.getElementById('searchString2').focus();
		return false;
	}
														
}

function checkUnitsAvailableforLeasebyEquipment() {	

	if (document.getElementById('searchString4').value == "%") {
		alert("Equipment Parameter 1 must be entered");
		document.getElementById('searchString4').focus();
		return false;
	}	
														
}

function checkUnitsAvailableforLeasebyFittings() {	

	if (document.getElementById('searchString7').value == "%") {
		alert("Fitting Group must be entered");
		document.getElementById('searchString7').focus();
		return false;
	}
	if (document.getElementById('searchString8').value == "%") {
		alert("Fitting Type must be entered");
		document.getElementById('searchString8').focus();
		return false;
	}	
	if (document.getElementById('searchString9').value == "") {
		alert("Fitting Description must be entered");
		document.getElementById('searchString9').focus();
		return false;
	}
																
}
// -->
</script>


<div id="search" style="position:absolute; left:0px; top:0px; width:260px; height:650px; z-index:10; visibility: visible;">
  <table border="0" cellpadding="1" cellspacing="2" width="100%" class="genesysSearchBgcolor">				

  <html:form action="/ReportListUnit" onsubmit="return checkCurrentFleetforLessee();">
	<html:hidden property="gotoPage" />
	<html:hidden property="searchString1" value="ONHIRE" />  <!--movests-->
	<html:hidden property="action" value="CurrentFleetforLessee" />    
    <tr id="CurrentFleetforLessee"><td><table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr>
      <td colspan="2" valign="middle"><h1 class="underline mtb0">
<INPUT name="reportButton" border="0" type="image" id="reportButton" src="/beacon/images/buttons/btn_report.png" align="bottom" 
onMouseOut="MM_swapImgRestore();" 
onMouseOver="MM_swapImage('reportButton','','/beacon/images/buttons/btn_report.png','reportButton','','/beacon/images/buttons/btn_report_over.png',1);"/>
          <bean:message key="currentfleetforlessee.title.search"/>
        </h1></td>
    </tr>
    <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
    </tr>	
    <tr>
      <td align="left" class="unitSearchText"><bean:message key="prompt.lessee"/>:</td>
    </tr>
    <tr>
      <td align="left"><html:select property="searchString2" styleClass="ftforminputsmall">
          <html:option value="%">
            <bean:message key="prompt.selectalessee"/>
          </html:option>
          <html:options collection="lessees" property="addrkey" labelProperty="shortname"/>
        </html:select>
      </td>
    </tr>
    <tr>
      <td class="underline mtb0"><img src="images/spacer.gif" height="10"/></td>
    </tr>
	</table></td></tr>
</html:form>
	
<%--    <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
    </tr>--%>

	 
  <html:form action="/ReportListUnit" onsubmit="return checkUnitsAvailableforLeasebyEquipment();">
	<html:hidden property="gotoPage" />
	<html:hidden property="searchString1" value="AVAILABLE" />  <!--movests-->
	<html:hidden property="action" value="UnitsAvailableforLeasebyEquipment" /> 
    <tr id="UnitsAvailableforLeasebyEquipment"><td><table border="0" cellpadding="0" cellspacing="0" width="100%">	    
    <tr>
      <td colspan="2" valign="middle"><h1 class="underline mtb0">
<INPUT name="reportButton2" border="0" type="image" id="reportButton2" src="/beacon/images/buttons/btn_report.png" align="bottom" 
onMouseOut="MM_swapImgRestore();" 
onMouseOver="MM_swapImage('reportButton2','','/beacon/images/buttons/btn_report.png','reportButton2','','/beacon/images/buttons/btn_report_over.png',1);"/>
          <bean:message key="unitsavailableforleasebyequipment.title.search"/>
        </h1></td>
    </tr>
    <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
    </tr>	
    <tr>
      <td align="left" class="unitSearchText"><bean:message key="prompt.location"/>:</td>
    </tr>
    <tr>
      <td align="left"><html:select property="searchString3" styleClass="ftforminputsmall">
          <html:option value="%">
            <bean:message key="prompt.selectalocation"/>
          </html:option>
          <html:options collection="locations" property="locationkey" labelProperty="shortName"/>
        </html:select>
      </td>
    </tr>
    <tr>
      <td><img src="images/spacer.gif" height="1"/></td>
    </tr>
        <tr>
          <td class="unitSearchText">
		        <bean:message key="prompt.equipmentparameters"/>:
		  </td>
		</tr>		
              <tr> 
                <td> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <TR> 
                <TD>
		<html:select property="searchString4" styleClass="ftforminputsmall">
			<html:option value="%"><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp1s" property="id.codekey" labelProperty="descr"/>
		</html:select>				 
				</TD>
              </TR>
              <TR> 
                <TD>
		<html:select property="searchString5" styleClass="ftforminputsmall">
			<html:option value="%"><bean:message key="prompt.selectaparameter"/></html:option>
			<html:options collection="eqpkeyp2s" property="id.codekey" labelProperty="descr"/>
		</html:select>
						</TD>
              </TR>	  			  			  
            </table>
			</td>
              </tr>	
    <tr>
      <td class="underline mtb0"><img src="images/spacer.gif" height="10"/></td>
    </tr>
	</table></td></tr>				  
</html:form>


<%--    <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
    </tr>--%>
	
 
  <html:form action="/ReportListUnit" onsubmit="return checkUnitsAvailableforLeasebyFittings();">
	<html:hidden property="gotoPage" />
	<html:hidden property="searchString1" value="AVAILABLE" />  <!--movests-->
	<html:hidden property="action" value="UnitsAvailableforLeasebyFittings" />  
    <tr id="UnitsAvailableforLeasebyFittings"><td><table border="0" cellpadding="0" cellspacing="0" width="100%">		   
    <tr>
      <td colspan="2" valign="middle"><h1 class="underline mtb0">
<INPUT name="reportButton2" border="0" type="image" id="reportButton2" src="/beacon/images/buttons/btn_report.png" align="bottom" 
onMouseOut="MM_swapImgRestore();" 
onMouseOver="MM_swapImage('reportButton2','','/beacon/images/buttons/btn_report.png','reportButton2','','/beacon/images/buttons/btn_report_over.png',1);"/>
          <bean:message key="unitsavailableforleasebyfittings.title.search"/>
        </h1></td>
    </tr>
    <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
    </tr>	
    <tr>
      <td align="left" class="unitSearchText"><bean:message key="prompt.location"/>:</td>
    </tr>
    <tr>
      <td align="left"><html:select property="searchString6" styleClass="ftforminputsmall">
          <html:option value="%">
            <bean:message key="prompt.selectalocation"/>
          </html:option>
          <html:options collection="locations" property="locationkey" labelProperty="shortName"/>
        </html:select>
      </td>
    </tr>
    <tr>
      <td><img src="images/spacer.gif" height="1"/></td>
    </tr>
        <tr>
          <td class="unitSearchText">
		        <bean:message key="prompt.fittings"/>:
		  </td>
		</tr>		
              <tr> 
                <td> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <TR> 
                <TD>
		<html:select property="searchString7" styleClass="ftforminputsmall">
			<html:option value="%"><bean:message key="prompt.selectagroup"/></html:option>
			<html:options collection="fitgrps" property="fitgrpkey" labelProperty="ldesc"/>
		</html:select>				 
				</TD>
              </TR>
              <TR> 
                <TD>
		<html:select property="searchString8" styleClass="ftforminputsmall">
			<html:option value="%"><bean:message key="prompt.selectatype"/></html:option>
			<html:options collection="fittyps" property="fittypkey" labelProperty="ldesc"/>
		</html:select>
						</TD>
              </TR>	 
             <TR> 
          <td class="unitSearchText">
		        <bean:message key="prompt.fittingdescription"/>:
		  </td>
              </TR>				  
             <TR> 
                <TD>
<html:text property="searchString9" size="40" styleClass="ftforminputsmall"/>	
						</TD>
              </TR>			   			  			  
            </table>
			</td>
              </tr>	
    <tr>
      <td class="underline mtb0"><img src="images/spacer.gif" height="10"/></td>
    </tr>
	</table></td></tr>				  
</html:form>

	
  </table>
  
  <script language="javascript">
<!--

	if (document.getElementById('searchString2').value != "%") {
document.getElementById("CurrentFleetforLessee").style.backgroundImage = 
                    'url(/beacon/images/backgrounds/bg_silver.jpg)';
	}
	if (document.getElementById('searchString4').value != "%") {
document.getElementById("UnitsAvailableforLeasebyEquipment").style.backgroundImage = 
                    'url(/beacon/images/backgrounds/bg_silver.jpg)';
	}
	if (document.getElementById('searchString7').value != "%") {
document.getElementById("UnitsAvailableforLeasebyFittings").style.backgroundImage = 
                    'url(/beacon/images/backgrounds/bg_silver.jpg)';	
	}
	
// -->
</script>

</div>
