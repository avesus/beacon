<%@page import="java.lang.Object" %>
<%@page import="com.serviceobjects.www.DOTSFastWeatherSoap"%>
<%@page import="com.serviceobjects.www.DOTSFastWeatherLocator"%>
<%@page import="com.serviceobjects.www.Err"%>
<%@page import="com.serviceobjects.www.DOTSFastWeather" %>
<%@page import="com.serviceobjects.www.Weather" %>
<%@page import="com.serviceobjects.www.Warning" %>



<html>
  <head>
    <title> 
      Service Objects DOTS FastWeather
    </title>
    <style>
      body {
      font-family: Arial, Helvetica, Verdana, sans-serif;
      font-size: 10pt;
      margin-left: 5px;
      margin-top: 5px;
      margin-right: 5px;
      margin-bottom: 5px;
      background-color: #FFF;
      }
      TD {
      font-family: Arial;
      }
      
      .header {
      font-family: Arial;
      font-size: 14pt;
      font-weight: bold;
      }
      .data {
      font-family: Arial;
      font-size: 10pt;
      font-weight:bold;
      }
      .row1 {
      background-color:eeeeee;
      }
      .row2 {
      background-color:fffff;
      }
    </style>
  </head>
  <body>
    <table cellspacing="0" width="100%" cellpadding="4" style="margin-bottom:15px; border: 1px solid black;">
      <tr>
        <td width="1%" nowrap class="header" valign="middle">
          <a href="http://www.serviceobjects.com/"><img src="images/so_logo_2.gif" border="0"></a>
        </td>
        <td class="header">
          DOTS FastWeather
        </td>
      </tr>
    </table>
    <BR />
    <table width="100%" cellspacing="0" cellpadding="5"style="border: 1px solid black;">
      <tr>
        <td class="header" style="background-color: #E0E7EF;">&nbsp;
          
        </td>
        <td class="header" style="background-color: #E0E7EF;">
          Lookup Weather Warning
        </td>
      </tr>
    </table>
        <%
          try
          {
            
             Warning[] warning;
             String state = request.getParameter("iState");
            String key = request.getParameter("iKey");
            
            DOTSFastWeatherLocator locator = new DOTSFastWeatherLocator();
            DOTSFastWeatherSoap soap = locator.getDOTSFastWeatherSoap();
            warning = soap.getWarningsByZip(state, key);
            
            Err error = warning[0].getError();
            if(error == null){
        %>
    <table border="0" width="100%" cellspacing="0" cellpadding="4" style="border: 1px solid black;">
      <tr class="row2">
        <td class="data" align="right" width="10%">
          <b>Weather Warning</b>
        </td>
        <td>&nbsp;
          
        </td>
      </tr>
      <tr class="row1">
        <td class="data" align="right">
         Event
        </td>
        <td>
          <%out.println(warning[0].getEvent());%>
        </td>
      </tr>
      <tr class="row2">
        <td class="data" align="right">
          Urgency
        </td>
        <td>
          <%out.println(warning[0].getUrgency());%>
        </td>
      </tr>
      <tr class="row1">
        <td class="data" align="right">
          Severity
        </td>
        <td>
          <%out.println(warning[0].getSeverity());%>
        </td>
      </tr>
      <tr class="row2">
        <td class="data" align="right">
          Certainty
        </td>
        <td>
          <%out.println(warning[0].getCertainty());%>
        </td>
      </tr>
      <tr class="row1">
        <td class="data" align="right">
          Effective From
        </td>
        <td>
          <%out.println(warning[0].getEffectiveFrom());%>
        </td>
      </tr>
      <tr class="row2">
        <td class="data" align="right">
          Effective Until
        </td>
        <td>
          <%out.println(warning[0].getEffectiveUntil());%>
        </td>
      </tr>
      <tr class="row1">
        <td class="data" align="right">
          Headline
        </td>
        <td>
          <%out.println(warning[0].getHeadline());%>
        </td>
      </tr>
      <tr >
        <td style="border: 1px solid black;" colspan="2" width="100%">	
          <input type ="button" VALUE="Start Over" onClick="document.location='FastWeatherForm.jsp';">
        </td>
      </tr>
    </table>
    <%
    }
    else{
      out.println("<BR /><Font face='arial' size='3' color='red'><b>"+error.getNumber()+": "+error.getDesc()+"</b></Font><BR />");  
    }
  }
  catch(Exception ex)
  {
    out.print(ex.getMessage());
  }
    %>
    <br />
    <br />
    <br />
    &copy2004 ServiceObjects, Inc.
  </body>
</html>
