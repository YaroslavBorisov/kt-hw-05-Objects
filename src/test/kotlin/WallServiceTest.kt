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
    fun updateExistingFalseTrue() {
        val post = Post()
        WallService.add(post)

        val post2 = post.copy(2)
        assertFalse(WallService.update(post2))
    }

}