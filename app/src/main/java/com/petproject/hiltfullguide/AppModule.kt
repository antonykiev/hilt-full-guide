package com.petproject.hiltfullguide

import com.petproject.hiltfullguide.datasource.DataSource
import com.petproject.hiltfullguide.datasource.DataSourceLocalImpl
import com.petproject.hiltfullguide.datasource.DataSourceRemoteImpl
import com.petproject.hiltfullguide.repository.Repository
import com.petproject.hiltfullguide.repository.RepositoryAnotherImpl
import com.petproject.hiltfullguide.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    @Named("repository")
    fun provideRepository(
        @Named("remote") dataSourceRemote: DataSource,
        @Named("local") dataSourceLocal: DataSource,
    ): Repository = RepositoryImpl(
        dataSourceRemote = dataSourceRemote,
        dataSourceLocal = dataSourceLocal,
    )

    @Provides
    @Singleton
    @Named("repositoryAnother")
    fun provideRepositoryAnotherImpl(
        @Named("remote") dataSourceRemote: DataSource,
        @Named("local") dataSourceLocal: DataSource,
    ): Repository = RepositoryAnotherImpl(
        dataSourceRemote = dataSourceRemote,
        dataSourceLocal = dataSourceLocal,
    )

    @Provides
    @Singleton
    @Named("remote")
    fun provideDataSourceRemote(): DataSource = DataSourceRemoteImpl()

    @Provides
    @Singleton
    @Named("local")
    fun provideDataSourceLocal(): DataSource = DataSourceLocalImpl()
}