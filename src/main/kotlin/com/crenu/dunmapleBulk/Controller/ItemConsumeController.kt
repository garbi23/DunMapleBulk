package com.crenu.dunmapleBulk.Controller

import com.crenu.dunmapleBulk.Data.GetItemConsumeDTO
import com.crenu.dunmapleBulk.Repo.GetItemConsumeRepo
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import java.util.*

@RestController
@RequestMapping("/item-consume")
class ItemConsumeController(
    private val getItemConsumeRepo: GetItemConsumeRepo
) {
    @GetMapping("/get-data")
    fun getData(): List<GetItemConsumeDTO> {
        val randomDataList = generateRandomDataList()
        return getItemConsumeRepo.sendItemConsumeList(randomDataList)
    }

    // 랜덤 데이터 생성 메소드
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
