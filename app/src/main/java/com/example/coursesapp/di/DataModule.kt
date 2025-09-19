package com.example.coursesapp.di

import com.example.coursesapp.data.mappers.CourseDomainToEntity
import com.example.coursesapp.data.mappers.CourseEntityToDomain
import com.example.coursesapp.data.mappers.CourseResponseToDomain
import com.example.coursesapp.data.mappers.UserDataToDomain
import com.example.coursesapp.data.remote.api.CoursesApi
import com.example.coursesapp.data.remote.datasource.CoursesRemoteDataSource
import com.example.coursesapp.data.repository.CoursesLocalRepositoryImpl
import com.example.coursesapp.data.repository.CoursesRemoteRepositoryImpl
import com.example.coursesapp.data.repository.LoginRepositoryImpl
import com.example.coursesapp.domain.repository.CoursesLocalRepository
import com.example.coursesapp.domain.repository.CoursesRemoteRepository
import com.example.coursesapp.domain.repository.LoginRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    //Repositories
    single<LoginRepository> {
        LoginRepositoryImpl(userDataToDomain = get())
    }

    single<CoursesRemoteRepository> {
        CoursesRemoteRepositoryImpl(
            coursesRemoteDataSource = get(),
            courseResponseToDomain = get()
        )
    }

    single<CoursesLocalRepository> {
        CoursesLocalRepositoryImpl(
            dao = get(),
            coursesEntityToDomain = get(),
            coursesDomainToEntity = get(),
        )
    }

    //Mappers
    factory<UserDataToDomain> {
        UserDataToDomain()
    }

    factory<CourseResponseToDomain> {
        CourseResponseToDomain()
    }

    factory<CourseEntityToDomain>  {
        CourseEntityToDomain()
    }

    factory<CourseDomainToEntity> {
        CourseDomainToEntity()
    }

    //DataSource
    single<CoursesRemoteDataSource> {
        CoursesRemoteDataSource(api = get())
    }


}

val networkModule = module {
    val BASE_URL = "https://drive.usercontent.google.com/u/0/"

    single<HttpLoggingInterceptor> {
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<CoursesApi> { get<Retrofit>().create(CoursesApi::class.java) }
}