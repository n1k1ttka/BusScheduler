package com.example.busschedule.database.schedule

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ScheduleDao {

    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC")
    fun getAll(): List<Schedule> // TODO Возвращает список объектов Schedule, учитывая аннотацию @Query

    @Query("SELECT * FROM schedule WHERE stop_name = :stopName ORDER BY arrival_time ASC") // TODO Q Зачем здесь ASC?
    fun getByStopName(stopName: String): List<Schedule> // TODO Возвращает список объектов Schedule, учитывая аннотацию @Query

}