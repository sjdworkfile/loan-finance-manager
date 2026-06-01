package com.sjdworkfile.loanmanager.data.repository

import com.sjdworkfile.loanmanager.data.db.dao.LoanDao
import com.sjdworkfile.loanmanager.data.db.entity.LoanEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoanRepository @Inject constructor(
    private val loanDao: LoanDao
) {
    suspend fun insertLoan(loan: LoanEntity): Long = loanDao.insertLoan(loan)

    suspend fun updateLoan(loan: LoanEntity) = loanDao.updateLoan(loan)

    suspend fun deleteLoan(loan: LoanEntity) = loanDao.deleteLoan(loan)

    suspend fun getLoanById(id: Long): LoanEntity? = loanDao.getLoanById(id)

    fun getAllLoans(): Flow<List<LoanEntity>> = loanDao.getAllLoans()

    fun getActiveLoans(): Flow<List<LoanEntity>> = loanDao.getActiveLoans()

    fun getCompletedLoans(): Flow<List<LoanEntity>> = loanDao.getCompletedLoans()

    fun getActiveLoanCount(): Flow<Int> = loanDao.getActiveLoanCount()

    fun getTotalActiveLoanAmount(): Flow<Double?> = loanDao.getTotalActiveLoanAmount()

    fun getTotalMonthlyPayment(): Flow<Double?> = loanDao.getTotalMonthlyPayment()
}
