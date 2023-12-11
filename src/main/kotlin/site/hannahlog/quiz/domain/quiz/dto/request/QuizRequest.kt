package site.hannahlog.quiz.domain.quiz.dto.request

import jakarta.validation.constraints.NotBlank

data class QuizRequest(
    @NotBlank(message = "문제를 입력해주세요.")
    val question: String,

    @NotBlank(message = "보기를 입력해주세요.")
    val choose: String,

    @NotBlank(message = "정답을 입력해주세요.")
    val answer: String
)