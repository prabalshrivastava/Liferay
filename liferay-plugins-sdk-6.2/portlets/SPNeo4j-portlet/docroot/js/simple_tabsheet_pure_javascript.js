function SimpleTabSheet(param) {

	var that = this;

	this.j_tabsheet = null;

	var cur_tab = null;
	var count = 0;

	function __construct(p) {
	try{
		for (pkey in p) {
			if (pkey[0] != "_") {
				that[pkey] = p[pkey];
			}
		}

		initTabSheet();
	}catch(err) {
		console.log(err);
	}
	}

	function initTabSheet() {
	try{
		for (var i=0;i<that.j_tabsheet.length;i++) {
			var j_tab_obj = that.j_tabsheet[i];
			var j_tab = j_tab_obj.j_tab;
			var j_tab_selected_by_default = j_tab_obj.j_tab_selected_by_default;

			j_tab.setAttribute("data-tabsheet-index", i);

			if (j_tab_selected_by_default === true) {
				cur_tab = j_tab;
				showSelectedTab(j_tab);
			}

			if (navigator.appName == 'Microsoft Internet Explorer') {
				addEventHandler(j_tab, "click", tabClick);
			}else {
				j_tab.addEventListener ("click", tabClick, false);
			}

			count++;
		}

	}catch(err) {
		console.log(err);
	}
	}

	function tabClick(e) {
	try{
		e.preventDefault();

		var selected_tab = getEventTarget(e);

		if (cur_tab) {
			if (selected_tab.getAttribute("data-tabsheet-index") === cur_tab.getAttribute("data-tabsheet-index")) {
				//do nothing
			}else {
				//hide current tab
				hideCurrentTab();
				//show select tab
				showSelectedTab(selected_tab);
				cur_tab = selected_tab;
			}
		}else {
			showSelectedTab(selected_tab);
			cur_tab = selected_tab;
		}
	}catch(err) {
		console.log(err);
	}
	}

	function showSelectedTab(selected_tab) {
	try{
		var selected_tab_content = document.getElementById(selected_tab.id + "_content");

		addClass(selected_tab, "active");
		addClass(selected_tab_content, "active");
	}catch(err) {
		console.log(err);
	}
	}

	function hideCurrentTab() {
	try{
		if (cur_tab) {
			var cur_tab_content = document.getElementById(cur_tab.id + "_content");
			removeClass(cur_tab, "active");
			removeClass(cur_tab_content, "active");
		}
	}catch(err) {
		console.log(err);
	}
	}

	__construct(param);

}