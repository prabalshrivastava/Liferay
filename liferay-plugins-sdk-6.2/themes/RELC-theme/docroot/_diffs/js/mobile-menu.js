YUI().use('node', function (Y) {
	var searchBar = Y.all('.header_search_icon');
	var searchBarDiv = Y.one('#signInsearchBtn');
	var userDiv = Y.all('.user-dropdown');
	var userMobDiv = Y.all('.user-dropdown-mobile');
	var searchBarField = Y.one('#headerSearchField');
	var signInSearchBar = Y.all('.signIn_search_icon');
	var signInSearchBarField = Y.all('#signIn-headerSearchField');
	var mobilesearchBarField = Y.one('#mobile-headerSearchField');
	var mobilesearchBar = Y.all('.mobileheader_search_icon');
	var menuSub = Y.all('.dl-menu ul.dl-submenu');
	var menuArrow = Y.all('.nav-list-item img');
	var bodyElement = Y.one('body');
	//var menuDropDown = Y.all('ul.dl-menu');
	var menuSub2;
	var menuBack;
	//alert("menuDropDown " + menuDropDown);
	menuSub.prepend('<li class="dl-back" id="dl-back"><a class="menu_back_btn" href="#"><img alt="Menu Back" src="/RELC-theme/images/menu/Icon-left-arrow.png" class="leftArrow-mobileMenuBack"/> Back </a></li>');
	var menuItems = Y.all('.dl-menu ul li img');
	menuBack = Y.all('.dl-back');
	var menuBackI = Y.all('.dl-back a img');
	
	if(searchBarDiv != null){
		searchBarDiv.on('click', function(e){
		var searchdropDown =  Y.one('#dropdown-signInsearch');
		var searchdiv =  Y.one('.signInheaderSearch');
		var targ = e.currentTarget;
		//targ.toggleClass('active');
		searchdropDown.toggleClass('active');
		searchdiv.toggleClass('active');
		
		//close the user dropdown
		var userdropDown =  Y.one('.dropdown-content-dsktop');
		if(userdropDown){
			userdropDown.removeClass('active');
		}
		var userTarg = Y.all('.user-dropdown');
		if(userTarg){
		userTarg.removeClass('active');
		}
		
		
	});
	}
	
	
	userDiv.on('click', function(e){
		var userdropDown =  Y.one('.dropdown-content-dsktop');
		var targ = e.currentTarget;
		targ.toggleClass('active');
		userdropDown.toggleClass('active');
		
		//close the search dropdown
		
		var searchdropDown =  Y.one('#dropdown-signInsearch');
		var searchdiv =  Y.one('.signInheaderSearch');
		if(searchdropDown){
		searchdropDown.removeClass('active');
		}
		if(searchdiv){
		searchdiv.removeClass('active');
		}
	});
	
	userMobDiv.on('click', function(e){
		var targ = e.currentTarget;
		targ.toggleClass('active');
		var usermobiledropDown =  Y.one('#dropdown-content-mobile');
		usermobiledropDown.toggleClass('active');
	});
	
	/*var userTarg1 = Y.all('.user-dropdown');
	var searchdiv1 =  Y.one('.signInheaderSearch');
	var classNames = userTarg.get('className');
	alert("classNames " + classNames.indexOf('active'));
	if(userTarg1.hasClass('active') == true){
	bodyElement.on('click', function(e){
		alert("userTarg1 " + userTarg1.hasClass('active'));
		//close the user dropdown
		var userdropDown =  Y.one('.dropdown-content-dsktop');
//		var classNames = userTarg.get('className');
		
			userTarg1.removeClass('active');
			userdropDown.removeClass('active');
	});
	}	
		
	if(searchdiv1.hasClass('active')){
	bodyElement.on('click', function(e){
		//close the search dropdown
		var searchdropDown =  Y.one('#dropdown-signInsearch');
			searchdropDown.removeClass('active');
			searchdiv1.removeClass('active');
	});
	}	*/
	
	menuArrow.on('click', function(e){
		//var userdropDown =  Y.one('.dropdown-content');
		var targ = e.currentTarget;
		var parentLi = targ.get('parentNode');
		parentLi.toggleClass('active');
		//userdropDown.toggleClass('active');
	});
	
	menuItems.on('click', function(e){
		e.preventDefault();
		e.stopPropagation();
		var targ = e.currentTarget;
		var targParent = targ.get('parentNode').get('parentNode');
		//console.log("dlmenu " + targParent);
		menuSub2 = targParent.one('ul.dl-submenu');
		
		if(menuSub2){
			
			targParent.ancestor('ul.dl-menu').addClass('dl-subview');
			
			//e.stopPropagation();
			
		
			
			if(targParent.ancestor('li.dl-subviewopen')){
				//alert("I have LI ancestor of DL-Subviewopen");
				targParent.ancestor('li.dl-subviewopen').replaceClass('dl-subviewopen','dl-subview');
			}
			else{
				//alert("I dont have LI ancestor of DL-Subviewopen");
				
			}
			
			targParent.addClass('dl-subviewopen');	
		}
		
		else{
			window.location = targParent.one('a').getAttribute('href');
		}
		
		
		
	});

menuBack.on('click', function(e){
		
		e.preventDefault();
		e.stopPropagation();
		
		//alert("Back Btn!");
		var subview = e.currentTarget.ancestor('li.dl-subviewopen');
		var subview2 = e.currentTarget.ancestor('li.dl-subview');
		subview.removeClass('dl-subviewopen');
		
		if(subview2){
				subview2.replaceClass( 'dl-subview','dl-subviewopen' );
		}
		else if(e.currentTarget.ancestor('ul.dl-subview')){
			e.currentTarget.ancestor('ul.dl-subview').removeClass( 'dl-subview' );
		}
		
	});

menuBackI.on('click', function(e){
	
	e.preventDefault();
	e.stopPropagation();
	
	//alert("Back Btn!");
	var subview = e.currentTarget.ancestor('li.dl-subviewopen');
	var subview2 = e.currentTarget.ancestor('li.dl-subview');
	subview.removeClass('dl-subviewopen');
	
	if(subview2){
			subview2.replaceClass( 'dl-subview','dl-subviewopen' );
	}
	else if(e.currentTarget.ancestor('ul.dl-subview')){
		e.currentTarget.ancestor('ul.dl-subview').removeClass( 'dl-subview' );
	}
	
});

});

//search dd and text box
AUI().ready('node', 'event', function(Y) {
	var _ftsPageList = Y.one("#searchCatg");
	var _ftsText = Y.one("#signIn-headerSearchField");
	var search = function(){
		var searchText = _ftsText.val();
		if(searchText.trim() != ''){
			var url = _ftsPageList.val();
			url = url.replace("[SEARCH_TEXT]",searchText);
			//window.open(url); // for new tab
			window.location.href = url;
		}
	}
	var populateSearchOptions = function(){
		Y.each(_ftSearchJsonItems,function(item){
			if(item["pageUrl"] ){
				_ftsPageList.append("<option value=" + item["pageUrl"] + ">" + item["label"] + "</option>");
			}
		});
	}
	
	setTimeout(populateSearchOptions,0);
	Y.all('.signIn_search_icon').on("click",function(ev){
		search();
		ev.stopImmediatePropagation();
		return false;
	});
	_ftsText.on("keypress",function(ev){
		// click on enter
		if(ev.keyCode ==  13){
			search();
			ev.stopImmediatePropagation();
		}
	});
});

function changeDropDownHeight(id){
	var submenu2 = document.getElementById(id);
	var submenu2Parent = submenu2.parentElement;
	var submenu2ParentParent = submenu2.parentElement.parentElement.parentElement;
	var submenu2Child = submenu2.children;
	//console.log("paren " + submenu2.parentElement.children + " legth " + submenu2.parentElement.children.length)
	var chLen = submenu2.parentElement.children.length;
	if(submenu2Child[1]){
		var submenu2ChildHeight = submenu2Child[1].clientHeight;
		var submenu2Height = submenu2.clientHeight;
		//console.log("submenu2Heightggg " + submenu2Height + " submenu2ChildHeight length " + submenu2ChildHeight);
		if(submenu2Height*chLen > submenu2ChildHeight){
			submenu2ChildHeight = submenu2Height*chLen;
			submenu2Parent.setAttribute("style","height:"+submenu2ChildHeight+"px;border-bottom: 1px solid #000;");
			submenu2Child[1].setAttribute("style","height:"+submenu2ChildHeight+"px!important;border-bottom: 1px solid #000;");
		}else{
			submenu2Parent.setAttribute("style","height:"+submenu2ChildHeight+"px;border-bottom: 1px solid #000;");
			submenu2Child[1].setAttribute("style","height:"+submenu2ChildHeight+"px!important;border-bottom: 1px solid #000;");
			//submenu2Child[1].setAttribute("style","border-bottom: 1px solid #000;");
		}	
	}	
	var submenu2Child2 = submenu2Child.children;
	if(submenu2Child2){
	if(submenu2Child2[1]){
		var submenu2Child2Height = submenu2Child2[1].clientHeight;
		//console.log("submenu2Parent2 " + submenu2Child2[1] + " submenu2Parent2 length " + submenu2Child2[1].clientHeight);
		submenu2ParentParent.setAttribute("style","height:"+submenu2Child2Height+"px;border-bottom: 1px solid #000;");
		submenu2Child[1].setAttribute("style","border-bottom: 1px solid #000;");
	}	
	}
}

function restoreDropDownHeight(id){
	var submenu2 = document.getElementById(id);
	var submenu2Parent = submenu2.parentElement;
	var submenu2ParentParent = submenu2.parentElement.parentElement.parentElement;
	var submenu2Child = submenu2.children;
	if(submenu2Child[1]){
		var submenu2ChildHeight = submenu2Child[1].clientHeight;
		//console.log("submenu2Parent " + submenu2Child[1] + " submenu2Parent length " + submenu2Child[1].clientHeight);
		submenu2Parent.setAttribute("style","");
	}	
	
	var submenu2Child2 = submenu2.children.children;
	if(submenu2Child2){
	if(submenu2Child2[1]){
		var submenu2Child2Height = submenu2Child2[1].clientHeight;
		//console.log("submenu2Parent2 " + submenu2Child2[1] + " submenu2Parent2 length " + submenu2Child2[1].clientHeight);
		submenu2ParentParent.setAttribute("style","");
	}
	}
	
}

window.onclick = function (event) {
	var target = event.target.id;
	var selectChild = event.target.nodeName;
	if (target != "signInsearchBtn" && target != "user-dropdown-dropbtn" && target != "dropdown-signInsearch" && target != "_ftsPageList" && target != "_ftsText" && selectChild != "OPTION") {
		var userdropDown = document.getElementById("dropdown-content-dsktop");
		var searchdropDown = document.getElementById("dropdown-signInsearch");
		if(userdropDown){
			var userTarg1 =  userdropDown.parentNode;
			userdropDown.classList.remove("active");
			userTarg1.classList.remove("active");
		}
		
		if(searchdropDown){
			var searchdiv1 = searchdropDown.parentNode;
			searchdropDown.classList.remove("active");
			searchdiv1.classList.remove("active");
		}
		
	}
};
