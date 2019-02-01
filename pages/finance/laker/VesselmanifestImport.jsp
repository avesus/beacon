<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<!--
 *
 * Amendments
 * ----------
 * 
 * NT	2013-12-08		WSI-201311-0004		BEACON LAKER (WSI LINER) - Generate Vessel Manifest Sales Invoices
 *  
-->

<!-- start taglib -->
<%@ include file="/includes/taglibs.inc.jsp"%>
<!-- end taglib -->

<!-- start datapool -->
<%@ include file="/includes/datapool.inc.jsp"%>
<!-- end datapool -->

<!-- start scripts -->
<%@ include file="/includes/scripts.inc.jsp"%>
<!-- end scripts -->


<app:checkLogon />


<html:html>


<script language="JavaScript" type="text/javascript">

function screenRefresh() 
{
}

</script>



<script type="text/javascript">
function noenter() {
  return !(window.event && window.event.keyCode == 13); }
</script>
<script language="javascript" type="text/javascript">
//<![CDATA[
	function onLoad() {	
	}
    //]]>
</script>


<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/basedms.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />


<head>
<title>Vessel Manifest Import</title>


</head>


<body onLoad="onLoad();">

	<table cellpadding="0" cellspacing="0" border="0" width="100%">

		<tr>
			<td colspan="2"><jsp:include page="/pages/header.jsp"
					flush="true" /></td>
		</tr>


		<!-- BREADCRUMBS ----------------->
		<tr bgcolor="#F1F1F1">
			<td width="70%"><span class="header2">Vessel Manifest
					Import</span></td>
			<td width="30%"><jsp:include page="/pages/system/menubar.jsp"
					flush="true" /></td>
		</tr>
		<tr valign="top" bgcolor="#CCCCCC">
			<td height="1" colspan="2"></td>
		</tr>
		<!-- BREADCRUMBS ----------------->


		<tr>
			<td colspan="2"><html:messages id="error" name="APP_ERROR_KEY"
					header="errors.header" footer="errors.footer">
					<bean:message key="errors.prefix" />
					<bean:write name="error" />
					<bean:message key="errors.suffix" />
				</html:messages> <html:messages id="msg" name="APP_INFORMATION_KEY"
					header="messages.header" footer="messages.footer">
					<bean:message key="messages.prefix" />
					<bean:write name="msg" />
					<bean:message key="messages.suffix" />
				</html:messages> <html:messages id="warning" name="APP_WARNING_KEY"
					header="warnings.header" footer="messages.footer">
					<bean:message key="warnings.prefix" />
					<bean:write name="warning" />
					<bean:message key="warnings.suffix" />
				</html:messages>

				<div
					style="OVERFLOW: auto; width: 1100px; height: 650px; position: relative;">

					<table border="0" cellpadding="0" cellspacing="2" width="100%"
						bgcolor="#ffffff">


						<html:form action="/VesselmanifestImportLaker" focus="filename"
							enctype="multipart/form-data">


							<tr>
								<td><img src="images/spacer.gif" height="5" alt="" /></td>
							</tr>


							<tr>
								<td><html:img src="images/spacer.gif" border="0" width="1"
										height="1" /></td>

								<td width="100%"></td>
							</tr>


							<tr>
								<td colspan="2"><img src="images/spacer.gif" height="10"
									alt="" /></td>
							</tr>

							<tr>

							</tr>
							<tr>
								<td class="label2">Select Import File:</td>
							</tr>
							<tr>
								<td class="label2">
									<%--         <html:text property="filename" size="50" maxlength="100" styleClass="forminput1"/>--%>

									<html:file property="infile" size="100" />
								</td>
							</tr>

							<tr>

								<td colspan="2">
									<div class="btnPane">

										<input type="hidden" name="button" id="form-action" />

										<button class='btn btnFF' type='submit' value='IMPORT'
											onClick="document.getElementById('form-action').value='IMPORT'">
											<img class=" IM CK-IM" title=""
												src="images/buttons/clear1x1.gif" alt=""
												style="border-width: 0px;" /> <span>Import</span>
										</button>

										<button id="exitButton" class="btn btnFF" type="button"
											onclick="document.location.href='MainMenu.do'">
											<img class=" IM cross-IM" title=""
												src="images/buttons/clear1x1.gif" alt=""
												style="border-width: 0px;" /> <span><bean:message
													key="button.exit" /></span>
										</button>


									</div>
								</td>
							</tr>




						</html:form>

					</table>

				</div></td>
		</tr>

		<tr>
			<td colspan="2"><jsp:include page="/pages/footer.jsp"
					flush="true" /></td>
		</tr>

	</table>

</body>
</html:html>
