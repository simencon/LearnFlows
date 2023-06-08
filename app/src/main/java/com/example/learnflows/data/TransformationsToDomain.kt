package com.example.learnflows.data

import com.example.learnflows.data.domain.manufacturing.DomainTeamMember
import com.example.learnflows.data.local.entities.DatabaseTeamMember
import com.example.learnflows.utils.ObjectTransformer

object TransformationsToDomain {
    fun DatabaseTeamMember.toDomain() =
        ObjectTransformer(DatabaseTeamMember::class, DomainTeamMember::class).transform(this)

    fun List<DatabaseTeamMember>.asDomain(): List<DomainTeamMember> {
        return map {
            it.toDomain()
        }
    }

    fun List<DomainTeamMember>.changeDetails(id: Long): List<DomainTeamMember> {
        return map {
            if(id == it.id) {
                it.detailsVisibility = !it.detailsVisibility
            } else {
                it.detailsVisibility= false
            }
            it
        }
    }
}