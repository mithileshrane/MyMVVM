package com.example.mvvmapplication.data.db

import android.content.Context
import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mvvmapplication.data.db.entity.EmployeeListResponseModel
import com.example.mvvmapplication.data.db.AppDatabase.Companion.DB_VERSION
import com.example.mvvmapplication.data.db.converters.NullConverters
import com.example.mvvmapplication.data.db.dao.EmployeeDao

@Database(
    entities = [EmployeeListResponseModel.EmployeeListResult.EmployeeListUserDetail::class],
    version = DB_VERSION,
    exportSchema = false
)
@TypeConverters(NullConverters::class)
abstract class AppDatabase :RoomDatabase(){
    abstract fun getEmployeeDao(): EmployeeDao

    companion object {
        const val DB_VERSION = 1
        private const val DB_NAME = "mvvm_demo.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null


        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: build(context).also { INSTANCE = it }
            }

        private fun build(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME)
                .addMigrations(MIGRATION_1_TO_2)
                .build()

        private val MIGRATION_1_TO_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }

    }
}