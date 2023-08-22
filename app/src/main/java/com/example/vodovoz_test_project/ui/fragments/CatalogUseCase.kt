package com.example.vodovoz_test_project.ui.fragments

import com.example.vodovoz_test_project.data.api.ListCatalog
import javax.inject.Inject

class CatalogUseCase @Inject constructor(private val repository: CatalogRepository) {


    suspend fun catalogList(): ListCatalog = repository.catalogList()
}