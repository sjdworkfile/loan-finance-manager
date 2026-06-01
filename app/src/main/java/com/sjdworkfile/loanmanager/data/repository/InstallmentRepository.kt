package com.sjdworkfile.loanmanager.data.repository

import com.sjdworkfile.loanmanager.data.db.dao.InstallmentDao
import com.sjdworkfile.loanmanager.data.db.entity.InstallmentEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InstallmentRepository @Inject constructor(
    private val installmentDao: InstallmentDao
) {
    suspend fun insertInstallment(installment: InstallmentEntity): Long =
        installmentDao.insertInstallment(installment)

    suspend fun updateInstallment(installment: InstallmentEntity) =
        installmentDao.updateInstallment(installment)

    suspend fun deleteInstallment(installment: InstallmentEntity) =
        installmentDao.deleteInstallment(installment)

    suspend fun getInstallmentById(id: Long): InstallmentEntity? =
        installmentDao.getInstallmentById(id)

    fun getInstallmentsByLoanId(loanId: Long): Flow<List<InstallmentEntity>> =
        installmentDao.getInstallmentsByLoanId(loanId)

    fun getPendingInstallments(loanId: Long): Flow<List<InstallmentEntity>> =
        installmentDao.getPendingInstallments(loanId)

    fun getPendingInstallmentCount(loanId: Long): Flow<Int> =
        installmentDao.getPendingInstallmentCount(loanId)

    fun getTotalPendingAmount(loanId: Long): Flow<Double?> =
        installmentDao.getTotalPendingAmount(loanId)
}
