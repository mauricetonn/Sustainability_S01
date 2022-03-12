package com.mesh.pay.backend.network

import com.mesh.pay.backend.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class AuthApiService {

    @Singleton
    @Provides
    fun provideAuthRepository(
        authApi: AuthApiInterface
    ) = AuthRepository(authApi)

    /**
     * Implementation of API Interface to implement the POST Call for the Auth token
     */
    @Singleton
    @Provides
    fun provideAuthApi() : AuthApiInterface
    {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        val mediaType  = "application/x-www-form-urlencoded".toMediaType()
        val body = RequestBody.create(mediaType, "grant_type=client_credentials&scope=openid+groups+audience:server:client_id:DAIVBADM_MICTM_EMEA_DEV_00119")
        httpClient.addInterceptor { chain ->
            val original = chain.request()
            // Request customization: add request headers
            val requestBuilder = original.newBuilder()
                .url("https://ssoalpha.dvb.corpinter.net/v1/token")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Cookie", "OAuth_Token_Request_State=fb66b1fd-c802-48b9-b665-f5e563b3c30f; request_uri=L3Rva2VubWFzdGVyLW1hbmFnZW1lbnQtYXBpL2NsaWVudHM/c3RhdHVzPVBFTkRJTkclMkNBQ1RJVkUlMkNJTkFDVElWRSUyQ1RFUk1JTkFURUQmYXV0b2FwcHJvdmFsPXRydWUmc2hvd2FsbD10cnVl")
                .method("POST", body)
                .addHeader("Authorization", "Basic REFJVkJBRE1fTUlDVE1fRU1FQV9ERVZfMDAwMTQ6M2o4aWZ5ZEIuRDFwWUljLVE2OTB4TkF3MjU0V35fUjc=")
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        httpClient.readTimeout(60, TimeUnit.SECONDS)
        httpClient.connectTimeout(60, TimeUnit.SECONDS)
        httpClient.addNetworkInterceptor(logging)

        val okHttpClient=httpClient.build()

       return Retrofit.Builder()
            .baseUrl("https://ssoalpha.dvb.corpinter.net/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(AuthApiInterface::class.java)
    }
}