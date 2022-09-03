package app.fawry.task.core.di.module

import android.content.Context
import app.fawry.task.data.local.preferences.AppPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
import com.structure.base_mvvm.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

  const val REQUEST_TIME_OUT: Long = 60

  /**Add Query Parameter for api-key in BuildConfig instead of send every time in each request**/
  @Provides
  @Singleton
  fun provideHeadersInterceptor(appPreferences: AppPreferences) = run {
    Interceptor { chain ->
      var request = chain.request()
      request = request.newBuilder().url(
        request.url.newBuilder()
          .addQueryParameter("api_key", BuildConfig.APIKEY)
          .build()
      ).build()
      chain.proceed(
        request
      )
    }
  }

  /**Add Body for Requesting & Response in Debug Mode Only**/
  @Provides
  @Singleton
  fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    return logging
  }

  /**
   * BuildConfig (Debug Mode - Release Mode)
   * Set Connection for (connecting & reading) TimeOut (debug-release)
   * add logging HttpLoggingInterceptor for show (request - response) Body (debug)
   * add ChuckInterceptor for notification for each request (debug)
   * */


  @Provides
  @Singleton
  fun provideOkHttpClient(
    headersInterceptor: Interceptor,
    logging: HttpLoggingInterceptor,
    @ApplicationContext context: Context
  ): OkHttpClient {
    return if (BuildConfig.DEBUG) {
      OkHttpClient.Builder()
        .readTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
        .connectTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(headersInterceptor)
        .addNetworkInterceptor(logging)
        .addInterceptor(ChuckInterceptor(context))
        .build()
    } else {
      OkHttpClient.Builder()
        .readTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
        .connectTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(headersInterceptor)
        .build()
    }
  }

  @Provides
  @Singleton
  fun provideGson(): Gson {
    return GsonBuilder()
      .setLenient()
//      .serializeNulls() // To allow sending null values
      .create()
  }

  /** Add Json Converter **/
  @Provides
  @Singleton
  fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .baseUrl(BuildConfig.API_BASE_URL)
    .build()
}