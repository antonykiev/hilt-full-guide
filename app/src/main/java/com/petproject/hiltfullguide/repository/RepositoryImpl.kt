package com.petproject.hiltfullguide.repository

import android.util.Log
import com.petproject.hiltfullguide.datasource.DataSource
import javax.inject.Inject
import javax.inject.Named

class RepositoryImpl @Inject constructor(
    private val dataSourceRemote: DataSource,
    private val dataSourceLocal: DataSource,
) : Repository {
    override fun userName(): String {
        return dataSourceLocal.userName()
    }
}

class RepositoryAnotherImpl @Inject constructor(
    private val dataSourceRemote: DataSource,
    private val dataSourceLocal: DataSource,
) : Repository {
    override fun userName(): String {
        return dataSourceRemote.userName()
    }
}