/*!
 * jQuery rgbmultiselect plugin v1.0
 *  http://ryan.buterbaugh.org/rgbmultiselect/
 * 
 * Copyright (c) 2010 Ryan Buterbaugh
 *  http://ryan.buterbaugh.org/
 *
 * Dual licensed under the MIT and GPL licenses:
 *   http://www.opensource.org/licenses/mit-license.php
 *   http://www.gnu.org/licenses/gpl.html
 */

(function(jQuery) {

   jQuery.fn.extend({
		 rgbmultiselect: function(prefs) {

		   if (typeof prefs != "undefined") {
		     // if the user has specified a field text format and a threshold
		     // but hasn't specified an alternate field text format for cases
		     // when the number of results to show is less than the threshold,
		     // copy over their field text format instead of using our default
		     if (typeof prefs.fieldTextFormatOnBlurIfLTENumToShow == "undefined" &&
			 typeof prefs.fieldTextFormatOnBlurNumToShow != "undefined" &&
			 prefs.fieldTextFormatOnBlurNumToShow > -1 &&
			 typeof prefs.fieldTextFormatOnBlur != "undefined") {
		       prefs.fieldTextFormatOnBlurIfLTENumToShow = prefs.fieldTextFormatOnBlur;
		     }

		     // if the user doesn't specify max selections, use their help text
		     // as the maxSelections help text if it exists
		     if (typeof prefs.helpText != "undefined" &&
			 typeof prefs.maxSelections == "undefined") {
		       prefs.helpTextMaxSelectionsReached=prefs.helpText;
		     }
		   }

		   prefs = jQuery.extend({}, jQuery.rgbmultiselector.defaults, prefs);

		   return this.each(function() {
				      var myPrefs=prefs;
				      if (!jQuery(this).attr("multiple")) {
					myPrefs.allOptionsExclusive=true;
				      }
				      new jQuery.rgbmultiselector(this, myPrefs);
				    });
		 }
	       });
          
    jQuery.rgbmultiselector = function(input, prefs) {
     var KEY = {
       UP: 38,
       DOWN: 40,
       DEL: 46,
       TAB: 9,
       RETURN: 13,
       ESC: 27,
       COMMA: 188,
       PAGEUP: 33,
       PAGEDOWN: 34,
       BACKSPACE: 8
     };

     var jQuerysSelect=jQuery(input);
     var selectId=jQuerysSelect.attr("id");
     var inputId=selectId+"_rgbmultiselect";
     var optionsId=inputId+"_container";
     var iframeId=inputId+"_iframe";
     var baseCheckboxId=optionsId+"_checkbox";
     var selectWidth=parseInt(jQuerysSelect.outerWidth(),10);
     var leaveFieldTimeout=null;
     var blockSubmit=false;
     var hasFocus=0;
     var keypressTimeout=null;
     var optionsNumMatching=0,optionsOneSelectedMatch=null,optionsOneSelectedMatchType="";
     var optionsKeyboardCurrentId=null,optionsKeyboardCurrentType=null;
     var clearInputField=true;
     var unselectedOriginalHeight=null;

     var jQuerysInput=buildInputField();
     var inputWidth=parseInt(jQuerysInput.width(),10);

     var jQuerysOptions=buildOptionsContainer();
     jQuery(document.body).append(jQuerysOptions);

     var jQuerysIframe=buildIE6Iframe();

     var selectCache=getSelectOptions();
     updateFieldText();

     if (prefs.buildOptionsInBackground) {
       jQuery(document).ready(function() {
			   setTimeout(function() {
					buildOptions();
					// when the page reloads after pressing back, IE sometimes does not
					// have the selected options checked...
					if (jQuery.browser.msie) {
					  jQuerysOptions.find(".jquery_rgbmultiselect_options_selected .jquery_rgbmultiselect_options_item_checkbox").attr("checked","checked");
					}
				      },10);
			 });
     }

     // set up handlers
     // borrowed from jquery autocomplete by Jorn Zaefferer... prevent form submit when pressing enter key in opera
     if (jQuery.browser.opera) {
       jQuery(input.form).bind("submit.rgbmultiselect",
			  function() {
			    if (blockSubmit) {
			      blockSubmit = false;
			      return false;
			    }
			    return true;
			  });
     }

     jQuerysInput.focus(
       function() {
	 hasFocus++;
	 if (leaveFieldTimeout) {
	   clearTimeout(leaveFieldTimeout);
	   leaveFieldTimeout=null;
	 }

	 buildOptions();
	 showOptions();
	 jQuery(this).removeClass("jquery_rgbmultiselect_blurred");
	 if (clearInputField) {
	   clearInputField=false;
	   jQuery(this).val("");
	 }
       }
     );

     jQuerysInput.click(
       function() {
	 hasFocus++;
	 if (hasFocus > 1 && !jQuerysOptions.is(":visible")) {
	   showOptions();
	 }
       }
     );

     jQuerysInput.blur(
       function() {
	 hasFocus=0;
	 leaveFieldTimeout = setTimeout(function() { leaveField(); },200);
       }
     );
     
     jQuerysInput.bind((jQuery.browser.opera ? "keypress" : "keydown") + ".rgbmultiselect",
		  function (e) {
		    hasFocus=1;
		    switch (e.keyCode) {
		      case KEY.ESC:
		        hideOptions();
			break;

		      case KEY.RETURN:
			e.preventDefault();
			blockSubmit = true;
			selectOnEnterAndReset();
		        e.stopPropagation();
			return false;

		      case KEY.UP:
		        if (!jQuerysOptions.is(":visible")) {
			  showOptions();
			} else {
			  keyGo(-1);
			}
		        break;

		      case KEY.DOWN:
		        if (!jQuerysOptions.is(":visible")) {
			  showOptions();
			} else {
			  keyGo(1);
			}
		        break;

		      case KEY.PAGEUP:
		        if (!jQuerysOptions.is(":visible")) {
			  showOptions();
			} else {
			  keyGo(prefs.pageUpDownDistance*-1);
			}
		        break;

		      case KEY.PAGEDOWN:
		        if (!jQuerysOptions.is(":visible")) {
			  showOptions();
			} else {
			  keyGo(prefs.pageUpDownDistance);
			}
		        break;

		      default:
		        if (!jQuerysOptions.is(":visible")) {
			  showOptions();
			}
		        if (keypressTimeout) {
			  clearTimeout(keypressTimeout);
			}
		        keypressTimeout = setTimeout(function() {
						       filterOptions();
						       updateUnselectedHeight();
						       positionOptionsContainer();
						     },10);
			break;
		    }
		  });

     jQuery(window).bind("resize.rgbmultiselect",
		    function() {
		      positionOptionsContainer();
		    });


     // chrome and IE will unfocus the input box when you click the scrollbar, so if
     // the user clicks within the box, refocus on the input box
     jQuery(document).bind("mousedown.rgbmultiselect",
		      function(event) {
			if (jQuerysOptions.is(":visible") && mouseOverObj(jQuerysOptions,event)) {
			  setTimeout(function(){jQuerysInput.focus();},10);
			}
		      });

     function resetKeySelection() {
       if (optionsKeyboardCurrentId !== null) {
	 jQuery("#"+baseCheckboxId+"_"+optionsKeyboardCurrentType+optionsKeyboardCurrentId)
	   .parent().removeClass("jquery_rgbmultiselect_options_item_arrownav_selected");
	 optionsKeyboardCurrentId=optionsKeyboardCurrentType=null;
       }
     }

     function keyGo(num) {
       var options=getAllVisibleOptions();
       if (optionsKeyboardCurrentId === null || (optionsKeyboardCurrentType != "clearlist" && 
						 selectCache[optionsKeyboardCurrentId].filtered)) {
	 resetKeySelection();
	 optionsKeyboardCurrentId=options[0].id;
	 optionsKeyboardCurrentType=options[0].type;
       } else {
	 var curIndex=0;
	 var l=options.length;
	 for (var i=0;i<l;i++) {
	   if (options[i].id == optionsKeyboardCurrentId) {
	     curIndex=i;
	   }
	 }
	 curIndex+=num;
	 if (curIndex < 0) {
	   curIndex+=options.length;
	 } else if (curIndex >= options.length) {
	   curIndex=curIndex % options.length;
	 }
	 resetKeySelection();
	 optionsKeyboardCurrentId=options[curIndex].id;
	 optionsKeyboardCurrentType=options[curIndex].type;
       }
       var checkbox=jQuery("#"+baseCheckboxId+"_"+optionsKeyboardCurrentType+optionsKeyboardCurrentId);
       var parent=checkbox.parent();
       parent.addClass("jquery_rgbmultiselect_options_item_arrownav_selected");
       var firstUn=firstUnselected(options);
       var firstUnselectedOffset=0;
       if (firstUn != "") {
	 firstUnselectedOffset=jQuery("#"+baseCheckboxId+"_unselected"+firstUn).parent().position().top;
       }
       var unselContainer=jQuerysOptions.children(".jquery_rgbmultiselect_options_unselected");
       var scrollOffset=parent.position().top-firstUnselectedOffset-(unselContainer.height()/2);
       if (scrollOffset < 0 || optionsKeyboardCurrentType != "unselected") {
	 scrollOffset=0;
       }
       unselContainer.scrollTop(scrollOffset);
     }

     function firstUnselected(options) {
       var l=options.length;
       for (var i=0;i<l;i++) {
	 if (options[i].type == "unselected") {
	   return options[i].id;
	 }
       }
       return "";
     }

     function lastUnselected(options) {
       var last="";
       var l=options.length;
       for (var i=0;i<l;i++) {
	 if (options[i].type == "unselected") {
	   last=options[i].id;
	 }
       }
       return last;
     }

     // returns a list of all visible options
     function getAllVisibleOptions() {
       var options=[];
       if (prefs.clearAllSelectNoneAvailable) {
	 options.push({id:'',type:'clearlist'});
       }
       var stickyOptions=[];
       var selectedOptions=[];
       var unselectedOptions=[];
       for (var o in selectCache) {
	 if (typeof o == "string" && objTypeNot(o,"default") && !selectCache[o].filtered) {
	   if (objTypeIs(o,"sticky")) {
	     stickyOptions.push({id:o,type:'sticky'});
	   } else if (selectCache[o].selected) {
	     selectedOptions.push({id:o,type:'selected'});
	   } else if (!selectCache[o].selected) {
	     unselectedOptions.push({id:o,type:'unselected'});
	   }
	 }
       }

       return options.concat(stickyOptions,selectedOptions,unselectedOptions);
     }

     function filterOptions() {
       var str=jQuery.trim(jQuerysInput.val());
       var strParts=str.split(/ +/);
       if (optionsNumMatching == 1) {
	 optionsOneSelectedMatch.parent().removeClass("jquery_rgbmultiselect_options_item_singlefiltered");
	 var value=getItemId(optionsOneSelectedMatch,optionsOneSelectedMatchType);
	 selectCache[value].filtered=false;
       }
       optionsNumMatching=0;
       for (var o in selectCache) {
	 if (typeof o == "string") {
	   var type="unselected";
	   if (objTypeIs(o,"sticky")) {
	     type="sticky";
	   }
	   var cur=jQuery("#"+baseCheckboxId+"_"+type+o);
	   var optionText=cur.siblings("SPAN");
	   var parentItem=cur.parent();
	   if (objTypeNot(o,"default") && !selectCache[o].selected &&
	       !parentItem.hasClass("jquery_rgbmultiselect_options_selected_item_marker")) {
	     if (str == "" || andMatch(selectCache[o].text.toLowerCase(),strParts)) {
	       if (str == "") {
		 restoreOptionText(optionText,o);
	       } else {
		 optionText.html(replaceAll(selectCache[o].text,strParts));
	       }
	       optionsNumMatching++;
	       optionsOneSelectedMatch=cur;
	       optionsOneSelectedMatchType=type;
	       parentItem.show();
	       selectCache[o].filtered=false;
	     } else {
	       restoreOptionText(optionText,o);
	       parentItem.removeClass("jquery_rgbmultiselect_options_item_singlefiltered").hide();
	       selectCache[o].filtered=true;
	       // if the currently key-selected item gets filtered out, reset key selection
	       if (optionsKeyboardCurrentId == o) {
		 resetKeySelection();
	       }
	     }
	   }
	 }
       }
       if (optionsNumMatching == 1) {
	 optionsOneSelectedMatch.parent().addClass("jquery_rgbmultiselect_options_item_singlefiltered");
       }
     }

     function restoreOptionText(optionText,o) {
       if (jQuery.trim(optionText.html()) != selectCache[o].text) {
	 optionText.html(selectCache[o].text);
       }
     }

     function andMatch(haystack,needles) {
       var l=needles.length;
       for (var i=0;i<l;i++) {
	 if (haystack.indexOf(needles[i].toLowerCase()) == -1) {
	   return false;
	 }
       }
       return true;
     }

     function replaceAll(originalText,filterTexts) {
       var l=filterTexts.length;
       if (l == 0 || (l == 1 && filterTexts[0] == "")) {
	 return originalText;
       }
       for (var i=0;i<l;i++) {
	 originalText=replaceWord(originalText+"",filterTexts[i]+"");
       }
       return originalText;
     }

     function replaceWord(originalText,searchText) {
       var l=originalText.length;
       var sl=searchText.length;
       var curPos=0;
       var matchLoc;
       while (true) {
	 matchLoc=originalText.toLowerCase().indexOf(searchText.toLowerCase(),curPos);
	 if (matchLoc == -1) {
	   break;
	 }
	 var before=originalText.substr(0,matchLoc);
	 var beforeWithSpan=before+'<span class="jquery_rgbmultiselect_options_text_filtermatch">';
	 var matched=originalText.substr(matchLoc,sl);
	 var after=originalText.substr(matchLoc+sl);
	 var afterWithSpan='</span>'+after;
	 if (((before.lastIndexOf('<') < before.lastIndexOf('>')) ||
	      (before.lastIndexOf('<') == -1 && before.lastIndexOf('>') == -1)) &&
	     ((after.indexOf('<') < after.indexOf('>')) ||
	      (after.indexOf('<') == -1 && after.indexOf('>') == -1))) {
	   originalText=beforeWithSpan+matched+afterWithSpan;
	   curPos=beforeWithSpan.length+matched.length+'</span>'.length;
	 } else {
	   curPos=matchLoc+sl;
	 }
       }
       return originalText;
     }

     function selectOnEnterAndReset() {
       if (optionsNumMatching == 1) {
	 // can't text filter on selected options
	 if (numOptionsSelected() >= prefs.maxSelections && prefs.maxSelections > -1) {
	   return;
	 }

	 optionsNumMatching=0;
	 var optionText=optionsOneSelectedMatch.siblings("SPAN");
	 var itemId=getItemId(optionsOneSelectedMatch,optionsOneSelectedMatchType);
	 optionsOneSelectedMatch.parent().removeClass("jquery_rgbmultiselect_options_item_singlefiltered");
	 
	 restoreOptionText(optionText,itemId);

	 selectCache[itemId].filtered=false;

	 if (optionsOneSelectedMatchType == "sticky") {
	   selectSticky(itemId);
	 } else {
	   selectOption(itemId);
	 }
	 jQuerysInput.focus().val("");
	 filterOptions();
	 updateUnselectedHeight();
       } else {
	 if (optionsKeyboardCurrentId !== null && (optionsKeyboardCurrentType == "clearlist" ||
						   !selectCache[optionsKeyboardCurrentId].filtered)) {

	   if (numOptionsSelected() >= prefs.maxSelections && 
	       prefs.maxSelections > -1 &&
	       optionsKeyboardCurrentType != "clearlist" &&
	       !selectCache[optionsKeyboardCurrentId].selected) {
	     return;
	   }

	   var toBeSelectedId=optionsKeyboardCurrentId;
	   var toBeSelectedType=optionsKeyboardCurrentType;
	   // safer to go up than down in case we're on the last unselected item, unless it's an exclusive
	   // option, in which case we should just clear
	   if (toBeSelectedType == "clearlist" || objIsExclusive(toBeSelectedId)) {
	     resetKeySelection();
	   } else {
	     keyGo(1);
	   }
	   
	   if (toBeSelectedType == "clearlist") {
	     clearTextClick();
	   } else if (toBeSelectedType == "sticky") {
	     if (selectCache[toBeSelectedId].selected) {
	       unselectSticky(toBeSelectedId);
	     } else {
	       selectSticky(toBeSelectedId);
	     }
	   } else {
	     if (selectCache[toBeSelectedId].selected) {
	       unselectOption(toBeSelectedId);
	     } else {
	       selectOption(toBeSelectedId);
	     }
	   }

	   // trigger another unselectedOptionsResize
	   jQuerysInput.focus();
	 }
       }
     }

     function getHelpText(numOptSel) {
       var helpTextText=prefs.helpText;
       if ((prefs.maxSelections > -1 && numOptSel >= prefs.maxSelections) ||
	 (numOptSel == 1 && prefs.allOptionsExclusive)) {
	 helpTextText=prefs.helpTextMaxSelectionsReached;
       }
       return helpTextText;
     }

     function buildOptions() {
       if (jQuerysOptions.hasClass("jquery_rgbmultiselect_optionsbuilt")) {
	 return;
       }
       jQuerysOptions.addClass("jquery_rgbmultiselect_optionsbuilt");

       var numOptSel=numOptionsSelected();
       var helpTextText=getHelpText(numOptSel);

       var helpText=jQuerye("div").addClass("jquery_rgbmultiselect_options_helptext")
	 .text(helpTextText).appendTo(jQuerysOptions);

       if (prefs.clearAllSelectNoneAvailable) {
	 var clearText=buildClearTextItem();
	 clearText.appendTo(jQuerysOptions);
	 if (numOptSel === 0) {
	   clearText.find(".jquery_rgbmultiselect_options_clearlist_checkbox").attr("checked","checked");
	 }
       }

       var stickyObj=jQuerye("div").addClass("jquery_rgbmultiselect_options_sticky");       
       buildStickyCheckboxList(stickyObj).appendTo(jQuerysOptions);

       var selectedItems=jQuerye("div").addClass("jquery_rgbmultiselect_options_selected");
       buildOptionsCheckboxList(selectedItems,"selected").appendTo(jQuerysOptions);

       var unselectedItems=jQuerye("div").addClass("jquery_rgbmultiselect_options_unselected");
       buildOptionsCheckboxList(unselectedItems,"unselected").appendTo(jQuerysOptions);

       jQuerysOptions.hover(function() {
		       },function() {
			 // address a bug where if you unhover onto an element like a scrollbar,
			 // the unhover doesn't register in jQuery
			 jQuery(this).find(".jquery_rgbmultiselect_options_item_hovered")
			   .removeClass("jquery_rgbmultiselect_options_item_hovered");
		       });
     }

     function buildStickyCheckboxList(stickyObj) {
       for (var o in selectCache) {
	 if (typeof o == "string" && objTypeIs(o,"sticky")) {
	   var stickyValueContainer=jQuerye("div").addClass("jquery_rgbmultiselect_options_item")
	     .addClass('jquery_rgbmultiselect_options_sticky_item');

	   var stickyCheckbox=jQuerye("input").addClass("jquery_rgbmultiselect_options_sticky_checkbox")
	     .attr({type:'checkbox',id:baseCheckboxId+'_sticky'+o,name:baseCheckboxId+'_sticky'+o});
	   stickyCheckbox.click(function() {jQuerysInput.focus();}).mousedown(function(e) {e.stopPropagation();}).appendTo(stickyValueContainer);

	   var stickyText=jQuerye("span").text(selectCache[o].text);
	   stickyText.appendTo(stickyValueContainer);

	   stickyValueContainer.appendTo(stickyObj);

	   stickyValueContainer.click(function(e) {
					jQuerysInput.focus();
					var checkbox=jQuery(this).find(".jquery_rgbmultiselect_options_sticky_checkbox");
					var value=getItemId(checkbox,"sticky");
					if (selectCache[value].selected) {
					  unselectSticky(value);
					} else {
					  selectSticky(value);
					}
					e.stopPropagation();
				      })
	     .mousedown(function(e) {e.stopPropagation();});

	   attachHoverEvents(stickyValueContainer);

	   if (selectCache[o].selected) {
	     stickyValueContainer.addClass("jquery_rgbmultiselect_options_selected_item");
	     stickyCheckbox.attr("checked","checked");
	   }
	 }
       }
       return stickyObj;
     }

     function buildClearTextItem() {
       var clearText=jQuerye("div").addClass("jquery_rgbmultiselect_options_cleartext");
       var clearTextContainer=jQuerye("div").addClass("jquery_rgbmultiselect_options_item")
	 .addClass('jquery_rgbmultiselect_options_cleartext_item');

       var clearTextCheckbox=jQuerye("input").addClass("jquery_rgbmultiselect_options_clearlist_checkbox")
	 .attr({type:'checkbox',id:baseCheckboxId+'_clearlist',name:baseCheckboxId+'_clearlist'});
       clearTextCheckbox.click(function() {jQuerysInput.focus();}).mousedown(function(e) {e.stopPropagation();}).appendTo(clearTextContainer);

       var clearTextText=jQuerye("span").text(prefs.clearAllSelectNoneText).appendTo(clearTextContainer);

       clearTextContainer.appendTo(clearText);

       clearText.click(function(e) {
			 clearTextClick();
			 jQuerysInput.focus();
			 e.stopPropagation();
		       }).mousedown(function(e) {e.stopPropagation();});

       attachHoverEvents(clearTextContainer);

       return clearText;
     }

     function clearTextClick() {
       clearAll();
       updateUnselectedHeight();
       jQuery("#"+baseCheckboxId+"_clearlist").attr("checked","checked");
     }

     function buildOptionsCheckboxList(items,type) {
       for (var o in selectCache) {
	 if (typeof o == "string" && objTypeNot(o,"default") && objTypeNot(o,"sticky")) {
	   var item=jQuerye("div").addClass("jquery_rgbmultiselect_options_item")
	     .addClass('jquery_rgbmultiselect_options_'+type+'_item').attr("id",optionsId+"_item"+o);

	   var displayed=false;
	   if ((selectCache[o].selected && type == "selected") ||
	     (!selectCache[o].selected && type == "unselected")) {
	     displayed=true;
	   } else {
	     if (type == "unselected") {
	       item.addClass("jquery_rgbmultiselect_options_selected_item_marker");
	     }
	   }
	   item.css("display",(displayed?"block":"none"));

	   var optId=baseCheckboxId+'_'+type+o;
	   var itemCheckbox=jQuerye("input").attr({type:'checkbox',id:optId,name:optId})
	     .addClass("jquery_rgbmultiselect_options_item_checkbox")
	     .addClass('jquery_rgbmultiselect_options_'+type+'_item_checkbox');

	   if (type == "selected") {
	     itemCheckbox.attr("checked","checked");
	   }

	   itemCheckbox.click(function(e) {jQuerysInput.focus();}).mousedown(function(e) {e.stopPropagation();});

	   itemCheckbox.appendTo(item);

	   var itemText=jQuerye("span").text(selectCache[o].text).appendTo(item);

	   item.click(function(e) {
			var checkbox=jQuery(this).find(".jquery_rgbmultiselect_options_item_checkbox");
			var value=getItemId(checkbox,type);
			if (type == "unselected") {
			  selectOption(value);
			} else if (type == "selected") {
			  unselectOption(value);
			}
			jQuerysInput.focus();
			e.stopPropagation();
		      })
	     .mousedown(function(e) {
			  e.stopPropagation();
			});

	   attachHoverEvents(item);
	   
	   item.appendTo(items);
	 }
       }
       return items;
     }

     function getItemId(item,type) {
       return item.attr("id").substr((baseCheckboxId+"_"+type).length);
     }

     function attachHoverEvents(item) {
       item.hover(function() {
		    jQuery(this).addClass("jquery_rgbmultiselect_options_item_hovered");
		  },function() {
		    jQuery(this).removeClass("jquery_rgbmultiselect_options_item_hovered");
		  });
     }

     // expect a value in the form "_selectvalue"
     function selectOption(value) {
       if (numOptionsSelected() >= prefs.maxSelections && prefs.maxSelections > -1) {
	 jQuery("#"+baseCheckboxId+"_unselected"+value).removeAttr("checked");
	 return;
       }
       preselectCommon(value);
       jQuery("#"+baseCheckboxId+"_selected"+value).attr("checked","checked").parent().show();
       jQuery("#"+baseCheckboxId+"_unselected"+value).removeAttr("checked").parent()
	 .addClass("jquery_rgbmultiselect_options_selected_item_marker").hide();
       selectCommon(value);
       updateUnselectedHeight();
     }

     // expect a value in the form "_selectvalue"
     function unselectOption(value) {
       jQuerysSelect.find("OPTION[value='"+value.substr(1)+"']").removeAttr("selected");
       jQuery("#"+baseCheckboxId+"_selected"+value).attr("checked","checked").parent().hide();
       jQuery("#"+baseCheckboxId+"_unselected"+value).removeAttr("checked").parent()
	 .removeClass("jquery_rgbmultiselect_options_selected_item_marker").show();
       unselectCommon(value);
       updateUnselectedHeight();
     }

     // expect a value in the form "_selectvalue"
     function selectSticky(value) {
       if (numOptionsSelected() >= prefs.maxSelections && prefs.maxSelections > -1) {
	 jQuery("#"+baseCheckboxId+"_sticky"+value).removeAttr("checked");
	 return;
       }
       preselectCommon(value);
       var checkBox=jQuery("#"+baseCheckboxId+"_sticky"+value);
       checkBox.attr("checked","checked").parent().addClass("jquery_rgbmultiselect_options_selected_item");
       var optionText=checkBox.siblings("SPAN");
       restoreOptionText(optionText,value);
       selectCommon(value);
     }

     // expect a value in the form "_selectvalue"
     function unselectSticky(value) {
       jQuery("#"+baseCheckboxId+"_sticky"+value).removeAttr("checked")
	 .parent().removeClass("jquery_rgbmultiselect_options_selected_item");
       unselectCommon(value);
     }

     function preselectCommon(value) {
       if (objIsExclusive(value)) {
	 clearAll();
       } else {
	 clearExclusive();
       }
     }

     function selectCommon(value) {
       selectCache[value].selected=true;
       jQuerysSelect.find("OPTION[value='"+value.substr(1)+"']").attr("selected","selected");
       if (prefs.clearAllSelectNoneAvailable) {
	 jQuery("#"+baseCheckboxId+"_clearlist").removeAttr("checked");
       }
       positionOptionsContainer();
       jQuerysOptions.children(".jquery_rgbmultiselect_options_helptext").text(getHelpText(numOptionsSelected()));
     }

     function unselectCommon(value) {
       selectCache[value].selected=false;
       jQuerysSelect.find("OPTION[value='"+value.substr(1)+"']").removeAttr("selected");
       if (prefs.clearAllSelectNoneAvailable && numOptionsSelected() === 0) {
	 jQuery("#"+baseCheckboxId+"_clearlist").attr("checked","checked");
       }
       positionOptionsContainer();
       jQuerysOptions.children(".jquery_rgbmultiselect_options_helptext").text(getHelpText(numOptionsSelected()));
     }

     function clearAll() {
       for (var o in selectCache) {
	 if (typeof o == "string") {
	   if (objTypeNot(o,"default") && selectCache[o].selected) {
	     if (objTypeIs(o,"sticky")) {
	       unselectSticky(o);
	     } else {
	       unselectOption(o);
	     }
	   }
	 }
       }
     }

     function clearExclusive() {
       for (var o in selectCache) {
	 if (typeof o == "string") {
	   if (objTypeNot(o,"default") && objTypeIs(o,"exclusive") && selectCache[o].selected) {
	     if (objTypeIs(o,"sticky")) {
	       unselectSticky(o);
	     } else {
	       unselectOption(o);
	     }
	   }
	 }
       }
     }

     function showOptions() {
       positionOptionsContainer();
       if (!jQuerysOptions.is(":visible")) {
	 jQuerysOptions.show();
       }

       // make sure we get the original height of the unselected list before we manipulate it
       // if only CSS max-height was universally supported...
       if (unselectedOriginalHeight === null) {
	 unselectedOriginalHeight=jQuerysOptions.children(".jquery_rgbmultiselect_options_unselected").height();
       }

       updateUnselectedHeight();

       // in case placing the options container causes the page to scroll, we might
       // need to reposition horizontally or vertically
       positionOptionsContainer();
     }

     function updateUnselectedHeight() {
       if (!jQuerysOptions.is(":visible")) {
	 return;
       }
       var unselectedContainer=jQuerysOptions.children(".jquery_rgbmultiselect_options_unselected");
       var unselHeight=heightOfUnselectedOptions();
       if (unselHeight >= unselectedOriginalHeight) {
	 unselectedContainer.css("height","");
       } else {
	 unselectedContainer.css("height",(unselHeight+2)+"px");
       }
       positionIframe(true);
     }

     function heightOfUnselectedOptions() {
       var options=getAllVisibleOptions();
       var first=firstUnselected(options);
       var last=lastUnselected(options);
       if (options.length === 0 || first === "" || last === "") {
	 return 0;
       }
       var firstParent=jQuery("#"+baseCheckboxId+"_unselected"+first).parent();
       var lastParent=jQuery("#"+baseCheckboxId+"_unselected"+last).parent();
       return lastParent.position().top + lastParent.height() - firstParent.position().top;
     }

     function hideOptions() {
       positionIframe(false);
       jQuerysOptions.hide();
     }

     function leaveField() {
       hideOptions();
       clearInputField=true;
       resetKeySelection();
       updateFieldText();
     }

     function buildOptionsContainer() {
       var optContainer=jQuerye("div");
       optContainer.hide().addClass("jquery_rgbmultiselect_options_container")
	 .attr("id",optionsId).css({width:inputWidth+"px"});

       return optContainer;
     }

     function positionOptionsContainer() {
       if (!jQuerysOptions.is(":visible")) {
	 return;
       }
       var offset=jQuerysInput.offset();
       var top=parseInt(offset.top,10);
       var left=parseInt(offset.left,10);
       var containerTop=top+jQuerysInput.outerHeight();
       var containerLeft=left;

       jQuerysOptions.css({top:containerTop+"px",left:containerLeft+"px"});
       positionIframe(true);
     }

     function updateFieldText() {
       jQuerysInput.val("");
       filterOptions();
       var replacementsO="";
       var replacementsC=0;
       var replacementsA=0;
       var numAdded=0;
       for (var o in selectCache) {
	 if (typeof o == "string") {
	   if (selectCache[o].selected) {
	     replacementsC++;
	     if (prefs.fieldTextFormatOnBlurNumToShow == -1 || 
		 (prefs.fieldTextFormatOnBlurNumToShow > 0 && prefs.fieldTextFormatOnBlurNumToShow > numAdded)) {
	       replacementsO+=selectCache[o].text+", ";
	       numAdded++;
	     }
	   }
	 }
       }
       
       if (prefs.fieldTextFormatOnBlurNumToShow > 0) {
	 replacementsA=replacementsC-prefs.fieldTextFormatOnBlurNumToShow;
       }
       
       replacementsO=replacementsO.substr(0,replacementsO.length-2);

       if (replacementsC == "") {
	 if (prefs.clearAllSelectNoneAvailable && prefs.clearAllSelectNoneTextShowOnBlur &&
	     jQuerysOptions.hasClass("jquery_rgbmultiselect_optionsbuilt")) {
	   jQuerysInput.val(prefs.clearAllSelectNoneText);
	 } else {
	   jQuerysInput.addClass("jquery_rgbmultiselect_blurred").val(prefs.inputDefaultText);
	 }
       } else {
	 var fieldText=prefs.fieldTextFormatOnBlur+"";
	 if (replacementsA <= 0) {
	   fieldText=prefs.fieldTextFormatOnBlurIfLTENumToShow+"";
	 }
	 fieldText=fieldText.replace(/%o/,replacementsO);
	 fieldText=fieldText.replace(/%c/,replacementsC);
	 fieldText=fieldText.replace(/%a/,replacementsA);
	 jQuerysInput.val(fieldText);
       }
     }

     function anyOptionsSticky() {
       for (var o in selectCache) {
	 if (typeof o == "string" && objTypeIs(o,"sticky")) {
	   return true;
	 }
       }
       return false;
     }

     function anyNonstickyOptionsSelected() {
       for (var o in selectCache) {
	 if (typeof o == "string" && objTypeNot(o,"sticky") && selectCache[o].selected) {
	   return true;
	 }
       }
       return false;
     }

     function numOptionsSelected() {
       var c=0;
       for (var o in selectCache) {
	 if (typeof o == "string") {
	   if (selectCache[o].selected) {
	     c++;
	   }
	 }
       }
       return c;
     }

     function getSelectOptions() {
        var data={};
       jQuerysSelect.find("OPTION").each(
	 function() {
	   var value=jQuery(this).val();
	   var rel=jQuery(this).attr("rel");
	   var text=jQuery(this).text();
	   var selected=jQuery(this).is(":selected");
	   data["_"+value]={
	     rel:rel,
	     text:text,
	     selected:selected,
	     filtered:false,
	     disabled:false
	   };
	 }
       );
       return data;
     }

     function buildInputField() {
       // we check for an existing input field because adding dynamic form elements breaks
       // back button functionality in firefox. if this bothers you, you can add the form
       // elements on your own and we'll just use them instead, without changing your form.
       var existingInputField=jQuery("#"+inputId);
       var inputField;
       if (existingInputField.size() == 1) {
	 inputField=existingInputField;	 
       } else {
	 inputField=jQuerye("input");
	 inputField.attr({type:"text",id:inputId,name:inputId}).css({width:selectWidth+"px"});
       }
       inputField.addClass("jquery_rgbmultiselect_input").attr("autocomplete","off").val(prefs.inputDefaultText);
       jQuerysSelect.after(inputField).hide();
       return inputField;
     }

     function positionIframe(makevisible) {
       if (jQuery.browser.msie && jQuery.browser.version == 6 && jQuerysIframe && jQuerysOptions.is(":visible")) {
	 if (makevisible) {
	   var w=jQuerysOptions.outerWidth();
	   var h=jQuerysOptions.outerHeight();
	   var o=jQuerysOptions.offset();
	   var t=o.top;
	   var l=o.left;
	   jQuerysIframe.css({display:"block",top:t,left:l,height:h,width:w});
	 } else {
	   jQuerysIframe.css({display:"none"});
	 }
       }
     }

     function buildIE6Iframe() {
       if (jQuery.browser.msie && jQuery.browser.version == 6) {
	 var iFrame=jQuerye("iframe");
	 iFrame.addClass("jquery_rgbmultiselect_ie6_iframe").attr({id:iframeId,src:"javascript:void(0)"});
	 jQuery(document.body).append(iFrame);
	 return iFrame;
       } else {
	 return null;
       }
     }

     function objIsExclusive(value) {
       return objTypeIs(value,"exclusive") || prefs.allOptionsExclusive;
     }

     function objTypeIs(o,type) {
       return selectCache[o].rel && selectCache[o].rel.indexOf(type) > -1;
     }

     function objTypeNot(o,type) {
       return !selectCache[o].rel || selectCache[o].rel.indexOf(type) == -1;
     }

     function debug(str) {
       if (window.console && window.console.log) {
	 window.console.log(str);
       } else {
	 if (jQuery("#console").size() === 0) {
	   jQuery(document.body).append('<div style="float:left;clear:both;margin:20px;border:1px solid black;width:200px;height:400px" id="console"></div>');
	 }
	 jQuery("#console").html(jQuery("#console").html()+str+"<br>");
       }
     }

     // convenience functions
     function jQuerye(t) {
       return jQuery(document.createElement(t));
     }

     function between(q,l,h) {
       return (q >= l && q <= h);
     }

     function mouseOverObj(obj,event) {
       obj=jQuery(obj);
       var mX=event.pageX;
       var mY=event.pageY;
       var pos=obj.offset();
       var top=pos.top;
       var left=pos.left;
       var bottom=top+obj.outerHeight();
       var right=left+obj.outerWidth();
       return between(mX,left,right) && between(mY,top,bottom);
     }
   };


   jQuery.rgbmultiselector.defaults = {
     helpText: 'Select options',
     helpTextMaxSelectionsReached: 'Max options selected',
     inputDefaultText: 'service',
     maxSelections: -1,
     clearAllSelectNoneAvailable: false,
     clearAllSelectNoneText: '',
     clearAllSelectNoneTextShowOnBlur: false,
     allOptionsExclusive: false,
     buildOptionsInBackground: true,
     pageUpDownDistance: 10,
     // replace keys:
     // %o: options list, in order
     //   - if fieldTextFormatOnBlurNumToShow == -1, show all,
     //     else show fieldTextFormatOnBlurNumToShow
     // %c: count of number of options selected
     // %a: count of number of options in addition to 
     //     fieldTextFormatOnBlurNumToShow, or
     //     %c - fieldTextFormatOnBlurNumToShow
     fieldTextFormatOnBlur: "%o",
     fieldTextFormatOnBlurNumToShow: -1,
     fieldTextFormatOnBlurIfLTENumToShow: "%o"
   };
 })(jQuery);
