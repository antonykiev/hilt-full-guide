package com.petproject.hiltfullguide

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
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
    lateinit var repository: Repository

    @Test
    fun testFoo() {
        assertThrows(UninitializedPropertyAccessException::class.java) { repository }
        hiltRule.inject()
        assertNotNull(repository)
        assertTrue(repository is RepositoryAnotherImpl)
    }
}