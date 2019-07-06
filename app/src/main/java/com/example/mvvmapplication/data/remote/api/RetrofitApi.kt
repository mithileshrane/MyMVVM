package com.example.mvvmapplication.data.remote.api

import com.example.mvvmapplication.data.constant.APIConstants
import com.example.mvvmapplication.data.hmac.HMACClient
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitApi {

    private var retrofitApi: RetrofitApi? = null
    private lateinit var retrofit: Retrofit
    private lateinit var apiClient: ApiClient
    private lateinit var logging: HttpLoggingInterceptor
    private lateinit var builder: OkHttpClient.Builder
    private lateinit var gson: Gson

    private var lmodel=""

    fun setObject(lmodel:String){
        this.lmodel=lmodel
    }

    fun getClient(): ApiClient {

        logging = HttpLoggingInterceptor()
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        // Define the interceptor, add authentication headers
        HMACClient.setObj1(lmodel)
        val interceptor = Interceptor { chain ->
            val stringArrayList = HMACClient.getAuthenticationHeader()
            val newRequest = chain.request().newBuilder()
                    .addHeader("Authentication", stringArrayList.get(1))

                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .addHeader("ContentDate", HMACClient.currentDate)
                    .addHeader("ContentHash", stringArrayList.get(0))

                    .method(chain.request().method(), chain.request().body())
                    .build()

            chain.proceed(newRequest)
        }


        builder = OkHttpClient.Builder()
                  .connectTimeout(120, TimeUnit.SECONDS)
                    .readTimeout(120, TimeUnit.SECONDS)
                    .writeTimeout(120, TimeUnit.SECONDS)


        builder.interceptors().add(interceptor)
        builder.interceptors().add(logging)
        val client = builder.build()

        /*gson = GsonBuilder()
                .setLenient()
                .create()*/


        gson = GsonBuilder()
            .disableHtmlEscaping()
            .setLenient()
            .create()


        retrofit = Retrofit.Builder()
                .baseUrl(APIConstants.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()


        apiClient = retrofit.create(ApiClient::class.java)

        return apiClient
    }


    fun getClientExposeWithout(lmodel: String): ApiClient {

        logging = HttpLoggingInterceptor()
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        // Define the interceptor, add authentication headers
        HMACClient.setObj1(lmodel)
        val interceptor = Interceptor { chain ->
            val stringArrayList = HMACClient.getAuthenticationHeader()
            val newRequest = chain.request().newBuilder()
                .addHeader("Authentication", stringArrayList.get(1))

                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("ContentDate", HMACClient.currentDate)
                .addHeader("ContentHash", stringArrayList.get(0))

                .method(chain.request().method(), chain.request().body())
                .build()

            chain.proceed(newRequest)
        }


        builder = OkHttpClient.Builder()
//                  .connectTimeout(120, TimeUnit.SECONDS)
//                    .readTimeout(120, TimeUnit.SECONDS)
//                    .writeTimeout(120, TimeUnit.SECONDS);


        builder.interceptors().add(interceptor)
        builder.interceptors().add(logging)
        val client = builder.build()

        /*gson = GsonBuilder()
                .setLenient()
                .create()*/

        gson = GsonBuilder()
//            .disableHtmlEscaping()
//            .excludeFieldsWithoutExposeAnnotation()
            .setLenient()
            .create()


        retrofit = Retrofit.Builder()
            .baseUrl(APIConstants.BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()


        apiClient = retrofit.create(ApiClient::class.java)

        return apiClient
    }

    fun getGsonParserDis():Gson{
        val gson = GsonBuilder()
            .disableHtmlEscaping()
            .setLenient()
            .create()

        return gson
    }

    fun getGsonExposeParserDis():Gson{
        val gson = GsonBuilder()
            .disableHtmlEscaping()
            .excludeFieldsWithoutExposeAnnotation()
            .setLenient()
            .create()

        return gson
    }

}