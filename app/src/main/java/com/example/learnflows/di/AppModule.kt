package com.example.learnflows.di

import android.content.Context
import androidx.room.Room
import com.example.learnflows.data.local.QualityDB
import com.example.learnflows.data.local.dao.ManufacturingDao
import com.example.learnflows.repositories.ManufacturingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideQualityDB(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context.applicationContext,
        QualityDB::class.java,
        "QualityDB"
    ).build()

    @Singleton
    @Provides
    fun provideManufacturingDao(database: QualityDB) = database.manufacturingDao()

    @Singleton
    @Provides
    fun provideManufacturingRepository(dao: ManufacturingDao) = ManufacturingRepository(dao)
}