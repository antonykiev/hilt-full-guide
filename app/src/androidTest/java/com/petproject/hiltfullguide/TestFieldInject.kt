package com.petproject.hiltfullguide

import com.petproject.hiltfullguide.repository.Repository
import com.petproject.hiltfullguide.repository.RepositoryAnotherImpl
import com.petproject.hiltfullguide.repository.RepositoryImpl
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named


@HiltAndroidTest
class TestFieldInject {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    @Named("repositoryAnother")
    lateinit var repositoryAnother: Repository

    @Inject
    @Named("repository")
    lateinit var repository: Repository

    @Before
    fun before() {
        hiltRule.inject()
    }

    @Test
    fun testRepositoryAnother() {
        assertNotNull(repositoryAnother)
        assertTrue(repositoryAnother is RepositoryAnotherImpl)
        assertTrue(repositoryAnother.userName() == "DataSourceRemoteImpl")
    }

    @Test
    fun testRepository() {
        assertNotNull(repository)
        assertTrue(repository is RepositoryImpl)
        assertTrue(repository.userName() == "DataSourceLocalImpl")
    }
}