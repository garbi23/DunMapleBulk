package com.crenu.dunmapleBulk.Data

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "getItemComsume")
class GetItemConsumeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val num: Long? = null

    @Column(name = "timeStamp", nullable = false)
    private val timeStamp: LocalDateTime? = null

    @Column(name = "userid", nullable = false)
    private val userid: String? = null

    @Column(name = "nickName")
    private val nickName: String? = null

    @Column(name = "itemName")
    private val itemName: String? = null

    @Column(name = "useCount")
    private val useCount: Int? = null

    @Column(name = "allCount")
    private val allCount: Int? = null

}