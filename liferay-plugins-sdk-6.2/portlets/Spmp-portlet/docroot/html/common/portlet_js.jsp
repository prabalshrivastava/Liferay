<script src="<%= ctxPath %>/html/js/jquery-1.3.2.js" type="text/javascript"></script>
<script src="<%= ctxPath %>/html/js/jquery.validate.js" type="text/javascript"></script>
<script src="<%= ctxPath %>/html/js/jquery.jeditable.js" type="text/javascript"></script>

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
		msg = "Are you sure to delete the record?";
		if (param == "delmultiple") {
			if (<portlet:namespace/>getCheckedCount()==0) {
				jAlert('Select Items to delete.', 'No items are selected !');

			} else {
				msg = "Are you sure to delete the record(s)?";

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

function <portlet:namespace/>addonconfirmDel(param) {
		msg = "Are you sure? to delete the record?";
		if (param == "delmultiple") {
			if (<portlet:namespace/>getCheckedCount()==0) {
				jAlert('Select Items to delete.', 'No items are selected !');

			} else {
				msg = "Are you sure? to delete the record(s)?";

				jConfirm(msg, 'Confirmation!', function(r) {
					if (r) {
						document.<portlet:namespace/>addonfm.submit();
					}
				});

			}
		} else if (param == "del") {
			if (confirm(msg)) {
				document.<portlet:namespace/>addonfm.submit();
			}
		} else {
			if (confirm(msg)) {
				document.<portlet:namespace/>addonfm.action = document.<portlet:namespace/>addonfm.action + "&deleteItem=" + param;
				document.<portlet:namespace/>addonfm.submit();
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

function <portlet:namespace/>addoncheckAllRev() {
	var items = document.getElementsByName("<portlet:namespace/>deleteItem");
	size = items.length;
	if (size == <portlet:namespace/>getCheckedCount()) {
		document.<portlet:namespace/>addonfm.<portlet:namespace/>check.checked = true;
	} else {
		document.<portlet:namespace/>addonfm.<portlet:namespace/>check.checked = false;
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

/* delete service component */

function clickService(_this,rowData) {
	if (_this.checked) {
		var r = confirm("Are you sure to remove this?");

		if (r) {

			var temp = _this.value;
				removeRow(temp);

			var indexForRemoveData;
			for (i=0;i<existingService.length;i++) {

				if (existingService[i]==rowData) {

					indexForRemoveData=i;
				}
			}

			existingService.splice(indexForRemoveData, 1);

		}else {
			_this.checked=false;
		}
	}
}

function removeServiceGroup(_this,removeDataGroup) {
	if (_this.checked) {
		var r = confirm("Are you sure to remove this?");

		if (r) {

			var temp = _this.value.split("&&&");

			for (i=1;i<temp.length;i++) {
				removeRow(temp[i]);
			}
			var indexForRemoveData;
			for (i=0;i<existingGroups.length;i++) {
				if (existingGroups[i]==removeDataGroup) {
					indexForRemoveData=i;

				}
			}

			existingGroups.splice(indexForRemoveData, 1);

		}else {
			_this.checked=false;
		}

	}

}

function clickPromotionCode(_this,id) {

	if (_this.checked) {
		var r = confirm("Are you sure to remove this?");

		if (r) {

			var temp = _this.value;
				removeRow(id);

		}else {
			_this.checked=false;
		}
	}
}

function removeRow(id) {
	  var tr = document.getElementById(id);
	  if (tr) {
	    if (tr.nodeName == 'TR') {
	      var tbl = tr;
	      while (tbl != document && tbl.nodeName != 'TABLE') {
	        tbl = tbl.parentNode;
	      }

	      if (tbl && tbl.nodeName == 'TABLE') {
	        while (tr.hasChildNodes()) {
	          tr.removeChild( tr.lastChild );
	        }
	      tr.parentNode.removeChild( tr );
	      }
	    } else {
	      jAlert( 'Specified document element is not a TR. id=' + id );
	    }
	  } else {
	    jAlert( 'Specified document element is not found. id=' + id );
	  }
}

/* validation for numeric field*/

function alfanumaricVal(e) {
var key;
var keychar;
document.<portlet:namespace/>fm.savebutton.disabled = false;
if (window.event)
key = window.event.keyCode;
else if (e)
key = e.which;
else
return true;
keychar = String.fromCharCode(key);
keychar = keychar.toLowerCase();
// control keys
if ((key==null) || (key==0) || (key==8) || (key==9) || (key==13) || (key==27) || (key==46) )
return true;
// numbers
else if ((("0123456789").indexOf(keychar) > -1))
return true;
else
return false;
}

function dotCheckFunction(dotValue,field) {

	var checkDot = dotValue.split(".");
	if (checkDot.length>2) {
		jAlert('Please fill the proper format (e.g, xxx.xx)', 'Wrong Format!');
		return false;
	}else {
	if (field == "discount") {
	if (checkDot > 100) {
	jAlert('Discount cannot be greater than 100%');
	mkreturn = "false";
	}else {
	mkreturn = "true";
	}
	}else {
	return true;
	}
if (mkreturn == "true") {
		return true;
		}
	}
}

/*function dotCheckFunction(dotValue) {

	var checkDot = dotValue.split(".");
	if (checkDot.length>2) {
		jAlert('Please fill the proper format (e.g, xxx.xx)', 'Wrong Format!');

		return false;
	}else {
		return true;
	}
}*/

//Date Check Function
function promotionDateStartEndValidate() {
/* var monthFrom=document.getElementById("<portlet:namespace/>promotionFrom_month").value;
	var dayFrom=document.getElementById("<portlet:namespace/>promotionFrom_day").value;
	var yearFrom=document.getElementById("<portlet:namespace/>promotionFrom_year").value;

	var monthTo=document.getElementById("<portlet:namespace/>promotionTo_month").value;
	var dayTo=document.getElementById("<portlet:namespace/>promotionTo_day").value;
	var yearTo=document.getElementById("<portlet:namespace/>promotionTo_year").value;
*/
	var valid = true;

	promotionLoop :
	for (i=0;i<=countRowForPromotionCode;i++) {
		var promoCode = "promotionCode"+i;

		try{
		var promotionCode = document.getElementById("promotionCode"+i).value;

		if (promotionCode!=null) {

			if (promotionCode!="") {

				var promotionFrom = document.getElementById("promotionFrom"+i).value;
				var promotionTo = document.getElementById("promotionTo"+i).value;
				var promotionDiscount = document.getElementById("discount"+i).value;

				if (promotionDiscount==null) {
					jAlert("Please insert discount %");
					valid =false;
					break promotionLoop;
				}
				if (promotionDiscount=="") {
					jAlert("Please insert discount %");
					valid =false;
					break promotionLoop;
				}
				if (promotionFrom==null || promotionTo==null) {
					jAlert("Promotion Start Date and Promotion End Date must not empty!");
					valid =false;
					break promotionLoop;
				}
				if (promotionFrom=="" && promotionTo=="") {
					jAlert("Promotion Start Date and Promotion End Date must not empty!");
					valid =false;
					break promotionLoop;
				}
				try{
				var proFromArr = promotionFrom.split("/");
				var proToArr = promotionTo.split("/");

				if (proFromArr.length!=3 || proToArr.length!=3) {
					jAlert("Enter Valid Promotion Start Date and Promotion End Date");
					valid =false;
					break promotionLoop;
				}

				var monthFrom=proFromArr[1]-1;
				var dayFrom=proFromArr[0];
				var yearFrom=proFromArr[2];

				var monthTo=proToArr[1]-1;
				var dayTo=proToArr[0];
				var yearTo=proToArr[2];

				var startDate = new Date(yearFrom,monthFrom,dayFrom);
				var endDate = new Date(yearTo,monthTo,dayTo);

				if (startDate > endDate) {
				alert("startDate , end date validation");
					jAlert("Promotion Start Date must be earlier than Promotion End Date");
					return false;
				}
				}catch(e) {
					jAlert("Please insert Promotion Start Date, Promotion End Date ");
					return false;
				}
			}
		}

	}catch(exe) {

	}

	var chkstartDate = startDate;
	var chkendDate = endDate;
	var chkCode = promotionCode;
for (j=0;j<countRowForPromotionCode;j++) {
	var pCode = "promotionCode"+j;
	var pFrom = document.getElementById("promotionFrom"+j).value;
	var pTo = document.getElementById("promotionTo"+j).value;
	var promoName = document.getElementById("promotionCode"+j).value;

	var pFromArr = pFrom.split("/");

	var pToArr = pTo.split("/");

	var monthFrom=pFromArr[1]-1;
	var dayFrom=pFromArr[0];
	var yearFrom=pFromArr[2];
	var monthTo=pToArr[1]-1;
	var dayTo=pToArr[0];
	var yearTo=pToArr[2];

	var chkSDate = new Date(yearFrom,monthFrom,dayFrom);
	var chkTDate = new Date(yearTo,monthTo,dayTo);
if (promoCode != pCode) {
		if (chkCode == promoName) {
		/*if (!(((chkstartDate > chkSDate) || (chkstartDate < chkSDate)) || ((chkendDate > chkTDate) || (chkendDate < chkTDate)))) {
		//if (chkendDate > chkSDate){*/
		if (((chkstartDate > chkSDate) || (chkstartDate < chkSDate) || (!((chkstartDate > chkSDate) || (chkstartDate < chkSDate)))) && (chkstartDate < chkTDate)) {
			jAlert("Promotion Code with same name is not allowed for the same period.");
			valid = false;
			}
	}
}
}
	}

	return valid;
}

var dtCh= "/";
var minYear=1900;
var maxYear=2100;

function isInteger(s) {
	var i;
	for (i = 0; i < s.length; i++) {
		// Check that current character is number.
		var c = s.charAt(i);
		if (((c < "0") || (c > "9"))) return false;
	}
	// All characters are numbers.
	return true;
}

function stripCharsInBag(s, bag) {
	var i;
	var returnString = "";
	// Search through string's characters one by one.
	// If character is not in bag, append to returnString.
	for (i = 0; i < s.length; i++) {
		var c = s.charAt(i);
		if (bag.indexOf(c) == -1) returnString += c;
	}
	return returnString;
}

function daysInFebruary (year) {
	// February has 29 days in any year evenly divisible by four,
	// EXCEPT for centurial years which are not also divisible by 400.
	return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}
function DaysArray(n) {
	for (var i = 1; i <= n; i++) {
		this[i] = 31
		if (i==4 || i==6 || i==9 || i==11) {this[i] = 30}
		if (i==2) {this[i] = 29}
}
return this
}

function isDate(dtStr) {
	var daysInMonth = DaysArray(12)
	var pos1=dtStr.indexOf(dtCh)
	var pos2=dtStr.indexOf(dtCh,pos1+1)
	var strDay=dtStr.substring(0,pos1)
	var strMonth=dtStr.substring(pos1+1,pos2)
	var strYear=dtStr.substring(pos2+1)
	strYr=strYear
	if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1)
	if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1)
	for (var i = 1; i <= 3; i++) {
		if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
	}
	month=parseInt(strMonth)
	day=parseInt(strDay)
	year=parseInt(strYr)

	if (dtStr != "") {
	if (pos1==-1 || pos2==-1) {
		jAlert("The date format should be : mm/dd/yyyy")
		return false
	}
	if (strMonth.length<1 || month<1 || month>12) {
		jAlert("Please enter a valid month")
		return false
	}
	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]) {
		jAlert("Please enter a valid day")
		return false
	}
	if (strYear.length != 4 || year==0 || year<minYear || year>maxYear) {
		jAlert("Please enter a valid 4 digit year between "+minYear+" and "+maxYear)
		return false
	}
	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false) {
		jAlert("Please enter a valid date")
		return false
	}
	}
return true
}

function ValidateForm(dateId) {
	var dt=document.getElementById(dateId);
	if (isDate(dt.value)==false) {
		dt.focus()
		return false
	}
	return true
}

function validateDate(dateId) {
	var validateform = ValidateForm(dateId);
	if (!validateform) {
		jAlert("Please enter a Valid Date");
	}
}
</script>