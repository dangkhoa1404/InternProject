package com.example.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.network.response.Item
import com.example.internprojectapplication.databinding.ListItemCustomBinding

class MainAdapter(
    private var listener: MainAdapterInterface,
    private var listItems: List<Item>
) : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    interface MainAdapterInterface {
        fun deleteItem(item: Item)
        fun updateItem(item: Item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ListItemCustomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(listItems[position], listener)
    }

    override fun getItemCount(): Int = listItems.size

    class MyViewHolder(
        private val binding: ListItemCustomBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(
            items: Item,
            listener: MainAdapterInterface
        ) {
            binding.run {
                items.run {
                    tvMinimumIDR.text = rangeMinimum.toString()
                    tvMaximumIDR.text = rangeMaximum.toString()
                    tvNumberOfApproval.text = numberOfApproval.toString()
                    llContainer.setOnClickListener {
                        listener.updateItem(items)
                    }
                    llContainer.setOnLongClickListener {
                        listener.deleteItem(items)
                        true
                    }
                }
            }
        }
    }
}