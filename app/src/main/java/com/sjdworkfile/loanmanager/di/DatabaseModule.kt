package com.sjdworkfile.loanmanager.di

import android.content.Context
import androidx.room.Room
import com.sjdworkfile.loanmanager.data.db.LoanDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideLoanDatabase(@ApplicationContext context: Context): LoanDatabase {
        return Room.databaseBuilder(
            context,
            LoanDatabase::class.java,
            "loan_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideLoanDao(database: LoanDatabase) = database.loanDao()

    @Singleton
    @Provides
    fun provideInstallmentDao(database: LoanDatabase) = database.installmentDao()

    @Singleton
    @Provides
    fun provideExpenseDao(database: LoanDatabase) = database.expenseDao()

    @Singleton
    @Provides
    fun provideAssetDao(database: LoanDatabase) = database.assetDao()
}
