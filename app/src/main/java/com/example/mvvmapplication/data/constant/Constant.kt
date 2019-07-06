package com.example.mvvmapplication.data.constant


import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Typeface
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.VectorDrawable
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build

import android.text.InputFilter
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils
import android.text.format.DateUtils
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputLayout
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ofPattern
import java.util.*
import kotlin.collections.ArrayList


class Constant {

    /*
    * 1.Start Marker (Orange Color)  -- 3
2.Stop Marker (Yellow Color) -- 4
3.Halt Marker (Grey Color) --5
4. Trail (Blue Color) -- 0
5. Visited Marker (Green Color) -- 1
6. Unvisited Marker (Red Color) -- 2
*/

    companion object {

        const val PASSWORD_PATTERN =
            "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+=\\[{\\]};:<>|./?,-])[A-Za-z\\d!@#$%^&*()_+=\\[{\\]};:<>|./?,-]{8,}$"
        const val ALPHA_NUMERIC_PATTERN = "^[a-zA-Z0-9]*$"

        const val showLog = true      //For DEV
//        const val showLog = false       //For Live,QA,UAT

        const val isWriteFile = true    //For DEV
//        const val isWriteFile=false     //For Live,QA,UAT

        const val showLogStatus=true     //For DEV
//        const val showLogStatus=false     //For Live,QA,UAT


        const val INTENT_DATA = "data"
        const val INTENT_DATA_TYPE_OF_JOURN_MODE = "journey_mode"
        const val INTENT_DATA_EMAIL = "email"

        const val TRAIL_MARKER = "0"
        const val VISITED_MARKER = "1"
        const val UNVISITED_MARKER = "2"
        const val START_MARKER = "3"
        const val STOP_MARKER = "4"
        const val HALT_MARKER = "5"

        const val NEWPASSWORD = 2
        const val CONFIRMNEWPASSWORD = 1
        const val ROLE_ADMIN = 1
        const val ROLE_MANAGER = 2
        const val ROLE_SALES_EXECUTIVE = 3
        const val ROLE_FIELD_OFFICER = 5
        const val INTENT_CUSTOMER_DETAILS = "customer_details"

        const val DEFAULT_GUUID_EMP = "00000000-0000-0000-0000-000000000000"
        val TP_TEXT = "Tour Plan"
        val PJP_TEXT = "Projected Journey Plan"
        val IN_HOUSE_TEXT = "In House"
        val TP_CODE = "2"
        val PJP_CODE = "1"
        val INHOUSE_CODE = "3"

        val TIER_3=3
        val TIER_2=2

        val TENURE_TYPE_MONTH = "1"
        val TENURE_TYPE_WEEK = "2"
        val TENURE_TYPE_QUARTER = "3"

        // Keys required for Add/Edit Customer
        val KEY_CUSTOMER_CODE = "CustomerCode"
        val KEY_CUSTOMER_ID = "CustomerId"
        val KEY_CUSTOMER_NAME = "Name"
        val KEY_CONTACT_PERSON = "ContactPerson"
        val KEY_CONTACT_NUMBER = "ContactNo"
        val KEY_MOBILE_NUMBER = "MobileNumber"
        val KEY_EMAIL = "Email"
        val KEY_ADDRESS_1 = "Address1"
        val KEY_ADDRESS_2 = "Address2"
        val KEY_ADDRESS_3 = "Address3"
        val KEY_COUNTRY_ID = "CountryId"
        val KEY_COUNTRY = "Country"
        val KEY_STATE_ID = "StateId"
        val KEY_STATE = "State"
        val KEY_CITY_ID = "CityId"
        val KEY_CITY = "City"
        val KEY_PINCODE_ID = "PinCodeId"
        val KEY_PINCODE = "PinCode"
        val KEY_LOCATION = "Location"
        val KEY_ANNUAL_TURN_OVER = "AnnualTurnover"
        val KEY_DEALING_BRAND_ID = "DealingBrandId"
        val KEY_AREA_OF_OPERATION = "AreaOfOperation"
        val KEY_ASSIGNED_TO = "AssignedTo"
        val KEY_MONTHLY_BILLING = "MonthlyBilling"
        val KEY_BILLING_DATE = "BillingDate"
        val KEY_IS_DOC_RECEIVED = "IsDocReceived"
        val KEY_IS_DOC_VERIFIED = "IsDocVerfied"
        val KEY_IS_CUSTOMER_CODE_EXIST = "IsCustomerCodeExist"
        val KEY_BRAND_LIST_FROM_SERVER = "brandList"
        val KEY_BRAND_LIST_USER_SELECTED = "brandLista"
        val KEY_BRAND_LIST_USER_ENTERED = "brandListb"

        // Keys required for Scheme Filter
        val KEY_FROM_DATE = "FromDate"
        val KEY_TO_DATE = "ToDate"
        val KEY_GROUP_ID = "GroupId"
        val KEY_BRAND_ID = "BrandId"
        val KEY_PRODUCT_ID = "ProductId"
        val KEY_ITEM_ID = "ItemId"
        val KEY_PRODUCT_NAME = "ProductName"
        val KEY_PRODUCT_PRICE = "ProductPrice"
        val KEY_SAVING_PRICE = "SavingPrice"

        // Keys required for Report Filter
        val KEY_YEAR = "Year"
        val KEY_VISIT_TYPE = "VisitType"
        val KEY_EMPLOYEE_ID = "EmployeeId"

        val PJP_TP_ADD = "add"
        val PJP_TP_VISIT = "visit"
        val PJP_TP_EDIT = "edit"

        val TO_TIME = "to_time"
        val FROM_TIME = "from_time"

        const val ADD_CUSTOMER = 1
        const val EDIT_CUSTOMER = 2

        const val TXT_VISITED_CUSTOMER = "Visited"
        const val TXT_UNVISITED_CUSTOMER = "UnVisited"

        const val COUNTRY_NAME = "India"
        const val COUNTRY_ID = "61f7b0a3-21e3-4c4e-91af-aed97255e111"

        const val TENURE_TYPE = "TenureType"
        const val TOTAL_VISIT = "TotalVisit"

        var IS_EDIT_CUSTOMER = false

        /**
         * The desired interval for location updates. Inexact. Updates may be more or less frequent.
         */
        val UPDATE_INTERVAL = (10 * 1000).toLong()

        /**
         * The fastest rate for active location updates. Updates will never be more frequent
         * than this value, but they may be less frequent.
         */
        val FASTEST_UPDATE_INTERVAL = UPDATE_INTERVAL / 2

        /**
         * The max time before batched results are delivered by location services. Results may be
         * delivered sooner than this interval.
         */
        val MAX_WAIT_TIME = UPDATE_INTERVAL * 3
        val SERVER_STATUS_PENDING = 0
        val SERVER_STATUS_SENT = 1
        val CHECKED_IN = "checkin"
        val CHECKED_OUT = "checkout"
        val PRIORITY_HIGH = 1
        val PRIORITY_LOW = 10
        val LIST_PERMISSION = "permision_list"
        val WritePermissionInDBIntentService = 100
        val WritePermissionInDBIntentServic2 = 101
        val SendAllLocationFromTableJobIntentService = 102
        val SendAllLocationFromTableJobIntentService2 = 103
        val SendAllCheckInOutStatusJobInntentService = 104
        val SendAllCheckInOutStatusJobInntentService2 = 105
        val SendAllCheckInOutDetailsJIntentService = 106
        val SendAllCheckInOutDetailsJIntentService2 = 107
        val GeofenceTransitionJobIntentS = 108
        val GeofenceTransitionJobIntentS2 = 109
        val GetAllCustomerDetailsJobIntentService=110
        val GetAllCustomerDetailsJobIntentService2=111
        val GetAllVisitPurposeJobIntentService=112
        val GetAllVisitPurposeJobIntentService2=113


        val JOBID_CONNECTIVITY = 145
        val JOBID_GEOLOCATION_SERVICE = 144

        val MENU_EMPLIST = ""
        val MENU_CUSOTMERLIST = "Customer List"
        val MENU_UPLOAD_TP = "Upload TP"
        val ZERO = "0"
        val CHECKED_IN_CODE = "1"
        val CHECKED_OUT_CODE = "0"


        val ACTION_UPLOAD = 1
        val ACTION_FILTER = 2
        val ACTION_DOWNLOAD = 3
        val ACTION_TOP = 4
        val ACTION_BOTTOM = 5

        val REQUEST_CODE_FILE_UPLOAD = 501
        val REQUEST_CODE_AUTOSTART=200
        val REQUEST_CHECK_SETTINGS = 40

        val UNVISITED_CUSTOMER = 0
        val VISITED_CUSTOMER = 1
        val VISITED_CUSTOMER_TXT = "Visited"
        val UNVISITED_CUSTOMER_TXT = "Unvisited"
        val INTENT_DATE = "date"
        val INTENT_IS_DATA_EDITABLE = "isediatable"
        val INTENT_IS_DATA_VISITED = "isvisited"
        val INTENT_DATA_EMPLOYEE = "dataemplyee"
        val INTENT_IS_DATA_FROM = "from"
        val INTENT_FROM_ADD = "add"
        val INTENT_FROM_EDIT = "edit"
        val INTENT_FROM_EDIT_VISIT = "edit_visit"
        val FROM_SCHDL_TIME = "scheduleIn"
        val downloadDirectory = "scheduleIn"
        val INVALID_TOKEN = 9
        val ERROR_CODE_FILE_ALREADY_EXIST = 27
        val ERROR_CODE_FILE_NOT_FOUND = 28
        val ERROR_CODE_FAILED_UPLOAD = 29

        val UNKNOWN_ERR_OCC = 4
        val INTENT_DATA_DATE = "date"
        val ERROR_CODE_PINCODE = 2

        val UPLOAD_FILE_IS_REPLACE_FILE_DEFAULT = "false"

        val DATE_FORMAT = "dd-MMM-yyyy"
        val PLOTTED = "1"
        val UNPLOTTED = "0"

        val TIME_DIFFERENCE = 1000 * 60 * 15L

        val GEOFENCE_CHECKIN_RECEIVED = "geofence_check_in"
        val GEOFENCE_CHECKOUT_RECEIVED = "geofence_check_out"
        val GEO_FENCE_CIRCLE_AREA = 80f
        val START_FOREGROUND = "start_foreground"
        val STOP_FOREGROUND = "stop_foreground"
        val ACTION_ADD_JP="add_jp"
        val REMOVE=3
        val OK=4
        val UNAUTHORIZED_ACCESS=5
        val EDIT=4
        val CHECKED_IN_CLICKED="checkinclicked"
        val ERROR_CODE_LOCATION_UNFOUND=71

        val EMOJI_FILTER = object :InputFilter{
            override fun filter(source: CharSequence, start: Int, end: Int, dest: Spanned?, dstart: Int, dend: Int): CharSequence? {
                var keepOriginal = true
                val sb = StringBuilder(end - start)

                for (index in start until end) {
                    val type = Character.getType(source.get(index))
                    if (type == Character.SURROGATE.toInt() || type == Character.OTHER_SYMBOL.toInt()) {
                        return ""
                    }
                    val c = source.get(index)
                    if (isCharAllowed(c))
                        sb.append(c)
                    else
                        keepOriginal = false
                }
                if (keepOriginal)
                    return null
                else {
                    if (source is Spanned) {
                        val sp = SpannableString(sb)
                        TextUtils.copySpansFrom(source, start, sb.length, null, sp, 0)
                        return sp
                    } else {
                        return sb
                    }
                }
            }
        }
        val INTENT_ISPREVIOUS_DATE="isPricousdate"


        private fun isCharAllowed(c: Char): Boolean {
            return Character.isLetterOrDigit(c) || Character.isSpaceChar(c)
        }


        fun setFont(group: ViewGroup, lTypeface: Typeface) {
            // TODO function to set font for entire layout
            val count = group.childCount
            var v: View
            for (i in 0 until count) {
                v = group.getChildAt(i)
                if (v is TextView) {
                    v.typeface = lTypeface
                } else if (v is EditText) {
                    v.typeface = lTypeface
                } else if (v is Button) {
                    v.typeface = lTypeface
                } else if (v is TextInputLayout) {
                    v.typeface = lTypeface
                }
                if (v is ViewGroup)
                    setFont(v, lTypeface)
            }
        }

        fun setupUI(lActivity: Activity, view: View, lEditText: EditText, lMagGlass: ImageView?) {
            // Set up touch listener for non-text box views to hide keyboard.
            if (view !is EditText) {
                /*view.setOnTouchListener { arg0, arg1 ->
                    onHideKeyBoard(lActivity, lEditText, lMagGlass)
                    false
                }*/

                view.setOnClickListener {
                    onHideKeyBoard(lActivity, lEditText, lMagGlass)

                }
            }

            // If a layout container, iterate over children and seed recursion.
            if (view is ViewGroup) {
                for (i in 0 until view.childCount) {
                    val innerView = view.getChildAt(i)
                    setupUI(lActivity, innerView, lEditText, lMagGlass)
                }
            }
        }

        fun onHideKeyBoard(mActivity: Activity, lEditText: EditText, lMagGlass: ImageView?) {
            val imm = mActivity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(lEditText.windowToken, 0)

            lEditText.clearFocus()
            if (lMagGlass != null) {
                if (TextUtils.isEmpty(lEditText.text.toString())) {
                    lMagGlass.visibility = View.VISIBLE
                } else {
                    lMagGlass.visibility = View.GONE
                }
            }
        }

        fun showToast(context: Context, message: String) {
            try {
                Toast.makeText(context!!, message, Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun showToast(context: Context, stringResID: Int) {
            try {
                Toast.makeText(context!!, stringResID, Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun showToastLong(context: Context, stringResID: Int) {
            try {
                Toast.makeText(context!!, stringResID,Toast.LENGTH_LONG ).show()

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }



        fun showLog(tag: String, message: String, typeOfLog: Int) {
            if (showLogStatus)
                when (typeOfLog) {
                    Log.DEBUG -> {
                        Log.d(tag, message)
                    }
                    Log.ERROR -> {
                        Log.e(tag, message)
                    }
                    Log.WARN -> {
                        Log.w(tag, message)
                    }
                    Log.VERBOSE -> {
                        Log.v(tag, message)
                    }
                    Log.INFO -> {
                        Log.i(tag, message)
                    }
                }
        }


        fun hideSoftKeyboard(context: Context, searchView: SearchView) {
            try {
                val inputMethodManager = context
                    .getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(searchView.windowToken, 0)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

        fun hideSoftKeyboard(context: Context, view: View) {
            try {
                val inputMethodManager = context
                    .getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }


        fun showSoftKeyboard(context: Context) {
            try {
                val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        fun showSoftKeyboard(context: Context,editext:EditText) {
            try {
                val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(editext, 0)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

        fun getVersionName(context: Context): String {
            var appVersion = ""
            try {
                appVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }
            return appVersion
        }


        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun getBitmap(context: Context, drawableId: Int): Bitmap {
            val drawable = ContextCompat.getDrawable(context, drawableId)
            return if (drawable is BitmapDrawable) {
                drawable.bitmap
            } else if (drawable is VectorDrawable) {
                getBitmap((drawable as VectorDrawable?)!!)
            } else {
                throw IllegalArgumentException("unsupported drawable type") as Throwable
            }
        }

        fun getBitmap(vectorDrawable: VectorDrawable): Bitmap {
            val bitmap = Bitmap.createBitmap(
                vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888
            );

            val canvas = Canvas(bitmap)
            vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            vectorDrawable.draw(canvas);
            return bitmap;
        }

        fun showLog(tag: String, message: String, errorThrow: Throwable, typeOfLog: Int) {
            if (showLog)
                when (typeOfLog) {
                    Log.DEBUG -> {
                        Log.d(tag, message, errorThrow)
                    }
                    Log.ERROR -> {
                        Log.e(tag, message, errorThrow)
                    }
                    Log.WARN -> {
                        Log.w(tag, message, errorThrow)
                    }
                    Log.VERBOSE -> {
                        Log.v(tag, message, errorThrow)
                    }
                }
        }

        @JvmStatic
        fun showLogI(tag: String, message: String, typeOfLog: Int) {
            if (showLog)
                when (typeOfLog) {
                    Log.DEBUG -> {
                        Log.d(tag, message)
                    }
                    Log.ERROR -> {
                        Log.e(tag, message)
                    }
                    Log.WARN -> {
                        Log.w(tag, message)
                    }
                    Log.VERBOSE -> {
                        Log.v(tag, message)
                    }
                }
        }

        @JvmStatic
        fun displayLog(tag: String, message: String) {
            if (showLog)
                Log.e(tag, message)
        }

        @JvmStatic
        fun displayLog(tag: String, message: String, errorThrow: Throwable) {
            if (showLog)
                Log.e(tag, message,errorThrow)
        }

        /**
         * Function to write data in given File
         * @param fileName
         * @param data
         */
        @Synchronized
        fun writeFile(fileName: String, data: String) {

            /***
             * Comment below code for UAT AND Live Build
             *
             */
            val f1 = FileOperations.getInstance()
            f1.write(fileName, data)

        }

        @JvmStatic
        fun writeFileS(fileName: String, data: String) {
            val f1 = FileOperations.getInstance()
            f1.write(fileName, data)
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun getCurrentTimeDetails(requireFormat: String): String? {
            val current = LocalDateTime.now()
            val formatter = ofPattern(requireFormat)
            val formatted = current.format(formatter)
            return formatted
        }

        fun getCurrentTimeDetailsOther(requireFormat: String): String? {
            val df = SimpleDateFormat(requireFormat, Locale.US);
            val calobj = Calendar.getInstance()
            return df.format(calobj.getTime())
        }

        fun changeDateFormat(inputDateString: String, inputFormat: String, outputFormat: String): String {
            val dateFormat = SimpleDateFormat(inputFormat, Locale.US)
            var myDate: Date? = null
            try {
                myDate = dateFormat.parse(inputDateString)
            } catch (e: ParseException) {
                e.printStackTrace()
                return ""
            }

            val timeFormat = SimpleDateFormat(outputFormat, Locale.US)
            if (myDate == null)
                return ""
            return timeFormat.format(myDate)
        }

        fun getDateFromString(inputDateString: String, inputFormat: String): Date? {
            val date: Date
            val format = SimpleDateFormat(inputFormat, Locale.US)
            try {
                date = format.parse(inputDateString)
                return date
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return null
        }

        fun getStringFromDate(inputDate: Date, outputFormat: String): String? {
            val dateFormat = SimpleDateFormat(outputFormat, Locale.US)
            try {
                val dateTime = dateFormat.format(inputDate)
                return dateTime
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return null
        }

        fun checkDateIsPreviousOrNot(inputDate: String): Boolean {
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)
            val strDate = sdf.parse(inputDate)

            var currentDate = sdf.format(Date())

            var givenDate = sdf.format(strDate)
            if (currentDate == givenDate) {
                return false
            } else {
                if (Date().after(strDate)) {
                    return true
                }
            }


            return false
        }

        fun checkDateIsPreviousOrNot(inputDate: String, inputFormat: String): Boolean {
            val sdf = SimpleDateFormat(inputFormat, Locale.US)
            val strDate = sdf.parse(inputDate)

            var currentDate = sdf.format(Date())

            var givenDate = sdf.format(strDate)
            if (currentDate == givenDate) {
                return false
            } else {
                if (Date().after(strDate)) {
                    return true
                }
            }


            return false
        }


        /*fun distFrom(lat2: Double, lng2: Double): Float {
            val earthRadius = 6371000.0 //meters
            val dLat =
                Math.toRadians(lat2 - SessionManager.getLastLocationLat()!!)
            val dLng =
                Math.toRadians(lng2 - SessionManager.getLastLocationLong()!!)
            val a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(
                Math.toRadians(
                    SessionManager.getLastLocationLat()!!
                )
            ) * Math.cos(Math.toRadians(lat2)) *
                    Math.sin(dLng / 2) * Math.sin(dLng / 2)
            val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))

            return (earthRadius * c).toFloat()
        }*/


        fun getDateFromMills(mills: Long): String {
            //Dec 17 2018 2:55PM
            try {
//                val formatter = SimpleDateFormat("MMM dd yyyy hh:mm a", Locale.US)
                val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)
                val calendar = Calendar.getInstance()
                calendar.timeInMillis = mills
                return formatter.format(calendar.getTime())
            } catch (exc: Exception) {
                showLog("EXCEP", "Detaisl", exc.fillInStackTrace(), Log.DEBUG)
            }
            return ""
        }

        /*@JvmStatic
        fun isOnline(): Boolean {
            val mContext = App.getApplicationContextImpl()

            val mConnectivityManager = mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val networkInfo: NetworkInfo = mConnectivityManager.activeNetworkInfo

            return networkInfo.isConnectedOrConnecting
        }*/

        fun compareDateAndTime(from_date: String, to_date: String): Int {
            var dateDif = 1

            try {
                val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.US)

                val date1 = formatter.parse(from_date)
                val date2 = formatter.parse(to_date)

                if (date2 == date1) {
                    dateDif = 0
                } else if (date1.after(date2)) {
                    //date 1 is grater than date2
                    dateDif = 1
                } else {
                    dateDif = 2
                }

                //            Log.e("Fielda validation", "dateDif 1 = " + dateDif);

            } catch (exc: ParseException) {
                // e1.printStackTrace();
                showLog("EXCEPTION", "Details : ", exc.fillInStackTrace(), Log.DEBUG)
            }

            return dateDif
        }

        fun compareDateAndTime(from_date: String, to_date: String, inputFormat: String): Int {
            var dateDif = 1

            try {
                val formatter = SimpleDateFormat(inputFormat, Locale.US)

                val date1 = formatter.parse(from_date)
                val date2 = formatter.parse(to_date)

                if (date2 == date1) {
                    dateDif = 0
                } else if (date1.after(date2)) {
                    //date 1 is grater than date2
                    dateDif = 1
                } else {
                    dateDif = 2
                }

                //            Log.e("Fielda validation", "dateDif 1 = " + dateDif);

            } catch (exc: ParseException) {
                // e1.printStackTrace();
                showLog("EXCEPTION", "Details : ", exc.fillInStackTrace(), Log.DEBUG)
            }

            return dateDif
        }

        fun compareDateAndTimeFor30Days(currentDate: String, dateWith30Added: String,testDate:String, inputFormat: String): Boolean {

            val formatter = SimpleDateFormat(inputFormat, Locale.US)

            val currentDateOb = formatter.parse(currentDate)
            val dateWith30Addedob = formatter.parse(dateWith30Added)
            val testDateob = formatter.parse(testDate)

            val difference = currentDateOb.getTime() - testDateob.getTime()
            val daysBetween = Math.abs(difference / (1000*60*60*24))
            Constant.showLog("DATEDIFF","dates "+daysBetween,Log.DEBUG)
            return daysBetween<=30L
//            return testDateob.after(currentDateOb) && testDateob.before(dateWith30Addedob)
        }

        fun convertMilliSecToDateTimeFormat(timeInMilli: Long): String {
            // Create a DateFormatter object for displaying date in specified format.
            //        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm a", Locale.US);
            val formatter = SimpleDateFormat("hh:mm a", Locale.US)

            // Create a calendar object that will convert the date and time value in milliseconds to date.
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = timeInMilli
            return formatter.format(calendar.time)
        }

        fun getDateRange(): ArrayList<Date> {
            var begining: Date? = null
            var end: Date? = null
            var calendar: Calendar

            calendar = getCalendarForNow()
            calendar.set(
                Calendar.DAY_OF_MONTH,
                calendar.getActualMinimum(Calendar.DAY_OF_MONTH)
            )
            setTimeToBeginningOfDay(calendar);
            begining = calendar.getTime();



            calendar = getCalendarForNow()
            calendar.set(
                Calendar.DAY_OF_MONTH,
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
            )

            setTimeToEndofDay(calendar)
            end = calendar.getTime()

            val dateList = ArrayList<Date>()
            dateList.add(begining)
            dateList.add(end)
            return dateList
        }


        fun getCalendarForNow(): Calendar {
            val calendar = Calendar.getInstance()
            calendar.time = Date()
            return calendar
        }

        fun setTimeToBeginningOfDay(calendar: Calendar) {
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
        }


        fun setTimeToEndofDay(calendar: Calendar) {
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MILLISECOND, 999);
        }


        fun isTodayDate(dateFromSelcted: String, inputString: String): Boolean {
            return DateUtils.isToday(getDateFromString(dateFromSelcted, inputString)!!.time)
        }


        fun getTime(): Long {
            val calendar = Calendar.getInstance()
            calendar.timeZone = TimeZone.getTimeZone("UTC")
            calendar.time = Date()
            println(calendar.time)
            return calendar.time.time
        }

        fun compareTimeDiff(startTime: Long, lastTime: Long): Long {
            return lastTime - startTime
        }

        fun hideSoftKeyboard(context: Activity) {
            val inputMethodManager = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as
                    InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(context.getCurrentFocus()?.getWindowToken(), 0)
        }

        fun getRandomGUID():String{
            val  uniqueID = UUID.randomUUID().toString();
            return uniqueID
        }




    }


}