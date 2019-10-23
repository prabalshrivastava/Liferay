function onchangeVocs(ajaxurl){
	AUI().use('aui-node','aui-base','aui-io-request-deprecated',function(A){
		var vocsId = "#feedSearchVocId";
		A.one(vocsId).on("change",fillCats,null,ajaxurl);
	});
}

function fillCats(event,ajaxurl,feedSearchCatId){
	AUI().use('aui-node','aui-base','aui-io-request-deprecated',function(A){
		A.all("#feedSearchCatId option").remove();
		var vocsId = "#feedSearchVocId";
		var selectedId = A.one(vocsId).get('value');
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
						var catObj ;
						for (var i=0; i<items.length; i++) {
							catObj = items[i];
							var opnode = A.Node.create("<option value='" + catObj.id +"'>" + catObj.value + "</option>");
							catDd.append(opnode);
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
	AUI().use('aui-node','aui-base',function(A) {
		var opt = A.one("#custom");
		if (opt && opt.get('checked')) {
			A.one("#criteriaDiv").setStyle("display","inline");
			A.one("#cdDiv").setStyle("display","none");
		}else {
			A.one("#criteriaDiv").setStyle("display","none");
			A.one("#cdDiv").setStyle("display","inline");
		}
	});
}
