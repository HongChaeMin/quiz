package site.hannahlog.quiz.domain.quiz.dto.response

import site.hannahlog.quiz.domain.quiz.entity.Quiz
import java.time.LocalDateTime

data class QuizResponse(
    val id: Long?,
    val question: String,
    val choose: String,
    val answer: String,
    val createdDate: LocalDateTime,
    val modifiedDate: LocalDateTime,
)

fun Quiz.toResponse(): QuizResponse = QuizResponse(
    id = this.id,
    question = this.question,
    choose = this.choose,
    answer = this.answer,
    createdDate = this.createdDate,
    modifiedDate = this.modifiedDate,
)
