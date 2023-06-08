package com.example.learnflows.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.learnflows.data.local.dao.ManufacturingDao
import com.example.learnflows.data.local.entities.DatabaseTeamMember

@Database(
    entities = [DatabaseTeamMember::class],
    version = 1,
    exportSchema = true
)
abstract class QualityDB: RoomDatabase() {
    abstract fun manufacturingDao(): ManufacturingDao
}