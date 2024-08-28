package com.triosng2024.treasurehunt.viewmodel

import android.app.Application
import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.google.android.libraries.places.api.model.Place
import com.triosng2024.treasurehunt.repository.BookmarkRepo

class MapsViewModel(application: Application) :
AndroidViewModel(application) {

    private val TAG = "MapsViewModel"

    private val bookmarkRepo: BookmarkRepo = BookmarkRepo(
        getApplication())

    fun addBookmarkFromPlace(place: Place, image: Bitmap?) {

        val bookmark = bookmarkRepo.createBookmark()
        bookmark.placeId = place.id
        bookmark.name = place.name.toString()
        bookmark.longitude = place.latLng?.longitude ?: 0.0
        bookmark.latitude = place.latLng?.latitude ?: 0.0
        bookmark.phone = place.phoneNumber.toString()
        bookmark.address = place.address.toString()

        val newId = bookmarkRepo.addBookmark(bookmark)
        Log.i(TAG, "NewBookmark $newId added to the database.")
    }

}