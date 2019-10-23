var spConversation = function(config) {
    var AArray = A.Array;
    var instance;
    var searchCriteriaChangedConv = false;
    this.init = function(config) {
        instance = this;
        this.pns = config.pns;
        this.ajaxUrl = config.ajaxUrl;
        this.entityId = config.entityId;
        this.entityClassId = config.entityClassId;
        this.entityClassName = config.entityClassName;
        this.ajaxUrlFileUpload = config.ajaxUrlFileUpload;
        this.associatedWith = config.associatedWith;
        this.extUser = config.extUser;
        this.closedStageId = config.closedStageId;

        this.saveMessage = A.one("#saveMessage");
        this.message = A.one("#conversationTxtArea");
        this.userLockBtn = A.one("#userLockBtnId");
        this.uploadsFileEntryId = A.one("#uploadsFileEntryIdConv");
        this.ascRemoveAction = A.one("#ascRemoveAction");

        
        if (instance.closedStageId != 0) {
         	 var convosAddremove = document.getElementById('myTab');
              convosAddremove.classList.add("hide");
       }else{
      	   var convosAddremove = document.getElementById('myTab');
             convosAddremove.classList.remove("hide");
       }
        
        this.initializeSaveMessage();
        this.initializeLoadConversation();
        this.initializeFileUpload();
        
        var currentUrl = window.location.href;
        var url = new URL(currentUrl);
        var convUuid = url.searchParams.get("convUuid");

        if (currentUrl.includes("convUuid")){
        	this.loadConversation();
        	A.all('.actDetailContent').each(function(node) {
        		if (node._node.getAttribute('uuid') == convUuid){
        			node.simulate('click');
        		}
	        });
        }
       


    }


    this.initializeSaveMessage = function() {
        if (A.one("#saveMessage")) {
            A.one("#saveMessage").on("click", function() {
                instance.saveConversation();
            });
        }

    }

    this.initializeFileUpload = function() {
        if (A.one("#convFile")) {
            A.one("#convFile").on("change", function() {
                instance.GetFileSizeNameAndTypeConv();
                A.one("#convFile").ancestor().ancestor().removeClass('activeAction');
            });
        }

    }

    this.initializeEnterKeySearch = function() {
        var nodes = [A.one("#searchInpBar_Id")];
        var nodeList = new A.NodeList(nodes);
        nodeList.on("keypress", function(ev) {
            // click on enter
            if (ev.keyCode == 13) {
                searchCriteriaChangedConv = true;
                instance.loadConversation();
            }
        });
    }

    this.initializeLoadConversation = function() {

        if (A.one("#convLoad")) {

            A.one("#convLoad").on("click", function() {

                instance.loadConversation();

            });

            if (instance.extUser == "External") {
                instance.loadConversation();
            }




        }

    }




    this.saveConversation = function() {
    	
    	var validationResult = validateReqField("tab-convos","");

    	if (!validationResult){
	        var obj = {};
	        obj.action = "saveConversation";
	        if (instance.message) {
	            obj.message = instance.message.getDOMNode().innerHTML;
	        }
	        obj.entityId = instance.entityId;
	        obj.entityClassId = instance.entityClassId;
	        obj.entityClassName = instance.entityClassName;
	        obj.associatedWith = instance.associatedWith;
	        obj.uploadsFileEntryId = instance.uploadsFileEntryId.val();
	        var userId = '';
	        A.all('.usTags').each(function(node) {
	            userId = userId + "," + node._node.getAttribute('data-id');
	        });
	        obj.sentToUserId = userId;
	        if (instance.ascRemoveAction) {
	            if (instance.ascRemoveAction.hasClass('show')) {
	                obj.restricted = 1;
	            } else {
	                obj.restricted = 0;
	            }
	        }
	
	        A.io.request(instance.ajaxUrl, {
	            dataType: 'json',
	            method: 'POST',
	            sync: true,
	            data: obj,
	            on: {
	                success: function() {
	                    var data = this.get("responseData");
	                    if (data) {
	                        if (data.error) {
	                            alert(data.error);
	                        } else {
	                        	instance.clearConversation();
	                            instance.loadConversation();
	                        }
	                    }
	
	                },
	                failure: function() {
	                    alert('Error while saving message');
	                }
	            }
	        });
    	}
    }
    
    this.clearConversation =  function(){
    	instance.message.getDOMNode().innerHTML = "";
    	if (document.getElementById('userSelectDiv')){
    		document.getElementById('userSelectDiv').innerHTML = "";
    	}
    	if (document.getElementById('SelectedEnterpriseCreate')){
    		document.getElementById('SelectedEnterpriseCreate').innerHTML = "";
    	}
    	if (document.getElementById('asoociateAct')){
    		document.getElementById('asoociateAct').classList.remove("removeAssociate");
    		document.getElementById('ascRemoveAction').classList.remove("show");
    	}
    	if (document.getElementById('convLock')){
    		document.getElementById('convLock').classList.remove("hide");
    		document.getElementById('convLock').classList.add("show");
    	}
    	if (document.getElementById('convunLock')){
    		document.getElementById('convunLock').classList.remove("show");
    		document.getElementById('convunLock').classList.add("hide");
    	}
    	
    	
    	if (document.getElementById('fp')){
    		document.getElementById('fp').innerHTML = "";    
    	}
         
    }

    this.loadConversation = function() {

        var obj = {};
        obj.action = "loadConversation";
        obj.entityId = instance.entityId;
        obj.entityClassId = instance.entityClassId;
        obj.searchText = A.one("#searchInpBar_Id") ? A.one("#searchInpBar_Id").val() : "";
        A.io.request(instance.ajaxUrl, {
            dataType: 'json',
            method: 'POST',
            sync: true,
            data: obj,
            on: {
                success: function() {
                    var data = this.get("responseData");
                    if (data) {
                        if (data.error) {
                            alert(data.error);
                        } else {
                            instance.addElement(data);
                        }
                    }

                },
                failure: function() {
                    alert('Error while saving message');
                }
            }
        });

    }

    this.addSearchSection = function() {

        //clear the existing data
        if (document.getElementById('tabConvos')) {
            document.getElementById('tabConvos').innerHTML = '';
        }


        //NO OF INTERACTIONS
        var divTitlebar = document.createElement('div');
        divTitlebar.setAttribute('class', 'tabTitleBar');
        divTitlebar.setAttribute('id', 'tabTitleBarId');
        var titleSpan = document.createElement('span');
        titleSpan.setAttribute('id', 'titleSpanId');
        var dvP = document.createElement('P');
        //titleSpan.textContent = data.total;
        dvP.textContent = "Convos";

        var searchCon = document.createElement('div');
        searchCon.setAttribute('class', 'searchListWrap');
        searchCon.setAttribute('id', 'searchListID');

        var searchCon_Img = document.createElement('IMG');

        searchCon_Img.setAttribute("id", "searchListIDimg");
        searchCon_Img.src = '/SPActivityHub-portlet/images/searchuser.svg';
        var searchConClose_Img = document.createElement('IMG');
        searchConClose_Img.setAttribute("id", "searchListIDimgclose");
        searchConClose_Img.setAttribute("class", "closeSearch");


        searchConClose_Img.src = '/SPActivityHub-portlet/images/closeSearch.svg';
        var searchInpBar = document.createElement('input');
        searchInpBar.setAttribute('class', 'searchInpBar');
        searchInpBar.setAttribute('id', 'searchInpBar_Id');
        searchInpBar.setAttribute('type', 'text');
        searchInpBar.setAttribute('placeholder', 'SEARCH CONVERSATION');
        searchInpBar.setAttribute('name', 'searchBarId');
        var searchResultP = document.createElement('p');
        searchResultP.setAttribute('class', 'searcgresultDiv');
        searchResultP.setAttribute('id', 'searcgresultDivId');
        //searchResultP.innerHTML = "<b>0</b>results";

        divTitlebar.appendChild(titleSpan);
        divTitlebar.appendChild(dvP);
        searchCon.appendChild(searchInpBar);
        searchCon.appendChild(searchCon_Img);
        searchCon.appendChild(searchConClose_Img);
        searchCon.appendChild(searchResultP);


        divTitlebar.appendChild(searchCon);
        document.getElementById('tabConvos').appendChild(divTitlebar);

        if (A.one("#searchListIDimg")) {
            A.one("#searchListIDimg").on("click", function() {
                instance.searchConvos();
            });
        }

        if (A.one("#searchListIDimgclose")) {
            A.one("#searchListIDimgclose").on("click", function() {
                instance.searchConvosClose();
            });
        }



    }

    this.searchConvos = function() {

        var serachIc = document.getElementById("searchListID");
        serachIc.classList.add("showSearch");


    }
    this.searchConvosClose = function() {

        var serachIcClose = document.getElementById("searchListID");
        serachIcClose.classList.remove("showSearch");
        var searchInputClear = document.getElementById('searchInpBar_Id');
        searchInputClear.value = "";
        instance.loadConversation();


    }

    //add listing section
    this.addElement = function(data) {


        if (data.total != 0 && !searchCriteriaChangedConv) {
            instance.addSearchSection();
            instance.initializeEnterKeySearch();
        }

        if (document.getElementById('searcgresultDivId')) {
            document.getElementById('searcgresultDivId').innerHTML = "<b>" + data.total + "</b>results";
        }


        if (document.getElementById('titleSpanId')) {
            document.getElementById('titleSpanId').textContent = data.total;
        }


        //clear the existing data
        if (document.getElementById('actDetailsWrapperId')) {
            A.all('#actDetailsWrapperId').remove();
        }

        if (A.one('.emptyContainer')) {
            A.one('.emptyContainer').remove();
        }



        //CONVERSATION CONTENT WRAP
        var divConvosWrap = document.createElement('div');
        divConvosWrap.setAttribute('class', 'actDetailsWrapper');
        divConvosWrap.setAttribute('id', 'actDetailsWrapperId');




        var divConvosinnerWrap = document.createElement('div');
        divConvosinnerWrap.setAttribute('class', 'innerActd');
        divConvosinnerWrap.setAttribute('id', 'actdetailsec');

        divConvosWrap.appendChild(divConvosinnerWrap);
        document.getElementById('tabConvos').appendChild(divConvosWrap);


        
       

        if (data.total == 0 && instance.extUser == "External" && !searchCriteriaChangedConv)

        {
            var convosAddremove = document.getElementById('myTab');
            convosAddremove.innerHTML = '';



            var convosList = document.getElementById('tabConvos');
            convosList.innerHTML = '';
            var emptyConvContainer = document.createElement('DIV');
            emptyConvContainer.setAttribute('class', 'emptyContainer');
            var eContTitle = document.createElement('p');
            eContTitle.setAttribute('class', 'emTitle');
            eContTitle.innerHTML = "<b>0</b>Conversations";
            var econtIcon = document.createElement('IMG');
            econtIcon.src = "/SPActivityHub-portlet/images/conversations_Empty.svg";
            var econtTagline = document.createElement('H2');
            econtTagline.setAttribute('class', 'empTag');
            econtTagline.innerHTML = "Converse. Collaborate";
            var econtMessage = document.createElement('P');
            econtMessage.setAttribute('class', 'emptyMessage');
            econtMessage.innerHTML = 'Create one using the section above';

            emptyConvContainer.appendChild(eContTitle);
            emptyConvContainer.appendChild(econtIcon);
            emptyConvContainer.appendChild(econtTagline);
            emptyConvContainer.appendChild(econtMessage);
            convosList.appendChild(emptyConvContainer);
        } else if (data.total == 0 && instance.extUser == "Internal" && !searchCriteriaChangedConv) {
            var convosList = document.getElementById('tabConvos');
            convosList.innerHTML = '';
            var emptyConvContainer = document.createElement('DIV');
            emptyConvContainer.setAttribute('class', 'emptyContainer');
            var eContTitle = document.createElement('p');
            eContTitle.setAttribute('class', 'emTitle');
            eContTitle.innerHTML = "<b>0</b>Conversations";
            var econtIcon = document.createElement('IMG');
            econtIcon.src = "/SPActivityHub-portlet/images/conversations_Empty.svg";
            var econtTagline = document.createElement('H2');
            econtTagline.setAttribute('class', 'empTag');
            econtTagline.innerHTML = "Converse. Collaborate";
            var econtMessage = document.createElement('P');
            econtMessage.setAttribute('class', 'emptyMessage');
            econtMessage.innerHTML = 'Create one using the section above';

            emptyConvContainer.appendChild(eContTitle);
            emptyConvContainer.appendChild(econtIcon);
            emptyConvContainer.appendChild(econtTagline);
            emptyConvContainer.appendChild(econtMessage);
            convosList.appendChild(emptyConvContainer);
        } else {
            //ACTIVITY CONTENT WRAP **REPEAT SECTION***
            var chkForToday = false;
            var chkForOlder = false;
            for (var i = 1; i <= data.total; i++) {

                var counter = i;

                if (!data.conversations[i - 1].createDate.includes("at") && !chkForToday) {
                    var convosType = document.createElement('div');
                    convosType.setAttribute('class', 'InActTitle');
                    var ctypeP = document.createElement('P');
                    ctypeP.textContent = "Today";
                    convosType.appendChild(ctypeP);
                    divConvosinnerWrap.appendChild(convosType);
                    chkForToday = true;
                } else if (data.conversations[i - 1].createDate.includes("at") && !chkForOlder) {
                    var convosType = document.createElement('div');
                    convosType.setAttribute('class', 'InActTitle');
                    var ctypeP = document.createElement('P');
                    ctypeP.textContent = "Older";
                    convosType.appendChild(ctypeP);
                    divConvosinnerWrap.appendChild(convosType);
                    chkForOlder = true;
                }
                var convSectionWrap = document.createElement('div');
                convSectionWrap.setAttribute('class', 'convSectionWrapper');
                convSectionWrap.setAttribute('id', 'convContentWrapId_' + (+counter));

                var convContentWrap = document.createElement('div');
                convContentWrap.setAttribute('class', 'actDetailContent');
                convContentWrap.setAttribute('id', 'adcWrapId' + (+counter));
                convContentWrap.setAttribute('uuid', data.conversations[i - 1].uuid);

                var convCloseSpan = document.createElement('SPAN');
                convCloseSpan.setAttribute('class', 'closePopEditaction viewClose');
                convCloseSpan.setAttribute('id', 'closeConvView_' + (+counter));
                var convCloseSpanImg = document.createElement('IMG');
                convCloseSpanImg.src = '/SPActivityHub-portlet/images/cancelactivity.svg';
                convCloseSpan.appendChild(convCloseSpanImg);
                convSectionWrap.appendChild(convCloseSpan);



                convContentWrap.addEventListener('click', function(ee) {


                    var elems = document.querySelector(".editDetailact");

                    if (elems != null && elems1.parentNode.parentNode != null) {
                        elems.classList.remove("editDetailact");
                        elems.parentNode.childNodes[0].classList.remove("show");
                    }
                    this.classList.add('editDetailact');
                    this.parentNode.childNodes[0].classList.add("show");

                })

                convCloseSpan.addEventListener('click', function(closeConView) {
                    this.parentNode.childNodes[0].classList.remove("show");

                    this.parentNode.childNodes[1].classList.remove("editDetailact");


                })




                //-Notify Icon Img  
                var notifIcon = document.createElement('div');
                notifIcon.setAttribute('class', 'notifyIcon ');
                var notifIconImg = document.createElement('IMG');
                notifIconImg.src = "/SPActivityHub-portlet/images/activity_icon.svg";
                notifIcon.appendChild(notifIconImg);

                //-Time & User Details 
                var notifTimeweap = document.createElement('div');
                notifTimeweap.setAttribute('class', 'notifySenderTime');
                var notifySender = document.createElement('P');
                notifySender.textContent = data.conversations[i - 1].caption;
                notifySender.setAttribute('class', 'notifySender');

                var str = data.conversations[i - 1].createDate;
                notifyTime = document.createElement('SPAN');
                notifyTime.setAttribute('class', 'notifyTime');
                notifyTime.innerHTML = str;

                notifTimeweap.appendChild(notifySender);
                notifTimeweap.appendChild(notifyTime);

                //-Notification Message Content
                var notifyMessage = document.createElement('P');
                notifyMessage.setAttribute('class', 'notifyMessage');
                notifyMessage.innerHTML = data.conversations[i - 1].msg;

                convContentWrap.appendChild(notifIcon);
                convContentWrap.appendChild(notifTimeweap);
                convContentWrap.appendChild(notifyMessage);
                convSectionWrap.appendChild(convContentWrap);
                divConvosinnerWrap.appendChild(convSectionWrap);


                // check if its external or internal user. The Profile icons should not be visible for external users
                if (instance.extUser == "Internal") {
                    //-USER Section
                    if (data.conversations[i - 1].numberOfRecipients > 0 && data.conversations[i - 1].recipientProfileImagePath.length > 0) {
                        var convEditWrap = document.createElement('DIV');
                        convEditWrap.setAttribute('class', 'convEditWrapper');

                        var ceIconUser = document.createElement('DIV');
                        ceIconUser.setAttribute('class', 'ceIconuser');
                        for (var n = 0; n < data.conversations[i - 1].numberOfRecipients; n++) {
                            var ceIconUserImg = document.createElement('IMG');
                            ceIconUserImg.setAttribute('class', 'userAc');
                            ceIconUserImg.src = data.conversations[i - 1].recipientProfileImagePath[n];
                            ceIconUser.appendChild(ceIconUserImg);
                        }
                        convEditWrap.appendChild(ceIconUser);
                        convContentWrap.appendChild(convEditWrap);
                    }
                }

                //attachment section - start
                if (data.conversations[i - 1].numberOfAttachments > 0) {



                    var fileUploadDiv = document.createElement('DIV');
                    fileUploadDiv.setAttribute('class', 'file-save');
                    for (var k = 0; k < data.conversations[i - 1].attachments.length; k++) {
                        var attachmentDetail = data.conversations[i - 1].attachments[k];

                        var fileName = attachmentDetail.fileName;
                        var fileSize = attachmentDetail.fileSize;
                        var downloadUrl = attachmentDetail.downloadUrl;

                        var filesaveDiv = document.createElement('DIV');
                        filesaveDiv.setAttribute('class', 'Filenamedetailsave');

                        var fileNameP = document.createElement('A');
                        fileNameP.setAttribute('target', '_blank');
                        fileNameP.href = downloadUrl;
                        var fileNameSize = document.createElement('P');
                        fileNameSize.innerHTML = fileSize;

                        fileNameP.innerHTML = fileName;
                        filesaveDiv.appendChild(fileNameP);
                        filesaveDiv.appendChild(fileNameSize);
                        fileUploadDiv.appendChild(filesaveDiv);


                    }
                    convContentWrap.appendChild(fileUploadDiv);


                }
                //attachment section - end

            }

            /* delete section - start

            var convActionWrap = document.createElement('DIV');
            convActionWrap.setAttribute('class', 'ceActionIcon');




            //var acteditIcon = document.createElement('DIV');
            //acteditIcon.setAttribute('class', 'acteditIcon');
            //var acteditIconImg = document.createElement('IMG');
            //acteditIconImg.src = "/SPActivityHub-portlet/images/edit-icon.svg";
            //acteditIcon.appendChild(acteditIconImg);
            //convActionWrap.appendChild(acteditIcon);
            



            
            var actdeleteIcon = document.createElement('DIV');
            actdeleteIcon.setAttribute('class', 'actdeleteIcon');
            var actdeleteIconButton = document.createElement('A');
            actdeleteIconButton.textContent = "DELETE";
            actdeleteIconButton.setAttribute('href', '#deleteContent' + (+counter));
            actdeleteIconButton.setAttribute('class', 'deleteActButton');
            
           
            //deleteFunction


            var deletePopop = document.createElement('DIV');
                deletePopop.setAttribute('class', 'comwOverlay');
                deletePopop.setAttribute('id', 'deleteContent' + (+counter));
            var deletePopopinner = document.createElement('DIV');
                deletePopopinner.setAttribute('class', 'comwPopup');
            var deleteContentArea = document.createElement('DIV');
                deleteContentArea.setAttribute('class', 'comwContent');

           
            var actinfoIconImg = document.createElement('IMG');
                actinfoIconImg.setAttribute('class', 'infoIcon');
                actinfoIconImg.src = "/SPActivityHub-portlet/images/infoIcon.svg";
            var deleteContentTitle= document.createElement('H2');
                deleteContentTitle.textContent = 'Are you sure you want to delete this conversation?';
            var deleteMessage= document.createElement('p');
                deleteMessage.textContent = "This action cannot be undone";

             

            var dcActionwrap = document.createElement('DIV');
                dcActionwrap.setAttribute('class','popDeleteWrap');
                var deleteact= document.createElement('A');
                deleteact.textContent = "DELETE";
                deleteact.setAttribute('class', 'deleteActButton');
                deleteact.setAttribute('href', '#');
                deleteact.setAttribute('id', data.conversations[i-1].convId);
               
                var keepact= document.createElement('A');
                keepact.textContent = "KEEP ACTIVITY";
                keepact.setAttribute('class', 'keepAnchor');
                keepact.setAttribute('href', '#');
                dcActionwrap.appendChild(deleteact);
                dcActionwrap.appendChild(keepact);

                deleteContentArea.appendChild(actinfoIconImg);
                deleteContentArea.appendChild(deleteContentTitle);
                deleteContentArea.appendChild(deleteMessage);
                deleteContentArea.appendChild(dcActionwrap);
                deletePopopinner.appendChild(deleteContentArea);

                 deleteact.addEventListener('click', function(a) {
                     var current = a.target;
                     instance.deleteConversation(current.id);
                   
                })

                deletePopop.appendChild(deletePopopinner);
                convContentWrap.appendChild(deletePopop);



            actdeleteIcon.appendChild(actdeleteIconButton);
            convActionWrap.appendChild(actdeleteIcon);
            
           

            convEditWrap.appendChild(convActionWrap); */

            // delete section - end



        }

        //**REPEAT SECTION END***

    }



    this.deleteConversation = function(convId) {
        var obj = {};
        obj.action = "deleteConversation";
        obj.convId = convId;
        A.io.request(instance.ajaxUrl, {
            dataType: 'json',
            method: 'POST',
            sync: true,
            data: obj,
            on: {
                success: function() {
                    var data = this.get("responseData");
                    if (data) {
                        if (data.error) {
                            alert(data.error);
                        } else {
                            alert(data.msg);
                            instance.loadConversation();
                        }
                    }

                },
                failure: function() {
                    alert('Error while saving message');
                }
            }
        });
    }

    //Content Edit
    this.GetFileSizeNameAndTypeConv = function() {
        var fi = document.getElementById('convFile'); // GET THE FILE INPUT AS VARIABLE.

        var totalFileSize = 0;

        // VALIDATE OR CHECK IF ANY FILE IS SELECTED.
        if (fi.files.length > 0) {
            // RUN A LOOP TO CHECK EACH SELECTED FILE.
            for (var i = 0; i <= fi.files.length - 1; i++) {
                //ACCESS THE SIZE PROPERTY OF THE ITEM OBJECT IN FILES COLLECTION. IN THIS WAY ALSO GET OTHER PROPERTIES LIKE FILENAME AND FILETYPE
                var fsize = fi.files.item(i).size;
                totalFileSize = totalFileSize + fsize;
                document.getElementById('fp').innerHTML =
                    document.getElementById('fp').innerHTML +
                    '<div class="Filenamedetail" ' + 'id="' + 'fileConvUPId' + fsize + '"' + '>' + '<p>' + fi.files.item(i).name + '</p>' + Math.round(totalFileSize / 1024) + '&nbsp;' + 'KB' + '<p class="fileprogressLogAdd" >' + '</p>' + '</div>'
                var uploader = new fileUploadActivityHub();
                uploader.init(instance.ajaxUrlFileUpload, instance.pns, 'convFile', 'uploadsFileEntryIdConv', '', 'fileprogressLogAdd');

            }
        }

    }

    //anchor link add




    var applyBtnwr = document.getElementById("applyBtn");

    applyBtnwr.onclick = function() {
        var applyContarea = document.getElementById('conversationTxtArea');
        if (applyContarea != null) {
            var applyContareaText = applyContarea.innerHTML;
            var applyContareaTextLength = applyContareaText.trim().length;
            var startPosition = applyContarea.selectionStart;
            var endPosition = applyContarea.selectionEnd;

            var linkText = document.getElementById("cLinkTxt").value;
            var linkUrl = document.getElementById("cLinkUrl").value;
            if (startPosition == endPosition) {
                applyContarea.innerHTML += '<a href="' + linkUrl + '" target="_blank">' + linkText + '</a>';

            }

            var closeLinkWrap = document.getElementById('linkToolsWrap_1');
            closeLinkWrap.classList.remove('activeAction');

            document.getElementById("cLinkTxt").value = "";
            document.getElementById("cLinkUrl").value = "";

            return false;
        }

    };
    var cancelLinkClear = document.getElementById("cancelBtnLink");
    cancelLinkClear.onclick = function() {


        var linkTextEmpty = document.getElementById("cLinkTxt");
        var linkUrlEmpty = document.getElementById("cLinkUrl");
        linkTextEmpty.value = "";
        linkUrlEmpty.value = "";
        var closeLinkWrapTXT = document.getElementById('linkToolsWrap_1');
        closeLinkWrapTXT.classList.remove('activeAction');

        return false;

    };






    this.init(config);

}


//Initialize SP conversation
