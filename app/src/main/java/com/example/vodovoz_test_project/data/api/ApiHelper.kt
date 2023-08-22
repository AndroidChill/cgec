package com.example.vodovoz_test_project.data.api

import com.example.vodovoz_test_project.data.model.Catalog
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Response<List<Catalog>>
}