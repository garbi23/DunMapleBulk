package com.crenu.dunmapleBulk.Service

import com.crenu.dunmapleBulk.Data.GetItemConsumeDTO
import com.crenu.dunmapleBulk.Data.GetItemConsumeEntity
import com.crenu.dunmapleBulk.Data.toDTO
import com.crenu.dunmapleBulk.Repo.GetItemConsumeJPARepo
import com.crenu.dunmapleBulk.Repo.GetItemConsumeRepo
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class ItemConsumeService(
    private val getItemConsumeRepo: GetItemConsumeRepo,
    private val getItemConsumeJPARepo: GetItemConsumeJPARepo
) {
    fun getData(): List<GetItemConsumeDTO> {
        val randomDataList = generateRandomDataList()
        return getItemConsumeRepo.sendItemConsumeList(randomDataList)
    }

    fun deleteItemConsume(userIds: List<String>) {
        getItemConsumeRepo.deleteItemConsumeByUserIds(userIds)
    }

    fun updateItemConsume(dtoItems: List<GetItemConsumeDTO>) {
        getItemConsumeRepo.updateItemConsumeList(dtoItems)
    }

    fun getByUserid(userid: String): List<GetItemConsumeDTO> {
        return getItemConsumeJPARepo.findByUserid(userid).map(GetItemConsumeEntity::toDTO)
    }

    fun getAllItems(): List<GetItemConsumeDTO> {
        return getItemConsumeJPARepo.findAll().map(GetItemConsumeEntity::toDTO)
    }

    fun createItemConsume(newItemConsumeData: List<GetItemConsumeDTO>) {
        getItemConsumeRepo.insertItemConsumeList(newItemConsumeData)
    }

    private fun generateRandomDataList(): List<GetItemConsumeDTO> {
        val random = Random()
        return List(100) {
            GetItemConsumeDTO(
                num = null,
                timeStamp = LocalDateTime.now().minusDays(random.nextLong(1, 30)),
                userid = UUID.randomUUID().toString(),
                nickName = "User-${random.nextInt(1000)}",
                itemName = "Item-${random.nextInt(100)}",
                useCount = random.nextInt(1, 100),
                allCount = random.nextInt(1, 100)
            )
        }
    }
}