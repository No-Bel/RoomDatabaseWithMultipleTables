package com.example.roomdatabasewithmultipletables.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.roomdatabasewithmultipletables.entities.Student
import com.example.roomdatabasewithmultipletables.entities.Subject

data class SubjectWithStudents(
    @Embedded
    val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val student: List<Student>
)