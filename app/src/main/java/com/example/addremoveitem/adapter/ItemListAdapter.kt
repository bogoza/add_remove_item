package com.example.addremoveitem.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.addremoveitem.Data.Item
import com.example.addremoveitem.R
import com.example.addremoveitem.databinding.ItemRvBinding


class ItemListAdapter:ListAdapter<Item,ItemListAdapter.ItemViewHolder>(ItemDiff()){
    class ItemDiff:DiffUtil.ItemCallback<Item>(){
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }
    private var onItemClickListener:((items:Item) ->Unit)? = null
    fun setOnItemClickListener(listener:(items:Item) -> Unit){
        onItemClickListener = listener
    }

    inner class ItemViewHolder(private val binding:ItemRvBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind() = with(binding){
            val position = currentList[adapterPosition]
            rvTv.text = position.title
            Glide
                .with(root.context)
                .load(position.image)
                .centerCrop()
                .placeholder(R.drawable.ic_default)
                .into(rvImage)
        }
        fun listener(){
            val item = currentList[adapterPosition]

            binding.root.setOnClickListener {
                onItemClickListener?.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemRvBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind()
        holder.listener()
    }
}