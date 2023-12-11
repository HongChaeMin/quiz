package site.hannahlog.quiz.domain.quiz.repository

import org.springframework.data.jpa.repository.JpaRepository
import site.hannahlog.quiz.domain.chapter.entity.Chapter
import site.hannahlog.quiz.domain.quiz.entity.Quiz

interface QuizRepository: JpaRepository<Quiz, Long> {

    fun findAllByDeletedDateIsNull(): List<Quiz>

    fun findByIdAndDeletedDateIsNull(id: Long): Quiz?

    fun findByChapterAndDeletedDateIsNull(chapter: Chapter): List<Quiz>

}