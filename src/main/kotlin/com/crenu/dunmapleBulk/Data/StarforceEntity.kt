package com.crenu.dunmapleBulk.Data

import jakarta.persistence.*

@Entity
@Table(name = "starforce")
data class StarforceEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val num: Long? = null,
    @Column
    val timestamp: String,
    val userid: String,
    val nickname: String?,
    val itemname: String?,
    val starcount: Int?,
    val forcevalue: String?,
    val breakprevent: String?,
    val itemruid: String?
)