package com.crenu.dunmapleBulk.Service

import com.crenu.dunmapleBulk.Data.PurchasedCoinitemDTO
import com.crenu.dunmapleBulk.Repo.PurchasedCoinitemRepo
import org.springframework.stereotype.Service

@Service
class PurchasedCoinitemService(private val purchasedCoinitemRepo: PurchasedCoinitemRepo) {
    fun insertPurchasedCoinitemList(dtoItems: List<PurchasedCoinitemDTO>) {
        purchasedCoinitemRepo.insertPurchasedCoinitemList(dtoItems)
    }
}