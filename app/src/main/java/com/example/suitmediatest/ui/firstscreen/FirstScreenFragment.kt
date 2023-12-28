package com.example.suitmediatest.ui.firstscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.suitmediatest.databinding.FragmentFirstScreenBinding


class FirstScreenFragment : Fragment() {

    private var _binding : FragmentFirstScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstScreenBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPalindrome()
        moveToSecondScreen()
        onBackPressed()

    }
    private fun onBackPressed(){
        requireActivity().onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().popBackStack()
                }
            })
    }

    private fun moveToSecondScreen(){
        binding.apply {
            btnNext.setOnClickListener {
                if(etName.text.toString().isEmpty()){
                    Toast.makeText(requireContext(), "Please fill Your Name", Toast.LENGTH_SHORT).show()
                } else{
                    val action = FirstScreenFragmentDirections.actionFirstScreenFragmentToSecondScreenFragment(etName.text.toString(), "null")
                    findNavController().navigate(action)
                }

            }
        }
    }

    private fun checkPalindrome(){
        binding.apply {
            btnCheck.setOnClickListener {
                if (etPalindrome.text.toString().isEmpty()){
                    Toast.makeText(requireContext(), "Please fill the Palindrome text first", Toast.LENGTH_SHORT).show()
                } else {
                    val tvPalindrome = etPalindrome.text.toString()
                    if (isPalindrome(tvPalindrome)){
                        Toast.makeText(requireContext(), "the text is palindrome", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(requireContext(), "the text is not palindrome", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }
    private fun isPalindrome(sentence: String): Boolean {
        val cleanedSentence = sentence.replace("\\s+".toRegex(), "").toLowerCase()
        val reversedSentence = cleanedSentence.reversed()
        return cleanedSentence == reversedSentence
    }


}