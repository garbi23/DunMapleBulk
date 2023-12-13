package com.crenu.dunmapleBulk.Repo

import com.crenu.dunmapleBulk.Data.GetItemConsumeDTO
import org.springframework.jdbc.core.BatchPreparedStatementSetter
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.PreparedStatement
import java.sql.SQLException

@Repository
class GetItemConsumeRepo(private val jdbcTemplate: JdbcTemplate) {
    fun insertItemConsumeList(dtoItems: List<GetItemConsumeDTO>) {
        val sql =
            "INSERT INTO getitemconsume (timestamp, userid, nickname, itemname, usecount, allcount) VALUES (?, ?, ?, ?, ?, ?)"
        try {
            jdbcTemplate.batchUpdate(sql, object : BatchPreparedStatementSetter {
                @Throws(SQLException::class)
                override fun setValues(ps: PreparedStatement, i: Int) {
                    val (timestamp, userid, nickName, itemName, useCount, allCount) = dtoItems[i]
                    // Assuming timestamp is a String representing a valid datetime format.
                    // Convert it to java.sql.Timestamp or java.time.LocalDateTime if necessary
                    ps.setString(1, timestamp)
                    ps.setString(2, userid)
                    ps.setString(3, nickName)
                    ps.setString(4, itemName)
                    ps.setInt(5, useCount)
                    ps.setInt(6, allCount)
                }

                override fun getBatchSize(): Int {
                    return dtoItems.size
                }
            })
        } catch (e: Exception) {
            // Log the exception or handle it as required
            throw RuntimeException("Error inserting data: " + e.message, e)
        }
    }
}
