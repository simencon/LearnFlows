package com.example.learnflows.utils

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Test
import com.example.learnflows.R
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before

class ResourceComparerTest {
    private lateinit var resourceComparer: ResourceComparer

    @Before
    fun setup() {
        resourceComparer = ResourceComparer()
    }

    @After
    fun teardown() {

    }

    @Test
    fun stringResourceSameAsGivenString_returnsTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()

        val result = resourceComparer.isEqual(context, R.string.app_name, "LearnFlows")
        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceDifferentAsGivenString_returnsFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()

        val result = resourceComparer.isEqual(context, R.string.app_name, "Learn Flows")
        assertThat(result).isFalse()
    }
}