package com.example.addremoveitem.view_model


import androidx.lifecycle.ViewModel
import com.example.addremoveitem.Data.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow

class ItemViewModel:ViewModel() {
    private var _rvItemsList = MutableStateFlow(
        arrayListOf(
            Item(
                title = "Frist",
                image = "https://images.pexels.com/photos/405202/pexels-photo-405202.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
            ),
            Item(
                title = "Second",
                image = "https://images.pexels.com/photos/2454790/pexels-photo-2454790.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
            )
        )
    )
    val rvItemList: StateFlow<List<Item>> get() = _rvItemsList

    private var editDelete: Item? = null

    fun setData(item: Item)
    {
        editDelete = item
    }
    fun addItem(item:Item){
        _rvItemsList.value.add(item)
    }
    fun update(item: Item){
        _rvItemsList.value.remove(item)
        _rvItemsList.value.add(item)
    }
    fun removeItem(item:Item){
        _rvItemsList.value.remove(item)
    }

}
