package com.example.roomdatabasewithmultipletables.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomdatabasewithmultipletables.entities.School
import com.example.roomdatabasewithmultipletables.entities.Student

data class SchoolWithStudents(
    @Embedded
    val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)
