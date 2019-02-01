<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags/app"    prefix="app" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<app:checkLogon/>


<html:html>

<html xmlns:v="urn:schemas-microsoft-com:vml"
xmlns:o="urn:schemas-microsoft-com:office:office"
xmlns:w="urn:schemas-microsoft-com:office:word"
xmlns="http://www.w3.org/TR/REC-html40">

<head>
<title>General Help</title>

<link rel="stylesheet" type="text/css" href="css/base.css" />


<meta http-equiv=Content-Type content="text/html; charset=windows-1252">
<meta name=ProgId content=Word.Document>
<meta name=Generator content="Microsoft Word 9">
<meta name=Originator content="Microsoft Word 9">
<link rel=File-List href="images/generalhelp/filelist.xml">
<link rel=Edit-Time-Data href="images/generalhelp/editdata.mso">
<link rel=OLE-Object-Data href="images/generalhelp/oledata.mso">
<!--[if !mso]>
<style>
v\:* {behavior:url(#default#VML);}
o\:* {behavior:url(#default#VML);}
w\:* {behavior:url(#default#VML);}
.shape {behavior:url(#default#VML);}
</style>
<![endif]-->
<title>General Help</title>
<!--[if gte mso 9]><xml>
 <o:DocumentProperties>
  <o:Author> </o:Author>
  <o:LastAuthor> </o:LastAuthor>
  <o:Revision>1</o:Revision>
  <o:TotalTime>2</o:TotalTime>
  <o:Created>2006-12-10T09:11:00Z</o:Created>
  <o:LastSaved>2006-12-10T09:13:00Z</o:LastSaved>
  <o:Pages>17</o:Pages>
  <o:Words>722</o:Words>
  <o:Characters>4118</o:Characters>
  <o:Company> </o:Company>
  <o:Lines>34</o:Lines>
  <o:Paragraphs>8</o:Paragraphs>
  <o:CharactersWithSpaces>5057</o:CharactersWithSpaces>
  <o:Version>9.3821</o:Version>
 </o:DocumentProperties>
</xml><![endif]-->
<style>
<!--
 /* Style Definitions */
p.MsoNormal, li.MsoNormal, div.MsoNormal
	{mso-style-parent:"";
	margin:0cm;
	margin-bottom:.0001pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
h1
	{mso-style-next:Normal;
	margin-top:12.0pt;
	margin-right:0cm;
	margin-bottom:3.0pt;
	margin-left:0cm;
	mso-pagination:widow-orphan;
	page-break-after:avoid;
	mso-outline-level:1;
	font-size:16.0pt;
	font-family:Arial;
	mso-font-kerning:16.0pt;}
h2
	{mso-style-next:Normal;
	margin-top:12.0pt;
	margin-right:0cm;
	margin-bottom:3.0pt;
	margin-left:0cm;
	mso-pagination:widow-orphan;
	page-break-after:avoid;
	mso-outline-level:2;
	font-size:14.0pt;
	font-family:Arial;
	font-style:italic;}
h3
	{mso-style-next:Normal;
	margin-top:12.0pt;
	margin-right:0cm;
	margin-bottom:3.0pt;
	margin-left:0cm;
	mso-pagination:widow-orphan;
	page-break-after:avoid;
	mso-outline-level:3;
	font-size:13.0pt;
	font-family:Arial;}
h4
	{mso-style-next:Normal;
	margin:0cm;
	margin-bottom:.0001pt;
	text-align:right;
	mso-pagination:widow-orphan;
	page-break-after:avoid;
	mso-outline-level:4;
	font-size:16.0pt;
	mso-bidi-font-size:12.0pt;
	font-family:Arial;
	mso-font-kerning:12.0pt;}
@page Section1
	{size:595.3pt 841.9pt;
	margin:72.0pt 90.0pt 72.0pt 90.0pt;
	mso-header-margin:35.4pt;
	mso-footer-margin:35.4pt;
	mso-paper-source:0;}
div.Section1
	{page:Section1;}
div.MsoNormal1 {mso-style-parent:"";
	margin:0cm;
	margin-bottom:.0001pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
li.MsoNormal1 {mso-style-parent:"";
	margin:0cm;
	margin-bottom:.0001pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
p.MsoNormal1 {mso-style-parent:"";
	margin:0cm;
	margin-bottom:.0001pt;
	mso-pagination:widow-orphan;
	font-size:12.0pt;
	font-family:"Times New Roman";
	mso-fareast-font-family:"Times New Roman";}
-->
</style>
<!--[if gte mso 9]><xml>
 <o:shapedefaults v:ext="edit" spidmax="1039"/>
</xml><![endif]--><!--[if gte mso 9]><xml>
 <o:shapelayout v:ext="edit">
  <o:idmap v:ext="edit" data="1"/>
 </o:shapelayout></xml><![endif]-->
</head>



<body>  

<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td colspan="2">
<jsp:include page="/pages/headerHelp.jsp" flush="true" />	</td>
</tr>


<!-- BREADCRUMBS -----------------> 
<tr>
<%--      <td height="20" bgcolor="#CCCCCC">&nbsp;</td>--%>  
	<td class="tdwht">
		<span class="heading2">    
			<strong>	
				<bean:message key="heading.beacon.help"/>	
			</strong>		</span>	</td> 
</tr>  
<tr valign="top" bgcolor="#CCCCCC">
	<td height="1" colspan="2"></td>
</tr>


<tr>
	<td bgcolor="#CCCCCC" width="121" valign="top" align="center">
<jsp:include page="/pages/sidebarHelp.jsp" flush="true" />
	</td>

	
	<td>
	<div>
      <!-- BODY GOES HERE ----------------->
      <table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
        <tr>
          <td class="tdwht"><logic:present name="user">
              <table border="0" cellpadding="5" cellspacing="5" width="100%" bgcolor="#ffffff">
                <tr>
                  <td><div class=Section1>
                      <h1 align=right style='text-align:right'>General Help</h1>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><strong><span style='mso-bidi-font-size:
5.5pt;font-family:Arial;color:black'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></strong></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>The
                      BEACON system </span><span style='mso-bidi-font-size:5.5pt;font-family:Arial;
color:black'>is a Web based solution that </span><span style='font-family:Arial'>enables
                        the integration of day-to-day operational needs with financial objectives,
                        facilitating full control of your business.
                        <o:p></o:p>
                      </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>This
                      chapter explains general concepts that apply to the entire system.<span
style="mso-spacerun: yes">  </span>Please read it carefully, as the subjects
                      covered here affect all functions within the BEACON package.
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <h2 style='text-align:justify'><a name="_Toc153262106">Common User Interface</a></h2>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>All
                      modules within BEACON adhere to a common standard of screen design, option
                      links, function buttons and menu layout.
                          <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>Typically,
                      when selecting a function from a menu, you will be presented with a list of
                      records currently on file (Selection screens).<span style="mso-spacerun: yes">  </span>You will then proceed to work with these records by pressing option
                      links or selecting menu functions to perform other activities.
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <h3 style='text-align:justify'><a name="_Toc153262107">Menu Layout</a></h3>
                    <p class=MsoNormal1 style='text-align:justify'>
                      <!--[if gte vml 1]><v:shapetype
 id="_x0000_t75" coordsize="21600,21600" o:spt="75" o:preferrelative="t"
 path="m@4@5l@4@11@9@11@9@5xe" filled="f" stroked="f">
 <v:stroke joinstyle="miter"/>
 <v:formulas>
  <v:f eqn="if lineDrawn pixelLineWidth 0"/>
  <v:f eqn="sum @0 1 0"/>
  <v:f eqn="sum 0 0 @1"/>
  <v:f eqn="prod @2 1 2"/>
  <v:f eqn="prod @3 21600 pixelWidth"/>
  <v:f eqn="prod @3 21600 pixelHeight"/>
  <v:f eqn="sum @0 0 1"/>
  <v:f eqn="prod @6 1 2"/>
  <v:f eqn="prod @7 21600 pixelWidth"/>
  <v:f eqn="sum @8 21600 0"/>
  <v:f eqn="prod @7 21600 pixelHeight"/>
  <v:f eqn="sum @10 21600 0"/>
 </v:formulas>
 <v:path o:extrusionok="f" gradientshapeok="t" o:connecttype="rect"/>
 <o:lock v:ext="edit" aspectratio="t"/>
</v:shapetype><v:shape id="_x0000_s1030" type="#_x0000_t75" style='position:absolute;
 left:0;text-align:left;margin-left:0;margin-top:9pt;width:73.75pt;height:185.15pt;
 z-index:5' strokeweight=".5pt">
 <v:imagedata src="images/generalhelp/image001.png" o:title=""/>
</v:shape><v:shape id="_x0000_s1031" type="#_x0000_t75" style='position:absolute;
 left:0;text-align:left;margin-left:324pt;margin-top:9pt;width:75.95pt;
 height:189pt;z-index:6'>
 <v:imagedata src="images/generalhelp/image002.png" o:title=""/>
</v:shape><![endif]-->
                      <![if !vml]>
                    <span style='mso-ignore:vglayout'>
                      <table cellpadding=0 cellspacing=0 align=left>
                        <tr>
                          <td width=0 height=12></td>
                          <td width=98></td>
                          <td width=334></td>
                          <td width=101></td>
                        </tr>
                        <tr>
                          <td height=247></td>
                          <td align=left valign=top><img width=98 height=247
  src="images/generalhelp/image003.gif" v:shapes="_x0000_s1030"></td>
                          <td></td>
                          <td rowspan=2 align=left valign=top><img width=101 height=252
  src="images/generalhelp/image004.gif" v:shapes="_x0000_s1031"></td>
                        </tr>
                        <tr>
                          <td height=5></td>
                        </tr>
                      </table>
                        </span>
                    <![endif]>
                    <span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                      </span>
                    <p></p>
                    <table border=0 cellspacing=0 cellpadding=0 style='border-collapse:collapse;
 mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>
                        <tr>
                          <td width=127 valign=top style='width:95.4pt;padding:0cm 5.4pt 0cm 5.4pt'><p class=MsoNormal1 style='text-align:justify'>
                            <![if !supportEmptyParas]>
                            &nbsp;
                            <![endif]>
                            <span
  style='font-family:Arial'>
                              <o:p></o:p>
                            </span></p></td>
                          <td width=288 valign=top style='width:216.0pt;padding:0cm 5.4pt 0cm 5.4pt'><br
  style='mso-ignore:vglayout' clear=ALL>
                              <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>This
                                is the standard Menu layout used to access the BEACON Modules and Maintenance
                                functions.<span style="mso-spacerun: yes">  </span>The Menu is System-defined
                                so that system administrators can grant/deny access to any of the Menu
                                options.
                                <o:p></o:p>
                              </span></p></td>
                        </tr>
                      </table>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <h3 style='text-align:justify'><a name="_Toc153262108">Option Links</a></h3>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>This
                      is the standard panel included in the Selection screens.<span
style="mso-spacerun: yes">  </span>Any variations from this panel will be
                      described in the relevant section of this manual.
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'>
                      <!--[if gte vml 1]><v:shape id="_x0000_s1026"
 type="#_x0000_t75" style='position:absolute;left:0;text-align:left;
 margin-left:0;margin-top:5.05pt;width:1in;height:31.1pt;z-index:1;
 visibility:visible;mso-wrap-edited:f' fillcolor="black" strokeweight=".5pt">
 <v:imagedata src="images/generalhelp/image005.wmz" o:title=""/>
 <v:textbox style='mso-next-textbox:#_x0000_s1026'/>
</v:shape><![if gte mso 9]><o:OLEObject Type="Embed" ProgID="Word.Picture.8"
 ShapeID="_x0000_s1026" DrawAspect="Content" ObjectID="_1227250754">
</o:OLEObject>
<![endif]><![endif]-->
                      <![if !vml]>
                    <span style='mso-ignore:vglayout'>
                      <table cellpadding=0 cellspacing=0 align=left>
                        <tr>
                          <td width=0 height=7></td>
                        </tr>
                        <tr>
                          <td></td>
                          <td><img width=96 height=41 src="images/generalhelp/image006.gif" v:shapes="_x0000_s1026"></td>
                        </tr>
                      </table>
                        </span>
                    <![endif]>
                    <span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                      </span>
                    <p></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <br style='mso-ignore:vglayout' clear=ALL>
                      <p class=MsoNormal1 style='text-align:justify'><b><span style='font-family:Arial'>Add
                        a Record link</span></b><span style='font-family:Arial'> – Pressing this link
                          allows you to enter new details into the system.<span style="mso-spacerun:
yes">  </span>For example, if you start working through a new port, you would
                          need to enter their location details onto the Location table.
                          <o:p></o:p>
                        </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><b><span style='font-family:Arial'>Delete
                      link</span></b><span style='font-family:Arial'> – This allows you to remove
                        records that you know are no longer required in the system.<span
style="mso-spacerun: yes">  </span>When the Delete link is clicked the user
                        will be asked to confirm the Delete decision.<span style="mso-spacerun: yes">  </span>
                        <o:p></o:p>
                      </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><b><span style='font-family:Arial'>Edit
                      link</span></b><span style='font-family:Arial'> – This link is used to edit
                        details that you have previously entered.<span style="mso-spacerun: yes">  </span>For example, if the email address of the customer contact changes, then
                        you would need to adjust the contact record relating to this customer to show
                        this change.
                        <o:p></o:p>
                      </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><b><span style='font-family:Arial'>Copy
                      link</span></b><span style='font-family:Arial'> – Used if you wish to create a
                        new record, but are aware that these new details are similar to a record you
                        already have in the system.<span style="mso-spacerun: yes">  </span>For
                        example, if a customer has two departments in the same location, simply copy
                        the first entry and make the small changes necessary to this.
                        <o:p></o:p>
                      </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'><span
style="mso-spacerun: yes"> </span>
                          <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <h3 style='text-align:justify'><a name="_Toc153262109">Function Buttons</a></h3>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>These
                      are the standard buttons that are part of most of the Maintenance screens.<span
style="mso-spacerun: yes">  </span>Any variations from the standard will be
                      described in the relevant section.
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'>
                      <!--[if gte vml 1]><v:shape id="_x0000_s1027"
 type="#_x0000_t75" style='position:absolute;left:0;text-align:left;
 margin-left:0;margin-top:10.25pt;width:99pt;height:14.65pt;z-index:2'
 stroked="t" strokeweight=".5pt">
 <v:imagedata src="images/generalhelp/image007.png" o:title=""/>
</v:shape><![endif]-->
                      <![if !vml]>
                      <span style='mso-ignore:vglayout;position:
relative;z-index:3;left:-2px;top:12px;width:135px;height:34px'><img width=135
height=22 src="images/generalhelp/image008.gif" v:shapes="_x0000_s1027"></span>
                      <![endif]>
                      <span
style='font-family:Arial'>
                        <![if !supportEmptyParas]>
                        &nbsp;
                        <![endif]>
                        <o:p></o:p>
                      </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <br style='mso-ignore:vglayout' clear=ALL>
                      <p class=MsoNormal1 style='text-align:justify'><b><span style='font-family:Arial'>Save
                        button</span></b><span style='font-family:Arial'> – This function will write
                          the details entered on the screen to the BEACON database.<span
style="mso-spacerun: yes">  </span>Any fields that have been changed will be
                          updated to the database.
                          <o:p></o:p>
                        </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><b><span style='font-family:Arial'>Reset
                      button</span></b><span style='font-family:Arial'> – This function will remove
                        any field changes that have not been saved and the fields will be reset to the
                        initial state.
                        <o:p></o:p>
                      </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><b><span style='font-family:Arial'>Cancel
                      button</span></b><span style='font-family:Arial'> – This will allow you to
                        leave the current screen.<span style="mso-spacerun: yes">  </span>Any changes
                        you have made will not be saved to the BEACON database.
                        <o:p></o:p>
                      </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'>
                      <!--[if gte vml 1]><v:shape id="_x0000_s1032"
 type="#_x0000_t75" style='position:absolute;left:0;text-align:left;
 margin-left:97pt;margin-top:9.5pt;width:20pt;height:15.85pt;z-index:7'>
 <v:imagedata src="images/generalhelp/image009.png" o:title=""/>
</v:shape><![endif]-->
                      <![if !vml]>
                    <span style='mso-ignore:vglayout'>
                      <table cellpadding=0 cellspacing=0 align=left>
                        <tr>
                          <td width=129 height=13></td>
                        </tr>
                        <tr>
                          <td></td>
                          <td><img width=27 height=21 src="images/generalhelp/image010.gif" v:shapes="_x0000_s1032"></td>
                        </tr>
                      </table>
                        </span>
                    <![endif]>
                    <span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                      </span>
                    <p></p>
                    <br style='mso-ignore:vglayout' clear=ALL>
                      <p class=MsoNormal1 style='text-align:justify'><b><span style='font-family:Arial'>Retrieve
                        button<span style="mso-spacerun: yes">       </span></span></b><span
style='font-family:Arial'><span style="mso-spacerun: yes"> </span></span><span
style="mso-spacerun: yes"> </span><span style='font-family:Arial'>– The
                          retrieve button is present on all Selection and Search screens in the
                          system.<span style="mso-spacerun: yes">  </span>This feature allows you to
                          limit the amount of information that appears in the Results list.<span
style="mso-spacerun: yes">  </span>For example, on the address Selection
                          screen, if you only want addresses starting ABC, then type the Address name as
                          ‘ABC%’ and press the Retrieve button.
                          <o:p></o:p>
                        </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <h3 style='text-align:justify'><a name="_Toc153262110">Breadcrumb Links</a></h3>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>These
                      are standard links that help you navigate the BEACON system.<span
style="mso-spacerun: yes">  </span>They can be found to the immediate right of
                      the screens title.<span style="mso-spacerun: yes">  </span>They will help you
                      navigate back to Home, previous screens, result lists etc.
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'>
                      <!--[if gte vml 1]><v:shape id="_x0000_s1028"
 type="#_x0000_t75" style='position:absolute;left:0;text-align:left;
 margin-left:0;margin-top:12.75pt;width:297pt;height:15.7pt;z-index:3'
 stroked="t" strokeweight=".5pt">
 <v:imagedata src="images/generalhelp/image011.png" o:title=""/>
</v:shape><![endif]-->
                      <![if !vml]>
                      <span style='mso-ignore:vglayout;position:
relative;z-index:5;left:-2px;top:15px;width:399px;height:39px'><img width=399
height=24 src="images/generalhelp/image012.gif" v:shapes="_x0000_s1028"></span>
                      <![endif]>
                      <span
style='font-family:Arial'>
                        <![if !supportEmptyParas]>
                        &nbsp;
                        <![endif]>
                        <o:p></o:p>
                      </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <h2 style='text-align:justify'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </h2>
                    <p class=MsoNormal1>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </p>
                    <br style='mso-ignore:vglayout' clear=ALL>
                      <h2><a name="_Toc153262111">Standard Field Types</a></h2>
                    <p class=MsoNormal1>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </p>
                    <h3><a name="_Toc153262112">CheckBox</a></h3>
                    <p class=MsoNormal1>
                      <!--[if gte vml 1]><v:shape id="_x0000_s1035" type="#_x0000_t75"
 style='position:absolute;margin-left:0;margin-top:.9pt;width:27pt;height:11pt;
 z-index:10'>
 <v:imagedata src="images/generalhelp/image013.png" o:title=""/>
</v:shape><![endif]-->
                      <![if !vml]>
                    <span style='mso-ignore:vglayout'>
                      <table cellpadding=0 cellspacing=0 align=left>
                        <tr>
                          <td width=0 height=1></td>
                        </tr>
                        <tr>
                          <td></td>
                          <td><img width=36 height=15 src="images/generalhelp/image014.gif" v:shapes="_x0000_s1035"></td>
                        </tr>
                      </table>
                        </span>
                    <![endif]>
                    <![if !supportEmptyParas]>
                    &nbsp;
                    <![endif]>
                    <o:p></o:p>
                    <p></p>
                    <br style='mso-ignore:vglayout' clear=ALL>
                      <p class=MsoNormal1><span style='font-family:Arial'>A check box is a square box
                        that can be selected or deselected. When it is selected, a check mark appears
                        in the box.
                            <o:p></o:p>
                      </span></p>
                    <h3>
                      <!--[if gte vml 1]><v:shape id="_x0000_s1034" type="#_x0000_t75" style='position:absolute;
 margin-left:0;margin-top:27.3pt;width:81pt;height:15.25pt;z-index:9'>
 <v:imagedata src="images/generalhelp/image015.png" o:title=""/>
</v:shape><![endif]-->
                      <![if !vml]>
                      <span style='mso-ignore:vglayout;position:
absolute;z-index:7;margin-left:0px;margin-top:36px;width:108px;height:21px'><img
width=108 height=21 src="images/generalhelp/image016.gif" v:shapes="_x0000_s1034"></span>
                      <![endif]>
                      <a
name="_Toc153262113">ComboBox</a></h3>
                    <p class=MsoNormal1>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </p>
                    <p class=MsoNormal1><span style='font-family:Arial'>A combo box allows a user to
                      make a single selection from a pull-down list.
                      <o:p></o:p>
                    </span></p>
                    <h3>
                      <!--[if gte vml 1]><v:shape id="_x0000_s1033" type="#_x0000_t75" style='position:absolute;
 margin-left:0;margin-top:28.55pt;width:126pt;height:14.05pt;z-index:8'>
 <v:imagedata src="images/generalhelp/image017.png" o:title=""/>
</v:shape><![endif]-->
                      <![if !vml]>
                      <span style='mso-ignore:vglayout;position:
absolute;z-index:8;margin-left:0px;margin-top:38px;width:168px;height:19px'><img
width=168 height=19 src="images/generalhelp/image018.gif" v:shapes="_x0000_s1033"></span>
                      <![endif]>
                      <a
name="_Toc153262114">RadioButton</a></h3>
                    <p class=MsoNormal1>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </p>
                    <p class=MsoNormal1><span style='font-family:Arial'>The RadioButton component
                      lets a user to make a single choice within a set of choices.
                      <o:p></o:p>
                    </span></p>
                    <h3>
                      <!--[if gte vml 1]><v:shape id="_x0000_s1038" type="#_x0000_t75" style='position:absolute;
 margin-left:2pt;margin-top:27.45pt;width:16pt;height:17pt;z-index:13'>
 <v:imagedata src="images/generalhelp/image019.png" o:title=""/>
</v:shape><![endif]-->
                      <![if !vml]>
                      <span style='mso-ignore:vglayout;position:
absolute;z-index:9;margin-left:3px;margin-top:37px;width:21px;height:22px'><img
width=21 height=22 src="images/generalhelp/image020.gif" v:shapes="_x0000_s1038"></span>
                      <![endif]>
                      <a
name="_Toc153262115">Magnifying Glass</a></h3>
                    <p class=MsoNormal1><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1><span style='font-family:Arial'>The Magnifying Glass gives
                      you the option to make an advanced Popup search.
                          <o:p></o:p>
                    </span></p>
                    <h3>
                      <!--[if gte vml 1]><v:shape id="_x0000_s1037" type="#_x0000_t75" style='position:absolute;
 margin-left:2pt;margin-top:28.1pt;width:16pt;height:17pt;z-index:12'>
 <v:imagedata src="images/generalhelp/image021.png" o:title=""/>
</v:shape><![endif]-->
                      <![if !vml]>
                      <span style='mso-ignore:vglayout;position:
absolute;z-index:10;margin-left:3px;margin-top:37px;width:21px;height:23px'><img
width=21 height=23 src="images/generalhelp/image022.gif" v:shapes="_x0000_s1037"></span>
                      <![endif]>
                      <a
name="_Toc153262116">Report</a></h3>
                    <p class=MsoNormal1><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1><span style='font-family:Arial'>The Report icon gives you
                      the option to run the Beacon Reports.
                          <o:p></o:p>
                    </span></p>
                    <h3>
                      <!--[if gte vml 1]><v:shape id="_x0000_s1036" type="#_x0000_t75" style='position:absolute;
 margin-left:.95pt;margin-top:24.55pt;width:17.05pt;height:18pt;z-index:11'>
 <v:imagedata src="images/generalhelp/image023.png" o:title=""/>
</v:shape><![endif]-->
                      <![if !vml]>
                      <span style='mso-ignore:vglayout;position:
absolute;z-index:11;margin-left:1px;margin-top:33px;width:23px;height:24px'><img
width=23 height=24 src="images/generalhelp/image024.gif" v:shapes="_x0000_s1036"></span>
                      <![endif]>
                      <a
name="_Toc153262117">Notes lookup</a></h3>
                    <p class=MsoNormal1><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1><span style='font-family:Arial'>The Post-it note icon allows
                      you to hover over the image to see any notes for a specific record.
                          <o:p></o:p>
                    </span></p>
                    <h2 style='text-align:justify'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </h2>
                    <b><i><span style='font-size:14.0pt;font-family:Arial;mso-fareast-font-family:
"Times New Roman";mso-ansi-language:EN-GB;mso-fareast-language:EN-US;
mso-bidi-language:AR-SA'><br clear=all style='page-break-before:always'>
                      </span></i></b>
                      <h2 style='text-align:justify'><a name="_Toc153262118">Popup Search Functions</a></h2>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>BEACON
                      makes extensive use of codes; for example, customer and vendor account codes,
                      cost codes, charge codes and tariff codes.<span style="mso-spacerun: yes">  </span>BEACON provides easy Popup search windows to help locate these codes and
                      attach them to Quotations and Orders.
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'>
                      <!--[if gte vml 1]><v:shape id="_x0000_s1029"
 type="#_x0000_t75" style='position:absolute;left:0;text-align:left;
 margin-left:0;margin-top:9.7pt;width:180pt;height:12.45pt;z-index:4'
 stroked="t" strokeweight=".5pt">
 <v:imagedata src="images/generalhelp/image025.png" o:title=""/>
</v:shape><![endif]-->
                      <![if !vml]>
                      <span style='mso-ignore:vglayout;position:
relative;z-index:12;left:-2px;top:11px;width:243px;height:31px'><img width=243
height=20 src="images/generalhelp/image026.gif" v:shapes="_x0000_s1029"></span>
                      <![endif]>
                      <span
style='font-family:Arial'>
                        <![if !supportEmptyParas]>
                        &nbsp;
                        <![endif]>
                        <o:p></o:p>
                      </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <br style='mso-ignore:vglayout' clear=ALL>
                      <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>For
                        example, you can press the magnifying glass image next to the location and
                        address fields to perform a search on available records.<span
style="mso-spacerun: yes">  </span>The system will then display the following
                        popup window:
                        <o:p></o:p>
                      </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <!--[if gte vml 1]><v:shape
 id="_x0000_i1025" type="#_x0000_t75" style='width:414.75pt;height:275.25pt'>
 <v:imagedata src="images/generalhelp/image027.png" o:title=""/>
</v:shape><![endif]-->
                      <![if !vml]>
                      <img width=553 height=367
src="images/generalhelp/image028.jpg" v:shapes="_x0000_i1025">
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>Once
                      you have entered the search criteria press the Search button to display the
                      Results list.<span style="mso-spacerun: yes">  </span>For example, select
                      Barcelona in the city pull-down list and type ‘AGE%’ in the Name field to
                      display all addresses in Barcelona that begin AGE.
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <!--[if gte vml 1]><v:shape
 id="_x0000_i1026" type="#_x0000_t75" style='width:414.75pt;height:275.25pt'>
 <v:imagedata src="images/generalhelp/image029.png" o:title=""/>
</v:shape><![endif]-->
                      <![if !vml]>
                      <img width=553 height=367
src="images/generalhelp/image030.jpg" v:shapes="_x0000_i1026">
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>The
                      address you are searching for can be selected by pressing the radio button to
                      the left of the address row.<span style="mso-spacerun: yes">  </span>The
                      address name will automatically be returned to the main screen and placed in
                      the input field.<span style="mso-spacerun: yes">  </span>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1 style='text-align:justify'><span style='font-family:Arial'>If
                      the address is not displayed in the Results list then press the Back button and
                      widen your search criteria.
                          <o:p></o:p>
                    </span></p>
                    <p class=MsoNormal1>
                      <![if !supportEmptyParas]>
                      &nbsp;
                      <![endif]>
                      <o:p></o:p>
                    </p>
                  </div></td>
                </tr>
              </table>
          </logic:present>          </td>
        </tr>
      </table>
	  </div></td>
</tr>

<tr>
	<td colspan="2">
<jsp:include page="/pages/footer.jsp" flush="true" />	</td>
</tr>
</table>

</body>
</html:html>
