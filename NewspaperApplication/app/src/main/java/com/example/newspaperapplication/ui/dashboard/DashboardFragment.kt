package com.example.newspaperapplication.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.newspaperapplication.R

class DashboardFragment : Fragment() {
    private var dashboardViewModel: DashboardViewModel? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        //        val mRecyclerView = root.findViewById<RecyclerView>(R.id.mRecyclerView)
//        val list = mutableListOf<Any>()
//        list.add(Header("Header 1"))
//        list.add(Header("Header 2"))
//        list.add(Header("Header 3"))
//        val adapter = MainListAdapter(requireActivity())
//        mRecyclerView.adapter = adapter
//        adapter.items = list
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}