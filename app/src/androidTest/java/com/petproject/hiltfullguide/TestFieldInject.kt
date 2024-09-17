package com.petproject.hiltfullguide

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertThrows
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject


@HiltAndroidTest
class TestFieldInject {
    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var repository: Repository

//    @Before
//    fun init() = hiltRule.inject()

    @Test
    fun testFoo() {
        assertThrows(UninitializedPropertyAccessException::class.java) { repository }
        hiltRule.inject()
        assertNotNull(repository)
    }
}