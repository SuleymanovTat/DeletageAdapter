package com.example.newspaperapplication.ui.home.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newspaperapplication.R
import com.example.newspaperapplication.ui.home.adapter.story.MainStoryAdapter
import com.example.newspaperapplication.ui.model.Stories
import com.example.newspaperapplication.ui.model.Story
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate


class StoryListAdapter() : AdapterDelegate<List<Any>>() {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_recyclerview))

    }

    override fun isForViewType(items: List<Any>, position: Int): Boolean {
        return items[position] is Stories
    }

    override fun onBindViewHolder(items: List<Any>, position: Int, holder: RecyclerView.ViewHolder,
                                  payloads: MutableList<Any>) {
        val vh = holder as ViewHolder
        val item = items[position] as Stories
        vh.bind(item.stories)
    }

    private inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var recyclerView = itemView.findViewById<RecyclerView>(R.id.recyclerView)
        fun bind(stories: List<Story>?) {
            val adapter = MainStoryAdapter()
            recyclerView.adapter = adapter
            adapter.items = stories
        }
    }
}