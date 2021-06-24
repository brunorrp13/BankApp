package com.example.bankapp.domain.usecase

import com.example.bankapp.data.model.ExtratoAPIResponse
import com.example.bankapp.data.model.ExtratoItem
import com.example.bankapp.data.repository.remote.statement.ExtratoRepository
import com.example.bankapp.data.util.Resource

class GetExtratoUseCase (private val extratoRepository: ExtratoRepository) {

      suspend fun execute(): Resource<List<ExtratoItem>> {

          return extratoRepository.getStatement()

    }

}