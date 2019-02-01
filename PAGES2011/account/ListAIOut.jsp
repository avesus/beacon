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

<!-- tell jsp to use the user bean -->
<jsp:useBean
  id="user"
  class="com.bureaueye.beacon.model.standard.User"
  scope="session"
/>

<app:checkLogon/>

<html:html>
  <head>
  <title>
  <bean:message key="aiout.title.list"/>
  </title>
  <link rel="stylesheet" type="text/css" href="css/base.css" />
  
  <script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>
<script language="javascript" type="text/javascript">
//<![CDATA[
	function onLoad() {	
		//onLoadSidebar('menu2');								
	}
    //]]>
</script>


</head>


  <body onLoad="onLoad();">

<table cellpadding="0" cellspacing="0" border="0" width="100%">

<%-- HEADER -----------------%>
<tr>
	<td colspan="2">
<jsp:include page="/pages/header.jsp" flush="true" />
	</td>
</tr>

<%-- BREADCRUMBS -----------------%> 
<tr>
	<td height="20" bgcolor="#eeeeee">&nbsp;</td>  
	<td class="tdwht"><span class="heading2">     
		<strong><bean:message key="aiout.title"/></strong> 
		</span>
		<span class="heading2">
			<html:link action="/ListAIOut" styleClass="link5">
				<bean:message key="title.list"/> 	
			</html:link>
		</span>					
	</td> 
</tr>  
<tr valign="top" bgcolor="#eeeeee">
	<td height="1" colspan="2"></td>
</tr>
<%-- BREADCRUMBS -----------------%> 


<tr>
<%-- SIDEBAR -----------------%>
	<td bgcolor="#eeeeee" width="121" valign="top" align="center">	
	</td>
	
<%-- BODY -----------------%>	
	<td>
	
		<div style="OVERFLOW:auto; width:1150px; height:650px;">	

<table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
<tr><td>

<html:form action="/ListAIOut" focus="searchString1">
<html:hidden property="gotoPage" />

<table border="0" cellpadding="2" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>	

<table border="0" cellpadding="3" cellspacing="0" width="100%" bgcolor="#ffffff">
<tr><td>


<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#CED6E3">
  <tr><td>

<table border="0" cellpadding="0" cellspacing="1" width="100%" bgcolor="#CED6E3">
<tr><td colspan="2" valign="middle">
<h1 class="underline mtb0">
<INPUT name="refreshButton" border="0" type="image" src="images/report/refreshButtonBorder.gif" align="bottom" id="refreshButton" title="Refresh" onMouseOut="MM_swapImgRestore();" onMouseOver="MM_swapImage('refreshButton','','images/report/refreshButtonBorder.gif','refreshButton','','images/report/refreshButtonBorder_over_blue.gif',1);"/>
&nbsp;<bean:message key="aiout.title.search"/>
</h1>
</td></tr>
<tr><td colspan="2"><img src="images/spacer.gif" height="10"/></td></tr>
	<tr>
		<td align="left" width="40%" class="text7">
<bean:message key="prompt.doctype"/>:		
        </td>
		<td align="left" width="60%" class="text7">
<bean:message key="prompt.createdate"/>:
		</td>		
  	</tr>
  	<tr>
		<td align="left" width="40%">
		<html:select property="searchString1" styleClass="ftforminputsmall">
			<html:option value="">- select a Type -</html:option>				
			<html:option value="AR">AR</html:option>
			<html:option value="AP_ACCRUAL">AP_ACCRUAL</html:option>    
            <html:option value="AP_ACTUAL">AP_ACTUAL</html:option>                   															
		</html:select>						
		</td>
	<td width="60%">
		<table width="95%">
		<tr>
          <td width="10%" class="text7">
		  <div align="left">
		&nbsp;<bean:message key="prompt.from"/>:
		  </div>		  
		  </td>		
          <td width="40%">
		<html:select property="searchDate1dd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="searchDate1mm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="searchDate1yyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>			 	  
          </td>		
          <td width="5%" class="text7">
		  <div align="right">
		       <bean:message key="prompt.to"/>:
		  </div>		  
		  </td>
          <td width="40%">
		<html:select property="searchDate2dd" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.day"/></html:option>				
			<html:options collection="days" property="value" labelProperty="label"/>	
		</html:select>		  
		<html:select property="searchDate2mm" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.month"/></html:option>				
			<html:options collection="months" property="value" labelProperty="label"/>	
		</html:select>
		<html:select property="searchDate2yyyy" styleClass="ftforminputsmall">
			<html:option value=""><bean:message key="prompt.year"/></html:option>				
			<html:options collection="years" property="value" labelProperty="label"/>	
		</html:select>			 	  
          </td>
		  </tr>
		  </table>
		</td>		
	<tr>
	<tr>
		<td align="left" width="40%" class="text7"><bean:message key="prompt.status"/>: </td>
		<td align="left" width="60%" class="text7"><bean:message key="prompt.documentkey"/>: </td>		
  	</tr>
  	<tr>
		<td align="left" width="40%">		<span class="ftformradiosmall3">
<html:radio property="searchString9" value="%"/>
All
<html:radio property="searchString9" value="PENDING"/>
Pending 
<html:radio property="searchString9" value="SENT"/>
Sent
<html:radio property="searchString9" value="ERROR"/>
Error 
</span></td>
		<td width="60%" align="left" valign="top">
		<html:text property="searchString2" size="20" maxlength="20" styleClass="ftforminputsmall"/>  
		</td>
  	</tr>	
	
	<tr>
		<td align="left" width="40%" class="text7"><bean:message key="prompt.batchid"/>: </td>
		<td align="left" width="60%" class="text7"></td>		
  	</tr>
  	<tr>
		<td align="left" width="40%">
		<html:text property="searchString3" size="20" maxlength="20" styleClass="ftforminputsmall"/>          
        </td>
		<td width="60%" align="left" valign="top">

		</td>
  	</tr>
    
  	<tr>
  	  <td align="left" width="40%" valign="top">
	    
  	    </td>			
	  </tr>		
	<tr><td colspan="2"><img src="images/spacer.gif" height="5"/></td></tr> 
</table>

</td></tr></table>

</td>
</tr>
</table>

<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
  <tr>
	<td width="85%">
<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
  <tr>
	<td class="text2">
	<bean:message key="prompt.sortby"/>:&nbsp;
<logic:notEqual name="ListAIOutForm" property="orderBy"
			scope="session" value="AIOUT_ID">
	<html:link action="/ListAIOut?orderBy=AIOUT_ID&gotoPage=0" styleClass="link6"><bean:message key="prompt.docid"/></html:link>	
</logic:notEqual>
<logic:equal name="ListAIOutForm" property="orderBy"
			scope="session" value="AIOUT_ID">
	<strong><bean:message key="prompt.docid"/></strong>
</logic:equal>		
	<strong>&nbsp;|&nbsp;</strong>	
<logic:notEqual name="ListAIOutForm" property="orderBy"
			scope="session" value="Doctype">
	<html:link action="/ListAIOut?orderBy=Doctype&gotoPage=0" styleClass="link6"><bean:message key="prompt.doctype"/></html:link>	
</logic:notEqual>
<logic:equal name="ListAIOutForm" property="orderBy"
			scope="session" value="Doctype">
	<strong><bean:message key="prompt.doctype"/></strong>
</logic:equal>		
	<strong>&nbsp;|&nbsp;</strong>	
<logic:equal name="ListAIOutForm" property="orderBy"
			scope="session" value="Createdate">		
	<strong><bean:message key="prompt.createtime"/></strong>
</logic:equal>
<logic:notEqual name="ListAIOutForm" property="orderBy"
			scope="session" value="Createdate">
			<span class="link4">
	<html:link action="/ListAIOut?orderBy=Createdate&gotoPage=0" styleClass="link6"><bean:message key="prompt.createtime"/></html:link>	
			</span>
</logic:notEqual>
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListAIOutForm" property="orderBy"
			scope="session" value="Sentdate">		
	<strong><bean:message key="prompt.senttime"/></strong>
</logic:equal>
<logic:notEqual name="ListAIOutForm" property="orderBy"
			scope="session" value="Sentdate">
			<span class="link4">
	<html:link action="/ListAIOut?orderBy=Sentdate&gotoPage=0" styleClass="link6"><bean:message key="prompt.senttime"/></html:link>	
			</span>
</logic:notEqual>
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListAIOutForm" property="orderBy"
			scope="session" value="Aistatus">		
	<strong><bean:message key="prompt.status"/></strong>
</logic:equal>
<logic:notEqual name="ListAIOutForm" property="orderBy"
			scope="session" value="Aistatus">
			<span class="link4">
	<html:link action="/ListAIOut?orderBy=Aistatus&gotoPage=0" styleClass="link6"><bean:message key="prompt.status"/></html:link>	
			</span>
</logic:notEqual>
	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListAIOutForm" property="orderBy"
			scope="session" value="AIBATCH_ID">		
	<strong><bean:message key="prompt.batchid"/></strong>
</logic:equal>
<logic:notEqual name="ListAIOutForm" property="orderBy"
			scope="session" value="AIBATCH_ID">
			<span class="link4">
	<html:link action="/ListAIOut?orderBy=AIBATCH_ID&gotoPage=0" styleClass="link6"><bean:message key="prompt.batchid"/></html:link>	
			</span>
</logic:notEqual>


	<strong>&nbsp;|&nbsp;</strong>
<logic:equal name="ListAIOutForm" property="orderBy"
			scope="session" value="Dockey">		
	<strong><bean:message key="prompt.documentkey"/></strong>
</logic:equal>
<logic:notEqual name="ListAIOutForm" property="orderBy"
			scope="session" value="Dockey">
			<span class="link4">
	<html:link action="/ListAIOut?orderBy=Dockey&gotoPage=0" styleClass="link6"><bean:message key="prompt.documentkey"/></html:link>	
			</span>
</logic:notEqual>


	</td>	
  </tr>
</table>
	</td>
<td width="15%">
<table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
  <tr>
	<td align="right">&nbsp;
	</td>
  </tr> 
</table>
	</td>
  </tr> 
</table>
<table width="100%" border="0" cellspacing="2" cellpadding="0" valign="top" bgcolor="#FFFFFF">
	<tr>
		<td>
			<table width="100%"  border="0" cellpadding="0" cellspacing="1" bgcolor="#FFFFFF">
				<tr>
		  			<td class="tdblue" width="8%">
					<span class="heading4">					
						<bean:message key="heading.docid"/>					</span>					</td>				
		  			<td class="tdblue" width="8%">
					<span class="heading4">					
						<bean:message key="heading.doctype"/>						</span>					</td>						
		  			<td class="tdblue" width="7%">
					<span class="heading4">	
					<bean:message key="heading.status"/>					</span>					</td>
		  			<td class="tdblue" width="10%"><span class="heading4"><bean:message key="heading.createuser"/> </span></td>
		  			<td class="tdblue" width="10%">
					<span class="heading4">					
						<bean:message key="heading.createtime"/></span>					</td>											
		  			<td class="tdblue" width="15%">
					<span class="heading4">					
						<bean:message key="heading.senttime"/>					</span>					</td>
		  			<td class="tdblue" width="10%"><span class="heading4"><bean:message key="heading.documentkey"/></span></td>
		  			<td class="tdblue" width="6%" align="left">
                    <span class="heading4">
                    <bean:message key="heading.companyid"/>
                    </span></td>																								
		  			<td class="tdblue" width="5%" align="left">
		  			  <span class="heading4">
		  			    <bean:message key="heading.batchid"/>					</span> </td>
		  			<td class="tdblue" width="16%" align="right">

                    </td>																
				</tr>		
				

			<c:forEach var="lineItem" items="${ListAIOutForm.lineItems}" varStatus="loop">
										
				<c:set var="_class" value="tdlghtgry"/>
				<c:if test="${lineItem.aistatus == 'ERROR'}">
					<c:set var="_class" value="tdlghtgryRed"/>
				</c:if>	
				<c:if test="${loop.count % 2 == 0}">
					<c:set var="_class" value="tdlghtgry2"/>
					<c:if test="${lineItem.aistatus == 'ERROR'}">
 						<c:set var="_class" value="tdlghtgry2Red"/>
					</c:if>					
				</c:if>
								
			<!-- row1 -->
  				<tr>	
								<td class='<c:out value="${_class}"/>' valign="top">
									<bean:write name="lineItem" property="aioutId" filter="true"/>								</td> 				
								<td class='<c:out value="${_class}"/>' valign="top">
									<bean:write name="lineItem" property="doctype" filter="true"/>								</td>  												
								<td class='<c:out value="${_class}"/>' nowrap valign="top">
									<bean:write name="lineItem" property="aistatus" filter="true"/>								</td>								
								<td class='<c:out value="${_class}"/>' valign="top"><bean:write name="lineItem" property="createuserid" filter="true"/></td>
								<td class='<c:out value="${_class}"/>' valign="top">
									<bean:write name="lineItem" property="createdate" format="dd-MMM-yyyy" filter="true"/>								</td>								
								<td class='<c:out value="${_class}"/>' valign="top">																	
<bean:write name="lineItem" property="sentdate" format="dd-MMM-yyyy" filter="true"/>&nbsp;<bean:write name="lineItem" property="senttime" filter="true"/></td>								
								<td class='<c:out value="${_class}"/>' nowrap valign="top">																	
								  <bean:write name="lineItem" property="dockey" filter="true"/>								</td>
								<td class='<c:out value="${_class}"/>' align="left" valign="top" nowrap>
                                <bean:write name="lineItem" property="companykey" filter="true"/>	
                                </td>		
								<td class='<c:out value="${_class}"/>' align="left" valign="top" nowrap>
  										<bean:write name="lineItem" property="aibatchId" filter="true"/>								</td>		
					<td class='<c:out value="${_class}"/>' align="right">
                                      					
	  					<app:linkAIOutLineItem page="/EditAIOut.do?action=View">
						<bean:message key="prompt.view"/>					
						</app:linkAIOutLineItem>

<c:if test="${lineItem.aistatus != 'PENDING'}">					
            			&nbsp;<span style="color:000000;">|</span>&nbsp;
	  					<app:linkAIOutLineItem page="/EditAIOut.do?action=ReSend">
						Re-send					
						</app:linkAIOutLineItem>  
</c:if>


<c:if test="${lineItem.aistatus == 'PENDING'}">	
                        &nbsp;<span style="color:000000;">|</span>&nbsp;  				
                        <app:linkAIOutLineItem page="/EditAIOut.do?action=Delete">
						<bean:message key="prompt.delete"/>					
						</app:linkAIOutLineItem>                        
</c:if>
                          

									
					</td>																												
				</tr>
                	
                									
			</c:forEach>
			</table>
		</td>
	</tr>
</table>
</td>
</tr>
</table>

</html:form>

</td>
</tr>
</table>

</div>
</td>
</tr>


<%-- FOOTER -----------------%>
<tr>
	<td colspan="2">
<jsp:include page="/pages/footer.jsp" flush="true" />
	</td>
</tr>

</table>

</body>
</html:html>
