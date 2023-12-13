package com.crenu.dunmapleBulk.Data


data class GetItemConsumeDTO(
    val timestamp: String,
    val userid: String,
    val nickName: String?,
    val itemName: String?,
    val useCount: Int,
    val allCount: Int
)

