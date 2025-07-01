package com.example.user

import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.request.receive
import io.ktor.server.routing.Route
import io.ktor.server.routing.route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.delete
import kotlinx.serialization.Serializable
import java.util.concurrent.ConcurrentHashMap
import kotlin.text.get

val users = ConcurrentHashMap<Int, User>()
var userIdCounter = 1

fun Route.userRoutes() {
    route("/users") {
        get {
            call.respond(users.values.toList())
        }
        post {
            val req = call.receive<UserRequest>()
            val user = User(userIdCounter++, req.name, req.email)
            users[user.id] = user
            call.respond(user)
        }
        delete("/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            if (id != null && users.containsKey(id)) {
                users.remove(id)
                call.respond(mapOf("deleted" to true))
            } else {
                call.respond(mapOf("deleted" to false))
            }
        }
    }
}

@Serializable
data class User(val id: Int, val name: String, val email: String)

@Serializable
data class UserRequest(val name: String, val email: String)