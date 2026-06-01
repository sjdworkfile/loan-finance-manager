package com.sjdworkfile.loanmanager.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sjdworkfile.loanmanager.data.db.converter.DateConverter
import com.sjdworkfile.loanmanager.data.db.dao.LoanDao
import com.sjdworkfile.loanmanager.data.db.dao.InstallmentDao
import com.sjdworkfile.loanmanager.data.db.dao.ExpenseDao
import com.sjdworkfile.loanmanager.data.db.dao.AssetDao
import com.sjdworkfile.loanmanager.data.db.entity.LoanEntity
import com.sjdworkfile.loanmanager.data.db.entity.InstallmentEntity
import com.sjdworkfile.loanmanager.data.db.entity.ExpenseEntity
import com.sjdworkfile.loanmanager.data.db.entity.AssetEntity

@Database(
    entities = [
        LoanEntity::class,
        InstallmentEntity::class,
        ExpenseEntity::class,
        AssetEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class LoanDatabase : RoomDatabase() {
    abstract fun loanDao(): LoanDao
    abstract fun installmentDao(): InstallmentDao
    abstract fun expenseDao(): ExpenseDao
    abstract fun assetDao(): AssetDao

    companion object {
        @Volatile
        private var instance: LoanDatabase? = null

        fun getInstance(context: Context): LoanDatabase {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    LoanDatabase::class.java,
                    "loan_database"
                ).build().also { instance = it }
            }
        }
    }
}
