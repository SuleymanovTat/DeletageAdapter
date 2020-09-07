package com.example.newspaperapplication.ui.model

data class Header(var title: String? = null)
data class HeaderOther(var title: String? = null)
data class People(var name: String? = null)
data class Other(var name: String? = null)
data class Cat(var name: String? = null)
data class Snake(var name: String? = null)
data class Stories(var stories: MutableList<Story>? = null)

data class Story(var name: String? = null,
                 var decs: String? = null,
                 var image: String? = null)