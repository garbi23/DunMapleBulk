package com.crenu.dunmapleBulk.Data

import jakarta.persistence.*

@Entity
@Table(name = "purchasedcoinitem")
class PurchasedCoinItemEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val num: Long?,
    @Column
    val timestamp: String,
    val userid: String,
    val nickname: String?,
    val itemname: String?,
    val purchaseCount: Int?,
    val coinType: String?,
    val allcount: Int?,
    val usecount: Int?
)