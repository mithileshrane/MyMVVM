package com.example.mvvmapplication.data.db.converters

import androidx.room.TypeConverter
import java.util.*
//
// https://github.com/
// AgustaRC/MVVMArchitecture/blob/master/app/src/main/java/com/leopold/mvvm/data/db/converter/DateConverter.kt

class DateConverter {
    @TypeConverter
    fun toDate(value: Long): Date = Date(value)

    @TypeConverter
    fun toLong(date: Date): Long = date.time
}