var typeAheadSearch = function(config) {

    var className = config.className;
    var sourceJSON = config.sourceJSON;
    var valueToBeSaved = config.valueToBeSaved;
    var idToBeSaved = config.idToBeSaved;
    var displayDiv = config.displayDiv;
    var inputNodeId = config.inputNodeId;
    var placeHolder = config.placeHolder;
    var dotCreation = true;

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
                        allowBrowserAutocomplete: 'false',

                        inputNode: className,
                        activateFirstItem: 'true',
                        source: sourceJSON,
                        resultTextLocator: 'code',
                        resultHighlighter: 'phraseMatch',
                        resultFilters: 'phraseMatch',
                        minQueryLength: 1,
                        maxResults: 1000,
                        queryDelimiter: ',',
                        on: {
                            select: function(event) {
                                var result = event.result.raw;
                                var elementToSaveValues = document
                                    .getElementById(valueToBeSaved);
                                var elementToSaveId = document
                                    .getElementById(idToBeSaved);
                                var resultCodeid = result.code;
                                var resultUsrNamevalue = result.userName;
                                var resultUsrImagevalue = result.userImg;
                                var resMailaddress = resultCodeid;
                        		var alreadySelected = false;
                                var usTagsNames = document.getElementsByClassName("usTags");
                                for (var i = 0; i < usTagsNames.length; i++) {
                                    	var userId = usTagsNames[i].getAttribute('data-id');
                                    	if (result.key == userId){
                                    		alreadySelected = true;
                                    		break;
                                    	}
                                }
                                if (!alreadySelected){
                                	createSelectedList(resMailaddress, resultUsrNamevalue, resultUsrImagevalue, result.key,
                                			displayDiv, valueToBeSaved);
                                	elementToSaveValues.value = resMailaddress;
                                	elementToSaveId.value = result.key;
                                }
                                try {
                                    elementToSaveId.onchange();
                                } catch (e) {}
                                document.getElementById(inputNodeId).classList.remove("Error-success");
                                document.getElementById(inputNodeId).classList.remove("Error");
                                document.getElementById(inputNodeId).placeholder = placeHolder;
                            }
                        },
                        after: {
                            select: function(event) {
                                clearAutoCompleteData(inputNodeId);
                            }
                        },
                        render: 'true'
                    }).render();
                }
            });
    }

    function clearAutoCompleteData(id) {
        var elm = document.getElementById(id);
        elm.value = '';

    }



    function createSelectedList(listEmail, listUserName, listUserImg, listId, displayDiv, valueDiv) {
        var selListDiv = document.getElementById(displayDiv);
        var div1 = document.createElement('div');
        div1.setAttribute("class", "usTags");
        div1.setAttribute("id", "selWrap_" + listId);
        div1.setAttribute("data-id", listId);
        var div2 = document.createElement('div');
        div2.setAttribute("class", "sel-list-name");
        var span1 = document.createElement('p');
        span1.setAttribute("title", listUserName + "[" + listEmail + "]");
        var userNameSplitvalue = listUserName.substring(0, 14);
        var text1 = document.createTextNode(userNameSplitvalue);
        span1.appendChild(text1);
        div2.appendChild(span1);
        var div3 = document.createElement('div');
        div3.setAttribute("class", "sel-list-remove");
        var span2 = document.createElement('p');
        span2.setAttribute("class", "removeSelList");
        span2.setAttribute("onClick", "removeElement(" + listId + "," +
            valueDiv + ")");
        span2Img = document.createElement('IMG');
        span2Img.src = '/SPActivityHub-portlet/images/cancelactivity.svg';


        span2.appendChild(span2Img)
        div3.appendChild(span2);
        div1.appendChild(div2);
        div1.appendChild(div3);
        selListDiv.appendChild(div1);


        // USER IMAGE SELECT
        var userActiveWrap = document.getElementById("userSelectDiv");
        var xUsrImgDiv = document.createElement("div");
        xUsrImgDiv.setAttribute("class", "aPIcon");
        xUsrImgDiv.setAttribute("id", "usrWrap_" + listId);
        xUsrImg = document.createElement("img");
        // xUsrImg.setAttribute("title", listUserName);
        xUsrImg.src = listUserImg;
        xUsrImgDiv.appendChild(xUsrImg);
        userActiveWrap.appendChild(xUsrImgDiv);


        //USER FULL LIST COUNT
        var uluserListAll = document.getElementById('inserUserWrapUL_id');
        var insertUserDivLI = document.createElement('DIV');
        insertUserDivLI.setAttribute('class','lucWrap');
        insertUserDivLI.setAttribute('id', 'userListLiID_' + listId)
        var userImgList = document.createElement('IMG');
        userImgList.src = listUserImg;
        var UserDivMailContent = document.createElement('DIV');
        UserDivMailContent.setAttribute('class', 'mailNameWrap');
        var userNameList = document.createElement('P');
        userNameList.innerHTML = listUserName;
        var userMailList = document.createElement('SPAN');
        userMailList.innerHTML = listEmail;

        insertUserDivLI.appendChild(userImgList);
        UserDivMailContent.appendChild(userNameList);
        UserDivMailContent.appendChild(userMailList)
        insertUserDivLI.appendChild(UserDivMailContent);
        uluserListAll.appendChild(insertUserDivLI);


        var nodeDot;
        nodeDot = document.createElement("DIV");
        nodeDot.setAttribute('class', 'userActionDot');
        nodeDot.setAttribute('id', 'userActionDot_id_' + listId);
        nodeDot.addEventListener('click', function(userAddList) {
            var userAllId = document.getElementById('inserUserWrap_id');
            userAllId.classList.add('activeAction');



        })

        //DOT CREATION INSERT BEFORE 1st NODE
        var itemDivs = document.getElementById("userSelectDiv");
        var itemDivsChildboolean = document.getElementById("userSelectDiv").children;
        if (itemDivsChildboolean.length <= 2) {

            dotCreation = true;
        }
        var itemDivsChildId = document.getElementById("userSelectDiv");
        var itemDivsChild = document.getElementById("userSelectDiv").children;
        if (dotCreation) {
            if (itemDivsChild.length > 2) {
                itemDivsChildId.insertBefore(nodeDot, itemDivsChild[1]);
                dotCreation = false;
            }
        }

        //HIDE AND SHOW THE USER
        if (itemDivs.childNodes.length > 2) {
            for (var i = 0; i < itemDivsChild.length; i++) {
                itemDivsChild[i].classList.add('hide');
                itemDivsChild[0].classList.add('show');
                itemDivsChild[1].classList.add('show');
                nodeDot.classList.add('show');
            }
        }


        //USTAGS COUNT
        // use the native .trim() if it exists
        //   otherwise use a regular expression 
        var summaryDiv = document.getElementById("SelectedEnterpriseCreate");
        var lockIcon = document.getElementById('convLock');
        var lockUnLockIcon = document.getElementById('convunLock');
        var associateActive = document.getElementById('asoociateAct');


        if (summaryDiv.childNodes.length > 0) {
            lockIcon.classList.add("hide");
            lockIcon.classList.remove("show");
            lockUnLockIcon.classList.remove("hide");
            lockUnLockIcon.classList.add("show");

            if (associateActive) {
                associateActive.classList.add("removeAssociate");
            }

        }

    }

}

function removeElement(listId, valueDivElem) {
    var elem = document.getElementById("selWrap_" + listId);
    var elemId = valueDivElem; //document.getElementById(valueDivElem);
    elemIdValues = elemId.value;
    var elemUser = document.getElementById("usrWrap_" + listId);
    var nodeDotRemove = document.getElementById("userActionDot_id_" + listId); //
    var userListidRemove = document.getElementById("userListLiID_" + listId)
    var itemDivsChildIdRemove = document.getElementById("userSelectDiv").children;
    var elemUserId = valueDivElem; //document.getElementById(valueDivElem);
    elemUserIdValues = elemUserId.value;
    console.log(listId);

    if (elemIdValues.indexOf(listId) != -1) {
        var val = "," + listId;
        if (elemIdValues.indexOf(val) != -1) {
            elemIdValues = elemIdValues.replace(new RegExp(val), '');
        } else {
            elemIdValues = elemIdValues.replace(new RegExp(listId), '');
        }
        if (elemIdValues == ',') {
            elemIdValues = '';
        }
        elemIdValues = elemIdValues.replace(new RegExp(',,'), ',');
        elemId.value = elemIdValues;
    }

    elemUser.remove();
    elem.remove();
    userListidRemove.remove();

    var summaryDiv = document.getElementById("SelectedEnterpriseCreate");
    var lockIcon = document.getElementById('convLock');
    var lockUnLockIcon = document.getElementById('convunLock');
    var associateActive = document.getElementById('asoociateAct');
    var associateActiveRemove = document.getElementById('ascRemoveAction');
    if (summaryDiv.childNodes.length == 2) {
        if (nodeDotRemove) {
            nodeDotRemove.remove();
        }

    }
    if (summaryDiv.childNodes.length <= 0) {
        lockUnLockIcon.classList.remove("show");
        lockUnLockIcon.classList.add("hide");
        lockIcon.classList.add("show");
        lockIcon.classList.remove("hide");



        if (associateActive) {
            associateActive.classList.remove("removeAssociate");
        }

        if (associateActiveRemove) {
            associateActiveRemove.classList.remove("show");
        }


    }
    return true;
}
