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
    fun getNum(): Long? = num
    fun getTimeStamp(): LocalDateTime? = timeStamp
    fun getUserid(): String? = userid
    fun getNickName(): String? = nickName
    fun getItemName(): String? = itemName
    fun getUseCount(): Int? = useCount
    fun getAllCount(): Int? = allCount
}

fun GetItemConsumeEntity.toDTO(): GetItemConsumeDTO = GetItemConsumeDTO(
    num = this.getNum(),
    timeStamp = this.getTimeStamp() ?: LocalDateTime.now(),
    userid = this.getUserid() ?: "",
    nickName = this.getNickName(),
    itemName = this.getItemName(),
    useCount = this.getUseCount() ?: 0,
    allCount = this.getAllCount() ?: 0
)

