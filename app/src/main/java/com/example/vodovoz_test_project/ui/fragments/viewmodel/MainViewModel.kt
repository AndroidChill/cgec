package com.example.vodovoz_test_project.ui.fragments.viewmodel

import androidx.lifecycle.*
import com.example.vodovoz_test_project.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (
    private val mainRepository: MainRepository
) : ViewModel() {

}