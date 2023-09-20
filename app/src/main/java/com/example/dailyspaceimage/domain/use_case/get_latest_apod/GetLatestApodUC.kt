package com.example.dailyspaceimage.domain.use_case.get_latest_apod

import com.example.dailyspaceimage.common.Resource
import com.example.dailyspaceimage.data.remote.dto.toApod
import com.example.dailyspaceimage.domain.model.Apod
import com.example.dailyspaceimage.domain.repo.ApodRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetLatestApodUC(
    private val repository: ApodRepo
) {
    operator fun invoke(): Flow<Resource<Apod>> = flow {
        try {
            emit(Resource.Loading())
            val apod = repository.getLatestApod().toApod()
            emit(Resource.Success(apod))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}