package com.example.comparetest.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface wordDao {

    //全件検索
    @Query("SELECT * FROM word_table")
    fun getItem(): LiveData<List<Word>>

    //追加
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord (Word:Word)

}