package com.crenu.dunmapleBulk.Repo

import com.crenu.dunmapleBulk.Data.GetItemConsumeDTO
import org.springframework.jdbc.core.BatchPreparedStatementSetter
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class GetItemConsumeRepo(
    private val jdbcTemplate: JdbcTemplate
) {
    fun sendItemConsumeList(dtoItems: List<GetItemConsumeDTO>): List<GetItemConsumeDTO> {
        return dtoItems
    }
    fun insertItemConsumeList(dtoItems: List<GetItemConsumeDTO>) {
        val sql = "INSERT INTO item_consume (timestamp, userid, nickname, itemname, usecount, allcount) VALUES (?, ?, ?, ?, ?, ?)"

        jdbcTemplate.batchUpdate(sql, object : BatchPreparedStatementSetter {
            override fun setValues(ps: java.sql.PreparedStatement, i: Int) {
                val dto = dtoItems[i]
                ps.setTimestamp(1, java.sql.Timestamp.valueOf(dto.timeStamp))
                ps.setString(2, dto.userid)
                ps.setString(3, dto.nickName)
                ps.setString(4, dto.itemName)
                ps.setInt(5, dto.useCount)
                ps.setInt(6, dto.allCount)
            }
            override fun getBatchSize(): Int = dtoItems.size
        })
    }
}
