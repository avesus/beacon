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









<div id="div_search" style="position:absolute; left:0px; top:0px; width:1400px; height:100px; z-index:30; visibility: visible; background-color:#EEEEEE;">
  <table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#EEEEEE">
  
    <tr>
          <td colspan="5"  valign="middle"><h1 class="underline mtb0">
<INPUT name="searchButton" border="0" type="image" id="searchButton" src="images/refreshButtonBorderGrey.gif" align="bottom" onMouseOut="MM_swapImgRestore();" onMouseOver="MM_swapImage('searchButton','','images/refreshButtonBorderGrey.gif','searchButton','','images/refreshButtonBorderGrey_over_blue.gif',1);"/>
              <bean:message key="title.search"/>
            </h1></td>
        <td bgcolor="#CCCCCC" width="3" rowspan="5"><img src="images/spacer.gif" width="1" height="100"/></td>
    </tr>
    
    <tr>
      <td width="5" rowspan="4"><img src="images/spacer.gif" width="5"/></td>
      <td width="274"></td>
      <td width="229">&nbsp;</td>
      <td width="205">&nbsp;</td>
      <td width="684"><img src="images/spacer.gif" height="5"/></td>
    </tr>
    
    <tr>
      <td align="left" class="text7">Transport Mode
        : </td>
      <td align="left" class="text7">Validity
        :</td>
      <td align="left" class="text7"><bean:message key="prompt.locations"/>
      :</td>
      <td align="left" class="text7">Transit Time:</td>
    </tr>
    <tr>
      <td align="left" valign="top"><table border="0" cellpadding="0" cellspacing="1" width="83%">
        <tr>
          <td class="text7">
<span class="ftformradiosmall3">
<input type="radio" name="searchString19" value="OCEAN" checked="checked">OCEAN
<input type="radio" name="searchString19" value="RAIL">RAIL
<input type="radio" name="searchString19" value="TRUCK">TRUCK
</span>
            </td>
          </tr>
        <tr><td><img src="images/spacer.gif" height="10"/></td></tr>              
        <tr>
          <td class="text7">Vendor
            : </td>
          </tr>
        <tr>
          <td>
<span class="ftforminputsmall">        
            <select name="select3" property="searchString2" styleclass="ftforminputsmall">
              <option value="%">- select a Carrier -</option>
              <option> </option>
            </select>
</span>            
            </td>
          </tr>
      </table></td>
      <td align="left" valign="top"><table border="0" cellpadding="0" cellspacing="1" width="100%">
          <tr>
            <td class="text7">&nbsp;
              <bean:message key="prompt.from"/>
              :</td>
          </tr>
          <tr>
            <td>&nbsp;
              <select property="searchDate1dd" styleClass="ftforminputsmall">
                <option value=""><bean:message key="prompt.day"/></option>
              </select>
              <select property="searchDate1mm" styleClass="ftforminputsmall">
                <option value=""><bean:message key="prompt.month"/></option>
              </select>
              <select property="searchDate1yyyy" styleClass="ftforminputsmall">
                <option value=""><bean:message key="prompt.year"/></option>
              </select>
            </td>
          </tr>
          <tr>
            <td class="text7">&nbsp;
              <bean:message key="prompt.to"/>:</td>
          </tr>
          <tr>
            <td>&nbsp;
              <select property="searchDate2dd" styleClass="ftforminputsmall">
                <option value=""><bean:message key="prompt.day"/></option>
              </select>
              <select property="searchDate2mm" styleClass="ftforminputsmall">
                <option value=""><bean:message key="prompt.month"/></option>
              </select>
              <select property="searchDate2yyyy" styleClass="ftforminputsmall">
                <option value=""><bean:message key="prompt.year"/></option>
              </select>
            </td>
          </tr>
        </table></td>
      <td align="left" valign="top"><table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#EEEEEE">
        <tr>
          <td align="left" class="text7">&nbsp;
            Load Port: </td>
        </tr>
        <tr>
          <td align="left">&nbsp;
            <select name="select2" property="searchString11" styleclass="ftforminputsmall">
              <option value="%">- select a Location -</option>
              <option> </option>
            </select></td>
        </tr>
        <tr>
          <td align="left" class="text7">&nbsp;
            Port of Destination
            : </td>
        </tr>
        <tr>
          <td align="left">&nbsp;
            <select name="select2" property="searchString12" styleclass="ftforminputsmall">
              <option value="%">- select a Location -</option>
              <option> </option>
            </select></td>
        </tr>
      </table></td>
      <td align="left" valign="top"><table border="0" cellpadding="0" cellspacing="1" width="100%">
        <tr>
          <td class="text7">&nbsp;
            <bean:message key="prompt.from"/>
            : &nbsp; <input type="text" size="5" value="0" name="searchString1" styleClass="ftforminputsmall"/> 
&nbsp;<bean:message key="prompt.to"/>
            : &nbsp; <input type="text" size="5" value="0" name="searchString2" styleClass="ftforminputsmall"/>            
            </td>
        </tr>
        <tr><td><img src="images/spacer.gif" height="10"/></td></tr>        
        <tr>
          <td><span class="text7">IMO Class
            : </span></td>
        </tr>
        <tr>
          <td class="text7"><span class="ftforminputsmall">
<input type="text" value="" name="searchString3" size="5" styleClass="ftforminputsmall"/>
          </span></td>
        </tr>
      </table></td>
    </tr>
    
    <tr>
      <td><img src="images/spacer.gif" height="5"/></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    
       
  </table>
</div>







