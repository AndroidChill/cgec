package com.example.vodovoz_test_project.data.api

import javax.inject.Inject

class ApiHelper @Inject constructor(
    private val apiService: ApiService
) {
    
    suspend fun getCatalog() = apiService.getCatalog()
    
}