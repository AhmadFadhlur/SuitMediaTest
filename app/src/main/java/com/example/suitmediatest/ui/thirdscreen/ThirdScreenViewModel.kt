package com.example.suitmediatest.ui.thirdscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.suitmediatest.data.network.response.DataItem
import com.example.suitmediatest.data.repository.DataRepository
import com.example.suitmediatest.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThirdScreenViewModel @Inject constructor (
    private val userRepository: UserRepository) : ViewModel() {

    private var _listUser = MutableStateFlow<PagingData<DataItem>>(PagingData.empty())
    val listUser : StateFlow<PagingData<DataItem>> = _listUser

    fun getUser() = viewModelScope.launch{
        userRepository.getUserPaging().cachedIn(viewModelScope).collectLatest {
            _listUser.value = it
        }
    }
}