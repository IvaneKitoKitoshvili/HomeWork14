package com.kito.homework14

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kito.homework14.databinding.BuildingItemBinding

class BuildingAdapter() : RecyclerView.Adapter<BuildingAdapter.UserViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Content.BuildingModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    private var list: List<Content.BuildingModel> = listOf()

    class UserViewHolder(val binding: BuildingItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind (model: Content.BuildingModel){
            Glide.with(binding.ivBuilding.context).load(model.cover)
                .placeholder(R.drawable.ic_launcher_background).into(binding.ivBuilding)
            binding.tvDescription.text = "${model.titleKA}\n\n${model.descriptionKA}\n\n${model.publishDate}"
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding =
            BuildingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val building = list[position]
        holder.bind(building)

    }

    override fun getItemCount() = list.size


}