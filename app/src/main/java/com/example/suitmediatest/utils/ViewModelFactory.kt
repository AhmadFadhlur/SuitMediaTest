package com.example.suitmediatest.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.suitmediatest.di.Injection
import com.example.suitmediatest.ui.thirdscreen.ThirdScreenViewModel

//class ViewModelFactory(private val context: Context)  : ViewModelProvider.Factory{
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel> create (modelClass: Class<T>) : T{
//        return when {
//            modelClass.isAssignableFrom(ThirdScreenViewModel::class.java) -> {
//                ThirdScreenViewModel(Injection.provideRepository(context)) as T
//            }
//
//            else ->throw java.lang.IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
//
//        }
//
//    }
//}