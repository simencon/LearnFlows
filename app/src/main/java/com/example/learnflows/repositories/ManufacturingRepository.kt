package com.example.learnflows.repositories

import com.example.learnflows.data.TransformationsToDomain.asDomain
import com.example.learnflows.data.TransformationsToLocal.toLocal
import com.example.learnflows.data.domain.manufacturing.DomainTeamMember
import com.example.learnflows.data.local.dao.ManufacturingDao

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ManufacturingRepository @Inject constructor(private val manufacturingDao: ManufacturingDao){
    fun teamComplete(): Flow<List<DomainTeamMember>> =
        manufacturingDao.getTeamMembers().map {
            it.asDomain()
        }

    suspend fun insertTeamMember(domainTeamMember: DomainTeamMember) {
        manufacturingDao.insertTeamMember(domainTeamMember.toLocal())
    }

    suspend fun deleteTeamMember(domainTeamMember: DomainTeamMember) {
        manufacturingDao.deleteTeamMember(domainTeamMember.toLocal())
    }

    suspend fun updateTeamMember(domainTeamMember: DomainTeamMember) {
        manufacturingDao.updateTeamMember(domainTeamMember.toLocal())
    }
}