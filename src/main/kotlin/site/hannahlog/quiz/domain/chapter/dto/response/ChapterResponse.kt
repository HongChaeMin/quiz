package site.hannahlog.quiz.domain.chapter.dto.response

import site.hannahlog.quiz.domain.chapter.entity.Chapter
import java.time.LocalDateTime

data class ChapterResponse(
    val id: Long?,
    val title: String,
    val createdDate: LocalDateTime,
    val modifiedDate: LocalDateTime,
)

fun Chapter.toListResponse(): ChapterResponse = ChapterResponse(
    id = this.id,
    title = this.title,
    createdDate = this.createdDate,
    modifiedDate = this.modifiedDate,
)

fun Chapter.toResponse(): ChapterResponse = ChapterResponse(
    id = this.id,
    title = this.title,
    createdDate = this.createdDate,
    modifiedDate = this.modifiedDate,
)
