package com.example.vodovoz_test_project.data.api

import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
    ) {

    suspend fun getCatalog()= apiService.getCatalog()

}