package site.hannahlog.quiz

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@EnableJpaAuditing
@SpringBootApplication
class QuizApplication

fun main(args: Array<String>) {
    runApplication<QuizApplication>(*args)
}

@RestController
class PingController {
    @GetMapping("/ping")
    fun pingPong(): String = "pong!"
}
