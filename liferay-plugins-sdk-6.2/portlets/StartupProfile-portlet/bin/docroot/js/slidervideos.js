function initVideos() {
	AUI().use('aui-node','aui-base',function(A){
		var videos = A.all(".video video");
		videos.each(function (video) {
			var player = videojs(video.get('id'), { "controlBar": {
				"fullscreenToggle": false
			  }, "autoplay": false, preload: true }, function() {
				player = this;
			});
			
			// work around to use videojs with ninjaslider
			// if pause button is clicked..an additional event is fired to play the video by ninja slider apart from the event fired by videojs. 
			player.on('pause', function(){
				player.pause();
			});
			
		});
	});
}