<%@page import="java.lang.Object" %>
<%@page import="com.serviceobjects.www.DOTSFastWeatherSoap"%>
<%@page import="com.serviceobjects.www.DOTSFastWeatherLocator"%>
<%@page import="com.serviceobjects.www.Err"%>
<%@page import="com.serviceobjects.www.DOTSFastWeather" %>
<%@page import="com.serviceobjects.www.Weather" %>



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
          Lookup Weather
        </td>
      </tr>
    </table>
        <%
          try
          {
            
             Weather weather;
             String zip = request.getParameter("iZip");
            String key = request.getParameter("iKey");
            
            DOTSFastWeatherLocator locator = new DOTSFastWeatherLocator();
            DOTSFastWeatherSoap soap = locator.getDOTSFastWeatherSoap();
            weather = soap.getWeatherByZip(zip, key);
            
            Err error = weather.getError();
            if(error == null){
        %>
    <table border="0" width="100%" cellspacing="0" cellpadding="4" style="border: 1px solid black;">
      <tr class="row2">
        <td class="data" align="right" width="10%">
          <b>Weather</b>
        </td>
        <td>&nbsp;
          
        </td>
      </tr>
      <tr class="row1">
        <td class="data" align="right">
          Last Updated
        </td>
        <td>
          <%out.println(weather.getLastUpdated());%>
        </td>
      </tr>
      <tr class="row2">
        <td class="data" align="right">
          Temperature (F)
        </td>
        <td>
          <%out.println(weather.getTemperatureF());%>
        </td>
      </tr>
      <tr class="row1">
        <td class="data" align="right">
          Wind Chill
        </td>
        <td>
          <%out.println(weather.getWindchill());%>
        </td>
      </tr>
      <tr class="row2">
        <td class="data" align="right">
          Heat Index
        </td>
        <td>
          <%out.println(weather.getHeatIndex());%>
        </td>
      </tr>
      <tr class="row1">
        <td class="data" align="right">
          Humidity
        </td>
        <td>
          <%out.println(weather.getHumidity());%>
        </td>
      </tr>
      <tr class="row2">
        <td class="data" align="right">
          Dewpoint
        </td>
        <td>
          <%out.println(weather.getDewpoint());%>
        </td>
      </tr>
      <tr class="row1">
        <td class="data" align="right">
          Wind
        </td>
        <td>
          <%out.println(weather.getWind());%>
        </td>
      </tr>
      <tr class="row2">
        <td class="data" align="right">
          Pressure
        </td>
        <td>
          <%out.println(weather.getPressure());%>
        </td>
      </tr>
      <tr class="row1">
        <td class="data" align="right">
          Conditions
        </td>
        <td>
          <%out.println(weather.getConditions());%>
        </td>
      </tr>
      <tr class="row2">
        <td class="data" align="right">
          Visibility
        </td>
        <td>
          <%out.println(weather.getVisibility());%>
        </td>
      </tr>
      <tr class="row1">
        <td class="data" align="right">
          Sunrise
        </td>
        <td>
          <%out.println(weather.getSunrise());%>
        </td>
      </tr>
      <tr class="row2">
        <td class="data" align="right">
          Sunset
        </td>
        <td>
          <%out.println(weather.getSunset());%>
        </td>
      </tr>
      <tr class="row1">
        <td class="data" align="right">
          City
        </td>
        <td>
          <%out.println(weather.getCity());%>
        </td>
      </tr>
      <tr class="row2">
        <td class="data" align="right">
          State
        </td>
        <td>
          <%out.println(weather.getState());%>
        </td>
      </tr>
      <tr class="row1">
        <td class="data" align="right">
          Moonrise
        </td>
        <td>
          <%out.println(weather.getMoonrise());%>
        </td>
      </tr>
      <tr class="row2">
        <td class="data" align="right">
          Moonset
        </td>
        <td>
          <%out.println(weather.getMoonset());%>
        </td>
      </tr>
      <tr class="row1">
        <td class="data" align="right">
          Precipitation
        </td>
        <td>
          <%out.println(weather.getPrecipitation());%>
        </td>
      </tr>
      <tr class="row2">
        <td class="data" align="right">
          Country
        </td>
        <td>
          <%out.println(weather.getCountry());%>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <br>
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
