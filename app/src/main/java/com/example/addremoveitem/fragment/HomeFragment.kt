package com.example.addremoveitem.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.addremoveitem.Data.Item
import com.example.addremoveitem.adapter.ItemListAdapter
import com.example.addremoveitem.base.BaseFragment
import com.example.addremoveitem.databinding.FragmentHomeBinding
import com.example.addremoveitem.view_model.ItemViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private var newItem: Item? = null
    private val itemViewModel: ItemViewModel by viewModels()
    private lateinit var adapter:ItemListAdapter

    override fun start() {
        drawRecycler()
        observe()
        listener()
    }

    private fun observe(){
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                itemViewModel.rvItemList.collect{
                    adapter.submitList(it)
                }
            }
        }
    }
    private fun drawRecycler(){
        adapter = ItemListAdapter()
        binding.homeRv.layoutManager = GridLayoutManager(requireContext(),2)
        binding.homeRv.adapter = adapter
    }


    fun listener(){
        binding.addBtn.setOnClickListener {

        }
    }
}