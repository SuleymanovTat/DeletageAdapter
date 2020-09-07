package com.example.newspaperapplication.ui.home.adapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.newspaperapplication.R
import com.example.newspaperapplication.ui.model.Header
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.jay.widget.StickyHeaders


class HeaderAdapterDelegate(activity: Activity) : AdapterDelegate<List<Any>>() {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_header))

    }

    override fun isForViewType(items: List<Any>, position: Int): Boolean {
        return items[position] is Header
    }

    override fun onBindViewHolder(items: List<Any>, position: Int, holder: RecyclerView.ViewHolder,
                                  payloads: MutableList<Any>) {
        val vh = holder as ViewHolder
        val item = items[position] as Header
        vh.bind(item)
    }

    private inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textViewHeader = itemView.findViewById<TextView>(R.id.textViewHeader)
        fun bind(header: Header) {
            textViewHeader.setText(header.title)
            textViewHeader.setOnClickListener {
                Log.e("my", "textViewHeader " + header.title)
            }
        }
    }
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}
