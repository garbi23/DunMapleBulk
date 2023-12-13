package com.crenu.dunmapleBulk.Data

data class StarforceDTO(
    val timestamp: String,
    val userid: String,
    val nickname: String?,
    val itemname: String?,
    val starcount: Int?,
    val forcevalue: String?,
    val breakprevent: String?,
    val itemruid: String?
)