package com.example.bankapp.domain.statements.repository

import com.example.bankapp.data.model.Extrato
import com.example.bankapp.data.util.Resource

interface StatementRepository {

    suspend fun getStatement(): Resource<Extrato>

}