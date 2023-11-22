package com.crenu.dunmapleBulk.Data

import java.time.LocalDateTime

data class GetItemConsumeDTO(
    val num: Long?,
    val timeStamp: LocalDateTime,
    val userid: String,
    val nickName: String?,
    val itemName: String?,
    val useCount: Int,
    val allCount: Int
)
