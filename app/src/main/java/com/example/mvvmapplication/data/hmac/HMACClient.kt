package com.example.mvvmapplication.data.hmac

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Base64
import android.util.Log
import android.widget.Toast
import com.example.mvvmapplication.data.constant.APIConstants
import com.example.mvvmapplication.data.constant.Constant
import okhttp3.ResponseBody

import retrofit2.Response
import java.io.UnsupportedEncodingException
import java.net.MalformedURLException
import java.net.URL
import java.security.GeneralSecurityException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.text.SimpleDateFormat
import java.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec


object HMACClient {

    private val HMAC_SHA1_ALGORITHM = "HmacSHA1"
    //   private final static String DATE_FORMAT = "EEE, d MMM yyyy HH:mm:ss z";
    private val DATE_FORMAT = "yyyyMMdd HH:mm:ss"
    //  private final static String SECRET = "80her845j93455()*)JEDf45KER#54-sdfsr0-ji"; //"secretsecret";
    private val SECRET = "23naslf2034h(*2jasldjq9423812ehnOQIUEDW04" //"secretsecret";
    private val PROTOCOL_CONTENT_TYPE = "application/x-www-form-urlencoded"
    /**
     * Charset for request.
     */
    private val PROTOCOL_CHARSET = "utf-8"
    private val hMacApplyTimeCheckInSeconds = 300

    internal var obj1 : String? = null

    internal var currentDate = String()


    fun getObj1(): String? {
        return obj1
    }

    fun setObj1(obj1: String) {
        HMACClient.obj1 = obj1
    }

    private fun getCurrentDate(): String {

        currentDate = getUTCtime()
        return currentDate
    }


    private fun getUTCtime(): String {
        var formattedDate : String? = null
        try {
            val time = Calendar.getInstance().time
            //            SimpleDateFormat outputFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            val outputFmt = SimpleDateFormat(DATE_FORMAT, Locale.US)
            outputFmt.timeZone = TimeZone.getTimeZone("UTC")
            formattedDate = outputFmt.format(Date())
        } catch (e: Exception) {
            Constant.showLog("HMACClient", "Msg==", e.fillInStackTrace(),Log.DEBUG)
        }

        return formattedDate.toString()
    }


    private fun calculateMD5(contentToEncode: String?): String? {
        var digest: MessageDigest? = null
        var result: String? = null
        try {
            digest = MessageDigest.getInstance("MD5")
            digest!!.update(contentToEncode?.toByteArray(charset("UTF-8")))
            result = String(Base64.encode(digest.digest(), Base64.DEFAULT))
        } catch (e: NoSuchAlgorithmException) {
            Constant.showLog(javaClass.simpleName, "Msg==", e.fillInStackTrace(),Log.DEBUG)
        } catch (e: UnsupportedEncodingException) {
            Constant.showLog(javaClass.simpleName, "Msg==", e.fillInStackTrace(),Log.DEBUG)
        }

        return result
    }

    private fun calculateHMAC(data: String): String {
        try {
            val signingKey = SecretKeySpec(SECRET.toByteArray(), HMAC_SHA1_ALGORITHM)
            val mac = Mac.getInstance(HMAC_SHA1_ALGORITHM)
            mac.init(signingKey)
            val rawHmac = mac.doFinal(data.toByteArray(charset("UTF-8")))
            return String(Base64.encode(rawHmac, Base64.DEFAULT))
        } catch (e: GeneralSecurityException) {
            return ""
        } catch (e: UnsupportedEncodingException) {
            Constant.showLog(javaClass.simpleName, "Msg==", e.fillInStackTrace(),Log.DEBUG)
            return ""
        }

    }

    internal fun getAuthenticationHeader(): ArrayList<String> {

        var url: String? = null
        try {
            url = URL(APIConstants.AbsolutePath_URL).path
        } catch (e: MalformedURLException) {
            Constant.showLog(javaClass.simpleName, "Msg==", e.fillInStackTrace(),Log.DEBUG)
        }

        val contentMd5 = calculateMD5(getObj1())!!.replace("\n", "")
        Constant.showLog("ContentToEncoded", ": " + getObj1(),Log.ERROR)
        Constant.showLog("MD5", ": $contentMd5",Log.DEBUG)
        val toSign = ("POST" + "\n" + getBodyContentType() + "\n" +
                contentMd5 + "\n" + url + "\n"
                + getCurrentDate())
        Constant.showLog("toSign", ": $toSign",Log.DEBUG)
        val hmac = calculateHMAC(toSign).replace("\n", "")
        Constant.showLog("path", ": " + url!!,Log.DEBUG)
        val stringArrayList = ArrayList<String>()
        stringArrayList.add(contentMd5)
        stringArrayList.add(hmac)
        return stringArrayList
    }

    private fun getBodyContentType(): String {
        return PROTOCOL_CONTENT_TYPE
    }


    fun parseResponse(response: Response<*>, contentToEncoded: String): Boolean {
        var isvalidresponse = false
        try {
            val hmacFromRequest = response.headers().get("Authentication")
            val contentMD5FromRequest = response.headers().get("ContentHash")
            val currentDateFromRequest = response.headers().get("ContentDate")
            if (currentDateFromRequest != null) {
                if (isValidTimeDiff(currentDateFromRequest, getUTCtime())) {
                    var url1 = ""
                    try {
                        url1 = URL(APIConstants.AbsolutePath_URL).path
                    } catch (e: MalformedURLException) {
                        Constant.showLog(javaClass.simpleName, "Msg==", e.fillInStackTrace(),Log.DEBUG)
                    }

                    val verb = "POST"
                    val contentType = "application/x-www-form-urlencoded"
                    val contentMd5 = calculateMD5(contentToEncoded)!!.replace("\n", "")
                    val toSign = (verb + "\n" + contentType + "\n" +
                            contentMd5 + "\n" + url1 + "\n"
                            + currentDateFromRequest)

                    val hmacCalculated = calculateHMAC(toSign).replace("\n", "")

                    Constant.showLog("----", "------------------------",Log.DEBUG)
                    Constant.showLog("----", "Data = $contentToEncoded",Log.ERROR)
                    Constant.showLog("----", "hmacFromRequest = " + hmacFromRequest!!,Log.DEBUG)
                    Constant.showLog("----", "hmacCalculated = $hmacCalculated",Log.DEBUG)
                    Constant.showLog("----", "url 1 = $url1",Log.DEBUG)
                    Constant.showLog("----", "toSign = $toSign",Log.DEBUG)

                    val isValid = hmacCalculated == hmacFromRequest
                    if (!isValid) {
                        isvalidresponse = false
                        exitApplication()
                    } else {
                        isvalidresponse = true
                        return isvalidresponse
                    }
                } else {
                    isvalidresponse = false
                    exitApplication()
                }
            } else {
                isvalidresponse = false
                exitApplication()
            }

        } catch (e: Exception) {
            Constant.showLog(javaClass.simpleName, "Msg==", e.fillInStackTrace(),Log.DEBUG)
        }

        return isvalidresponse
    }

    fun exitApplication(){
        /*Handler(Looper.getMainLooper()).post{
            Toast.makeText(App.getApplicationContextImpl(),
                "Oops!, Something went wrong", Toast.LENGTH_SHORT).show()
        }
*/
//        SessionManager.logoutUser()

      /*  val i = App.getApplicationContextImpl().packageManager
            .getLaunchIntentForPackage(App.getApplicationContextImpl().packageName)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        i.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        App.getApplicationContextImpl().startActivity(i)*/
    }


    fun isValidTimeDiff(startDate: String?, endDate: String?): Boolean {

        val startDate = stringToDate(startDate)
        val endDate = stringToDate(endDate)

        //milliseconds
        val different = endDate.time - startDate.time

        val secondsInMilli = 1000L

        val elapsedSeconds  = different / secondsInMilli

        return Math.abs(elapsedSeconds) <= hMacApplyTimeCheckInSeconds
    }


    fun stringToDate(stringDate: String?): Date {
        var date = Date()
        val format = SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH)
        try {
            date = format.parse(stringDate)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return date
    }

    fun parseResponse(response: okhttp3.Response?, contentToEncoded: String?) :Boolean{
        var isvalidresponse = false
        try {
            val hmacFromRequest = response?.headers()?.get("Authentication")
            val contentMD5FromRequest = response?.headers()?.get("ContentHash")
            val currentDateFromRequest = response?.headers()?.get("ContentDate")
            if (currentDateFromRequest != null) {
                if (isValidTimeDiff(currentDateFromRequest, getUTCtime())) {
                    var url1 = ""
                    try {
                        url1 = URL(APIConstants.AbsolutePath_URL).path
                    } catch (e: MalformedURLException) {
                        Constant.showLog(javaClass.simpleName, "Msg==", e.fillInStackTrace(),Log.DEBUG)
                    }

                    val verb = "POST"
                    val contentType = "application/x-www-form-urlencoded"
                    val contentMd5 = calculateMD5(contentToEncoded.toString())!!.replace("\n", "")
                    val toSign = (verb + "\n" + contentType + "\n" +
                            contentMd5 + "\n" + url1 + "\n"
                            + currentDateFromRequest)

                    val hmacCalculated = calculateHMAC(toSign).replace("\n", "")

                    Constant.showLog("----", "------------------------",Log.DEBUG)
                    Constant.showLog("----", "Data = $contentToEncoded",Log.ERROR)
                    Constant.showLog("----", "hmacFromRequest = " + hmacFromRequest!!,Log.DEBUG)
                    Constant.showLog("----", "hmacCalculated = $hmacCalculated",Log.DEBUG)
                    Constant.showLog("----", "url 1 = $url1",Log.DEBUG)
                    Constant.showLog("----", "toSign = $toSign",Log.DEBUG)

                    val isValid = hmacCalculated == hmacFromRequest
                    if (!isValid) {
                        isvalidresponse = false
                        exitApplication()
                    } else {
                        isvalidresponse = true
                        return isvalidresponse
                    }
                } else {
                    isvalidresponse = false
                    exitApplication()
                }
            } else {
                isvalidresponse = false
                exitApplication()
            }

        } catch (e: Exception) {
            Constant.showLog(javaClass.simpleName, "Msg==", e.fillInStackTrace(),Log.DEBUG)
        }

        return isvalidresponse
    }


}