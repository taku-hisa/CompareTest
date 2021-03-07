package com.example.comparetest

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.comparetest.db.Word
import com.example.comparetest.db.wordDao
import com.example.comparetest.db.wordRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (application: Application): AndroidViewModel(application) {

    private val dao: wordDao
    init {
        val db = wordRoomDatabase.buildDatabase(application) // DBにアクセスするclassで一度だけDBをビルドする
        dao = db.wordDao() // 使用するDaoを指定
    }

    val getItem = dao.getItem()

    fun insertWord(Word: Word) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.insertWord(Word)
        }
    }

    fun deleteWord(Id:Int){
        viewModelScope.launch (Dispatchers.IO) {
            dao.deleteitem(Id)
        }
    }
}