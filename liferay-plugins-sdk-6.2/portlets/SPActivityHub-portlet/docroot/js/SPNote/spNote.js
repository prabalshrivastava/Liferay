var spNote = function(config) {
    var AArray = A.Array;
    var instance;
    var searchCriteriaChangedNote = false;
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

        this.noteTitle = A.one("#noteTitle");
        this.noteContent = A.one("#noteTxtArea");
        this.uploadsFileEntryId = A.one("#uploadsFileEntryIdNote");
        this.saveNoteElem = A.one("#saveNote");
        
        
        if (instance.closedStageId != 0) {
          	 var convosAddremove = document.getElementById('myTab');
               convosAddremove.classList.add("hide");
        }else{
       	   var convosAddremove = document.getElementById('myTab');
              convosAddremove.classList.remove("hide");
        }

        this.initializeSaveNote();
        this.initializeLoadNote();
        this.initializeFileUpload();

        this.loadNote();

    }
    



    this.initializeSaveNote = function() {
        if (A.one("#saveNote")) {
            A.one("#saveNote").on("click", function() {
                instance.saveNote();
            });
        }

    }

    this.initializeFileUpload = function() {
        if (A.one("#noteFile")) {
            A.one("#noteFile").on("change", function() {
                instance.GetFileSizeNameAndTypeNote();
                A.one("#noteFile").ancestor().ancestor().removeClass('activeAction');
            });
        }

    }

    this.initializeEnterKeySearch = function() {
        var nodes = [A.one("#searchNotesInpBar_Id")];
        var nodeList = new A.NodeList(nodes);
        nodeList.on("keypress", function(ev) {
            // click on enter
            if (ev.keyCode == 13) {
                searchCriteriaChangedNote = true;
                instance.loadNote();
            }
        });
    }

    this.initializeLoadNote = function() {
        if (A.one("#notesLoad")) {
            A.one("#notesLoad").on("click", function() {

                instance.loadNote();
            });


        }

    }


    this.saveNote = function() {

    	var validationResult = validateReqField("tab-addnote","");
    	
    	if (!validationResult){
	        var obj = {};
	        obj.action = "saveNote";
	        obj.noteTitle = instance.noteTitle.val();
	
	
	        if (instance.noteContent) {
	            obj.noteContent = instance.noteContent.getDOMNode().innerHTML;
	        }
	
	
	        obj.entityId = instance.entityId;
	        obj.entityClassId = instance.entityClassId;
	        obj.entityClassName = instance.entityClassName;
	        obj.associatedWith = instance.associatedWith;
	        obj.uploadsFileEntryId = instance.uploadsFileEntryId.val();
	
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
	                        	instance.clearNote();
	                            instance.loadNote();
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
    
    this.clearNote =  function(){
    	document.getElementById('noteTitle').value = "";
    	instance.noteContent.getDOMNode().innerHTML = "";
    	if (document.getElementById('fileUploadNote')){
    		document.getElementById('fileUploadNote').innerHTML = "";    
    	}
         
    }

    this.updateNote = function(note) {
    	
    	var counterId = note.getAttribute('counter-id');
    	var validationResult = validateReqField("noteContainerid", "_"+counterId);
    	
    	if (!validationResult){
	        var obj = {};
	        obj.action = "updateNote";
	        
	        var noteTitle = document.getElementById('notifyTitleId_' + (+counterId));
	        if (noteTitle) {
	            obj.noteTitle = noteTitle.innerHTML;
	        }
	        var noteContent = document.getElementById('notifyMessage_' + (+counterId));
	        if (noteContent) {
	            obj.noteContent = noteContent.innerHTML;
	        }
	
	        obj.noteId = note.id;
	        var noteAttachment = document.getElementById('input-fileAtc1' + (+counterId));
	        if (noteAttachment) {
	            obj.uploadsFileEntryId = noteAttachment.value;
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
	                            instance.loadNote();
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

    this.loadNote = function() {

        var obj = {};
        obj.action = "loadNote";
        obj.entityId = instance.entityId;
        obj.entityClassId = instance.entityClassId;
        obj.searchText = A.one("#searchNotesInpBar_Id") ? A.one("#searchNotesInpBar_Id").val() : "";
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
        if (document.getElementById('tabNotes')) {
            document.getElementById('tabNotes').innerHTML = '';
        }


        //NO OF INTERACTIONS
        var divTitlebar = document.createElement('div');
        divTitlebar.setAttribute('class', 'tabTitleBar');
        divTitlebar.setAttribute('id', 'tabNotesTitleBarId');
        var titleSpan = document.createElement('span');
        titleSpan.setAttribute('id', 'titleNotesSpanId');
        var dvP = document.createElement('P');
        //titleSpan.textContent = data.total;
        dvP.textContent = "Notes";

        var searchCon = document.createElement('div');
        searchCon.setAttribute('class', 'searchListWrap');
        searchCon.setAttribute('id', 'searchNotesListID');

        var searchCon_Img = document.createElement('IMG');

        searchCon_Img.setAttribute("id", "searchNotesListIDimg");
        searchCon_Img.src = '/SPActivityHub-portlet/images/searchuser.svg';
        var searchConClose_Img = document.createElement('IMG');
        searchConClose_Img.setAttribute("id", "searchNotesListIDimgclose");
        searchConClose_Img.setAttribute("class", "closeSearch");


        searchConClose_Img.src = '/SPActivityHub-portlet/images/closeSearch.svg';
        var searchInpBar = document.createElement('input');
        searchInpBar.setAttribute('class', 'searchInpBar');
        searchInpBar.setAttribute('id', 'searchNotesInpBar_Id');
        searchInpBar.setAttribute('type', 'text');
        searchInpBar.setAttribute('placeholder', 'SEARCH NOTE');
        searchInpBar.setAttribute('name', 'searchBarId');
        var searchResultP = document.createElement('p');
        searchResultP.setAttribute('class', 'searcgresultDiv');
        searchResultP.setAttribute('id', 'searchNoteresultDivId');
        //searchResultP.innerHTML = "<b>0</b>results";

        divTitlebar.appendChild(titleSpan);
        divTitlebar.appendChild(dvP);
        searchCon.appendChild(searchInpBar);
        searchCon.appendChild(searchCon_Img);
        searchCon.appendChild(searchConClose_Img);
        searchCon.appendChild(searchResultP);


        divTitlebar.appendChild(searchCon);
        document.getElementById('tabNotes').appendChild(divTitlebar);

        if (A.one("#searchNotesListIDimg")) {
            A.one("#searchNotesListIDimg").on("click", function() {
                instance.searchNotes();
            });
        }

        if (A.one("#searchNotesListIDimgclose")) {
            A.one("#searchNotesListIDimgclose").on("click", function() {
                instance.searchNotesClose();
            });
        }



    }

    this.searchNotes = function() {

        var serachIc = document.getElementById("searchNotesListID");
        serachIc.classList.add("showSearch");


    }
    this.searchNotesClose = function() {

        var serachIcClose = document.getElementById("searchNotesListID");
        serachIcClose.classList.remove("showSearch");
        var searchInputClear = document.getElementById('searchNotesInpBar_Id');
        searchInputClear.value = "";
        instance.loadNote();


    }

    //add listing section
    this.addElement = function(data) {

        if (data.total != 0 && !searchCriteriaChangedNote) {
            instance.addSearchSection();
            instance.initializeEnterKeySearch();
        }


        if (document.getElementById('searchNoteresultDivId')) {
            document.getElementById('searchNoteresultDivId').innerHTML = "<b>" + data.total + "</b>results";
        }


        if (document.getElementById('titleNotesSpanId')) {
            document.getElementById('titleNotesSpanId').textContent = data.total;
        }


        //clear the existing data
        if (document.getElementById('antDetailsWrapperId')) {
            A.all('#antDetailsWrapperId').remove();
        }

        if (A.one('.emptyContainer')) {
            A.one('.emptyContainer').remove();
        }



        //NOTE CONTENT WRAP
        var divNotesWrap = document.createElement('div');
        divNotesWrap.setAttribute('class', 'actDetailsWrapper');
        divNotesWrap.setAttribute('id', 'antDetailsWrapperId');






        var divNotesinnerWrap = document.createElement('div');
        divNotesinnerWrap.setAttribute('class', 'innerActd');
        divNotesinnerWrap.setAttribute('id', 'antdetailsec');

        divNotesWrap.appendChild(divNotesinnerWrap);
        document.getElementById('tabNotes').appendChild(divNotesWrap);



      
   



        if (data.total == 0 && instance.extUser == "Internal" && !searchCriteriaChangedNote) {
            var notesList = document.getElementById('tabNotes');
            notesList.innerHTML = '';
            var emptyNoteContainerNote = document.createElement('DIV');
            emptyNoteContainerNote.setAttribute('class', 'emptyContainer');
            var eContTitleNote = document.createElement('p');
            eContTitleNote.setAttribute('class', 'emTitle');
            eContTitleNote.innerHTML = "<b>0</b>Notes";
            var econtIconNote = document.createElement('IMG');
            econtIconNote.src = "/SPActivityHub-portlet/images/conversations_Empty.svg";
            var econtTaglineNote = document.createElement('H2');
            econtTaglineNote.setAttribute('class', 'empTag');
            econtTaglineNote.innerHTML = "Pen your thoughts!";
            var econtMessageNote = document.createElement('P');
            econtMessageNote.setAttribute('class', 'emptyMessage');
            econtMessageNote.innerHTML = 'Create one using the section above';

            emptyNoteContainerNote.appendChild(eContTitleNote);
            emptyNoteContainerNote.appendChild(econtIconNote);
            emptyNoteContainerNote.appendChild(econtTaglineNote);
            emptyNoteContainerNote.appendChild(econtMessageNote);
            notesList.appendChild(emptyNoteContainerNote);
        }else {
            //ACTIVITY CONTENT WRAP **REPEAT SECTION***
            var chkForToday = false;
            var chkForOlder = false;
            for (var i = 1; i <= data.total; i++) {

                var counter = i;

                if (!data.notes[i - 1].createDate.includes("at") && !chkForToday) {
                    var notesType = document.createElement('div');
                    notesType.setAttribute('class', 'InActTitle');
                    var ctypeP = document.createElement('P');
                    ctypeP.textContent = "Today";
                    notesType.appendChild(ctypeP);
                    divNotesinnerWrap.appendChild(notesType);
                    chkForToday = true;
                } else if (data.notes[i - 1].createDate.includes("at") && !chkForOlder) {
                    var notesType = document.createElement('div');
                    notesType.setAttribute('class', 'InActTitle');
                    var ctypeP = document.createElement('P');
                    ctypeP.textContent = "Older";
                    notesType.appendChild(ctypeP);
                    divNotesinnerWrap.appendChild(notesType);
                    chkForOlder = true;
                }

                var noteContainer = document.createElement('div');
                noteContainer.setAttribute('class', 'noteContainerDiv');
                noteContainer.setAttribute('id', 'noteContainerid_' + (+counter));

                var noteContentWrap = document.createElement('div');
                noteContentWrap.setAttribute('class', 'actDetailContent_notes');
                noteContentWrap.setAttribute('id', 'ancWrapId' + (+counter));
                // noteContentWrap.setAttribute('onclick', 'focusEditNotes(this)');
                var notesCloseSpan = document.createElement('SPAN');
                notesCloseSpan.setAttribute('class', 'closePopEditaction viewClose');
                notesCloseSpan.setAttribute('id', 'closeConvView_' + (+counter));
                var notesCloseSpanImg = document.createElement('IMG');
                notesCloseSpanImg.src = '/SPActivityHub-portlet/images/cancelactivity.svg';
                notesCloseSpan.appendChild(notesCloseSpanImg);
                noteContentWrap.appendChild(notesCloseSpan);

                notesCloseSpan.addEventListener('click', function(closeNoteView) {
                    this.parentElement.classList.remove("editDetailact");
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
                notifySender.textContent = data.notes[i - 1].caption;
                notifySender.setAttribute('class', 'notifySender');

                var str = data.notes[i - 1].createDate;
                notifyTime = document.createElement('SPAN');
                notifyTime.setAttribute('class', 'notifyTime');
                notifyTime.innerHTML = str;

                notifTimeweap.appendChild(notifySender);
                notifTimeweap.appendChild(notifyTime);

                //Message Title
                var notifyTitleWrap = document.createElement('DIV');
                notifyTitleWrap.setAttribute('class', ' notifyTitleWrap');
                var notifyTitle = document.createElement('H2');
                notifyTitle.setAttribute('class', 'contentEditError notifyTitle Requiredfield');
                notifyTitle.setAttribute('id', 'notifyTitleId_' + (+counter));
                notifyTitle.innerHTML = data.notes[i - 1].noteTitle;
                notifyTitle.defaultValue = data.notes[i - 1].noteTitle;
                var notifyTitleError = document.createElement('SPAN');
                notifyTitleError.setAttribute('class', 'actErrorNotif');
                notifyTitleError.textContent = "This field is required";
                var notifyTitleErrorImg = document.createElement('IMG');
                notifyTitleErrorImg.src = "/SPActivityHub-portlet/images/act-error.svg";
                notifyTitleError.appendChild(notifyTitleErrorImg);



                //-Notification Message Content
                var notifyMessageWrap = document.createElement('DIV');
                notifyMessageWrap.setAttribute('class', ' notifyMessageWrap');
                var notifyMessage = document.createElement('P');
                notifyMessage.setAttribute('class', 'contentEditError notifyMessage Requiredfield');
                notifyMessage.setAttribute('id', 'notifyMessage_' + (+counter));
                notifyMessage.innerHTML = data.notes[i - 1].noteContent;
                notifyMessage.defaultValue = data.notes[i - 1].noteContent;
                var notifyError = document.createElement('SPAN');
                notifyError.setAttribute('class', 'actErrorNotif');
                notifyError.textContent = "This field is required";
                var notifyErrorImg = document.createElement('IMG');
                notifyErrorImg.src = "/SPActivityHub-portlet/images/act-error.svg";
                notifyError.appendChild(notifyErrorImg);



                var fileUploadEditNote = document.createElement('P');
                fileUploadEditNote.setAttribute('class', 'file-return');
                fileUploadEditNote.setAttribute('id', 'fileUploadEditNote' + (+counter));

                //Append Notes ICON,TimeWrap,Title, Message 
                noteContentWrap.appendChild(notifIcon);
                noteContentWrap.appendChild(notifTimeweap);
                notifyTitleWrap.appendChild(notifyTitle);
                notifyTitleWrap.appendChild(notifyTitleError);
                noteContentWrap.appendChild(notifyTitleWrap);
                notifyMessageWrap.appendChild(notifyMessage);
                notifyMessageWrap.appendChild(notifyError);
                noteContentWrap.appendChild(notifyMessageWrap);
                noteContentWrap.appendChild(fileUploadEditNote);
                noteContainer.appendChild(noteContentWrap);
                divNotesinnerWrap.appendChild(noteContainer);



                //-USER & SECTION Section
                var notesEditWrap = document.createElement('DIV');
                notesEditWrap.setAttribute('class', 'convEditWrapper_notes');

                // EDIT TEXTFORMAT &ACTIVE LINK & FILEUPLOAD
                var notesTextFormat = document.createElement('DIV');
                notesTextFormat.setAttribute('class', 'ceTextFormatWrap');

                var NotesEditAct = document.createElement('DIV');
                NotesEditAct.setAttribute('class', 'nEditactionsIcons');

                //LINK
                var linkEdAddnote = document.createElement('A');
                linkEdAddnote.setAttribute('class', 'actBtns');
                linkEdAddnote.setAttribute('id', 'linkadnBtns' + (+counter));
                linkEdAddnote.setAttribute('onclick', 'focusLinkActionDiv(this)');
                var imgEdAddnote = document.createElement('IMG');
                imgEdAddnote.src = '/SPActivityHub-portlet/images/inactive.svg';
                linkEdAddnote.appendChild(imgEdAddnote);
                NotesEditAct.appendChild(linkEdAddnote);




                //TEXT FORMAT
                var txtFmtEdAddnote = document.createElement('A');
                txtFmtEdAddnote.setAttribute('class', 'actBtns');
                txtFmtEdAddnote.setAttribute('id', 'txtFmtadnBtns' + (+counter));
                txtFmtEdAddnote.setAttribute('onclick', 'focusTxtFormatActionDiv(this)');
                var imgtextAddnote = document.createElement('IMG');
                imgtextAddnote.src = '/SPActivityHub-portlet/images/ac-icon-a.svg';
                txtFmtEdAddnote.appendChild(imgtextAddnote);
                NotesEditAct.appendChild(txtFmtEdAddnote);

                //UPLOAD NOTE ATTACHMENT
                var uploadEdAddnote = document.createElement('A');
                uploadEdAddnote.setAttribute('class', 'actBtns');
                uploadEdAddnote.setAttribute('id', 'uplEdadnBtns' + (+counter));
                uploadEdAddnote.setAttribute('onclick', 'focusUploadActionDiv(this)');
                var imguploadIconnote = document.createElement('IMG');
                imguploadIconnote.src = '/SPActivityHub-portlet/images/attachment.svg';
                uploadEdAddnote.appendChild(imguploadIconnote);
                NotesEditAct.appendChild(uploadEdAddnote);



                var noteLinkeditContent = document.createElement('DIV');
                noteLinkeditContent.setAttribute('class', 'linkTools');
                noteLinkeditContent.setAttribute('id', 'editLink' + (+counter));

                var linkSpan = document.createElement('SPAN');
                linkSpan.setAttribute('class', 'closePopEditaction');
                linkSpan.setAttribute('id', 'closeEditPop_' + (+counter));

                linkSpan.addEventListener('click', function(closeEdit) {
                    this.parentElement.classList.remove("activeAction");
                })

                var linkSpanImg = document.createElement('IMG');
                linkSpanImg.src = '/SPActivityHub-portlet/images/cancelactivity.svg';
                linkSpan.appendChild(linkSpanImg);
                var linkH2 = document.createElement('H2');
                linkH2.innerHTML = 'ADD LINK';
                var linkInputTxt = document.createElement("INPUT");
                linkInputTxt.setAttribute('type', 'text');
                linkInputTxt.setAttribute('class', 'inputlinkacted');
                linkInputTxt.setAttribute('id', 'cLinkTxt_' + (+counter));
                linkInputTxt.setAttribute('placeholder', 'Add Text');
                var linkInputUrl = document.createElement("INPUT");
                linkInputUrl.setAttribute('type', 'text');
                linkInputUrl.setAttribute('id', 'cLinkUrl_' + (+counter));
                linkInputUrl.setAttribute('placeholder', 'Add Url');

                //ADD AND DELETE Button

                var editActWrap = document.createElement('DIV');
                editActWrap.setAttribute('class', 'linkActions');
                var addapplyWrapA = document.createElement('A');
                addapplyWrapA.innerHTML = 'Apply';
                addapplyWrapA.setAttribute('class', 'linkAnchor');
                addapplyWrapA.setAttribute('id', 'applyBtn_' + (+counter));
                addapplyWrapA.setAttribute('counter-id', counter);
                var addCancelWrapA = document.createElement('A');
                addCancelWrapA.innerHTML = 'Cancel';
                addCancelWrapA.setAttribute('class', 'linkAnchor');
                addCancelWrapA.setAttribute('id', 'cancelBtn_' + (+counter));
                addCancelWrapA.setAttribute('counter-id', counter);
                editActWrap.appendChild(addapplyWrapA);
                editActWrap.appendChild(addCancelWrapA);



                addapplyWrapA.addEventListener('click', function() {


                    this.parentNode.parentNode.classList.remove('activeAction');
                    var counterId = this.getAttribute('counter-id');
                    var applyContarea = document.getElementById('notifyMessage_' + (+counterId));
                    if (applyContarea != null) {
                        var applyContareaText = applyContarea.innerHTML;
                        var applyContareaTextLength = applyContareaText.trim().length;
                        var startPosition = applyContarea.selectionStart;
                        var endPosition = applyContarea.selectionEnd;
                        var linkText = document.getElementById('cLinkTxt_' + (+counterId)).value;
                        var linkUrl = document.getElementById('cLinkUrl_' + (+counterId)).value;
                        if (startPosition == endPosition) {
                            applyContarea.innerHTML += '<a href="' + linkUrl + '" target="_blank">' + linkText + '</a>';

                        }



                        document.getElementById('cLinkTxt_' + (+counterId)).value = "";
                        document.getElementById('cLinkUrl_' + (+counterId)).value = "";

                        return false;
                    }

                });
                addCancelWrapA.addEventListener('click', function() {

                    this.parentNode.parentNode.classList.remove('activeAction');
                    var counterId = this.getAttribute('counter-id');
                    var linkTextEmpty = document.getElementById('cLinkTxt_' + (+counterId));
                    var linkUrlEmpty = document.getElementById('cLinkUrl_' + (+counterId));
                    linkTextEmpty.value = "";
                    linkUrlEmpty.value = "";

                    return false;

                });



                noteLinkeditContent.appendChild(linkSpan); //Span
                noteLinkeditContent.appendChild(linkH2); //h2
                noteLinkeditContent.appendChild(linkInputTxt); //InputAddText
                noteLinkeditContent.appendChild(linkInputUrl); //InputAddUrl
                noteLinkeditContent.appendChild(editActWrap); //action wrap



                var notetextEditContent = document.createElement('DIV');
                notetextEditContent.setAttribute('class', 'txtFormatTools');
                notetextEditContent.setAttribute('id', 'txtFmtLink' + (+counter));

                var txtFmtSpan = document.createElement('SPAN');
                txtFmtSpan.setAttribute('class', 'closePopEditaction');
                txtFmtSpan.setAttribute('id', 'closeFmtPop_' + (+counter));
                var txtFmtSpanImg = document.createElement('IMG');
                txtFmtSpanImg.src = '/SPActivityHub-portlet/images/cancelactivity.svg';
                txtFmtSpan.appendChild(txtFmtSpanImg);

                var formatterWrap = document.createElement('DIV');
                formatterWrap.setAttribute('class', 'formatter');


                var fmtBold = document.createElement('BUTTON');
                fmtBold.setAttribute('class', 'btnAc btn-default');
                fmtBold.setAttribute('onclick', 'document.execCommand (' + "'" + 'bold' + "'" + ',' + false + ',' + null + ')');
                var fmtBoldImg = document.createElement('IMG');
                fmtBoldImg.src = '/SPActivityHub-portlet/images/textFormat-icons/bold.svg';
                fmtBold.appendChild(fmtBoldImg);

                var fmtItalic = document.createElement('BUTTON');
                fmtItalic.setAttribute('class', 'btnAc btn-default');
                fmtItalic.setAttribute('onclick', 'document.execCommand (' + "'" + 'italic' + "'" + ',' + false + ',' + null + ')');
                var fmtItalicImg = document.createElement('IMG');
                fmtItalicImg.src = '/SPActivityHub-portlet/images/textFormat-icons/italic.svg';
                fmtItalic.appendChild(fmtItalicImg);

                var fmtUnderLine = document.createElement('BUTTON');
                fmtUnderLine.setAttribute('class', 'btnAc btn-default');
                fmtUnderLine.setAttribute('onclick', 'document.execCommand (' + "'" + 'underline' + "'" + ',' + false + ',' + null + ')');
                var fmtUnderLineImg = document.createElement('IMG');
                fmtUnderLineImg.src = '/SPActivityHub-portlet/images/textFormat-icons/underline.svg';
                fmtUnderLine.appendChild(fmtUnderLineImg);

                var fmtStrike = document.createElement('BUTTON');
                fmtStrike.setAttribute('class', 'btnAc btn-default');
                fmtStrike.setAttribute('onclick', 'document.execCommand (' + "'" + 'strikeThrough' + "'" + ',' + false + ',' + null + ')');
                var fmtStrikeImg = document.createElement('IMG');
                fmtStrikeImg.src = '/SPActivityHub-portlet/images/textFormat-icons/strikethrough.svg';
                fmtStrike.appendChild(fmtStrikeImg);

                var fmtUl = document.createElement('BUTTON');
                fmtUl.setAttribute('class', 'btnAc btn-default');
                fmtUl.setAttribute('onclick', 'document.execCommand (' + "'" + 'insertUnorderedList' + "'" + ',' + false + ',' + null + ')');
                var fmtUlImg = document.createElement('IMG');
                fmtUlImg.src = '/SPActivityHub-portlet/images/textFormat-icons/ul-list.svg';
                fmtUl.appendChild(fmtUlImg);

                var fmtOl = document.createElement('BUTTON');
                fmtOl.setAttribute('class', 'btnAc btn-default');
                fmtOl.setAttribute('onclick', 'document.execCommand (' + "'" + 'insertOrderedList' + "'" + ',' + false + ',' + null + ')');
                var fmtOlImg = document.createElement('IMG');
                fmtOlImg.src = '/SPActivityHub-portlet/images/textFormat-icons/ol-list.svg';
                fmtOl.appendChild(fmtOlImg);


                formatterWrap.appendChild(fmtBold);
                formatterWrap.appendChild(fmtItalic);
                formatterWrap.appendChild(fmtUnderLine);
                formatterWrap.appendChild(fmtStrike);
                formatterWrap.appendChild(fmtUl);
                formatterWrap.appendChild(fmtOl);
                notetextEditContent.appendChild(formatterWrap);
                notetextEditContent.appendChild(txtFmtSpan);

                txtFmtSpan.addEventListener('click', function(closetxtFmt) {
                    this.parentElement.classList.remove("activeAction");
                })

                //ATTACHMENT 
                var noteAtcEditContent = document.createElement('DIV');
                noteAtcEditContent.setAttribute('class', 'convAttchment');
                noteAtcEditContent.setAttribute('id', 'noteAtcEdit' + (+counter));

                var noteAtcSpan = document.createElement('SPAN');
                noteAtcSpan.setAttribute('class', 'closePopEditaction');
                noteAtcSpan.setAttribute('id', 'closeFmtPop_' + (+counter));
                var noteAtcSpanImg = document.createElement('IMG');
                noteAtcSpanImg.src = '/SPActivityHub-portlet/images/cancelactivity.svg';
                noteAtcSpan.appendChild(noteAtcSpanImg);
                noteAtcEditContent.appendChild(noteAtcSpan);

                noteAtcSpan.addEventListener('click', function(closeupload) {
                    this.parentElement.classList.remove("activeAction");
                })

                var noteAtcDiv = document.createElement('DIV');
                noteAtcDiv.setAttribute('class', 'input-file-container');
                var noteAtcInput = document.createElement('INPUT');
                noteAtcInput.setAttribute('type', 'hidden');
                noteAtcInput.setAttribute('id', 'input-fileAtc1' + (+counter));
                noteAtcInput.setAttribute('value', '0');
                var noteAtcInputFile = document.createElement('INPUT');
                noteAtcInputFile.setAttribute('type', 'file');
                noteAtcInputFile.setAttribute('id', 'input-fileAtc2' + (+counter));
                noteAtcInputFile.setAttribute('class', 'input-file');
                noteAtcInputFile.setAttribute('counter-id', counter);
                noteAtcInputFile.setAttribute('multiple', true);
                //noteAtcInputFile.setAttribute('onchange', 'GetFileSizeNameAndTypeNote(this)');
                noteAtcInputFile.addEventListener('change', function(a) {
                    instance.GetFileSizeNameAndTypeNoteUpdate(a.target);
                    this.parentElement.parentElement.classList.remove("activeAction");

                });
                var noteAtcInputLabel = document.createElement('LABEL');
                noteAtcInputLabel.setAttribute('tabindex', '0' + (+counter));
                noteAtcInputLabel.setAttribute('for', 'input-fileAtc2' + (+counter));
                noteAtcInputLabel.setAttribute('class', 'input-file-trigger');
                noteAtcInputLabel.innerHTML = 'Upload from computer';

                noteAtcDiv.appendChild(noteAtcInput);
                noteAtcDiv.appendChild(noteAtcInputFile);
                noteAtcDiv.appendChild(noteAtcInputLabel);
                noteAtcEditContent.appendChild(noteAtcDiv);




                //TEXT FORMAT
                notesTextFormat.appendChild(NotesEditAct);
                notesTextFormat.appendChild(noteLinkeditContent);
                notesTextFormat.appendChild(notetextEditContent);
                notesTextFormat.appendChild(noteAtcEditContent);







                // EDIT ACTION UPDATE & ASSOCIATE & CANCEL
                var notesActionWrap = document.createElement('DIV');
                notesActionWrap.setAttribute('class', 'ceActionIcon');

                if (instance.associatedWith != null && instance.associatedWith != "0") {
                    //Associate User Check
                    var notesAssocWrap = document.createElement('DIV');
                    notesAssocWrap.setAttribute('class', 'notesAccociate');
                    var notesAssocP = document.createElement('P');
                    notesAssocP.innerHTML = "Associated<br> with";
                    var notesAssocIconImg = document.createElement('IMG');
                    notesAssocIconImg.src = "/SPActivityHub-portlet/images/user.png";

                    notesAssocWrap.appendChild(notesAssocP);
                    notesAssocWrap.appendChild(notesAssocIconImg);
                    notesActionWrap.appendChild(notesAssocWrap);
                }



                //UPDATE BUTTON CREATION
                var actupdateIcon = document.createElement('DIV');
                actupdateIcon.setAttribute('class', 'updateButtonWrap');
                var actUpdateIconButton = document.createElement('A');
                actUpdateIconButton.textContent = "UPDATE";
                actUpdateIconButton.setAttribute('href', '#');
                actUpdateIconButton.setAttribute('class', 'updateNotesButton');
                actUpdateIconButton.setAttribute('id', data.notes[i - 1].noteId);
                actUpdateIconButton.setAttribute('counter-id', counter);
                actupdateIcon.appendChild(actUpdateIconButton);
                notesActionWrap.appendChild(actupdateIcon);

                actUpdateIconButton.addEventListener('click', function(a) {
                    var current = a.target;
                    instance.updateNote(current);

                });



                //CANCEL BUTTON CREATION
                var actcancelIcon = document.createElement('DIV');
                actcancelIcon.setAttribute('id', 'cancelNoteid_' + (+counter));
                actcancelIcon.setAttribute('class', 'cancelButtonWrap');
                actcancelIcon.setAttribute('counter-id', counter);
                var actCancelIconButton = document.createElement('A');
                actCancelIconButton.textContent = "CANCEL";
                actCancelIconButton.setAttribute('href', 'javascript:void(0)');
                actCancelIconButton.setAttribute('class', 'cancelNotesButton');
                actCancelIconButton.setAttribute('counter-id', counter);

                actcancelIcon.appendChild(actCancelIconButton);
                notesActionWrap.appendChild(actcancelIcon);

                actcancelIcon.addEventListener('click', function(a) {
                    var current = a.target;
                    var currentCounterId = current.getAttribute('counter-id');
                    var cancelNoteEdit = document.getElementById('noteContainerid_' + (+currentCounterId));
                    cancelNoteEdit.classList.remove('editDetail');
                    document.getElementById('notifyMessage_' + (+currentCounterId)).innerHTML = document.getElementById('notifyMessage_' + (+currentCounterId)).defaultValue;
                    document.getElementById('notifyTitleId_' + (+currentCounterId)).innerHTML = document.getElementById('notifyTitleId_' + (+currentCounterId)).defaultValue;
                    document.getElementById('fileUploadEditNote' + (+currentCounterId)).innerHTML = "";
                    for (var i = 0; i < cancelNoteEdit.children[0].children.length; i++){
                    	cancelNoteEdit.children[0].children[i].classList.remove("ErrorValidation");
                    }
                
                });

                //APPEND ACTION & EDIT WRAP

                notesEditWrap.appendChild(notesTextFormat);
                notesEditWrap.appendChild(notesActionWrap);
                noteContentWrap.appendChild(notesEditWrap);


                //VIEW, EDIT & DELETE ACTIONS
                var noteActionDiv = document.createElement('DIV');
                noteActionDiv.setAttribute('class', 'noteListAction');
                //NOTES VIEW
                var notesviewIcon = document.createElement('DIV');
                notesviewIcon.setAttribute('class', 'actViewIcon');
                var notesViewIconImg = document.createElement('IMG');
                notesViewIconImg.src = "/SPActivityHub-portlet/images/view-edit.svg";
                notesviewIcon.appendChild(notesViewIconImg);
                noteActionDiv.appendChild(notesviewIcon);
                notesviewIcon.setAttribute('id', 'view_Notes' + (+counter));


                notesviewIcon.addEventListener('click', function(a) {
                    var elemsView = document.querySelector(".viewShow");
                    if (elemsView != null) {

                        elemsView.classList.remove('viewShow');
                        elemsView.parentNode.parentNode.childNodes[0].classList.remove('editDetailact');
                    }
                    this.classList.add('viewShow');
                    this.parentNode.parentNode.childNodes[0].classList.add('editDetailact');
                })

                //NOTES EDIT

                var notesEditIcon = document.createElement('DIV');
                notesEditIcon.setAttribute('class', 'acteditIcon');
                notesEditIcon.setAttribute('counter-id', counter);
                var notesEditIconImg = document.createElement('IMG');
                notesEditIconImg.src = "/SPActivityHub-portlet/images/edit-icon.svg";
                notesEditIconImg.setAttribute('counter-id', counter);
                notesEditIcon.appendChild(notesEditIconImg);
                noteActionDiv.appendChild(notesEditIcon);


                notesEditIcon.setAttribute('id', 'edit_Notes' + (+counter));

                notesEditIcon.addEventListener('click', function(a) {

                    var current = a.target;
                    var currentCounterId = current.getAttribute('counter-id');
                    var elemsNotes = document.querySelector(".editShow");
                    if (elemsNotes != null) {

                        elemsNotes.classList.remove('editShow');
                        elemsNotes.parentNode.parentNode.classList.remove('editDetail');
                    }
                    this.classList.add('editShow');
                    this.parentNode.parentNode.classList.add('editDetail');
                    document.getElementById('notifyMessage_' + (+currentCounterId)).setAttribute('contenteditable', 'true');
                    document.getElementById('notifyTitleId_' + (+currentCounterId)).setAttribute('contenteditable', 'true');

                });


                //NOTES DELETE
                var notesDeleteIcon = document.createElement('DIV');
                notesDeleteIcon.setAttribute('class', 'actdeleteIcon');
                var notesDeleteIconButton = document.createElement('A');
                notesDeleteIconButton.setAttribute('href', '#deleteContent' + (+counter));
                notesDeleteIconButton.setAttribute('class', 'deleteAct');
                var notesDeleteIconImg = document.createElement('IMG');
                notesDeleteIconImg.src = "/SPActivityHub-portlet/images/delete-icon.svg";
                notesDeleteIconButton.appendChild(notesDeleteIconImg);
                notesDeleteIcon.appendChild(notesDeleteIconButton);
                noteActionDiv.appendChild(notesDeleteIcon);


                noteContainer.appendChild(noteActionDiv);

                // DELETE FUNCTION
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
                var deleteContentTitle = document.createElement('H2');
                deleteContentTitle.textContent = 'Are you sure you want to delete this Note?';
                var deleteMessage = document.createElement('p');
                deleteMessage.textContent = "This action cannot be undone";



                var dcActionwrap = document.createElement('DIV');
                dcActionwrap.setAttribute('class', 'popDeleteWrap');
                var deleteact = document.createElement('A');
                deleteact.textContent = "DELETE";
                deleteact.setAttribute('class', 'deleteActButton');
                deleteact.setAttribute('href', 'javascript:;');
                deleteact.setAttribute('id', data.notes[i - 1].noteId);

                var keepact = document.createElement('A');
                keepact.textContent = "KEEP NOTES";
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
                    instance.deleteNote(current.id);

                });

                deletePopop.appendChild(deletePopopinner);
                noteContainer.appendChild(deletePopop);




                //attachment section - start
                if (data.notes[i - 1].numberOfAttachments > 0) {



                    var fileUploadDiv = document.createElement('DIV');
                    fileUploadDiv.setAttribute('class', 'file-save');
                    for (var k = 0; k < data.notes[i - 1].attachments.length; k++) {
                        var attachmentDetail = data.notes[i - 1].attachments[k];

                        var fileName = attachmentDetail.fileName;
                        var fileSize = attachmentDetail.fileSize;
                        var downloadUrl = attachmentDetail.downloadUrl;

                        var filesaveDiv = document.createElement('DIV');
                        filesaveDiv.setAttribute('class', 'Filenamedetailsave');
                        filesaveDiv.setAttribute('id', 'FilenamedetailsaveId_' + (+counter));

                        var fileNameP = document.createElement('A');
                        fileNameP.setAttribute('target', '_blank');
                        fileNameP.href = downloadUrl;
                        var fileNameSize = document.createElement('P');
                        fileNameSize.innerHTML = fileSize;
                        fileNameSize.innerHTML = fileSize;
                        var fileUploadProgbar = document.createElement('DIV');
                        fileUploadProgbar.setAttribute('id', 'fileprogressid_' + (+counter));

                        fileNameP.innerHTML = fileName;
                        filesaveDiv.appendChild(fileNameP);
                        filesaveDiv.appendChild(fileNameSize);
                        filesaveDiv.appendChild(fileUploadProgbar);
                        fileUploadDiv.appendChild(filesaveDiv);


                    }
                    noteContentWrap.appendChild(fileUploadDiv);


                }
                //attachment section - end

            }





        }
        
        //**REPEAT SECTION END***
        
      //validate content area onchange
        var contentValidateArea = document.getElementsByClassName("contentEditError");
        for (var i = 0; i < contentValidateArea.length; i++) {
            contentValidateArea[i].addEventListener("input", function() {
                validateContentArea(this);
            }, false);
        }

    }



    this.deleteNote = function(noteId) {
        var obj = {};
        obj.action = "deleteNote";
        obj.noteId = noteId;
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
                            instance.loadNote();
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
    this.GetFileSizeNameAndTypeNote = function() {
        var fiNotes = document.getElementById('noteFile'); // GET THE FILE INPUT AS VARIABLE.

        var totalFileSize = 0;

        // VALIDATE OR CHECK IF ANY FILE IS SELECTED.
        if (fiNotes.files.length > 0) {
            // RUN A LOOP TO CHECK EACH SELECTED FILE.

            for (var i = 0; i <= fiNotes.files.length - 1; i++) {

                //ACCESS THE SIZE PROPERTY OF THE ITEM OBJECT IN FILES COLLECTION. IN THIS WAY ALSO GET OTHER PROPERTIES LIKE FILENAME AND FILETYPE
                var fsize = fiNotes.files.item(i).size;
                totalFileSize = totalFileSize + fsize;
                document.getElementById('fileUploadNote').innerHTML =
                    document.getElementById('fileUploadNote').innerHTML +
                    '<div class="Filenamedetail" ' + 'id="' + 'fileNameUPId' + fsize + '"' + '>' + '<p>' + fiNotes.files.item(i).name + '</p>' + Math.round(totalFileSize / 1024) + '&nbsp;' + 'KB' + '<p class="fileProgressNoteAdd" >' + '</p>' + '</div>'
                var uploader = new fileUploadActivityHub();
                uploader.init(instance.ajaxUrlFileUpload, instance.pns, 'noteFile', 'uploadsFileEntryIdNote', '', 'fileProgressNoteAdd');

            }
        }

    }


    this.GetFileSizeNameAndTypeNoteUpdate = function(elem) {
        var fiNotes = document.getElementById(elem.id); // GET THE FILE INPUT AS VARIABLE.
        var counterId = elem.getAttribute('counter-id');
        var totalFileSize = 0;

        // VALIDATE OR CHECK IF ANY FILE IS SELECTED.
        if (fiNotes.files.length > 0) {
            // RUN A LOOP TO CHECK EACH SELECTED FILE.
            for (var i = 0; i <= fiNotes.files.length - 1; i++) {
                //ACCESS THE SIZE PROPERTY OF THE ITEM OBJECT IN FILES COLLECTION. IN THIS WAY ALSO GET OTHER PROPERTIES LIKE FILENAME AND FILETYPE
                var fsize = fiNotes.files.item(i).size;
                totalFileSize = totalFileSize + fsize;
                document.getElementById('fileUploadEditNote' + (+counterId)).innerHTML =
                    document.getElementById('fileUploadEditNote' + (+counterId)).innerHTML +
                    '<div class="Filenamedetail"> ' + '<p>' + fiNotes.files.item(i).name + '</p>' + Math.round(totalFileSize / 1024) + '&nbsp;' + 'KB' + '<p class="fileProgressNoteEdit" >' + '</p>' + '</div>'
                var uploader = new fileUploadActivityHub();
                uploader.init(instance.ajaxUrlFileUpload, instance.pns, elem.id, 'input-fileAtc1' + (+counterId), '', 'fileProgressNoteEdit');

            }
        }

    }

    //anchor link add




    var applyBtnwr = document.getElementById("applyBtnNote");

    applyBtnwr.onclick = function() {
        var applyContarea = document.getElementById('noteTxtArea');
        if (applyContarea != null) {
            var applyContareaText = applyContarea.innerHTML;
            var applyContareaTextLength = applyContareaText.trim().length;
            var startPosition = applyContarea.selectionStart;
            var endPosition = applyContarea.selectionEnd;

            var linkText = document.getElementById("nLinkTxt").value;
            var linkUrl = document.getElementById("nLinkUrl").value;

            if (startPosition == endPosition) {
                applyContarea.innerHTML += '<a href="' + linkUrl + '" target="_blank">' + linkText + '</a>';

            }
            var closeLinkWrap = document.getElementById('linkToolsWrap');
            closeLinkWrap.classList.remove('activeAction');

            document.getElementById("nLinkTxt").value = "";
            document.getElementById("nLinkUrl").value = "";

            return false;
        }

    };
    var cancelLinkClear = document.getElementById("cancelBtnLinkNote");
    cancelLinkClear.onclick = function() {


        var linkTextEmpty = document.getElementById("nLinkTxt");
        var linkUrlEmpty = document.getElementById("nLinkUrl");
        linkTextEmpty.value = "";
        linkUrlEmpty.value = "";
        var closeLinkWrapTXT = document.getElementById('linkToolsWrap');
        closeLinkWrapTXT.classList.remove('activeAction');

        return false;

    };






    this.init(config);

}


//FOcus Notes
// function focusEditNotes(id) {
//     var elems = document.querySelector(".editDetailact");
//     if (elems != null) {
//         elems.classList.remove("editDetailact");
//         elems.parentNode.childNodes[1].classList.remove('hide');

//     }
//     id.classList.add('editDetailact');
//     id.parentNode.childNodes[1].classList.add('hide');
// }

function focusLinkActionDiv(linkedId) {

    linkedId.parentNode.parentNode.childNodes[1].classList.add('activeAction');

}

function focusTxtFormatActionDiv(txtformtId) {
    txtformtId.parentNode.parentNode.childNodes[2].classList.add('activeAction');

}

function focusUploadActionDiv(uploadAction) {
    uploadAction.parentNode.parentNode.childNodes[3].classList.add('activeAction');

}



var savedSelection;

function doSave() {
    savedSelection = saveSelection(document.getElementById("noteTxtArea"));
}
