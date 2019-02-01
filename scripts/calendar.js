<script language="javascript">
var dDate = new Date();
var mes = dDate.getMonth() + 1;
var dia = dDate.getDate();
var diaDeSemana = dDate.getDay();
var anyo = dDate.getFullYear();
//alert(dia+ "--" +mes+ "--" +anyo);
var objPrevElement = new Object();
var nMonth = new Array();
for(i=1;i < 13;i++) nMonth[i]=new Array();

nMonth[1][1] = "Gener";
nMonth[1][2] = "Febrer";
nMonth[1][3] = "Març";
nMonth[1][4] = "Abril";
nMonth[1][5] = "Maig";
nMonth[1][6] = "Juny";
nMonth[1][7] = "Juliol";
nMonth[1][8] = "Agost";
nMonth[1][9] = "Setembre";
nMonth[1][10] = "Octubre";
nMonth[1][11] = "Novembre";
nMonth[1][12] = "Desembre";

nMonth[2][1] = "Enero";
nMonth[2][2] = "Febrero";
nMonth[2][3] = "Marzo";
nMonth[2][4] = "Abril";
nMonth[2][5] = "Mayo";
nMonth[2][6] = "Junio";
nMonth[2][7] = "Julio";
nMonth[2][8] = "Agosto";
nMonth[2][9] = "Septiembre";
nMonth[2][10] = "Octubre";
nMonth[2][11] = "Noviembre";
nMonth[2][12] = "Diciembre";

nMonth[3][1] = "January";
nMonth[3][2] = "February";
nMonth[3][3] = "March";
nMonth[3][4] = "April";
nMonth[3][5] = "May";
nMonth[3][6] = "June";
nMonth[3][7] = "July";
nMonth[3][8] = "August";
nMonth[3][9] = "September";
nMonth[3][10] = "October";
nMonth[3][11] = "November";
nMonth[3][12] = "December";


function fToggleColor(myElement) {
var toggleColor = "#ff0000";
if (myElement.id == "calDateText") {
if (myElement.color == toggleColor) {
myElement.color = "";
} else {
myElement.color = toggleColor;
   }
} else if (myElement.id == "calCell") {
for (var i in myElement.children) {
if (myElement.children[i].id == "calDateText") {
if (myElement.children[i].color == toggleColor) {
myElement.children[i].color = "";
} else {
myElement.children[i].color = toggleColor;
            }
         }
      }
   }
}
function fSetSelectedDay(myElement){
if (myElement.id == "calCell") {
if (!isNaN(parseInt(myElement.children["calDateText"].innerText))) {
myElement.bgColor = "#c0c0c0";
objPrevElement.bgColor = "";
document.all.calSelectedDate.value = parseInt(myElement.children["calDateText"].innerText);
objPrevElement = myElement;
      }
   }
}
function fGetDaysInMonth(iMonth, iYear) {
var dPrevDate = new Date(iYear, iMonth, 0);
return dPrevDate.getDate();
}
/////////////////////
/////////////////////
/////////////////////
/////////////////////
function fBuildCal(iYear, iMonth, iDayStyle) {


var aMonth = new Array();

aMonth[0] = new Array(7);
aMonth[1] = new Array(7);
aMonth[2] = new Array(7);
aMonth[3] = new Array(7);
aMonth[4] = new Array(7);
aMonth[5] = new Array(7);
aMonth[6] = new Array(7);
var dCalDate = new Date(iYear, iMonth-1, 1);
var iDayOfFirst = dCalDate.getDay()-1;
iDayOfFirst=(iDayOfFirst==-1)?6:iDayOfFirst;

var iDaysInMonth = fGetDaysInMonth(iMonth, iYear);
var iVarDate = 1;
var i, d, w;
if (iDayStyle == 1) {
aMonth[0][6] = "Dg";
aMonth[0][0] = "Dl";
aMonth[0][1] = "Dm";
aMonth[0][2] = "Dc";
aMonth[0][3] = "Dj";
aMonth[0][4] = "Dv";
aMonth[0][5] = "Ds";
} else if (iDayStyle == 2) {
aMonth[0][6] = "Do";
aMonth[0][0] = "Lu";
aMonth[0][1] = "Ma";
aMonth[0][2] = "Mi";
aMonth[0][3] = "Ju";
aMonth[0][4] = "Vi";
aMonth[0][5] = "Sa";
} else {
aMonth[0][6] = "Su";
aMonth[0][0] = "Mo";
aMonth[0][1] = "Tu";
aMonth[0][2] = "We";
aMonth[0][3] = "Th";
aMonth[0][4] = "Fr";
aMonth[0][5] = "Sa";
}




for (d = iDayOfFirst; d < 7; d++) {
aMonth[1][d] = iVarDate;
iVarDate++;
}
for (w = 2; w < 7; w++) {
for (d = 0; d < 7; d++) {
if (iVarDate <= iDaysInMonth) {
aMonth[w][d] = iVarDate;
iVarDate++;
      }
   }
}
return aMonth;
}
///////
///////
function fDrawCal(iYear, iMonth, iCellWidth, iCellHeight, sDateTextSize, sDateTextWeight, iDayStyle) {
document.frmCalendarSample.mes.value=iMonth;
document.frmCalendarSample.anyo.value=iYear;


if(document.all) {
document.getElementById("fecha").innerHTML= "" + nMonth[3][iMonth] + " " + iYear;
}

else {

var x = "" + nMonth[3][iMonth] + " " + iYear;
}


var myMonth;

myMonth = fBuildCal(iYear, iMonth, iDayStyle);


document.write("<table border=0 cellpadding=1 cellspacing=1 summary='dies' width='100%'>")
document.write("<tr>");
document.write("<td class='textonoticiaazul2' width='14%'  align='right'>" + myMonth[0][0] + "</td>");
document.write("<td class='textonoticiaazul2' width='14%' align='right'>" + myMonth[0][1] + "</td>");
document.write("<td class='textonoticiaazul2' width='14%' align='right'>" + myMonth[0][2] + "</td>");
document.write("<td class='textonoticiaazul2' width='14%' align='right'>" + myMonth[0][3] + "</td>");
document.write("<td class='textonoticiaazul2' width='14%' align='right'>" + myMonth[0][4] + "</td>");
document.write("<td class='textonoticiaazul2' width='14%' align='right'>" + myMonth[0][5] + "</td>");
document.write("<td class='textonoticiaazul2'  align='right'>" + myMonth[0][6] + "</td>");
document.write("</tr>");


for (w = 1; w < 7; w++) {
document.write("<tr id='fila" + w + "'>" );
for (d = 0; d < 7; d++) {
if (d < 5) document.write("<td id='dia" + myMonth[w][d] + "' align='right' class='textonoticiaazul2' onclick=fSetSelectedDay(this)>");
else  document.write("<td id='dia" + myMonth[w][d] + "'  align='right' class='textonoticiaazul2bold' onclick=fSetSelectedDay(this)>");
if (!isNaN(myMonth[w][d])) { 
		if (esPosterior(myMonth[w][d],iMonth,iYear) && ''!='Llistat') document.write("<font id=calDateText ><a  href='javascript:enlaceCalendari(" + myMonth[w][d] + ");' class='textonoticiaazul2'>" + myMonth[w][d] + " </a></font>");
		else document.write("<font id=calDateText ><span class='textonoticiaazul2'>" + myMonth[w][d] + "</span></font>");;
} else {
document.write("<font id=calDateText  >");
}
document.write("</td>")
}
document.write("</tr></font>");
}
document.write("</table>")
}
///////////////////////////////
///////////////////////////////
///////////////////////////////
///////////////////////////////
function fUpdateCal(tipoMov) {



//1 disminuir fecha 0 aumentar
iYear=parseInt(document.frmCalendarSample.anyo.value);
iMonth=parseInt(document.frmCalendarSample.mes.value);

if (tipoMov==0){
	if (iMonth < 12 ) {iMonth = iMonth + 1;}
	else {
		iMonth =  1;
		iYear = iYear + 1;
	}
}
if (tipoMov==1){
	if (iMonth > 1 ) {iMonth = iMonth - 1;}
	else {		
		iMonth = 12; 
		iYear = iYear - 1;
	
	}
}

document.frmCalendarSample.mes.value=iMonth;
document.frmCalendarSample.anyo.value=iYear;
document.getElementById("fecha").innerHTML= "" + nMonth[3][iMonth] + " " + iYear;
myMonth = fBuildCal(iYear, iMonth);
objPrevElement.bgColor = "";
document.all.calSelectedDate.value = "";
document.getElementById("dia" + dia).className="textonoticiaazul2";
for (w = 1; w < 7; w++) {
document.getElementById("fila" + w).className="blanco";
for (d = 0; d < 7; d++) {
	if (!isNaN(myMonth[w][d])) {
		if (esPosterior(myMonth[w][d],parseInt(iMonth),parseInt(iYear))) calDateText[((7*w)+d)-7].innerHTML ="<a href='javascript:enlaceCalendari(" + myMonth[w][d] + ");' class='textonoticiaazul2'>" + myMonth[w][d] +'</a>';
		else calDateText[((7*w)+d)-7].innerHTML ="<span class='textonoticiaazul2'>" + myMonth[w][d] + "</span>";
		
	//calDateText[((7*w)+d)-7].innerHTML ="<a href='javascript:enlaceCalendari(" + myMonth[w][d] + ");' class='textonoticiaazul2'>" + myMonth[w][d] +'</a>';
	} else {
	calDateText[((7*w)+d)-7].innerText = " ";
	}
      }
   }
   	sombrearCalendari();  
}

function enlaceCalendari (diaSel){

iYear=parseInt(document.frmCalendarSample.anyo.value);
iMonth=parseInt(document.frmCalendarSample.mes.value);
//alert(diaSel + "" + iMonth + "" + iYear);

document.frmCalendarSample.action="/V07/Serveis/ActesPerDia/V07ActesPerDiaIniciCtl/0,2491,1653_71861_3,00.html" + "?paramFecha=" + diaSel +"/" + iMonth +"/" + iYear;

document.frmCalendarSample.submit();
}


function esPosterior(sdia,smes,sanyo){


if (sdia<=9) sdia="0" + sdia;
if (smes<=9) smes="0" + smes;
auxdia=(parseInt(dia)<=9)?'0'+dia:dia; 
auxmes=(parseInt(mes)<=9)?'0'+mes:mes;
fecha1=parseInt(sanyo + "" + "" + smes + "" + sdia);
fecha2=parseInt(anyo + "" + "" + auxmes + "" + auxdia);
sufijo='';
if (sufijo=='Recordam'){
	if (fecha1>fecha2) return true;
	else return false;
}else {
	if (fecha1>=fecha2) return true;
	else return false;
}

}

function sombrearCalendari(){
//alert(dia+ "--" +mes+ "--" +anyo);
	iYear=parseInt(document.frmCalendarSample.anyo.value);
	iMonth=parseInt(document.frmCalendarSample.mes.value);	
	if (mes==iMonth && anyo==iYear) {
	//sombreo la semana correspondiente	
        numSemana=numeroSemana(dia,mes,anyo);  	
			document.getElementById("fila" + numSemana).className="fondoazulclaro";
			document.getElementById("dia" + dia).className="fondoazuloscuro";	
	}
}

function numeroSemana(dia,mes,anyo)
{

	var fecha = new Date();
	fecha.setMonth(mes - 1);
	fecha.setYear(anyo);
	fecha.setDate(1);
	diaSemana = fecha.getDay();
	diaSemana=(diaSemana==0)?7:diaSemana;
	//alert(diaSemana + "----" + Math.ceil((diaSemana + dia - 1) / 7) );
	return (Math.ceil((diaSemana + dia - 1) / 7) );
	
}

</script>
<script languaje="javascript">  
	document.writeln('<form name="frmCalendarSample" method="post" action="">');

		document.writeln('<input type="hidden" name="calSelectedDate" value="">');
          document.writeln('<table border=0 cellpadding=0 cellspacing=0 summary="calendari" width=170 class="fondoazulclaro">');
             document.writeln('<tr>');			 		 
                document.writeln('<td class="azulgris">');
                   document.writeln('<table border=0 cellpadding=1 cellspacing=2 summary="calendari" width=100%>');
				   	document.writeln('<tr>');					  					  <!-- El calendari solo lo mostramos si hay javascript -->
                        document.writeln('<td class="azulgris">');
							    document.writeln('<table border=0 cellpadding=0 cellspacing=0 summary="calendari" width=100%>');					
								document.writeln('<tr>');
			                          document.writeln('<td><img src="images/V011px_transp.gif" border=0 alt="" hspace="2"></td>');
									  
			                          document.writeln('<td><a href="javascript:fUpdateCal(1)" ><img src="images/V01calendari_esq.gif" alt="previous" border=0></a></td>');
									  									  	
										document.writeln('<input type="hidden"  size=3 name="mes" value="" readonly>');										
										document.writeln('<input type="hidden"  size=4 name="anyo" value="" enabled=false>');
										document.writeln('<input type="hidden"  size=4 name="dia" value="" enabled=false>');									  
										document.writeln('<td align="center" class="textonoticiaazul2" id="fecha" nowrap width=100% ></td>');
									  
			                          document.writeln('<td><a href="javascript:fUpdateCal(0)" ><img src="images/V01calendari_dreta.gif" alt="following" border=0></a></td>');
									  
			                          document.writeln('<td><img src="images/V011px_transp.gif" border=0 alt="" hspace="2"></td>');
								document.writeln('</tr>');
			                    document.writeln('<tr><td><img src="images/V011px_transp.gif" border=0 alt=""></td></tr>							');
								document.writeln('</table>');
							document.writeln('</td>');			
						document.writeln('</tr>');
						document.writeln('<tr>');
							document.writeln('<td class="blanco">');		
								var dataAux=''.split('/');
								//alert(dataAux);
								mesAux=dataAux[1];
								anyoAux=dataAux[2];
								var dCurDate = new Date();
								if (dataAux!=null && dataAux.length==3){ 
									dCurDate.setMonth(mesAux-1);
									dCurDate.setYear(anyoAux);
									dCurDate.setDate(1);
								}
								document.frmCalendarSample.mes.value=dCurDate.getMonth() + 1;
								document.frmCalendarSample.anyo.value=dCurDate.getFullYear();							
								fDrawCal(dCurDate.getFullYear(), dCurDate.getMonth()+1, 0, 0, "8px", "bold", 3);								
								sombrearCalendari();
							document.writeln('</td>');
						document.writeln('</tr>');
					document.writeln('</table>');
				document.writeln('</td>');
			document.writeln('</tr>');
		document.writeln('</table>');
	
	document.writeln('</form>');
	
	</script>