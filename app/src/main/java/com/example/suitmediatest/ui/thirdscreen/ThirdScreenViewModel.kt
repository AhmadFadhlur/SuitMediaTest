package com.example.suitmediatest.ui.thirdscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.suitmediatest.data.repository.DataRepository
import com.example.suitmediatest.network.model.user.DataItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ThirdScreenViewModel(private val repository: DataRepository) : ViewModel() {

    private var _listUser = MutableStateFlow<PagingData<DataItem>>(PagingData.empty())
    val listUser = _listUser.asStateFlow()

    fun getUser(){
        repository.getUser().cachedIn(viewModelScope).onEach {
            _listUser.value = it
        }.launchIn(viewModelScope)
    }
}