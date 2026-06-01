package com.sjdworkfile.loanmanager.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "loans")
data class LoanEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val bankName: String,
    val totalAmount: Double,
    val monthlyInstallment: Double,
    val startDate: Date,
    val endDate: Date,
    val description: String = "",
    val isCompleted: Boolean = false,
    val createdAt: Date = Date(),
    val updatedAt: Date = Date()
)
