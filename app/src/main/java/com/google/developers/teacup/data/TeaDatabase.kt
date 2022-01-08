package com.google.developers.teacup.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Tea::class], version = 1, exportSchema = false)
abstract class TeaDatabase : RoomDatabase() {

    abstract fun teaDao(): TeaDao

    companion object {

        @Volatile
        private var instance: TeaDatabase? = null

        /**
         * Returns an instance of Room Database
         *
         * @param context application context
         * @return The singleton TeaDatabase
         */
        fun getInstance(context: Context): TeaDatabase?{



            if (instance == null) {
                synchronized(TeaDatabase::class.java) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            context.applicationContext,
                            TeaDatabase::class.java, "tea_database"
                        )
                            .addCallback(sRoomDatabaseCallback)
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return instance
        }
        private val sRoomDatabaseCallback: Callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
            }
        }


    }
}
