<!-- Piwik -->
<script type="text/javascript">
  var _paq = _paq || [];
  _paq.push(['setUserId', '${themeDisplay.getUser().getScreenName()}']);
  _paq.push(['setCustomVariable',1,'spUserId','${themeDisplay.getUser().getUserId()}']);
  _paq.push(['trackPageView']);
  _paq.push(['enableLinkTracking']);
  _paq.push(['trackAllContentImpressions']);
  _paq.push(['enableHeartBeatTimer']);
  (function() {
    var u="//analytics.menariniapac.com/";
    _paq.push(['setTrackerUrl', u+'piwik.php']);
    _paq.push(['setSiteId', 1]);
    var d=document, g=d.createElement('script'), s=d.getElementsByTagName('script')[0];
    g.type='text/javascript'; g.async=true; g.defer=true; g.src=u+'piwik.js'; s.parentNode.insertBefore(g,s);
  })();
</script>
<noscript><p><img src="//analytics.menariniapac.com/piwik.php?idsite=1amp;rec=1amp;uid=${themeDisplay.getUser().getScreenName()}" style="border:0;" alt="Analytics" /></p></noscript>
<!-- End Piwik Code -->
