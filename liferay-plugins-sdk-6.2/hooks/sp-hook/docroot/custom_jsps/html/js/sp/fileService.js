/*
const spFileService = function(){
    let base64 = Formio.providers.storage.base64(Formio);  
    let dropbox = Formio.providers.storage.dropbox(Formio);  
    let s3 = Formio.providers.storage.s3(Formio);  
    let url = Formio.providers.storage.url(Formio);
    
    const download = function(storage, file) {
        return Formio.providers.storage.url(Formio).downloadFile(storage); 
    };

    const upload = function(storage, file, fileName, dir, progressCallback, url) {
        return Formio.providers.storage.url(Formio).uploadFile(file, fileName, dir, progressCallback, url); 
    };

    return {
        downloadFile : download,
        uploadFile : upload
    };
}();
*/

// Formio actually contains the file service and is the default when options.fileService is not specified
const spFileService = new Formio();