package com.example.vodovoz_test_project.data.repository

import com.example.vodovoz_test_project.data.api.ListCatalog
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn


interface CatalogRepository {

    suspend fun catalogList(): ListCatalog
}