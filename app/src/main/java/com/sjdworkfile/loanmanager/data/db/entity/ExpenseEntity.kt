package com.sjdworkfile.loanmanager.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "expenses")
data class ExpenseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val category: String, // gym, tuition, subscription, etc
    val amount: Double,
    val dueDate: Date? = null,
    val isRecurring: Boolean = true, // monthly recurring
    val frequency: String = "monthly",
    val notes: String = "",
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)
