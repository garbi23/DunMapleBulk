package com.crenu.dunmapleBulk.Data


import jakarta.persistence.*

@Entity
@Table(name = "scrollforce")
data class ScrollforceEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val num: Long,
    val timestamp: String? = null,
    val userid: String? = null,
    val nickname: String? = null,
    val itemname: String? = null,
    val scrollname: String? = null,
    val forcevalue: String? = null,
    val breakprevent: String? = null,
    val itemruid: String? = null
)