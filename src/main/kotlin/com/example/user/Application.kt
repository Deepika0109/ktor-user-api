package com.example.user

import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.routing.routing
import io.ktor.server.request.*
import io.ktor.server.response.*
import kotlinx.serialization.Serializable
import java.util.concurrent.ConcurrentHashMap

fun main() {
    embeddedServer(Netty, port = 8081, host = "0.0.0.0") {
        install(ContentNegotiation) {
            json()
        }
        routing {
            userRoutes()
        }
    }.start(wait = true)
}