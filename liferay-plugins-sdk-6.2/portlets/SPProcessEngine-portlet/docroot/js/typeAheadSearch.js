var typeAheadSearch = function(config) {

	var className = config.className;
	var sourceJSON = config.sourceJSON;
	var valueToBeSaved = config.valueToBeSaved;
	var idToBeSaved = config.idToBeSaved;
	var displayDiv = config.displayDiv;
	var inputNodeId = config.inputNodeId;
	var placeHolder = config.placeHolder;
	
	autoCompleteList();
	
	function autoCompleteList() {
		AUI().use(
				'aui-node',
				'aui-base',
				'aui-io-request',
				'autocomplete-list',
				'aui-io-request',
				'autocomplete-filters',
				'autocomplete-highlighters',
				function(A) {
					if (sourceJSON) {
						var autoComplete = new A.AutoCompleteList({
							allowBrowserAutocomplete : 'false',
							inputNode : className,
							activateFirstItem : 'true',
							source : sourceJSON,
							resultTextLocator : 'code',
							resultHighlighter : 'phraseMatch',
							resultFilters : 'phraseMatch',
							minQueryLength : 1,
							maxResults : 1000,
							queryDelimiter : ',',
							on : {
								select : function(event) {
									var result = event.result.raw;
									var elementToSaveValues = document
											.getElementById(valueToBeSaved);
									var elementToSaveId = document
											.getElementById(idToBeSaved);
									createSelectedList(result.code, result.key,
											displayDiv, valueToBeSaved);
									elementToSaveValues.value = result.code;
									elementToSaveId.value = result.key;
									document.getElementById(inputNodeId).classList.remove("Error-success");
				    				document.getElementById(inputNodeId).classList.remove("Error");
				    				document.getElementById(inputNodeId).placeholder=placeHolder;
								}
							},
							 after: {
	                                select: function (event) {
	                                    clearAutoCompleteData(inputNodeId);
	                                }
	                            },
							render : 'true'
						}).render();
					}
				});
	}
	
	function clearAutoCompleteData(id){
		var elm = document.getElementById(id);
		elm.value = '';
	}
	
	function createSelectedList(listName, listId, displayDiv, valueDiv){
		var selListDiv = document.getElementById(displayDiv);
		var div1 = document.createElement('div');
		div1.setAttribute("class", "selWrap");
		div1.setAttribute("id", "selWrap_" + listId);
		var div2 = document.createElement('div');
		div2.setAttribute("class", "sel-list-name");
		var span1 = document.createElement('span');
		var text1 = document.createTextNode(listName);
		span1.appendChild(text1);
		div2.appendChild(span1);
		div1.appendChild(div2);
		
		if(selListDiv.hasChildNodes()){
			selListDiv.replaceChild(div1, selListDiv.firstChild);
		}else{
			selListDiv.appendChild(div1);
		}
		
		if(listName){
			var errorDiv = A.one("#productNameErrorDiv");
			errorDiv.html("");
			errorDiv.addClass("hide");
		}
		
	}
}