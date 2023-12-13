package com.crenu.dunmapleBulk.Repo

import com.crenu.dunmapleBulk.Data.ScrollforceDTO
import jakarta.transaction.Transactional
import org.springframework.jdbc.core.BatchPreparedStatementSetter
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.PreparedStatement
import java.sql.SQLException

@Repository
class ScrollforceRepo(private val jdbcTemplate: JdbcTemplate) {
    @Transactional
    fun insertScrollforceList(dtoItems: List<ScrollforceDTO>) {
        val sql =
            "INSERT INTO scrollforce (timestamp, userid, nickname, itemname, scrollname, forcevalue, breakprevent, itemruid) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
        jdbcTemplate.batchUpdate(sql, object : BatchPreparedStatementSetter {
            @Throws(SQLException::class)
            override fun setValues(ps: PreparedStatement, i: Int) {
                val (timestamp, userid, nickName, itemName, scrollName, forceValue, breakPrevent, itemRuid) = dtoItems[i]
                ps.setString(1, timestamp)
                ps.setString(2, userid)
                ps.setString(3, nickName)
                ps.setString(4, itemName)
                ps.setString(5, scrollName)
                ps.setString(6, forceValue)
                ps.setString(7, breakPrevent)
                ps.setString(8, itemRuid)
            }

            override fun getBatchSize(): Int {
                return dtoItems.size
            }
        })
    }
}
