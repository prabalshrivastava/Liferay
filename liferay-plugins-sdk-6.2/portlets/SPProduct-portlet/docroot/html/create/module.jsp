<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.sambaash.platform.srv.model.Activity" %>
<%@ page import="com.sambaash.platform.srv.model.Module" %>
<%@ page import="com.sambaash.platform.srv.model.Schedule" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<%
    String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.default";
    String moduleDescriptionLabel = "Module Description";
    moduleDescriptionLabel = LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.modules.moduleDescription");
    String outlineDescriptionLabel = "Outline Description (Knowledge / Skill)";
    outlineDescriptionLabel = LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.modules.outlineDescription");
    String certificateDescLabel = "Certificates General Description";
    certificateDescLabel = LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.modules.certifcateDescription");
    String sessionDescLabel = "Session Description";
    sessionDescLabel = LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.modules.sessionDescription");
    String activityDescLabel = "Activity Description";
    activityDescLabel = LabelUtil.getLabel(portletConfig,themeDisplay,"label.product.create.modules.activityDescription");
    Module module = (Module) request.getAttribute("moduleDetail");
    if (Validator.isNotNull(module)) {
        moduleDescriptionLabel = module.getGeneralDesc();
    }
%>


<portlet:resourceURL var="createModule">
    <portlet:param name="action" value="addModule"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="outlineDetail">
    <portlet:param name="action" value="getOutline"></portlet:param>
</portlet:resourceURL>

<%@ include file="/html/create/msg.jsp" %>

<div class="Product_Section screen-max-width">
    <div class="Product_Sidebar">
        <%@ include file="/html/create/navigation.jsp" %>
    </div>

    <div class="Product_wrapper">
        <div class="Border" id="mainContainer">
            <!--HEADER-->
            <div class="Product_header">
                <div class="Prod-Headtitle">
                    <h2><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.modules")%></h2>
                    <div class="Backtolist-btn">
                        <a href="<%=listModule%>"><span><</span><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.back")%></a>
                    </div>
                </div>

                <div class="Prod-HeadContent">
                    <a href="#"> <img
                            src="<%=request.getContextPath()%>/images/Product_create/Icon-Modules.svg" alt="Modules">
                        <c:if test="${empty moduleDetail.spModuleId}">
                            <h2 id="header"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.module.createModule")%></h2>
                        </c:if>
                        <c:if test="${not empty moduleDetail.spModuleId}">
                            <h2 id="header"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.module.updateModule")%></h2>
                        </c:if>
                    </a>
                </div>
            </div>
            <!--HEADER end-->
            <div class="active-content-Sec  ProdBorder-active">
                <span></span>
            </div>
            <!--HEADER END-->

            <!--CONTENTSECTION FRAMEWORK-->
            <form action="#" method="POST" id="fmId" name="fm">
                <div class="Product_contsection">
                    <div id="Product_Modules">
                        <div class="Form-Prodsection Form-padding ">
                            <input type="hidden" id="spModuleId" name="spModuleId"
                                   value="${moduleDetail.spModuleId}">
                            <div class="Input_HalfWidth Margin-20">
                                <input type="text" id="moduleCodeId" name="moduleCode"
                                       value="${moduleDetail.moduleCode}" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.modules.moduleCode")%>*"
                                       class="Requiredfield"
                                       onblur="requiredFieldValidation( this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.modules.moduleCode")%>*' , ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>')">
                                <div class="icon-right">MC</div>
                            </div>

                            <div class="Input_HalfWidth">
                                <input type="text" id="moduleNameId" name="moduleName"
                                       value="${moduleDetail.moduleName}" maxlength="75"
                                       placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.modules.moduleName")%>*" class="Requiredfield"
                                       onblur="requiredFieldValidation( this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.modules.moduleName")%>*' , ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>')">
                            </div>
                            <div class="Input_HalfWidth Margin-20">
                                <div class="select_style" id="Producttype1_select">
                                    <select id="countryListId" name="countryList"
                                            class="Requiredfield"
                                            onblur="requiredFieldValidation( this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.competencyUnit.originCountry")%> *' , ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>')">
                                        <option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.competencyUnit.originCountry")%>*
                                        </option>
                                        <c:forEach var="country" items="${countryList}">
                                            <c:if test="${moduleDetail.countryId ==  country.categoryId}">
                                                <option value="${country.categoryId}" selected>${country.name}</option>
                                            </c:if>
                                            <c:if test="${moduleDetail.countryId !=  country.categoryId}">
                                                <option value="${country.categoryId}">${country.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="Input_Fullwidth margin-20-topbottom">
                                <liferay-ui:input-editor name='<%="module_description"%>'
                                                         editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY%>" toolbarSet="sp"
                                                         initMethod='<%="initEditor_module_description"%>'
                                                         cssClass="ckeditor"/>
                                <input type="hidden" value="" name="moduleDescription"
                                       id="moduleDescriptionId">
                                <c:set var="moduleDesc" value="${moduleDetail.moduleDesc}"/>
                                <%
                                    String modDesc = (String) pageContext.getAttribute("moduleDesc");
                                %>
                                <aui:script>
                                    function <portlet:namespace/>initEditor_module_description() {
                                    <c:if test="${empty moduleDetail}">
                                        return "<%=UnicodeFormatter.toString(moduleDescriptionLabel)%>";
                                    </c:if>
                                    <c:if test="${!empty moduleDetail}">
                                        return "<%=UnicodeFormatter.toString(modDesc)%>";
                                    </c:if>
                                    }
                                </aui:script>


                            </div>
                            <div class="Input_HalfWidth Margin-20">
                                <div class="select_style" id="Producttype1_select">
                                    <select id="moduleTypeListId" name="moduleTypeList"
                                            class="Requiredfield"
                                            onblur="requiredFieldValidation( this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.moduleType")%> *' , ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>')">
                                        <option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.moduleType")%> *</option>
                                        <c:forEach var="moduleType" items="${moduleTypeList}">
                                            <c:if
                                                    test="${moduleDetail.moduleType ==  moduleType.categoryId}">
                                                <option value="${moduleType.categoryId}"
                                                        selected>${moduleType.name}</option>
                                            </c:if>
                                            <c:if
                                                    test="${moduleDetail.moduleType !=  moduleType.categoryId}">
                                                <option value="${moduleType.categoryId}">${moduleType.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="Input_HalfWidth ">
                                <input type="text" id="creditsId" name="credits"
                                       value="${moduleDetail.creditValue}" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.competencyUnit.credits")%>*"
                                       class="Requiredfield Numberfield"
                                       onblur="numberfieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.competencyUnit.credits")%>*' , '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>',' <%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.required.message")%>')">
                                <div class="icon-right">CVs</div>
                            </div>
                            <div class="Input_HalfWidth Margin-20">
                                <input type="text" id="durationId" name="duration"
                                       value="${moduleDetail.moduleDuration}" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.duration")%>*"
                                       class="Requiredfield">
                            </div>
                            <div class="Input_HalfWidth ">
                                <input type="text" id="noOfSessionsId" name="noOfSessions"
                                       value="${moduleDetail.noOfSessions}"
                                       placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.sessions")%>*"
                                       class="Requiredfield Numberfield"
                                       onblur="numberfieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.sessions")%>*' , '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>',' <%= LabelUtil.getLabel(pageContext, themeDisplay, "label.product.create.required.message")%>')">
                                <div class="icon-right">Session(s)</div>
                            </div>
                            <div class="Input_Fullwidth">
                                <div class="select_style" id="Producttype1_select">
                                    <select id="frameworkListId" name="frameworkList"
                                            class="Requiredfield"
                                            onblur="requiredFieldValidation(this, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.framework")%> *' , ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>')">
                                        <option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.sidebar.menu.framework")%> *</option>
                                        <c:if test="${!empty moduleFrameWorkDetail}">
                                            <c:forEach var="framework" items="${frameworkList}">
                                                <c:forEach var="moduleFrameWorkDetail"
                                                           items="${moduleFrameWorkDetail }">
                                                    <c:if
                                                            test="${moduleFrameWorkDetail.spFrameworkId ==  framework.spFrameworkId}">
                                                        <option value="${framework.spFrameworkId}"
                                                                selected>${framework.frameworkCode}</option>
                                                    </c:if>
                                                    <c:if
                                                            test="${moduleFrameWorkDetail.spFrameworkId !=  framework.spFrameworkId}">
                                                        <option value="${framework.spFrameworkId}">${framework.frameworkCode}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${empty moduleFrameWorkDetail}">
                                            <c:forEach var="framework" items="${frameworkList}">
                                                <option value="${framework.spFrameworkId}">${framework.frameworkCode}</option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                            </div>

                            <div class="Input_Fullwidth">
                                <div id="selectedCompetency"
                                     class="selectedCompetency selectedList"></div>
                            </div>
                            <div class="Input_Fullwidth">
                                <input name="valueToBeSaved" id="valueToBeSavedId" type="hidden"
                                       class="Requiredfield autoComplete" value="0" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.addCompetency")%>*">
                                <input name="competencyUnitList"
                                       class="selectedListInput competencyUnitList"
                                       id="competencyUnitListId" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.addCompetency")%>*">
                                <div class="search_icon">
                                    <img
                                            src="/SPProduct-portlet/images/Product_create/search.svg" alt="Search">
                                </div>
                            </div>

                            <div class="Input_Fullwidth Outcome_div" id="outcome_div">
                                <div class="outcomeDetails" id="outlineDetailsId">
                                    <c:forEach var="outLineList" items="${outLineList}">
                                        <div class="outcomeTitle">${outLineList.outlineType }</div>
                                        <div class="outcomeDesc">${outLineList.outlineDesc }</div>
                                    </c:forEach>
                                </div>
                            </div>

                            <div class="Input_Fullwidth margin-20-topbottom">
                                <ul>

                                    <li class="Border-custom1-right ModuleSchedule_active"
                                        id="Module_schedule"><a href="#"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.schedule")%> +</a></li>
                                    <li id="Module_certificate" class="ModuleCertificate_active"><a
                                            href="#"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.certificates")%> +</a></li>
                                </ul>
                            </div>
                            <div id="schCertErrorMsg" class="error"></div>
                            <!--SCHEDULE SECTION-->
                            <div style="display:none;">
                                <select hidden="true" id="sessionTypeListId" name="sessionTypeList"
                                        class="sessionTypeList">
                                    <option selected disabled value="0"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.sessionType")%></option>
                                    <c:forEach var="sessionType" items="${sessionTypeList}">
                                        <option value="${sessionType.categoryId}">${sessionType.name}</option>
                                    </c:forEach>

                                </select>
                            </div>
                            <div id="scheduleSection" class="Display-none">
                                <input type="hidden" id="gbSchInstanceCountId" name="gbSchInstanceCount" value="0">
                                <div class="Input_Fullwidth text-right ">
                                    <a href="javascript:addScheduleInstances('','','','','')"
                                       class="Button-green button-pos-right Add_Schedule"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.addSchedule")%></a>
                                </div>
                                <div id="scheduleInner">
                                    <%-- <c:if test="${!empty scheduleDetail}">
                                        <%@ include file="/html/create/module_edit.jsp"%>
                                    </c:if>
                                    <c:if test="${empty scheduleDetail}">
                                        <%@ include file="/html/create/schedule_activity.jsp"%>
                                    </c:if> --%>
                                    <!--ACTIVITY SECTION END-->

                                </div>
                                <!-- scheduleInner -->
                                <div id="scheduleAppendSection"></div>
                            </div>
                            <!--SCHEDULE SECTION END-->


                            <!--CERTIFICATE SECTION-->
                            <div id="certificateSection" class="Display-none">
                                <div class="Input_Fullwidth">
                                    <div class="sc_head">
                                        <div class="sc_title"><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.addCertificate")%></div>
                                    </div>
                                    <div class="Input_Fullwidth margin-20-topbottom">
                                        <liferay-ui:input-editor
                                                name='<%="certificates_description"%>'
                                                editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY%>" toolbarSet="sp"
                                                initMethod='<%="initEditor_certificates_description"%>'
                                                cssClass="ckeditor"/>
                                        <input type="hidden" value="" name="certificatesDescription"
                                               id="certificatesDescriptionId">
                                        <c:set var="certDesc" value="${moduleDetail.generalDesc}"/>
                                        <%
                                            String cerificateDesc = (String) pageContext.getAttribute("certDesc");
                                        %>
                                        <aui:script>
                                            function <portlet:namespace/>initEditor_certificates_description() {
                                            <c:if test="${empty moduleDetail}">
                                                return "<%=UnicodeFormatter.toString(certificateDescLabel)%>";
                                            </c:if>
                                            <c:if test="${!empty moduleDetail}">
                                                return "<%=UnicodeFormatter.toString(cerificateDesc)%>";
                                            </c:if>
                                            }
                                        </aui:script>


                                    </div>
                                </div>

                                <div class="Input_Fullwidth">
                                    <div id="selectedCertificates" class="selectedCertificates selectedList"></div>
                                </div>
                                <div class="Input_Fullwidth">
                                    <input name="certificateList"
                                           class="selectedListInput certificateList"
                                           id="certificateListId" placeholder="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.addCertificate")%>">
                                    <div class="search_icon">
                                        <img
                                                src="/SPProduct-portlet/images/Product_create/search.svg" alt="Search">
                                    </div>
                                    <input name="certValueToBeSaved" id="certValueToBeSavedId" class=""
                                           type="hidden" value="0">
                                </div>
                            </div>
                            <!--CERTIFICATE SECTION END-->


                        </div>
                        <!-- Form-Prodsection -->
                    </div>
                    <!-- Product_Modules -->
                </div>
                <!-- Product_contsection -->
            </form>


        </div>

        <div class="Product_bottom">
            <!-- <a href="#">Cancel</a><a href="javascript:;"
            onclick="submitForm('fmId','Schedule_wrapper','Activity_wrapper');" id="moduleSubmitButton">Save
            Changes</a> -->
            <input type="button" id="moduleCancelButton" value="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.cancel")%>"
                   onclick="window.location.href='<%= listModule %>'">
            <input type="button" id="moduleSubmitButton"
                   onclick="submitForm('fmId','Schedule_wrapper','Activity_wrapper');"
                   value="<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.saveChanges")%>">
        </div>
    </div>
    <!-- Product_wrapper end -->

</div>
<!--</div>Product_Section -->


<!--TAB VIEW-->

<script type="text/javascript">
    var competencyUnitListJSON = ${competencyUnitList};
    var certificatesListJSON = ${certificatesList};
    var moduleCompetencyUnitListJSON = ${moduleCompetencyUnitListJSON};
    var moduleCertificateListJSON = ${moduleCertificatesListJSON};
    autoCompleteList('.competencyUnitList', competencyUnitListJSON, moduleCompetencyUnitListJSON, 'valueToBeSavedId', 'selectedCompetency', 'competencyUnitListId','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.addCompetency")%>*');
    autoCompleteList('.certificateList', certificatesListJSON, moduleCertificateListJSON, 'certValueToBeSavedId', 'selectedCertificates', 'certificateListId','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.course.addCertificate")%>');

    YUI()
            .use(
                    'node',
                    'transition',
                    function (Y) {

                        //schedule
                        if (Y.one('#Module_schedule')) {
                            var addSchedule = Y.all('#Module_schedule');
                            addSchedule.on('click', addScheduleClick);
                        }


                        //Add Schedule
                        function addScheduleClick(e) {


                            e.preventDefault();
                            document.getElementById("schCertErrorMsg").innerHTML = "";
                            var scheduleSectionItem = Y
                                    .all('#scheduleSection');

                            for (var i = 0; i < scheduleSectionItem.size(); i++) {
                                var scheduleSectionItem1 = Y
                                        .all('#scheduleSection');
                                var scheduleSectionactive = Y
                                        .one('.ModuleSchedule_active');
                                scheduleSectionItem1.removeClass('Display-none');
                                scheduleSectionactive.addClass('active');

                                //CERTIFICATE
                                var CertificateItems = Y
                                        .all('#certificateSection');
                                var Certificateactive = Y
                                        .one('.ModuleCertificate_active');
                                Certificateactive.removeClass('active');
                                CertificateItems.addClass('Display-none');

                            }

                        }


                        //Certificate MODULE
                        if (Y.one('#Module_certificate')) {
                            var Addcertificate = Y
                                    .all('#Module_certificate');
                            Addcertificate.on('click', AddcertificateClick);
                        }

                        function AddcertificateClick(e) {
                            e.preventDefault();
                            document.getElementById("schCertErrorMsg").innerHTML = "";
                            // var isValidate2 = validateForm("scheduleSection");
                            isValidate2 = true;
                            if (isValidate2) {
                                var CertificateItems = Y
                                        .all('#certificateSection');
                                for (var i = 0; i < CertificateItems.size(); i++) {
                                    var CertificateItems1 = Y
                                            .all('#certificateSection');
                                    var Certificateactive = Y
                                            .one('.ModuleCertificate_active');
                                    CertificateItems1
                                            .removeClass('Display-none');
                                    Certificateactive.addClass('active');

                                    //Schedule
                                    var scheduleItems1 = Y
                                            .all('#scheduleSection');
                                    var scheduleActive = Y
                                            .one('.ModuleSchedule_active');
                                    scheduleActive.removeClass('active');
                                    scheduleItems1.addClass('Display-none');
                                }
                            }
                        }


                        //initialize schedule

                        var scheduleDetail = ${scheduleListJSON};
                        console.log("scheduleDetail initialised " + new Date().getTime());
                        if (document.getElementById("schInitialised")) {
                            console.log("Schedule instances already initisalised");
                        } else {
                            var initDiv = document.createElement('div');
                            initDiv.setAttribute("class", "Display-none");
                            initDiv.setAttribute("id", "schInitialised");
                            Y.one('#Module_schedule').appendChild(initDiv);
                            if (scheduleDetail != 0) {
                                for (key in scheduleDetail) {
                                    var items = scheduleDetail[key];
                                    for (key in items) {
                                        console.log("items key " + key);
                                        var activityDetails = items[key].activityDetails;
                                        var sessionDescription = unicodeToChar(items[key].sessionDescription);
                                        var sessionType = items[key].sessionType;
                                        var sessionNumber = items[key].sessionNumber;
                                        var sessionDuration = items[key].sessionDuration;

                                        addScheduleInstances(sessionDescription, sessionType, sessionNumber, sessionDuration, activityDetails);
                                    }
                                }

                            } else {
                                addScheduleInstances('', '', '', '', '');
                            }
                        }


                    });

    function createSelectedList(listName, listId, displayDiv, valueDiv) {
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
        var div3 = document.createElement('div');
        div3.setAttribute("class", "sel-list-remove");
        var span2 = document.createElement('span');
        var text2 = document.createTextNode("X");
        span2.setAttribute("class", "removeSelList");
        span2.setAttribute("onClick", "removeElement(" + listId + "," + valueDiv + ")");
        span2.appendChild(text2);
        div3.appendChild(span2);
        div1.appendChild(div2);
        div1.appendChild(div3);
        selListDiv.appendChild(div1);
    }

    function removeElement(listId, valueDivElem) {
        var elem = document.getElementById("selWrap_" + listId);
        var elemId = valueDivElem;//document.getElementById(valueDivElem);
        elemIdValues = elemId.value;
        if (elemIdValues.indexOf(listId) != -1) {
            var val = "," + listId;
            elemIdValues = elemIdValues.replace(new RegExp(val), '');
            elemId.value = elemIdValues;
        }
        elem.remove();
        return true;
    }

    function autoCompleteList(className, sourceJSON, extsourceJSON, valueToBeSaved, displayDiv, inputNodeId,placeholder) {
        var items = extsourceJSON;
        var itemIds = "0";
        var itemNames = "";
        if (extsourceJSON != "0") {
            for (key in items) {
                var ss = items[key];
                itemIds += "," + ss.key;
                itemNames += "," + ss.code;
                //tag,className,id,name,type,placeholder,maxlength,event,eventValue,url,isMandatory,isNumberOnly,isTextOnly
                document.getElementById(valueToBeSaved).value = itemIds;
                createSelectedList(ss.code, ss.key, displayDiv, valueToBeSaved);
            }

            //document.getElementById("selectedCompetency").innerHTML = itemNames;

        }
        AUI().use('aui-node', 'aui-base', 'aui-io-request', 'autocomplete-list', 'aui-io-request', 'autocomplete-filters', 'autocomplete-highlighters', function (A) {
            if (competencyUnitListJSON) {
                var autoComplete = new A.AutoCompleteList(
                        {
                            allowBrowserAutocomplete: 'false',
                            inputNode: className,
                            activateFirstItem: 'true',
                            source: sourceJSON,
                            resultTextLocator: 'code',
                            resultHighlighter: 'startsWith',
                            resultFilters: 'startsWith',
                            minQueryLength: 0,
                            maxResults: 10,
                            queryDelimiter: ',',
                            on: {
                                select: function (event) {
                                    var result = event.result.raw;
                                    var elementToSaveValues = document.getElementById(valueToBeSaved);
                                    var elemValues = elementToSaveValues.value;
                                    var reslt = "," + result.key + ","
        			    			if(elemValues.indexOf(reslt) == -1){
                                        elementToSaveValues.value += "," + result.key;
                                        document.getElementById(inputNodeId).classList.remove("Error-success");
                                        document.getElementById(inputNodeId).classList.remove("Error");
                                        document.getElementById(inputNodeId).placeholder = placeholder;
                                        createSelectedList(result.code, result.key, displayDiv, valueToBeSaved);
                                    }
                                    //alert("data.key " + result.key);
                                }
                            },
                            after: {
                                select: function (event) {
                                    clearAutoCompleteData(inputNodeId);
                                }
                            },
                            render: 'true'
                        }).render();
            }
        });
    }


    function submitForm(fmId, wrapperInstance1, wrapperInstance2) {
    	console.log("module form submitted " + new Date().getTime());
        document.getElementById("moduleDescriptionId").value = window.<portlet:namespace />module_description
                .getHTML();
        document.getElementById("certificatesDescriptionId").value = window.<portlet:namespace />certificates_description
                .getHTML();

        var schInstancesCount = parseInt(document.getElementById("gbSchInstanceCountId").value);

        var spModuleId = document.getElementById("spModuleId").value;
        for (var i = 0; i < schInstancesCount; i++) {
            if (document.getElementById(i + "_gbActCountId")) {
                var actvInstancesCount = parseInt(document.getElementById(i + "_gbActCountId").value);
                setCKEditorValues('Ip_eligibility_criteria_desc_', 'eligibility_criteria_desc_', i);
                for (var j = 0; j < actvInstancesCount; j++) {
                    var gName = "SchedulewrapperId_" + i + "_activitywrapperId_" + j + "_activity_desc_";
                    gName1 = 'Ip_' + gName;
                    setCKEditorValues(gName1, gName, j);
                }
            }
        }
        var isValidate = validateForm("Product_Modules",' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.message")%>',' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.number.message")%>', ' <%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.url.message")%>','<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.required.select.message")%>');
        //alert("isValidate");
        if (isValidate) {
            //document.getElementById("moduleSubmitButton").disabled = true;
            AUI().use('aui-io-request', function (A) {
                startPreLoader("mainContainer");
                A.io.request('${createModule}',
                        {
                            method: 'post',
                            form: {id: fmId},
                            data: {
                                schInstancesCount: schInstancesCount,
                                actvInstancesCount: 0,
                                spModuleId: spModuleId
                            },
                            on: {
                                complete: function () {
                                    stopPreLoader("mainContainer");
                                },
                                success: function () {
                                	console.log("module form submit success " + new Date().getTime());
                                    var data = this.get('responseData');
                                    if (data) {
                                        if (typeof data == "string") {
                                            // dont know, somehow response is in string format
                                            data = JSON.parse(data);
                                        }
                                        if (data.error) {
                                            displayError(data.error);
                                        } else if (data.spModuleId > 0) {
                                            // here data.spModuleId = value returned from server
                                            //  spModuleId is value submitted to server
                                            var moduleIdNode = A.one("#spModuleId");
                                            var modeuleId = moduleIdNode.val();
                                            moduleIdNode.val(data.spModuleId);
                                            if (modeuleId > 0) { //existing
                                                displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.modules.updated")%>');
                                            } else {
                                                displaySuccess('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.modules.created")%>');
                                                A.one("#header").setContent('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.module")%>');
                                            }
                                        } else {
                                            // This case is very very rare
                                            displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.modules.save.error")%><%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.screen.refresh")%>');
                                        }
                                    } else {
                                        displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.modules.save.error")%>');
                                    }
                                    window.scrollTo(0,0);
                                },
                                failure: function () {
                                    displayError('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.create.modules.save.error")%>');
                                    window.scrollTo(0,0);
                                }
                            }
                        });
            });
        }
    }


    function addScheduleInstances(sessionDescription, sessionType, sessionNumber, sessionDuration, activityDetails) {

    	console.log("addScheduleInstances adding schedule -- session number " + sessionNumber + " "+ new Date().getTime());
        var globalScheduleCount = parseInt(document.getElementById("gbSchInstanceCountId").value);


        if (sessionDescription == null || sessionDescription == '') {
            sessionDescription = "<%=sessionDescLabel%>";
        }

        var schInstances = document.getElementsByClassName("Schedule_wrapper");
        var count = globalScheduleCount;
        var mainSchWrapper = document.getElementById("scheduleInner");

        //main wrapper
        var schWrap = createInstanceElements("div", "Schedule_wrapper", "SchedulewrapperId_" + count, '', '', '', '', '', '', '', '', '', '','','');
        var secWrap = createInstanceElements("div", "form-inner Form-padding sc_title", '', '', '', '', '', '', '', '', '', '', '','','');
        secWrap.innerHTML = '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.schedule")%>';
        schWrap.appendChild(secWrap);

        //insctance count
        var instCount = createInstanceElements("input", '', 'activityInstId_' + count, 'activityInst_' + count, 'hidden', '', '', '', '', '', '', '', '','','');
        schWrap.appendChild(instCount);
        //schedule
        //var schTitle =

        //close Button
        var clsButtonDiv = createInstanceElements("div", "close_button", "closeButtonId" + count, '', '', '', '', '', '', '', '', '', '','','');
        var clsButtonSpan = createInstanceElements("span", '', '', '', '', '', '', 'onclick', 'javascript:removeByInstanceId("SchedulewrapperId_' + count + '")', '', '', '', '','','');
        var clsButtonImg = createInstanceElements("img", '', '', '', '', '', '', '', '', '/SPProduct-portlet/images/Product_create/Close-icon.svg', '', '', '','','');
        clsButtonSpan.appendChild(clsButtonImg);
        clsButtonDiv.appendChild(clsButtonSpan);
        secWrap.appendChild(clsButtonDiv); //added button to schedule instance

        //schedule fields wrap
        var schFieldsWrap = createInstanceElements("div", "form-summary-inner", '', '', '', '', '', '', '', '', '', '', '','','');
        //schedule number
        var schNumber = createInstanceElements("div", "Input_Fullwidth", '', '', '', '', '', '', '', '', '', '', '','','');
        var schNumberIp = createInstanceElements("input", "sessionNumber  ", "sessionNumberId_" + count, 'sessionNumber_' + count, 'text', '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.sessionNumber")%>', '', '', '', '', '', '', '','','');
        if (sessionNumber != '') {
            schNumberIp.setAttribute("value", sessionNumber);
        }
        schNumber.appendChild(schNumberIp);
        schFieldsWrap.appendChild(schNumber);//added schedule number
        //ck-editor
        var ckEditorDiv = createInstanceElements("div", "Input_Fullwidth margin-20-topbottom", '', '', '', '', '', '', '', '', '', '', '','','');
        var edtrName = "eligibility_criteria_desc_" + count;
        var edtrTxtArea = createInstanceElements("textarea", 'lfr-editor-textarea', '', edtrName, '', '', '', '', '', '', '', '', '','','');
        edtrTxtArea.setAttribute("style", "height:159px");
        ckEditorDiv.appendChild(edtrTxtArea);
        schFieldsWrap.appendChild(ckEditorDiv);//added ck editor
        //sessionTypeList
        var optionList = document.getElementById("sessionTypeListId").innerHTML;
        var ssnTypeListWrp = createInstanceElements("div", 'Input_HalfWidth Margin-20', '', '', '', '', '', '', '', '', '', '', '','','');
        var ssnTypeListDiv = createInstanceElements("div", 'select_style', "sessionType_select_" + count, '', '', '', '', '', '', '', '', '', '','','');
        var ssnTypeListSelect = createInstanceElements("select", "sessionTypeList", "sessionTypeListId_" + count, 'sessionTypeList_' + count, '', '', '', '', '', '', '', '', '','','');
        ssnTypeListSelect.innerHTML = optionList;
        if (sessionType != '') {
            ssnTypeListSelect.value = sessionType;
        }
        //var ssnTypeListSelOption = addSelectOptions("option","value","Session Type *",'',ssnTypeListSelect);
        ssnTypeListDiv.appendChild(ssnTypeListSelect);
        ssnTypeListWrp.appendChild(ssnTypeListDiv);
        schFieldsWrap.appendChild(ssnTypeListWrp);//added sessionTypeList

        //sessionDuration
        var ssnDurationWrp = createInstanceElements("div", 'Input_HalfWidth', '', '', '', '', '', '', '', '', '', '', '','','');
        var ssnDurationIp = createInstanceElements("input", 'sessionDuration scheduleFields', 'sessionDurationId_' + count, 'sessionDuration_' + count, 'text', '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.sessionDuration")%>', '', '', '', '', '', '', '','','');
        if (sessionDuration != '') {
            ssnDurationIp.setAttribute("value", sessionDuration);
        }
        ssnDurationWrp.appendChild(ssnDurationIp);
        schFieldsWrap.appendChild(ssnDurationWrp);//added sessionDuration
        secWrap.appendChild(schFieldsWrap);
        schWrap.appendChild(secWrap);
        mainSchWrapper.appendChild(schWrap);
        addCKEditor(edtrName, false, ckEditorDiv, sessionDescription);
        var c = 0;
        if (activityDetails != '') {
            for (key in activityDetails) {
                console.log("activityDetails key " + key);
                console.log("activityDetails  " + activityDetails[key].activityDescription);
                if (c == 0) {
                    addActivityInstances(count, true, activityDetails[key].activityDescription, activityDetails[key].activityTiming, activityDetails[key].activityPerformer, activityDetails[key].activityDuration);

                } else {
                    addActivityInstances(count, false, activityDetails[key].activityDescription, activityDetails[key].activityTiming, activityDetails[key].activityPerformer, activityDetails[key].activityDuration);
                }
                c = c + 1;
            }
        } else {
            addActivityInstances(count, true, '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.activityDescription")%>', '', '', '');
        }

        document.getElementById("gbSchInstanceCountId").value = globalScheduleCount + 1;

    }

    function addActivityInstances(count, fromSchedule, activityDescription, activityTiming, activityPerformer, activityDuration) {
		
    	console.log("addActivityInstances " + new Date().getTime());
        if (activityDescription == null || activityDescription == '') {
            activityDescription = "<%=activityDescLabel%>";
        }

        var activityInstances = document.getElementsByClassName('Activity_wrapper');
        var schWrap = document.getElementById("SchedulewrapperId_" + count);

        //maintain global count
        if (document.getElementById(count + "_gbActCountId")) {
            gbSchActCount = parseInt(document.getElementById(count + "_gbActCountId").value);
        } else {
            var hiddenSchActCount = document.createElement("INPUT");
            hiddenSchActCount.setAttribute("type", "hidden");
            hiddenSchActCount.setAttribute('name', count + "_gbActCount");
            hiddenSchActCount.setAttribute('id', count + "_gbActCountId");
            hiddenSchActCount.setAttribute('value', '0');
            schWrap.appendChild(hiddenSchActCount);
            gbSchActCount = 0;
        }

        var aCount = gbSchActCount;


        //Activity main wrap

        var activityMainWrap = createInstanceElements("div", '', 'activitySectionId_' + aCount, '', '', '', '', '', '', '', '', '', '','','');
        //createInstanceElements(tag,className,id,name,type,placeholder,maxlength,event,eventValue,url,isMandatory,isNumberOnly,isTextOnly);
        //add button
        if (fromSchedule) {
            var addButtonDiv = createInstanceElements("div", 'Input_Fullwidth text-right', '', '', '', '', '', '', '', '', '', '', '','','');
            var addButtonLink = createInstanceElements("a", 'Button-green button-pos-right Add_Activitytype', '', '', '', '', '', '', '', '', '', '', '','','');
            addButtonLink.setAttribute("href", "javascript:addActivityInstances('" + count + "',false,'','','','')");
            var optTextNode = document.createTextNode('<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.addActivity")%>');
            addButtonLink.appendChild(optTextNode);
            addButtonDiv.appendChild(addButtonLink);
            activityMainWrap.appendChild(addButtonDiv);//add button added
        }

        // activity inner wrap
        var activityInner = createInstanceElements("div", '', 'activityInner', '', '', '', '', '', '', '', '', '', '','','');
        var activityWrap = createInstanceElements("div", 'Activity_wrapper', count + '_activitywrapperId_' + aCount, '', '', '', '', '', '', '', '', '', '','','');
        activityInner.appendChild(activityWrap);
        var activityIForm = createInstanceElements("div", 'form-inner Border Form-padding Form-bg FormBorder-active', '', '', '', '', '', '', '', '', '', '', '','','');
        activityWrap.appendChild(activityIForm);
        activityMainWrap.appendChild(activityInner);

        //close Button
        var clsButtonDiv = createInstanceElements("div", 'close_button', 'actCloseButtonId_' + aCount, '', '', '', '', '', '', '', '', '', '','','');
        var clsButtonSpan = createInstanceElements("span", '', '', '', '', '', '', 'onclick', 'javascript:removeByInstanceId("' + count + '_activitywrapperId_' + aCount + '")', '', '', '', '','','');
        var clsButtonImg = createInstanceElements("img", '', '', '', '', '', '', '', '', '/SPProduct-portlet/images/Product_create/Close-icon.svg', '', '', '','','');
        clsButtonSpan.appendChild(clsButtonImg);
        clsButtonDiv.appendChild(clsButtonSpan);
        activityIForm.appendChild(clsButtonDiv); //added button to schedule instance

        //Activity fields wrap
        var actvFieldsWrap = createInstanceElements("div", 'form-summary-inner', '', '', '', '', '', '', '', '', '', '', '','','');

        //ck-editor
        var ckEditorDiv = createInstanceElements("div", 'Input_Fullwidth margin-20-topbottom', '', '', '', '', '', '', '', '', '', '', '','','');
        var actvEdtrName = "SchedulewrapperId_" + count + "_activitywrapperId_" + aCount + "_activity_desc_" + aCount;
        var edtrTxtArea = createInstanceElements("textarea", 'lfr-editor-textarea', '', actvEdtrName, '', '', '', '', '', '', '', '', '','','');
        edtrTxtArea.setAttribute("style", "height:159px");
        ckEditorDiv.appendChild(edtrTxtArea);
        actvFieldsWrap.appendChild(ckEditorDiv);//added ck editor

        //activity timing
        var actvTiming = createInstanceElements("div", 'Input_HalfWidth Margin-20', '', '', '', '', '', '', '', '', '', '', '','','');
        var gname = "SchedulewrapperId_" + count + "_activitywrapperId_" + aCount + "_activityTiming_" + aCount;
        var actvTimingIp = createInstanceElements("input", 'activityTiming scheduleFields', 'activityTimingId_' + aCount, gname, 'text', '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.activityTiming")%>', '', '', '', '', '', false, '','','');

        if (activityTiming != '') {
            actvTimingIp.setAttribute("value", activityTiming);
        }
        actvTiming.appendChild(actvTimingIp);
        actvFieldsWrap.appendChild(actvTiming);//added activity timing

        //activityPerformer
        var actvPerfm = createInstanceElements("div", 'Input_HalfWidth', '', '', '', '', '', '', '', '', '', '', '','','');
        var gname = "SchedulewrapperId_" + count + "_activitywrapperId_" + aCount + "_activityPerformer_" + aCount;
        var actvPerfmIp = createInstanceElements("input", 'activityPerformer scheduleFields', 'activityPerformerId_' + aCount, gname, 'text', '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.activityPerformer")%>', '', '', '', '', '', false, '','','');
        if (activityPerformer != '') {
            actvPerfmIp.setAttribute("value", activityPerformer);
        }
        actvPerfm.appendChild(actvPerfmIp);
        actvFieldsWrap.appendChild(actvPerfm);//added activityPerformer

        //activityDuration
        var actvDurnfm = createInstanceElements("div", 'Input_HalfWidth Margin-20', '', '', '', '', '', '', '', '', '', '', '','','');
        var gname = "SchedulewrapperId_" + count + "_activitywrapperId_" + aCount + "_activityDuration_" + aCount;
        var actvDurnfmIp = createInstanceElements("input", 'activityDuration scheduleFields', 'activityDurationId_' + aCount, gname, 'text', '<%=LabelUtil.getLabel(pageContext, themeDisplay,"label.product.update.moduels.activityDuration")%>', '', '', '', '', '', false, '','','');
        if (activityDuration != '') {
            actvDurnfmIp.setAttribute("value", activityDuration);
        }
        actvDurnfm.appendChild(actvDurnfmIp);
        actvFieldsWrap.appendChild(actvDurnfm);//added activityDuration
        activityIForm.appendChild(actvFieldsWrap);
        //activityAppendSection
        var actvApnd = createInstanceElements("div", '', 'activityAppendSectionId_' + aCount, '', '', '', '', '', '', '', '', '', '','','');
        activityIForm.appendChild(actvApnd);
        schWrap.appendChild(activityMainWrap);

        addCKEditor(actvEdtrName, false, ckEditorDiv, unicodeToChar(activityDescription));

        document.getElementById(count + "_gbActCountId").value = gbSchActCount + 1;
    }

    function getAutoCompleteValuesMod(elementId) {
        var selectList = document.getElementById(elementId);
        var selectedItems = [];
        var selectListValues = selectList.value;
        var selectListValue = selectListValues.split(",");
        for (var i = 0; i < selectListValue.length; i++) {
            if (selectListValue[i] > 0) selectedItems.push(selectListValue[i]);
        }
        console.log(selectedItems);

        return selectedItems;
    }

</script>
