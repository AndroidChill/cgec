package com.example.vodovoz_test_project.data.api

import kotlinx.serialization.Serializable
import retrofit2.http.GET

interface ApiService {

    @GET("super_top.php?action=topglav")
    suspend fun getCatalog(): ListCatalog

}

@Serializable
data class ListCatalog (
    val status: String,
    val TOVARY: List <ProductData>
        )

//@Serializable
//data class Catalog(
//    val data: List <ProductData>
//)

@Serializable
data class ProductData(
    val DETAIL_PICTURE: String,
    val CATALOG_PURCHASING_PRICE: String
)