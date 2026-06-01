package com.sjdworkfile.loanmanager.data.repository

import com.sjdworkfile.loanmanager.data.db.dao.ExpenseDao
import com.sjdworkfile.loanmanager.data.db.entity.ExpenseEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExpenseRepository @Inject constructor(
    private val expenseDao: ExpenseDao
) {
    suspend fun insertExpense(expense: ExpenseEntity): Long = expenseDao.insertExpense(expense)

    suspend fun updateExpense(expense: ExpenseEntity) = expenseDao.updateExpense(expense)

    suspend fun deleteExpense(expense: ExpenseEntity) = expenseDao.deleteExpense(expense)

    suspend fun getExpenseById(id: Long): ExpenseEntity? = expenseDao.getExpenseById(id)

    fun getAllExpenses(): Flow<List<ExpenseEntity>> = expenseDao.getAllExpenses()

    fun getExpensesByCategory(category: String): Flow<List<ExpenseEntity>> =
        expenseDao.getExpensesByCategory(category)

    fun getTotalExpenses(): Flow<Double?> = expenseDao.getTotalExpenses()

    fun getTotalRecurringExpenses(): Flow<Double?> = expenseDao.getTotalRecurringExpenses()
}
