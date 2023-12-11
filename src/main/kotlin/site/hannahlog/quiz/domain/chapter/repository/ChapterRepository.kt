package site.hannahlog.quiz.domain.chapter.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import site.hannahlog.quiz.domain.chapter.entity.Chapter

@Repository
interface ChapterRepository: JpaRepository<Chapter, Long> {

    fun findByIdAndDeletedDateIsNull(id: Long): Chapter?

    fun findAllByDeletedDateIsNull(): List<Chapter>

}
