package com.crenu.dunmapleBulk.Service

import com.crenu.dunmapleBulk.Data.StarforceDTO
import com.crenu.dunmapleBulk.Repo.StarforceRepo
import org.springframework.stereotype.Service

@Service
class StarforceService(repo: StarforceRepo) {
    private val repo: StarforceRepo

    init {
        this.repo = repo
    }

    fun insertStarforceList(dtoItems: List<StarforceDTO>) {
        repo.insertStarforceList(dtoItems)
    }
}
