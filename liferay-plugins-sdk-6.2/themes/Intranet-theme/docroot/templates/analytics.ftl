<!-- Piwik -->
<script type="text/javascript">
  var _paq = _paq || [];
  _paq.push(["setDomains", ["*.www.lithan.com"]]);
  _paq.push(['setUserId', '${themeDisplay.getUser().getEmailAddress()}']);
  _paq.push(['setCustomVariable',1,'spUserId','${themeDisplay.getUser().getUserId()}']);
  _paq.push(['trackPageView']);
  _paq.push(['enableLinkTracking']);
  _paq.push(['trackAllContentImpressions']);
  _paq.push(['enableHeartBeatTimer']);
  (function() {
    var u="//analytics.sambaash.com/";
    _paq.push(['setTrackerUrl', u+'piwik.php']);
    _paq.push(['setSiteId', '4']);
    var d=document, g=d.createElement('script'), s=d.getElementsByTagName('script')[0];
    g.type='text/javascript'; g.async=true; g.defer=true; g.src=u+'piwik.js'; s.parentNode.insertBefore(g,s);
  })();
</script>
<noscript><p><img src="//analytics.sambaash.com/piwik.php?idsite=4;rec=1amp;userId=${themeDisplay.getUser().getEmailAddress()}" style="border:0;" alt="Analytics" /></p></noscript>
<!-- End Piwik Code -->
