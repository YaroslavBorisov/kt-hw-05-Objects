package ru.netology

object WallService {
    private var posts = emptyArray<Post>()
    private var counter = 0

    private var comments = emptyArray<Comment>()
    private var commentCounter = 0

    private var reportComments = emptyArray<ReportComment>()
    private var reportCommentCounter = 0

    fun createComment(postId: Int, comment: Comment): Comment {
        var postFound = false
        for (post in posts) {
            if (post.id == postId) {
                postFound = true
                break
            }
        }

        if (!postFound) {
            throw PostNotFoundException("Post $postId not found")
        }

        comments += comment.copy(id = ++commentCounter)
        return comments.last()

    }

    fun add(post: Post): Post {
        posts += post.copy(id = ++counter)
        return posts.last()
    }


    fun update(post: Post): Boolean {
        for ((index, value) in posts.withIndex()) {
            if (value.id == post.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }

    fun createReportComment(commentId: Int, reason: Int, reportComment: ReportComment): ReportComment {
        var commentFound = false
        for (comment in comments) {
            if (comment.id == commentId) {
                commentFound = true
                break
            }
        }

        if (!commentFound) {
            throw CommentNotFoundException("Comment $commentId not found")
        }

        if ((reason < 0 || reason > 6) && reason != 8) {
            throw InvalidReportCommentReason("Invalid reason, should be 0..6 or 8")
        }

        reportComments += reportComment.copy()
        return reportComments.last()
    }

    fun clear() {
        posts = emptyArray()
        counter = 0

        comments = emptyArray()
        commentCounter = 0

        reportComments = emptyArray()
        reportCommentCounter = 0
    }
}