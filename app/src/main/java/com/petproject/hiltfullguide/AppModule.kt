package com.petproject.hiltfullguide

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
    fun provideRepository(): Repository  = RepositoryImpl()

    @Provides
    @Singleton
    @Named("repositoryAnother")
    fun provideRepositoryAnotherImpl(): Repository  = RepositoryAnotherImpl()
}