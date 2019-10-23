function IndividualRatings(initObj){

	this.initialize = function (){
		AUI().use('aui-rating','aui-node','aui-base','aui-io-request', function(A) {
			// Initially hide this link, once ratings fetches from server using ajax it will be enabled.
			hide(A.one("#" + AVG_IND_RATING_BUTTON));
			if(ratingPermisson){
				A.one("#" + RATE_IT_BUTTON).on("click",function(){
					showRatings();
				});
				A.one("#" + RATINGS_MAIN_DIV_ID + " .closePop").on("click",function(){
					// Click
					//processAvgRatings(RENDER_ATTR_AVG_RATING);
					hide(A.one("#" + RATINGS_MAIN_DIV_ID));
				});
			}
			A.one("#" + AVG_IND_RATING_BUTTON).on("click",function(){
				// Click
				processAvgRatings(RENDER_ATTR_AVG_RATING);
			});
			A.one("#" + ATTR_AVG_MODEL_CONTAINER_ID + " .closePop").on("click",function(){
				// Click
				//processAvgRatings(RENDER_ATTR_AVG_RATING);
				hide(A.one("#" + ATTR_AVG_MODEL_CONTAINER_ID));
			});
		});
		try {
			processAvgRatings(RENDER_OVERALL_RATING);
		} catch (err) {console.log(err);}
	}
	
	function hoverEffect(){
			AUI().use('aui-rating','node', function(A) {
			
			var ratingWrap = A.one('.ratingsSection_wrap');
			ratingWrap.on('hover', rw_in, rw_out);
			
			function rw_in(e){
				var targ = e.currentTarget;
				targ.one('.rs_items').addClass('active');
			}
			function rw_out(e){
				var targ = e.currentTarget;
				targ.one('.rs_items').removeClass('active');
				//targ.one('.rs_items').addClass('fadeOutUp');
			}
		});
	}
	function processAvgRatings(action){
		AUI().use('aui-rating','aui-node','aui-base','aui-io-request', function(A) {
			var formJson = {
					objId:organization.organizationId,
					sp_p_auth: getAuthToken()
			};
			formJson.action = 'getAllAvgRatings';
			var ajaxObj = {
					ajaxUrl: ajaxUrl,
					data:formJson,
					afterReceivingData: function(data){
						if(data.status == spUtilities.SUCCESS){
							if(action == RENDER_OVERALL_RATING){
								renderOverallAvgRating(data);
							}else if(action == RENDER_ATTR_AVG_RATING){
								renderAvgRatings(data);
							}
						}
					}
			};
			spUtilities.actionUsingAjax(ajaxObj);
		});
	}
	function renderStars(ratingValue,ul){
		AUI().use('aui-rating','aui-node','aui-base','aui-io-request', function(A) {
			ratingValue = ratingValue ? ratingValue : 0 ;
			starCount =  MAX_STARS;
			if(ul){
				var renderStarCount = 0;
				for(var j=1 ; j <= ratingValue; j++){
					var li = A.Node.create("<li></li>");
					li.addClass(CLASS_STAR_FULL);
					li.appendTo(ul);
					renderStarCount = renderStarCount + 1;
				}
				if(Math.floor(ratingValue) != ratingValue){
					var fraction = ratingValue- Math.floor(ratingValue);
					var starClass = "r-25";
					if(fraction >= 0.4 && fraction <0.6){
						starClass = CLASS_STAR_HALF;
					}else if(fraction >= 0.6){
						starClass = "r-75"
					}
					var li = A.Node.create("<li></li>");
					li.addClass(starClass);
					li.appendTo(ul);
					renderStarCount = renderStarCount + 1;
				}
				if(renderStarCount < starCount ){
					for(var j=renderStarCount + 1 ; j <= starCount; j++){
						var li = A.Node.create("<li></li>");
						li.addClass(CLASS_STAR_EMPTY);
						li.appendTo(ul);
					}
				}
			}
			
		});
	}
	 function show(node){
		if(node){
			node.removeClass('hide-content');
			node.addClass('show-block');
		}
	}
	function hide(node){
		if(node){
			node.removeClass('show-block');
			node.addClass('hide-content');
		}
	}
	function showRatings(){
		
		AUI().use('aui-rating','aui-node','aui-base','aui-io-request', function(A) {
			show(A.one('#' + RATINGS_MAIN_DIV_ID));
			var formJson = {
					objId:organization.organizationId,
					sp_p_auth: getAuthToken()
			};
			formJson.action = 'getRatingsForObj';
			var ajaxObj = {
					ajaxUrl: ajaxUrl,
					data:formJson,
					afterReceivingData: function(data){
						if(data.status == spUtilities.SUCCESS){
							renderRatings(data.items);
							show(A.one('#'+RATINGS_DISPLAY_DIV_ID));
							fetchAndShowRatings();
							
						}else{
							hide(A.one('#'+RATINGS_DISPLAY_DIV_ID));
						}
					}
			};
			spUtilities.actionUsingAjax(ajaxObj);
		});
	}
	
	function fetchAndShowRatings(){
		
		AUI().use('aui-rating','aui-node','aui-base','aui-io-request', function(A) {
			var displayRatingsUlDiv= A.one('#'+DETAIL_CONTENT_WRAP);
			displayRatingsUlDiv.all("div").remove();
			var formJson = {
					objId:organization.organizationId,
					sp_p_auth: getAuthToken()
			};
			formJson.action = 'getRatingsForObj';
			var ajaxObj = {
					ajaxUrl: ajaxUrl,
					data:formJson,
					afterReceivingData: function(data){
						if(data.status == spUtilities.SUCCESS){
							for(var r=0;r<data.items.length;r++){
								if(data.items[r].value!=0){
									var tempDiv=A.Node.create("<div class='aveRating stars'><div>"+data.items[r].ratingAttrname+"</div></div>");
									var tempDivUl=A.Node.create("<ul></ul>");
									tempDivUl.appendTo(tempDiv);
									tempDiv.appendTo(displayRatingsUlDiv);
									renderStars(data.items[r].value, tempDivUl);
								}
								
							}
						}else{
							//showMsgs(data.msgs);
						}
					}
			};
			spUtilities.actionUsingAjax(ajaxObj);
		});
	}
	
	
	function renderAvgRatings(data){
		AUI().use('aui-rating','aui-node','aui-base','aui-io-request', function(A) {
			//A.one("#" + ATTR_AVG_MODEL_CONTAINER_ID).addClass('show-block');
			show(A.one("#" + ATTR_AVG_MODEL_CONTAINER_ID));
			//A.one("#" + ATTR_AVG_DIV_ID).siblings().remove();
			A.one("#" + ATTR_AVG_CONTAINER_ID).all("*").remove();
			//A.one("#" + ATTR_AVG_DIV_ID).addClass('showAttr');
			if(data){
				//var overAllUl = A.one("#" + OVERALL_RATING_STARS_DIV_ID + " ul");
				//var overAllRatDiv = A.one("#" + OVERALL_RATING_DIV_ID);
				var totalAvgRating = data.avgRating;
				if(totalAvgRating){
					if(totalAvgRating >= 0){
						//overAllRatDiv.setContent(totalAvgRating);
						//renderStars(totalAvgRating,overAllUl);
						if(data.items && data.items.length > 0 ){
							var cloneConfig = {
									nodeId: ATTR_AVG_DIV_ID ,
									targetNodeId: ATTR_AVG_CONTAINER_ID,
									dontusePrefix: true
							};
							for(var i = 0, tol = data.items.length; i < tol ; i++ ){
								var item = data.items[i];
								spUtilities.cloneNode(cloneConfig);
								var dup = cloneConfig.clonedNode;
								var span = dup.one("#" + ATTR_NAME_SPAN_ID);
								span.setContent(item.ratingAttrname);
								var ul = dup.one("ul");
								if(item.avgRating){
									renderStars(item.avgRating,ul);
								}else{
									renderStars(-1,ul);
								}
							}
						}
					}else{
						//renderStars(totalAvgRating,overAllUl);
						//overAllRatDiv.setContent("No ratings yet");
					}
				}else{
					//renderStars(-1,overAllUl);
					//overAllRatDiv.setContent("No ratings yet");
				}
				
			}
		});
	}
	function renderOverallAvgRating(data){
		AUI().use('aui-rating','aui-node','aui-base','aui-io-request', function(A) {
			var avgRatingsLink = A.one("#" + AVG_IND_RATING_BUTTON);
			if(data){
				var overAllUl = A.one("#" + OVERALL_RATING_STARS_DIV_ID + " ul");
				overAllUl.all("li").remove();
				var overAllRatDiv = A.one("#" + OVERALL_RATING_DIV_ID);
				var totalAvgRating = data.avgRating;
				if(totalAvgRating){
					if(totalAvgRating >= 0){
						show(A.one('#'+RATINGS_DISPLAY_DIV_ID));
						fetchAndShowRatings();
						show(avgRatingsLink);
						overAllRatDiv.setContent(totalAvgRating);
						overAllRatDiv.removeClass('noRatingsYet');
						A.one("#" + AVG_IND_RATING_BUTTON + "Hide").addClass('hide');
						renderStars(totalAvgRating,overAllUl);
						overAllRatDiv.addClass('aveValue');
					}else{
						hide(A.one('#'+RATINGS_DISPLAY_DIV_ID));
						overAllRatDiv.removeClass('aveValue');
						overAllRatDiv.addClass('noRatingsYet');
						overAllRatDiv.setContent("");
						hide(avgRatingsLink);
						
					}
				}else{
					hide(A.one('#'+RATINGS_DISPLAY_DIV_ID));
					overAllRatDiv.removeClass('aveValue');
					overAllRatDiv.addClass('noRatingsYet');
					overAllRatDiv.setContent("");
					hide(avgRatingsLink);
				}
			}else{
				hide(avgRatingsLink);
			}
		});
	}
	
	function renderRatings(ratings) {

		AUI().use('aui-rating', 'aui-node', 'aui-base', 'aui-io-request',
				function(A) {
					//A.one("#" + RATING_SAMPLE_DIV_ID).siblings().remove();
					A.one("#" + RATINGS_DIV_ID).all("*").remove();
					var cloneConfig = {
							nodeId: RATING_SAMPLE_DIV_ID ,
							targetNodeId: RATINGS_DIV_ID,
							dontusePrefix: true
					};
					if (ratings && ratings.length > 0) {
						for (var i = 0, tol = ratings.length; i < tol; i++) {
							var ratingData = ratings[i];
							spUtilities.cloneNode(cloneConfig);
							var rval = ratingData.value ? (ratingData.value) : -1;
							var rating = new A.StarRating({
								boundingBox : '#' + cloneConfig.clonedNode.get('id'),
								size : 5,
								disabled : false,
								label : ratingData.ratingAttrname,
								rdata : ratingData,
								defaultSelected : rval
							}).render();
							//rating.set('value',rval);
							//rating.fillTo(rval);
							
							//rating.robj = ratings[i];
							// rating.fillTo()
							rating.on('click', function(event,d1,d2,d3,d4) {
								if(d4){
									//alert(ratingData.ratingAttrId);
								}
								var instance = event.target;
								var title = instance.get('title');
								var stars = instance.get('value');
								if(event.target._originalConfig){
									if(event.target._originalConfig.rdata){
										var rdata = event.target._originalConfig.rdata;
										//alert(rdata.ratingAttrId);
										var formJson = {
												ratingAttrId:rdata.ratingAttrId,
												value: stars + 1,
												objId: rdata.objId,
												action: 'saveAttrRate',
												sp_p_auth: getAuthToken()
										}
										var ajaxObj = {
												ajaxUrl: ajaxUrl,
												data:formJson,
												afterReceivingData: function(data){
													if(data.status == spUtilities.SUCCESS){
														if(data.avgRatings){
															renderOverallAvgRating(data.avgRatings);	
														}
														//renderRatings(data.items);
														//alert(data[SUCCESS_MSG]);
													}else{
														//showMsgs(data.msgs);
													}
												}
										};
										spUtilities.actionUsingAjax(ajaxObj);
									}
								}
							},ratingData);

						}
					}
				});
	}
	
/*
 * function hoverOnStars(){ AUI().use('aui-rating','node', function(A) { var
 * ratingWrap = A.one('.ratingsSection_wrap'); ratingWrap.on('hover', rw_in,
 * rw_out); function rw_in(e){ var targ = e.currentTarget;
 * targ.one('.rs_items').addClass('active'); } function rw_out(e){ var targ =
 * e.currentTarget; targ.one('.rs_items').removeClass('active');
 * //targ.one('.rs_items').addClass('fadeOutUp'); } }); }
 */
	function _construct(initObj){
		pns = initObj.pns;
		ajaxUrl = initObj.ajaxUrl;
		ratingPermisson = initObj.ratingPermisson;
		RATE_IT_BUTTON = pns + RATE_IT_BUTTON;
		RATINGS_DIV_ID = pns + RATINGS_DIV_ID;
		RATINGS_MAIN_DIV_ID = pns + RATINGS_MAIN_DIV_ID;
		RATING_SAMPLE_DIV_ID = pns + RATING_SAMPLE_DIV_ID;
		OVERALL_RATING_DIV_ID = pns + OVERALL_RATING_DIV_ID;
		ATTR_AVG_DIV_ID = pns + ATTR_AVG_DIV_ID;
		ATTR_NAME_SPAN_ID = pns + ATTR_NAME_SPAN_ID;
		OVERALL_RATING_STARS_DIV_ID = pns + OVERALL_RATING_STARS_DIV_ID;
		ATTR_AVG_CONTAINER_ID = pns + ATTR_AVG_CONTAINER_ID;
		AVG_IND_RATING_BUTTON = pns + AVG_IND_RATING_BUTTON;
		ATTR_AVG_MODEL_CONTAINER_ID = pns + ATTR_AVG_MODEL_CONTAINER_ID;
	}
	var RATE_IT_BUTTON = "rateItButton";
	var RATINGS_DIV_ID = "ratingsDiv";
	var RATINGS_DISPLAY_DIV_ID="detailedRatingDiv";
	var DETAIL_CONTENT_WRAP="detailContentWrap";
	var RATINGS_MAIN_DIV_ID = "ratingsMainDiv";
	var RATING_SAMPLE_DIV_ID = "sampleRateDiv";
	var ATTR_AVG_MODEL_CONTAINER_ID = "attrAvgModelContainer";
	var OVERALL_RATING_DIV_ID = "overallRating";
	var ATTR_AVG_DIV_ID = "attrAvg";
	var ATTR_AVG_CONTAINER_ID = "attrAvgContainer";
	var ATTR_NAME_SPAN_ID = "attrNameSpan";
	var pns;
	var ajaxUrl;
	var CLASS_STAR_FULL = "r-full";
	var CLASS_STAR_EMPTY = "r-off";
	var CLASS_STAR_HALF = "r-half";
	var OVERALL_RATING_STARS_DIV_ID = "overallRatingStars";
	var AVG_IND_RATING_BUTTON = "avgIndRatingsButton";
	var MAX_STARS = 5;
	var RENDER_OVERALL_RATING = "renderOverAllRating";
	var RENDER_ATTR_AVG_RATING = "renderAttrAvgRating";

	// Object uuid will be received from other portlet 
	var objId ;
	var ratingPermisson;
	_construct(initObj);
}
