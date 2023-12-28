package com.example.suitmediatest.ui.thirdscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.suitmediatest.R
import com.example.suitmediatest.databinding.FragmentSecondScreenBinding
import com.example.suitmediatest.databinding.FragmentThirdScreenBinding
import com.example.suitmediatest.ui.secondscreen.SecondScreenFragmentArgs
import com.example.suitmediatest.ui.thirdscreen.adapter.LoadStateUserAdapter
import com.example.suitmediatest.ui.thirdscreen.adapter.UserAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ThirdScreenFragment : Fragment(R.layout.fragment_third_screen) {

    private val navArgs : ThirdScreenFragmentArgs by navArgs()
    private val binding by viewBinding(FragmentThirdScreenBinding::bind)
    private lateinit var userAdapter: UserAdapter
    private val thirdScreenViewModel : ThirdScreenViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUserAdapter()
        observeDataUser()
    }

    private fun observeDataUser(){
        thirdScreenViewModel.getUser()
        thirdScreenViewModel.listUser.flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .onEach(userAdapter::submitData).launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun setUserAdapter() = with(binding){
        val username = navArgs.username.toString()
        userAdapter = UserAdapter(username)
        rvUser.adapter = userAdapter.withLoadStateFooter(footer = LoadStateUserAdapter{userAdapter.retry()})
        rvUser.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        userAdapter.addLoadStateListener {
            when (it.source.refresh){
                is LoadState.NotLoading ->{
                    binding.pbThirdScreen.visibility = View.GONE
                }
                is LoadState.Loading ->{
                    binding.pbThirdScreen.visibility = View.VISIBLE
                }
                is LoadState.Error->{
                    binding.pbThirdScreen.visibility = View.GONE
                }
            }
        }
    }
}