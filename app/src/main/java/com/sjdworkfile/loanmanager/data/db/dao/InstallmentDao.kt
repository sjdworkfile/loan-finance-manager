package com.sjdworkfile.loanmanager.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sjdworkfile.loanmanager.data.db.entity.InstallmentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface InstallmentDao {
    @Insert
    suspend fun insertInstallment(installment: InstallmentEntity): Long

    @Update
    suspend fun updateInstallment(installment: InstallmentEntity)

    @Delete
    suspend fun deleteInstallment(installment: InstallmentEntity)

    @Query("SELECT * FROM installments WHERE id = :id")
    suspend fun getInstallmentById(id: Long): InstallmentEntity?

    @Query("SELECT * FROM installments WHERE loanId = :loanId ORDER BY dueDate ASC")
    fun getInstallmentsByLoanId(loanId: Long): Flow<List<InstallmentEntity>>

    @Query("SELECT * FROM installments WHERE loanId = :loanId AND isPaid = 0 ORDER BY dueDate ASC")
    fun getPendingInstallments(loanId: Long): Flow<List<InstallmentEntity>>

    @Query("SELECT COUNT(*) FROM installments WHERE loanId = :loanId AND isPaid = 0")
    fun getPendingInstallmentCount(loanId: Long): Flow<Int>

    @Query("SELECT SUM(amount) FROM installments WHERE loanId = :loanId AND isPaid = 0")
    fun getTotalPendingAmount(loanId: Long): Flow<Double?>
}
