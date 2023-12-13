package com.crenu.dunmapleBulk.Repo

import com.crenu.dunmapleBulk.Data.PurchasedCoinitemDTO
import org.springframework.jdbc.core.BatchPreparedStatementSetter
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.PreparedStatement
import java.sql.SQLException

@Repository
class PurchasedCoinitemRepo(private val jdbcTemplate: JdbcTemplate) {
    fun insertPurchasedCoinitemList(dtoItems: List<PurchasedCoinitemDTO>) {
        val sql =
            "INSERT INTO purchasedcoinitem (timestamp, userid, nickname, itemname, purchase_count, coin_type, allcount, usecount) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
        jdbcTemplate.batchUpdate(sql, object : BatchPreparedStatementSetter {
            @Throws(SQLException::class)
            override fun setValues(ps: PreparedStatement, i: Int) {
                val (timestamp, userid, nickname, itemname, purchaseCount, coinType, allcount, usecount) = dtoItems[i]
                ps.setString(1, timestamp)
                ps.setString(2, userid)
                ps.setString(3, nickname)
                ps.setString(4, itemname)
                ps.setInt(5, purchaseCount ?: 0)
                ps.setString(6, coinType)
                ps.setInt(7, allcount ?: 0)
                ps.setInt(8, usecount ?: 0)
            }

            override fun getBatchSize(): Int {
                return dtoItems.size
            }
        })
    }
}
