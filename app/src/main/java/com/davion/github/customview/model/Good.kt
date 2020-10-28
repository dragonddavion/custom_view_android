package com.davion.github.customview.model

data class Good(
    override val id: Int,
    val name: String,
    val level: Int,
    val time: String,
) : BaseModel(id)