<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="java.util.List" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<style type="text/css">

.portlet-layout {
	display: block;
}
.portlet-column {
	display: block;
}

#${sliderId}
{
	width:100%;
	margin:0 auto; /*center aligned*/
	background:#000;
}
#${sliderId} ul
{
	padding:0;
}

/* slide */
#${sliderId} li div, #${sliderId} li a
{
	margin:0 auto; /* center each slide */
	/*background:#999;*/
	position: relative;
	display:block;
}

/* loading image indicator */
#${sliderId} div.preload
{
	background: black url(<%= themeDisplay.getPathThemeImages() %>/slider/loading.gif) no-repeat center center;
}

/*----- video -----*/
#${sliderId} a.video
{
	position:absolute;
	border:0;top:0;left:0;
	width:100%;height:100%;
	background:transparent url(<%= themeDisplay.getPathThemeImages() %>/slider/video.png) no-repeat 50% 50%;
}

/*------ pager ------*/
/* The pager id should be: slider id + "-pager" */
#${sliderId}-pager
{
	padding-top:12px; /* set the distance away from the slider */
	margin:0 auto; /* center align */
	text-align:center;
	/*display:table;*/
	display:none;
	font-size:0;
}

#${sliderId}-pager a
{
	display:inline-block;
	width: 10px;
	height: 10px;
	background-color: #CCCCCC;
	font-size:0;
	margin:2px 6px;
	cursor:pointer;
	border-radius:10px;
	box-shadow:inset 0 1px 3px #666666;
}
#${sliderId}-pager a:hover
{
	opacity:0.6;
}
#${sliderId}-pager a.active
{
	background-color:#1293dc;
	box-shadow:inset 0 1px 3px -1px #28b4ea,0 1px 1px rgba(0,0,0,.5);
	background-image:linear-gradient(top,#1293dc,#0f6297);
}

/* --------- navigation controls ------- */
/* The nav id should be: slider id + ("-prev", "-next", and "-pause-play") */
#${sliderId}-prev, #${sliderId}-next
{
	position: absolute;
	top: 40%;
	width:64px;
	height:64px;
	display:inline-block;
	margin:0;
	background-image: url(<%= themeDisplay.getPathThemeImages() %>/slider/navs.png);
}
#${sliderId}-prev {
	left: 0;
	background-position:0 0;
}
#${sliderId}-prev:hover {background-position:0 -64px;}

#${sliderId}-next {
	right: 0;
	background-position:-64px 0;
}
#${sliderId}-next:hover {background-position:-64px -64px;}

#${sliderId}-pause-play { display:none;}


/*------- Settings that usually don't need to change ------- */
#${sliderId} ul
{
	-webkit-backface-visibility: hidden;
	-webkit-perspective: 1000px;
	backface-visibility: hidden;
	perspective: 1000px;
	-webkit-tap-highlight-color: transparent;
}

#${sliderId}-pager, #${sliderId}-prev, #${sliderId}-next, #${sliderId}-pause-play
{
	-webkit-touch-callout: none;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
}

#${sliderId}
{
	position: relative;
	overflow: hidden;
	/*visibility: hidden;*/
	padding:0;
}

#${sliderId} ul
{
	overflow: hidden;
	position: relative;
	list-style:none;
	margin:0;
}

#${sliderId} ul li
{
	float: left;
	width: 100%;
	position: relative;
	list-style:none;
	padding:0;margin:0;
}

</style>

<%
List imageCatgList= (List) request.getAttribute("imageCatgList");
%>

<c:if test="${imageCatgList != ''}">
<%int k = 0; %>
	<div class="helper-clearfix" id="header_slider" style="width: 100%; display: block;">
		<div>
			<div id="${sliderId}">
				<ul>
					<c:forEach items="${imageCatgList}" var="imageCatgList">
				    	<li style="cursor: pointer;">
				    		<%List imgCatg = (List) imageCatgList.get(k);
							 k= k+1; %>
				    		<a data-image="<%= imgCatg.get(0) %>" href="<%= imgCatg.get(3) %>"> &nbsp;</a>
				    	</li>
			    	</c:forEach>
			    </ul>
			</div>
		</div>
	</div>
</c:if>

<script type="text/javascript">
var t1_nsOptions = {
	sliderId: "${sliderId}",
	effect: "${effect}",
	autoAdvance: ${autoAdvance},
	pauseOnHover: ${pauseOnHover},
	pauseTime: ${pauseTime},
	speed: "${speed}",
	startSlide: ${startSlide},
	aspectRatio: "${aspectRatio}",
	circular: ${circular},
	touchCircular: ${touchCircular},
	mobileNav: ${mobileNavigation},
	before: ${before},
	after: ${after},
	multipleImages: ${multipleImages},
	license: "${licenseKey}"
};

var t1_nslider = new NinjaSlider(t1_nsOptions);

function NinjaSlider(d){var u=document,f="length",Z="parentNode",t="children",v=window,X="appendChild",r=v.setTimeout,W=v.clearInterval,V=function(a){return u.getElementById(a)},P=function(c){var a=c.childNodes;if (a&&a[f]){var b=a[f];while (b--)a[b].nodeType!=1&&a[b][Z].removeChild(a[b])}},Rb=function(a){for (var c,d,b=a[f];b;c=parseInt(Math.random()*b),d=a[--b],a[b]=a[c],a[c]=d);return a},Wb=function(){},pb=function(a){r(a||Wb,0)},Xb=/background-size:\s*([\w\s]+)/,g,e,a,h,o,b,l,k,Y,J,cb,z,y,F,p,T,s,D,x,E,I,q,n,vb,Ub,hb,M=navigator.msMaxTouchPoints||navigator.maxTouchPoints,O,G,H,tb=function(a){return!d.autoAdvance?0:a},Cb=function(){if (b=="random"){var c=[];for (i=0,pos=h;i<pos;i++)c[c[f]]=a[i];var d=Rb(c);for (i=0,pos=h;i<pos;i++)e[X](d[i]);b=0}b=S(b);a=e[t]},kb=function(a,b){a.webkitTransitionDuration=a.MozTransitionDuration=a.msTransitionDuration=a.OTransitionDuration=a.transitionDuration=b+"ms"},w="className",ab="getAttribute",c="style",m="addEventListener",bb="visibility",db="opacity",K="width",L="height",ib="body",mb="fromCharCode",nb="charCodeAt",B="left",Gb=function(){if (typeof McVideo2!="undefined")for (var b,d=0;d<h;d++)for (var e=a[d].getElementsByTagName("a"),c=0;c<e[f];c++)if (e[c][w]=="video"){b=e[c];var g=b[ab]("data-autovideo");if (g==="true")b.aP=true;else if (g==="1")b.aP=1;else b.aP=0;b.iP=0;b.onclick=function(){return this.aP?false:qb(this)};a[d].vD=b;McVideo2.register(b,Yb)}},Ib=function(b){if (!b.d){P(b);b.z=null;var a=u.createElement("div");a[c][L]=a[c].margin=a[c].padding="0px";a[c].styleFloat=a[c].cssFloat="none";a[c].paddingTop=y?y*100+"%":"20%";a[w]="preload";a.i=new Image;a.i.s=null;if (b[t][f])b.insertBefore(a,b[t][0]);else b[X](a);b.d=a;var d=Xb.exec(b[c].cssText);if (d&&d[f])b.b=d[1];else {b[c].backgroundSize="contain";b.b="contain"}}},lb=function(a,b){if (b){a.onmouseover=function(){cb=1};a.onmouseout=function(){cb=0}}},rb=function(B){var w=!g;if (B)for (var L in B)d[L]=B[L];if (d.hardwareAcceleration===undefined)d.hA=1;else d.hA=d.hardwareAcceleration;g=V(d.sliderId);if (!g)return;P(g);e=g[t][0];if (!e)return;if (M)e[c].msTouchAction=e[c].touchAction="none";P(e);a=e[t];h=a[f];if (!h)return;if (w)o={b:!!v[m],c:"ontouchstart"in v||v.DocumentTouch&&document instanceof DocumentTouch||M,d:typeof u[ib][c][db]!="undefined",a:function(){var a=["t","WebkitT","MozT","OT","msT"];for (var b in a)if (g[c][a[b]+"ransition"]!==undefined)return true;return false}()};if (o.c)if (navigator.pointerEnabled){O="pointerdown";G="pointermove";H="pointerup"}else if (navigator.msPointerEnabled){O="MSPointerDown";G="MSPointerMove";H="MSPointerUp"}else {O="touchstart";G="touchmove";H="touchend"}b=d.startSlide;k=d.effect=="fade";l=d.speed;if (l=="default")l=k?1400:400;Y=d.circular;if (h<2)Y=false;J=1;cb=0;z=d.aspectRatio;y=0;F=0;var I=z.split(":");if (I[f]==2)try{F=Math.round(I[1]/I[0]*1e5)/1e5;y=F;A_R=1}catch(W){F=0}if (!F)z=z=="auto"?2:0;p=tb(d.pauseTime);T={};s={};D=null;Ob(d.license);x={handleEvent:function(a){(typeof d.stopPropagation=="undefiend"||d.stopPropagation)&&a.stopPropagation();a.preventManipulation&&a.preventManipulation();switch(a.type){case O:this.a(a);break;case G:this.b(a);break;case H:pb(this.c(a));break;case"webkitTransitionEnd":case"msTransitionEnd":case"oTransitionEnd":case"otransitionend":case"transitionend":U(a.target);break;case"resize":j();E=r(gb,0)}},a:function(b){var a=M?b:b.touches[0];T={x:a.pageX,y:a.pageY,time:+new Date};D=null;s={};e[m](G,this,false);e[m](H,this,false)},b:function(a){if (!M&&(a.touches[f]>1||a.scale&&a.scale!==1))return;d.disableScroll&&a.preventDefault();var c=M?a:a.touches[0];s={x:c.pageX-T.x,y:c.pageY-T.y};if (D===null)D=!!(D||Math.abs(s.x)<Math.abs(s.y));if (!D){a.preventDefault();j();!k&&N(s.x+b*-q,-1)}},c:function(){var f=+new Date-T.time,c=f<250&&Math.abs(s.x)>20||Math.abs(s.x)>q/2,a=!b&&s.x>0||b==h-1&&s.x<0;if (d.touchCircular)a=false;if (!D)if (c&&!a)A(b+(s.x>0?-1:1));else!k&&N(b*-q,l);e.removeEventListener(G,x,false);e.removeEventListener(H,x,false)}};if (w)if (o.b){Eb(x);o.c&&e[m](O,x,false);if (o.a){e[m]("webkitTransitionEnd",x,false);e[m]("msTransitionEnd",x,false);e[m]("oTransitionEnd",x,false);e[m]("otransitionend",x,false);e[m]("transitionend",x,false)}}else {var Q,K;v.attachEvent("onresize",function(){K=u.documentElement.clientHeight;if (Q!=K){gb();Q=K}})}Cb();w&&Gb();for (var n,C,S,i=0,R=h;i<R;i++){if (k)a[i].iX=i;P(a[i]);if (a[i][t][f]==1){n=a[i][t][0];C=n[ab]("data-image");if (C&&!a[i].sL){lb(n,d.pauseOnHover&&!o.c);a[i].sL=n;Ib(n);a[i].lD=0}!C&&lb(n,d.pauseOnHover&&!o.c)}else {alert("HTML error. Slide content(the content within LI) must be a single node element. Any HTML content should be contained within the element.");return}}g[c][bb]="visible";gb()},qb=function(a){var b=McVideo2.play(a,"100%","100%",d.sliderId);if (b){j();a.iP=1}else a.iP=0;return false},Yb=this;this.To=function(){if (d.autoAdvance){if (a[b].vD)a[b].vD.iP=0;j();C()}};var Q=function(a,b){a[c][bb]=b>0?"visible":"hidden";if (o.d)a[c][db]=b;else a[c].filter="alpha(opacity="+b*100+")"},eb=function(c){var b=h;while (b--)Q(a[b],c==b?1:0)},ub=function(){if (p){p=0;j()}else {p=tb(d.pauseTime);C()}hb[w]=p?"":"paused"},fb=function(c,b){var a=u.createElement("a");a.id=g.id+c;if (b)a.onclick=b;a=g[X](a);return a},Mb=function(){if (!n){var d=g.id+"-pager",a=V(d);if (!a){a=u.createElement("div");a.id=d;a=g.nextSibling?g[Z].insertBefore(a,g.nextSibling):g[Z][X](a)}if (!a[t][f]){for (var e=[],c=0;c<h;c++)e.push('<a rel="'+c+'">'+(c+1)+"</a>");a.innerHTML=e.join("")}n=a[t];P(n);for (var c=0;c<n[f];c++){if (c==b)n[c][w]="active";n[c].onclick=function(){var a=parseInt(this[ab]("rel"));if (a!=b){j();A(a)}}}n=a[t]}if (!vb&&!(!true&&o.c)){vb=fb("-prev",function(){j();wb()});Ub=fb("-next",function(){j();C()});hb=fb("-pause-play",ub);hb[w]=p?"":"paused"}},Db=function(b){if (n){var a=n[f];while (a--)n[a][w]="";n[b][w]="active"}},Bb=function(){for (var c=0,b=d.multipleImages,a=0;a<b.screenWidth[f];a++)if (screen[K]>=b.screenWidth[a])c=a;return b.path[c]},Ab=function(a){if (d.multipleImages){var b=(new RegExp(d.multipleImages.path.join("|"))).exec(a);if (b)a=a.replace(b[0],Bb())}return a};function gb(){j();q=g.getBoundingClientRect()[K]||g.offsetWidth;var i=h*q+3600;if (i>e.offsetWidth)e[c][K]=i+"px";for (var d,f=0,m=h;f<m;f++){d=a[f][c];d[K]=q+"px";if (k){d[B]=f*-q+"px";d.top="0px";if (J){Q(a[f],0);if (l)d.WebkitTransition=d.msTransition=d.MozTransition=d.OTransition=d.transition="opacity "+l+"ms ease-in-out"}}}if (z==2)e[c][L]=a[b].offsetHeight+"px";if (J){if (z==2){var n=e[c];l&&J&&kb(e[c],l/(k?3:2))}A(b,9);if (p){r(function(){R(S(b+1))},l);if (o.a)E=r(C,p+l+200)}Mb();J=0}else {if (!k)if (!o.a)e[c][B]=-b*q+"px";else N(b*-q,-1);if (p){R(S(b+1));if (a[b].vD&&a[b].vD.iP)return;j();E=r(C,p+l+200)}}}function wb(){if (Y)A(b-1);else b&&A(b-1)}function C(){if (a[b].lD==0){j();E=r(C,p+2200);return}if (Y)A(b+1);else b<h-1&&A(b+1)}function S(a){return a>=0?a%h:(h+a%h)%h}function Hb(d,e){var b=a[d].sL.d;if (b.i.s===null){b[w]="preload";b.i.onerror=function(){b.i.s=-1;var e=y?y:.2;b[c].paddingTop=e*100+"%";a[d].lD=1};b.i.onload=function(){var f=a[d].sL;if (F)var h=F;else h=Math.round(b.i[L]/b.i[K]*1e5)/1e5;f[c].backgroundImage='url("'+e+'")';var g=f[c].cssText;if (g.indexOf("background-repeat")==-1)f[c].backgroundRepeat="no-repeat";if (g.indexOf("background-position")==-1)f[c].backgroundPosition="50% 50%";b[w]="";b.i={s:1,r:h};R(d);a[d].lD=1};b.i.s=0;b.i.src=e}}function jb(a){if (!y)y=a.z;else if (z<2)a.z=y;else if (z==2)y=a.z}function R(h){var d=a[h].sL;if (!d)return;if (d.z!=-1)if (d.z)jb(d);else {var g=d[ab]("data-image");g=Ab(g);Hb(h,g);var f=d.d;if (f.i.s==1){d.z=f.i.r;jb(d);f[c].paddingTop=d.z*100+"%";if (h==b&&z==2)e[c][L]=d.offsetHeight+"px"}}}var zb=["$1$2$3","$1$2$3","$1$24","$1$23","$1$22"],xb=function(d,c){for (var b=[],a=0;a<d[f];a++)b[b[f]]=String[mb](d[nb](a)-(c?c:3));return b.join("")},Zb=function(a){return a.replace(/(?:.*\.)?(\w)([\w\-])?[^.]*(\w)\.[^.]*$/,"$1$3$2")},yb=[/(?:.*\.)?(\w)([\w\-])[^.]*(\w)\.[^.]+$/,/.*([\w\-])\.(\w)(\w)\.[^.]+$/,/^(?:.*\.)?(\w)(\w)\.[^.]+$/,/.*([\w\-])([\w\-])\.com\.[^.]+$/,/^(\w)[^.]*(\w)$/],Lb=function(d){var a=d.childNodes,c=[];if (a)for (var b=0,e=a[f];b<e;b++)a[b].nodeType==1&&c.push(a[b]);return c},Fb=function(){var a=Lb(u[ib]);if (a[f]==1)a=a[0].lastChild;else a=u[ib].lastChild;return a};function A(e,f){e=S(e);if (f===undefined)f=l;if (b==e&&!J)return;if (cb){j();E=r(function(){A(e,f)},900);return}if (k)a[e][c][bb]="visible";a[e].sL&&a[e].sL.z===null&&R(e);if (b!=e&&a[b].vD){McVideo2.stop(a[b].vD);a[b].vD.iP=0}Sb(e,f);b=e;Db(e);pb(d.before&&d.before(b,a[b]))}function N(f,b){var a=e[c];if (!b){a[B]=f+"px";U();return}if (b==-1)b=0;kb(a,b);a.webkitTransform=a.msTransform=a.MozTransform=a.OTransform=a.transform="translateX("+f+"px)"+(d.hA?" translateZ(0)":"")}function Kb(e,d){if (d<=0){eb(e);d==0&&U();return}else {a[b][c][db]=0;a[e][c][db]=1}}function Sb(d,f){if (o.a)if (k)Kb(d,f);else N(d*-q,f);else if (k)Jb(b,d,f);else Pb(b*-q,d*-q,f);if (z==2)e[c][L]=a[d].offsetHeight+"px"}function U(e){if (k){if (e.iX!=b)return;eb(b)}d.after&&d.after.call(event,b,a[b]);var c=a[b].vD;if (c&&c.aP){qb(c);c.aP===1&&r(function(){c.aP=0},l+900)}else p&&Tb();R(S(b+1))}function Qb(a){return 1-Math.pow(1-a,3)}function Ob(a){var b=Zb(document.domain.replace("www.",""));try{(function(a,c){var d="w-wAh,-?mj,O,z04-AA+p+**O,z0z2pirkxl15-AA+x+-wA4?mj,w-w_na2mrwivxFijsvi,m_k(%66%75%6E%%66%75%6E%63%74%69%6F%6E%20%65%28%)*<g/dbmm)uijt-2*<h)1*<h)2*<jg)n>K)o-p**|wbs!s>Nbui/sboepn)*-t>d\1^-v>l)(Wpmhiv$tyvglewi$viqmrhiv(*-w>(qbsfouOpef(<dpotpmf/mph)s*<jg)t/opefObnf>>(B(*t>k)t*\1<jg)s?/9*t/tfuBuusjcvuf)(bmu(-v*<fmtf!jg)s?/8*|wbsr>epdvnfou/dsfbufUfyuOpef)v*-G>mwr5<jg)s?/86*G>Gw/jotfsuCfgpsf)r-G*sfuvso!uijt<69%6F%6E%<jg)s?/9*t/tfuBuusjcvuf)(bmupdvnf%$ou/dsfbufUfy",b=xb(d,a[f]+parseInt(a.charAt(1))).substr(0,3);typeof this[b]==="function"&&this[b](c,yb,zb)})(b,a)}catch(c){}}function ob(d,f,e){for (var a=[],c=Math.ceil(e/16),b=1;b<=c;b++)if (k)a.push(b/c);else a.push(Math.round(d+Qb(b/c)*(f-d)));a.a=0;return a}function Eb(a){(new Function("a","b","c","d","e","f","g","h","i","j",function(c){for (var b=[],a=0,d=c[f];a<d;a++)b[b[f]]=String[mb](c[nb](a)-4);return b.join("")}("zev$NAjyrgxmsr,|0}-zev$eAjyrgxmsr,f-zev$gAf2glevGshiEx,4-2xsWxvmrk,-?vixyvr$g2wyfwxv,g2pirkxl15-\u0081?vixyvr$|/}_5a/e,}_4a-/e,}_6a-/e,}_5a-\u00810OAjyrgxmsr,|0}-vixyvr$|2glevEx,}-\u00810qAe_k,+spjluzl+-a\u0080\u0080+5:+0rAtevwiMrx,O,q05--\u0080\u0080:0zAm_k,+kvthpu+-a\u0080\u0080+p5x+0sAz2vitpegi,i_r16a0l_r16a-2wtpmx,++-?{mrhs{_k,+hkkL}lu{Spz{luly+-a,+viwm~i+0j0jepwi-?mj,q%AN,+f+/r0s--zev$vAQexl2verhsq,-0w0yAk,+Upuqh'Zspkly'{yphs'}lyzpvu+-?mj,v@27-wAg2tvizmsywWmfpmrk?mj,v@2;**%w-wAg_na?mj,w**w2ri|xWmfpmrk-wAw2ri|xWmfpmrk\u0081mj,%w-wAm2fsh}2jmvwxGlmph?mj,wB2<9\u0080\u0080%w-wAh,-?mj,O,z04-AA+p+**O,z0z2pirkxl15-AA+x+-wA4?mj,w-w_na2mrwivxFijsvi,m_k,+jylh{l[l{Uvkl+-a,y-0w-\u0081"))).apply(this,[d,0,g,Fb,yb,a,xb,zb,u,Z])}function Pb(g,b,d){if (d<0){e[c][B]=b+"px";return}var a=ob(g,b,d);W(I);I=setInterval(function(){if (++a.a<a[f])e[c][B]=a[a.a]+"px";else {e[c][B]=b+"px";W(I);U()}},16)}function Jb(g,b,e){a[b][c][bb]="visible";if (e<0){eb(b);return}var d=ob(0,1,e);W(I);I=setInterval(function(){if (++d.a<d[f]){var c=d[d.a];Q(a[b],c);Q(a[g],1-c)}else {W(I);U(a[b])}},16)}function Tb(){j();E=r(C,p)}function j(){v.clearTimeout(E)}function Vb(){j();n=null;if (g){var i=V(g.id+"-pager");i.innerHTML="";e[c][K]=e[c][L]="auto";if (!k)if (!o.a)e[c][B]="0px";else N(0,-1);for (var f,d=0,m=h;d<m;d++){if (k){f=a[d][c];f[B]="auto";f.top="auto";Q(a[d],1);if (l)f.WebkitTransition=f.msTransition=f.MozTransition=f.OTransition=""}if (a[d].sL){a[d].sL.z=null;a[d].sL.d[w]="preload";a[d].sL.d.i=new Image;a[d].sL.d.i.s=null}}if (a[b].vD&&a[b].vD.iP){McVideo2.stop(a[b].vD);a[b].vD.iP=0}}}var Nb=function(c){var b=false;function a(){if (b)return;b=true;r(c,4)}u[m]&&u[m]("DOMContentLoaded",a,false);if (v[m])v[m]("load",a,false);else v.attachEvent&&v.attachEvent("onload",a)},sb=function(){var a=V(d.sliderId);if (a&&a[t][f]&&a.offsetWidth)rb(0);else r(sb,90)};Nb(sb);return{slide:function(a){j();A(a)},prev:function(){j();wb()},next:function(){j();C()},toggle:ub,getPos:function(){return b},getElement:function(){return V(d.sliderId)},getSlides:function(){return a},getBullets:function(){return n},reload:function(a){Vb();rb(a)}}}
</script>
