package com.neptuunia.travel.di;

import com.neptuunia.travel.constant.Constant;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Putra Nugraha (putra.nugraha@dana.id)
 * @version AppModule, v 0.0.1 18/08/20 07.22 by Putra Nugraha
 */
@Module
@InstallIn(ApplicationComponent.class)
public class AppModule {

    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
            .baseUrl(Constant.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient)
            .build();
    }

    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build();
    }

    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        return interceptor;
    }
}
