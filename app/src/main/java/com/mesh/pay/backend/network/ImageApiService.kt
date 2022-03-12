package com.mesh.pay.backend.network

import com.mesh.pay.backend.repository.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ImageApiService{

    @Singleton
    @Provides
    fun provideImageRepository(
       imageApi: ImageApiInterface
    ) = ImageRepository(imageApi)

    @Singleton
    @Provides
    fun provideImageApi() : ImageApiInterface
    {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        val mediaType  = "text/plain".toMediaType()
        val body = MultipartBody.Builder().setType(MultipartBody.FORM)
            .addFormDataPart("requestInfo", null,
                RequestBody.create(
                    "application/json".toMediaType(),
                    "{\n" +
                            "  \"applicationType\": \"0 = trackPace, other values = 1 is emotionTour, 2 is offroadAdventure\",\n" +
                            "  \"language\": \"en_gb\",\n" +
                            "  \"laps\": [\n" +
                            "    {\n" +
                            "      \"averageSpeed\": 1212,\n" +
                            "      \"averageTemp\": 132,\n" +
                            "      \"avg_horsepower\": 192.14285714285714,\n" +
                            "      \"driftScore\": 2,\n" +
                            "      \"drivingDuration\": 123,\n" +
                            "      \"lapLength\": 122.22,\n" +
                            "      \"lapNumber\": 1,\n" +
                            "      \"lapTimeInMilliseconds\": 123412,\n" +
                            "      \"lapType\": \"XYZ\",\n" +
                            "      \"odometer\": 2000,\n" +
                            "      \"offRoadScore\": 1.5,\n" +
                            "      \"startDate\": \"25-02-2022\",\n" +
                            "      \"startTime\": \"12:12\",\n" +
                            "      \"sumElevationGain\": 12,\n" +
                            "      \"sumElevationLoss\": 12\n" +
                            "    }\n" +
                            "  ],\n" +
                            "  \"recordingData\": {\n" +
                            "    \"avgValues\": {\n" +
                            "      \"avgBrakeTorque\": 132,\n" +
                            "      \"avgDriftAngle\": 132,\n" +
                            "     \"avgGForce\": 132,\n" +
                            "      \"avgOilTemp\": 132,\n" +
                            "      \"avgSpeed\": 132,\n" +
                            "      \"avgTireTemp\": 132,\n" +
                            "      \"avgTransmissionTemp\": 132\n" +
                            "    },\n" +
                            "    \"date\": \"25-02-2022\",\n" +
                            "    \"maxValues\": {\n" +
                            "      \"maxBrakeTorque\": 132,\n" +
                            "      \"maxDriftAngle\": 132,\n" +
                            "      \"maxGForce\": 132,\n" +
                            "      \"maxOilTemp\": 132,\n" +
                            "      \"maxSpeed\": 132,\n" +
                            "      \"maxTireTemp\": 132,\n" +
                            "      \"maxTransmissionTemp\": 132\n" +
                            "    },\n" +
                            "    \"raceGuid\": 3504078157174,\n" +
                            "    \"startTime\": \"12:12\"\n" +
                            "  },\n" +
                            "  \"requestType\": \"animation or highlightVide\",\n" +
                            "  \"templateId\": 0,\n" +
                            "  \"userProfile\": {\n" +
                            "    \"authId\": 1212,\n" +
                            "    \"email\": \"souvick.mazumder@daimler.com\",\n" +
                            "    \"meId\": 1212,\n" +
                            "    \"name\": \"Souvick Mazumder\"\n" +
                            "  },\n" +
                            "  \"vinOrFin\": \"WDD2130331A123456\",\n" +
                            "  \"weather\": {\n" +
                            "    \"dateTime\": \"2020-02-28T08:46:38-04:00\",\n" +
                            "    \"dew\": 69.2,\n" +
                            "    \"humidity\": 94,\n" +
                            "    \"icon\": \"rain\",\n" +
                            "    \"precip\": 0.1,\n" +
                            "    \"snowDepth\": \"null\",\n" +
                            "    \"sunRise\": \"2020-02-28T05:47:23-04:00\",\n" +
                            "    \"sunSet\": \"2020-05-22T20:27:02-04:00\",\n" +
                            "    \"temp\": 71,\n" +
                            "    \"visibility\": \"null\"\n" +
                            "  }\n" +
                            "}"
))
.build();

httpClient.addInterceptor { chain ->
            val original = chain.request()
            // Request customization: add request headers
            val requestBuilder = original.newBuilder()
                .url("https://amghua-dev.query.api.dvb.corpinter.net/hua/v1/asset")
                .addHeader("Cookie", "OAuth_Token_Request_State=3eff3de7-2ed9-4794-a535-ee8b4c0e9799; request_uri=L2h1YS92MS9hc3NldA==")                .method("POST", body)
                //.addHeader("Authorization",token)
        val request = requestBuilder.build()
            chain.proceed(request)
        }
        httpClient.readTimeout(60, TimeUnit.SECONDS)
        httpClient.connectTimeout(60, TimeUnit.SECONDS)
        httpClient.addNetworkInterceptor(logging)

        val okHttpClient=httpClient.build()

        return Retrofit.Builder()
            .baseUrl("https://amghua-dev.query.api.dvb.corpinter.net/hua/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ImageApiInterface::class.java)
    }
}
