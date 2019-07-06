package com.example.mvvmapplication.data.constant


object APIConstants {


    const val URL_DISTANCEMATRIX = "api/directions/json"
    const val KEY_DESTINATION = "destination"
    const val KEY_ORIGINS = "origin"
    const val KEY_API = "key"

    // http://192.168.0.100:82/TradePartner/API/GPSTrackingAPI
    // DEV Pointing
     const val BASE_URL = "http://hjwserver.itgurussoftware.com:82/TradePartner/API/"
     const val  RELATIVE_URL = "GPSTrackingAPI"
     const val AbsolutePath_URL = "http://hjwserver.itgurussoftware.com:82/TradePartner/API/GPSTrackingAPI"

    // DEV Pointing
    /*const val BASE_URL = "http://192.168.0.100:82/TradePartner/API/"
    const val  RELATIVE_URL = "GPSTrackingAPI"
    const val AbsolutePath_URL = "http://192.168.0.100:82/TradePartner/API/GPSTrackingAPI"*/


    // DEV Pointing Phase 2  http://192.168.0.100:82/TradePartnerP2/API/GPSTrackingAPI
    /*const val BASE_URL = "http://hjwserver.itgurussoftware.com:82/TradePartnerP2/API/"
    const val  RELATIVE_URL = "GPSTrackingAPI"
    const val AbsolutePath_URL = "http://hjwserver.itgurussoftware.com:82/TradePartnerP2/API/GPSTrackingAPI"*/

    // http://192.168.0.100:83/TradePartner/API/GPSTrackingAPI
    // QA Pointing
   /* const val BASE_URL = "http://hjwserver.itgurussoftware.com:83/TradePartner/API/"
    const val RELATIVE_URL = "GPSTrackingAPI"
    const val AbsolutePath_URL = "http://hjwserver.itgurussoftware.com:83/TradePartner/API/GPSTrackingAPI"*/


    // QA Pointing Phase 2  http://192.168.0.100:82/TradePartnerP2/API/GPSTrackingAPI
    /*const val BASE_URL = "http://hjwserver.itgurussoftware.com:83/TradePartnerP2/API/"
    const val RELATIVE_URL = "GPSTrackingAPI"
    const val AbsolutePath_URL = "http://hjwserver.itgurussoftware.com:83/TradePartnerP2/API/GPSTrackingAPI"*/


    //Mumbai Server Supertron == http://mumserver.itgurussoftware.com:6095/API/GPSTrackingAPI
    /*const val BASE_URL = "http://mumserver.itgurussoftware.com:6095/API/"
    const val RELATIVE_URL = "GPSTrackingAPI"
    const val AbsolutePath_URL = "http://mumserver.itgurussoftware.com:6095/API/GPSTrackingAPI"*/


    //Mumbai Server 98 == http://mumserver.itgurussoftware.com:6095/API/GPSTrackingAPI
    /*const val BASE_URL = "http://mumserver.itgurussoftware.com:6098/API/"
    const val RELATIVE_URL = "GPSTrackingAPI"
    const val AbsolutePath_URL = "http://mumserver.itgurussoftware.com:6098/API/GPSTrackingAPI"*/


   //Mumbai Server Saboo == http://mumserver.itgurussoftware.com:6096/API/GPSTrackingAPI
    /*const val BASE_URL = "http://mumserver.itgurussoftware.com:6096/API/"
    const val RELATIVE_URL = "GPSTrackingAPI"
    const val AbsolutePath_URL = "http://mumserver.itgurussoftware.com:6096/API/GPSTrackingAPI"*/

    //Mumbai Server MIPL == http://mumserver.itgurussoftware.com:6097/API/GPSTrackingAPI
    /*const val BASE_URL = "http://mumserver.itgurussoftware.com:6097/API/"
    const val RELATIVE_URL = "GPSTrackingAPI"
    const val AbsolutePath_URL = "http://mumserver.itgurussoftware.com:6097/API/GPSTrackingAPI"*/


    //New UAT server
    //Server == http://mumserver.itgurussoftware.com:6096/API/GPSTrackingAPI
    /*const val BASE_URL = "http://mumserver.itgurussoftware.com:6096/API/"
    const val RELATIVE_URL = "GPSTrackingAPI"
    const val AbsolutePath_URL = "http://mumserver.itgurussoftware.com:6096/API/GPSTrackingAPI"*/


    const val CHANGE_PASSWORD = "change_password"
    const val SET_FORGOT_PASSWORD = "set_forgot_password"
    const val GET_CUSTOMERDETAILS_ID = "getcustomerdetailsbyid"
    const val GET_EMPLOYEELISTBY_ID = "getemployeedetailsbyid"
    const val GET_PJPTPDETAILS_ID = "api_get_pjp_tp_details"

    const val AUTHENTICATE_LOGIN = "authenticate_login"
    const val FORGOT_PASSWORD = "forgot_password"
    const val VERIFY_OTP = "verify_otp"
    const val ADD_PJPTP = "add_edit_pjp_tp"

    const val GET_BRAND_LIST = "get_brand_data"
    const val GET_CUSTOMER_DDL = "api_get_customer_ddl"
    const val GET_CUSTOMER_DETAILS = "api_get_customer_details"
    const val ADD_CUSTOMER = "addcustomer"
    const val UPDATE_CUSTOMER = "updatecustomer"
    const val APPROVE_PJP_TP = "mgr_approve_pjp_tp"
    const val GET_EMPLOYEE_LIST_FOR_REPORT = "getemployeelistbyid"
    const val GET_COUNTRY_LIST = "get_country_list"
    const val GET_STATE_LIST = "getstatelist"
    const val GET_CITY_BY_PINCODE = "getcitylistbypincode"
    const val INSERT_ROUTING_DATA = "saveroutetracking"
    const val GET_MAP_PLOT_DETAILS = "api_route_tracking_list"
    const val CMD_UPDATE_PROFILE_PICTURE = "update_profile_picture"
    const val CMD_UPLOAD_FILE = "api_upload_employee_pjp_tp"
    const val CMD_DOWNLOAD_FILE = "download_asm_report_numeric"
    const val CMD_DOWNLOAD_FILE_EMPMNGRTP_PJP_MGR = "api_get_manager_pjp_tp_files"
    const val CMD_DOWNLOAD_FILE_EMPMNGRTP_PJP_EMP = "api_get_employee_pjp_tp_template"

    const val GET_PINCODE_LIST = "get_pincode_list"

    const val GET_SCHEME_LIST = "get_all_scheme"
    const val GET_GROUP_LIST = "get_group_data"
    const val GET_SCHEME_BRAND_LIST = "get_scheme_brand_list"
    const val GET_SCHEME_PRODUCT_LIST = "get_scheme_product_list"

    const val GET_NUMERIC_ASM_REPORT_LIST = "api_customerbase_asm_report"
    const val GET_GRAPHICAL_ASM_REPORT_LIST = "api_customer_base_asm_graphical_report"


    const val GET_VISIT_PURPOSE = "get_visit_purpose_list"
    const val GET_CUSTOMER_DETAILS_GEO = "get_ploting_customer_list"

    const val GET_PJP_TP_INH_ITEM_LIST = "get_pjp_tp_inhouse_item_list"
    const val GET_ALL_ITEM_LIST = "get_pjp_tp_items_all"
    const val GET_CUSTOMER_TIER3_DETAILS_LIST = "get_customer_tier3_detail_list"
    const val GET_SCHEME_ITEM_LIST = "get_scheme_item_list"
    const val GET_PJP_CUSTOMER_LIST = "get_pjp_customer_list"
    const val CMD_DELETE_SNAPS = "api_delete_snaps"
    const val CMD_GET_SNAPS = "api_get_snaps_list"
    const val CMD_UPLOAD_SNAPS = "api_upload_snaps"

    const val DELETE_PJP_TP_DETAILS = "delete_pjp_tp_details"
}