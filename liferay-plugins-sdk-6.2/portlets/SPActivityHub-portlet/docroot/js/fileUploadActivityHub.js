var fileUploadActivityHub = function() {
    this.ajaxurl = "";
    this.pns = "";
    var instance = this;

    this.removeFromProgress = function(file) {
        if (instance.progressData) {
            var index = instance.progressData.indexOf(file.name);
            if (index >= 0) {
                instance.progressData.splice(index, 1);
            }
        }
    }
    this.isInProgress = function() {
        var progress = false;
        if (instance.progressData && instance.progressData.length > 0) {
            progress = true;
        }
        return progress;
    }
    this.uploadFile = function(file) {

        var xhr = new XMLHttpRequest();
        if (xhr.upload) {
            instance.progressData = [];
            instance.progressData.push(file.name);
            // progress bar


            xhr.upload.addEventListener("progress", function(e) {
                var progressFrameID = document.getElementsByClassName(instance.progressStateId);
                for (var i = 0; i < progressFrameID.length; i++) {

                    var pc = parseInt(e.loaded / e.total * 100);
                    var width = 0;
                    progressFrameID[i].style.backgroundPosition = pc + "0%";
                    progressFrameID[i].style.backgroundColor = "#48d321";
                    progressFrameID[i].style.fontSize = "8px";
                    progressFrameID[i].style.paddingTop = "2px";
                    progressFrameID[i].style.paddingBottom = "2px";
                    progressFrameID[i].style.paddingLeft = "4px";
                    progressFrameID[i].style.paddingRight = "4px";
                    progressFrameID[i].style.marginTop = "5px";
                    progressFrameID[i].style.borderRadius = "5px";
                    progressFrameID[i].style.color = "#FFFFFF";
                    progressFrameID[i].style.display = "block";
                    width++;
                    progressFrameID[i].style.width = pc + '%';
                 
                }



            }, false);
            // file received/failed
            xhr.onreadystatechange = function(e) {
                if (xhr.readyState == 4) {
                    instance.removeFromProgress(file);
                    if (xhr.status == 200) {
                        var restext = xhr.responseText.replace(/\n/g, "");
                        var jsonobj = JSON.parse(restext);
                        if (instance.handleResponse) {
                            instance.handleResponse(jsonobj);
                        } else if (instance.hiddenFieldId) {
                            if (jsonobj) {
                                if (jsonobj.tempFileEntryId) {
                                    var progressFrameID = document.getElementsByClassName(instance.progressStateId);
                                    for (var i = 0; i < progressFrameID.length; i++) {

                                        var pc = parseInt(e.loaded / e.total * 100);
                                        var width = 0;
                                        progressFrameID[i].style.backgroundColor = "#48d321";
                                        progressFrameID[i].style.backgroundPosition = pc + "0%";
                                        progressFrameID[i].style.backgroundColor = "#48d321";
                                        progressFrameID[i].style.fontSize = "8px";
                                        progressFrameID[i].style.paddingTop = "2px";
                                        progressFrameID[i].style.paddingBottom = "2px";
                                        progressFrameID[i].style.paddingLeft = "4px";
                                        progressFrameID[i].style.paddingRight = "4px";
                                        progressFrameID[i].style.marginTop = "5px";
                                        progressFrameID[i].style.borderRadius = "5px";
                                        progressFrameID[i].style.color = "#FFFFFF";
                                        progressFrameID[i].style.display = "block";
                                        width++;
                                        progressFrameID[i].style.width = pc + '%';
                                        progressFrameID[i].innerHTML =    'File uploaded successfully';

                                    }
                                    console.log("File uploaded successfully" + jsonobj.tempFileEntryId);
                                    //A.one("#" + instance.hiddenFieldId).val(jsonobj.tempFileEntryId);
                                    A.one("#" + instance.hiddenFieldId).val(A.one("#" + instance.hiddenFieldId).val() + "," + jsonobj.tempFileEntryId);
                                } else {
                                    alert("error");
                                }
                            } else {
                                alert("error");
                            }

                        } else {
                            if (jsonobj) {
                                if (jsonobj.tempFileEntryId) {
                                    //alert("File uploaded successfully" + jsonobj.tempFileEntryId);
                                    console.log("File uploaded successfully" + jsonobj.tempFileEntryId);
                                } else {
                                    alert("error");
                                }
                            } else {
                                alert("error");
                            }
                        }
                    }
                }
            };
            var formData = new FormData();
            formData.append("file", file);
            formData.append("action", "uploadFileToTemp");
            // start upload
            xhr.open("POST", instance.ajaxurl, true);
            //	xhr.setRequestHeader("Content-Type", "multipart/form-data");
            xhr.send(formData);
        }
    };

    // initialize
    // hiddenFieldId is used to store the file entry id of file uploaded
    this.init = function(ajaxurl, pns, fileElementId, hiddenFieldId, handleResponse, progressStateId) {
        instance.ajaxurl = ajaxurl;
        instance.pns = pns;
        instance.fileElementId = fileElementId;
        instance.hiddenFieldId = hiddenFieldId;
        instance.handleResponse = handleResponse;
        instance.progressStateId = progressStateId;
        var xhr = new XMLHttpRequest();
        if (xhr.upload) {
            var fileElmnt = A.one("#" + fileElementId);
            if (fileElmnt) {
                var flist = document.getElementById(instance.fileElementId).files;
                for (var i = 0; i < flist.length; i++) {
                    var file = flist[i];
                    instance.uploadFile(file);
                }
            }
        }
    };
};