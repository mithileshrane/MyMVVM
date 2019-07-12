package com.example.mvvmapplication.data.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson



class NullConverters {
    @TypeConverter // note this annotation
    fun fromOptionValuesList(optionValues: String?): String? {
        if (optionValues == null) {
            return ""
        }

        return optionValues
    }

  /*  @TypeConverter // note this annotation
    fun toOptionValuesList(optionValuesString: String?): String? {
        if (optionValuesString == null) {
            return ""
        }

        return optionValuesString
    }*/
}

