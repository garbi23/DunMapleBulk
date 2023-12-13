package com.crenu.dunmapleBulk.Data

import java.sql.Timestamp

data class PurchasedCoinitemDTO(
    val timestamp: String,
    val userid: String,
    val nickname: String?,
    val itemname: String?,
    val purchaseCount: Int?,
    val coinType: String?,
    val allcount: Int?,
    val usecount: Int?
)
