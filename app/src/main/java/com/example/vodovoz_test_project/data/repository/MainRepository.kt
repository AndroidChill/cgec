package com.example.vodovoz_test_project.data.repository

import com.example.vodovoz_test_project.data.api.ApiHelperImpl
import com.example.vodovoz_test_project.data.api.ListCatalog
import com.example.vodovoz_test_project.ui.fragments.CatalogRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
interface MainRepository : CatalogRepository {

    val apiHelperImpl: ApiHelperImpl
    override suspend fun catalogList() : ListCatalog {
        return apiHelperImpl.getCatalog()
    }

    @Binds
    fun catalogList(catalogRepository: ApiHelperImpl): CatalogRepository

}