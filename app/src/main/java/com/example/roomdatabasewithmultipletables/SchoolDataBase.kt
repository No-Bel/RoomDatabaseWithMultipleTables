package com.example.roomdatabasewithmultipletables

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabasewithmultipletables.dao.SchoolDao
import com.example.roomdatabasewithmultipletables.entities.Director
import com.example.roomdatabasewithmultipletables.entities.School
import com.example.roomdatabasewithmultipletables.entities.Student
import com.example.roomdatabasewithmultipletables.entities.Subject
import com.example.roomdatabasewithmultipletables.entities.relations.StudentSubjectCrossRef

@Database(
    entities = [
        School::class,
        Student::class,
        Subject::class,
        Director::class,
        StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDataBase: RoomDatabase() {

    abstract val schoolDao: SchoolDao

    companion object {
        @Volatile
        private var INSTANCE: SchoolDataBase? = null

        fun getInstance(context: Context): SchoolDataBase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDataBase::class.java,
                    "SCHOOL_DB"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}