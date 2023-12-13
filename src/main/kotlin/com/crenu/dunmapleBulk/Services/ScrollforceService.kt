package com.crenu.dunmapleBulk.Service

import com.crenu.dunmapleBulk.Data.ScrollforceDTO
import com.crenu.dunmapleBulk.Repo.ScrollforceRepo
import org.springframework.stereotype.Service

@Service
class ScrollforceService(repo: ScrollforceRepo) {
    private val repo: ScrollforceRepo

    init {
        this.repo = repo
    }

    fun insertScrollforceList(dtoItems: List<ScrollforceDTO>) {
        repo.insertScrollforceList(dtoItems)
    }
}
