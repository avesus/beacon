<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%--
 *
 * Amendments
 * ----------
 *																					
 * 
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
function showHideDetails(div,but) { 

var i,p,v,obj,but;

obj=MM_findObj(div);
obj=obj.style; 
v=obj.visibility;
if (v=='hidden') {
	obj.visibility='visible';	
	MM_swapImage(but,'','images/icon_collapse_12_12.png');	
}
else {
	obj.visibility='hidden'; 
	MM_swapImage(but,'','images/icon_expand_12_12.png');	
}
}
-->
</script>






<div id="results" style="position:absolute; left:220px; top:0px; width:1180px; height:650px; z-index:20; visibility: visible">


<table border="0" cellpadding="0" cellspacing="0" width="100%">



<tr>
<td bgcolor="#CCCCCC" width="1"><img src="images/spacer.gif" width="1" height="650"/></td>
<td bgcolor="#ffffff" width="3"><img src="images/spacer.gif" width="3" height="650"/></td>

<td valign="top">

<!-- start messages -->
<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
  
<tr><td>			
            <html:messages id="error" name="APP_ERROR_KEY" header="errors.header" footer="errors.footer">
              <bean:message key="errors.prefix"/>
              <bean:write name="error"/>
              <bean:message key="errors.suffix"/>
              </span>
            </html:messages>
            <html:messages id="msg" name="APP_INFORMATION_KEY" header="messages.header" footer="messages.footer">
              <bean:message key="messages.prefix"/>
              <bean:write name="msg"/>
              <bean:message key="messages.suffix"/>
            </html:messages>
</td></tr>    
                     
</table>
<!-- end messages -->  


<table border="0" cellpadding="0" cellspacing="0" width="60%" bgcolor="#ffffff"> 
	<tr><td class="tdwht" valign="middle">			  
		<table width="40%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
			<tr>
				<td class="tdwht">&nbsp;<html:img src="images/select_top_arrow_12_17.gif"/></td>
				<td class="tdwht">
					<div class="btnPane3">
					    <bean:message key="prompt.selectall"/>&nbsp;<html:checkbox name="ListTrackForm" property="searchString15" />
						<button class="btn btnFF" type="submit" name="emailAttachmentsButton">
        					<img class=" IM Z-IM" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
			        		<span>Email</span>
				       	</button>                           
				 	</div>
				</td>
			</tr>
		</table>
	</td></tr>
</table>


   
<!-- documents information --> 
<table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
	<tr>
    	<td class="column-header3" width="1%" nowrap>&nbsp;</td>
		<td class="column-header3" width="1%" nowrap>&nbsp;</td>

		<td class="column-header1" width="8%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListTrack.do?orderBy=Docid&gotoPage=0'">
										<span><bean:message key="heading.docid"/></span>                        
										<logic:notEqual name="ListTrackForm" property="orderBy" scope="session" value="Docid">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListTrackForm" property="orderBy" scope="session" value="Docid">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>        
   
		<td class="column-header2" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListTrack.do?orderBy=Doctype&gotoPage=0'">
										<span><bean:message key="heading.doctype"/></span>                        
										<logic:notEqual name="ListTrackForm" property="orderBy" scope="session" value="Doctype">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListTrackForm" property="orderBy" scope="session" value="Doctype">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>   
        
        
		<td class="column-header2" width="25%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListTrack.do?orderBy=Description&gotoPage=0'">
										<span><bean:message key="heading.documentdescription"/></span>                        
										<logic:notEqual name="ListTrackForm" property="orderBy" scope="session" value="Description">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListTrackForm" property="orderBy" scope="session" value="Description">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>               
		<td class="column-header2" width="5%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListTrack.do?orderBy=Versionno&gotoPage=0'">
										<span><bean:message key="heading.curver"/></span>                        
										<logic:notEqual name="ListTrackForm" property="orderBy" scope="session" value="Versionno">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListTrackForm" property="orderBy" scope="session" value="Versionno">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>           
		<td class="column-header2" width="8%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListTrack.do?orderBy=Companykey&gotoPage=0'">
										<span><bean:message key="heading.compid"/></span>                        
										<logic:notEqual name="ListTrackForm" property="orderBy" scope="session" value="Companykey">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListTrackForm" property="orderBy" scope="session" value="Companykey">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>        
		<td class="column-header2" width="12%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListTrack.do?orderBy=Createdate&gotoPage=0'">
										<span><bean:message key="heading.createtime"/></span>                        
										<logic:notEqual name="ListTrackForm" property="orderBy" scope="session" value="Createdate">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListTrackForm" property="orderBy" scope="session" value="Createdate">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>        
		<td class="column-header2" width="10%">              
                    				<button id="sortButton" class="column-header-btn1" type="button" onClick="document.location.href='ListTrack.do?orderBy=Createuserid&gotoPage=0'">
										<span><bean:message key="heading.createuser"/></span>                        
										<logic:notEqual name="ListTrackForm" property="orderBy" scope="session" value="Createuserid">              
									         <img class=" IM2 Spacer-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:notEqual>
										<logic:equal name="ListTrackForm" property="orderBy" scope="session" value="Createuserid">              
									         <img class=" IM2 Sortdown-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />       
										</logic:equal>
							        </button>
		</td>         
    	<td class="column-header3" width="23%" nowrap>&nbsp;</td>	
	</tr>  

  



<logic:notEmpty name="ListTrackForm" property="lineItems">

<%int row=0;%>

<logic:iterate 
		id="xdocumentLineItem" 
		name="ListTrackForm" 
    	property="lineItems"
    	type="com.bureaueye.beacondms.model.dms.Xdocument"
    	>

<%String _class = "column-cell1";if ((row % 2) == 0) _class = "column-cell2";row++;%>
              
<!-- row1 -->
		<tr>
			<td class="<%= _class %>" align="left" nowrap="nowrap">				  
				<html:multibox property="selectedObjects"><bean:write name="xdocumentLineItem" property="xdocumentId" /></html:multibox>
			</td>	
			<td class="<%= _class %>">
				<img src="images/icon_expand_12_12.png" width="12" height="12" align="middle" id="but_<c:out value="${xdocumentLineItem.xdocumentId}"/>" onclick="showHideDetails('div_<c:out value="${xdocumentLineItem.xdocumentId}"/>','but_<c:out value="${xdocumentLineItem.xdocumentId}"/>');"/>                    				
            </td>
			<td class="<%= _class %>" nowrap>
<logic:equal name="xdocumentLineItem" property="createaction" value="STORE">                                    
<img class=" IM2 Storedocument-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
</logic:equal>
<logic:notEqual name="xdocumentLineItem" property="createaction" value="STORE">                                    
<img class=" IM2 Generatedocument-IM2" title="" src="images/buttons/clear1x1.gif" alt="" style="border-width:0px;" />
</logic:notEqual>              
				<bean:write name="xdocumentLineItem" property="docid" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
				<bean:write name="xdocumentLineItem" property="doctype" filter="true"/>
			</td>
            <td class="<%= _class %>">
				<bean:write name="xdocumentLineItem" property="description" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
				<bean:write name="xdocumentLineItem" property="versionno" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
				<bean:write name="xdocumentLineItem" property="companykey" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
				<bean:write name="xdocumentLineItem" property="createdate" format="dd-MMM-yyyy" filter="true"/>&nbsp;<bean:write name="xdocumentLineItem" property="createtime" filter="true"/>
			</td>
			<td class="<%= _class %>" nowrap>
				<bean:write name="xdocumentLineItem" property="createuserid" filter="true"/>
			</td>
			<td class="<%= _class %>" align="right"> 
               
<html:link action="/EditTrack.do?action=View" paramId="xdocumentId" paramName="xdocumentLineItem" paramProperty="xdocumentId"><bean:message key="prompt.viewdetails"/></html:link>   
&nbsp;&nbsp;|&nbsp;&nbsp;
<html:link action="/DisplayDocument.do" paramId="xdocumentId" paramName="xdocumentLineItem" paramProperty="xdocumentId"><bean:message key="prompt.viewdocument"/></html:link>  
																																										
			</td>
		</tr>	
													

	


<!-- GENERATED DOCUMENT - EXTRA INFORMATION -->
<logic:equal name="xdocumentLineItem" property="createaction" value="GENERATE">

			<tr>
            <td colspan="10">						
            <!-- row2 -->
				<div id='div_<c:out value="${xdocumentLineItem.xdocumentId}"/>' style='position:absolute; z-index:30; visibility: hidden; border: 1px solid #6683BA;'>
					<table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
          				<tr>
				            <td class="column-header1" width="15%" nowrap>
	                            <bean:message key="heading.userid"/> 
                            </td>
    				        <td class="column-header2" width="40%" nowrap>
                            	User Location 
                            </td>
				            <td class="column-header2" width="15%" nowrap>
                            	To Attn 
                            </td>
            				<td class="column-header2" width="15%" nowrap>
                            	CC To Attn 
                            </td>              
            				<td class="column-header2" width="15%" nowrap>
                            	User Email 
                            </td>             
						</tr>	
 
      
<logic:notEqual name="xdocumentLineItem" property="xmldocument" value="">      
						<!--init xml document-->
						<x:parse var="document" xml="${xdocumentLineItem.xmldocument}"/>
		
						<tr>
				            <td class="<%= _class %>" align="left" nowrap>
								<x:out select="$document//ParamDetails/UserId"/>         
							</td>
              				<td class="<%= _class %>" align="left" nowrap>
								<x:out select="$document//ParamDetails/UserLocation/name"/>
              				</td>
              				<td class="<%= _class %>" align="left" nowrap>
								<x:out select="$document//ParamDetails/ToAttn"/>
              				</td>
              				<td class="<%= _class %>" align="left" nowrap>
								<x:out select="$document//ParamDetails/CCToAttn"/>            
							</td>
              				<td class="<%= _class %>" align="left" nowrap>
								<x:out select="$document//ParamDetails/UserEmail"/>            
							</td>
            			</tr>  
</logic:notEqual>
                        
					</table>
				</div>
			</td>
			</tr>


<script language="JavaScript">
<!--	
MM_showHideLayers('div_<c:out value="${xdocumentLineItem.xdocumentId}"/>','','hide');
-->
</script>		

</logic:equal>



<!-- STORED DOCUMENT - EXTRA INFORMATION -->
<logic:equal name="xdocumentLineItem" property="createaction" value="STORE">

<tr><td colspan="10">						
            <!-- row3 -->
			<div id='div_<c:out value="${xdocumentLineItem.xdocumentId}"/>' style='position:absolute; z-index:40; visibility: hidden; border: 1px solid #6683BA;'>
	  <table width="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
          <tr>
            <td class="column-header1" width="10%" nowrap>
<bean:message key="heading.categorycode"/>
            </td>
            <td class="column-header2" width="90%" nowrap>
<bean:message key="heading.additionalnotes"/>
            </td>             
          </tr>	
 		
          <tr>
              <td class="<%= _class %>" align="left" nowrap>
<bean:write name="xdocumentLineItem" property="categorycode" filter="true"/>       
			  </td>
              <td class="<%= _class %>" align="left">
<bean:write name="xdocumentLineItem" property="txt1" filter="true"/>
              </td>
            </tr>  
</table>
			</div>
</td></tr>


<script language="JavaScript">
<!--	
MM_showHideLayers('div_<c:out value="${xdocumentLineItem.xdocumentId}"/>','','hide');
-->
</script>		


</logic:equal>


                    			  
</logic:iterate>
               
</logic:notEmpty>                
                
</table>                
<!-- documents information -->






  
  </td>
  </tr>
  
  
  
</table>


</div>



