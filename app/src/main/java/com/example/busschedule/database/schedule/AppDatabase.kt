package com.example.busschedule.database.schedule

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class AppDatabase: RoomDatabase(){

    abstract fun scheduleDao(): ScheduleDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase { // TODO Q ?!?!?!?!?!??!?!?
            return INSTANCE ?: synchronized(this) { // TODO Выдаем существующий экземпляр БД либо создаем новый
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, // TODO Q Что за двойное двоеточие?
                    "app_database")
                    .createFromAsset("database/bus_schedule.db") // для загрузки существующих данных
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}