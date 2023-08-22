package com.example.vodovoz_test_project.ui.fragments

import com.example.vodovoz_test_project.data.api.ListCatalog
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

@Module
@InstallIn
interface CatalogRepository {

    @Provides
    suspend fun catalogList(): ListCatalog
}