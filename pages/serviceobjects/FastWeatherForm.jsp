<html>
  <head>
    <title> 
      Service Objects DOTS Fast Weather
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
  <body bgcolor="white">
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
        <td class="header" style="background-color: #E0E7EF;">
          &nbsp;
        </td>
        <td class="header" style="background-color: #E0E7EF;">
          Lookup Weather
        </td>
      </tr>
    </table>
    <table border="0" width="100%" cellspacing="0" cellpadding="4" style="border: 1px solid black;">
      <FORM action ="FastWeather.jsp" method=POST>	
        <tr class="row2">
          <td class="data" align="right">
            Zip
          </td>
          <td>
            <input type="text" name="iZip" size="35" maxlength="30">
          </td>
        </tr>
        <tr class="row1">
          <td class="data" align="right" width="10%">
            License Key 				
          </td>
          <td>
            <input type="text" name="iKey" value="" size="35">
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <br>
          </td>
        </tr>
        <tr >
          <td style="border: 1px solid black;" colspan="2" width="100%">	
            <input type="SUBMIT" VALUE="Lookup" style="margin-right:10px;margin-left:20px;">
            <input type ="RESET" VALUE="Start Over">
          </td>
        </tr>
      </form>
    </table>
    <br />
    <br />
    <br />
    &copy2004 ServiceObjects, Inc.
  </body>
</html>

