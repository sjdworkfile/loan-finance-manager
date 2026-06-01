package com.sjdworkfile.loanmanager.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "installments",
    foreignKeys = [
        ForeignKey(
            entity = LoanEntity::class,
            parentColumns = ["id"],
            childColumns = ["loanId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class InstallmentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val loanId: Long,
    val amount: Double,
    val dueDate: Date,
    val paidDate: Date? = null,
    val isPaid: Boolean = false,
    val reminderEnabled: Boolean = true,
    val reminderTime: String? = null,
    val notes: String = "",
    val createdAt: Date = Date()
)
