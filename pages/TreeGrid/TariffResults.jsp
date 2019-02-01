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


<script src="/beacon/scripts/TreeGrid/GridE.js"> </script>
      




<div id="results" style="OVERFLOW:auto; position:absolute; left:0px; top:155px;  z-index:20;">

<table border="0" cellpadding="0" cellspacing="0" width="100%">



<tr>
<%--<td bgcolor="#ffffff" width="1"><img src="images/spacer.gif" width="1" height="650"/></td>
<td bgcolor="#ffffff" width="3"><img src="images/spacer.gif" width="3" height="650"/></td>--%>

<td valign="top">
  <table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
  
 <tr><td>			

</td></tr>
 
    <tr>
      <td><table border="0" cellpadding="0" cellspacing="0" width="100%" bgcolor="#ffffff">
          <tr>
            <td class="text2">
            </td>
          </tr>
        </table></td>
<%--      <td width="15%"><table border="0" cellpadding="2" cellspacing="2" width="100%" bgcolor="#ffffff">
          <tr>
            <td align="right">
               <img src="images/spacer.gif" width="1" height="13" border="0"/>
            </td>
          </tr>
        </table></td>--%>
    </tr>
  </table>
  <table width="100%" border="0" cellspacing="0" cellpadding="0" valign="top" bgcolor="#FFFFFF">
    <tr>
      <td>
<div id="results" style="OVERFLOW:auto; width:1700px; height:350px; position:relative;">
         <bdo Debug='1'
              Layout_Url="/beacon/pages/TreeGrid/TariffLayout.jsp" 
              Data_Url="/beacon/pages/TreeGrid/TariffData.jsp"
              Upload_Url="/beacon/pages/TreeGrid/TariffUpload.jsp" Upload_Format="Internal" Upload_Data="TGData"
              Export_Url="/beacon/pages/TreeGrid/Framework/Export.jsp" Export_Data="TGData" Export_Param_File="Tariff.xls"
              ></bdo>
</div>
		</td>
        <td bgcolor="#CCCCCC" width="1"><img src="images/spacer.gif" width="1" height="100"/></td>        
    </tr>
  </table>
  </td>
  </tr>
  </table>
</div>


<div id="hide_something" style="position:absolute; left:170px; top:485px;  background-color:#fff; z-index:40; width:200px; height:20px; ">
</div>