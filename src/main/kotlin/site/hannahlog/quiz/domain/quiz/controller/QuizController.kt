package site.hannahlog.quiz.domain.quiz.controller

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import site.hannahlog.quiz.domain.quiz.dto.request.QuizRequest
import site.hannahlog.quiz.domain.quiz.dto.response.QuizResponse
import site.hannahlog.quiz.domain.quiz.service.QuizService
import site.hannahlog.quiz.global.common.response.ApiResponse.Success
import site.hannahlog.quiz.global.common.status.SuccessStatus

@RestController
class QuizController(
    private val quizService: QuizService,
) {

    @GetMapping("/quizzes")
    fun getQuizzes(): Success<List<QuizResponse>> {
        val result = quizService.findAll()
        return Success(result, SuccessStatus.OK)
    }

    @GetMapping("/quizzes/{id}")
    fun getQuiz(@PathVariable id: Long): Success<QuizResponse> {
        val result = quizService.findOne(id)
        return Success(result, SuccessStatus.OK)
    }

    @GetMapping("/chapters/{chapterId}/quizzes")
    fun getQuizzesByChapterId(@PathVariable chapterId: Long): Success<List<QuizResponse>> {
        val result = quizService.findAllByChapterId(chapterId)
        return Success(result, SuccessStatus.OK)
    }

    @PostMapping("/chapters/{chapterId}/quizzes")
    fun saveQuiz(
        @PathVariable chapterId: Long,
        @Valid @RequestBody request: QuizRequest
    ): Success<QuizResponse> {
        val result = quizService.save(chapterId, request)
        return Success(result, SuccessStatus.CREATED)
    }

    @PatchMapping("/quizzes/{id}")
    fun updateQuiz(
        @PathVariable id: Long,
        @Valid @RequestBody request: QuizRequest
    ): Success<QuizResponse> {
        val result = quizService.update(id, request)
        return Success(result, SuccessStatus.UPDATED)
    }

    @DeleteMapping("/quizzes/{id}")
    fun deleteQuiz(@PathVariable id: Long): Success<String> {
        quizService.delete(id)
        return Success(null, SuccessStatus.DELETED)
    }

}