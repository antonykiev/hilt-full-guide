package com.petproject.hiltfullguide

import android.util.Log
import javax.inject.Inject

class Repository @Inject constructor() {
    fun execute() {
        Log.d("Repository", "execute: run")
    }
}