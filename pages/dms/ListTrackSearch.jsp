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









<div id="search" style="position:absolute; left:0px; top:0px; width:220px; height:650px; z-index:10; visibility: visible; background-color:#E6EAEF;">

  <table border="0" cellpadding="1" cellspacing="2" width="100%" bgcolor="#E6EAEF">
    
    <tr><td><img src="images/spacer.gif" height="10"/></td></tr>
       
       
<tr><td align="center"><table border="0" cellpadding="0" cellspacing="1" width="95%" bgcolor="#999999">
<tr><td><table border="0" cellpadding="1" cellspacing="5" width="100%" bgcolor="#ffffff">      
           
    <tr>
      <td class="label2"><bean:message key="prompt.docid"/>:</td>
    </tr>
    <tr>
      <td class="label2">
      <html:text property="searchString1" size="25" maxlength="40" styleClass="forminput1" onkeypress="return noenter()"/>
      </td>
    </tr>

</table></td></tr>
</table></td></tr>

    
       
 
     <tr><td><img src="images/spacer.gif" height="5"/></td></tr>
    
    
<tr><td align="center"><table border="0" cellpadding="0" cellspacing="1" width="95%" bgcolor="#999999">
<tr><td><table border="0" cellpadding="1" cellspacing="5" width="100%" bgcolor="#ffffff">   
    
    <tr>
      <td class="label2"><bean:message key="prompt.documentdescription"/>:</td>
    </tr>
    <tr>
      <td class="label2">
      <html:text property="searchString7" size="25" maxlength="40" styleClass="forminput1" onkeypress="return noenter()"/>
      </td>
    </tr>
 
 
     <tr>
      <td><img src="images/spacer.gif" height="5"/></td>
    </tr>
        
        
        <tr>
      <td class="label2"><bean:message key="prompt.categorycode"/>:</td>
    </tr>
    <tr>
      <td class="label2">     
<html:select property="searchString3" styleClass="forminput1">
                <html:option value=""><bean:message key="prompt.selectacategory"/></html:option> 
                <html:options collection="categorys" property="categorycode" labelProperty="categorycode"/>                
</html:select>   
      </td>
    </tr>
    

       
      <tr>
      <td><img src="images/spacer.gif" height="5"/></td>
    </tr>
           
        <tr>
      <td class="label2"><bean:message key="prompt.doctype"/>:</td>
    </tr>
    <tr>
      <td class="label2">
<html:select property="searchString2" styleClass="forminput1">
                <html:option value=""><bean:message key="prompt.selectadoctype"/></html:option> 
                <html:options collection="doctypes" property="doctype" labelProperty="doctype"/>                             
</html:select>
      </td>
    </tr>
    
                                  
    

        
       <tr>
      <td><img src="images/spacer.gif" height="5"/></td>
    </tr>
        
        <tr>
      <td class="label2"><bean:message key="prompt.companyid"/>:</td>
    </tr>
    <tr>
      <td class="label2">
<html:select property="searchString5" styleClass="forminput1">
			<html:options collection="usercompanykeylist" property="compid" labelProperty="name"/>	                
</html:select>
      </td>
    </tr>
           
             <tr>
      <td><img src="images/spacer.gif" height="5"/></td>
    </tr>
        
        <tr>
      <td class="label2"><bean:message key="prompt.createuserid"/>:</td>
    </tr>
    <tr>
      <td class="label2">
      <html:text property="searchString6" size="25" maxlength="40" styleClass="forminput1" onkeypress="return noenter()"/>
      </td>
    </tr>
    
                          
    <tr>
      <td><img src="images/spacer.gif" height="5"/></td>
    </tr>
    
    
    <tr>
      <td class="label2"><bean:message key="prompt.createdate"/>: </td>
    </tr>
    <tr>
      <td><table border="0" cellpadding="0" cellspacing="0" width="100%">
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

    
</table></td></tr>
</table></td></tr>

    
    <tr><td><img src="images/spacer.gif" height="5"/></td></tr>

    
<tr><td align="center"><table border="0" cellpadding="0" cellspacing="1" width="95%" bgcolor="#999999">
<tr><td><table border="0" cellpadding="1" cellspacing="5" width="100%" bgcolor="#ffffff">   
    
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
     
 
 
<tr><td><img src="images/spacer.gif" height="10"/></td></tr>
        
<tr><td>

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
 
</td></tr>
 
                     
  </table>
  
</div>
