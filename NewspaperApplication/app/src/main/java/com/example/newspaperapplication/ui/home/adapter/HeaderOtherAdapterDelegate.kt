package com.example.newspaperapplication.ui.home.adapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.newspaperapplication.R
import com.example.newspaperapplication.ui.model.Header
import com.example.newspaperapplication.ui.model.HeaderOther
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.jay.widget.StickyHeaders


class HeaderOtherAdapterDelegate(activity: Activity) : AdapterDelegate<List<Any>>() {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_header_other))

    }

    override fun isForViewType(items: List<Any>, position: Int): Boolean {
        return items[position] is HeaderOther
    }

    override fun onBindViewHolder(items: List<Any>, position: Int, holder: RecyclerView.ViewHolder,
                                  payloads: MutableList<Any>) {
        val vh = holder as ViewHolder
        val item = items[position] as HeaderOther
        vh.bind(item)
    }

    private inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var i = 0
        var textViewHeader = itemView.findViewById<TextView>(R.id.textViewHeader)
        var click = itemView.findViewById<ImageButton>(R.id.click)
        fun bind(header: HeaderOther) {
            textViewHeader.setText(header.title)
            textViewHeader.setOnClickListener {
                Log.e("my", "textViewHeader " + header.title)
            }
            click.setOnClickListener {
                Log.e("my", "click")
                textViewHeader.setText(header.title + i++)
            }

        }
    }
}

