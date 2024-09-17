package com.petproject.hiltfullguide

import android.util.Log
import javax.inject.Inject

class RepositoryImpl @Inject constructor() : Repository {
    override fun execute() {
        Log.d("Repository", "execute: run")
    }
}