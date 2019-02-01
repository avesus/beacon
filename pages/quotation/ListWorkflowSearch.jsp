<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
/**
 *
 * Amendments
 * ----------
 * 											
 */
 --%>
<!-- start taglib -->
<%@ include file="/includes/taglibs.inc.jsp" %>
<!-- end taglib -->

<!-- start datapool -->
<%@ include file="/includes/datapool.inc.jsp" %>
<!-- end datapool -->
  
<!-- start scripts -->
<%@ include file="/includes/scripts.inc.jsp" %>
<!-- end scripts -->








<div id="search" style="position:absolute; left:0px; top:0px; width:220px; height:650px; z-index:10; visibility: visible; background-color:#E6EAEF; border-right:solid 1px #C6C6C6;">

  <table border="0" cellpadding="0" cellspacing="1" width="220px" bgcolor="#E6EAEF">
    
    <tr><td><img src="images/spacer.gif" height="5"/></td></tr>
       
       
<tr><td align="center"><table border="0" cellpadding="0" cellspacing="1" width="210px" bgcolor="#999999">
<tr><td><table border="0" cellpadding="1" cellspacing="3" bgcolor="#ffffff" width="210px">      
           
    <tr>
      <td class="label2"><bean:message key="prompt.userid"/>:</td>
    </tr>
    <tr>
      <td class="label2">
      <c:if test="${sessionScope.user.securitylevel == '1'}">
          <html:select property="searchString1"	styleClass="forminput1">
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
      <td class="label2"><bean:message key="prompt.groupid"/>:</td>
    </tr>
    <tr>
      <td class="label2">
<c:if test="${sessionScope.user.securitylevel == '1'}">
          <html:select property="searchString2" styleClass="forminput1">
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

</table></td></tr>
</table></td></tr>
    
 
     <tr><td><img src="images/spacer.gif" height="5"/></td></tr>
    
    
<tr><td align="center"><table border="0" cellpadding="0" cellspacing="1" width="210px" bgcolor="#999999">
<tr><td><table border="0" cellpadding="1" cellspacing="3" bgcolor="#ffffff" width="210px">   
    
    
    <tr>
      <td class="label2"><bean:message key="prompt.quotno"/>:</td>
    </tr>
    <tr>
      <td class="label2">
<html:text property="searchString3" size="25" maxlength="40" styleClass="ftforminputsmall" onkeypress="return noenter()"/>
      </td>
    </tr>
    

       
      <tr>
      <td><img src="images/spacer.gif" height="3"/></td>
    </tr>
           
        <tr>
      <td class="label2"><bean:message key="prompt.status"/>:</td>
    </tr>
    <tr>
      <td class="label2">
              <html:select property="searchString4" styleClass="forminput1">
              	<html:option value=""><bean:message key="prompt.pending"/></html:option>        
              	<html:option value="APPROVED"><bean:message key="prompt.approved"/></html:option>  
              	<html:option value="REJECTED"><bean:message key="prompt.rejected"/></html:option>                     
              </html:select>  
      </td>
    </tr>
    
    
                          
    <tr>
      <td><img src="images/spacer.gif" height="3"/></td>
    </tr>
    
    
    <tr>
      <td class="label2"><bean:message key="prompt.quotedate"/>: </td>
    </tr>
    <tr>
      <td class="label2"><table border="0" cellpadding="0" cellspacing="1">
          <tr>
            <td class="label2">&nbsp;<bean:message key="prompt.from"/>:</td>
          </tr>
          <tr>
            <td class="label2">&nbsp;<html:select property="searchDate1dd" styleClass="forminput1">
                <html:option value="">
                  <bean:message key="prompt.day"/>
                </html:option>
                <html:options collection="days" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="searchDate1mm" styleClass="forminput1">
                <html:option value="">
                  <bean:message key="prompt.month"/>
                </html:option>
                <html:options collection="months" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="searchDate1yyyy" styleClass="forminput1">
                <html:option value="">
                  <bean:message key="prompt.year"/>
                </html:option>
                <html:options collection="years" property="value" labelProperty="label"/>
              </html:select>
            </td>
          </tr>
          <tr>
            <td class="label2">&nbsp;<bean:message key="prompt.to"/>:</td>
          </tr>
          <tr>
            <td class="label2">&nbsp;<html:select property="searchDate2dd" styleClass="forminput1">
                <html:option value="">
                  <bean:message key="prompt.day"/>
                </html:option>
                <html:options collection="days" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="searchDate2mm" styleClass="forminput1">
                <html:option value="">
                  <bean:message key="prompt.month"/>
                </html:option>
                <html:options collection="months" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="searchDate2yyyy" styleClass="forminput1">
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
      <td><img src="images/spacer.gif" height="3"/></td>
    </tr>
    
    
    <tr>
      <td class="label2"><bean:message key="prompt.approvaldate"/>: </td>
    </tr>
    <tr>
      <td class="label2"><table border="0" cellpadding="0" cellspacing="1">
          <tr>
            <td class="label2">&nbsp;<bean:message key="prompt.from"/>:</td>
          </tr>
          <tr>
            <td class="label2">&nbsp;<html:select property="searchDate3dd" styleClass="forminput1">
                <html:option value="">
                  <bean:message key="prompt.day"/>
                </html:option>
                <html:options collection="days" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="searchDate3mm" styleClass="forminput1">
                <html:option value="">
                  <bean:message key="prompt.month"/>
                </html:option>
                <html:options collection="months" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="searchDate3yyyy" styleClass="forminput1">
                <html:option value="">
                  <bean:message key="prompt.year"/>
                </html:option>
                <html:options collection="years" property="value" labelProperty="label"/>
              </html:select>
            </td>
          </tr>
          <tr>
            <td class="label2">&nbsp;<bean:message key="prompt.to"/>:</td>
          </tr>
          <tr>
            <td class="label2">&nbsp;<html:select property="searchDate4dd" styleClass="forminput1">
                <html:option value="">
                  <bean:message key="prompt.day"/>
                </html:option>
                <html:options collection="days" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="searchDate4mm" styleClass="forminput1">
                <html:option value="">
                  <bean:message key="prompt.month"/>
                </html:option>
                <html:options collection="months" property="value" labelProperty="label"/>
              </html:select>
              <html:select property="searchDate4yyyy" styleClass="forminput1">
                <html:option value="">
                  <bean:message key="prompt.year"/>
                </html:option>
                <html:options collection="years" property="value" labelProperty="label"/>
              </html:select>
            </td>
          </tr>
        </table></td>
    </tr>	

    
</table></td></tr>
</table></td></tr>

    
    <tr><td><img src="images/spacer.gif" height="5"/></td></tr>

    
<tr><td align="center"><table border="0" cellpadding="0" cellspacing="1" width="210px" bgcolor="#999999">
<tr><td><table border="0" cellpadding="1" cellspacing="3" bgcolor="#ffffff" width="210px">   
    
    <tr>
      <td class="label2"><bean:message key="prompt.listdisplay"/>
        :</td>
    </tr>
    <tr>
      <td class="label2">
              <html:select property="maxResults" styleClass="forminput1">
      		<html:options collection="pageresults" property="id.codekey" labelProperty="descr"/>                              
              </html:select>      
      </td>
    </tr>
     
</table></td></tr>
</table></td></tr>
     
 
<tr><td><img src="images/spacer.gif" height="5"/></td></tr>
        
<tr><td><table border="0" cellpadding="0" cellspacing="1" width="210px">
<tr>
<td>
 <div class="btnPaneSearch">     
		<button id="searchButton" class="btn btnFF" type="submit">
        <img class=" IM search-default" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        <span>Search</span>
        </button>      

		<button id="exitButton" class="btn btnFF" type="button"  onclick="document.location.href='MainMenu.do'">
		<img class=" IM cross-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
        <span><bean:message key="button.exit"/></span>
		</button>    
 </div>
</td>
</tr>
</table></td></tr> 
                     
  </table>
  
</div>













