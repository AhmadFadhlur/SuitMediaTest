package com.example.suitmediatest.ui.thirdscreen.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.suitmediatest.databinding.LoadStateUserBinding

class LoadStateUserAdapter (private val retry: () -> Unit) : LoadStateAdapter<LoadStateUserAdapter.LoadingStateViewHolder>() {
    class LoadingStateViewHolder( private val binding : LoadStateUserBinding, retry: () -> Unit) :
        RecyclerView.ViewHolder(binding.root){

        fun bind (loadState: LoadState){
            if (loadState is LoadState.Error){
                binding.errorMsg.text = loadState.error.localizedMessage
            }
            binding.pbLoadStateStory.isVisible = loadState is LoadState.Loading
            binding.retryButton.isVisible = loadState is LoadState.Error
            binding.errorMsg.isVisible = loadState is LoadState.Error

            if (loadState.endOfPaginationReached){
                binding.errorMsg.text = "End Of Page"
                binding.errorMsg.isVisible = loadState is LoadState.Error
            }

        }
    }

    override fun onBindViewHolder(holder: LoadingStateViewHolder, loadState: LoadState) = holder.bind(loadState)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): LoadingStateViewHolder =
        LoadingStateViewHolder(LoadStateUserBinding.inflate(LayoutInflater.from(parent.context),parent,false),retry)


}