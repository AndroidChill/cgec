package com.example.vodovoz_test_project.data.repository

import com.example.vodovoz_test_project.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getUsers() =  apiHelper.getUsers()

}