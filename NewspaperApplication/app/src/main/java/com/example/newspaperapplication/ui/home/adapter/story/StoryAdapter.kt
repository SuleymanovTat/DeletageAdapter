package com.example.newspaperapplication.ui.home.adapter.story

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.newspaperapplication.R
import com.example.newspaperapplication.ui.home.adapter.inflate
import com.example.newspaperapplication.ui.model.Story
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate


class StoryAdapter() : AdapterDelegate<List<Any>>() {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_story))

    }

    override fun isForViewType(items: List<Any>, position: Int): Boolean {
        return items[position] is Story
    }

    override fun onBindViewHolder(items: List<Any>, position: Int, holder: RecyclerView.ViewHolder,
                                  payloads: MutableList<Any>) {
        val vh = holder as ViewHolder
        val item = items[position] as Story
        vh.bind(item)
    }

    private inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textViewName = itemView.findViewById<TextView>(R.id.textViewName)
        var textViewDecs = itemView.findViewById<TextView>(R.id.textViewDecs)
        var imageView = itemView.findViewById<ImageView>(R.id.imageView)

        fun bind(story: Story) {
            textViewName.setText(story.name)
            textViewDecs.setText(story.decs)
            imageView.load(story.image) {
                transformations(CircleCropTransformation())
            }

        }
    }
}