package com.example.addremoveitem.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.addremoveitem.Data.Item
import com.example.addremoveitem.R
import com.example.addremoveitem.base.BaseFragment
import com.example.addremoveitem.databinding.FragmentAddItemBinding
import com.example.addremoveitem.view_model.ItemViewModel


class AddItemFragment : BaseFragment<FragmentAddItemBinding>(FragmentAddItemBinding::inflate) {
    private val viewModel:ItemViewModel by activityViewModels()
    override fun start() {
        listener()
    }

    private fun listener()= with(binding){
        addItemBtn.setOnClickListener {
            if (!addImageEt.text.isNullOrEmpty() || !addTitleEt.text.isNullOrEmpty()){
                addItem()
                findNavController().navigate(R.id.homeFragment)
            }else{
                Toast.makeText(requireContext(),"Image name or title is blank",Toast.LENGTH_LONG).show()
            }
        }
        backBtn.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
    }

    private fun addItem() = with(binding){
        viewModel.addItem(Item(image = addImageEt.text.toString(), title = addTitleEt.text.toString()))
    }
}