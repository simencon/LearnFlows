package com.example.learnflows.utils


import com.example.learnflows.utils.Homework.checkBraces
import com.example.learnflows.utils.Homework.fib
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class HomeworkTest {

    @Test
    fun `returns the n-th correct fibonacci number`() {
        val number = fib(10)
        assertThat(number).isEqualTo(34)
    }

    @Test
    fun `returns the n-th incorrect fibonacci number`() {
        val number = fib(11)
        assertThat(number).isNotEqualTo(54)
    }

    @Test
    fun `Checks if the braces are set correctly`() {
        val result = checkBraces("(3-4)")
        assertThat(result).isTrue()
    }

    @Test
    fun `Checks if the braces are set incorrectly`() {
        val result = checkBraces("3-4)")
        assertThat(result).isFalse()
    }
}