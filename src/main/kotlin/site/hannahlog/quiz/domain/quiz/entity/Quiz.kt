package site.hannahlog.quiz.domain.quiz.entity

import jakarta.persistence.*
import site.hannahlog.quiz.domain.chapter.entity.Chapter
import site.hannahlog.quiz.domain.model.BaseEntity
import site.hannahlog.quiz.domain.quiz.dto.request.QuizRequest

@Entity
class Quiz(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    internal val id: Long? = null,

    @ManyToOne
    internal val chapter: Chapter,

    @Column(nullable = false)
    internal var question: String,

    @Column(nullable = false)
    internal var choose: String,

    @Column(nullable = false)
    internal var answer: String
): BaseEntity() {
    fun update(request: QuizRequest) {
        this.question = request.question
        this.choose = request.choose
        this.answer = request.answer
    }

    companion object {
        fun of(chapter: Chapter, request: QuizRequest): Quiz = Quiz(
            chapter = chapter,
            question = request.question,
            choose = request.choose,
            answer = request.answer,
        )
    }

}
