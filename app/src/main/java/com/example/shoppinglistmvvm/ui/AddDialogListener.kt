package com.example.shoppinglistmvvm.ui

import com.example.shoppinglistmvvm.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)

}