package ir.magiccodes.wikipedia.adapter

import ir.magiccodes.wikipedia.data.ItemPost

interface ItemEvents {

    fun onItemClicked(itemPost: ItemPost)
}