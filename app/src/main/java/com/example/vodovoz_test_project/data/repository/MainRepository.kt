package com.example.vodovoz_test_project.data.repository

import com.example.vodovoz_test_project.data.api.ApiHelperImpl
import com.example.vodovoz_test_project.data.api.ListCatalog
import com.example.vodovoz_test_project.ui.fragments.CatalogRepository
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelperImpl: ApiHelperImpl
    ) : CatalogRepository {

    override suspend fun catalogList() : ListCatalog {
        return apiHelperImpl.getCatalog()
    }

}