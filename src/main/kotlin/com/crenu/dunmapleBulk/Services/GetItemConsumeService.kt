package com.crenu.dunmapleBulk.Service

import com.crenu.dunmapleBulk.Data.GetItemConsumeDTO
import com.crenu.dunmapleBulk.Repo.GetItemConsumeRepo
import org.springframework.stereotype.Service

@Service
class GetItemConsumeService(private val getItemConsumeRepo: GetItemConsumeRepo) {
    fun insertItemConsumeList(dtoItems: List<GetItemConsumeDTO>) {
        getItemConsumeRepo.insertItemConsumeList(dtoItems)
    }
}