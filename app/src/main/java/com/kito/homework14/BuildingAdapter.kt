package com.kito.homework14

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kito.homework14.databinding.BuildingItemBinding

class BuildingAdapter() : RecyclerView.Adapter<BuildingAdapter.UserViewHolder>() {
    private var list: MutableList<BuildingModel> = mutableListOf()

    class UserViewHolder(val binding: BuildingItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            BuildingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val building = list[position]

    }

    override fun getItemCount() = buildingList.size


}