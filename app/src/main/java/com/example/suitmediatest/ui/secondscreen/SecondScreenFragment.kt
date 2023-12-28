package com.example.suitmediatest.ui.secondscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.suitmediatest.R
import com.example.suitmediatest.databinding.FragmentFirstScreenBinding
import com.example.suitmediatest.databinding.FragmentSecondScreenBinding


class SecondScreenFragment : Fragment(R.layout.fragment_second_screen) {

    private val binding by viewBinding(FragmentSecondScreenBinding::bind)
    private val navArgs : SecondScreenFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
        moveToThirdScreen()
    }

    private fun moveToThirdScreen(){
        binding.btnChooseUser.setOnClickListener{
            val action = SecondScreenFragmentDirections.actionSecondScreenFragmentToThirdScreenFragment(navArgs.userName)
            findNavController().navigate(action)

        }
    }


    private fun setView(){
        binding.apply {
            val username = navArgs.userName
            val userSelected = navArgs.usernameSelected
            if (userSelected != "null"){
                tvSelectedUser.text = userSelected
            }
            tvUser.text = username
        }
    }

//    private fun setviewUserSelected(){
//        binding.apply {
//        val username = navArgs.userName
//            val Userselect = navArgs.usernameSelected
//            when (sourceFrag) {
//                "FragmentThird" -> {
//                    tvSelectedUser.text = username
//                }
//            }
//        }
//    }

}