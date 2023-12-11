package site.hannahlog.quiz.domain.chapter.controller

import jakarta.validation.Valid
import org.springframework.data.repository.query.Param
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import site.hannahlog.quiz.domain.chapter.dto.request.ChapterRequest
import site.hannahlog.quiz.domain.chapter.dto.response.ChapterResponse
import site.hannahlog.quiz.domain.chapter.service.ChapterService
import site.hannahlog.quiz.global.common.response.ApiResponse.Success
import site.hannahlog.quiz.global.common.status.SuccessStatus

@RestController
@RequestMapping("/chapters")
class ChapterController(
    private val chapterService: ChapterService,
) {

    @GetMapping
    fun getChapters(): Success<List<ChapterResponse>> {
        val result = chapterService.findAll()
        return Success(result, SuccessStatus.OK)
    }

    @GetMapping("/{id}")
    fun getChapter(@PathVariable id: Long): Success<ChapterResponse> {
        val result = chapterService.findOne(id)
        return Success(result, SuccessStatus.OK)
    }

    @PostMapping
    fun saveChapter(@Valid @RequestBody request: ChapterRequest): Success<ChapterResponse> {
        val result = chapterService.save(request)
        return Success(result, SuccessStatus.CREATED)
    }

    @PatchMapping("/{id}")
    fun updateChapter(@PathVariable id: Long, @Valid @RequestBody request: ChapterRequest): Success<ChapterResponse> {
        val result = chapterService.update(id, request)
        return Success(result, SuccessStatus.UPDATED)
    }

    @DeleteMapping("/{id}")
    fun deleteChapter(@PathVariable id: Long): Success<String> {
        chapterService.delete(id)
        return Success(null, SuccessStatus.DELETED)
    }

}