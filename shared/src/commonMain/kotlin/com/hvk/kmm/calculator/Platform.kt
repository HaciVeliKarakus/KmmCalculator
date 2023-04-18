package com.hvk.kmm.calculator

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform