package com.crenu.dunmapleBulk.Controller

import com.crenu.dunmapleBulk.Data.GetItemConsumeDTO
import com.crenu.dunmapleBulk.Data.PurchasedCoinitemDTO
import com.crenu.dunmapleBulk.Data.ScrollforceDTO
import com.crenu.dunmapleBulk.Data.StarforceDTO
import com.crenu.dunmapleBulk.Service.GetItemConsumeService
import com.crenu.dunmapleBulk.Service.PurchasedCoinitemService
import com.crenu.dunmapleBulk.Service.ScrollforceService
import com.crenu.dunmapleBulk.Service.StarforceService
import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/items")
class ItemConsumeController(
    private val itemConsumeService: GetItemConsumeService, // Injecting the service through the constructor
    private val starforceService: StarforceService,
    private val scrollforceService: ScrollforceService,
    private val purchasedCoinitemService: PurchasedCoinitemService
) {
    @PostMapping("/getitemconsume")
    fun insertItemConsumeList(@RequestBody dtoItems: List<GetItemConsumeDTO>): ResponseEntity<*> {
        return try {
            itemConsumeService.insertItemConsumeList(dtoItems)
            ResponseEntity("Items successfully inserted into the database.", HttpStatus.OK)
        } catch (e: DataAccessException) {
            e.printStackTrace()
            ResponseEntity(
                "Failed to insert items into the database. Error: " + e.message,
                HttpStatus.INTERNAL_SERVER_ERROR
            )
        }
    }
    @PostMapping("/starforce")
    fun insertStarforceList(@RequestBody dtoItems: List<StarforceDTO>): ResponseEntity<String> {
        return try {
            starforceService.insertStarforceList(dtoItems)
            ResponseEntity.ok<String>("Data inserted successfully")
        } catch (e: java.lang.Exception) {
            ResponseEntity.status(500).body<String>("Error occurred: " + e.message)
        }
    }
    @PostMapping("/scrollforce")
    fun insertScrollforceList(@RequestBody dtoItems: List<ScrollforceDTO>): ResponseEntity<String> {
        return try {
            scrollforceService.insertScrollforceList(dtoItems)
            ResponseEntity.ok<String>("Data inserted successfully")
        } catch (e: java.lang.Exception) {
            ResponseEntity.status(500).body<String>("Error occurred: " + e.message)
        }
    }
    @PostMapping("/purchasedcoinitem")
    fun insertPurchasedCoinitemList(@RequestBody dtoItems: List<PurchasedCoinitemDTO>): ResponseEntity<String> {
        return try {
            purchasedCoinitemService.insertPurchasedCoinitemList(dtoItems)
            ResponseEntity.ok<String>("Data inserted successfully")
        } catch (e: java.lang.Exception) {
            ResponseEntity.status(500).body<String>("Error occurred: " + e.message)
        }
    }
}