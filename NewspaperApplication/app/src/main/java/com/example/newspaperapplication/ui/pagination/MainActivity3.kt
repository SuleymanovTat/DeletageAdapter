package com.example.newspaperapplication.ui.pagination

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.PagedList.BoundaryCallback
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newspaperapplication.R
import com.example.newspaperapplication.ui.home.adapter.inflate
import com.example.newspaperapplication.ui.home.asyncAdapter.manAdapterDelegate
import com.example.newspaperapplication.ui.home.asyncAdapter.womanAdapterDelegate
import com.example.newspaperapplication.ui.model.DiffItem
import com.hannesdorfmann.adapterdelegates4.AbsFallbackAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager
import com.hannesdorfmann.adapterdelegates4.paging.PagedListDelegationAdapter


class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val delegatesManager: AdapterDelegatesManager<List<DiffItem>> = AdapterDelegatesManager<List<DiffItem>>()
                .addDelegate(manAdapterDelegate({}))
                .addDelegate(womanAdapterDelegate({ }))
                .setFallbackDelegate(LoadingAdapterDelegate())

        val adapter: PagedListDelegationAdapter<DiffItem> = PagedListDelegationAdapter<DiffItem>(delegatesManager, callback)
        recyclerView.adapter = adapter


        val pagedListLiveData: LiveData<PagedList<DiffItem>> = LivePagedListBuilder(SampleDataSource.Factory(), 20)
                .setBoundaryCallback(object : BoundaryCallback<DiffItem>() {
                    override fun onZeroItemsLoaded() {
                        Log.d("PaginationSource", "onZeroItemsLoaded")
                        super.onZeroItemsLoaded()
                    }

                    override fun onItemAtFrontLoaded(itemAtFront: DiffItem) {
                        Log.d("PaginationSource", "onItemAtFrontLoaded $itemAtFront")
                        super.onItemAtFrontLoaded(itemAtFront)
                    }

                    override fun onItemAtEndLoaded(itemAtEnd: DiffItem) {
                        Log.d("PaginationSource", "onItemAtEndLoaded $itemAtEnd")
                        super.onItemAtEndLoaded(itemAtEnd)
                    }
                })
                .build()

        pagedListLiveData.observe(this, object : Observer<PagedList<DiffItem>?> {
            override fun onChanged(displayableItems: PagedList<DiffItem>?) {
                adapter.submitList(displayableItems)
            }
        })
    }


    private val callback: DiffUtil.ItemCallback<DiffItem> = object : DiffUtil.ItemCallback<DiffItem>() {
        override fun areItemsTheSame(oldItem: DiffItem, newItem: DiffItem): Boolean {
            return if (oldItem === newItem || oldItem.equals(newItem)) true else oldItem.javaClass.kotlin.equals(newItem.javaClass.kotlin)
        }

        override fun areContentsTheSame(oldItem: DiffItem, newItem: DiffItem): Boolean {
            // TODO implement that properly
            return false
        }
    }
}

class LoadingAdapterDelegate : AbsFallbackAdapterDelegate<List<DiffItem>>() {


    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_loading))
    }

    override fun onBindViewHolder(items: List<DiffItem>, position: Int, holder: RecyclerView.ViewHolder, payloads: MutableList<Any>) {
        val vh = holder as ViewHolder
    }

    private inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }
}