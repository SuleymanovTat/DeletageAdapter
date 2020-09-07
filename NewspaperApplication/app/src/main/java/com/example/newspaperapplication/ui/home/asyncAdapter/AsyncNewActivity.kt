package com.example.newspaperapplication.ui.home.asyncAdapter

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.newspaperapplication.R
import com.example.newspaperapplication.ui.model.DiffItem
import com.example.newspaperapplication.ui.model.Man
import com.example.newspaperapplication.ui.model.Woman
import kotlinx.android.synthetic.main.activity_async_new.*
import java.util.*


class AsyncNewActivity : AppCompatActivity() {

    private lateinit var adapter: AsyncNewsAdapter
    private lateinit var currentItems: List<DiffItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_new)
        currentItems = mutableListOf()
        adapter = AsyncNewsAdapter()
        recyclerViewPeople.adapter = adapter
        btnAdd.setOnClickListener { addItems() }
        btnDelete.setOnClickListener { deleteItems() }
        btnUpdate.setOnClickListener { updateItems() }
        btnShuffleItems.setOnClickListener { shuffleItems() }
    }

    private fun updateItems() {
        val items: MutableList<DiffItem> = ArrayList(currentItems)
        try {
            val diffItem0 = items[0]
            if (diffItem0 is Woman) {
                val dog: Woman = diffItem0 as Woman
                items[0] = Woman(dog.id, dog.name.toString() + "Updated")
            } else if (diffItem0 is Man) {
                val cat: Man = diffItem0 as Man
                items[0] = Man(cat.id, cat.name.toString() + "Updated")
            }
            val diffItem3 = items[2]
            if (diffItem3 is Woman) {
                val dog: Woman = diffItem3 as Woman
                items[2] = Woman(dog.id, dog.name.toString() + "Updated")
            } else if (diffItem3 is Man) {
                val cat: Man = diffItem3 as Man
                items[2] = Man(cat.id, cat.name.toString() + "Updated")
            }
        } catch (e: java.lang.IndexOutOfBoundsException) {
            Toast.makeText(this, "Please add more items", Toast.LENGTH_SHORT).show()
        }
        currentItems = items
        adapter.items = currentItems
    }


    private fun addItems() {
        var items = mutableListOf<DiffItem>()
        items.addAll(currentItems)
        items.add(0, Man(Date().time, "Man ${Date().time}"))
        items.add(0, Woman(Date().time, "Woman ${Date().time}"))
        currentItems = items
        adapter!!.items = currentItems
    }

    private fun shuffleItems() {
        try {
            var items = mutableListOf<DiffItem>()
            items.addAll(currentItems)
            Collections.shuffle(items)
            currentItems = items
            adapter.items = currentItems
        } catch (ex: Exception) {
        }

    }

    private fun deleteItems() {
        var items = mutableListOf<DiffItem>()
        items.addAll(currentItems)
        try {
            items.removeAt(0)
        } catch (e: IndexOutOfBoundsException) {
            Toast.makeText(this, "Please add more items", Toast.LENGTH_SHORT).show()
        }
        currentItems = items
        adapter.items = currentItems
    }

}