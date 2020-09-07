package com.example.newspaperapplication.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.newspaperapplication.R
import com.example.newspaperapplication.ui.home.adapter.MainListAdapter
import com.example.newspaperapplication.ui.home.adapter.onClickAnimal
import com.example.newspaperapplication.ui.home.asyncAdapter.AsyncNewActivity
import com.example.newspaperapplication.ui.model.*
import com.example.newspaperapplication.ui.pagination.MainActivity3
import com.jay.widget.StickyHeadersLinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment(), onClickAnimal {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView = root.findViewById<TextView>(R.id.text_home)
        val mRecyclerView = root.findViewById<RecyclerView>(R.id.mRecyclerView)
        val list = mutableListOf<Any>()
        val stories = mutableListOf<Story>()
        stories.add(Story("Истории 1", "Это вторая часть цикла статей ", "https://miro.medium.com/max/1400/1*kd62ng52rNTY9KIgFJ8CHA.png"))
        stories.add(Story("Истории 2", "Это вторая часть цикла статей ", "https://www.talkwalker.com/images/2020/blog-headers/image-analysis.png"))
        stories.add(Story("Истории 3", "Это вторая часть цикла статей ", "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg"))
        stories.add(Story("Истории 4", "Это вторая часть цикла статей ", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQGMf5RLsxY1VKguLz-6s6bhYUkC3xWrAmG3Q&usqp=CAU"))
        stories.add(Story("Истории 5", "Это вторая часть цикла статей ", "https://i.pinimg.com/236x/6b/cb/e1/6bcbe10420ae10b82b550b3d4adeb13e--sunset-pictures-pretty-pictures.jpg"))
        list.add(Header("Истории"))
        list.add(Stories(stories))
        list.add(Header("Header 1"))
        list.add(People("Kamil 1"))
        list.add(People("Kamil 2"))
        list.add(People("Kamil 3"))
        list.add(People("Kamil 4"))
        list.add(People("Kamil 4"))
        list.add(People("Kamil 4"))
        list.add(HeaderOther("HeaderOther"))
        list.add(People("Kamil 4"))
        list.add(People("Kamil 4"))
        list.add(People("Kamil 4"))
        list.add(Header("Header 2"))
        list.add(People("Sasha 4"))
        list.add(Header("Header 3"))
        list.add(Other("Header 3"))
        list.add(Cat("Cat 1"))
        list.add(Cat("Cat 2"))
        list.add(Cat("Cat 3"))
        list.add(Other("Header 3"))
        list.add(Snake("Snake 1"))
        list.add(People("Kamil 3"))
        list.add(People("Kamil 4"))
        list.add(Header("Header 2"))
        list.add(People("Sasha 4"))
        list.add(Header("Header 3"))
        val adapter = MainListAdapter(requireActivity(), this)
        val layoutManager = StickyHeadersLinearLayoutManager<MainListAdapter>(activity)
        mRecyclerView.layoutManager = layoutManager
        mRecyclerView.adapter = adapter
        adapter.items = list
        root.deleteAdd.setOnClickListener {
            list.removeAt(9)
            list.add(9, HeaderOther("New"))
            adapter.items = list
            adapter.notifyDataSetChanged()
        }
        return root
    }

    override fun onClickCat(cat: Cat) {
//        startActivity(Intent(activity, AsyncNewActivity::class.java))
        startActivity(Intent(activity, MainActivity3::class.java))
    }
}
