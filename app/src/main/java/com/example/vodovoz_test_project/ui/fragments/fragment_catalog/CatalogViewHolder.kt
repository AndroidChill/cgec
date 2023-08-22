package com.example.vodovoz_test_project.ui.fragments.fragment_catalog

import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.request.ImageRequest
import com.example.vodovoz_test_project.R
import com.example.vodovoz_test_project.databinding.ItemCatalogBinding

class CatalogViewHolder (
    private val binding: ItemCatalogBinding
        ) : RecyclerView.ViewHolder (binding.root) {

            fun itemProducts (
                imageLink: String,
                cost: String
            ){
                with(binding){
                    val request = ImageRequest.Builder(ivProduct.context).data(imageLink)
                        .target(onStart = { placeholder ->
                            ivProduct.setImageDrawable(ivProduct.context.getDrawable(R.drawable.ic_launcher_background))
                        }, onSuccess = { result ->
                            ivProduct.setImageDrawable(result)
                        }, onError = { error ->
                            ivProduct.setImageDrawable(ivProduct.context.getDrawable(R.drawable.ic_launcher_background))
                        }).build()

                    val imageLoader = ImageLoader.Builder(ivProduct.context).crossfade(true).build()

                    imageLoader.enqueue(request)
                    tvCost.text = cost


                }
            }

}