<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--
 *
 * Amendments
 * ----------
 *
 * NT	2009-06-05		200900015		Add Quote Number to Workflow search criteria
 *
 * NT	2009-09-02		200900032		Add Approve Flag to Workflow search criteria
 *  												
-->

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
  <table border="0" cellpadding="1" cellspacing="2" width="100%" bgcolor="#EEEEEE">
    <tr>
      <td colspan="2" valign="middle"><h1 class="underline mtb0">
<INPUT name="searchButton" border="0" type="image" id="searchButton" src="images/refreshButtonBorderGrey.gif" align="bottom" onMouseOut="MM_swapImgRestore();" onMouseOver="MM_swapImage('searchButton','','images/refreshButtonBorderGrey.gif','searchButton','','images/refreshButtonBorderGrey_over_blue.gif',1);"/>
          <bean:message key="quoapprove.title.search"/>
        </h1></td>
    </tr>
    <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
    </tr>
    <tr>
      <td align="left" class="text7"><bean:message key="prompt.userid"/>
        : </td>
    </tr>
    <tr>
      <td align="left" class="text7"><c:if test="${sessionScope.user.securitylevel == '1'}">
          <html:select property="searchString1"	styleClass="ftforminputsmall">
            <html:option value="%">
              <bean:message key="prompt.selectauserid"/>
            </html:option>
            <html:options collection="users" property="userid" labelProperty="userid"/>
          </html:select>
        </c:if>
        <c:if test="${sessionScope.user.securitylevel != '1'}"> &nbsp;<strong>[&nbsp;
          <bean:write name="ListWorkflowForm" property="searchString1"/>
          &nbsp;]</strong>
          <html:hidden property="searchString1" />
        </c:if>
      </td>
    </tr>
    <tr>
      <td><img src="images/spacer.gif" height="5"/></td>
    </tr>
    <tr>
      <td align="left" class="text7"><bean:message key="prompt.groupid"/>
        : </td>
    </tr>
    <tr>
      <td align="left" class="text7"><c:if test="${sessionScope.user.securitylevel == '1'}">
          <html:select property="searchString2" styleClass="ftforminputsmall">
            <html:option value="%">
              <bean:message key="prompt.selectagroupid"/>
            </html:option>
            <html:options collection="usergroups" property="usergroupid" labelProperty="usergroupid"/>
          </html:select>
        </c:if>
        <c:if test="${sessionScope.user.securitylevel != '1'}"> &nbsp;<strong>[&nbsp;
          <bean:write name="ListWorkflowForm" property="searchString2"/>
          &nbsp;]</strong>
          <html:hidden property="searchString2" />
        </c:if>
      </td>
    </tr>
    
    
<!--s200900015-->    
        <tr>
      <td><img src="images/spacer.gif" height="5"/></td>
    </tr>
        <tr>
      <td align="left" class="text7"><bean:message key="prompt.quotno"/>
        :</td>
    </tr>
    <tr>
      <td align="left" ><html:text property="searchString3" size="35" maxlength="40" styleClass="ftforminputsmall" onkeypress="return noenter()"/>
      </td>
    </tr>
<!--e200900015--> 


<!--s200900032--> 
    <tr>
      <td><img src="images/spacer.gif" height="5"/></td>
    </tr>
    <tr>
      <td align="left" class="text7"><bean:message key="prompt.status"/>
        : </td>
    </tr>
    <tr>
      <td align="left" valign="top"><span class="ftformradiosmall">
        <html:radio property="searchString4" value=""/>
        <bean:message key="prompt.pending"/>
        <br/>
        <html:radio property="searchString4" value="APPROVED"/>
        <bean:message key="prompt.approved"/>
        <br/>
        <html:radio property="searchString4" value="REJECTED"/>
        <bean:message key="prompt.rejected"/>
        </span> </td>
    </tr>   
<!--e200900032-->    
    
    <tr>
      <td><img src="images/spacer.gif" height="5"/></td>
    </tr>
    <tr>
      <td align="left" class="text7"><bean:message key="prompt.quotedate"/>
        : </td>
    </tr>
    <tr>
      <td><table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#EEEEEE">
          <tr>
            <td class="text7">&nbsp;
              <bean:message key="prompt.from"/>
              :</td>
          </tr>
          <tr>
            <td>&nbsp;
              <html:select property="searchDate1dd" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.day"/>
                </html:option>
                <html:options collection="days" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="searchDate1mm" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.month"/>
                </html:option>
                <html:options collection="months" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="searchDate1yyyy" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.year"/>
                </html:option>
                <html:options collection="years" property="value" labelProperty="label"/>
              </html:select>
            </td>
          </tr>
          <tr>
            <td class="text7">&nbsp;
              <bean:message key="prompt.to"/>
              :</td>
          </tr>
          <tr>
            <td>&nbsp;
              <html:select property="searchDate2dd" styleClass="ftforminputsmall">
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
      <td align="left" class="text7"><bean:message key="prompt.approvaldate"/>
        : </td>
    </tr>
    <tr>
      <td align="left" valign="top"><table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#EEEEEE">
          <tr>
            <td class="text7">&nbsp;
              <bean:message key="prompt.from"/>
              :</td>
          </tr>
          <tr>
            <td>&nbsp;
              <html:select property="searchDate3dd" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.day"/>
                </html:option>
                <html:options collection="days" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="searchDate3mm" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.month"/>
                </html:option>
                <html:options collection="months" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="searchDate3yyyy" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.year"/>
                </html:option>
                <html:options collection="years" property="value" labelProperty="label"/>
              </html:select>
            </td>
          </tr>
          <tr>
            <td class="text7">&nbsp;
              <bean:message key="prompt.to"/>
              :</td>
          </tr>
          <tr>
            <td>&nbsp;
              <html:select property="searchDate4dd" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.day"/>
                </html:option>
                <html:options collection="days" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="searchDate4mm" styleClass="ftforminputsmall">
                <html:option value="">
                  <bean:message key="prompt.month"/>
                </html:option>
                <html:options collection="months" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="searchDate4yyyy" styleClass="ftforminputsmall">
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
      <td><img src="images/spacer.gif" height="10"/></td>
    </tr>
    
        <tr>
      <td align="left" class="text7"><bean:message key="prompt.listdisplay"/>
        :</td>
    </tr>
    <tr>
      <td valign="top">
              <html:select property="maxResults" styleClass="ftforminputsmall">
      		<html:options collection="pageresults" property="id.codekey" labelProperty="descr"/>
    	</html:select>                                  
      </td>
    </tr>
    
    <tr>
      <td><img src="images/spacer.gif" height="1"/></td>
    </tr>
  </table>
</div>
