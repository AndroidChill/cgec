package com.example.vodovoz_test_project.ui.fragments.fragment_catalog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vodovoz_test_project.databinding.ItemCatalogBinding

class CatalogAdapter(
) : RecyclerView.Adapter<CatalogViewHolder>() {

    private val data = mutableListOf<CatalogData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemCatalogBinding =
            ItemCatalogBinding.inflate(layoutInflater, parent, false)
        return CatalogViewHolder(binding)
    }

    override fun getItemCount() = data.size

    fun addData(dataTemp: List<CatalogData>) {
        val prevCount = data.size
        data.clear()
        notifyItemRangeRemoved(0, prevCount)
        data.addAll(dataTemp)
        notifyItemRangeInserted(0, dataTemp.size)
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        data[position].apply {
            holder.itemProducts(
                this.imageLink,
                this.cost
            )
        }
    }


}