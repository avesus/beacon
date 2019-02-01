<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
/**
 *
 * Amendments
 * ----------
 * 											
 * NT	2010-01-19		201000006			Replace Addresss with Customers in Customer Name pull-down
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




<script language="JavaScript">
<!--	
function showHideSearch(div1,div2) { 

var v,obj1,obj2;

obj1=MM_findObj(div1);
obj1=obj1.style; 
v=obj1.visibility;
if (v=='hidden') {
	obj1.visibility='visible';	
}
else {
	obj1.visibility='hidden'; 
}

obj2=MM_findObj(div2);
obj2=obj2.style; 
v=obj2.visibility;
if (v=='hidden') {
	obj2.visibility='visible';	
}
else {
	obj2.visibility='hidden'; 
}

}
-->
</script>


<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/ajaxV2.js"></script> 
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/quotation/ListQuohdrSearchListG2codeAjax.js"></script>
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/quotation/ListQuohdrSearchListG3codeAjax.js"></script>
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/quotation/ListQuohdrSearchListG4codeAjax.js"></script>



<div id="div_search" style="position:absolute; left:0px; top:0px; width:270px; height:650px; z-index:10; visibility: visible; background-color:#EEEEEE;">
  <table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#EEEEEE">
    <tr>
      <td colspan="3" valign="middle"><h1 class="underline mtb0">
<INPUT name="searchButton" border="0" type="image" id="searchButton" src="images/refreshButtonBorderGrey.gif" align="bottom" onMouseOut="MM_swapImgRestore();" onMouseOver="MM_swapImage('searchButton','','images/refreshButtonBorderGrey.gif','searchButton','','images/refreshButtonBorderGrey_over_blue.gif',1);"/>
          <bean:message key="quohdr.title.search"/>
        </h1></td>
<td bgcolor="#CCCCCC" width="1" rowspan="27"><img src="images/spacer.gif" width="1" height="650"/></td>
    </tr>
    
    <tr>
    <td width="5" rowspan="26"><img src="images/spacer.gif" width="5"/></td>
      <td width="230"><img src="images/spacer.gif"height="20" width="230"/></td>
      <td rowspan="26">
<!--check advance search selected-->        
<c:if test="${ListQuohdrForm.searchString20!='' or ListQuohdrForm.searchString21!='' or ListQuohdrForm.searchString22!='' or ListQuohdrForm.searchString23!='' or ListQuohdrForm.searchString24!='' or ListQuohdrForm.searchString25!='' or ListQuohdrForm.searchString26!='' or ListQuohdrForm.searchString27!=''}">         
<img src="images/buttons/btn_advance_search_show_select.png" align="right" id="btn_expand_search" onclick="showHideSearch('div_search','div_search2');" border="0"/>
</c:if>
<c:if test="${ListQuohdrForm.searchString20=='' and ListQuohdrForm.searchString21=='' and ListQuohdrForm.searchString22=='' and ListQuohdrForm.searchString23=='' and ListQuohdrForm.searchString24=='' and ListQuohdrForm.searchString25=='' and ListQuohdrForm.searchString26=='' and ListQuohdrForm.searchString27==''}">         
<img src="images/buttons/btn_advance_search_show.png" align="right" id="btn_expand_search" onclick="showHideSearch('div_search','div_search2');" border="0"/>
</c:if>
      </td>
    </tr>
    
    <tr>
      <td align="left" class="text7"><bean:message key="prompt.quotno"/>
      :</td>
    </tr>
    <tr>
      <td align="left" ><html:text property="searchString1" size="35" maxlength="40" styleClass="ftforminputsmall" onkeypress="return noenter()"/>
      </td>
    </tr>
    <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
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
          <html:options collection="customers" property="addrkey" labelProperty="shortLabel"/><!--201000006-->
        </html:select>
      </td>
    </tr>
    <tr>
      <td align="left" class="text7"><bean:message key="prompt.customername"/>
      : </td>
    </tr>
    <tr>
      <td align="left"><html:text property="searchString14" size="35" maxlength="40" styleClass="ftforminputsmall" onkeypress="return noenter()"/>
      </td>
    </tr>
    	
    <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
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
      <td><img src="images/spacer.gif" height="10"/></td>
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
    </tr>
    <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
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
                <html:options collection="pickuplocations1" property="locationkey" labelProperty="shortName"/>
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
                <html:options collection="ports" property="locationkey" labelProperty="shortLabel"/>
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
                <html:options collection="ports" property="locationkey" labelProperty="shortLabel"/>
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
                <html:options collection="deliverylocations1" property="locationkey" labelProperty="shortName"/>
              </html:select>
            </td>
          </tr>
        </table></td>
    </tr>
    <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
    </tr>
    <tr>
      <td align="left" class="text7"><bean:message key="prompt.activeexpired"/>
        : </td>
    </tr>
    <tr>
      <td align="left" valign="top"><span class="ftformradiosmall">
        <html:radio property="searchString15" value="ALL"/>
        <bean:message key="prompt.all"/>
&nbsp;	  
        <html:radio property="searchString15" value="ACTIVE"/>
        <bean:message key="prompt.active"/>
&nbsp;
        <html:radio property="searchString15" value="EXPIRED"/>
        <bean:message key="prompt.expired"/>
        </span> </td>
    </tr>	
    <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
    </tr>
    <tr>
      <td align="left" class="text7"><bean:message key="prompt.status"/>: </td>
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
    
  </table>
</div>



<div id="div_search2" style="position:absolute; left:0px; top:0px; width:470px; height:650px; z-index:10; visibility: hidden; background-color:#EEEEEE;">
  <table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#EEEEEE">
    <tr>
      <td colspan="4" valign="middle"><h1 class="underline mtb0">
<INPUT name="searchButton" border="0" type="image" id="searchButton" src="images/refreshButtonBorderGrey.gif" align="bottom" onMouseOut="MM_swapImgRestore();" onMouseOver="MM_swapImage('searchButton','','images/refreshButtonBorderGrey.gif','searchButton','','images/refreshButtonBorderGrey_over_blue.gif',1);"/>
          <bean:message key="quohdr.title.search"/>
        </h1></td>
<td bgcolor="#CCCCCC" width="1" rowspan="27"><img src="images/spacer.gif" width="1" height="650"/></td>
    </tr>
    
    <tr>
    <td width="5" rowspan="26"><img src="images/spacer.gif" width="5"/></td>
      <td width="440" colspan="2"><img src="images/spacer.gif"height="20" width="440"/></td>
      <td rowspan="26">
<img src="images/buttons/btn_advance_search_hide.png" align="right" id="btn_expand_search" onclick="showHideSearch('div_search','div_search2');"/>
      </td>
    </tr>
    
    <tr>
      <td align="left" class="text7"><bean:message key="prompt.quotno"/>
      :</td>
            <td rowspan="25">
      
<!--advanced search options -->               
     <table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#EEEEEE">
        <tr>
          <td align="left" class="text7"><bean:message key="prompt.gcodes"/>
        :</td>
        </tr>
        <tr>
          <td align="left">
          <table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#EEEEEE">
            <tr>
              <td align="left" class="text7">&nbsp;
                <bean:message key="prompt.portloading"/>
                : </td>
            </tr>
            <tr>
              <td align="left">&nbsp;
                <html:select property="searchString20" styleClass="ftforminputsmall" onchange="processListG2code21('searchString20','searchString21','searchString22','searchString23');">
                  <html:option value="">
                    <bean:message key="prompt.selectag1code"/>
                  </html:option>
                  <html:options collection="g1codes" property="g1codekey" labelProperty="g1codekey"/>
                </html:select></td>
            </tr>
            <tr>
              <td align="left">&nbsp;
                <html:select property="searchString21" styleClass="ftforminputsmall" onchange="processListG3code22('searchString20','searchString21','searchString22','searchString23');">
                  <html:option value="">
                    <bean:message key="prompt.selectag2code"/>
                  </html:option>
                </html:select></td>
            </tr>
            <tr>
              <td align="left">&nbsp;
                <html:select property="searchString22" styleClass="ftforminputsmall" onchange="processListG4code23('searchString20','searchString21','searchString22','searchString23');">
                  <html:option value="">
                    <bean:message key="prompt.selectag3code"/>
                  </html:option>
                </html:select></td>
            </tr>
            <tr>
              <td align="left">&nbsp;
                <html:select property="searchString23" styleClass="ftforminputsmall">
                  <html:option value="">
                    <bean:message key="prompt.selectag4code"/>
                  </html:option>
                </html:select></td>
            </tr>
          </table>        
          </td>
        </tr>
        <tr>
          <td align="left">
<table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#EEEEEE">
            <tr>
              <td align="left" class="text7">&nbsp;
                <bean:message key="prompt.portdischarge"/>
                : </td>
            </tr>
            <tr>
              <td align="left">&nbsp;
                <html:select property="searchString24" styleClass="ftforminputsmall" onchange="processListG2code25('searchString24','searchString25','searchString26','searchString27');">
                  <html:option value="">
                    <bean:message key="prompt.selectag1code"/>
                  </html:option>
                  <html:options collection="g1codes" property="g1codekey" labelProperty="g1codekey"/>
                </html:select></td>
            </tr>
            <tr>
              <td align="left">&nbsp;
                <html:select property="searchString25" styleClass="ftforminputsmall" onchange="processListG3code26('searchString24','searchString25','searchString26','searchString27');">
                  <html:option value="">
                    <bean:message key="prompt.selectag2code"/>
                  </html:option>
                </html:select></td>
            </tr>
            <tr>
              <td align="left">&nbsp;
                <html:select property="searchString26" styleClass="ftforminputsmall" onchange="processListG4code27('searchString24','searchString25','searchString26','searchString27');">
                  <html:option value="">
                    <bean:message key="prompt.selectag3code"/>
                  </html:option>
                </html:select></td>
            </tr>
            <tr>
              <td align="left">&nbsp;
                <html:select property="searchString27" styleClass="ftforminputsmall">
                  <html:option value="">
                    <bean:message key="prompt.selectag4code"/>
                  </html:option>
                </html:select></td>
            </tr>
          </table>          
</td>
        </tr>
        <tr>
          <td align="left">&nbsp;
</td>
        </tr>
        <tr>
          <td align="left">&nbsp;
</td>
        </tr>
      </table>
            
      </td>
    </tr>
    <tr>
      <td align="left" ><html:text property="searchString1" size="35" maxlength="40" styleClass="ftforminputsmall" onkeypress="return noenter()"/>
      </td>
    </tr>
    <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
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
          <html:options collection="customers" property="addrkey" labelProperty="shortLabel"/><!--201000006-->
        </html:select>
      </td>
    </tr>
    <tr>
      <td align="left" class="text7"><bean:message key="prompt.customername"/>
      : </td>
    </tr>
    <tr>
      <td align="left"><html:text property="searchString14" size="35" maxlength="40" styleClass="ftforminputsmall" onkeypress="return noenter()"/>
      </td>
    </tr>
     <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
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
      <td><img src="images/spacer.gif" height="10"/></td>
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
    </tr>
    <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
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
                <html:options collection="pickuplocations1" property="locationkey" labelProperty="shortName"/>
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
                <html:options collection="ports" property="locationkey" labelProperty="shortLabel"/>
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
                <html:options collection="ports" property="locationkey" labelProperty="shortLabel"/>
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
                <html:options collection="deliverylocations1" property="locationkey" labelProperty="shortName"/>
              </html:select>
            </td>
          </tr>
        </table></td>
    </tr>
    <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
    </tr>
    <tr>
      <td align="left" class="text7"><bean:message key="prompt.activeexpired"/>
        : </td>
    </tr>
    <tr>
      <td align="left" valign="top"><span class="ftformradiosmall">
        <html:radio property="searchString15" value="ALL"/>
        <bean:message key="prompt.all"/>
&nbsp;	  
        <html:radio property="searchString15" value="ACTIVE"/>
        <bean:message key="prompt.active"/>
&nbsp;
        <html:radio property="searchString15" value="EXPIRED"/>
        <bean:message key="prompt.expired"/>
        </span> </td>
    </tr>	
    <tr>
      <td><img src="images/spacer.gif" height="10"/></td>
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
    
  </table>
</div>





      
      