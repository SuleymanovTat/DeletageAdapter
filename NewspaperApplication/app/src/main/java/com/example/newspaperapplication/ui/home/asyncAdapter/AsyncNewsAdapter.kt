package com.example.newspaperapplication.ui.home.asyncAdapter

import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import com.example.newspaperapplication.R
import com.example.newspaperapplication.ui.model.Cat
import com.example.newspaperapplication.ui.model.DiffItem
import com.example.newspaperapplication.ui.model.Man
import com.example.newspaperapplication.ui.model.Woman
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate


class AsyncNewsAdapter : AsyncListDifferDelegationAdapter<DiffItem>(DIFF_CALLBACK) {

    init {
        delegatesManager
                .addDelegate(manAdapterDelegate({}))
                .addDelegate(womanAdapterDelegate({ }))
    }

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<DiffItem> = object : DiffUtil.ItemCallback<DiffItem>() {
            override fun areItemsTheSame(oldItem: DiffItem, newItem: DiffItem): Boolean {
                return oldItem.getItemId() == newItem.getItemId()
            }

            override fun areContentsTheSame(oldItem: DiffItem, newItem: DiffItem): Boolean {
                return oldItem.getItemHash() == newItem.getItemHash()
            }
        }
    }
}

fun manAdapterDelegate(itemClickedListener: (Man) -> Unit) = adapterDelegate<Man, DiffItem>(R.layout.item_man) {


    val name: TextView = findViewById(R.id.textViewName)

    bind { list ->
        name.text = item.name
    }
}

fun womanAdapterDelegate(itemClickedListener: (Woman) -> Unit) = adapterDelegate<Woman, DiffItem>(R.layout.item_woman) {

    val name: TextView = findViewById(R.id.textViewName)

    bind { list ->
        name.text = item.name
    }
}