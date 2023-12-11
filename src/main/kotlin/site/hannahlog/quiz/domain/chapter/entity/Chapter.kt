package site.hannahlog.quiz.domain.chapter.entity

import jakarta.persistence.*
import site.hannahlog.quiz.domain.chapter.dto.request.ChapterRequest
import site.hannahlog.quiz.domain.model.BaseEntity

@Entity
class Chapter(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    internal val id: Long? = null,

    @Column(nullable = false)
    internal var title: String
): BaseEntity() {
    fun update(request: ChapterRequest) {
        this.title = request.title
    }

    companion object {
        fun of(request: ChapterRequest): Chapter = Chapter(
            title = request.title,
        )
    }
}
