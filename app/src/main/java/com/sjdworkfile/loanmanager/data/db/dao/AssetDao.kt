package com.sjdworkfile.loanmanager.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sjdworkfile.loanmanager.data.db.entity.AssetEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AssetDao {
    @Insert
    suspend fun insertAsset(asset: AssetEntity): Long

    @Update
    suspend fun updateAsset(asset: AssetEntity)

    @Delete
    suspend fun deleteAsset(asset: AssetEntity)

    @Query("SELECT * FROM assets WHERE id = :id")
    suspend fun getAssetById(id: Long): AssetEntity?

    @Query("SELECT * FROM assets ORDER BY type ASC")
    fun getAllAssets(): Flow<List<AssetEntity>>

    @Query("SELECT * FROM assets WHERE type = :type")
    fun getAssetsByType(type: String): Flow<List<AssetEntity>>

    @Query("SELECT SUM(totalValue) FROM assets")
    fun getTotalAssetValue(): Flow<Double?>

    @Query("SELECT SUM(totalValue) FROM assets WHERE type = :type")
    fun getTotalValueByType(type: String): Flow<Double?>
}
