package site.hannahlog.quiz.domain.chapter.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import site.hannahlog.quiz.domain.chapter.dto.request.ChapterRequest
import site.hannahlog.quiz.domain.chapter.dto.response.ChapterResponse
import site.hannahlog.quiz.domain.chapter.dto.response.toResponse
import site.hannahlog.quiz.domain.chapter.entity.Chapter
import site.hannahlog.quiz.domain.chapter.repository.ChapterRepository
import site.hannahlog.quiz.global.common.status.ErrorStatus
import site.hannahlog.quiz.global.error.LogicException

@Service
class ChapterService(
    private val chapterRepository: ChapterRepository,
) {

    fun findAll(): List<ChapterResponse> = chapterRepository
        .findAllByDeletedDateIsNull()
        .map { it.toResponse() }

    fun findOne(id: Long): ChapterResponse {
        val chapter = chapterRepository
            .findByIdAndDeletedDateIsNull(id)
            ?: throw LogicException(ErrorStatus.NOT_EXIST_CHAPTER)
        return chapter.toResponse()
    }

    @Transactional
    fun save(request: ChapterRequest): ChapterResponse {
        val saveEntity = Chapter.of(request)
        return chapterRepository.save(saveEntity)
            .toResponse()
    }

    @Transactional
    fun update(id: Long, request: ChapterRequest): ChapterResponse {
        val chapter = chapterRepository
            .findByIdAndDeletedDateIsNull(id)
            ?: throw LogicException(ErrorStatus.NOT_EXIST_CHAPTER)
        chapter.update(request)
        return chapter.toResponse()
    }

    @Transactional
    fun delete(id: Long) {
        chapterRepository
            .findByIdAndDeletedDateIsNull(id)
            ?.delete()
    }

}