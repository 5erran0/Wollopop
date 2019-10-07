package com.ginzo.commons.data

interface ToDomain<out T> {
    fun toDomain(): T
}