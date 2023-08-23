package com.example.vodovoz_test_project.ui.fragments.fragment_catalog

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vodovoz_test_project.R
import com.example.vodovoz_test_project.databinding.FragmentCatalogBinding
import com.example.vodovoz_test_project.ui.main.viewmodel.CatalogState
import com.example.vodovoz_test_project.ui.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CatalogFragment : Fragment(R.layout.fragment_catalog) {

    private val fragmentViewModel by viewModels<MainViewModel>()
    lateinit var binding: FragmentCatalogBinding

    private val adapter: CatalogAdapter = CatalogAdapter()

    private var isSelect = true
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCatalogBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCatalog.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCatalog.adapter = adapter
        
        binding.btnFirst.setTextColor(Color.BLUE)
        binding.btnFirst.setOnClickListener {
            if (!isSelect) {
                isSelect = !isSelect
                select()
                addData(true)
            }
        }
        
        binding.btnSecond.setOnClickListener {
            if (isSelect) {
                isSelect = !isSelect
                select()
                addData(false)
            }
        }
        
        addData(true)
    }


    private fun select() {
        if (isSelect) {
            binding.btnFirst.setTextColor(Color.BLUE)
            binding.btnSecond.setTextColor(Color.BLACK)
        } else {
            binding.btnFirst.setTextColor(Color.BLACK)
            binding.btnSecond.setTextColor(Color.BLUE)
        }
        isSelect = !isSelect
    }

    private fun addData(position: Boolean) {
        lifecycleScope.launch {

            fragmentViewModel.state.collect {
                it.events.forEach { event ->
                    when (event) {
                        is CatalogState.Event.LoadCatalog -> {
                            val data = event.data.map {
                                CatalogData(
                                    imageLink = it.DETAIL_PICTURE ?: "",
                                    cost = it.CATALOG_PURCHASING_PRICE ?: ""
                                )
                            }

                            var coroutineData = data
                            lifecycleScope.launch(Dispatchers.IO) {

                                coroutineData = data.filter {
                                    if (position){
                                        it.cost.isNotEmpty()
                                    } else {
                                        it.cost.isEmpty()
                                    }
                                }
                                adapter.addData(coroutineData)

                            }

                            adapter.addData(data)
                        }

                        is CatalogState.Event.ShowError -> {
                            Toast.makeText(context, "Ups, internet is missing", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                }
            }
        }
    }

}