package com.example.learnflows.utils


import com.example.learnflows.utils.RegistrationUtil
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `empty username returns false`() {
        val result = RegistrationUtil.validateRegistrationInput("","123","123")
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true`() {
        val result = RegistrationUtil.validateRegistrationInput("Philip","1234","1234")
        assertThat(result).isTrue()
    }

    @Test
    fun `username already exists returns false`() {
        val result = RegistrationUtil.validateRegistrationInput("Roman","123","123")
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput("Vikusia","","")
        assertThat(result).isFalse()
    }

    @Test
    fun `not repeated password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput("Vikusia","12345","12346")
        assertThat(result).isFalse()
    }

    @Test
    fun `password contains less than 2 digits returns false`() {
        val result = RegistrationUtil.validateRegistrationInput("Vikusia","simenko1","simenko1")
        assertThat(result).isFalse()
    }
}