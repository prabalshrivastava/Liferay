<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
<%@page import="com.sambaash.platform.util.LabelUtil"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />


<div class='adfDropdown-button' id='adfDropdown-favText' onclick="showadfDropdown()"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.favourites")%></div>
<button class="adfUpdateBtn gs-fav-update gs-fav-info hide" id="update2" onclick="updateFavourite(this)"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.update")%></button>
<span class='triangle' id='adfDropdown-triangle' onclick="showadfDropdown()">&#9660;</span>

<ul class='adfDropdown-selection' id='adfDropdown-selection-id'>
	<div class="adfSearchList hide">
		<input type="text" name="" value="" placeholder="" id="searchTextFav" onkeyup="javascript:showFavUsingSearchText(this)">
	</div>
	<li class="gs-fav-private-list hide"><span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.private")%></span>
	</li>
	<li class="gs-fav-global-list hide"><span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.global")%></span>
	</li>
	<div class="createNewBut">
		<a href="javascript:showNewFavourite();"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.create.new")%></a>
		<a class="clearAllBut" href="javascript:clearFavourite();"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.clear.all")%></a>
	</div>
</ul>

<div class="hide" id="gsfavtemplates">
	<div class="adfListSec gs-fav-item gs-fav-info">
			<div class="adfavname gs-fav-name" onclick="javascript:onFavSelected(this)"></div>
			<button class="adfUpdateBtn gs-fav-update gs-fav-info hide " id="update1" onclick="updateFavourite(this)"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.update")%></button>
			<div class="adFavicon gs-fav-actions hide">
				<a href="javascript:;" onclick="javascript:showEditFavourite(this)" class="gs-fav-edit gs-fav-info"><img src="/GenericSearch-portlet/images/Fv-edit.svg" alt="edit"></a>
				<a href="javascript:;" onclick="javascript:deleteFavourite(this)" class="gs-fav-delete gs-fav-info"><img
					src="/GenericSearch-portlet/images/Fv-cancel.svg" alt="Cancel"></a>
			</div>
	</div>
</div>

<script type="text/javascript">
	//ADDED BY KARTHIK - ADD TO FAV


var activeadfDropdown = {};
//document.getElementById('addtofav-adfDropdown').addEventListener('click',showadfDropdown);

                                                              
function showadfDropdown(event){
	
	var adfDropdown = document.getElementById('addtofav-adfDropdown');
  //if (activeadfDropdown.id && activeadfDropdown.id !== event.target.id) {
  //  activeadfDropdown.element.classList.remove('active');
  //}
  
  var adfDropdownSelection = document.getElementById('adfDropdown-selection-id');
  if(adfDropdownSelection.classList.contains('active')){
	  adfDropdownSelection.classList.remove('active');
  }
  else{
	  for (var i = 0;i<adfDropdown.children.length;i++){
		    if (adfDropdown.children[i].classList.contains('adfDropdown-selection')){
		        activeadfDropdown.id = adfDropdown.id;
		        activeadfDropdown.element = adfDropdown.children[i];
		        adfDropdown.children[i].classList.add('active');
		     }
		    //adding the adfDropdown-button to our object
		    else if (adfDropdown.children[i].classList.contains('adfDropdown-button')){
		      activeadfDropdown.button = adfDropdown.children[i];
		    }
		  }
  }

}


</script>
