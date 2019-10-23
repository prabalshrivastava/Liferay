<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="/html/membershipupgradesubscription/init.jsp" %>

<portlet:defineObjects />

<script type="text/javascript">
AUI().ready('aui-panel', 'anim', 'aui-form-validator', 'aui-overlay-context-panel', 'aui-io-request', function(A)
{
	var packagesJsonString = ${membershipUpgrade.packagesJsonString};
	var items = ${membershipUpgrade.membershipPackageJsonString};
	var mpId = ${membershipUpgrade.membershipPackage.mpId};
	var divPackageDetailsNode = A.one("#divPackageDetails");
	var packageNode = A.one("#<portlet:namespace />memberPackage");
	var _packageNode = document.getElementById("<portlet:namespace />memberPackage");

	document.getElementById("<portlet:namespace />divEmpty").style.display = 'none';
	document.getElementById("<portlet:namespace />divContent").style.display = 'block';

	A.on('domready', function(e)
	{
		initPackageView();
		initMembershipSubsription( items );
	});//end domready

	var packageValue = document.getElementById("<portlet:namespace />memberPackage").value;
	initMembershipSubsriptionList( packageValue );

	function processUpdate()
	{
		var responseValue = null;
		var reqUrl = '<portlet:resourceURL id="" />';
			 A.io.request(reqUrl, {
			 data: {
				 <portlet:namespace />action: "processUpdate"
			 },
		     sync: true,
		     dataType: 'json',
		     on: {
		         success: function() {
		             responseValue = this.get('responseData');
		             fMessageHide();
		             fMessageShow( responseValue );
		          }
		     }
		 });
	}

	var promotionCodeNode = A.one("#<portlet:namespace />promoCode");

	promotionCodeNode.on('change', function(event) {
			validatePromoCode( this.val() );
	});

	promotionCodeNode.on('key', function(event) {
		validatePromoCode( this.val() );
	}, 'down:13');

	function validatePromoCode( code )
	{
		var packageId = document.getElementById("<portlet:namespace />memberPackage").value;

		var responseValue = null;
		var reqUrl = '<portlet:resourceURL id="" />';
			 A.io.request(reqUrl, {
			 data: {
				 <portlet:namespace />action: "validatePromoCode",
				 <portlet:namespace />promoCode: code,
				 <portlet:namespace />packageId: packageId
			 },
		     sync: true,
		     dataType: 'json',
		     on: {
		         success: function() {
		             responseValue = this.get('responseData');

		             fMessageHide();

		             if (responseValue.item == null)
		             {
		            	fMessageShow( responseValue );
		             	initMembershipSubsription( items );
			         } else
		             {
			        	initMembershipSubsription( responseValue );
			         }
		          }
		     }
		 });
		return false;
	}

	var memberPackageNode = A.one("#<portlet:namespace />memberPackage");
		memberPackageNode.on('change', function(event) {
			initMembershipSubsriptionList( this.val() );
			fMessageHide();
			fShowHideDetails();
			promotionCodeNode.val('');
	});

	function initMembershipSubsriptionList( mId )
	{
		var items = null;
		var reqUrl = '<portlet:resourceURL id="" />';
			 A.io.request(reqUrl, {
			 data: {
				 <portlet:namespace />action: "selectSubscriptionList",
				 <portlet:namespace />membershipId: mId
			 },
		     sync: true,
		     dataType: 'json',
		     on: {
		         success: function() {
		        	 items = this.get('responseData');
		             initMembershipSubsription(items);
		          }
		     }
		 });
		return items;
	}

	function initMembershipSubsription( items )
	{
		var itemNode = A.one("#divItem");
		var currencyNode = A.one("#divCurrency");
		var priceNode = A.one("#divPrice");
		var discountNode = A.one("#divDiscount");
		var totalNode = A.one("#divTotal");

		itemNode.html(items.item);
		currencyNode.html(items.currency);
		priceNode.html(formatCurrency(items.price));
		discountNode.html(items.discount);
		totalNode.html(formatCurrency(items.total));

		divPackageDetailsNode.html(items.details);
	}

	function initPackageView() {
		for (var key in packagesJsonString) {
			if (packagesJsonString.hasOwnProperty(key))
			{
				var keyValue = key.split('-');
				var _option = new Option(packagesJsonString[key], keyValue[1]);
				if (mpId == parseInt(keyValue[1])) {
					_option.selected = true;
				}

				try {
					_packageNode.add(_option);
				} catch (e) {
					packageNode.append(_option);
				}

			}
		}
	}

	function formatCurrency(amount)
	{
		var i = parseFloat(amount);
		if (isNaN(i)) {
			i = 0.00;
		}

		var minus = '';
		if (i < 0) {
			minus = '-';
		}

		i = Math.abs(i);
		i = parseInt((i + .005) * 100);
		i = i / 100;
		s = new String(i);

		if (s.indexOf('.') < 0) {
			s += '.00';
		}

		if (s.indexOf('.') == (s.length - 2)) {
			s += '0';
		}

		s = minus + s;
		return s;
	}

	fShowHideDetails();
	function fShowHideDetails()
	{
		A.one("#divPackageDetails").hide();
	}

	function fMessageShow( msg )
	{
		A.one("#divMessage").html(msg);
		document.getElementById("divMessage").style.display = 'block';
	}

	function fMessageHide()
	{
		A.one("#divMessage").html("");
		document.getElementById("divMessage").style.display = 'none';
	}

	A.one("#divShowDetails").on('click', function(event) {
		 var _value = this.html();
	     if (_value.indexOf("show") != -1) {
	      	this.html("hide details");
	     } else {
	     	this.html("show details");
	     }
	     A.one("#divPackageDetails").toggle();
	     event.halt();
	});

});

function fReturn(code,e)
{
	if (e.keyCode == 13)
	{
		return false;
	}else
	{
		return true;
	}
}
</script>

<portlet:actionURL var="actionPayment">
	<portlet:param name="action" value="payments" />
</portlet:actionURL>

<portlet:actionURL var="actionCancel">
	<portlet:param name="action" value="cancel" />
</portlet:actionURL>

<form action="${actionPayment}" method="post" name="<portlet:namespace/>fm">
<div class="reg-outer-wrap">
	<div class="reg-content-wrap">
	<!-- upgrade package screen -->
		<h1 class="header-title">Membership Package Upgrade</h1>
			<div id="<portlet:namespace/>divContent" style="display:none;">
			<div style="padding-top: 20px">
			<div class="portlet-msg-error" id="divMessage" style="display:none;"></div>
				<aui:layout cssClass="ms-box-wrapper">
					<div class="content-column-box">
						<div class="left-content-wrapper padding-wrap1">
							<label>Package&nbsp;</label>
							<table class="left-content-col-wrapper">
								<tr class="tblRow">
									<td>
										<select class="select" id="<portlet:namespace/>memberPackage" name="<portlet:namespace />memberPackage"></select>
									</td>
									<td><a class="href-text" id="divShowDetails">show details</a></td>
								</tr>
							</table>
						</div>
						<div class="right-content-wrapper padding-top">
							<div class="column1-wrapper">&nbsp;</div>
							<div class="column2-wrapper">&nbsp;</div>
						</div>
						<div class="right-content-wrapper padding-wrap2">
							<div class="content-column1-wrapper"><label>Promotion Code</label></div>
							<div class="content-column2-wrapper">
								<input class="reg-input-text select" id="<portlet:namespace/>promoCode" onkeypress="return fReturn(this.value,event)" placeholder="Promotion Code" type="text" value="${membershipUpgrade.promotionCode.promotionCode}" />
							</div>
						</div>
					</div>

					<!-- membership details -->
					<div class="details" id="divPackageDetails" style="overflow:auto;"></div>

					<!-- Member ship package screen -->
					<div class="subscription-box-left">
						<div class="ms-row-content padding-top">
							<table>
								<tr>
									<td><div id="divItem"></div></td>
									<td><div>&nbsp;&nbsp;Membership Fees</div></td>
								</tr>
							</table>
						</div>
						<div class="ms-row-content">
							<div class="ms-row-content-label">Currency </div>
							<div class="ms-row-content-value" id="divCurrency"></div>
						</div>
						<div class="ms-row-content">
							<div class="ms-row-content-label">Price </div>
							<div class="ms-row-content-value" id="divPrice"></div>
						</div>
						<div class="ms-row-content">
							<div class="ms-row-content-label">Discount </div>
							<div class="ms-row-content-value" id="divDiscount">0%</div>
						</div>
						<div class="ms-row-content">
							<div class="ms-row-content-label">Net Total </div>
							<div class="ms-row-content-value" id="divTotal"></div>
						</div>
					</div>

				</aui:layout>
			</div>

			<div class="ms-box-wrapper">
				<div style="float: right; padding-top: 10px; padding-right: 10px;">
					<aui:button name="btnUpgrade" type="submit" value="Upgrade" />
					<aui:button name="cancel" onClick="location.href='${actionCancel}'" value="Cancel" />
				</div>
			</div>
		<!-- end of div content -->
		</div>

		<div id="<portlet:namespace/>divEmpty" style="text-align: center; padding: 30px; display: none">
			 	<h2>
			   			No membership package available for Upgrade
			    </h2>
	  		<div style="text-align: right;padding-right:50px;">
	    		<a href="${actionCancel}">home page</a>
	    	</div>
		</div>
	</div>
</div>
<!-- end mike -->
</form>