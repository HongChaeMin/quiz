package site.hannahlog.quiz.domain.quiz.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import site.hannahlog.quiz.domain.chapter.repository.ChapterRepository
import site.hannahlog.quiz.domain.quiz.dto.request.QuizRequest
import site.hannahlog.quiz.domain.quiz.dto.response.QuizResponse
import site.hannahlog.quiz.domain.quiz.dto.response.toResponse
import site.hannahlog.quiz.domain.quiz.entity.Quiz
import site.hannahlog.quiz.domain.quiz.repository.QuizRepository
import site.hannahlog.quiz.global.common.status.ErrorStatus
import site.hannahlog.quiz.global.error.LogicException

@Service
class QuizService(
    private val quizRepository: QuizRepository,
    private val chapterRepository: ChapterRepository,
) {

    fun findAll(): List<QuizResponse> = quizRepository
        .findAllByDeletedDateIsNull()
        .map { it.toResponse() }
        .shuffled()

    fun findOne(id: Long): QuizResponse {
        val quiz = quizRepository
            .findByIdAndDeletedDateIsNull(id)
            ?: throw LogicException(ErrorStatus.NOT_EXIST_QUIZ)
        return quiz.toResponse()
    }

    fun findAllByChapterId(chapterId: Long): List<QuizResponse> {
        val chapter = chapterRepository
            .findByIdAndDeletedDateIsNull(chapterId)
            ?: throw LogicException(ErrorStatus.NOT_EXIST_CHAPTER)
        return quizRepository
            .findByChapterAndDeletedDateIsNull(chapter)
            .map { it.toResponse() }
    }

    @Transactional
    fun save(chapterId: Long, request: QuizRequest): QuizResponse {
        val chapter = chapterRepository
            .findByIdAndDeletedDateIsNull(chapterId)
            ?: throw LogicException(ErrorStatus.NOT_EXIST_CHAPTER)
        val saveEntity = Quiz.of(chapter, request)
        return quizRepository.save(saveEntity)
            .toResponse()
    }

    @Transactional
    fun update(id: Long, request: QuizRequest): QuizResponse {
        val quiz = quizRepository
            .findByIdAndDeletedDateIsNull(id)
            ?: throw LogicException(ErrorStatus.NOT_EXIST_QUIZ)
        quiz.update(request)
        return quiz.toResponse()
    }

    @Transactional
    fun delete(id: Long) {
        quizRepository
            .findByIdAndDeletedDateIsNull(id)
            ?.delete()
    }

}