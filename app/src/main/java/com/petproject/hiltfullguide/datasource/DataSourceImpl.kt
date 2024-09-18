package com.petproject.hiltfullguide.datasource

import javax.inject.Inject

class DataSourceRemoteImpl @Inject constructor(): DataSource {
    override fun userName(): String {
        return "DataSourceRemoteImpl"
    }
}

class DataSourceLocalImpl @Inject constructor(): DataSource {
    override fun userName(): String {
        return "DataSourceLocalImpl"
    }
}