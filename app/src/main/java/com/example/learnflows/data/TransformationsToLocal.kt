package com.example.learnflows.data

import com.example.learnflows.data.domain.manufacturing.DomainTeamMember
import com.example.learnflows.data.local.entities.DatabaseTeamMember
import com.example.learnflows.utils.ObjectTransformer

object TransformationsToLocal {
        fun DomainTeamMember.toLocal() =
            ObjectTransformer(DomainTeamMember::class, DatabaseTeamMember::class).transform(this)
}