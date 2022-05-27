package com.example.paginationwithpaging3library.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paginationwithpaging3library.databinding.ItemDataBinding
import com.example.paginationwithpaging3library.model.Data
import com.squareup.picasso.Picasso

class Paging3Adapter : PagingDataAdapter<Data, Paging3Adapter.ViewHolder>(MyDiffUtil()) {

    inner class ViewHolder(val itemDataBinding: ItemDataBinding) : RecyclerView.ViewHolder(itemDataBinding.root){
        fun onBind(data: Data?){
            itemDataBinding.apply {
                Picasso.get().load(data?.avatar).into(ivAvatar)
                tvFullname.text = "${data?.firstName} ${data?.lastName}"
                tvEmail.text = data?.email
            }
        }
    }

    class MyDiffUtil : DiffUtil.ItemCallback<Data>(){
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}