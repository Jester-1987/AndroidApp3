package com.triosng2024.treasurehunt.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.triosng2024.treasurehunt.db.BookmarkDao
import com.triosng2024.treasurehunt.db.TreasureHuntDatabase
import com.triosng2024.treasurehunt.model.Bookmark

class BookmarkRepo(context: Context) {

    private val db = TreasureHuntDatabase.getInstance(context)
    private val bookmarkDao: BookmarkDao = db.bookmarkDao()

    fun addBookmark(bookmark: Bookmark): Long? {
        val newId = bookmarkDao.insertBookmark(bookmark)
        bookmark.id = newId
        return newId
    }

    fun createBookmark():Bookmark {
        return Bookmark()
    }

    val allBookmarks: LiveData<List<Bookmark>>
        get() {
            return bookmarkDao.loadAll()
        }
}