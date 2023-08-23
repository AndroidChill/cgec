package com.example.vodovoz_test_project.di.module

import com.example.vodovoz_test_project.data.repository.CatalogRepository
import com.example.vodovoz_test_project.data.repository.CatalogRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    
    @Binds
    @Singleton
    fun provideCatalogRepository(repository: CatalogRepositoryImpl): CatalogRepository
    
}