package com.example.addremoveitem.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.addremoveitem.Data.Item
import com.example.addremoveitem.R
import com.example.addremoveitem.base.BaseFragment
import com.example.addremoveitem.databinding.FragmentUpdateDeleteBinding


class UpdateDeleteFragment : BaseFragment<FragmentUpdateDeleteBinding>(FragmentUpdateDeleteBinding::inflate) {
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
    private fun listener(){
        binding.backBtn.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }
    }
}