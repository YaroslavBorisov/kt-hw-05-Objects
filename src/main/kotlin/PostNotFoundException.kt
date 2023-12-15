package ru.netology

class PostNotFoundException(message: String) : RuntimeException(message)
class CommentNotFoundException(message: String) : RuntimeException(message)
class InvalidReportCommentReason(message: String) : RuntimeException(message)