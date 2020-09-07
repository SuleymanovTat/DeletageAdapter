package com.example.newspaperapplication.ui.home.adapter

import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.view.ViewCompat
import com.example.newspaperapplication.R
import com.example.newspaperapplication.ui.model.Cat
import com.example.newspaperapplication.ui.model.Header
import com.example.newspaperapplication.ui.model.HeaderOther
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegate
import com.jay.widget.StickyHeaders


class MainListAdapter(activity: Activity, val onClickAnimal: onClickAnimal? = null) : ListDelegationAdapter<List<Any>>(), (Cat) -> Unit, StickyHeaders, StickyHeaders.ViewSetup {

    init {
        delegatesManager.addDelegate(HeaderAdapterDelegate(activity))
        delegatesManager.addDelegate(HeaderOtherAdapterDelegate(activity))
        delegatesManager.addDelegate(PeopleAdapterDelegat(activity))
        delegatesManager.addDelegate(catAdapterDelegate(this))
        delegatesManager.addDelegate(SnakeAdapterDelegate(activity))
        delegatesManager.addDelegate(StoryListAdapter())
        delegatesManager.setFallbackDelegate(OtherAdapterDelegat(activity))
    }

    override fun invoke(cat: Cat) {
        onClickAnimal?.onClickCat(cat)
        Log.e("my", "cat ${cat.name}")
    }

    override fun isStickyHeader(p0: Int): Boolean {
        return if (getItems().get(p0) is Header || getItems().get(p0) is HeaderOther) {
            Log.e("my", "h true")
            true
        } else {
            Log.e("my", "h false")
            false
        }
    }

    override fun setupStickyHeaderView(stickyHeader: View?) {
        ViewCompat.setElevation(stickyHeader!!, 10f)
    }

    override fun teardownStickyHeaderView(stickyHeader: View?) {
        ViewCompat.setElevation(stickyHeader!!, 0f)
    }

    fun remove() {
//        getItems()[9] = HeaderOther("HeaderOther 2222")

//        notifyItemChanged(9)

//        items.get(9) = Header()
//        items.add(position, item)
//        notifyItemChanged(position)
    }
}

fun catAdapterDelegate(itemClickedListener: (Cat) -> Unit) = adapterDelegate<Cat, Any>(R.layout.item_cat) {


    val name: TextView = findViewById(R.id.textViewName)
    name.setOnClickListener {
        itemClickedListener(item)
    }

    bind { list ->
        name.text = item.name // Item is of type Cat and is the current bound item.
    }
}

interface onClickAnimal {
    fun onClickCat(cat: Cat)
}

