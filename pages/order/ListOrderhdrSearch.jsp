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
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/order/ListOrderhdrSearchListG2codeAjax.js"></script>
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/order/ListOrderhdrSearchListG3codeAjax.js"></script>
<script type="text/javascript" language="javascript" src="/beacon/scripts/ajax/order/ListOrderhdrSearchListG4codeAjax.js"></script>




<div id="search" style="position:absolute; left:0px; top:0px; width:220px; height:650px; z-index:10; visibility: visible; background-color:#E6EAEF; border-right:solid 1px #C6C6C6;">

  <table border="0" cellpadding="0" cellspacing="1" width="220px" bgcolor="#E6EAEF">
    
    <tr><td><img src="images/spacer.gif" height="2"/></td></tr>
       
       
<tr><td align="center"><table border="0" cellpadding="0" cellspacing="1" width="210px" bgcolor="#999999">
<tr><td><table border="0" cellpadding="1" cellspacing="3" width="210px" bgcolor="#ffffff">      
           
    <tr>
      <td class="label2"><bean:message key="prompt.orderno"/>:</td>
    </tr>
    <tr>
      <td class="label2">
      <html:text property="searchString1" size="25" maxlength="40" styleClass="forminput1" onkeypress="return noenter()"/>
      </td>
    </tr>

</table></td></tr>
</table></td></tr>
    
 
<tr><td><img src="images/spacer.gif" height="2"/></td></tr>
    

<tr><td align="center"><table border="0" cellpadding="0" cellspacing="1" width="210px" bgcolor="#999999">
<tr><td><table border="0" cellpadding="1" cellspacing="3" width="210px" bgcolor="#ffffff">      
           
    <tr>
      <td class="label2"><bean:message key="prompt.consignmentno"/>:</td>
    </tr>
    <tr>
      <td class="label2">
      <html:text property="searchString14" size="25" maxlength="40" styleClass="forminput1" onkeypress="return noenter()"/>
      </td>
    </tr>

</table></td></tr>
</table></td></tr>
    
 
<tr><td><img src="images/spacer.gif" height="2"/></td></tr>
    
<tr><td align="center"><table border="0" cellpadding="0" cellspacing="1" width="210px" bgcolor="#999999">
<tr><td><table border="0" cellpadding="1" cellspacing="3" width="210px" bgcolor="#ffffff">   
    
    
    <tr>
      <td class="label2"><bean:message key="prompt.customer"/>:</td>
    </tr>
    <tr>
      <td class="label2">
      <html:select property="searchString2" styleClass="forminput1">
          <html:option value="%">
            <bean:message key="prompt.selectacustomer"/>
          </html:option>
          <html:options collection="customers" property="addrkey" labelProperty="shortLabel"/>
        </html:select>
      </td>
    </tr>
    

       
      <tr>
      <td><img src="images/spacer.gif" height="2"/></td>
    </tr>
           
        <tr>
      <td class="label2"><bean:message key="prompt.company"/>:</td>
    </tr>
    <tr>
      <td class="label2">                      
		<html:select property="searchString19" styleClass="forminput1">
			<html:options collection="usercompanykeylist" property="compid" labelProperty="name"/>	
		</html:select>  
      </td>
    </tr>
    
    
                          
    <tr>
      <td><img src="images/spacer.gif" height="2"/></td>
    </tr>
    
    
    <tr>
      <td class="label2"><bean:message key="prompt.orderdate"/>: </td>
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
      <td><img src="images/spacer.gif" height="2"/></td>
    </tr>
    
    
        <tr>
      <td class="label2"><bean:message key="prompt.locations"/>:</td>
    </tr>
    <tr>
      <td class="label2">
      <table border="0" cellpadding="0" cellspacing="1">
          <tr>
            <td align="left" class="label2">&nbsp;
              <bean:message key="prompt.pickupplant"/>
              : </td>
          </tr>
          <tr>
            <td align="left">&nbsp;
              <html:select property="searchString10" styleClass="forminput1">
                <html:option value="%">
                  <bean:message key="prompt.selectalocation"/>
                </html:option>
                <html:options collection="pickuplocations1" property="locationkey" labelProperty="shortName"/>
              </html:select>
            </td>
          </tr>
          <tr>
            <td align="left" class="label2">&nbsp;
              <bean:message key="prompt.portloading"/>
              : </td>
          </tr>
          <tr>
            <td align="left">&nbsp;
              <html:select property="searchString11" styleClass="forminput1">
                <html:option value="%">
                  <bean:message key="prompt.selectalocation"/>
                </html:option>
                <html:options collection="ports" property="locationkey" labelProperty="shortName"/>
              </html:select>
            </td>
          </tr>
          <tr>
            <td align="left" class="label2">&nbsp;
              <bean:message key="prompt.portdischarge"/>
              : </td>
          </tr>
          <tr>
            <td align="left">&nbsp;
              <html:select property="searchString12" styleClass="forminput1">
                <html:option value="%">
                  <bean:message key="prompt.selectalocation"/>
                </html:option>
                <html:options collection="ports" property="locationkey" labelProperty="shortName"/>
              </html:select>
            </td>
          </tr>
          <tr>
            <td align="left" class="label2">&nbsp;
              <bean:message key="prompt.deliveryplant"/>
              : </td>
          </tr>
          <tr>
            <td align="left">&nbsp;
              <html:select property="searchString13" styleClass="forminput1">
                <html:option value="%"><bean:message key="prompt.selectalocation"/></html:option>
                <html:options collection="deliverylocations1" property="locationkey" labelProperty="shortName"/>
              </html:select>
            </td>
          </tr>
        </table>
      </td>
    </tr>
    
        
    
      <tr>
      <td><img src="images/spacer.gif" height="2"/></td>
    </tr>
 
           
<tr>
	<td class="label2"><bean:message key="prompt.invoicestatus"/>:</td>
</tr>
<tr>
      <td class="label2">
              <html:select property="searchString3" styleClass="forminput1">
              	<html:option value="%"><bean:message key="prompt.all"/></html:option>
              	<html:option value="NOT INVOICED">Not Invoiced</html:option>        
              	<html:option value="PART INVOICED">Part Invoiced</html:option> 
              	<html:option value="FULLY INVOICED">Fully Invoiced</html:option>                       
              </html:select>            
      </td>   
</tr>
<tr><td class="label2">
<bean:message key="prompt.completed"/>:
</td></tr>   
<tr><td class="label2">
<html:select property="searchString30" styleClass="forminput1">
			<html:option value="N">No</html:option>    
			<html:option value="Y">Yes</html:option>        
</html:select> 
</td></tr>  

    
</table></td></tr>
</table></td></tr>

    
<tr><td><img src="images/spacer.gif" height="2"/></td></tr>

    
<tr><td align="center"><table border="0" cellpadding="0" cellspacing="1" width="210px" bgcolor="#999999">
<tr><td><table border="0" cellpadding="1" cellspacing="3" width="210px" bgcolor="#ffffff">   
    
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
     
 
<tr><td><img src="images/spacer.gif" height="1"/></td></tr>
        
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
<td align="right">
<a href="javascript:showHideSearch('search','search2');" >        
<img class="NavigationSprite Expand" title="Show More Search Options" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;"/>
</a>        
</td>
</tr>
</table></td></tr> 
                     
  </table>
  
</div>







<div id="search2" style="position:absolute; left:0px; top:0px; width:220px; height:650px; z-index:10; visibility: hidden; background-color:#E6EAEF; border-right:solid 1px #C6C6C6;">

  <table border="0" cellpadding="0" cellspacing="1" width="220px" bgcolor="#E6EAEF">
    

    
    <tr><td><img src="images/spacer.gif" height="5"/></td></tr>

    
<tr><td align="center"><table border="0" cellpadding="0" cellspacing="1" width="210px" bgcolor="#999999">
<tr><td><table border="0" cellpadding="1" cellspacing="3" bgcolor="#ffffff" width="210px">      
    
      
        <tr>
          <td align="left" class="label2"><bean:message key="prompt.gcodes"/>
        :</td>
        </tr>
        <tr>
          <td align="left">         
          <table border="0" cellpadding="0" cellspacing="1">
            <tr>
              <td align="left" class="label2">&nbsp;
                <bean:message key="prompt.portloading"/>
                : </td>
            </tr>
            <tr>
              <td align="left">&nbsp;
                <html:select property="searchString20" styleClass="forminput1" onchange="processListG2code21('searchString20','searchString21','searchString22','searchString23');">
                  <html:option value="">
                    <bean:message key="prompt.selectag1code"/>
                  </html:option>
                  <html:options collection="g1codes" property="g1codekey" labelProperty="g1codekey"/>
                </html:select></td>
            </tr>
            <tr>
              <td align="left">&nbsp;
                <html:select property="searchString21" styleClass="forminput1" onchange="processListG3code22('searchString20','searchString21','searchString22','searchString23');">
                  <html:option value="">
                    <bean:message key="prompt.selectag2code"/>
                  </html:option>
                </html:select></td>
            </tr>
            <tr>
              <td align="left">&nbsp;
                <html:select property="searchString22" styleClass="forminput1" onchange="processListG4code23('searchString20','searchString21','searchString22','searchString23');">
                  <html:option value="">
                    <bean:message key="prompt.selectag3code"/>
                  </html:option>
                </html:select></td>
            </tr>
            <tr>
              <td align="left">&nbsp;
                <html:select property="searchString23" styleClass="forminput1">
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
<table border="0" cellpadding="0" cellspacing="1">
            <tr>
              <td align="left" class="label2">&nbsp;
                <bean:message key="prompt.portdischarge"/>
                : </td>
            </tr>
            <tr>
              <td align="left">&nbsp;
                <html:select property="searchString24" styleClass="forminput1" onchange="processListG2code25('searchString24','searchString25','searchString26','searchString27');">
                  <html:option value="">
                    <bean:message key="prompt.selectag1code"/>
                  </html:option>
                  <html:options collection="g1codes" property="g1codekey" labelProperty="g1codekey"/>
                </html:select></td>
            </tr>
            <tr>
              <td align="left">&nbsp;
                <html:select property="searchString25" styleClass="forminput1" onchange="processListG3code26('searchString24','searchString25','searchString26','searchString27');">
                  <html:option value="">
                    <bean:message key="prompt.selectag2code"/>
                  </html:option>
                </html:select></td>
            </tr>
            <tr>
              <td align="left">&nbsp;
                <html:select property="searchString26" styleClass="forminput1" onchange="processListG4code27('searchString24','searchString25','searchString26','searchString27');">
                  <html:option value="">
                    <bean:message key="prompt.selectag3code"/>
                  </html:option>
                </html:select></td>
            </tr>
            <tr>
              <td align="left">&nbsp;
                <html:select property="searchString27" styleClass="forminput1">
                  <html:option value="">
                    <bean:message key="prompt.selectag4code"/>
                  </html:option>
                </html:select></td>
            </tr>
          </table> 
</td>
        </tr>
    
      <tr>
      <td><img src="images/spacer.gif" height="5"/></td>
    </tr>
       
    <tr>
      <td class="label2"><bean:message key="prompt.shippingline"/>:</td>
    </tr>
    <tr>
      <td class="label2">
      <html:select property="searchString28" styleClass="forminput1">
          <html:option value="">
            <bean:message key="prompt.selectavendor"/>
          </html:option>
          <html:options collection="vendors" property="addrkey" labelProperty="shortLabel"/>
        </html:select>
      </td>
    </tr>
 
 
       <tr>
      <td><img src="images/spacer.gif" height="5"/></td>
    </tr>
       
    <tr>
      <td class="label2"><bean:message key="prompt.vessel"/>:</td>
    </tr>
    <tr>
      <td class="label2">
      <html:select property="searchString29" styleClass="forminput1">
          <html:option value="">
            <bean:message key="prompt.selectavessel"/>
          </html:option>
			<html:options collection="vessels" property="vesselkey" labelProperty="vesselname"/>
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
<td align="right">
<a href="javascript:showHideSearch('search2','search');" >        
<img class="NavigationSprite Collapse" title="Hide More Search Options" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;"/>
</a>        
</td>
</tr>
</table></td></tr> 
                     
  </table>
  
</div>







