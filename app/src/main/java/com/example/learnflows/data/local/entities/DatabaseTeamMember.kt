package com.example.learnflows.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "8_team_members"
)
data class DatabaseTeamMember constructor(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo(index = true)
    var departmentId: Long,
    var department: String,
    var email: String? = null,
    var fullName: String,
    var jobRole: String,
    @ColumnInfo(index = true)
    var roleLevelId: Long,
    var passWord: String? = null,
    @ColumnInfo(index = true)
    var companyId: Long
)