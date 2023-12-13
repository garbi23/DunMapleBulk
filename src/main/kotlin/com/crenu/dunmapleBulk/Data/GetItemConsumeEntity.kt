package com.crenu.dunmapleBulk.Data

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "getitemconsume")
class GetItemConsumeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val num: Long = 0

    @Column(name = "timestamp", nullable = false)
    val timestamp: String? = null

    @Column(name = "userid", nullable = false)
    val userid: String? = null

    @Column(name = "nickName")
    val nickname: String? = null

    @Column(name = "itemName")
    val itemname: String? = null

    @Column(name = "useCount")
    val usecount: Int? = null

    @Column(name = "allCount")
    val allCount: Int? = null
}

