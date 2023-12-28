package com.example.suitmediatest.ui.firstscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.suitmediatest.R
import com.example.suitmediatest.databinding.FragmentFirstScreenBinding


class FirstScreenFragment : Fragment(R.layout.fragment_first_screen) {


    private val binding by viewBinding(FragmentFirstScreenBinding::bind)

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
                    Toast.makeText(requireContext(),
                        getString(R.string.please_fill_your_name), Toast.LENGTH_SHORT).show()
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
                    Toast.makeText(requireContext(),
                        getString(R.string.please_fill_the_palindrome_text_first), Toast.LENGTH_SHORT).show()
                } else {
                    val tvPalindrome = etPalindrome.text.toString()
                    if (isPalindrome(tvPalindrome)){
                        Toast.makeText(requireContext(),
                            getString(R.string.the_text_is_palindrome), Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(requireContext(),
                            getString(R.string.the_text_is_not_palindrome), Toast.LENGTH_SHORT).show()
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