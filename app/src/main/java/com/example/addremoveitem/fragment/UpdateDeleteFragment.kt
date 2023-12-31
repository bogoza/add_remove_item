package com.example.addremoveitem.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.addremoveitem.Data.Item
import com.example.addremoveitem.R
import com.example.addremoveitem.base.BaseFragment
import com.example.addremoveitem.databinding.FragmentUpdateDeleteBinding
import com.example.addremoveitem.view_model.ItemViewModel


class UpdateDeleteFragment : BaseFragment<FragmentUpdateDeleteBinding>(FragmentUpdateDeleteBinding::inflate) {
    private val viewModel: ItemViewModel by activityViewModels()
    private lateinit var item: Item
    override fun start() {
        getItem()
        listener()
    }

    private fun getItem()= with(binding){
        val args:UpdateDeleteFragmentArgs by navArgs()
        item = args.Item
        itemTv.text = args.Item.title
        Glide
            .with(itemImage.context)
            .load(args.Item.image)
            .into(itemImage)
    }
    private fun listener() = with(binding){
        backBtn.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
        itemDeleteBtn.setOnClickListener {
            deleteItem()
            findNavController().navigate(R.id.homeFragment)
        }
        itemUpdateBtn.setOnClickListener {
            updateItem()
        }

    }
    private fun deleteItem(){
        viewModel.removeItem(item)
    }
    private fun updateItem()= with(binding){
       if (!updateImageEt.text.isNullOrEmpty() && !updateTitleEt.text.isNullOrEmpty()){
           viewModel.removeItem(item)
           viewModel.addItem(Item(image = updateImageEt.text.toString(), title = updateTitleEt.text.toString()))
           findNavController().navigate(R.id.homeFragment)
       }else{
           Toast.makeText(requireContext(),"Image name or title is blank", Toast.LENGTH_LONG).show()
       }

    }
}