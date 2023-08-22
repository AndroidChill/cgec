package com.example.vodovoz_test_project.data.api

import com.example.vodovoz_test_project.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("super_top.php?action=topglav")
    suspend fun getUsers(): Response<List<User>>

}