package com.example.newspaperapplication.ui.home.adapter.story

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class MainStoryAdapter() : ListDelegationAdapter<List<Any>>() {

    init {
        delegatesManager.addDelegate(StoryAdapter())
    }
}
