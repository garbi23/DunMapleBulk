package com.crenu.dunmapleBulk.Controller

import com.crenu.dunmapleBulk.Data.GetItemConsumeDTO
import com.crenu.dunmapleBulk.Service.ItemConsumeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/item-consume")
class ItemConsumeController(private val itemConsumeService: ItemConsumeService) {

    @GetMapping("/get-data")
    fun getData(): ResponseEntity<List<GetItemConsumeDTO>> {
        return ResponseEntity.ok(itemConsumeService.getData())
    }

    @PostMapping("/create")
    fun createItemConsume(@RequestBody newItemConsumeData: List<GetItemConsumeDTO>): ResponseEntity<String> {
        itemConsumeService.createItemConsume(newItemConsumeData)
        return ResponseEntity.ok("Created new item consume records")
    }


    @DeleteMapping("/delete")
    fun deleteItemConsume(@RequestBody userIds: List<String>): ResponseEntity<String> {
        itemConsumeService.deleteItemConsume(userIds)
        return ResponseEntity.ok("Deleted items for user IDs: ${userIds.joinToString()}")
    }

    @PutMapping("/update")
    fun updateItemConsume(@RequestBody dtoItems: List<GetItemConsumeDTO>): ResponseEntity<String> {
        itemConsumeService.updateItemConsume(dtoItems)
        return ResponseEntity.ok("Updated items")
    }

    @GetMapping("/by-userid/{userid}")
    fun getByUserid(@PathVariable userid: String): ResponseEntity<List<GetItemConsumeDTO>> {
        return ResponseEntity.ok(itemConsumeService.getByUserid(userid))
    }

    @GetMapping("/all")
    fun getAllItems(): ResponseEntity<List<GetItemConsumeDTO>> {
        return ResponseEntity.ok(itemConsumeService.getAllItems())
    }
}
