package com.logic.uasg.util

import java.util.regex.Pattern

class Validator {

    companion object {
        fun isEmailValid(email: String): Boolean {
            var isValid = false
            val expression = "[^ ]+@[^ ]+\\.[^ ]{2,63}"
            val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
            val matcher = pattern.matcher(email)
            if (matcher.matches()) {
                isValid = true
            }
            return isValid
        }
    }
}