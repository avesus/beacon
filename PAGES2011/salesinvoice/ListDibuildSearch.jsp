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

<div id="search" style="position:absolute; left:0px; top:0px; width:200px; height:650px; z-index:10; visibility: visible; background-color:#EEEEEE;">
<html:form action="/ListDibuild" focus="searchDate2dd">
	<html:hidden property="gotoPage" />
	<html:hidden property="maxResults" value="999"/>
	<html:hidden property="searchString10"/>
	<html:hidden property="searchString11"/>
	<html:hidden property="searchString12"/>
  <table border="0" cellpadding="1" cellspacing="2" width="100%" bgcolor="#EEEEEE">
    <tr>
      <td colspan="2" valign="middle"><h1 class="underline mtb0">
<INPUT name="searchButton" border="0" type="image" id="searchButton" src="images/refreshButtonBorderGrey.gif" align="bottom" onMouseOut="MM_swapImgRestore();" onMouseOver="MM_swapImage('searchButton','','images/refreshButtonBorderGrey.gif','searchButton','','images/refreshButtonBorderGrey_over_blue.gif',1);"/>
          <bean:message key="title.search"/>
        </h1></td>
    </tr>
    <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
    </tr>
    <tr>
      <td class="text7">Invoice Upto Date: </td>
    </tr>
    <tr>
      <td><table border="0" cellpadding="0" cellspacing="0" width="100%">
          <tr>
            <td>&nbsp;<html:select property="searchDate2dd" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.day"/>
                </html:option>
                <html:options collection="days" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="searchDate2mm" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.month"/>
                </html:option>
                <html:options collection="months" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="searchDate2yyyy" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.year"/>
                </html:option>
                <html:options collection="years" property="value" labelProperty="label"/>
              </html:select>
            </td>
          </tr>
        </table></td>
    </tr>		
    <tr>
      <td><img src="images/spacer.gif" height="5"/></td>
    </tr>		
    <tr>
      <td><img src="images/spacer.gif" height="5"/></td>
    </tr>
    <tr>
      <td align="left" width="60%" class="text7"><bean:message key="prompt.billingaccount"/>:</td>
    </tr>
    <tr>
      <td align="left" width="60%"><html:select property="searchString6" styleClass="ftforminputsmall">
          <html:option value="%">
            <bean:message key="prompt.selectabillingaccount"/>
          </html:option>
          <html:options collection="addresss" property="addrkey" labelProperty="shortname"/>
        </html:select>
      </td>
    </tr>
  </table>
</html:form>  
</div>
