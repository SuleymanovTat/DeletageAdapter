package com.example.newspaperapplication.ui.model

interface DiffItem {
    fun getItemId(): Long
    fun getItemHash(): Int
}

data class Man(
        val id: Long? = null,
        val name: String? = null,
        val image: String? = null) : DiffItem {
    override fun getItemId(): Long {
        return id ?: 0
    }

    override fun getItemHash(): Int {
        return hashCode()
    }
}

data class Woman(
        val id: Long? = null,
        val name: String? = null,
        val image: String? = null) : DiffItem {
    override fun getItemId(): Long {
        return id ?: 0
    }

    override fun getItemHash(): Int {
        return hashCode()
    }
}
