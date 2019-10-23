<div id="<portlet:namespace />inviteFriendsFacebookContent">

</div>

<script type="text/javascript">

AUI().ready('', function() {

	FB.ui({
	  method: 'send',
	  link: '<%= viewDiscussionsTabURL %>'
	});

});

</script>