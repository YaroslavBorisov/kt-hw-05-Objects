package ru.netology

data class Comment(
    val id: Int = 0,
    val fromId: Int = 0,
    val date: Int = 0,
    val text: String = "",
    val donut: Donut? = null,
    val replyToUser: Int = 0,
    val replyToComment: Int = 0,
    val attachments: Array<Attachment>? = null,
    val parentsStack: Array<Int>? = null,
    val thread: Thread? = null
)

data class Donut(val isDon: Boolean = false, val placeHolder: String = "")

data class Thread(
    val count: Int = 0,
    val items: Array<Comment>? = null,
    val canPost: Boolean = false,
    val showReplyButton: Boolean = false,
    val groupsCanPost: Boolean = false
)

data class ReportComment(val ownerId: Int = 0, val commentID: Int = 0, val reason: Int = 0)