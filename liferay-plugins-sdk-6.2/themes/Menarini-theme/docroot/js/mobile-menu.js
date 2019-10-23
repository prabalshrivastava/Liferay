YUI().use('node', function (Y) {
	
	var menuSub = Y.all('.dl-menu ul.dl-submenu');
	var menuSub2;
	var menuBack;
	
	menuSub.prepend('<li class="dl-back" id="dl-back"><a class="menu_back_btn" href="#"><i class="icon icon-chevron-left"></i> Back </a></li>');
	
	var menuItems = Y.all('.dl-menu li');
	
	menuBack = Y.all('.dl-back');
	
	
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
	
	
	
	menuItems.on('click', function(e){
		
		e.preventDefault();
		e.stopPropagation();
		//alert("Clicked! " + e.currentTarget);
		var targ = e.currentTarget;
		
		menuSub2 = e.currentTarget.one('ul.dl-submenu');
		
		if(menuSub2){
			
			e.currentTarget.ancestor('ul.dl-menu').addClass('dl-subview');
			
			//e.stopPropagation();
			
		
			
			if(e.currentTarget.ancestor('li.dl-subviewopen')){
				//alert("I have LI ancestor of DL-Subviewopen");
				e.currentTarget.ancestor('li.dl-subviewopen').replaceClass('dl-subviewopen','dl-subview');
			}
			else{
				//alert("I dont have LI ancestor of DL-Subviewopen");
				
			}
			
			e.currentTarget.addClass('dl-subviewopen');	
		}
		
		else{
			window.location = targ.one('a').getAttribute('href');
		}
		
		
		
	});


	

});
