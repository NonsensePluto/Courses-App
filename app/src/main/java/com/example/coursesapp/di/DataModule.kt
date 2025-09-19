package com.example.coursesapp.di

import androidx.room.Room
import com.example.coursesapp.data.local.appdatabase.AppDatabase
import com.example.coursesapp.data.local.dao.CourseDao
import com.example.coursesapp.data.mappers.CourseDomainToEntity
import com.example.coursesapp.data.mappers.CourseEntityToDomain
import com.example.coursesapp.data.mappers.CourseResponseToDomain
import com.example.coursesapp.data.mappers.UserDataToDomain
import com.example.coursesapp.data.remote.api.CoursesApi
import com.example.coursesapp.data.remote.datasource.CoursesRemoteDataSource
import com.example.coursesapp.data.repositories.CoursesLocalRepositoryImpl
import com.example.coursesapp.data.repositories.CoursesRemoteRepositoryImpl
import com.example.coursesapp.data.repositories.LoginRepositoryImpl
import com.example.coursesapp.domain.repositories.CoursesLocalRepository
import com.example.coursesapp.domain.repositories.CoursesRemoteRepository
import com.example.coursesapp.domain.repositories.LoginRepository
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
            coursesDomainToEntity = get(),
            coursesEntityToDomain = get()
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

val databaseModule = module {

    single<AppDatabase> {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "courses_app_database"
        ).build()
    }

    single<CourseDao> {
        get<AppDatabase>().courseDao()
    }
}