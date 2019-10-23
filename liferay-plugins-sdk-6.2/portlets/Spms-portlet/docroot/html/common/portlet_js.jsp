<script src="<%= ctxPath %>/html/js/jquery.validate.js" type="text/javascript"></script>
<script type="text/javascript">
	    jQuery(document).ready(function() {
		      jQuery("#fm").validate();
	    });
</script>
<script type="text/javascript">
	if (Liferay.Menu) {
		new Liferay.Menu(
			{
				button: '.lfr-actions',
				trigger: '.lfr-trigger'
			}
		);
	}
</script>
<script type="text/javascript">
	function <portlet:namespace/>checkAll(obj) {
		var items = document.getElementsByName("<portlet:namespace/>deleteItem");
		for (var i=0; i<items.length; i++) {
			items[i].checked = obj.checked;
		}
	}
	function <portlet:namespace/>confirmDel(param) {
		msg = "Are you sure? to delete the record?";
		if (param == "delmultiple") {
			if (<portlet:namespace/>getCheckedCount()==0) {
				jAlert('Select Items to delete.', 'No items are selected !');
			} else {
				msg = "Are you sure? to delete the record(s)?";
				jConfirm(msg, 'Confirmation!', function(r) {
					if (r) {
						document.<portlet:namespace/>fm.submit();
					}
				});
			}
		} else if (param == "del") {
			if (confirm(msg)) {
				document.<portlet:namespace/>fm.submit();
			}
		} else {
			if (confirm(msg)) {
				document.<portlet:namespace/>fm.action = document.<portlet:namespace/>fm.action + "&deleteItem=" + param;
				document.<portlet:namespace/>fm.submit();
			}
		}
	}
	function <portlet:namespace/>checkAllRev() {
		var items = document.getElementsByName("<portlet:namespace/>deleteItem");
		size = items.length;
		if (size == <portlet:namespace/>getCheckedCount()) {
			document.<portlet:namespace/>fm.<portlet:namespace/>check.checked = true;
		} else {
			document.<portlet:namespace/>fm.<portlet:namespace/>check.checked = false;
		}
	}
	function <portlet:namespace/>getCheckedCount() {
		var items = document.getElementsByName("<portlet:namespace/>deleteItem");
		checkedCount=0;
		for (i=0; i< items.length; i++)
		{
	        if (items[i].checked)
	        {
	        	checkedCount += 1;
	        }
		}
		return checkedCount;
	}

</script>