function postURL(myParams) {

  with (document.forms['postForm']) {

    myParams = myParams; 

    action = myParams;

    submit();

  }

}



function MM_displayRow()	{

  var i,p,v,obj,args=MM_displayRow.arguments;

  for (i=0; i<(args.length-2); i+=3) if ((obj=MM_findObj(args[i]))!=null) { v=args[i+2];

    if (obj.style) { obj=obj.style; v=(v=='show' && obj.display=='none')?'':'none'; }

    obj.display=v; }

}



function MM_showHideLayers() { //v3.0

  var i,p,v,obj,args=MM_showHideLayers.arguments;

  for (i=0; i<(args.length-2); i+=3) if ((obj=MM_findObj(args[i]))!=null) { v=args[i+2];

    if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v='hide')?'hidden':v; }

    obj.visibility=v; }

}



function MM_preloadImages() { //v3.0

  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();

    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)

    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}

}



function MM_findObj(n, d) { //v4.01

  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {

    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}

  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];

  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);

  if(!x && d.getElementById) x=d.getElementById(n); return x;

}



function MM_swapImage() { //v3.0

  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)

   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}

}



function MM_nbGroup(event, grpName) { //v3.0

  var i,img,nbArr,args=MM_nbGroup.arguments;

  if (event == "init" && args.length > 2) {

    if ((img = MM_findObj(args[2])) != null && !img.MM_init) {

      img.MM_init = true; img.MM_up = args[3]; img.MM_dn = img.src;

      if ((nbArr = document[grpName]) == null) nbArr = document[grpName] = new Array();

      nbArr[nbArr.length] = img;

      for (i=4; i < args.length-1; i+=2) if ((img = MM_findObj(args[i])) != null) {

        if (!img.MM_up) img.MM_up = img.src;

        img.src = img.MM_dn = args[i+1];

        nbArr[nbArr.length] = img;

    } }

  } else if (event == "over") {

    document.MM_nbOver = nbArr = new Array();

    for (i=1; i < args.length-1; i+=3) if ((img = MM_findObj(args[i])) != null) {

      if (!img.MM_up) img.MM_up = img.src;

      img.src = (img.MM_dn && args[i+2]) ? args[i+2] : args[i+1];

      nbArr[nbArr.length] = img;

    }

  } else if (event == "out" ) {

    for (i=0; i < document.MM_nbOver.length; i++) {

      img = document.MM_nbOver[i]; img.src = (img.MM_dn) ? img.MM_dn : img.MM_up; }

  } else if (event == "down") {

    if ((nbArr = document[grpName]) != null)

      for (i=0; i < nbArr.length; i++) { img=nbArr[i]; img.src = img.MM_up; img.MM_dn = 0; }

    document[grpName] = nbArr = new Array();

    for (i=2; i < args.length-1; i+=2) if ((img = MM_findObj(args[i])) != null) {

      if (!img.MM_up) img.MM_up = img.src;

      img.src = img.MM_dn = args[i+1];

      nbArr[nbArr.length] = img;

  } }

}

function P7AniMagic(el, x, y, a, b, c, s) { //v2.5 PVII

 var g,elo=el,f="",m=false,d="";x=parseInt(x);y=parseInt(y);

 var t = 'g.p7Magic = setTimeout("P7AniMagic(\''+elo+'\','; 

 if ((g=MM_findObj(el))!=null) {d=(document.layers)?g:g.style;}else{return;}

 if (parseInt(s)>0) {eval(t+x+','+y+','+a+','+b+','+c+',0)",' + s+')');return;}

 var xx=(parseInt(d.left))?parseInt(d.left):0;

 var yy=(parseInt(d.top))?parseInt(d.top):0;

 if(parseInt(c)==1) {x+=xx;y+=yy;m=true;c=0;}

 else if (c==2) {m=false;clearTimeout(g.p7Magic);}

 else {var i=parseInt(a);

  if (eval(g.moved)){clearTimeout(g.p7Magic);}

  if (xx<x){xx+=i;m=true;if(xx>x){xx=x;}}

  if (xx>x){xx-=i;m=true;if(xx<x){xx=x;}}

  if (yy<y){yy+=i;m=true;if(yy>y){yy=y;}}

  if (yy>y){yy-=i;m=true;if(yy<y){yy=y;}}}

 if (m) {if((navigator.appName=="Netscape") && parseInt(navigator.appVersion)>4){

    xx+="px";yy+="px";}

  d.left=xx;d.top=yy;g.moved=true;eval(t+x+','+y+','+a+','+b+','+c+',0)",'+b+')');

  }else {g.moved=false;}

}



function P7_autoLayers() { //v1.1 PVII

 var g,b,k,f,args=P7_autoLayers.arguments;

 if(!document.p7setc) {p7c=new Array();document.p7setc=true;}

 for(k=0; k<p7c.length; k++) {

  if((g=MM_findObj(p7c[k]))!=null) {

   b=(document.layers)?g:g.style;b.visibility="hidden";}}

 for(k=0; k<args.length; k++) {

  if((g=MM_findObj(args[k])) != null) {

   b=(document.layers)?g:g.style;b.visibility="visible";f=false;

   for(j=0;j<p7c.length;j++) {

    if(args[k]==p7c[j]) {f=true;}}

  if(!f) {p7c[p7c.length++]=args[k];}}}

}



function pviiW3Cbg(obj, pviiColor) { //v1.1 by Project VII

	obj.style.backgroundColor=pviiColor

}

function MM_swapImgRestore() { //v3.0

  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;

}





                function getReport(sess, vers, typ, coref, sty, purp ) {



                    with (document.forms['yourref']) {

                    sessionid.value = sess;

                    type.value = typ;

                    reference.value = coref;

                    stylesheet.value = sty;

                    version.value = vers;

                    purposeofsearch.value = purp;

                    submit();

                    }



                }





function MM_callJS(jsStr) { //v2.0

  return eval(jsStr)

}



function doTooltip(e, msg) {

  if ( typeof Tooltip == "undefined" || !Tooltip.ready ) return;

  Tooltip.show(e, msg);

}



function hideTip() {

  if ( typeof Tooltip == "undefined" || !Tooltip.ready ) return;

  Tooltip.hide();

}



var dw_event = {

  

  add: function(obj, etype, fp, cap) {

    cap = cap || false;

    if (obj.addEventListener) obj.addEventListener(etype, fp, cap);

    else if (obj.attachEvent) obj.attachEvent("on" + etype, fp);

  }, 



  remove: function(obj, etype, fp, cap) {

    cap = cap || false;

    if (obj.removeEventListener) obj.removeEventListener(etype, fp, cap);

    else if (obj.detachEvent) obj.detachEvent("on" + etype, fp);

  }, 



  DOMit: function(e) { 

    e = e? e: window.event;

    e.tgt = e.srcElement? e.srcElement: e.target;

    

    if (!e.preventDefault) e.preventDefault = function () { return false; }

    if (!e.stopPropagation) e.stopPropagation = function () { if (window.event) window.event.cancelBubble = true; }

        

    return e;

  }

  

}



viewport = {

  getWinWidth: function () {

    this.width = 0;

    if (window.innerWidth) this.width = window.innerWidth - 18;

    else if (document.documentElement && document.documentElement.clientWidth) 

  		this.width = document.documentElement.clientWidth;

    else if (document.body && document.body.clientWidth) 

  		this.width = document.body.clientWidth;

  },

  

  getWinHeight: function () {

    this.height = 0;

    if (window.innerHeight) this.height = window.innerHeight - 18;

  	else if (document.documentElement && document.documentElement.clientHeight) 

  		this.height = document.documentElement.clientHeight;

  	else if (document.body && document.body.clientHeight) 

  		this.height = document.body.clientHeight;

  },

  

  getScrollX: function () {

    this.scrollX = 0;

  	if (typeof window.pageXOffset == "number") this.scrollX = window.pageXOffset;

  	else if (document.documentElement && document.documentElement.scrollLeft)

  		this.scrollX = document.documentElement.scrollLeft;

  	else if (document.body && document.body.scrollLeft) 

  		this.scrollX = document.body.scrollLeft; 

  	else if (window.scrollX) this.scrollX = window.scrollX;

  },

  

  getScrollY: function () {

    this.scrollY = 0;    

    if (typeof window.pageYOffset == "number") this.scrollY = window.pageYOffset;

    else if (document.documentElement && document.documentElement.scrollTop)

  		this.scrollY = document.documentElement.scrollTop;

  	else if (document.body && document.body.scrollTop) 

  		this.scrollY = document.body.scrollTop; 

  	else if (window.scrollY) this.scrollY = window.scrollY;

  },

  

  getAll: function () {

    this.getWinWidth(); this.getWinHeight();

    this.getScrollX();  this.getScrollY();

  }

  

}



var Tooltip = {

  followMouse: true,

  offX: 8,

  offY: 12,

  

  ready: false,

  t1: null,

  t2: null,

  tipID: "tipDiv",

  tip: null,

  

  init: function() {

      if ( document.createElement && document.body && typeof document.body.appendChild != "undefined" ) {

      var el = document.createElement("DIV");

      el.className = "tooltip";

      el.id = this.tipID;

      document.body.appendChild(el);

      this.ready = true;

    }

  },

  

  show: function(e, msg) {

    if (this.t1) clearTimeout(this.t1);	

  	if (this.t2) clearTimeout(this.t2); 

    this.tip = document.getElementById( this.tipID );

  	// set up mousemove 

  	if (this.followMouse) 

      dw_event.add( document, "mousemove", this.trackMouse, true );

    this.writeTip("");  // for mac ie

    this.writeTip(msg);

    viewport.getAll();

    this.positionTip(e);

  	this.t1 = setTimeout("document.getElementById('" + Tooltip.tipID + "').style.visibility = 'visible'",200);	

    },

    

    writeTip: function(msg) {

      if ( this.tip && typeof this.tip.innerHTML != "undefined" ) this.tip.innerHTML = msg;

    },

    

    positionTip: function(e) {

      var x = e.pageX? e.pageX: e.clientX + viewport.scrollX;

      var y = e.pageY? e.pageY: e.clientY + viewport.scrollY;



      if ( x + this.tip.offsetWidth + this.offX > viewport.width + viewport.scrollX )

        x = x - this.tip.offsetWidth - this.offX;

      else x = x + this.offX;

    

      if ( y + this.tip.offsetHeight + this.offY > viewport.height + viewport.scrollY )

        y = ( y - this.tip.offsetHeight - this.offY > viewport.scrollY )? y - this.tip.offsetHeight - this.offY : viewport.height + viewport.scrollY - this.tip.offsetHeight;

      else y = y + this.offY;

  

      this.tip.style.left = x + "px"; this.tip.style.top = y + "px";

    },

    

    hide: function() {

      if (this.t1) clearTimeout(this.t1);	

    	if (this.t2) clearTimeout(this.t2); 

      this.t2 = setTimeout("document.getElementById('" + this.tipID + "').style.visibility = 'hidden'",200);

    	// release mousemove

    	if (this.followMouse) 

    		dw_event.remove( document, "mousemove", this.trackMouse, true );

      this.tip = null;

    },

    

    trackMouse: function(e) {

    	e = dw_event.DOMit(e);

     	Tooltip.positionTip(e);	

    }



}



      function method_closure(object, method, opt_argArray) {
        return function() {
          return method.apply(object, opt_argArray);
        }
      }

      function removeChildren(parent) {
		//rowCounter = 3;
        while (parent.firstChild) {
          parent.removeChild(parent.firstChild);
        }
      }

      function cssSetClass(el, className) {
        el.className = className;
      }

      function createDiv(opt_text, opt_className) {
        var el = document.createElement("div");
        if (opt_text) {
          el.innerHTML = opt_text;
        }
        if (opt_className) { el.className = opt_className; }
        return el;
      }

      function createTable(opt_className) {
        var el = document.createElement("table");
        if (opt_className) { el.className = opt_className; }
        return el;
      }

      function createTableRow(table) {
        var tr = table.insertRow(-1);
        return tr;
      }

      function createTableCell(tr, opt_className) {
        var td = tr.insertCell(-1);
        if (opt_className) { td.className = opt_className; }
        return td;
      }
	  
	  

  	function classChange(element,newclass) {
		element.className = newclass;
	}
	

