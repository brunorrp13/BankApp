package com.example.tasks.service.constants


class TaskConstants private constructor() {

    // SharedPreferences
    object SHARED {
        const val USERNAME = "username"
        const val PASSWORD = "password"
        const val PERSON_CPF = "personcpf"
        const val PERSON_NAME = "personname"
        const val PERSON_BALANCE = "personsaldo"
        const val TOKEN_KEY = "tokenkey"
        }

    object HEADER {
        const val TOKEN_KEY = "token"
    }

    object HTTP {
        const val SUCCESS = 200
    }


}