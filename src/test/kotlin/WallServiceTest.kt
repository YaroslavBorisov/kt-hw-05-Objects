package ru.netology

import org.junit.Assert.*
import org.junit.*

class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        var post = Post()
        post = WallService.add(post)
        assertEquals(1, post.id)
    }


    @Test
    fun updateExistingTrue() {
        val post = Post()
        WallService.add(post)

        val post2 = post.copy(1)
        assertTrue(WallService.update(post2))

    }

    @Test
    fun updateExistingFalse() {
        val post = Post()
        WallService.add(post)

        val post2 = post.copy(2)
        assertFalse(WallService.update(post2))
    }

    @Test(expected = PostNotFoundException::class)
    fun addCommentUnsuccessful() {
        val post = Post()
        WallService.add(post)

        val comment = Comment()
        WallService.createComment(2, comment)
    }

    @Test
    fun addCommentSuccessful() {
        val post = Post()
        WallService.add(post)

        val comment = Comment(text = "My comment")
        val commentAdded = WallService.createComment(1, comment)
        assertEquals("My comment", commentAdded.text)
    }

    @Test(expected = InvalidReportCommentReason::class)
    fun addReportCommentInvalidReason() {
        val post = Post()
        WallService.add(post)

        val comment = Comment()
        WallService.createComment(1, comment)

        val reportComment = ReportComment(0, 1, 10)
        WallService.createReportComment(1, 10, reportComment)
    }

    @Test(expected = CommentNotFoundException::class)
    fun addReportCommentCommentNotFound() {
        val post = Post()
        WallService.add(post)

        val comment = Comment()
        WallService.createComment(1, comment)

        val reportComment = ReportComment(0, 1, 10)
        WallService.createReportComment(2, 1, reportComment)
    }

    @Test
    fun addReportCommentSuccessful() {
        val post = Post()
        WallService.add(post)

        val comment = Comment()
        WallService.createComment(1, comment)

        val reportComment = ReportComment(0, 1, 1)
        val reportCommentAdded = WallService.createReportComment(1, 1, reportComment)
        assertEquals(1, reportCommentAdded.reason)
    }


}