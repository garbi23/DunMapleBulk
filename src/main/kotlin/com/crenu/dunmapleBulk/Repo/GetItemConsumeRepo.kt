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
    fun deleteItemConsumeByUserIds(userIds: List<String>) {
        val sql = "DELETE FROM item_consume WHERE userid = ?"

        jdbcTemplate.batchUpdate(sql, object : BatchPreparedStatementSetter {
            override fun setValues(ps: java.sql.PreparedStatement, i: Int) {
                ps.setString(1, userIds[i])
            }

            override fun getBatchSize(): Int = userIds.size
        })
    }
    fun updateItemConsumeList(dtoItems: List<GetItemConsumeDTO>) {
        val sql = "UPDATE item_consume SET usecount = ?, allcount = ? WHERE userid = ? AND itemname = ?"

        jdbcTemplate.batchUpdate(sql, object : BatchPreparedStatementSetter {
            override fun setValues(ps: java.sql.PreparedStatement, i: Int) {
                val dto = dtoItems[i]
                ps.setInt(1, dto.useCount)
                ps.setInt(2, dto.allCount)
                ps.setString(3, dto.userid)
                ps.setString(4, dto.itemName)
            }
            override fun getBatchSize(): Int = dtoItems.size
        })
    }
}
