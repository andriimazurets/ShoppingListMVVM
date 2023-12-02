package com.example.shoppinglistmvvm

import android.app.Application
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import com.example.shoppinglistmvvm.data.db.ShoppingDatabase

class ShoppingApplication: Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ShoppingApplication))
        bind () from singleton = { ShoppingDatabase(instance())}
    }
}