package com.example.learnflows.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.learnflows.data.local.entities.DatabaseTeamMember
import kotlinx.coroutines.flow.Flow

@Dao
interface ManufacturingDao {
    @Query("select tm.* from `8_team_members` as tm order by tm.fullName")
    fun getTeamMembers(): Flow<List<DatabaseTeamMember>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeamMember(teamMember: DatabaseTeamMember)

    @Delete
    suspend fun deleteTeamMember(teamMember: DatabaseTeamMember)

    @Update
    suspend fun updateTeamMember(teamMember: DatabaseTeamMember)
}