package com.example.mvvmapplication.di

import android.util.Log
import com.example.mvvmapplication.BuildConfig
import com.example.mvvmapplication.data.constant.APIConstants
import com.example.mvvmapplication.data.hmac.HMACClient
import com.example.mvvmapplication.data.remote.api.RetrofitApi
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okio.Buffer
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.nio.charset.Charset
import java.util.concurrent.TimeUnit



private const val CONNECT_TIMEOUT = 120L
private const val WRITE_TIMEOUT = 120L
private const val READ_TIMEOUT = 120L

val networkModule = module {
    single { Cache(androidContext().cacheDir, 10L * 1024 * 1024) }

    single { GsonBuilder()
        .disableHtmlEscaping()
        .setLenient()
        .create() }

    single {
        OkHttpClient.Builder().apply {
            cache(get())
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            addInterceptor(get())
            addInterceptor(HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            })
        }.build()
    }

    /*single {
        Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(get())
            .build()
    }*/

    single {
        Retrofit.Builder()
            .baseUrl(APIConstants.BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(get())
            .build()
    }

    /*single {
        Interceptor { chain ->
            chain.proceed(chain.request().newBuilder().apply {
                header("Accept", "application/vnd.github.mercy-preview+json")
            }.build())
        }
    }*/

    single {

        //        HMACClient.setObj1(lmodel)
        Interceptor { chain ->
            Log.d("REQ",chain.request().body().toString())
//            HMACClient.setObj1(chain.request().body().toString())
            val buffer = Buffer()
            chain.request().body()?.writeTo(buffer)
            val charset=Charset.forName("UTF-8")
            HMACClient.setObj1(buffer.readString(charset))

            val stringArrayList = HMACClient.getAuthenticationHeader()
            val newRequest = chain.request().newBuilder()
                .addHeader("Authentication", stringArrayList.get(1))

                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("ContentDate", HMACClient.currentDate)
                .addHeader("ContentHash", stringArrayList.get(0))

                .method(chain.request().method(), chain.request().body())
                .build()

//            chain.proceed(newRequest)

            // try the request
            var response = chain.proceed(newRequest)

            var tryCount = 0
            val maxLimit = 3 //Set your max limit here

            while (!response.isSuccessful && tryCount < maxLimit) {

                Log.d("REQ", "Request failed - $tryCount")

                tryCount++

                // retry the request
                response = chain.proceed(newRequest)
            }
           /* val source = response.body()?.source()
            source?.request(java.lang.Long.MAX_VALUE) // Buffer the entire body.
            val bufferResp = source?.buffer()


           val isValid= HMACClient.parseResponse(response,bufferResp?.readString(charset))
            Log.d("REQ", "isValid - $isValid")*/
            // otherwise just pass the original response on
           response


        }
    }
}