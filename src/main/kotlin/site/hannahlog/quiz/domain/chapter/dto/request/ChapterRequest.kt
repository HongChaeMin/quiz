package site.hannahlog.quiz.domain.chapter.dto.request

import jakarta.validation.constraints.NotBlank

data class ChapterRequest(
    @NotBlank(message = "제목을 입력해주세요.")
    val title: String,
)
