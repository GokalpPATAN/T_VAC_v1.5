package com.erayerarslan.t_vac_kotlin.domain.repository

import com.erayerarslan.t_vac_kotlin.domain.repository.SensorDataRepository
import com.erayerarslan.t_vac_kotlin.model.SensorData
import com.erayerarslan.t_vac_kotlin.model.SensorDataManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseSensorDataRepository @Inject constructor(
    private val manager: SensorDataManager
) : SensorDataRepository {

    override suspend fun fetchSensorData(): SensorData =
        manager.fetchSensorData().also { manager.addSensorData(it) } // 🔄

    override fun getLatestSensorData(): SensorData? =
        manager.getLatestSensorData()
}

