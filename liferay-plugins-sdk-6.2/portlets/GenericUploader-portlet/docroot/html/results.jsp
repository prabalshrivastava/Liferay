
<style>
.tableGenericUpLoader { display: table; width: 100%; } 
    .trGu { display: table-row; } 
    .theadGu { display: table-header-group } 
    .tbodyGu { display: table-row-group } 
    .tfootGu { display: table-footer-group } 
    .colGu { display: table-column } 
    .colgroupGu { display: table-column-group } 
    .tdGu, .thGu { display: table-cell; } 
    .captionGu { display: table-caption } 
    .tableGu, .theadGu, .tbodyGu, .tfootGu, .trGu, .tdGu, .thGu{ text-align: left; margin: auto; padding: 5px 15px; } .tableGenericUpLoader{ background: #fff; margin: auto; border:none; padding: 0; margin-bottom: 20px; } 
    .thGu
    { 
      font-weight: 600;
    font-size: 10pt;
    border: 1px solid #dfe3e6;
    /* background-color: #faf3f7; */
    background-image: linear-gradient(to bottom,#f9fafc,#f1f4f8);
    } 
    .tdGu{ font-weight: 400; border: 1px solid #e8dee4; background-color: #fffcfe; border-top: none; font-size: 10pt; } 
    .tdGu span#status { color: #4CAF50; font-weight: 600; } 
    .tdGu a.log-link { font-weight: 600; } 
    .aa_htmlTable{ padding: 20px 15px; display: table; width: 100%; height: 100vh; vertical-align: middle; } 
    .aa_css{ padding: 20px 15px; display: table; width: 100%; height: 100vh; vertical-align: middle; } 
    .aa_ahmadawais{ display: table; width: 100%; margin: 5rem auto; } 
    h2.aa_h2 { font-size: 16px; margin-bottom: 5px; padding: 0; font-weight: 700; color: #696868; } 
    .aui .uc-box {
    margin-top: 30px;
    }
  .uc-box-bottom {
      background: #fff;
      margin: -27px 27px 27px 27px;
      padding-bottom: 50px;
  }
  .uc-box {
      width: 720px;
      min-height: 150px;
      margin: 0 auto;
  }
  .btn-file {
     position: relative;
    overflow: hidden;
    width: 100px;
    height: 31px;
    background-color: #e0e0e0 !important;
    border: none;
    border-radius: 5px;
    color: black;
    padding: 5px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-weight: 500;
    cursor: pointer;
    text-transform: uppercase;
  }
  .btn-file input[type=file] {
      position: absolute;
      top: 0;
      right: 0;
      filter: alpha(opacity=0);
      opacity: 0;
      outline: none;
      color: white;
      cursor: inherit;
      display: block;
      cursor: pointer;
  } 
  .aui button.btn-submit
  {
  background-color: #0f9f1c;
    color: #FFF;
    padding: 15px 10px;
    border: 0;
    border-radius: 4px;
    margin-top: 5px;
    width: 100%;
  }
  .aui button.btn-submit:hover{
    opacity: 0.8;
  }
  .aui .control-group.customMargin
  {
    margin-bottom: 10px;
  }

</style>
<div class="aa_css hide"  id="logContainer">
  
 

 <div class="tableGenericUpLoader">
    <div class="theadGu">
      <div class="trGu">
        <div class="thGu">Upload Log Id </div>
        <div class="thGu">Success Count</div>
         <div class="thGu">Status</div>
          <div class="thGu">Start Time</div>
           <div class="thGu">End Time</div>
            <div class="thGu">Error File</div>
             <div class="thGu">Uploaded File </div>
      </div>
    </div>
    <div class="tbodyGu">
      <div class="trGu">
        <div class="tdGu">
          <span id="uploadLogId" class="log-field log-text"></span>
        </div>
        <div class="tdGu">
          <span id="successCount" class="log-field log-text" ></span>
        </div>
          <div class="tdGu">
          <span id="status" class="log-field log-text"></span>
        </div>
          <div class="tdGu">
         <span id="startTime" class="log-field log-text" ></span>
        </div>
          <div class="tdGu">
         <span id="endTime" class="log-field log-text"></span>
        </div>
          <div class="tdGu">
          <a id="errorFileUrl" class="log-field  log-link hide" href="">Download</a>
        </div>
          <div class="tdGu">
         <a id="uploadedFileUrl" class="log-field log-link  hide" href="">Download</a>
        </div>
      </div>
      
    </div>
   
   
 </div>

 <h2 class="aa_h2">Errors:</h2>

 <div class="tableGenericUpLoader">
 	<div class="theadGu">
      <div class="trGu">
        <div class="thGu" style="width: 20%;">SheetName </div>
        <div class="thGu" style="width: 10%;">Row No</div>
         
            <div class="thGu" style="width: 30%;">Column Name</div>
             <div class="thGu" style="width: 40%;">Messages</div>
      </div>
    </div>
    <div class="tbodyGu"  id="errors">
     
      
    </div>

 </div>
<h2 class="aa_h2">Messages:</h2>
 
 <div class="tableGenericUpLoader">
 	<div class="theadGu">
      <div class="trGu">
        <div class="thGu" style="width: 20%;">SheetName </div>
        <div class="thGu" style="width: 10%;">Row No</div>
         
            <div class="thGu" style="width: 30%;">Column Name</div>
             <div class="thGu" style="width: 40%;">Messages</div>
      </div>
    </div>
    <div class="tbodyGu"  id="msgs">
     
      
    </div>

 </div>

<div style="text-align:center;">
<br><a onclick="window.location = window.location.pathname"><button class="normal-cta" type="button">Start Again</button></a>
</div>
 
</div>


<div class="hide">
	<div class="trGu" id="sampleMsgRow">
	
     
		 <div class="tdGu log-field" style="width: 20%;"  id="sheetName"></div> 
		 <div class="tdGu log-field" style="width: 10%;"  id="rowNo"></div>
		 <div class="tdGu log-field" style="width: 30%;"  id="clmnName"></div> 
		 <div class="tdGu log-field" style="width: 40%;"  id="msg"></div>
	
</div>

</div>


