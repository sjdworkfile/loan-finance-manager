package com.sjdworkfile.loanmanager.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "assets")
data class AssetEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val type: String, // gold, silver, dollar, crypto, etc
    val quantity: Double,
    val currentPrice: Double = 0.0, // price per unit
    val totalValue: Double = 0.0, // quantity * currentPrice
    val purchasePrice: Double = 0.0,
    val purchaseDate: Date = Date(),
    val notes: String = "",
    val lastUpdated: Date = Date()
)
