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
  <table border="0" cellpadding="1" cellspacing="2" width="100%" bgcolor="#EEEEEE">
    <tr>
      <td colspan="2" valign="middle"><h1 class="underline mtb0">
<INPUT name="searchButton" border="0" type="image" id="searchButton" src="images/refreshButtonBorderGrey.gif" align="bottom" onMouseOut="MM_swapImgRestore();" onMouseOver="MM_swapImage('searchButton','','images/refreshButtonBorderGrey.gif','searchButton','','images/refreshButtonBorderGrey_over_blue.gif',1);"/>
          <bean:message key="quohdr.title.search"/>
        </h1></td>
    </tr>
    <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
    </tr>
    <tr>
      <td align="left" class="text7"><bean:message key="prompt.quotno"/>
        :</td>
    </tr>
    <tr>
      <td align="left" ><html:text property="searchString1" size="30" maxlength="40" styleClass="ftforminputsmall" onkeypress="return noenter()"/>
      </td>
    </tr>
    <tr>
      <td><img src="images/spacer.gif" height="5"/></td>
    </tr>
    <tr>
      <td align="left" class="text7"><bean:message key="prompt.customer"/>
        : </td>
    </tr>
    <tr>
      <td align="left"><html:select property="searchString2" styleClass="ftforminputsmall">
          <html:option value="%">
            <bean:message key="prompt.selectacustomer"/>
          </html:option>
          <html:options collection="addresss" property="addrkey" labelProperty="shortLabel"/>
        </html:select>
      </td>
    </tr>  
    
    <tr>
      <td><img src="images/spacer.gif" height="5"/></td>
    </tr>
    <tr>
      <td align="left" class="text7"><bean:message key="prompt.company"/>
      : </td>
    </tr>
    <tr>
      <td align="left">
		<html:select property="searchString19" styleClass="ftforminputsmall">
			<html:options collection="companys" property="compid" labelProperty="name"/>	
		</html:select>      
      </td>
    </tr>
         
    <tr>
      <td><img src="images/spacer.gif" height="5"/></td>
    </tr>    
    <tr>
      <td align="left" class="text7"><bean:message key="prompt.quotedate"/>
        :</td>
    </tr>
    <tr>
      <td><table border="0" cellpadding="0" cellspacing="1" width="100%">
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
    <tr>
    <tr>
      <td><img src="images/spacer.gif" height="5"/></td>
    </tr>
    <tr>
      <td align="left" class="text7">New Exchange Rate Date
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
      <td><img src="images/spacer.gif" height="5"/></td>
    </tr>
    <tr>
      <td align="left" class="text7"><bean:message key="prompt.locations"/>
        : </td>
    </tr>
    <tr>
      <td align="left"><table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#EEEEEE">
          <tr>
            <td align="left" class="text7">&nbsp;
              <bean:message key="prompt.pickupplant"/>
              : </td>
          </tr>
          <tr>
            <td align="left">&nbsp;
              <html:select property="searchString10" styleClass="ftforminputsmall">
                <html:option value="%">
                  <bean:message key="prompt.selectalocation"/>
                </html:option>
                <html:options collection="plants" property="locationkey" labelProperty="shortName"/>
              </html:select>
            </td>
          </tr>
          <tr>
            <td align="left" class="text7">&nbsp;
              <bean:message key="prompt.portloading"/>
              : </td>
          </tr>
          <tr>
            <td align="left">&nbsp;
              <html:select property="searchString11" styleClass="ftforminputsmall">
                <html:option value="%">
                  <bean:message key="prompt.selectalocation"/>
                </html:option>
                <html:options collection="ports" property="locationkey" labelProperty="shortName"/>
              </html:select>
            </td>
          </tr>
          <tr>
            <td align="left" class="text7">&nbsp;
              <bean:message key="prompt.portdischarge"/>
              : </td>
          </tr>
          <tr>
            <td align="left">&nbsp;
              <html:select property="searchString12" styleClass="ftforminputsmall">
                <html:option value="%">
                  <bean:message key="prompt.selectalocation"/>
                </html:option>
                <html:options collection="ports" property="locationkey" labelProperty="shortName"/>
              </html:select>
            </td>
          </tr>
          <tr>
            <td align="left" class="text7">&nbsp;
              <bean:message key="prompt.deliveryplant"/>
              : </td>
          </tr>
          <tr>
            <td align="left">&nbsp;
              <html:select property="searchString13" styleClass="ftforminputsmall">
                <html:option value="%">
                  <bean:message key="prompt.selectalocation"/>
                </html:option>
                <html:options collection="plants" property="locationkey" labelProperty="shortName"/>
              </html:select>
            </td>
          </tr>
        </table></td>
    </tr>
    <tr>
      <td><img src="images/spacer.gif" height="5"/></td>
    </tr>
    <tr>
      <td align="left" class="text7"><bean:message key="prompt.status"/>
        : </td>
    </tr>
    <tr>
      <td align="left" valign="top"><span class="ftformradiosmall">
        <html:radio property="searchString9" value="%"/>
        <bean:message key="prompt.all"/>
        <br/>
        <html:radio property="searchString9" value="PENDING"/>
        <bean:message key="prompt.pending"/>
        <br/>
        <html:radio property="searchString9" value="APPROVED"/>
        <bean:message key="prompt.approved"/>
        <br/>
        <html:radio property="searchString9" value="REJECTED"/>
        <bean:message key="prompt.rejected"/>
        </span> </td>
    </tr>
    <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
    </tr>
    <tr>
      <td><img src="images/spacer.gif" height="1"/></td>
    </tr>
  </table>
</div>
