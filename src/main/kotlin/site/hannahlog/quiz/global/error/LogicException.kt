package site.hannahlog.quiz.global.error

import site.hannahlog.quiz.global.common.status.ErrorStatus

class LogicException(
    val errorStatus: ErrorStatus
) : RuntimeException(errorStatus.getMessage())
