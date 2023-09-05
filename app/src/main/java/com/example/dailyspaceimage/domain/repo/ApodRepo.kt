package com.example.dailyspaceimage.domain.repo

import com.example.dailyspaceimage.data.remote.dto.ApodDto
import java.time.LocalDate

/**
 * interface providing access to API functions
 * but can contain caching logic (saving to database)
 */
interface ApodRepo {
    suspend fun getApods(startDate: LocalDate, endDate: LocalDate): List<ApodDto>

    suspend fun getSingleApod(endDate: LocalDate): ApodDto
}