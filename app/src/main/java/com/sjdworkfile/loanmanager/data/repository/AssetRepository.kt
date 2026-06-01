package com.sjdworkfile.loanmanager.data.repository

import com.sjdworkfile.loanmanager.data.db.dao.AssetDao
import com.sjdworkfile.loanmanager.data.db.entity.AssetEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AssetRepository @Inject constructor(
    private val assetDao: AssetDao
) {
    suspend fun insertAsset(asset: AssetEntity): Long = assetDao.insertAsset(asset)

    suspend fun updateAsset(asset: AssetEntity) = assetDao.updateAsset(asset)

    suspend fun deleteAsset(asset: AssetEntity) = assetDao.deleteAsset(asset)

    suspend fun getAssetById(id: Long): AssetEntity? = assetDao.getAssetById(id)

    fun getAllAssets(): Flow<List<AssetEntity>> = assetDao.getAllAssets()

    fun getAssetsByType(type: String): Flow<List<AssetEntity>> = assetDao.getAssetsByType(type)

    fun getTotalAssetsValue(): Flow<Double?> = assetDao.getTotalAssetsValue()
}
