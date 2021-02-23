package com.example.comparetest.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity
@Entity(tableName = "word_table")
data class Word(
        @PrimaryKey(autoGenerate = true) val id: Int,
        @ColumnInfo val word: String
)