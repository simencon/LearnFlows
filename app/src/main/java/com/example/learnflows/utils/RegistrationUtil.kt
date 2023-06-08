package com.example.learnflows.utils

object RegistrationUtil {
    private val existingUsers = listOf("Roman", "Ivan")

    /**
     * the input is not valid if:
     * ...the username/password is empty
     * ...the username is already taken
     * ...the confirmed password is not the same
     * ...the password contains less than 2 digits
     */
    fun validateRegistrationInput(
        username: String,
        password: String,
        confirmedPassword: String
    ): Boolean {
        var result = true

        if (username == "")
            result = false

        existingUsers.forEach {
            if (it == username) {
                result = false
                return@forEach
            }
        }

        if (password.count { it.isDigit() } < 2)
            result = false

        if (password != confirmedPassword)
            result = false

        return result
    }
}