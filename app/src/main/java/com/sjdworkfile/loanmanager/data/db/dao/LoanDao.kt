package com.sjdworkfile.loanmanager.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sjdworkfile.loanmanager.data.db.entity.LoanEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LoanDao {
    @Insert
    suspend fun insertLoan(loan: LoanEntity): Long

    @Update
    suspend fun updateLoan(loan: LoanEntity)

    @Delete
    suspend fun deleteLoan(loan: LoanEntity)

    @Query("SELECT * FROM loans WHERE id = :id")
    suspend fun getLoanById(id: Long): LoanEntity?

    @Query("SELECT * FROM loans ORDER BY createdAt DESC")
    fun getAllLoans(): Flow<List<LoanEntity>>

    @Query("SELECT * FROM loans WHERE isCompleted = 0 ORDER BY createdAt DESC")
    fun getActiveLoans(): Flow<List<LoanEntity>>

    @Query("SELECT * FROM loans WHERE isCompleted = 1 ORDER BY createdAt DESC")
    fun getCompletedLoans(): Flow<List<LoanEntity>>

    @Query("SELECT COUNT(*) FROM loans WHERE isCompleted = 0")
    fun getActiveLoanCount(): Flow<Int>

    @Query("SELECT SUM(totalAmount) FROM loans WHERE isCompleted = 0")
    fun getTotalActiveLoanAmount(): Flow<Double?>

    @Query("SELECT SUM(monthlyInstallment) FROM loans WHERE isCompleted = 0")
    fun getTotalMonthlyPayment(): Flow<Double?>
}
