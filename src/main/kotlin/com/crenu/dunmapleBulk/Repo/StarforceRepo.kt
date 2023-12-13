package com.crenu.dunmapleBulk.Repo

import com.crenu.dunmapleBulk.Data.StarforceDTO
import jakarta.transaction.Transactional
import org.springframework.jdbc.core.BatchPreparedStatementSetter
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.PreparedStatement
import java.sql.SQLException

@Repository
class StarforceRepo(private val jdbcTemplate: JdbcTemplate) {
    @Transactional
    fun insertStarforceList(dtoItems: List<StarforceDTO>) {
        val sql =
            "INSERT INTO starforce (timestamp, userid, nickname, itemname, starcount, forcevalue, breakprevent, itemruid)VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
        jdbcTemplate.batchUpdate(sql, object : BatchPreparedStatementSetter {
            @Throws(SQLException::class)
            override fun setValues(ps: PreparedStatement, i: Int) {
                val (timestamp, userid, nickname, itemname, starcount, forcevalue, breakprevent, itemruid) = dtoItems[i]
                ps.setString(1, timestamp)
                ps.setString(2, userid)
                ps.setString(3, nickname)
                ps.setString(4, itemname)
                ps.setInt(5, starcount ?: 0)
                ps.setString(6, forcevalue)
                ps.setString(7, breakprevent)
                ps.setString(8, itemruid)
            }

            override fun getBatchSize(): Int {
                return dtoItems.size
            }
        })
    }
}
