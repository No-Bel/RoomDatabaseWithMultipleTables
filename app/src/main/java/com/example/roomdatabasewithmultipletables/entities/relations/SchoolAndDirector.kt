package com.example.roomdatabasewithmultipletables.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomdatabasewithmultipletables.entities.Director
import com.example.roomdatabasewithmultipletables.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)