package com.example.vodovoz_test_project.data.repository

import com.example.vodovoz_test_project.data.api.ApiHelper
import com.example.vodovoz_test_project.data.api.ListCatalog
import dagger.Binds
import dagger.Module
import javax.inject.Inject

class CatalogRepositoryImpl @Inject constructor(
    private val apiHelper: ApiHelper
): CatalogRepository {

    override suspend fun catalogList() : ListCatalog {
        return apiHelper.getCatalog()
    }
    
}