package com.davion.github.customview.screen.main

import com.davion.github.customview.model.BaseModel

data class Screen(
    override var id: Int = -1,
    var name: String = "Screen",
    var description: String = "The head of layout that provide more detail"
) : BaseModel(id)