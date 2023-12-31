package site.hannahlog.quiz.global.common.status

import org.springframework.http.HttpStatus

enum class ErrorStatus(
    private val code: HttpStatus,
    private val message: String
): ResponseStatus {
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버에서 문제가 발생했습니다. 나중에 다시 시도해주세요."),

    NOT_EXIST_CHAPTER(HttpStatus.BAD_REQUEST, "존재하지 않는 챕터입니다."),
    NOT_EXIST_QUIZ(HttpStatus.BAD_REQUEST, "존재하지 않는 퀴즈입니다."),

    NOT_URI(HttpStatus.BAD_GATEWAY, "잘못된 URI 요청입니다."),
    NOT_BODY(HttpStatus.BAD_REQUEST, "잘못된 Body 요청입니다.");

    override fun getStatus(): HttpStatus = code
    override fun getMessage(): String = message
}
