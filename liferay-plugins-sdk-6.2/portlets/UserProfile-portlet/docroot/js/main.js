


/**
 * Edittable textfield
 */

function Edittable(categoryId, length){
	var componentContainer = document.getElementById(categoryId+'_container');
	var inputField = document.getElementById(categoryId+'_input'); //corresponds to an input type
	
	if(inputField == null){
		return;
	}
	
	var objType = inputField.type;
	var inputVal = inputField.value;
	var displayDiv = componentContainer.appendChild(document.createElement("div"));
	if(objType == "hidden") {
		return;
	}
	var displayAsText = function(value){
		displayDiv.setAttribute('id',categoryId + '_text');
		displayDiv.setAttribute('section_name', categoryId);
		
		var editorType = inputField.getAttribute('editorType');

		if(objType == "textarea" && editorType == "CKEditor"){
			inputField.style.display="none";
			var ckeditor = CKEDITOR.replace( categoryId+'_input',
				{
					resize_enabled: false,
					toolbar :
					[
						[ 'TextColor','FontSize','Font','-','Bold', 'Italic', 'Underline', '-', 'Link', 'Unlink' , '-', 'JustifyLeft', 'JustifyCenter','JustifyRight','JustifyBlock','NumberedList','BulletedList' ]
					]
				});
			if(value == ""){
				displayDiv.innerHTML="[click to edit]";
				displayDiv.style.color="gray";
			}else{
				if(ckeditor){
					ckeditor.setData(value);
				}
				displayDiv.innerHTML=value;
			}
			displayDiv.setAttribute('class', 'textedit-input single-input-div');
			displayDiv.setAttribute('editor', 'ckeditor');
			displayDiv.setAttribute('onclick', 'javascript:editThis("' + categoryId + '_text' + '")');
			document.getElementById('cke_' + categoryId + '_container').style.display = 'none';
		} else if(objType == "select-one"){
			
		} else if (objType == "hidden" && inputField.name == "auicalendar") {
			/*
			var section_name = inputField.getAttribute("section_name");
			jq("#" + section_name + "_input_cal").hide();
			
			displayDiv.setAttribute('class', 'textedit-input single-input-div');
			displayDiv.setAttribute('editor', 'auicalendar');
			displayDiv.setAttribute('onclick', 'javascript:editThis("' + categoryId + '_text' + '")');
			displayDiv.innerHTML=value;
			*/
		} else{
			inputField.style.display="none";
			
			displayDiv.setAttribute('class', 'textedit-input single-input-div');
			displayDiv.setAttribute('onclick', 'javascript:editThis("' + categoryId + '_text' + '")');
			
			if(value == ""){
				displayDiv.innerHTML="[click to edit]";
				displayDiv.style.color="gray";
			}else{
				if(length){
					if(length < value.length){
						displayDiv.setAttribute('class', 'textedit-input single-input-div show_tooltip');
						displayDiv.setAttribute('tooltip', value);
						/*jq('.show_tooltip').tooltip({
							speed:300
						});*/
						value = value.substring(0,length) + "...";
					}else{
						displayDiv.setAttribute('class', 'textedit-input single-input-div');
						displayDiv.removeAttribute('tooltip');
					}
				}
				
				displayDiv.innerHTML=value;
			}
		}
	};//end displayAsText
	
	displayAsText(inputVal);
	
}//end Edittable
/** end textfield edittable  */

/**
 * Save single input field instance
 */
function saveSelectInput(id,categoryName){
	var input_value = document.getElementById(id).value;
	var successSave = ajaxSubmitSingleField(id,input_value,categoryName);
}

function saveSingleInput(id, categoryName, length){
	
	var A = AUI();
	var inputField = document.getElementById(id);

	var section_name = "";
	var input_value = "";
	var objType = "";
	
	if(inputField != null){
		objType = inputField.type;
		section_name = inputField.getAttribute("section_name");
	}
	
	if(objType == 'select-one'){
		input_value = inputField.options[inputField.selectedIndex].value.trim();
	}else if(objType == 'select-multiple'){
		var opt = inputField.options;
		for ( var i = 0; i < opt.length; i++) {
			if (opt[i].selected){
				if(input_value != ''){
					input_value += ', ' + opt[i].value;
				}else{
					input_value = opt[i].value;
				}
			}//end if
		}//end for
	}else if(objType == 'radio'){
		if(inputField.checked){
			input_value = inputField.value;
		}
	}else if(objType == 'textarea'){
		var ckeditor = CKEDITOR.instances[id];
		if (ckeditor != null) {
			input_value = ckeditor.getData();
			inputField.value = input_value;
		}else{
			input_value = inputField.value;
		}	
	}else{//default is textfield
		input_value = inputField.value;			
	}
	
	var successSave = ajaxSubmitSingleField(id, input_value, categoryName);
	
	if(objType == 'radio'){ 
		return;// do not change the radio buttons to label after save
	}
	
	if(successSave){
		if(input_value == ""){
			A.one("#" + section_name + "_text").text("[click to edit]");
			A.one("#" + section_name + "_text").setStyle("color","gray");
		}else{
			
			if(length){
				if(length < input_value.length){
					//document.getElementById(section_name + "_text").setAttribute('tooltip', input_value);
					//document.getElementById(section_name + "_text").setAttribute('class', 'textedit-input single-input-div show_tooltip');
					
					showTooltip(section_name + "_text", input_value);
					/*jq('.show_tooltip').tooltip({
						speed:300
					});*/
					input_value = input_value.substring(0,length) + "...";
				}else{
					A.one("#"+section_name + "_text").removeClass('textedit-input-hide');
					//document.getElementById(section_name + "_text").setAttribute('class', 'textedit-input single-input-div');
					//document.getElementById(section_name + "_text").removeAttribute('tooltip');
				}
			}
			
			//A.one("#" + section_name + "_text").text(input_value);
			A.one("#" + section_name + "_text").setStyle("color","black");
		}
		
		A.one("#" + section_name + "_text").removeClass("textedit-input-hide");
		//A.one("#" + section_name + "_text").addClass("textedit-input");
		//A.one("#" + section_name + "_text").removeClass("focus");
		
		A.one("#" + id).setStyle("display","none");
	}
}

/**
 * CKEditor button save action
 */
function saveCKEditor(id, categoryName){
	var A = AUI();
	
	var section_name = A.one('#'+id).attr("section_name");
	
	var input_value = CKEDITOR.instances[section_name+"_input"].getData(); //get value from ckeditor
	
	A.one('#'+id).val(input_value); //assign ckeditor value to textarea
	
	var successSave = ajaxSubmitSingleField(section_name+"_input",input_value, categoryName);
	
	if(successSave){
		if(input_value == ""){
			A.one("#" + section_name + "_text").text("[click to edit]");
			A.one("#" + section_name + "_text").setStyle("color","gray");
		}else{
			A.one("#" + section_name + "_text").html(input_value);
			A.one("#" + section_name + "_text").setStyle("color","black");
		}
		
		A.one("#" + section_name + "_text").removeClass("textedit-input-hide");
		A.one("#" + section_name + "_text").addClass("textedit-input");
		A.one("#" + section_name + "_text").removeClass("focus");
		
		A.one("#cke_" + section_name + "_container").setStyle("display","none");
		A.one("#" + section_name + "_input").val(input_value);
	}
}

/**
 * CKEditor button cancel action
 */
function cancelCKEditor(id) {
	var A=AUI();
	var section_name = A.one('#' + id).attr("section_name");
	var input_value = A.one('#' + section_name+"_input").val();
	
	if(input_value == ""){
		A.one("#" + section_name + "_text").html("[click to edit]");
		A.one("#" + section_name + "_text").setStyle("color","gray");
		
	}else{
		A.one("#" + section_name + "_text").html(input_value);
		A.one("#" + section_name + "_text").setStyle("color","black");
	}
	
	A.one("#" + section_name + "_text").removeClass("textedit-input-hide");
	A.one("#" + section_name + "_text").addClass("textedit-input");
	A.one("#" + section_name + "_text").removeClass("focus");
	
	A.one("#cke_" + section_name + "_container").setStyle("display","none");
};

/**
 * On click with the div will change to edit mode
 */
function editThis(id){
	
	var A=AUI();
	var editor_name = A.one('#' + id).attr("editor");
	var section_name = A.one('#' + id).attr("section_name");
	
	var input_value = A.one('#' + section_name + "_input").val();
	if(editor_name == "ckeditor"){
		CKEDITOR.instances[section_name+"_input"].setData(input_value); //set value of ckeditor
		A.one('#' + id).addClass("textedit-input-hide");
		A.one("#cke_" + section_name + "_container").setStyle('display', 'inline-block');
	} else if(editor_name == "auicalendar"){
		A.one('#' + id).addClass("textedit-input-hide");
		A.one("#" + section_name + "_input_cal").show();
	} else{
		A.one('#' + id).addClass("textedit-input-hide");
		A.one('#' + id).removeClass("single-input-focus");
		
		A.one('#' + section_name + "_input").setStyle('display', 'inline-block');
		A.one('#' + section_name + "_input").addClass("single-input-focus");
		A.one('#' + section_name + "_input").focus();
	}
	
}
	
	
/*auto complete:*/

var InitAutoComplete;
(function(){
    InitAutoComplete=(function(){
        var used_textboxes=[];
        return function(textboxes,datas){
            var fragment = document.createDocumentFragment();
            textboxes.forEach(function(textbox) {
                var s=textbox.style;
                s.border="1px solid #ccc";
                s.padding="4px 7px 6px";
                //s.fontSize="17px";
                s.fontFamily="arial, sans-serif";
                var used=false;
                
                for(var x=0,limit=used_textboxes.length;x<limit;++x){
                    if(used_textboxes[x]===textbox){
                        used=true;
                        break;
                    }
                }
                if(!used){
                    fragment.appendChild(new ACBox(textbox,datas));
                    used_textboxes.push(textbox);
                }
            });
            document.body.appendChild(fragment);
        };
    })();
    var ACBox;
    (function(){
        var hide=function(){
            this.IsDisplayed=false;
            this.style.display="none";
        };
        var show=function(){
            this.IsDisplayed=true;
            this.style.display="block";
        };
        var submit=function(textbox){
            if(this._index===-1){
                return;
            }
            this.Hide();
            var value=this.childNodes[this._index].innerHTML;
            textbox.SetValue(value);
            textbox.scrollLeft=textbox.scrollWidth;
            value=textbox.value;
            textbox.setSelectionRange(value.length,value.length);
            textbox.focus();
        };
        var select_child=function(child){
            var child_nodes=this.childNodes;
            for(var x=0,limit=child_nodes.length;x<limit;++x){
                if(child===child_nodes[x]){
                    this.SetIndex(x);
                    return;
                }
            }
        };
        var set_index=function(index){
            var child_nodes=this.childNodes;
            var old_index=this._index;
            if(old_index!==-1){
                var s=child_nodes[old_index].style;
                s.lineHeight="22px";
                s.background="";
                s.padding="0 7px";
            }
            var s=child_nodes[index].style;
            s.lineHeight="22px";
            s.padding="0 7px";
            s.backgroundColor="#dfe8f6";
            s.cursor="pointer";
            this._index=index;
            this._textbox.SetValue(child_nodes[index].innerHTML);
        };
        var add_index=function(amt){
            var child_nodes=this.childNodes;
            var index=this._index;
            if(index===-1){
                if(amt>0){
                    index=amt-1;
                }else{
                    index=child_nodes.length-1;
                }
            }else{
                index+=amt;
                if(index<0){
                    index+=child_nodes.length;
                }else{
                    index%=child_nodes.length;
                }
            }
            this.SetIndex(index);
        };
        var GetPos=function(element) {
            var left = 0, top=0;
            while(true){
                left+=element.offsetLeft;
                top+=element.offsetTop;
                var parent=element.offsetParent;
                if(parent===null){
                    break;
                }
                element=parent;
            }
            return [left,top];
        };
        var repos_ac_box=function(div){
            var pos=GetPos(this);
            var left=pos[0];
            var top=pos[1]+this.offsetHeight;
            var s=div.style;
            s.minWidth = this.offsetWidth + "px";
            s.left =left+"px";
            s.top =top+"px";
        };
        ACBox=function(textbox,datas){
            var div=document.createElement("div");
            div._index=-1;
            div.Submit = submit;
            div.SelectChild=select_child;
            div.SetIndex=set_index;
            div.AddIndex = add_index;
            div.style.position="absolute";
            div.style.overflow="auto";
            div.style.lineHeight="22px";
            div.style.backgroundColor="white";
            div.setAttribute('class', 'subpopup');
            div.Show=show;
            div.Hide=hide;
            div.Hide();
            textbox.ReposACBox=function(){
                repos_ac_box.call(this,div);
            };
            div.addEventListener("mousedown",function(e){
                e.preventDefault();
            },true);
            TransformTextBox(textbox,div,datas);
            return div;
        };
        var TransformTextBox;
        (function(){
            var HandleInput=function(element,handler,use_capture){
                element.addEventListener("input",handler,use_capture);
                if(navigator.appName==="Microsoft Internet Explorer"){
                    var remove_selection=function(textbox){
                        var value=textbox.value;
                        var selection_start=textbox.selectionStart;
                        textbox.value=value.substr(0,selection_start)+value.substr(this.selectionEnd);
                        textbox.setSelectionRange(selection_start,selection_start);
                    };
                    element.addEventListener("cut",function(e){
                        remove_selection(this);
                        e.preventDefault();
                        handler.call(this,e);
                    },use_capture);
                    element.addEventListener("keydown",function(e){
                        var value=this.value;
                        var key_code=e.keyCode;
                        var selection_start=this.selectionStart;
                        switch(key_code){
                            case 8:case 46:
                            if(selection_start===this.selectionEnd){
                                if(key_code===46){//del
                                    if(selection_start!==value.length){
                                        this.value=value.substring(0,selection_start)+value.substring(selection_start+1);
                                        var new_selection_start=selection_start;
                                        this.setSelectionRange(new_selection_start,new_selection_start);
                                    }
                                }else{//backspace
                                    if(selection_start!==0){
                                        this.value=value.substring(0,selection_start-1)+value.substring(selection_start);
                                        var new_selection_start=selection_start-1;
                                        this.setSelectionRange(new_selection_start,new_selection_start);
                                    }
                                }
                            }else{
                                remove_selection(this);
                            }
                            e.preventDefault();
                            handler.call(this,e);
                            break;
                        }
                    },use_capture);
                }
            };
            var Process=function(text,datas) {
                if(text==="")return datas;
                var results = [];
                for (var x = 0, count = 0, limit = datas.length; x < limit;++x) {
                    var data = datas[x];
                    if (data.toLowerCase().indexOf(text.toLowerCase()) === 0) {
                        results.push(data);
                        ++count;
                        if (count === 5) {
                            break;
                        }
                    }
                }
                return results;    
            };
            TransformTextBox=function(textbox,ac_box,datas){
                
                textbox._ac_box=ac_box;
                ac_box._textbox=textbox;
                
                textbox.cached_datas = [];
                textbox.BuildACBox = build_ac_box;
                textbox.BuildACBoxFromData = build_ac_box_from_data;
                textbox.GetValue=get_value;
                textbox.SetValue=set_value;
                var handler = function(e) {
                    var value = textbox.GetValue();
                    var result_is_cached=textbox.BuildACBox(ac_box,value);
                    textbox.ReposACBox();
                    if (result_is_cached)return;
                    textbox.cached_datas.push({
                        Text: value,
                        Results: Process(value,datas)
                    });
                    textbox.BuildACBox(ac_box);
                };
                textbox._on_input=handler;
                HandleInput(textbox,handler,true);
                textbox.addEventListener("focus", handler, true);
                handler = function(e){
                    if(!ac_box.IsDisplayed){
                        return;
                    }
                    var key_code=e.keyCode;
                    switch(e.keyCode){
                        case 13:
                        ac_box.Submit(textbox);
                        break;
                        case 38:
                        ac_box.AddIndex(-1);
                        break;
                        case 40:
                        ac_box.AddIndex(1);
                        break;
                        default:
                        return;
                    }
                    e.preventDefault();
                };
                textbox.addEventListener("keydown",handler,true);
                textbox.addEventListener("blur",function(){
                    ac_box.Hide();
                },true);
            };
            var build_ac_box = function(ac_box) {
                var current_textbox_value = this.GetValue();//hook
                var chosen_data;
                this.cached_datas.forEach(function(cached_data) {
                    var text = cached_data.Text;
                    if (current_textbox_value.indexOf(text) === 0) {
                        if (chosen_data === undefined) {
                            chosen_data = cached_data;
                            return;
                        }
                        if (text.length > chosen_data.Text.length) {
                            chosen_data = cached_data;
                        }
                    }
                });
                if (chosen_data === undefined)return;
                this.BuildACBoxFromData(ac_box, chosen_data);
                return chosen_data.Text === current_textbox_value;
            };
            var build_ac_box_from_data = function(ac_box, chosen_data) {
                var textbox = this;
                var fragment = document.createDocumentFragment();
                var handler = function(e) {
                    ac_box.Submit(textbox);
                    e.preventDefault();
                };
                var handler2=function(e){
                    ac_box.SelectChild(e.target);
                };
                var results=chosen_data.Results;
                if(results.length===0){
                    ac_box.Hide();
                    return;
                }
                results.sort();
                results.forEach(function(result) {
                    var result_element = fragment.appendChild(document.createElement("div"));
                    var s=result_element.style;
                    result_element.innerHTML = result;
                    result_element.addEventListener("mousedown", handler, true);
                    result_element.addEventListener("mouseover", handler2, true);
                });
                ac_box.innerHTML = "";
                ac_box._index=-1;
                ac_box.appendChild(fragment);
                ac_box.Show();
                var child_nodes=ac_box.childNodes;
                ac_box.style.maxHeight=child_nodes[0].offsetHeight*10+"px";
            };
            var get_value=function(){
                var splits=this.value.split(",");
                return splits[splits.length-1].trim();
            };
            var set_value=function(value){
                var splits=this.value.split(",");
                splits.pop();
                splits.push(value);
                for(var x=0,limit=splits.length;x<limit;++x){
                    splits[x]=splits[x].trim();
                }
                this.value=splits.join(", ");
                var textbox=this;
            };
        })();
    })();
})();


function clearState(fieldToUpdate){
	var A = AUI();
	
	if((fieldToUpdate != '') || (fieldToUpdatefieldToUpdate.length > 0)){
		
		var divStatus = A.one('#'+fieldToUpdate+'_status');
		if(divStatus){
			divStatus.remove();//remove existing icon
		}
		
		var inputFld = A.one('#'+fieldToUpdate);
		if(!inputFld){
			inputFld = A.one('#'+fieldToUpdate+'_input');
		}
		if(inputFld){
			if(inputFld.attr('editortype') == 'CKEditor'){
				var ckeInput = A.one('#cke_'+fieldToUpdate);
				if(!ckeInput){
					ckeInput = A.one('#cke_'+fieldToUpdate+'_input');
				}
				ckeInput.removeClass("userpersonaldetails-errorClass");
			}else{
				inputFld.removeClass("userpersonaldetails-errorClass");
			}
		}
//		A.one("#" + fieldToUpdate + "_text").text("");
//		A.one('#' + fieldToUpdate + "_input").set('value', ""); 
//		alert("input field clear state " + A.one('#' + fieldToUpdate + "_input").val());
//		alert("input field clear state innerhtml " + document.getElementById(fieldToUpdate + "_text").innerHTML);
		//return true;
	}
	
}

function loadingState(fieldToUpdate){
	var A = AUI();
	
	var divStatus = A.one('#'+fieldToUpdate+'_status');
	if(divStatus){
		divStatus.remove();//remove existing icon
	}
	
	A.one('#'+fieldToUpdate+"_iconstatus").append('<div id="'+fieldToUpdate+'_status" class="loading"/>');
}
function successSaveState(fieldToUpdate, successMsg,fieldValue){
	
	var A = AUI();
	
	var divIconStatus = A.one('#'+fieldToUpdate+"_iconstatus");
	
	if(!divIconStatus) return;
	
	divIconStatus.append('<div id="'+fieldToUpdate+'_status" class="tick"/>');
	
	showTooltip(fieldToUpdate + '_status', successMsg);
	
	
	AUI().ready('transition', function(A) {
		
		var icon = A.one('#'+fieldToUpdate+'_status');
		
		if(icon){
			icon.transition({
				  //width: 100, 
				  //height: 100,
				  opacity: 0,
				  duration: 2,
				  easing: 'ease-out'
				}, function() {
				    this.remove(); //remove existing icon
				});
			
			var field = document.getElementById(fieldToUpdate);
			if(A.one("#" + fieldToUpdate + "_text")){
				A.one("#" + fieldToUpdate + "_text").text(fieldValue);
			}
			if(A.one("#" + fieldToUpdate + "_input")){
				A.one('#' + fieldToUpdate + "_input").set('value', fieldValue); 
			}	
			if(field){
				A.one('#'+fieldToUpdate).removeClass("userpersonaldetails-errorClass");
			}else{
				A.one('#'+fieldToUpdate + "_input").removeClass("userpersonaldetails-errorClass");
			}
			
		}
	});
	
}

function errorState(fieldToUpdate, errMsg){
	var A = AUI();
	var divStatus = A.one('#'+fieldToUpdate+'_status');
	if(divStatus){
		divStatus.remove();//remove existing icon
	}
	A.one('#'+fieldToUpdate+"_iconstatus").append('<div id="'+fieldToUpdate+'_status" class="cross"/>');
	showTooltip(fieldToUpdate + '_status', errMsg);
	var inputFld = A.one('#'+fieldToUpdate);
	
	if(!inputFld){
		inputFld = A.one('#'+fieldToUpdate+'_input');
	}
	if(inputFld){
		if(inputFld.attr('editortype') == 'CKEditor'){
			var ckeInput = A.one('#cke_'+fieldToUpdate);
			if(!ckeInput){
				ckeInput = A.one('#cke_'+fieldToUpdate+'_input');
			}
			ckeInput.removeClass("single-input-focus");
			ckeInput.addClass('userpersonaldetails-errorClass');
		}else{
			inputFld.removeClass("single-input-focus");
			inputFld.addClass('userpersonaldetails-errorClass');
		}
	}
}

function showTooltip(id, message){
	AUI().ready('aui-tooltip', 'aui-io-plugin', function(A) {
		var tooltip = new A.Tooltip({
			trigger: '#'+id,
			align: { points: [ 'lc', 'rc' ] },
			showArrow: false,
			bodyContent: message
		})
		.render();
	});
}

/**
 *  Validation related JS codes
 */
function validateMultipleFields(fieldToUpdate){
	var A = AUI();
	var fieldInput = A.one('#'+fieldToUpdate);
	var valueText = "";
	if(fieldInput){
		valueText = fieldInput.val();
	}
	clearState(fieldToUpdate);
	if(valueText != ''){
		if(valueText.toLowerCase().indexOf('<script>') == -1){
			if(valueText.toLowerCase().indexOf('<style>') == -1){
				return true;
			}else{
			var addWH = A.one('#workhistory_add');
				if(addWH != null){
	 			addWH.addClass('cross');
	 			showTooltip("workhistory_add","Please do not enter any HTML tags");
				}	
				return false;
			}
		}else{
			var addWH = A.one('#workhistory_add');
				if(addWH != null){
	 			addWH.addClass('cross');
	 			showTooltip("workhistory_add","Please do not enter any HTML tags");
				}	
				return false;
		}
	}else{
			if(fieldInput){
				if(fieldToUpdate.indexOf('work_description') == -1){
					var validation_key = fieldInput.attr("validation_key");
					return validateInput(fieldToUpdate,"",validation_key);
				}	
			}
		}
	
	return true;
}


function validateMandatory(field){
	var mandatory = document.getElementById(field).getAttribute('mandatory');
	var valueText = document.getElementById(field).value;
	if(mandatory == "true"){
		if(valueText == ""){
			return "This field is required.";
		}
	}
	return "";
}

function validateInputForScriptTag(fieldId,fieldPostFix,validation_key){

	var fieldName = fieldId+fieldPostFix;
	var A = AUI();
	
	var fieldInput = A.one('#'+fieldName);
	var section_name = fieldInput.attr('section_name');
	
	if(section_name == null || section_name == ""){
		section_name = fieldName;
	}
	
	if(fieldInput == null){
		return true;
	}
	
	var valueText = fieldInput.val();
	if(valueText.toLowerCase().indexOf('<script>') == -1){
		if(valueText.toLowerCase().indexOf('<style>') == -1){
			return true;
		}else{
			errorState(section_name, "Please do not enter any HTML tags");
			return false;
		}
	}else{
		errorState(section_name, "Please do not enter any HTML tags");
		return false;
	}
}
/**
 * returns true if field input value is valid
 */ 
function validateInput(fieldId,fieldPostFix,validation_key){
	var fieldName = fieldId+fieldPostFix;
	var A = AUI();
	
	var fieldInput = A.one('#'+fieldName);
	var section_name = fieldInput.attr('section_name');
	
	if(section_name == null || section_name == ""){
		section_name = fieldName;
	}
	
	if(fieldInput == null){
		return true;
	}
	
	var valueText = fieldInput.val();
	var requiredMsg = validateMandatory(fieldName);
	
	if(requiredMsg != ""){
		errorState(section_name, requiredMsg);
		return false;
	}

	if(valueText === "") return true;
	

	if((valueText.match(/([\<])([^\>]{1,})*([\>])/i) == null)){
	var exp,error_msg;
	switch(validation_key){
		case "0": //none
			exp = "";
			break;
		case "1": //decimal/numeric
			exp="^[-+]?[0-9]+(\.[0-9]+)?$";//"^\d*[0-9](\.\d*[0-9])?$";
			error_msg= "Please enter digits only";
			break;
		case "2": //alpha-numeric
			exp="^[0-9a-zA-Z ]+$";
			error_msg= "Please enter alphanumeric only";
			break;
		case "3": //url
			exp="(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?";
			exp="^((ht|f)tps?://)?[a-z0-9-\\.]+\\.[a-z]{2,4}/?([^\\s<>\\#%\"\\,\\{\\}\\\\|\\\\\\^\\[\\]`]+)?$";
			error_msg="Please enter valid URL";
			break;
		case "4": //phone
			exp="^\\+?\\d{1,5}-?\\d*$";
			error_msg="Please enter valid phone number";
			break; 
		case "5": //email
			exp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+(?:[A-Z]{2}|com|org|net|edu|gov|mil|biz|info|mobi|name|aero|asia|jobs|museum)";
			error_msg="Please enter valid email";
			break;
		case "6": //letters only
			exp="^[a-zA-Z ]+$";
			error_msg="Please enter alphabets only";
			break;
		case "7": //whole numbers only
			exp="^[0-9]+$";
			error_msg="Please enter numbers only";
			break;
		default: return true;
	}
	
	if (validation_key == "3") {
        if (startsWith(valueText,'www.',false)) {
            valueText = valueText.substring(4);
        }
    }
	
	if(new RegExp(exp).test(valueText)){
		return true;
	}else{
		errorState(section_name, error_msg);
		return false;
	}
	}else{
		errorState(section_name, "Please do not enter any HTML tags");
	}
}

function validateLinkedIn(fieldId,fieldPostFix){
    var fieldName = fieldId+fieldPostFix;
    var fieldInput = document.getElementById(fieldName);
    var section_name = fieldInput.getAttribute('section_name');
    
    if(section_name == null || section_name == ""){
        section_name = fieldName;
    }
    
    if(fieldInput == null){
        return true;
    }
    
    var valueText = fieldInput.value;
    var requiredMsg = validateMandatory(fieldName);
    
    if(requiredMsg != ""){
        errorState(section_name, requiredMsg);
        return false;
    }

    if (startsWith(valueText,'www.',false)) {
        valueText = valueText.substring(4);
    }
    
    if(valueText.indexOf('linkedin.com') > -1 ){
        return true;
    }else{
        errorState(section_name, "Please enter valid linkedin URL");
        return false;
    }
}

function startsWith(haystack,needle,isCaseSensitive){  
    if(isCaseSensitive){  
    	haystack=haystack.toUpperCase();  
    	needle=needle.toUpperCase();  
    }  
    return haystack.substr(0,needle.length)==needle?true:false;  
}  


function validateSocialSiteUrl(fieldId){
	var A = AUI();
	var validSocialSites = "twitter,facebook,linkedin";//allowed social sites for validation
	var category = A.one("#"+fieldId).attr("category") ;
	var textValue = A.one("#"+fieldId).val();
	
	if(textValue == ''){//dont allow empty url
		errorState(fieldId, "Field should not be empty.");
		return false;
	}
	
	if(!validateInput(fieldId,'','3'))//3 = validate URL
		return false;

	
	if(validSocialSites.indexOf(category) < 0){//skip validation if not on the list of allowed social sites
		clearState(fieldId);
		return true;
	}
	
	var isValid = validateDomainUrl(category + ".com",textValue);
	if(!isValid){
		errorState(fieldId, "Please enter valid " + category + " URL");
		return false;
	}
	
	return true;
}

function validateDomainUrl(domain,input){
	input=input.trim();
	if(input.indexOf("//")>-1){
		var http=input.substring(0,input.indexOf("//"));
		switch(http){
			case "http:":
			case "https:":
			break;
			default:
			return false;
		}
		input=input.substring(input.indexOf("//")+2);
		if(input.indexOf("//")>-1){
			return false;
		}
	}
	if(input.indexOf("/")===-1)return false;
	input=input.substring(0,input.indexOf("/"));
	if(input.length<domain.length)return false;
	if(input.substring(input.length-domain.length)===domain)return true;
	else return false;
}	

/**
 * HTML related JS codes
 */
function removeElement(ID){
	var el = document.getElementById(ID);
	if (el != null) {
		var remElement = (el.parentNode).removeChild(el);
	}
}

function removeSingleInputInstance(category, categoryDetails, instance, count){
	removeInputAjaxCall(category, categoryDetails, instance, count, '');
}

function insertHTMLSingleInput(response,category)
{
	var id = category;
	var parent=document.getElementById(id);
	var newdiv=document.createElement("div");
	
	newdiv.innerHTML=response;
	parent.appendChild(newdiv);
}

function insertHTMLForEdit(response, category, instance, displayfield){
	var divView = document.getElementById(category + "_" + instance);
	var divEdit = document.getElementById(category + "_edit_" + instance);
	divView.innerHTML = "";
	divEdit.innerHTML = response;
	hideButtonSaveUndo(category, instance);
	
	var A = AUI();
	var divNode = A.all("." + category + "_editAlign");
	
	divNode.each(function() {
		var node = this;
		
		var divEditButtonInstance = node.attr('instance');
		
		if(instance != divEditButtonInstance){
			node.setStyle('display','none');
	    }
	});

}

function insertHTMLforAdd(response, category, instance, displayfield){
	var divId = document.getElementById(category + "_details");
	var newDiv = document.createElement('div');
	newDiv.setAttribute("id", category + "_" + instance);
	newDiv.setAttribute("class","bottomgap");
	newDiv.innerHTML = response;
	
	var s = divId.getElementsByTagName('div')[0];
	
	if(s){
		divId.insertBefore(newDiv, s);
	}else{
		divId.appendChild(newDiv);
	}
	
	hideButtonSaveUndo(category, instance);
	
	var A = AUI();
	var divNode = A.all("." + category + "_editAlign");
	
	divNode.each(function() {
		var node = this;
		
		var divEditButtonInstance = node.attr('instance');
		
		if(instance != divEditButtonInstance){
			node.setStyle('display','none');
	    }
	});
}

function hideAddButton(category, hide){
	var ctg = category;
	var id=ctg + "_add";
	var element = document.getElementById(id);
	if(element != null){
		if(hide)
			element.style.display="none";
		else
			element.style.display="inline";
	}
}

function hideElement(elementId, hide){
	var element = document.getElementById(elementId);
	if(element != null){
		if(hide)
			element.style.display="none";
		else
			element.style.display="inline";
	}
}


function insertHTMLforSave(response, category, instance){
	var id=category + "_details";
	var parent = document.getElementById(id);
	parent.innerHTML = "";
	parent.innerHTML = response;
}

function hideButtonSaveUndo(category, instance){
	var id = category + '_button_' + instance;
	var A = AUI();
	var divNode = A.all("." + category + "-savedatabutton");
	
	divNode.each(function() {
		var node = this;
		
		if(id != node.attr('id')){
			node.setStyle('display','none');
	    }
	});
	/*jq("." + category + "-savedatabutton").each(function (index) {
	       var id = category + '_button_' + instance;
	       if(id != this.id){
	    	   document.getElementById(this.id).style.display = "none";
	       }
	});*/
}
/***
function removeHTMLforCancel(response, category, instance){
	var id = category + "_details";
	var parent=document.getElementById(id);
	parent.innerHTML="";
}
****/

function showButtonSaveUndo(category, instance){
	var id = category + '_editAlign';
	var ePresents = document.getElementsByName(id);
	if (Liferay.Browser.isIe()) {
		var divTag = document.getElementsByTagName("div");
		for(var i=0;i<divTag.length;i++){
			//alert("Liferay.Browser.isIe()2 " + divTag.item(i).getAttribute("name") + " " + divTag.item(i).getAttribute("Name"));
			  if(divTag.item(i).getAttribute("Name") == id ){
				  //alert("Liferay.Browser.isIe()3 " + divTag.item(i).getAttribute("Name"));
				  divTag.item(i).style.display = "inline";
			  }
			}
	}
		for(x=0;x<ePresents.length;x++)
		{
			if( ePresents[x].style.display == "none" )
			{
				ePresents[x].style.display = "inline";
			}
		}
}		

function removeHTML(category,instance){
	var idInput = category + "_" + instance;
	removeElement(idInput);
	hideSaveButton(category);
	hideAddButton(category, false);
}


function incrementCounter(categoryName){
	var counter = document.getElementById(categoryName + "_counter");
	var newCount = 0;
	
	if(counter){
		newCount = parseInt(counter.value) + 1;
	}
	counter.value = newCount;
	return newCount;
}

function addSaveButton(category,instanceCount,displayfield){
	var divId = category+"Save";
	var ctg = category;
	var listId = ctg + "List";	
	var id=ctg + "_button";
	var linkId = ctg + "_save";
	var cancelId = ctg + "_cancel";
	var element = document.getElementById(id);
	var divElement = document.getElementById(divId);
	var buttonElement = "<div style='display:inherit' id=" + divId +"><a class='book update-button' id=" + linkId + " title='save'>&#160;</a></div><div style='display:inherit'><a class='book undo-button' id=" + cancelId +" title='cancel'>&#160;</a></div>";
	if(divElement == null){ 
	if(element != null){
	element.innerHTML = buttonElement;
	}
	}
	var element1 = document.getElementById(linkId);
	var cancelElement = document.getElementById(cancelId);
	if(element1 != null){
		element1.setAttribute("href","javascript:saveInfo('" + category + "', '" + instanceCount + "','" + listId + "','" + displayfield + "')");
		cancelElement.setAttribute("href","javascript:cancelInfo('" + category + "', '" + instanceCount + "','" + listId + "','" + displayfield + "')");
	}	
}

function hideSaveButton(category){
	var ctg = category;
	var id=ctg + "_button";
	var element = document.getElementById(id);
	if(element != null){
		element.innerHTML="";
	}
}

/**
 * Calendar related functions
 */
function GetPos() {
    var left = 0, top = 0;
    var element=this;
    while (true) {
        left += element.offsetLeft;
        top += element.offsetTop;
        var parent = element.offsetParent;
        if (parent === null) {
            break;
        }
        element = parent;
    }
    return [left, top];
}

//Calender for workhistory
function callIsPresentJob(inputId,checkId){
	var chk = document.getElementById(checkId);
	var eDate = document.getElementById(inputId);
	var ePresents = document.getElementsByName("work_history_date");

	if(chk.checked)
	{
		//eDate.value = "Present";
		
		var errMsg = "";
		for(x=0;x<ePresents.length;x++)
		{
			if( ePresents[x].value == "Present" )
			{
				//temporary commented
				errMsg = "Present job already in your work history";
			}
		}
		
		if(errMsg !== "")
		{
			/*jq('.msg_tooltip').tooltip({
				speed:700
			});*/
			
			errorState(inputId, errMsg);
		} else
		{
			eDate.value = "Present";
		}
		
	}else{
		eDate.value = "";
	}
}
/* Joseph Phe Code for date validtaion for workhistory */

function GetDate(text)
{
	var text1 = text.toString();
	var splits=text1.split("/");
	var xx=splits.length;
	
	for(var x=0;x<xx;++x){
		splits[x]=parseInt(splits[x],10);
	}
	return new Date(splits[2],splits[1]-1,splits[0]);
}

function CompareDate(date1,date2)
{
	var year1=date1.getFullYear();
	var year2=date2.getFullYear();
	
	if(year1 < year2)
		return -1;
	
	else if(year1 > year2)
		return 1;
	
	var month1=date1.getMonth();
	var month2=date2.getMonth();
	
	if(month1<month2)
		return -1;
	
	else if (month1>month2)
		return 1;
	
	var date1=date1.getDate();
	var date2=date2.getDate();
	
	if(date1<date2)
		return -1;
	
	else if (date1>date2)
		return 1;
	
	return 0;
}
function DateBetween(input,start,end){
	return CompareDate(input,start)===1 && CompareDate(input,end)===-1;
}

function VerifyAllDates(){
	var i=1;
	var start_dates=[];
	var end_dates=[];
	while(true){
		var start=document.getElementById("start_date_"+i);
		if(start===null){
			break;
		}
		var end=document.getElementById("end_date_"+i);
		
		clearState("start_date_"+i);
		clearState("end_date_"+i);
		
		if (start.value!=="" && end.value!==""){
			var start_date=GetDate(start.value);
			var end_date = "";
			
			if(end.value == "Present"){
				var currentTime = new Date();
				var month = currentTime.getMonth() + 1;
				var day = currentTime.getDate();
				var year = currentTime.getFullYear();
				//end.value = day + "/" + month + "/" + year;
				end_date=GetDate(day + "/" + month + "/" + year);
			}else{
				end_date=GetDate(end.value);
			}	
			//var end_date=GetDate(end.value);
			var xx=start_dates.length;
			
			if(CompareDate(start_date,end_date)===1){
				errorState("start_date_"+i,"Start Date Greater than End Date!");
				errorState("end_date_"+i,"Start Date Greater than End Date!");
				return "Start Date Greater than End Date!";
			}
			for(var x=0;x<xx;++x){
				if(CompareDate(start_date,start_dates[x])===0 && CompareDate(end_date,end_dates[x])===0){
					return "Dates overlap";
				}
				if(DateBetween(start_date,start_dates[x],end_dates[x])){
					return "Dates overlap";
				}
				if(DateBetween(end_date,start_dates[x],end_dates[x])){
					return "Dates overlap";
				}
				if(CompareDate(end_date,end_dates[x])===1 && CompareDate(start_date,end_dates[x])===-1){
					return "Dates overlap";
				}
			}
			start_dates.push(start_date);	
			end_dates.push(end_date);
		}
		++i;
	}
	return "";
}


function fValidateForwardDated( value )
{
	var currentTime = new Date();
	var month = currentTime.getMonth() + 1;
	var day = currentTime.getDate();
	var year = currentTime.getFullYear();
	
	var crntDate = GetDate(day + "/" + month + "/" + year);
	var inputDate = GetDate(value);
	
	var errMsg = "";
	
	if( inputDate > crntDate )
	{	
		errMsg = "Date should not be later than current date";
		return errMsg;
	}
	
	return errMsg;
}

function fCurrentDateFormat()
{
	var currentDate = new Date();
	
	var month = currentDate.getMonth() + 1;
	var day = currentDate.getDate();
	var year = currentDate.getFullYear();
	
	return day + "/" + month + "/" + year;
}

//show the calendar image in personal info
function fShowCalendarBtn(diVid,args)
{
	if(args == "1" )
	{
		document.getElementById(diVid).style.display = 'block';
	}else
	{
		document.getElementById(diVid).style.display = 'none';
	}
		
}

var count = 100;
AUI().ready('aui-dialog', 'aui-overlay-manager', 'dd-constrain', function(A) {

	var upgradeView = A.one('#upgradeView');
	var loginView = A.one('#loginView');	
	
	for(i=0;i<count;i++) {
		if(A.one('#loginView'+i)){
			A.one('#loginView'+i).on(
				'click',
				function(event) {
			var name = this.get('name');
			var title = this.get('title');
			_callPopup(name,title);
			});
		}	
	}
	
	for(i=0;i<count;i++) {
		if(A.one('#upgradeView'+i)){
			A.one('#upgradeView'+i).on(
				'click',
				function(event) {
			var name = this.get('name');
			var title = this.get('title');
			_callPopup(name,title);
			});
		}	
	}
	function _callPopup(name, title) {
		var popup = new A.Dialog(
				{
					centered: true,
					destroyOnClose: true,
					title: title,
					modal: true,
					height: 219,
					width: 515
				}
			).render();
				popup.plug(
					A.Plugin.IO, {
						uri: name
					}
			);
	}
});

function upgradeViewTitle(id,title){
		var upgradeId = id;
		var upgrade = document.getElementById(upgradeId);
		if(upgrade != null)
		upgrade.setAttribute('title', title);
}


function fValidateStartAndEndDate(end_date)
{	
	var start_date = document.getElementById('hdnStartDate').value;
	var startDate = GetDate(start_date);
	var endDate = GetDate(end_date);
	var errMsg = "";
	
	if( startDate > endDate )
	{
		errMsg = "End date should be later than start date";
	}
	
	return errMsg;
}

function fValidateOverlapping(input_id)
{
	var inputObj = document.getElementById(input_id);
	var errMsg = "";
	var i = 1;
	
	do{
		var startDate = document.getElementById('start_date_'+i);
		var endDate = document.getElementById('end_date_'+i);
		
		if(startDate == null && endDate == null)
		{
			break;
		}
		
		errMsg = fCompareDate(startDate,endDate,inputObj,input_id);
		
		if(errMsg != "")
		{
			return errMsg;
		}
		
		i++;
	}while(true);
	
	return errMsg;
}

function fCompareDate(startDate,endDate,inputObj,input_id)
{
	var hdnStartDate = document.getElementById('hdnStartDate');
	var hdnEndDate = document.getElementById('hdnEndDate');
	
	var hdn_start_date = GetDate(hdnStartDate.value);
	var selected_date = GetDate(inputObj.value);
	
	var errMsg = "";
	
	var start_date = GetDate(startDate.value);
	var end_date = "";
	
	if(endDate.value == "Present")
	{
		end_date = GetDate(fCurrentDateFormat());
	} else
	{
		if(endDate.value != "")
		{
			end_date = GetDate(endDate.value);
		}
	}
	
	if(input_id.indexOf('start_date') == 0)
	{
		if(hdnEndDate.value != "")
		{
			var hdn_end_date = GetDate(hdnEndDate.value);
		
			if(selected_date.getTime() == start_date.getTime())
				return fGetErrMessage();
			
			if(fValidateIfNullorBlank(end_date))
			{
				if(selected_date < start_date)
					return fGetErrMessage();
			}

			if(selected_date < start_date && hdn_end_date > end_date)
				return fGetErrMessage();	
			
		}else
		{
			if(end_date == "")
			{
				if(selected_date.getTime() == start_date.getTime())
					return fGetErrMessage();
				
				if( hdnEndDate.value != "")
				{
					if(selected_date.getTime() < start_date.getTime())
						return fGetErrMessage();
				}
			}else
			{
				if(selected_date.getTime() == start_date.getTime())
					return fGetErrMessage();
			}
		}
	}else if(input_id.indexOf('end_date') == 0)
	{
		if(hdnStartDate.value != "")
		{
			if(end_date != "")
			{
				if(selected_date.getTime() == end_date.getTime())
					return fGetErrMessage();
				
				if(fValidateIfNullorBlank(end_date))
				{
					if(selected_date < end_date)
						return fGetErrMessage();
				} 

				if(hdn_start_date < start_date && selected_date > end_date)
					return fGetErrMessage();
				
				if(hdn_start_date < start_date && selected_date < end_date)
					return fGetErrMessage();
			} else
			{
				if(hdn_start_date < start_date && selected_date > end_date)
					return fGetErrMessage();	
			}
		}else
		{
			if(hdnStartDate.value != "")
			{
				document.getElementById(input_id).value = "";
				return "Must select the start date before end date.";
			}
		}
	}
	return errMsg;
}

function fValidateIfNullorBlank( args )
{
	if(args == "" || args == null)
		return true;
	else
		return false;
}

function fGetErrMessage()
{
	return "Date overlaps with other existing work history. Please select other date.";
}

function fThisShowHide(id,containId)
{
	document.getElementById(id).style.display = 'none';
	document.getElementById(containId).style.display = 'block';
}

function trimString(s)
{
    if( typeof(s) === 'undefined' )
    {
    	return;
    }
    return s.replace(/^\s+|\s+$/g,"");
}

