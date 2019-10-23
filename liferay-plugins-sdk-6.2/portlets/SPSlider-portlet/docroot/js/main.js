function onchangeVocs(ajaxurl) {
	AUI().use('aui-node','aui-base','aui-io-request-deprecated',function(A) {
		var vocsId = "#feedSearchVocId";
		A.one(vocsId).on("change",fillCats,null,ajaxurl);
	});
}

function fillCats(event,ajaxurl,feedSearchCatId) {
	AUI().use('aui-node','aui-base','aui-io-request-deprecated',function(A) {
		A.all("#feedSearchCatId option").remove();
		/*var feedSearchSel = document.getElementById("feedSearchCatId");
		//alert("feedSearchSel " + feedSearchSel);
		var length = feedSearchSel.options.length;
		for (s = 0; s < length; s++) {
			feedSearchSel.remove(s);
			//alert("feedSearchSel s " + s);
		}*/
		//alert("1");
		var vocsId = "#feedSearchVocId";
		var selectedId = A.one(vocsId).get('value');
		//alert("2");
		A.io.request(ajaxurl,{
			dataType : 'json',
			method : 'POST',
			data : {
				action: 'getCats',
				vocId: selectedId
			},
			on : {
				success : function() {
					var data = this.get('responseData');
					var items = data.items;
					var catsId = "#feedSearchCatId";
					var catDd = A.one(catsId);
					if (items) {
						var catObj;
						for (var i=0; i<items.length; i++) {
							catObj = items[i];
							if (catObj.isChild == "true") {
								var opnode = A.Node.create("<option value='" + catObj.id +"'>" + "---" + catObj.value + "</option>");
								catDd.append(opnode);
							}else {
								var opnode = A.Node.create("<option value='" + catObj.id +"'>" + catObj.value + "</option>");
								catDd.append(opnode);
							}
						}
					}
					if (feedSearchCatId) {
						setCatgSelected(feedSearchCatId);
					}
				}
			}
		});

	});

}
function setCatgSelected(selectedCat) {
	AUI().use('aui-node','aui-base',function(A) {
		var opt = A.one("#feedSearchCatId option[value=" + selectedCat + "]" );
		if (opt) {
			opt.set("selected","true");
		}
	});
}

function criteriaClickListener() {
	AUI().use('aui-node','aui-base',function(A) {
		var opt = A.one("#custom");
		opt.on("click",showHideCriteriaDiv);
		var cd = A.one("#countryDeparment");
		cd.on("click",showHideCriteriaDiv);

		var cd1 = A.one("#cdDiv");
		cd1.on("click",showHideCriteriaDiv);
	});
}
function showHideCriteriaDiv() {
	var defaultCategory = document.getElementById("countryDeparment");
	var categoryDiv = document.getElementById("categoryListDiv");
	if (defaultCategory.checked) {
		categoryDiv.style.display = "block";
	}else {
		categoryDiv.style.display = "none";
	}
	//document.getElementById("asset-existing-list").innerHTML="";
	setTimeout(
	AUI().use('aui-node','aui-base',function(A) {
		var opt = A.one("#custom");
		if (opt && opt.get('checked')) {
			A.one("#criteriaDiv").setStyle("display","inline");
			A.one("#cdDiv").setStyle("display","none");
		}else {
			A.one("#criteriaDiv").setStyle("display","none");
			A.one("#cdDiv").setStyle("display","inline");
		}
	}),1000
	);
}