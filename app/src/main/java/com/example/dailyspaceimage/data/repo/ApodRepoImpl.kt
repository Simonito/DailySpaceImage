package com.example.dailyspaceimage.data.repo

import com.example.dailyspaceimage.common.Constants
import com.example.dailyspaceimage.data.remote.ApodApi
import com.example.dailyspaceimage.data.remote.dto.ApodDto
import com.example.dailyspaceimage.domain.repo.ApodRepo
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ApodRepoImpl(
    private val api: ApodApi
) : ApodRepo {
    override suspend fun getApods(startDate: LocalDate, endDate: LocalDate): List<ApodDto> {
        return api.getApods(
            apiKey = Constants.API_KEY,
            endDate = endDate.format(DateTimeFormatter.ISO_DATE),
            startDate = startDate.format(DateTimeFormatter.ISO_DATE)
        )
    }

    override suspend fun getSingleApod(endDate: LocalDate): ApodDto {
        return api.getSingleApod(
            apiKey = Constants.API_KEY,
            endDate = endDate.format(DateTimeFormatter.ISO_DATE)
        )
    }
}