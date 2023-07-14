package com.example.suitmediatest.ui.thirdscreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.suitmediatest.databinding.ListItemUserBinding
import com.example.suitmediatest.network.model.user.DataItem
import com.example.suitmediatest.ui.secondscreen.SecondScreenFragmentArgs
import com.example.suitmediatest.ui.thirdscreen.ThirdScreenFragmentDirections

class UserAdapter (var username: String): PagingDataAdapter<DataItem, UserAdapter.ViewHolder>(callback) {

    companion object {
        val callback = object : DiffUtil.ItemCallback<DataItem>() {
            override fun areItemsTheSame(
                oldItem: DataItem,
                newItem: DataItem
            ): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: DataItem,
                newItem: DataItem
            ): Boolean =
                oldItem == newItem
        }
    }

    class ViewHolder(private val binding : ListItemUserBinding, private var username: String) :RecyclerView.ViewHolder(binding.root){
        fun bind (item : DataItem){
            binding.apply {
                tvFirstName.text = item.firstName
                tvLastName.text = item.lastName
                tvEmail.text = item.email
                Glide.with(itemView.context).load(item.avatar).into(imgAvatar)
            }
            val userSelectedName = "${item.firstName} ${item.lastName}"
            itemView.setOnClickListener {
                val action = ThirdScreenFragmentDirections.actionThirdScreenFragmentToSecondScreenFragment(username ,userSelectedName)
                it.findNavController().navigate(action)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val data = getItem(position)
        if (data != null) holder.bind(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ListItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false), username)
}