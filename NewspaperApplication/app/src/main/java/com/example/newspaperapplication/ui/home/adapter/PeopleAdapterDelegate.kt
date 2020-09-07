package com.example.newspaperapplication.ui.home.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newspaperapplication.R
import com.example.newspaperapplication.ui.model.People
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate


class PeopleAdapterDelegat(activity: Activity) : AdapterDelegate<List<Any>>() {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_people))

    }

    override fun isForViewType(items: List<Any>, position: Int): Boolean {
        return items[position] is People
    }

    override fun onBindViewHolder(items: List<Any>, position: Int, holder: RecyclerView.ViewHolder,
                                  payloads: MutableList<Any>) {
        val vh = holder as ViewHolder
        val item = items[position] as People
        vh.bind(item)
    }

    private inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textViewPeople = itemView.findViewById<TextView>(R.id.textViewPeople)
        fun bind(header: People) {
            textViewPeople.setText(header.name)
        }
    }
}
