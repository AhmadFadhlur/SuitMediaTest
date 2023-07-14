package com.example.suitmediatest.ui.secondscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.suitmediatest.R
import com.example.suitmediatest.databinding.FragmentFirstScreenBinding
import com.example.suitmediatest.databinding.FragmentSecondScreenBinding


class SecondScreenFragment : Fragment() {

    private var _binding : FragmentSecondScreenBinding? = null
    private val binding get() = _binding!!
    private val navArgs : SecondScreenFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setview()
        moveToThirdScreen()
    }

    private fun moveToThirdScreen(){
        binding.btnChooseUser.setOnClickListener{
            findNavController().navigate(R.id.action_secondScreenFragment_to_thirdScreenFragment)
        }
    }


    private fun setview(){
        binding.apply {
        val username = navArgs.userName
        val sourceFrag = navArgs.SourceFrag
            if (sourceFrag == "FragmentFirst"){
                tvUser.text = username
            }
            if (sourceFrag == "FragmentThird"){
                tvSelectedUser.text = username
            }
        }
    }

}