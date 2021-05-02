package teste.app

import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.request.receiveText
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.http.HttpMethod
import io.ktor.http.HttpHeaders

fun main() {
    embeddedServer(Netty, port = 8080) {

        install(CORS) {
            host(
                host = "hoppscotch.io",
                schemes = listOf("http","https"),
                subDomains = listOf("", "www", "app")
            )
            method(HttpMethod.Options)
            method(HttpMethod.Post)
            method(HttpMethod.Get)
            header(HttpHeaders.ContentType)
            header(HttpHeaders.Authorization)
            header(HttpHeaders.ContentDisposition)

            allowCredentials = true
        }

        routing {
            get("/") {
                call.respond(HttpStatusCode.OK, "Olá Mundo!")
            }

            get("/v2/teste/{name}") {
                val name = call.parameters["name"]
                call.respond(HttpStatusCode.OK, "Hello, $name!")
            }

            post("/v2/teste") {
                val json:String = call.receiveText()
                call.respondText(
                    "hello JSON: $json",
                    ContentType.Application.Json,
                    HttpStatusCode.OK
                )
            }
        }
    }.start(wait = true)
}
