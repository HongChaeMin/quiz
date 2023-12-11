package site.hannahlog.quiz.domain.quiz.entity

import jakarta.persistence.*
import site.hannahlog.quiz.domain.chapter.entity.Chapter

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
)
