package com.sambaash.gu.helper;

import java.util.HashMap;
import java.util.Map;

public class GUConstants {

    private GUConstants() {
        // cannot instantiate
    }
    
    public static final String SHEET_META_DATA = "metaData";

    public static final String CLMN_MODAL = "Modal";
    public static final String CLMN_ABOUT_MODAL = "About Modal";
    public static final String CLMN_DATA_SHEET_NAME = "Data Sheet Name";
    public static final String CLMN_DELETE_THEN_CREATE = "Delete-Then-Create";
    public static final String CLMN_FIELD_IN_DB = "Field In Db";
    public static final String CLMN_CLMN__NAME_IN_EXCEL = "Column Name In Excel";
    public static final String CLMN_CLMN__DEFAULT_VALUE = "Default Value";
    public static final String CLMN_KEY_CLMN = "Key Column";
    public static final String CLMN_LINKED_MODAL = "Linked Modal";
    public static final String CLMN_LINKED_MODAL_PROPERTY = "Linked Modal Property";
    public static final String CLMN_MULTI_INSTANCE = "Multi-Instance";
    public static final String CLMN_DELETE_THEN_CREATE_MULTI_INSTANCE = "Delete-Then-Create-Multi-Instance-Records";
    public static final String CLMN_VOCABULARY_NAME = "Vocabulary Name";
    public static final String CLMN_CREATE_CATEGORY = "Create Category";
    public static final String CLMN_DOCUMENT_TYPE = "Document Type";
    public static final String CLMN_SOURCE_PATH = "Source Path";
    public static final String CLMN_DESTINATION_PATH = "Destination Path";
    public static final String CLMN_FOLDER_MATCHING_PATH = "Folder Matching Path";
    public static final String CLMN_FORM_NODE_ID = "Form Node Id";
    public static final String CLMN_ARRAY_FIELD_NAME = "Array Field Name";

    public static final String[] ALL_META_DATA_CLMNS = {CLMN_MODAL,
        CLMN_ABOUT_MODAL,
        CLMN_DATA_SHEET_NAME,
        CLMN_DELETE_THEN_CREATE,
        CLMN_FIELD_IN_DB,
        CLMN_CLMN__NAME_IN_EXCEL,
        CLMN_KEY_CLMN,
        CLMN_LINKED_MODAL,
        CLMN_LINKED_MODAL_PROPERTY,
        CLMN_MULTI_INSTANCE,
        CLMN_DELETE_THEN_CREATE_MULTI_INSTANCE,
        CLMN_VOCABULARY_NAME,
        CLMN_CREATE_CATEGORY,
        CLMN_DOCUMENT_TYPE,
        CLMN_SOURCE_PATH,
        CLMN_DESTINATION_PATH,
        CLMN_FOLDER_MATCHING_PATH,
        CLMN_CLMN__DEFAULT_VALUE};

    public static final String STATUS_YET_TO_START = "Yet to Start";
    public static final String STATUS_STARTED = "Started";
    public static final String STATUS_VALIDATING = "Validating MetaData";
    public static final String STATUS_STOPED_META_DATA_ERROR = "Stopped - Error in MetaData";
    public static final String STATUS_IN_PROGRESS = "Uploading";
    public static final String STATUS_COMPLETED = "Completed";
    public static final String STATUS_COMPLETED_WITH_ERRORS = "Completed with some errors";
    public static final String STATUS_STOPED_ERROR_IN_PROCESSING = "Stopped - Error while processing";

    public static final String DOCUMENT_TYPE_FILE = "file";
    public static final String DOCUMENT_TYPE_Folder = "folder";
    // To avoid any naming conflict with field names in db, below name has given such that. It can be any name which must not match 
    public static final String DERIVED_PREFIX = "DDDRRRIIIVVVEEED_";
    public static final String ASSET_CATEGORY_PREFIX = "ASSET_CATEGORIES";

    public static final String MODAL_NAME_SEPARATOR = ":";
    public static final String CELL_VALUE_SEPARATOR = "|";
    //Actual separator is only pipe symbol. Back slashes added for escaping
    public static final String CELL_VALUE_SEPARATOR_ESCAPED = "\\|";

    public static final String DATE_FORMAT = "dd-MMM-yyyy";

    public static final Map<String, String[]> MODAL_METADATA_COLUMNS;

    static {
        MODAL_METADATA_COLUMNS = new HashMap<>();
        MODAL_METADATA_COLUMNS.put("ProcessV2", new String[]{
            CLMN_MODAL,
            CLMN_ABOUT_MODAL,
            CLMN_DATA_SHEET_NAME,
            CLMN_FIELD_IN_DB,
            CLMN_CLMN__NAME_IN_EXCEL,
            CLMN_KEY_CLMN,
            CLMN_LINKED_MODAL,
            CLMN_LINKED_MODAL_PROPERTY,
            CLMN_DOCUMENT_TYPE,
            CLMN_SOURCE_PATH,
            CLMN_DESTINATION_PATH,
            CLMN_FOLDER_MATCHING_PATH,
            CLMN_FORM_NODE_ID,
            CLMN_ARRAY_FIELD_NAME,
            CLMN_CLMN__DEFAULT_VALUE
        });
    }

}
