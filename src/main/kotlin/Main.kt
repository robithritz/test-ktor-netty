package blog

import freemarker.cache.ClassTemplateLoader
import io.ktor.application.*
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.freemarker.FreeMarker
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.http.ContentType
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty



fun Application.module(){
    install(DefaultHeaders)
    install(CallLogging)
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }
    install(Routing) {
        get("/") {
            call.respondText("Welcom to Kotlin", ContentType.Text.Html)
        }
        get("/templateengine") {
            call.respond(FreeMarkerContent("index.ftl", mapOf("data" to listOf<Int>(1, 2, 3), "name" to "Robith Ritz"), ""))

        }
    }
}
fun main() {
    embeddedServer(Netty, 9090, watchPaths = listOf("BlogAppKt"), module = Application::module).start(true)
}