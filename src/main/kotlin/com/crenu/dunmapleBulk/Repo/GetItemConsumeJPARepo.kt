package com.crenu.dunmapleBulk.Repo

import com.crenu.dunmapleBulk.Data.GetItemConsumeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface GetItemConsumeJPARepo : JpaRepository<GetItemConsumeEntity, Long?> {
    fun findByUserid(userid: String): List<GetItemConsumeEntity>
    override fun findAll() : List<GetItemConsumeEntity>
}