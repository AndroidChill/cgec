package com.example.vodovoz_test_project.ui.main.viewmodel

import androidx.lifecycle.*
import com.example.vodovoz_test_project.R
import com.example.vodovoz_test_project.data.api.ProductData
import com.example.vodovoz_test_project.ui.fragments.CatalogUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (
    private val catalogUseCase: CatalogUseCase
        ) : ViewModel() {


    private var _state = MutableStateFlow(CatalogState())
    val state = _state.asStateFlow()

    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        _state.update { oldState ->
            oldState.copy(
                events = oldState.events + CatalogState.Event.ShowError
            )

        }
    }

    init {
        viewModelScope.launch {
            getCatalog()
        }

    }

    suspend fun getCatalog() {
        viewModelScope.launch(coroutineExceptionHandler + CoroutineName("getCatalog")) {

            val response = catalogUseCase.catalogList()
            _state.update { oldState ->
                oldState.copy(
                    events = oldState.events + CatalogState.Event.LoadCatalog(
                        response.TOVARY
                    )
                )
            }
        }
    }


}

data class CatalogState(
    val events: List<Event> = emptyList()
) {

    sealed class Event {
        class LoadCatalog(val data: List<ProductData>) : Event()
        object ShowError : Event()
    }


}

